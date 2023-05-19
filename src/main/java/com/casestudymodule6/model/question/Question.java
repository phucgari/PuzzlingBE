package com.casestudymodule6.model.question;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public abstract class Question implements Serializable
{
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
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;
    public enum QuestionType
    {
        MULTI_CHOICE,ONE_CHOICE
    }
}
