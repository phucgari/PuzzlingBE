package com.casestudymodule6.model.question;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Answer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String status;
}
