package org.glabs.accessibility.services;

import jakarta.annotation.Nullable;
import org.glabs.accessibility.domain.Event;
import org.glabs.accessibility.repositories.implementations.EventsDBRepository;
import org.glabs.accessibility.repositories.interfaces.IEventsRepository;
import org.glabs.accessibility.repositories.interfaces.IEventsJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventsService {
    public IEventsRepository repository;

    public EventsService(IEventsJpaRepository repository) {
        this.repository = new EventsDBRepository(repository);
    }

    public Event createEvent(Event event) {
        return repository.createEvent(event);
    }

    public Event editEvent(Event event) {
        return repository.editEvent(event);
    }

    public boolean deleteEvent(UUID id) {
        return repository.deleteByID(id) == 1;
    }

    @Nullable
    public Event getEvent(UUID id) {
        return repository.getEvent(id);
    }

    public List<Event> getEvents() {
        return repository.getEvents();
    }

    public List<Event> getEvents(int pageNumber, int pageSize) {
        return repository.getEvents(pageNumber, pageSize);
    }
}
