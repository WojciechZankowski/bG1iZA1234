package pl.lodomaniak.icecream;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.icecream.entity.IceCreamShopEntity;

import java.util.List;

public interface IceCreamShopRepository extends JpaRepository<IceCreamShopEntity, Long> {

    List<IceCreamShopEntity> findAllByCompanyIdIn(List<Long> companyId);

}
