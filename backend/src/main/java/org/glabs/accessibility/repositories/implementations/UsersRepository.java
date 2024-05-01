package org.glabs.accessibility.repositories.implementations;

import org.glabs.accessibility.domain.User;
import org.glabs.accessibility.repositories.data.UserDB;
import org.glabs.accessibility.repositories.interfaces.IUsersJpaRepository;
import org.glabs.accessibility.repositories.interfaces.IUsersRepository;
import org.glabs.accessibility.repositories.mappers.IUsersMapper;

import java.util.UUID;

public class UsersRepository implements IUsersRepository {
    private final IUsersJpaRepository repository;

    public UsersRepository(IUsersJpaRepository repository) {
        this.repository = repository;
    }

    public User findUserBy(UUID id) {
        UserDB userDB = repository.findById(id).orElse(null);
        User result = null;
        if (userDB != null) {
            result = IUsersMapper.INSTANCE.usersDBToUsers(userDB);
        }
        return result;
    }

    public User findUserBy(String username) {
        UserDB userDB = repository.findByUsername(username);
        User result = null;
        if (userDB != null) {
            result = IUsersMapper.INSTANCE.usersDBToUsers(userDB);
        }
        return result;
    }

    public User save(User user) {
        IUsersMapper mapper = IUsersMapper.INSTANCE;
        UserDB userDB = repository.save(mapper.usersToUsersDB(user));
        return mapper.usersDBToUsers(userDB);
    }
}
