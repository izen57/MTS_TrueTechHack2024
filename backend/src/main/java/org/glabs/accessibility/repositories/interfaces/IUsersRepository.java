package org.glabs.accessibility.repositories.interfaces;

import org.glabs.accessibility.domain.Users;

import java.util.UUID;


public interface IUsersRepository {
    Users findUserBy(UUID id);

    Users findUserBy(String username);

    Users save(Users user);
}
