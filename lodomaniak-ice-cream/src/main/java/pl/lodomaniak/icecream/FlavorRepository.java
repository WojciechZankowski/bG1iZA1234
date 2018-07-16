package pl.lodomaniak.icecream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.icecream.entity.FlavorEntity;

import java.util.List;

public interface FlavorRepository extends JpaRepository<FlavorEntity, Long> {

    Page<FlavorEntity> findAllByCompanyIdIn(List<Long> companyId, Pageable pageable);

}
