package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.Event;
import org.glabs.accessibility.repositories.data.EventDB;
import org.mapstruct.IterableMapping;
import org.mapstruct.NullValueMappingStrategy;

public interface IEventsMapper {
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    EventDB eventToEventDB(Event event);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    Event eventDBToEvent(EventDB eventDB);
}
