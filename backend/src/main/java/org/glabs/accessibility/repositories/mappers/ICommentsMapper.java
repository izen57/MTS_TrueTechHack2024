package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.Comment;
import org.glabs.accessibility.repositories.data.CommentDB;
import org.mapstruct.Mapper;

@Mapper
public interface ICommentsMapper {
    CommentDB commentToCommentDB(Comment comment);
    Comment commentDBToComment(CommentDB commentDB);
}
