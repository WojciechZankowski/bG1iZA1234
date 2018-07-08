package pl.lodomaniak.user.entity;

import com.google.common.base.Objects;
import pl.lodomaniak.core.Constants;
import pl.lodomaniak.core.entity.AbstractAuditingEntity;
import pl.lodomaniak.core.entity.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "lodomaniak_user")
public class UserEntity extends AbstractAuditingEntity implements IEntity {

    private static final long serialVersionUID = -2666366358188622396L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 100)
    @Column(length = 100, unique = true, nullable = false)
    private String login;

    @NotNull
    @Size(min = 60, max = 60)
    @Column(name = "password_hash", length = 60)
    private String password;

    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Email
    @Size(max = 50)
    @Column(length = 100, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private boolean activated;

    @Size(min = 2, max = 5)
    @Column(name = "lang_key", length = 5)
    private String langKey;

    @Size(max = 256)
    @Column(name = "image_url", length = 256)
    private String imageUrl;

    @Size(max = 20)
    @Column(name = "activation_key", length = 20)
    private String activationKey;

    @Size(max = 20)
    @Column(name = "reset_key", length = 20)
    private String resetKey;

    @Column(name = "reset_date")
    private Instant resetDate;

    @ManyToMany
    @JoinTable(name = "lodomaniak_user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    private Set<AuthorityEntity> authorities;

    public UserEntity() {
    }

    public UserEntity(
            final Long id,
            final String createdBy,
            final Instant createdDate,
            final String lastModifiedBy,
            final Instant lastModifiedDate,
            final String login,
            final String password,
            final String firstName,
            final String lastName,
            final String email,
            final boolean activated,
            final String langKey,
            final String imageUrl,
            final String activationKey,
            final String resetKey,
            final Instant resetDate,
            final Set<AuthorityEntity> authorities) {
        super(createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
        this.login = login.toLowerCase();
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.langKey = langKey;
        this.imageUrl = imageUrl;
        this.activationKey = activationKey;
        this.resetKey = resetKey;
        this.resetDate = resetDate;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActivated() {
        return activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public String getResetKey() {
        return resetKey;
    }

    public Instant getResetDate() {
        return resetDate;
    }

    public Set<AuthorityEntity> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserEntity userEntity = (UserEntity) o;
        return activated == userEntity.activated &&
                Objects.equal(id, userEntity.id) &&
                Objects.equal(login, userEntity.login) &&
                Objects.equal(password, userEntity.password) &&
                Objects.equal(firstName, userEntity.firstName) &&
                Objects.equal(lastName, userEntity.lastName) &&
                Objects.equal(email, userEntity.email) &&
                Objects.equal(langKey, userEntity.langKey) &&
                Objects.equal(imageUrl, userEntity.imageUrl) &&
                Objects.equal(activationKey, userEntity.activationKey) &&
                Objects.equal(resetKey, userEntity.resetKey) &&
                Objects.equal(resetDate, userEntity.resetDate) &&
                Objects.equal(authorities, userEntity.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, login, password, firstName, lastName, email, activated, langKey, imageUrl,
                activationKey, resetKey, resetDate, authorities);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", activated=" + activated +
                ", langKey='" + langKey + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", activationKey='" + activationKey + '\'' +
                ", resetKey='" + resetKey + '\'' +
                ", resetDate=" + resetDate +
                ", authorities=" + authorities +
                "} " + super.toString();
    }
}
