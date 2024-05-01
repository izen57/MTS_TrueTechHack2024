package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.CustomUserDetails;
import org.glabs.accessibility.repositories.data.UserCredentialsDB;
import org.mapstruct.Mapper;

@Mapper
public interface IUserCredentialsCustomDetailsMapper {
    UserCredentialsDB userDetailsToCredentials(CustomUserDetails details);
    CustomUserDetails credentialsToUserDetails(UserCredentialsDB credentials);
}
