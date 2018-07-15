package pl.lodomaniak.icecream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.icecream.entity.FlavorActivityEntity;

import java.util.List;

public interface FlavorActivityRepository extends JpaRepository<FlavorActivityEntity, Long> {

    Page<FlavorActivityEntity> findAllByIceCreamShopId(List<Long> iceCreamShopId, Pageable pageable);

}
