package org.glabs.accessibility.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.glabs.accessibility.domain.UserIn;
import org.glabs.accessibility.domain.UserOut;
import org.glabs.accessibility.services.UsersService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Users", description = "Операции с пользователями")
public class UsersController {
    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }

    @Operation(responses = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Пользователь успешно создан."
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Такой пользователь уже существует."
            )
    })
    @PostMapping(value = "/users")
    public ResponseEntity<UserOut> createUser(@RequestBody UserIn userIn) {
        UserOut userOut = service.createUser(userIn);
        if (userOut == null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        else
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Пользователь найден."),
            @ApiResponse(
                    responseCode = "404",
                    description = "Пользователь не найден."
            )
    })
    //@GetMapping("/users/{id}")
    public ResponseEntity<UserOut> getUserById(@PathVariable UUID id) {
        HttpStatus status = HttpStatus.OK;
        HttpHeaders headers = new HttpHeaders();
        UserOut userOut = service.getUserBy(id);
        if (userOut == null) {
            status = HttpStatus.NOT_FOUND;
            headers.setLocation(URI.create("/"));
        }

        return new ResponseEntity<>(userOut, status);
    }

    @Operation(responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Пользователь найден."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Пользователь не найден."
            )
    })
    @GetMapping("/users/{username}")
    public ResponseEntity<UserOut> getUserByUsername(@PathVariable String username) {
        HttpStatus status = HttpStatus.OK;
        HttpHeaders headers = new HttpHeaders();
        UserOut userOut = service.getUserBy(username);
        if (userOut == null) {
            status = HttpStatus.NOT_FOUND;
            headers.setLocation(URI.create("/"));
        }
        return new ResponseEntity<>(userOut, status);
    }
}
