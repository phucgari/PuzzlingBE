package com.casestudymodule6.model.record;

import com.casestudymodule6.model.question.Option;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Answer implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "option_id")
    private Option option;


    private String answerStatus;


}
