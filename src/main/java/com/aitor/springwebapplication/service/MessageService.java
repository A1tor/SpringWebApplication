package com.aitor.springwebapplication.service;

import com.aitor.springwebapplication.dto.MessageRequestTo;
import com.aitor.springwebapplication.dto.MessageResponseTo;
import com.aitor.springwebapplication.model.Message;
import com.aitor.springwebapplication.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository repository;

    public MessageResponseTo add(MessageRequestTo requestBody){
        Message persisted = repository.save(new Message(
                requestBody.getIssueId(),
                requestBody.getContent()));
        return toResponse(persisted);
    }

    public MessageResponseTo set(Long id, MessageRequestTo requestBody){
        var entity = getEntity(id);
        entity.setIssueId(requestBody.getIssueId());
        entity.setContent(requestBody.getContent());
        return toResponse(repository.save(entity));
    }

    public MessageResponseTo get(Long id) {
        return toResponse(getEntity(id));
    }

    public List<MessageResponseTo> getAll(){
        return repository.findAll().stream()
                        .map(this::toResponse)
                        .collect(Collectors.toList());
    }

    public void remove(Long id){
        repository.deleteById(id);
    }

    private Message getEntity(Long id){
        return repository.findById(id).get();
    }

    private MessageResponseTo toResponse(Message entity){
        return new MessageResponseTo(
                entity.getId(),
                entity.getIssueId(),
                entity.getContent());
    }
}
