package org.glabs.accessibility.services;

import org.glabs.accessibility.domain.User;
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

    public User getUserBy(UUID id) {
        return repository.findUserBy(id);
    }

    public User getUserBy(String username) {
        return repository.findUserBy(username);
    }

    public User createUser(User user) {
        if (getUserBy(user.getUsername()) != null) {
            return null;
        }
        return repository.save(user);
    }
}
