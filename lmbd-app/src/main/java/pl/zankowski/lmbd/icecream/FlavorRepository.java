package pl.zankowski.lmbd.icecream;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zankowski.lmbd.icecream.api.FlavorTO;
import pl.zankowski.lmbd.icecream.entity.FlavorEntity;

import java.util.List;

public interface FlavorRepository extends JpaRepository<FlavorEntity, Long> {

    List<FlavorEntity> findAllByCompanyId(long companyId);

}
