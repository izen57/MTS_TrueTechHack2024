package org.glabs.accessibility.repositories.interfaces;

import jakarta.annotation.Nullable;
import org.glabs.accessibility.domain.Comment;

import java.util.List;
import java.util.UUID;

public interface ICommentsRepository {
    Comment createComment(Comment comment);

    Comment editComment(Comment comment);

    int deleteByID(UUID id);

    @Nullable
    Comment getComment(UUID id);

    List<Comment> getComments();

    List<Comment> getComments(int pageNumber, int pageSize);
}
