package pl.lodomaniak.icecream;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.icecream.entity.FlavorEntity;

import java.util.List;

public interface FlavorRepository extends JpaRepository<FlavorEntity, Long> {

    List<FlavorEntity> findAllByCompanyId(List<Long> companyId);

}
