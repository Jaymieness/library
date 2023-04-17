package com.practice.library.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "name cannot be blank")
    @NonNull
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "email cannot be blank")
    @NonNull
    @Column(nullable = false, unique = true)
    private String email;
}
