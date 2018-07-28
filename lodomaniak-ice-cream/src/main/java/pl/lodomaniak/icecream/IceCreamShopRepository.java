package pl.lodomaniak.icecream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.icecream.entity.IceCreamShopEntity;

import java.util.List;

public interface IceCreamShopRepository extends JpaRepository<IceCreamShopEntity, Long> {

    List<IceCreamShopEntity> findAllByCompanyIdIn(List<Long> companyId);

    Page<IceCreamShopEntity> findByAddressCity(String city, Pageable pageable);

    Page<IceCreamShopEntity> findByAddressCityAndCompanyNameContaining(String city, String company, Pageable pageable);

}
