package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.User;
import org.glabs.accessibility.repositories.data.UserDB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = { IUserCredentialsCustomDetailsMapper.class, IPreferencesMapper.class })
public interface IUsersMapper {
    @Mapping(source = "preference", target = "preferenceDB")
    @Mapping(source = "credentials", target = "credentialsDB")
    UserDB usersToUsersDB(User user);

    @Mapping(source = "preferenceDB", target = "preference")
    @Mapping(source = "credentialsDB", target = "credentials")
    User usersDBToUsers(UserDB userDB);
}
