package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.Preference;
import org.glabs.accessibility.repositories.data.UserPreferenceDB;
import org.mapstruct.factory.Mappers;

public interface IPreferencesMapper {
    IPreferencesMapper INSTANCE = Mappers.getMapper(IPreferencesMapper.class);

    UserPreferenceDB preferenceToPreferenceDB(Preference preference);

    Preference preferenceDBToPreference(UserPreferenceDB userPreferenceDB);
}
