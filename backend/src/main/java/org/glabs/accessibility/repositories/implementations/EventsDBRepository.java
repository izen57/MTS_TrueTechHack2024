package org.glabs.accessibility.repositories.implementations;

import org.glabs.accessibility.domain.Event;
import org.glabs.accessibility.repositories.data.EventDB;
import org.glabs.accessibility.repositories.interfaces.IEventsJpaRepository;
import org.glabs.accessibility.repositories.interfaces.IEventsRepository;
import org.glabs.accessibility.repositories.mappers.IEventsMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EventsDBRepository implements IEventsRepository {
    IEventsMapper mapper;
    private IEventsJpaRepository repository;

    public EventsDBRepository(IEventsJpaRepository repo) {
        repository = repo;
        mapper = IEventsMapper.INSTANCE;
    }

    @Override
    public Event createEvent(Event event) {
        EventDB eventDB = mapper.eventToEventDB(event);
        EventDB result = repository.save(eventDB);
        return mapper.eventDBToEvent(result);
    }

    @Override
    public Event editEvent(Event event) {
        EventDB eventDB = mapper.eventToEventDB(event);
        Optional<EventDB> result = repository.findById(event.getId());
        if (result.isEmpty())
            return null;
        else
            return mapper.eventDBToEvent(result.get());
    }

    @Override
    public int deleteByID(UUID id) {
        return repository.deleteByID(id);
    }

    @Override
    public Event getEvent(UUID id) {
        Optional<EventDB> result = repository.findById(id);
        if (result.isEmpty())
            return null;
        else
            return mapper.eventDBToEvent(result.get());
    }

    @Override
    public List<Event> getEvents() {
        return repository.findAll()
                .stream()
                .map(e -> mapper.eventDBToEvent(e))
                .toList();
    }

    @Override
    public List<Event> getEvents(int pageNumber, int pageSize) {
        return repository.findAll()
                .stream()
                .map(c -> mapper.eventDBToEvent(c))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .toList();
    }

    @Override
    public Event updateEvent(Event event) {
        if (repository.findById(event.getId()).orElse(null) != null) {
            EventDB eventDB = mapper.eventToEventDB(event);
            repository.save(eventDB);
            return event;
        }
        return null;
    }


}
