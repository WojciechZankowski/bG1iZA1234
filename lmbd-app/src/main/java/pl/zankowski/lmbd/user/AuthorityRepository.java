package pl.zankowski.lmbd.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zankowski.lmbd.user.entity.AuthorityEntity;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String> {
}
