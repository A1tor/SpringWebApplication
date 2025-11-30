package com.aitor.springwebapplication.repository;

import com.aitor.springwebapplication.model.IssueSticker;
import com.aitor.springwebapplication.model.Sticker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StickerRepository extends JpaRepository<Sticker, Long> {
    List<Sticker> findByName(String name);
}
