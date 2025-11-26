package com.aitor.springwebapplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "tbl_issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private Long userId;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private LocalDateTime created;
    @NonNull
    private LocalDateTime modified;
}