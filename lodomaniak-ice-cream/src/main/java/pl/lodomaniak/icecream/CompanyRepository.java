package pl.lodomaniak.icecream;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.icecream.entity.CompanyEntity;

import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    List<CompanyEntity> findAllByUserId(Long userId);

}
