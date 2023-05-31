package com.casestudymodule6.controller;

import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.user.User;
import com.casestudymodule6.service.exam.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/puzzling/exam")
public class ExamController
{
    @Autowired
    private IExamService examService;


    @GetMapping("/list")
    public ResponseEntity<List<Exam>> getAllExams(@RequestParam User user)
    {
        List<Exam> exams =(List<Exam>) examService.findExamsByUser(user);
        return new ResponseEntity<>(exams,HttpStatus.OK);
    }


    @GetMapping("/info")
    public ResponseEntity<Exam> infoExam(@RequestParam("examId") Long examId)
    {
        Optional<Exam> optionalExam = examService.findById(examId);
        return new ResponseEntity<>(optionalExam.get(),HttpStatus.OK);
    }

    @PostMapping(value ="/create")
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam)
    {
        return new ResponseEntity<>(examService.save(exam),HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Exam> updateExam(@RequestParam("examId") Long examId, @RequestBody Exam exam)
    {
        Optional<Exam> optionalExam = examService.findById(examId);
        optionalExam.get().setName(exam.getName());
        optionalExam.get().setCategory(exam.getCategory());
        optionalExam.get().setQuestions(exam.getQuestions());
        return new ResponseEntity<>(examService.save(optionalExam.get()),HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Exam> deleteExam(@RequestParam("examId") Long examId)
    {
        examService.remove(examId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/randomExam")
    public ResponseEntity<Exam> randomExam()
    {
        Exam exam = examService.findRandomExam();

        if (exam == null)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(exam,HttpStatus.OK);
        }
    }
}
