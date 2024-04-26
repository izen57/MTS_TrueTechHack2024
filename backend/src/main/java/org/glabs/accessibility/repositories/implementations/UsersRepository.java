package org.glabs.accessibility.repositories.implementations;

import org.glabs.accessibility.domain.Users;
import org.glabs.accessibility.repositories.data.UsersDB;
import org.glabs.accessibility.repositories.interfaces.IUsersJpaRepository;
import org.glabs.accessibility.repositories.interfaces.IUsersRepository;
import org.glabs.accessibility.repositories.mappers.IUsersMapper;

import java.util.UUID;

public class UsersRepository implements IUsersRepository {
    private final IUsersJpaRepository repository;

    public UsersRepository(IUsersJpaRepository repository) {
        this.repository = repository;
    }

    public Users findUserBy(UUID id) {
        UsersDB userDB = repository.findById(id).orElse(null);
        Users result = null;
        if (userDB != null) {
            result = IUsersMapper.INSTANCE.usersDBToUsers(userDB);
        }
        return result;
    }

    public Users findUserBy(String username) {
        UsersDB userDB = repository.findByUsername(username);
        Users result = null;
        if (userDB != null) {
            result = IUsersMapper.INSTANCE.usersDBToUsers(userDB);
        }
        return result;
    }

    public Users save(Users user) {
        IUsersMapper mapper = IUsersMapper.INSTANCE;
        UsersDB userDB = repository.save(mapper.usersToUsersDB(user));
        return mapper.usersDBToUsers(userDB);
    }
}
