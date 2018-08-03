package pl.lodomaniak.icecream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.lodomaniak.follow.api.FollowType;
import pl.lodomaniak.follow.spi.FollowExternalService;
import pl.lodomaniak.icecream.api.CompanyTO;
import pl.lodomaniak.icecream.api.FlavorActivityTO;
import pl.lodomaniak.icecream.api.FlavorTO;
import pl.lodomaniak.icecream.api.IceCreamShopTO;
import pl.lodomaniak.icecream.entity.FlavorEntity;
import pl.lodomaniak.icecream.mapper.FlavorActivityMapper;
import pl.lodomaniak.icecream.mapper.FlavorMapper;
import pl.lodomaniak.rating.api.RatingTO;
import pl.lodomaniak.rating.api.RatingType;
import pl.lodomaniak.rating.spi.RatingExternalService;
import pl.lodomaniak.user.api.AccountTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;
import pl.lodomaniak.user.spi.UserService;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

@Service
public class DefaultFlavorService implements FlavorService {

    private final FlavorActivityRepository flavorActivityRepository;
    private final FlavorRepository flavorRepository;
    private final FlavorMapper flavorMapper;
    private final FlavorActivityMapper flavorActivityMapper;
    private final CompanyService companyService;
    private final IceCreamShopService iceCreamShopService;
    private final RatingExternalService ratingService;
    private final FollowExternalService followService;
    private final UserService userService;

    @Autowired
    public DefaultFlavorService(final FlavorActivityRepository flavorActivityRepository,
            final FlavorRepository flavorRepository, final FlavorMapper flavorMapper,
            final FlavorActivityMapper flavorActivityMapper, final CompanyService companyService,
            final IceCreamShopService iceCreamShopService, final RatingExternalService ratingService,
            final FollowExternalService followService, final UserService userService) {
        this.flavorActivityRepository = flavorActivityRepository;
        this.flavorRepository = flavorRepository;
        this.flavorMapper = flavorMapper;
        this.flavorActivityMapper = flavorActivityMapper;
        this.companyService = companyService;
        this.iceCreamShopService = iceCreamShopService;
        this.ratingService = ratingService;
        this.followService = followService;
        this.userService = userService;
    }

    @Override
    public void addFlavor(final FlavorTO flavor) {
        flavorRepository.save(flavorMapper.map(flavor));
    }

    @Override
    public void updateFlavor(final FlavorTO flavor) {
        flavorRepository.save(flavorMapper.map(flavor));
    }

    @Override
    public Page<FlavorTO> getFlavors(final User user, final Pageable pageable) throws UserNotFoundException {
        final List<Long> companiesId = companyService.getCompanies(user).stream()
                .map(CompanyTO::getId)
                .collect(toList());
        return flavorRepository.findAllByCompanyIdIn(companiesId, pageable)
                .map(flavorMapper::map);
    }

    @Override
    public Page<FlavorTO> getFlavors(final String name, final String city, final Pageable pageable) {
        final List<Long> companyIds = iceCreamShopService.getIceCreamShops("", city, PageRequest.of(0, 2000))
                .getContent().stream()
                .map((shop) -> shop.getCompany().getId())
                .collect(toList());

        final String flavorName = name == null ? "" : name;

        return flavorRepository.findAllByCompanyIdInAndNameContainingOrTagsContaining(companyIds, flavorName, flavorName, pageable)
                .map(flavorMapper::map);
    }

    @Override
    public List<FlavorTO> getTopFlavors(final String city) {
        final List<Long> companyIds = iceCreamShopService.getIceCreamShops("", city, PageRequest.of(0, 2000))
                .getContent().stream()
                .map((shop) -> shop.getCompany().getId())
                .collect(toList());

        final List<Long> flavorIds = flavorRepository.findAllByCompanyIdIn(companyIds).stream()
                .map(FlavorEntity::getId)
                .collect(toList());

        final List<Long> topFlavorIds = ratingService.getMostPopular(RatingType.FLAVOR, flavorIds).stream()
                .map(RatingTO::getRatedObjectId)
                .collect(toList());

        return flavorRepository.findAllById(topFlavorIds).stream()
                .map(flavorMapper::map)
                .collect(toList());
    }

    @Override
    public void scheduleFlavor(final FlavorActivityTO flavorActivity) {
        flavorActivityRepository.save(flavorActivityMapper.map(flavorActivity));
    }

    @Override
    public void updateFlavorSchedule(final FlavorActivityTO flavorActivity) {
        flavorActivityRepository.save(flavorActivityMapper.map(flavorActivity));
    }

    @Override
    public Page<FlavorActivityTO> getPlannedFlavors(final Pageable pageable, final User user)
            throws UserNotFoundException {
        final List<Long> iceCreamShopsId = iceCreamShopService.getIceCreamShops(user).stream()
                .map(IceCreamShopTO::getId)
                .collect(toList());

        return flavorActivityRepository.findAllByIceCreamShopIdInAndDateGreaterThanEqual(iceCreamShopsId, LocalDate.now(), pageable)
                .map(flavorActivityMapper::map);
    }

    @Override
    public List<FlavorActivityTO> getAvailableFlavors(final String city, final Long flavorId, final Long iceCreamShopId,
            final LocalDate date) {
        if (flavorId != null) {
            return getSchedulesForFlavor(flavorId, date);
        }
        if (iceCreamShopId != null) {
            return getSchedulesForIceCreamShop(iceCreamShopId, date);
        }
        return flavorActivityRepository.findAllByIceCreamShopAddressCityAndDate(city, date).stream()
                .map(flavorActivityMapper::map)
                .collect(toList());
    }

    private List<FlavorActivityTO> getSchedulesForFlavor(final Long flavorId, final LocalDate date) {
        return flavorActivityRepository.findAllByFlavorIdAndDate(flavorId, date).stream()
                .map(flavorActivityMapper::map)
                .collect(toList());
    }

    private List<FlavorActivityTO> getSchedulesForIceCreamShop(final Long iceCreamShopId, final LocalDate date) {
        return flavorActivityRepository.findAllByIceCreamShopIdAndDate(iceCreamShopId, date).stream()
                .map(flavorActivityMapper::map)
                .collect(toList());
    }

    @Override
    public List<FlavorTO> getMineFollowedFlavors(final User user) throws UserNotFoundException {
        final AccountTO account = userService.loadUserByUsername(user.getUsername());

        final List<Long> followedObjects = followService.getFollowedObjects(account.getId(), FollowType.FLAVOR);

        return flavorRepository.findAllById(followedObjects).stream()
                .map(flavorMapper::map)
                .collect(toList());
    }

    @Override
    public List<FlavorActivityTO> getMineFlavorsScheduledForToday(final User user) throws UserNotFoundException {
        final AccountTO account = userService.loadUserByUsername(user.getUsername());

        final List<Long> followedObjects = followService.getFollowedObjects(account.getId(), FollowType.FLAVOR);

        return flavorActivityRepository.findAllByFlavorIdInAndDate(followedObjects, LocalDate.now()).stream()
                .map(flavorActivityMapper::map)
                .collect(toList());
    }
}
