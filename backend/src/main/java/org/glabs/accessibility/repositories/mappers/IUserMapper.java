package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.User;
import org.glabs.accessibility.repositories.data.UserDB;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    UserDB usersToUsersDB(User user);

    User usersDBToUsers(UserDB userDB);

}
