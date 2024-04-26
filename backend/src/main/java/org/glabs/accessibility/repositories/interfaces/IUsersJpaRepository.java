package org.glabs.accessibility.repositories.interfaces;

import org.glabs.accessibility.repositories.data.UsersDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUsersJpaRepository extends JpaRepository<UsersDB, UUID> {
    UsersDB findByUsername(String username);
}
