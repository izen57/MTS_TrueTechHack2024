package org.glabs.accessibility.repositories.interfaces;

import org.glabs.accessibility.repositories.data.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUsersJpaRepository extends JpaRepository<UserDB, UUID> {
    UserDB findByUsername(String username);
}
