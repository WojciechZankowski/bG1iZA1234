package pl.lodomaniak.icecream;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.icecream.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

}
