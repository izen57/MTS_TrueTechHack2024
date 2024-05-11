package org.glabs.accessibility.services;

import jakarta.annotation.Nullable;
import org.glabs.accessibility.domain.Comment;
import org.glabs.accessibility.repositories.implementations.CommentsDBRepository;
import org.glabs.accessibility.repositories.interfaces.ICommentsJpaRepository;
import org.glabs.accessibility.repositories.interfaces.ICommentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentsService {
    private ICommentsRepository repository;

    public CommentsService(ICommentsJpaRepository repo) {
        repository = new CommentsDBRepository(repo);
    }

    public Comment createComment(Comment comment) {
        return repository.createComment(comment);
    }

    public Comment editComment(Comment comment) {
        return repository.editComment(comment);
    }

    public boolean deleteComment(UUID id) {
        return repository.deleteByID(id) == 1;
    }

    @Nullable
    public Comment getComment(UUID id) {
        return repository.getComment(id);
    }

    public List<Comment> getComments() {
        return repository.getComments();
    }

    public List<Comment> getComments(int pageNumber, int pageSize) {
        return repository.getComments(pageNumber, pageSize);
    }
}
