package com.aitor.springwebapplication.controller;

import com.aitor.springwebapplication.dto.StickerRequestTo;
import com.aitor.springwebapplication.dto.StickerResponseTo;
import com.aitor.springwebapplication.service.StickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("stickers")
class StickerController {
    private final StickerService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public StickerResponseTo add(@RequestBody StickerRequestTo request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public StickerResponseTo set(@RequestBody StickerRequestTo request){
        return service.add(request);
    }

    @GetMapping("/{id}")
    public StickerResponseTo get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping()
    public List<StickerResponseTo> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        service.remove(id);
    }
}
