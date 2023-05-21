package com.casestudymodule6.controller;

import com.casestudymodule6.model.question.*;
import com.casestudymodule6.model.user.Account;
import com.casestudymodule6.model.user.User;
import com.casestudymodule6.service.account.IAccountService;
import com.casestudymodule6.service.exam.IExamService;
import com.casestudymodule6.service.question.IQuestionService;
import com.casestudymodule6.service.user.IUserService;
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
    private IUserService userService;



    @PostMapping("/createExam")
    public ResponseEntity<Exam> createExam(@RequestParam("username") String username, @RequestBody Exam exam)
    {
        Optional<User> optionalUser = userService.findUserByUsername(username);
        exam.setUser(optionalUser.get());
        examService.save(exam);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/updateExam")
    public ResponseEntity<Exam> updateExam(@RequestParam("username") String username, @RequestParam("examId") Long examId, @RequestBody Exam exam)
    {
        Optional<User> optionalUser = userService.findUserByUsername(username);
        Optional<Exam> optionalExam = examService.findById(examId);
        optionalExam.get().setId(examId);
        optionalExam.get().setUser(optionalUser.get());
        optionalExam.get().setQuestions(exam.getQuestions());
        return new ResponseEntity<>(examService.save(optionalExam.get()),HttpStatus.OK);
    }



}
