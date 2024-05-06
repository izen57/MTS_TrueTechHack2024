package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.CustomUserDetails;
import org.glabs.accessibility.repositories.data.UserCredentialsDB;
import org.mapstruct.*;

@Mapper
public interface IUserCredentialsCustomDetailsMapper {
    @Mapping(source = "userIn", target = "user")
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    UserCredentialsDB userDetailsToCredentials(CustomUserDetails details, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user", target = "userIn")
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    CustomUserDetails credentialsToUserDetails(UserCredentialsDB credentials, @Context CycleAvoidingMappingContext context);
}
