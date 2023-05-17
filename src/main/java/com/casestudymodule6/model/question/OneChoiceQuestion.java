package com.casestudymodule6.model.question;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class OneChoiceQuestion extends Question
{
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Set<OneChoiceOption> options;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "correct_option_id")
    private OneChoiceOption correctOption;
}
