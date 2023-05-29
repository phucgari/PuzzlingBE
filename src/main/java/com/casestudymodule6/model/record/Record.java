package com.casestudymodule6.model.record;

import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.user.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Record implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDateTime submitTime;

    @OneToMany
    @JoinColumn(name = "record_id")
    private Set<RecordDetail> recordDetails;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    private int userPoint;

    private int examPoint;


}
