package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.Comment;
import org.glabs.accessibility.repositories.data.CommentDB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = IUsersMapper.class)
public interface ICommentsMapper {
    @Mapping(source = "id", target = "ID")
    CommentDB commentToCommentDB(Comment comment);

    @Mapping(source = "ID", target = "id")
    Comment commentDBToComment(CommentDB commentDB);
}
