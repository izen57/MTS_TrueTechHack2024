package org.glabs.accessibility.repositories.implementations;

import org.glabs.accessibility.domain.UserIn;
import org.glabs.accessibility.domain.UserOut;
import org.glabs.accessibility.repositories.data.UserDB;
import org.glabs.accessibility.repositories.interfaces.IUsersJpaRepository;
import org.glabs.accessibility.repositories.interfaces.IUsersRepository;
import org.glabs.accessibility.repositories.mappers.CycleAvoidingMappingContext;
import org.glabs.accessibility.repositories.mappers.IUsersMapper;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

public class UsersRepository implements IUsersRepository {
    private final IUsersJpaRepository repository;
    private IUsersMapper mapper;

    public UsersRepository(IUsersJpaRepository repository) {
        this.repository = repository;
        mapper = IUsersMapper.INSTANCE;
    }

    public UserOut findUserBy(UUID id) {
        UserDB userDB = repository.findById(id).orElse(null);
        UserOut result = null;
        if (userDB != null) {
            result = mapper.usersDBToUsersOut(userDB, new CycleAvoidingMappingContext());
        }
        return result;
    }

    public UserOut findUserBy(String username) {
        UserDB userDB = repository.findByUsername(username);
        UserOut result = null;
        if (userDB != null) {
            result = mapper.usersDBToUsersOut(userDB, new CycleAvoidingMappingContext());
        }
        return result;
    }

    public UserOut save(UserIn userIn) {
        UserDB userDB = repository.save(mapper.usersInToUsersDB(userIn, new CycleAvoidingMappingContext()));
        return mapper.usersDBToUsersOut(userDB, new CycleAvoidingMappingContext());
    }
}
