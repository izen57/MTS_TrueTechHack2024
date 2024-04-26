package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.Users;
import org.glabs.accessibility.repositories.data.UsersDB;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IUsersMapper {
    IUsersMapper INSTANCE = Mappers.getMapper(IUsersMapper.class);

    UsersDB usersToUsersDB(Users user);

    Users usersDBToUsers(UsersDB userDB);

}
