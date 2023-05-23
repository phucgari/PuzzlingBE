package com.casestudymodule6.controller;

import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.question.ExamDTO;
import com.casestudymodule6.model.user.User;
import com.casestudymodule6.service.exam.IExamService;
import com.casestudymodule6.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/puzzling/exam")
public class ExamController
{
    @Autowired
    private IExamService examService;

    @Autowired
    private IUserService userService;


    @GetMapping("/examListByUser")
    public ResponseEntity<List<ExamDTO>> getAllExams(@RequestParam("username") String username)
    {
        List<Exam> exams =(List<Exam>) examService.findExamsByUsername(username);

        List<ExamDTO> examDTOs = exams.stream().map(ExamDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(examDTOs,HttpStatus.OK);
    }


    @GetMapping("/infoExam")
    public ResponseEntity<Exam> infoExam(@RequestParam("examId") Long examId)
    {
        Optional<Exam> optionalExam = examService.findById(examId);
        return new ResponseEntity<>(optionalExam.get(),HttpStatus.OK);
    }

    @PostMapping(value ="/createExam")
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam)
    {
        return new ResponseEntity<>(examService.save(exam),HttpStatus.CREATED);
    }
    @PutMapping("/updateExam")
    public ResponseEntity<Exam> updateExam(@RequestParam("examId") Long examId, @RequestBody Exam exam)
    {
        Optional<Exam> optionalExam = examService.findById(examId);
        optionalExam.get().setName(exam.getName());
        optionalExam.get().setCategory(exam.getCategory());
        optionalExam.get().setQuestions(exam.getQuestions());
        return new ResponseEntity<>(examService.save(optionalExam.get()),HttpStatus.OK);
    }
    @DeleteMapping("/deleteExam")
    public ResponseEntity<Exam> deleteExam(@RequestParam("examId") Long examId)
    {
        examService.remove(examId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
