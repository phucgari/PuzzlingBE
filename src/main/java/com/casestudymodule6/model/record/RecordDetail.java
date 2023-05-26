package com.casestudymodule6.model.record;

import com.casestudymodule6.model.question.Question;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class RecordDetail implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "record_id")
    private Record record;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;


    @OneToMany
    @JoinColumn(name = "recordDetail_id")
    private Set<Answer> answers;

}
