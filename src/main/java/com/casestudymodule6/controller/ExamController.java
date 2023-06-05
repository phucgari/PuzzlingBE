package com.casestudymodule6.controller;

import com.casestudymodule6.model.question.Category;
import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.user.User;
import com.casestudymodule6.service.exam.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<String> createExam(@RequestBody Exam exam)
    {
        Optional<Exam> ex = examService.findExamByUserAndName(exam.getUser(), exam.getName());
        if (ex.isPresent())
        {
            return new ResponseEntity<>("NO",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("OK",HttpStatus.OK);
        }
    }
    @PutMapping("/update")
    @PreAuthorize("@authorizationEvaluator.canUpdateThisExam(#examId)")
    public ResponseEntity<Exam> updateExam(@RequestParam("examId") Long examId, @RequestBody Exam exam)
    {
        Optional<Exam> optionalExam = examService.findById(examId);
        optionalExam.get().setName(exam.getName());
        optionalExam.get().setCategory(exam.getCategory());
        optionalExam.get().setQuestions(exam.getQuestions());
        return new ResponseEntity<>(examService.save(optionalExam.get()),HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    @PreAuthorize("@authorizationEvaluator.canUpdateThisExam(#examId)")
    public ResponseEntity<Exam> deleteExam(@RequestParam("examId") Long examId)
    {
        examService.remove(examId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/searchExamsByCategoryAndUser")
    public ResponseEntity<List<Exam>> searchExamsByCategoryAndUser(@RequestParam("categoriesId") Category category, @RequestParam("userId") User user)
    {
        List<Exam> exams = (List<Exam>) examService.findExamsByCategoryAndUser(category, user);
        if (exams.size() == 0)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(exams,HttpStatus.OK);
        }
    }
    @GetMapping("/searchExamsByCategory")
    public ResponseEntity<List<Exam>> searchExamsByCategory(@RequestParam("categoriesId") Category category)
    {
         List<Exam> exams = (List<Exam>)examService.findExamsByCategory(category);
         if (exams.size() == 0)
         {
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }
         else
         {
             return new ResponseEntity<>(exams,HttpStatus.OK);
         }

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
