package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.UserPreference;
import org.glabs.accessibility.repositories.data.UserPreferenceDB;
import org.mapstruct.Context;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = IUsersMapper.class)
public interface IPreferencesMapper {
    IPreferencesMapper INSTANCE = Mappers.getMapper(IPreferencesMapper.class);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    UserPreferenceDB preferenceToPreferenceDB(UserPreference userPreference, @Context CycleAvoidingMappingContext context);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    UserPreference preferenceDBToPreference(UserPreferenceDB userPreferenceDB, @Context CycleAvoidingMappingContext context);
}
