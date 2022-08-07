package com.example.authentication.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments;
}
