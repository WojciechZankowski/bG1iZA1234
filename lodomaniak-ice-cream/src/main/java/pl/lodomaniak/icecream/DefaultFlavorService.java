package pl.lodomaniak.icecream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.lodomaniak.icecream.api.CompanyTO;
import pl.lodomaniak.icecream.api.FlavorActivityTO;
import pl.lodomaniak.icecream.api.FlavorTO;
import pl.lodomaniak.icecream.api.IceCreamShopTO;
import pl.lodomaniak.icecream.mapper.FlavorActivityMapper;
import pl.lodomaniak.icecream.mapper.FlavorMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DefaultFlavorService implements FlavorService {

    private final FlavorActivityRepository flavorActivityRepository;
    private final FlavorRepository flavorRepository;
    private final FlavorMapper flavorMapper;
    private final FlavorActivityMapper flavorActivityMapper;
    private final CompanyService companyService;
    private final IceCreamShopService iceCreamShopService;

    @Autowired
    public DefaultFlavorService(final FlavorActivityRepository flavorActivityRepository,
            final FlavorRepository flavorRepository, final FlavorMapper flavorMapper,
            final FlavorActivityMapper flavorActivityMapper, final CompanyService companyService,
            final IceCreamShopService iceCreamShopService) {
        this.flavorActivityRepository = flavorActivityRepository;
        this.flavorRepository = flavorRepository;
        this.flavorMapper = flavorMapper;
        this.flavorActivityMapper = flavorActivityMapper;
        this.companyService = companyService;
        this.iceCreamShopService = iceCreamShopService;
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
    public List<FlavorTO> getAvailableFlavors(final long iceCreamShopId) {
        return null;
    }

    @Override
    public Page<FlavorTO> getFlavors(final User user, final Pageable pageable) {
        final List<Long> companiesId = companyService.getCompanies(user).stream()
                .map(CompanyTO::getId)
                .collect(toList());
        return flavorRepository.findAllByCompanyIdIn(companiesId, pageable)
                .map(flavorMapper::map);
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
    public Page<FlavorActivityTO> getPlannedFlavors(final Pageable pageable, final User user) {
        final List<Long> iceCreamShopsId = iceCreamShopService.getIceCreamShops(user).stream()
                .map(IceCreamShopTO::getId)
                .collect(toList());

        return flavorActivityRepository.findAllByIceCreamShopId(iceCreamShopsId, pageable)
                .map(flavorActivityMapper::map);
    }
}
