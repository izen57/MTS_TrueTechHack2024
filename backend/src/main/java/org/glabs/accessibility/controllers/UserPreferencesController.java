package org.glabs.accessibility.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.glabs.accessibility.controllers.dto.ContrastControllerDTO;
import org.glabs.accessibility.domain.UserOut;
import org.glabs.accessibility.services.ColorContrastService;
import org.glabs.accessibility.services.UsersService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.css.RGBColor;

import java.net.URI;
import java.util.UUID;

@RestController
public class UserPreferencesController {
    ColorContrastService service;
    UsersService usersService;

    public UserPreferencesController(ColorContrastService service, UsersService usersService) {
        this.service = service;
        this.usersService = usersService;
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
    @GetMapping("/users/{id}/preferences/contrast")
    public ResponseEntity<ContrastControllerDTO> checkContrast(@PathVariable UUID id, //
                                                               @RequestParam RGBColor color1,
                                                               @RequestParam RGBColor color2) {
        ContrastControllerDTO result = null;
        HttpStatus status = HttpStatus.OK;
        HttpHeaders headers = new HttpHeaders();
        UserOut userOut = usersService.getUserBy(id);
        if (userOut == null) {
            status = HttpStatus.NOT_FOUND;
            headers.setLocation(URI.create("/"));
        } else {
            service.replaceColorsRGB(color1, color2);
            boolean naa = service.normalTextAAContrastCheck();
            boolean naaa = service.normalTextAAAContrastCheck();
            boolean laa = service.largeTextAAContrastCheck();
            boolean laaa = service.largeTextAAAContrastCheck();
            result = ContrastControllerDTO.builder()
                    .c1(color1)
                    .c2(color2)
                    .AANormal(naa)
                    .AAANormal(naaa)
                    .AALarge(laa)
                    .AAALarge(laaa)
                    .build();
        }

        return new ResponseEntity<>(result, status);
    }
}
