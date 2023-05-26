package com.casestudymodule6.model.record;

import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.user.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
public class Record implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDateTime submitTime;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    private int userPoint;

    private int examPoint;


}