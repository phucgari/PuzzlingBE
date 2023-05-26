package com.casestudymodule6.model.dto;

import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.record.RecordDetail;
import com.casestudymodule6.model.user.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
@Data
public class RecordDTO {

    private Long id;

    private LocalDateTime submitTime;

    private User user;

    private Exam exam;

    private Set<RecordDetail> recordDetais;

    private int userPoint;

    private int examPoint;


}
