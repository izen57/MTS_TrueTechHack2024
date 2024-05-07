package org.glabs.accessibility.repositories.implementations;

import org.glabs.accessibility.domain.Comment;
import org.glabs.accessibility.repositories.data.CommentDB;
import org.glabs.accessibility.repositories.interfaces.ICommentsRepository;
import org.glabs.accessibility.repositories.interfaces.IJpaRepositoryDeleteMethod;
import org.glabs.accessibility.repositories.mappers.CycleAvoidingMappingContext;
import org.glabs.accessibility.repositories.mappers.ICommentsMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CommentsDBRepository implements ICommentsRepository {
    private IJpaRepositoryDeleteMethod<CommentDB, UUID> repository;
    ICommentsMapper mapper;

    public CommentsDBRepository(IJpaRepositoryDeleteMethod<CommentDB, UUID> repo) {
        repository = repo;
        mapper = Mappers.getMapper(ICommentsMapper.class);
    }

    @Override
    public Comment createComment(Comment comment) {
        CommentDB commentDB = mapper.commentToCommentDB(comment, new CycleAvoidingMappingContext());
        CommentDB result = repository.save(commentDB);
        return mapper.commentDBToComment(result, new CycleAvoidingMappingContext());
    }

    @Override
    public Comment editComment(Comment comment) {
        CommentDB commentDB = mapper.commentToCommentDB(comment, new CycleAvoidingMappingContext());
        Optional<CommentDB> result = repository.findById(comment.getId());
        if (result.isEmpty())
            return null;
        else
            return mapper.commentDBToComment(result.get(), new CycleAvoidingMappingContext());
    }

    @Override
    public int deleteByID(UUID id) {
        return repository.deleteByID(id);
    }

    @Override
    public Comment getComment(UUID id) {
        Optional<CommentDB> result = repository.findById(id);
        if (result.isEmpty())
            return null;
        else
            return mapper.commentDBToComment(result.get(), new CycleAvoidingMappingContext());
    }

    @Override
    public List<Comment> getComments() {
        return repository.findAll()
            .stream()
            .map(c -> mapper.commentDBToComment(c, new CycleAvoidingMappingContext()))
            .toList();
    }

    @Override
    public List<Comment> getComments(int pageNumber, int pageSize) {
        return repository.findAll()
            .stream()
            .map(c -> mapper.commentDBToComment(c, new CycleAvoidingMappingContext()))
            .skip((pageNumber - 1) * pageSize)
            .limit(pageSize)
            .toList();
    }
}
