package com.example.todo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // Lombokを使用　（使用しない場合はgetter/setterを自分で定義）
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String title;

    private boolean completed = false;
}
