package pl.lodomaniak.icecream;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.icecream.entity.OpeningHoursRangeEntity;

public interface OpeningHoursRangeRepository extends JpaRepository<OpeningHoursRangeEntity, Long> {
}
