package com.casestudymodule6.controller;


import com.casestudymodule6.model.question.MultiChoiceQuestion;
import com.casestudymodule6.model.question.OneChoiceQuestion;
import com.casestudymodule6.model.question.Question;
import com.casestudymodule6.service.question.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/puzzling/question")
public class QuestionController
{
    @Autowired
    private IQuestionService questionService;

    @PostMapping("/createQuestionOneChoice")
    public ResponseEntity<Question> questionOneChoice(@RequestBody OneChoiceQuestion oneChoiceQuestion)
    {
        questionService.save(oneChoiceQuestion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/createQuestionMultipleChoice")
    public ResponseEntity<Question> questionMultipleChoice(@RequestBody MultiChoiceQuestion multiChoiceQuestion)
    {
        questionService.save(multiChoiceQuestion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
