package com.aitor.springwebapplication.model;

import java.time.LocalDateTime;

public record Issue(long id, long userId, String title, String content, LocalDateTime created, LocalDateTime modified) {}