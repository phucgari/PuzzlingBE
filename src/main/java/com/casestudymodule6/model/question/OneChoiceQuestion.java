package com.casestudymodule6.model.question;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
public class OneChoiceQuestion extends Question{
    @OneToMany
    @JoinColumn(name = "question_id")
    private Set<OneChoiceOption> options;
    @OneToOne
    @JoinColumn(name = "correct_option_id")
    @NotNull
    private OneChoiceOption correctOption;
}
