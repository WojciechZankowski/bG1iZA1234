package pl.lodomaniak.icecream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.lodomaniak.icecream.api.CompanyTO;
import pl.lodomaniak.icecream.mapper.CompanyMapper;
import pl.lodomaniak.user.api.AccountTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;
import pl.lodomaniak.user.spi.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCompanyService implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final UserService userService;

    @Autowired
    public DefaultCompanyService(final CompanyRepository companyRepository, final CompanyMapper companyMapper,
            final UserService userService) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
        this.userService = userService;
    }

    @Override
    public List<CompanyTO> getCompanies(final User user) throws UserNotFoundException {
        final AccountTO account = userService.loadUserByUsername(user.getUsername());
        return companyRepository.findAllByUserId(account.getId()).stream()
                .map(companyMapper::map)
                .collect(Collectors.toList());
    }

}
