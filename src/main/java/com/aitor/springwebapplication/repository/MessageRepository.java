package com.aitor.springwebapplication.repository;

import com.aitor.springwebapplication.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
