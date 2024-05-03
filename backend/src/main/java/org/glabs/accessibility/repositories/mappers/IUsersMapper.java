package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.UserIn;
import org.glabs.accessibility.domain.UserOut;
import org.glabs.accessibility.repositories.data.UserDB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = { IUserCredentialsCustomDetailsMapper.class, IPreferencesMapper.class })
public interface IUsersMapper {
    @Mapping(target = "preferenceDB", ignore = true)
    @Mapping(target = "credentialsDB", ignore = true)
    @Mapping(target = "comments", ignore = true)
    UserDB usersToUsersDB(UserIn userIn);

    @Mapping(source = "preferenceDB", target = "preference")
    @Mapping(source = "credentialsDB", target = "credentials")
    UserOut usersDBToUsers(UserDB userDB);
}
