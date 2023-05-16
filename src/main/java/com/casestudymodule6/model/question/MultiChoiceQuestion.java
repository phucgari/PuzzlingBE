package com.casestudymodule6.model.question;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class MultiChoiceQuestion extends Question{
    @OneToMany
    @JoinColumn(name = "question_id")
    private Set<MultiChoiceOption> options;
}
