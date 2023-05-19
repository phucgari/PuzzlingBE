package com.casestudymodule6.model.question;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Question {
    public enum Level{
        EASY,MEDIUM,HARD
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Level level;
    @NotBlank
    private String name;

    private String question_type;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;


}
