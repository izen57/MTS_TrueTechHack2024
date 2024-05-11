package org.glabs.accessibility.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.glabs.accessibility.domain.AccessibiltyFeatureName;
import org.glabs.accessibility.domain.Event;
import org.glabs.accessibility.domain.EventEdit;
import org.glabs.accessibility.domain.Pagination;
import org.glabs.accessibility.services.EventsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Events", description = "Операции над мероприятиями")
@RestController
public class EventsController {
    private EventsService service;

    public EventsController(EventsService service) {
        this.service = service;
    }

    @PostMapping(value = "/events")
    @Operation(responses = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Мероприятие успешно создано."
            )
    })
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        if (event == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Event result = service.createEvent(event);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping(value = "/events/{id}")
    @Operation(responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Мероприятие успешно изменено."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Мероприятие не найдено."
            )
    })
    public ResponseEntity<Event> editEvent(@RequestBody EventEdit event, @PathVariable UUID id) {
        if (event == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Event result = service.editEvent(new Event(
                id,
                event.getTitle(),
                event.getDescription(),
                event.getBeginDateTime(),
                event.getEndDateTime()
        ));

        if (result == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @DeleteMapping(value = "/events/{id}")
    @Operation(responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Мероприятие успешно удалено."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Мероприятие не найдено."
            )
    })
    public ResponseEntity<Void> deleteEvent(@PathVariable UUID id) {
        boolean result = service.deleteEvent(id);
        if (result)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/events/{id}")
    @Operation(responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Мероприятие найдено."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Мероприятие не найдено."
            )
    })
    public ResponseEntity<Event> getEvent(@PathVariable UUID id) {
        Event result = service.getEvent(id);
        if (result == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/events")
    @Operation(responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Мероприятия найдены."
            )
    })
    public ResponseEntity<List<Event>> getEvents() {
        List<Event> result = service.getEvents();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/event/{pagination}")
    @Operation(responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Мероприятия найдены."
            )
    })
    public ResponseEntity<List<Event>> getEvents(@RequestParam Pagination pagination) {
        List<Event> result = service.getEvents(pagination.getPageNumber(), pagination.getPageSize());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping(value = "/events/{id}/accessibility")
    public ResponseEntity<Void> addAccessibiltyFeature(@PathVariable UUID id, @RequestParam List<AccessibiltyFeatureName> names) {
        Event result = service.getEvent(id);
        if (result == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        result = service.addAccessibiltyFeature(result, names);
        service.editEvent(result);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
