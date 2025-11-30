package com.aitor.springwebapplication.service;

import com.aitor.springwebapplication.dto.IssueRequestTo;
import com.aitor.springwebapplication.dto.IssueResponseTo;
import com.aitor.springwebapplication.exception.EntityNotExistsException;
import com.aitor.springwebapplication.model.Issue;
import com.aitor.springwebapplication.model.User;
import com.aitor.springwebapplication.repository.IssueRepository;
import com.aitor.springwebapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final IssueRepository repository;
    private final UserRepository userRepository;

    public IssueResponseTo add(IssueRequestTo requestBody){
        Issue persisted = repository.save(new Issue(
                getUser(requestBody.getUserId()),
                requestBody.getTitle(),
                requestBody.getContent(),
                LocalDateTime.now(),
                LocalDateTime.now()));
        return toResponse(persisted);
    }

    public IssueResponseTo set(Long id, IssueRequestTo requestBody){
        var entity = getEntity(id);
        entity.setUserId(getUser(requestBody.getUserId()));
        entity.setTitle(requestBody.getTitle());
        entity.setContent(requestBody.getContent());
        entity.setModified(LocalDateTime.now());
        return toResponse(repository.save(entity));
    }

    public IssueResponseTo get(Long id) {
        return toResponse(getEntity(id));
    }

    public List<IssueResponseTo> getAll(){
        return repository.findAll().stream()
                        .map(this::toResponse)
                        .collect(Collectors.toList());
    }

    public IssueResponseTo remove(Long id) {
        var entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            var entity = entityOptional.get();
            var response = toResponse(entity);
            repository.delete(entity);
            return response;
        } else
            throw new EntityNotExistsException();
    }

    private Issue getEntity(Long id){
        var entity = repository.findById(id);
        if (entity.isPresent())
            return entity.get();
        throw new EntityNotExistsException();
    }

    private User getUser(Long id){
        var entity = userRepository.findById(id);
        if (entity.isPresent())
            return entity.get();
        throw new EntityNotExistsException();
    }

    private IssueResponseTo toResponse(Issue entity){
        return new IssueResponseTo(
                entity.getId(),
                entity.getUserId().getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getCreated(),
                entity.getModified());
    }
}
