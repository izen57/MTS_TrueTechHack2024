package org.glabs.accessibility.repositories.interfaces;

import org.glabs.accessibility.domain.UserIn;
import org.glabs.accessibility.domain.UserOut;

import java.util.UUID;


public interface IUsersRepository {
    UserOut findUserBy(UUID id);

    UserOut findUserBy(String username);

    UserOut save(UserIn userIn);
}
