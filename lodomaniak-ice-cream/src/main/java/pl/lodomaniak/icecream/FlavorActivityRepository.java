package pl.lodomaniak.icecream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.icecream.entity.FlavorActivityEntity;

import java.time.LocalDate;
import java.util.List;

public interface FlavorActivityRepository extends JpaRepository<FlavorActivityEntity, Long> {

    Page<FlavorActivityEntity> findAllByIceCreamShopIdInAndDateGreaterThanEqual(List<Long> iceCreamShopId,
            LocalDate date, Pageable pageable);

    List<FlavorActivityEntity> findAllByIceCreamShopAddressCityAndDate(String city, LocalDate date);

    List<FlavorActivityEntity> findAllByFlavorIdAndDate(Long flavorId, LocalDate date);

}
