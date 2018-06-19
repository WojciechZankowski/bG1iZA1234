package pl.zankowski.lmbd.icecream;

import org.springframework.stereotype.Service;
import pl.zankowski.lmbd.icecream.api.FlavorTO;
import pl.zankowski.lmbd.icecream.mapper.FlavorMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DefaultFlavorService implements FlavorService {

    private final FlavorActivityRepository flavorActivityRepository;
    private final FlavorRepository flavorRepository;
    private final FlavorMapper flavorMapper;

    public DefaultFlavorService(final FlavorActivityRepository flavorActivityRepository,
            final FlavorRepository flavorRepository, final FlavorMapper flavorMapper) {
        this.flavorActivityRepository = flavorActivityRepository;
        this.flavorRepository = flavorRepository;
        this.flavorMapper = flavorMapper;
    }

    @Override
    public void addFlavor(final FlavorTO flavor) {
        flavorRepository.save(flavorMapper.map(flavor));
    }

    @Override
    public List<FlavorTO> getAvailableFlavors(final long iceCreamShopId) {
        return null;
    }

    @Override
    public List<FlavorTO> getFlavors(final long companyId) {
        return flavorRepository.findAllByCompanyId(companyId).stream()
                .map(flavorMapper::map)
                .collect(toList());
    }
}
