package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.CustomUserDetails;
import org.glabs.accessibility.repositories.data.UserCredentialsDB;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IUserCredentialsCustomDetailsMapper {
    IUserCredentialsCustomDetailsMapper INSTANCE = Mappers.getMapper(IUserCredentialsCustomDetailsMapper.class);

    UserCredentialsDB userDetailsToCredentials(CustomUserDetails details);

    CustomUserDetails credentialsToUserDetails(UserCredentialsDB credentials);

}
