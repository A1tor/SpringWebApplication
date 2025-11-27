package com.aitor.springwebapplication.service;

import com.aitor.springwebapplication.dto.StickerRequestTo;
import com.aitor.springwebapplication.dto.StickerResponseTo;
import com.aitor.springwebapplication.model.Sticker;
import com.aitor.springwebapplication.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StickerService {
    private final StickerRepository repository;

    public StickerResponseTo add(StickerRequestTo requestBody){
        Sticker persisted = repository.save(new Sticker(requestBody.getName()));
        return toResponse(persisted);
    }

    public StickerResponseTo set(Long id, StickerRequestTo requestBody){
        var entity = getEntity(id);
        entity.setName(requestBody.getName());
        return toResponse(repository.save(entity));
    }

    public StickerResponseTo get(Long id) {
        return toResponse(getEntity(id));
    }

    public List<StickerResponseTo> getAll(){
        return repository.findAll().stream()
                        .map(this::toResponse)
                        .collect(Collectors.toList());
    }

    public void remove(Long id){
        repository.deleteById(id);
    }

    private Sticker getEntity(Long id){
        return repository.findById(id).get();
    }

    private StickerResponseTo toResponse(Sticker entity){
        return new StickerResponseTo(entity.getId(), entity.getName());
    }
}
