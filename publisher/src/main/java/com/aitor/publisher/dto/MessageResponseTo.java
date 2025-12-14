package com.aitor.publisher.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponseTo {
    private Long id;
    private Long issueId;
    private String content;
}