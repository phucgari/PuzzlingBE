package com.casestudymodule6.controller;

import com.casestudymodule6.model.question.*;
import com.casestudymodule6.model.user.User;
import com.casestudymodule6.service.exam.IExamService;
import com.casestudymodule6.service.question.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/puzzling/exam")
public class ExamController
{
    @Autowired
    private IExamService examService;


    @Autowired
    private IQuestionService questionService;

    @PostMapping("/createExam/{userId}")
    public ResponseEntity<Exam> createExam(@PathVariable("userId") User user, @RequestBody Exam exam)
    {
        exam.setUser(user);
        examService.save(exam);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/updateExam/{userId}")
    public ResponseEntity<Exam> updateExam(@PathVariable("userId") User user, @RequestBody Exam exam)
    {
        Optional<Exam> optionalExam = examService.findById(exam.getId());
        optionalExam.get().setUser(user);
        for (Question question : exam.getQuestions())
        {
            if (question.getQuestionType() == Question.QuestionType.ONE_CHOICE)
            {
                OneChoiceQuestion oneChoiceQuestion = (OneChoiceQuestion) question;
                questionService.save(oneChoiceQuestion);
            }
            else
            {
                MultiChoiceQuestion multiChoiceQuestion = (MultiChoiceQuestion) question;
                questionService.save(multiChoiceQuestion);
            }
        }
        optionalExam.get().setQuestions(exam.getQuestions());
        return new ResponseEntity<>(examService.save(optionalExam.get()),HttpStatus.OK);
    }
}
