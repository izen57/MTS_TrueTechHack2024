package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.User;
import org.glabs.accessibility.repositories.data.UserDB;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IUsersMapper {
    IUsersMapper INSTANCE = Mappers.getMapper(IUsersMapper.class);

    UserDB usersToUsersDB(User user);

    User usersDBToUsers(UserDB userDB);

}
