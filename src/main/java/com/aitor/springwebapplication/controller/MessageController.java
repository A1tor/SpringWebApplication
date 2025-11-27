package com.aitor.springwebapplication.controller;

import com.aitor.springwebapplication.dto.MessageRequestTo;
import com.aitor.springwebapplication.dto.MessageResponseTo;
import com.aitor.springwebapplication.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("messages")
public class MessageController {
    private final MessageService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MessageResponseTo add(@RequestBody MessageRequestTo request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public MessageResponseTo set(@RequestBody MessageRequestTo request){
        return service.add(request);
    }

    @GetMapping("/{id}")
    public MessageResponseTo get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping
    public List<MessageResponseTo> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        service.remove(id);
    }
}
