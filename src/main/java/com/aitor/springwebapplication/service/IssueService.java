package com.aitor.springwebapplication.service;

import com.aitor.springwebapplication.dto.IssueRequestTo;
import com.aitor.springwebapplication.dto.IssueResponseTo;
import com.aitor.springwebapplication.model.Issue;
import com.aitor.springwebapplication.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final IssueRepository repository;

    public IssueResponseTo add(IssueRequestTo requestBody){
        Issue persisted = repository.save(new Issue(
                requestBody.getUserId(),
                requestBody.getTitle(),
                requestBody.getContent(),
                LocalDateTime.now(),
                LocalDateTime.now()));
        return toResponse(persisted);
    }

    public IssueResponseTo set(Long id, IssueRequestTo requestBody){
        var entity = getEntity(id);
        entity.setUserId(requestBody.getUserId());
        entity.setTitle(requestBody.getContent());
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

    public void remove(Long id){
        repository.deleteById(id);
    }

    private Issue getEntity(Long id){
        return repository.findById(id).get();
    }

    private IssueResponseTo toResponse(Issue entity){
        return new IssueResponseTo(
                entity.getId(),
                entity.getUserId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getCreated(),
                entity.getModified());
    }
}
