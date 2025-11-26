package com.aitor.springwebapplication.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequestTo {
    private long id;

    @NotNull(message = "Issue ID is required")
    private long issueId;

    @NotBlank(message = "Content is required")
    @Size(min = 2, max = 2048, message = "Content must be between 2 and 2048 characters")
    private String content;
}