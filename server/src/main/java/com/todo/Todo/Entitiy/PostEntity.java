package com.todo.Todo.Entitiy;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // Many posts can belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // This should replace @Column
    private UserEntity user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private String createdAt;

    private String lastUpdated;

}
