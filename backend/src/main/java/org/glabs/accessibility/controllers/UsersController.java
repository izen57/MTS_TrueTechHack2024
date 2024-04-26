package org.glabs.accessibility.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.glabs.accessibility.domain.Users;
import org.glabs.accessibility.services.UsersService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@Tag(name = "Users", description = "Users operations")
@RestController
public class UsersController {
    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }

    @Operation(
            responses = {
                    @ApiResponse(
                            responseCode = "201", //
                            description = "Successfully create user"),
                    @ApiResponse(
                            responseCode = "500", //
                            description = "Server-side problem")
            })
    @PostMapping(value = "/users")
    public ResponseEntity<Void> createUser(@RequestBody Users user) {
        HttpStatus status = HttpStatus.CREATED;
        user = service.createUser(user);
        if (user == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(status);
    }

    @Operation(
            responses = {
                    @ApiResponse(
                            responseCode = "200", //
                            description = "Successfully return user information"),
                    @ApiResponse(responseCode = "404", description = "User not found")
            })
    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById( //
                                              @PathVariable UUID id) {
        HttpStatus status = HttpStatus.OK;
        HttpHeaders headers = new HttpHeaders();
        Users user = service.getUserBy(id);
        if (user == null) {
            status = HttpStatus.NOT_FOUND;
            headers.setLocation(URI.create("/"));
        }
        return new ResponseEntity<>(user, status);
    }

    @Operation(
            responses = {
                    @ApiResponse(
                            responseCode = "200", //
                            description = "Successfully return user information"),
                    @ApiResponse(responseCode = "404", description = "User not found")
            })
    @GetMapping("/users/{username}")
    public ResponseEntity<Users> getUserByUsername( //
                                                    @PathVariable String username) {
        HttpStatus status = HttpStatus.OK;
        HttpHeaders headers = new HttpHeaders();
        Users user = service.getUserBy(username);
        if (user == null) {
            status = HttpStatus.NOT_FOUND;
            headers.setLocation(URI.create("/"));
        }
        return new ResponseEntity<>(user, status);
    }
}
