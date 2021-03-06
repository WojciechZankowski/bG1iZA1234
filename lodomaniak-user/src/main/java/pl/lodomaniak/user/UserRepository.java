package pl.lodomaniak.user;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lodomaniak.user.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findOneByLogin(String login);

    Optional<UserEntity> findOneByEmail(String email);

    Optional<UserEntity> findOneByActivationKey(String activationKey);

    Optional<UserEntity> findOneByResetKey(String resetKey);

    @EntityGraph(attributePaths = "authorities")
    Optional<UserEntity> findOneWithAuthoritiesByLogin(String login);

}
