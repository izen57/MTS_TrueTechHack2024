package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.Comment;
import org.glabs.accessibility.repositories.data.CommentDB;
import org.mapstruct.*;

@Mapper(uses = IUsersMapper.class)
public interface ICommentsMapper {
    @Mapping(source = "id", target = "ID")
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    CommentDB commentToCommentDB(Comment comment, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "ID", target = "id")
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    Comment commentDBToComment(CommentDB commentDB, @Context CycleAvoidingMappingContext context);
}
