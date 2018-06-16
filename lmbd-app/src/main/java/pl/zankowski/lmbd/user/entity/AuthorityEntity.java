package pl.zankowski.lmbd.user.entity;

import com.google.common.base.Objects;
import org.hibernate.annotations.Immutable;
import pl.zankowski.lmbd.core.IEntity;
import pl.zankowski.lmbd.user.AuthorityRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "lmbd_authority")
@Immutable
public class AuthorityEntity implements IEntity {

    private static final long serialVersionUID = 7484714419503632131L;

    @NotNull
    @Size(min = 0, max = 50)
    @Id
    @Column(length = 50)
    private String name;

    public AuthorityEntity(final String name) {
        this.name = name;
    }

    private AuthorityEntity() {}

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AuthorityEntity authorityEntity = (AuthorityEntity) o;
        return Objects.equal(name, authorityEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "AuthorityEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
