package com.aitor.publisher.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class MessageResponseTo {
    private long id;
    private long issueId;
    private String content;
}