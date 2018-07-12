package pl.lodomaniak.icecream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.lodomaniak.icecream.api.CompanyTO;
import pl.lodomaniak.icecream.mapper.CompanyMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCompanyService implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Autowired
    public DefaultCompanyService(final CompanyRepository companyRepository, final CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public List<CompanyTO> getCompanies(final User user) {
        return companyRepository.findAll().stream()
                .map(companyMapper::map)
                .collect(Collectors.toList());
    }

}
