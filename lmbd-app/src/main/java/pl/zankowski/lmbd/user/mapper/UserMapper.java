package pl.zankowski.lmbd.user.mapper;

import org.springframework.stereotype.Component;
import pl.zankowski.lmbd.user.api.AccountTO;
import pl.zankowski.lmbd.user.api.AccountTOBuilder;
import pl.zankowski.lmbd.user.entity.AuthorityEntity;
import pl.zankowski.lmbd.user.entity.UserEntity;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Component
public class UserMapper {

    public AccountTO map(final UserEntity user) {
        return new AccountTOBuilder()
                .withLogin(user.getLogin())
                .withPassword(user.getPassword())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withEmail(user.getEmail())
                .withActivated(user.isActivated())
                .withLangKey(user.getLangKey())
                .withImageUrl(user.getImageUrl())
                .withCreatedBy(user.getCreatedBy())
                .withCreatedDate(user.getCreatedDate())
                .withLastModifiedBy(user.getLastModifiedBy())
                .withLastModifiedDate(user.getLastModifiedDate())
                .withAuthorities(map(user.getAuthorities()))
                .build();
    }

    private Set<String> map(final Set<AuthorityEntity> authorityEntities) {
        return authorityEntities.stream().map(AuthorityEntity::getName).collect(toSet());
    }

}
