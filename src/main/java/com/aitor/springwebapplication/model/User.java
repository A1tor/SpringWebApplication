package com.aitor.springwebapplication.model;

public record User (long id, String login, String password, String firstname, String lastname){}