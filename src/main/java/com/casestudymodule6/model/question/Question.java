package com.casestudymodule6.model.question;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Question {
    public enum Level {
        EASY, MEDIUM, HARD
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Level level;
    @NotBlank
    private String name;
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @Enumerated(EnumType.STRING)
    private QUESTION_TYPE question_type;

    public enum QUESTION_TYPE
    {
        ONE_CHOICE, MULTI_CHOICE
    }

    @OneToMany
    @JoinColumn(name = "answers")
    private Set<Answer> answers;

}
