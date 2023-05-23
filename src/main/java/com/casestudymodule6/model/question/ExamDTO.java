package com.casestudymodule6.model.question;

import java.util.Set;

public class ExamDTO {

    private Long id;
    private String name;


    public ExamDTO(Exam exam)
    {
        this.id = exam.getId();
        this.name = exam.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
