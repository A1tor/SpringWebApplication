package com.aitor.discussion.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class MessageResponseTo {
    private long id;
    private long issueId;
    private String content;
}