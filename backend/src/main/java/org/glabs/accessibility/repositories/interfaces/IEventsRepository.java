package org.glabs.accessibility.repositories.interfaces;

import jakarta.annotation.Nullable;
import org.glabs.accessibility.domain.Event;

import java.util.List;
import java.util.UUID;

public interface IEventsRepository {
    Event createEvent(Event event);

    Event editEvent(Event event);

    int deleteByID(UUID id);

    @Nullable
    Event getEvent(UUID id);

    List<Event> getEvents();

    List<Event> getEvents(int pageNumber, int pageSize);

    Event updateEvent(Event event);
}
