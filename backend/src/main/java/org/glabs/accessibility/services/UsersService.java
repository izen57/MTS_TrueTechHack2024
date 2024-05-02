package org.glabs.accessibility.services;

import org.glabs.accessibility.domain.UserIn;
import org.glabs.accessibility.domain.UserOut;
import org.glabs.accessibility.repositories.implementations.UsersRepository;
import org.glabs.accessibility.repositories.interfaces.IUsersJpaRepository;
import org.glabs.accessibility.repositories.interfaces.IUsersRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersService {
    private final IUsersRepository repository;

    public UsersService(IUsersJpaRepository repository) {
        this.repository = new UsersRepository(repository);
    }

    public UserOut getUserBy(UUID id) {
        return repository.findUserBy(id);
    }

    public UserOut getUserBy(String username) {
        return repository.findUserBy(username);
    }

    public UserOut createUser(UserIn userIn) {
        if (getUserBy(userIn.getUsername()) != null) {
            return null;
        }
        return repository.save(userIn);
    }
}
