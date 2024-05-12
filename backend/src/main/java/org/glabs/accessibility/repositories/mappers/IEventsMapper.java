package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.Event;
import org.glabs.accessibility.repositories.data.EventDB;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IEventsMapper {
    IEventsMapper INSTANCE = Mappers.getMapper(IEventsMapper.class);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    EventDB eventToEventDB(Event event);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    Event eventDBToEvent(EventDB eventDB);
}
