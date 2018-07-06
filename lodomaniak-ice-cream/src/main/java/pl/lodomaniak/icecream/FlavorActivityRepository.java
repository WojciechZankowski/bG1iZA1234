package pl.lodomaniak.icecream;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.icecream.entity.FlavorActivityEntity;

public interface FlavorActivityRepository extends JpaRepository<FlavorActivityEntity, Long> {
}
