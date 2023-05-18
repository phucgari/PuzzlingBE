package com.casestudymodule6.controller;

import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.question.MultiChoiceQuestion;
import com.casestudymodule6.model.question.OneChoiceQuestion;
import com.casestudymodule6.model.question.Question;
import com.casestudymodule6.service.exam.IExamService;
import com.casestudymodule6.service.question.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/puzzling/exam")
public class ExamController
{
    @Autowired
    private IExamService examService;

    @Autowired
    private IQuestionService questionService;


    @PostMapping("/createExam")
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam)
    {
        examService.save(exam);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
