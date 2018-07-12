package pl.lodomaniak.icecream;

import org.springframework.security.core.userdetails.User;
import pl.lodomaniak.icecream.api.CompanyTO;

import java.util.List;

public interface CompanyService {

    List<CompanyTO> getCompanies(final User user);

}
