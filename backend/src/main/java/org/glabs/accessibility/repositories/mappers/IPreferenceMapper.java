package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.Preference;
import org.glabs.accessibility.repositories.data.UserPreferenceDB;
import org.mapstruct.factory.Mappers;

public interface IPreferenceMapper {
    IPreferenceMapper INSTANCE = Mappers.getMapper(IPreferenceMapper.class);

    UserPreferenceDB preferenceToPreferenceDB(Preference preference);

    Preference preferenceDBToPreference(UserPreferenceDB userPreferenceDB);
}
