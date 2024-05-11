package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.Event;
import org.glabs.accessibility.repositories.data.EventDB;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IEventsMapper {
    IEventsMapper INSTANCE = Mappers.getMapper(IEventsMapper.class);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    @Mappings({
            @Mapping(source = "beginDateTime", target = "beginZonedDateTime"),
            @Mapping(source = "endDateTime", target = "endZonedDateTime"),
            @Mapping(source = "id", target = "ID"),
    })
    EventDB eventToEventDB(Event event);

    @Mappings({
            @Mapping(source = "beginZonedDateTime", target = "beginDateTime"),
            @Mapping(source = "endZonedDateTime", target = "endDateTime"),
            @Mapping(source = "ID", target = "id"),
    })
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    Event eventDBToEvent(EventDB eventDB);
}
