package com.casestudymodule6.model.question;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

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
    @Enumerated(EnumType.STRING)
    private QUESTIONTYPE questionType;

    public enum QUESTIONTYPE
    {
        ONE_CHOICE, MULTI_CHOICE
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Set<Option> options;


}
