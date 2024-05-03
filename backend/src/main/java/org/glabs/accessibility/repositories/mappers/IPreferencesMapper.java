package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.UserPreference;
import org.glabs.accessibility.repositories.data.UserPreferenceDB;
import org.mapstruct.Mapper;

@Mapper(uses = IUsersMapper.class)
public interface IPreferencesMapper {
    UserPreferenceDB preferenceToPreferenceDB(UserPreference userPreference);
    UserPreference preferenceDBToPreference(UserPreferenceDB userPreferenceDB);
}
