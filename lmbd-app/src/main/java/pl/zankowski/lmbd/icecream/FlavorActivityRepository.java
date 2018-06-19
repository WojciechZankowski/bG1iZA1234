package pl.zankowski.lmbd.icecream;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zankowski.lmbd.icecream.entity.FlavorActivityEntity;

public interface FlavorActivityRepository extends JpaRepository<FlavorActivityEntity, Long> {
}
