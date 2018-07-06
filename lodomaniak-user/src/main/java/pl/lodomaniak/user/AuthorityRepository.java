package pl.lodomaniak.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.user.entity.AuthorityEntity;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String> {
}
