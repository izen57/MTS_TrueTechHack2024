package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.Preference;
import org.glabs.accessibility.domain.Users;
import org.glabs.accessibility.repositories.data.PreferenceDB;
import org.glabs.accessibility.repositories.data.UsersDB;
import org.mapstruct.factory.Mappers;

public interface IPreferenceMapper {
    IPreferenceMapper INSTANCE = Mappers.getMapper(IPreferenceMapper.class);
    PreferenceDB preferenceToPreferenceDB(Preference preference);
    Preference preferenceDBToPreference(PreferenceDB preferenceDB);
}
