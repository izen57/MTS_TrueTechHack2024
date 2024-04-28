package org.glabs.accessibility.repositories.interfaces;

import org.glabs.accessibility.domain.User;

import java.util.UUID;


public interface IUsersRepository {
    User findUserBy(UUID id);

    User findUserBy(String username);

    User save(User user);
}
