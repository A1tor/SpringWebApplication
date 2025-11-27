package com.aitor.springwebapplication.controller;

import com.aitor.springwebapplication.dto.IssueRequestTo;
import com.aitor.springwebapplication.dto.IssueResponseTo;
import com.aitor.springwebapplication.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("issues")
public class IssueController {
    private final IssueService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public IssueResponseTo add(@RequestBody IssueRequestTo request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public IssueResponseTo set(@RequestBody IssueRequestTo request){
        return service.add(request);
    }

    @GetMapping("/{id}")
    public IssueResponseTo get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping()
    public List<IssueResponseTo> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        service.remove(id);
    }
}
