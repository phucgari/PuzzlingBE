package com.casestudymodule6.model.question;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class MultiChoiceQuestion extends Question{
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Set<MultiChoiceOption> options;
}
