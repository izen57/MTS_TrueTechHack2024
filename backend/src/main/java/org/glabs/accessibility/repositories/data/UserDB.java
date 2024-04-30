package org.glabs.accessibility.repositories.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "_user")
public class UserDB {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", unique = true)
    private String username;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<CommentDB> comments;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_preference_id")
    private UserPreferenceDB preferenceDB;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_credentials_id")
    private UserCredentialsDB credentialsDB;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? //
                ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? //
                ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        UserCredentialsDB that = (UserCredentialsDB) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()//
                .getPersistentClass().hashCode() : getClass().hashCode();
    }
}
