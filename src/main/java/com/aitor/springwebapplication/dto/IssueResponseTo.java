package com.aitor.springwebapplication.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class IssueResponseTo {
    private long id;
    private long userId;
    private String title;
    private String content;
    private LocalDateTime created;
    private LocalDateTime modified;
}