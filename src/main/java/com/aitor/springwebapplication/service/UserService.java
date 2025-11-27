package com.aitor.springwebapplication.service;

import com.aitor.springwebapplication.dto.UserRequestTo;
import com.aitor.springwebapplication.dto.UserResponseTo;
import com.aitor.springwebapplication.model.User;
import com.aitor.springwebapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public UserResponseTo add(UserRequestTo requestBody){
        User persisted = repository.save(new User(
                requestBody.getLogin(),
                requestBody.getPassword(),
                requestBody.getFirstname(),
                requestBody.getLastname()));
        return toResponse(persisted);
    }

    public UserResponseTo set(Long id, UserRequestTo requestBody){
        var entity = getEntity(id);
        entity.setLogin(requestBody.getLogin());
        entity.setPassword(requestBody.getPassword());
        entity.setFirstname(requestBody.getFirstname());
        entity.setLastname(requestBody.getLastname());
        return toResponse(repository.save(entity));
    }

    public UserResponseTo get(Long id) {
        return toResponse(getEntity(id));
    }

    public List<UserResponseTo> getAll(){
        return repository.findAll().stream()
                        .map(this::toResponse)
                        .collect(Collectors.toList());
    }

    public void remove(Long id){
        repository.deleteById(id);
    }

    private User getEntity(Long id){
        return repository.findById(id).get();
    }

    private UserResponseTo toResponse(User entity){
        return new UserResponseTo(
                entity.getId(),
                entity.getLogin(),
                entity.getFirstname(),
                entity.getLastname());
    }
}
