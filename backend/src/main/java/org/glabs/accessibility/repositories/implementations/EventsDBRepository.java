package org.glabs.accessibility.repositories.implementations;

import org.glabs.accessibility.domain.Event;
import org.glabs.accessibility.repositories.data.EventDB;
import org.glabs.accessibility.repositories.interfaces.IEventsRepository;
import org.glabs.accessibility.repositories.interfaces.IJpaEventsDBRepositoryExtension;
import org.glabs.accessibility.repositories.mappers.IEventsMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class EventsDBRepository implements IEventsRepository {
    private IJpaEventsDBRepositoryExtension repository;
    IEventsMapper mapper;

    public EventsDBRepository(IJpaEventsDBRepositoryExtension repo) {
        repository = repo;
        mapper = Mappers.getMapper(IEventsMapper.class);
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
}
