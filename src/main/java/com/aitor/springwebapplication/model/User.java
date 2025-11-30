package com.aitor.springwebapplication.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NonNull
    @Column(unique = true, nullable = false)
    String login;
    @NonNull
    String password;
    @NonNull
    String firstname;
    @NonNull
    String lastname;
}