package com.aitor.springwebapplication.repository;

import com.aitor.springwebapplication.model.Sticker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StickerRepository extends JpaRepository<Sticker, Long> {
}
