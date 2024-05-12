package org.glabs.accessibility.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.glabs.accessibility.domain.Comment;
import org.glabs.accessibility.domain.CommentEdit;
import org.glabs.accessibility.domain.Pagination;
import org.glabs.accessibility.services.CommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Comments", description = "Операции с комментариями")
public class CommentsController {
    private CommentsService service;

    public CommentsController(CommentsService service) {
        this.service = service;
    }

    @PostMapping(value = "/comments")
    @Operation(responses = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Комментарий успешно создан."
            )
    })
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        if (comment == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Comment result = service.createComment(comment);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping(value = "/comments/{id}")
    @Operation(responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Комментарий успешно изменён."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Комментарий не найден."
            )
    })
    public ResponseEntity<Comment> editComment(@RequestBody CommentEdit comment, @PathVariable UUID id) {
        if (comment == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Comment result = service.editComment(new Comment(
                id,
                comment.getUserIn(),
                comment.getText(),
                comment.getZonedDateTime()
        ));

        if (result == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @DeleteMapping(value = "/comments/{id}")
    @Operation(responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Комментарий успешно удалён."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Комментарий не найден."
            )
    })
    public ResponseEntity<Void> deleteComment(@PathVariable UUID id) {
        boolean result = service.deleteComment(id);
        if (result)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/comments/{id}")
    @Operation(responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Комментарий найден."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Комментарий не найден."
            )
    })
    public ResponseEntity<Comment> getComment(@PathVariable UUID id) {
        Comment result = service.getComment(id);
        if (result == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/comments")
    @Operation(responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Комментарии найдены."
            )
    })
    public ResponseEntity<List<Comment>> getComments() {
        List<Comment> result = service.getComments();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/comments/{pagination}")
    @Operation(responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Комментарии найдены."
            )
    })
    public ResponseEntity<List<Comment>> getComments(@RequestParam Pagination pagination) {
        List<Comment> result = service.getComments(pagination.getPageNumber(), pagination.getPageSize());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
