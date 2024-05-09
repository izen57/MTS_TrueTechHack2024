package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.UserIn;
import org.glabs.accessibility.domain.UserOut;
import org.glabs.accessibility.repositories.data.UserDB;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {IUserCredentialsCustomDetailsMapper.class, IPreferencesMapper.class, ICommentsMapper.class})
public interface IUsersMapper {
    IUsersMapper INSTANCE = Mappers.getMapper(IUsersMapper.class);

    @Mapping(target = "preferenceDB", ignore = true)
    @Mapping(target = "credentialsDB", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    UserDB usersInToUsersDB(UserIn userIn, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "preferenceDB", target = "preference")
    @Mapping(source = "credentialsDB", target = "credentials")
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    UserOut usersDBToUsersOut(UserDB userDB, @Context CycleAvoidingMappingContext context);
}
