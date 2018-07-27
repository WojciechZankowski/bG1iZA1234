package pl.lodomaniak.icecream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.lodomaniak.icecream.entity.AddressEntity;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query("SELECT DISTINCT a.city FROM AddressEntity a")
    List<String> findDistinctCity();

}
