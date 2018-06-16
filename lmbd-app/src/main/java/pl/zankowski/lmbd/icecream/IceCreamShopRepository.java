package pl.zankowski.lmbd.icecream;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zankowski.lmbd.icecream.entity.IceCreamShopEntity;

public interface IceCreamShopRepository extends JpaRepository<IceCreamShopEntity, Long> {
}
