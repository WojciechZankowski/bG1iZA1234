package pl.lodomaniak.icecream;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.icecream.entity.IceCreamShopEntity;

public interface IceCreamShopRepository extends JpaRepository<IceCreamShopEntity, Long> {
}