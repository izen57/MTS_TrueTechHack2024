package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.CustomUserDetails;
import org.glabs.accessibility.repositories.data.UserCredentialsDB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface IUserCredentialsCustomDetailsMapper {
    @Mapping(source = "userIn", target = "user")
    UserCredentialsDB userDetailsToCredentials(CustomUserDetails details);

    @Mapping(source = "user", target = "userIn")
    CustomUserDetails credentialsToUserDetails(UserCredentialsDB credentials);
}
