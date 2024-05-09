package org.glabs.accessibility.repositories.mappers;

import org.glabs.accessibility.domain.Comment;
import org.glabs.accessibility.repositories.data.CommentDB;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = IUsersMapper.class)
public interface ICommentsMapper {
    ICommentsMapper INSTANCE = Mappers.getMapper(ICommentsMapper.class);

    @Mapping(source = "id", target = "ID")
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    CommentDB commentToCommentDB(Comment comment, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "ID", target = "id")
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    Comment commentDBToComment(CommentDB commentDB, @Context CycleAvoidingMappingContext context);
}
