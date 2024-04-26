package org.glabs.accessibility.services;

import org.glabs.accessibility.domain.Users;
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

    public Users getUserBy(UUID id) {
        return repository.findUserBy(id);
    }

    public Users getUserBy(String username) {
        return repository.findUserBy(username);
    }

    public Users createUser(Users user) {
        if (getUserBy(user.getUsername()) != null) {
            return null;
        }
        return repository.save(user);
    }
}
