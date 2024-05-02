package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.UserIn;
import org.glabs.accessibility.domain.UserOut;
import org.glabs.accessibility.repositories.data.UserDB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = { IUserCredentialsCustomDetailsMapper.class, IPreferencesMapper.class })
public interface IUsersMapper {
//    @Mapping(source = "preference", target = "preferenceDB")
//    @Mapping(source = "credentials", target = "credentialsDB")
    UserDB usersToUsersDB(UserIn userIn);

    @Mapping(source = "preferenceDB", target = "preference")
    @Mapping(source = "credentialsDB", target = "credentials")
    UserOut usersDBToUsers(UserDB userDB);
}
