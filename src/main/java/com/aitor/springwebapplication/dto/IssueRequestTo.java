package com.aitor.springwebapplication.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueRequestTo {
    private long id;

    @NotNull(message = "User ID is required")
    private long userId;

    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 64, message = "Title must be between 2 and 64 characters")
    private String title;

    @NotBlank(message = "Content is required")
    @Size(min = 4, max = 2048, message = "Content must be between 4 and 2048 characters")
    private String content;
}