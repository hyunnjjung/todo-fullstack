package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoEntity {
    private String id; // Object id
    private String userId; // User id who made object
    private String title; // Todo's title
    private boolean done; // if true - Todo is done
}
