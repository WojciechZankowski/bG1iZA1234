package pl.lodomaniak.icecream;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.lodomaniak.icecream.api.CompanyTO;
import pl.lodomaniak.icecream.api.FlavorTO;
import pl.lodomaniak.icecream.mapper.FlavorMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DefaultFlavorService implements FlavorService {

    private final FlavorActivityRepository flavorActivityRepository;
    private final FlavorRepository flavorRepository;
    private final FlavorMapper flavorMapper;
    private final CompanyService companyService;

    public DefaultFlavorService(final FlavorActivityRepository flavorActivityRepository,
            final FlavorRepository flavorRepository, final FlavorMapper flavorMapper,
            final CompanyService companyService) {
        this.flavorActivityRepository = flavorActivityRepository;
        this.flavorRepository = flavorRepository;
        this.flavorMapper = flavorMapper;
        this.companyService = companyService;
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
    public List<FlavorTO> getFlavors(final User user) {
        final List<Long> companiesId = companyService.getCompanies(user).stream()
                .map(CompanyTO::getId)
                .collect(toList());
        return flavorRepository.findAllByCompanyId(companiesId).stream()
                .map(flavorMapper::map)
                .collect(toList());
    }
}
