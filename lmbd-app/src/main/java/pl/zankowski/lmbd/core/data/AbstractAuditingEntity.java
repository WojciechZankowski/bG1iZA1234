package pl.zankowski.lmbd.core.data;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@Audited
@EntityListeners(AuditingEntityListener.class)
public class AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = -5387589497071709371L;

    @CreatedBy
    @Column(name = "created_by", nullable = false, length = 50, updatable = false)
    private final String createdBy;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private final Instant createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 50)
    private final String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private final Instant lastModifiedDate;

    public AbstractAuditingEntity(
            final String createdBy,
            final Instant createdDate,
            final String lastModifiedBy,
            final Instant lastModifiedDate) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }
}
