package com.casestudymodule6.model.question;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @OneToMany
    @JoinColumn(name = "exam_id")
    private Set<Question> questions;
}
