package com.casestudymodule6.controller;

import com.casestudymodule6.dto.LeaderDTO;
import com.casestudymodule6.model.record.Record;
import com.casestudymodule6.service.exam.IExamService;
import com.casestudymodule6.service.record.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/puzzling/record")
public class RecordController
{

    @Autowired
    private IExamService examService;

    @Autowired
    private IRecordService recordService;

    @PostMapping("/createExamResult")
    public ResponseEntity<Record> getExamResult(@RequestBody Record record)
    {
        LocalDateTime current=LocalDateTime.now();
        int scoreSumOfExam = examService.scoreSumOfExam(record.getExam().getId());
        int scoreSumOfUser = recordService.scoreSumOfUser(record.getRecordDetail());
        record.setExamPoint(scoreSumOfExam);
        record.setUserPoint(scoreSumOfUser);
        record.setTime(current);
        recordService.save(record);
        return new ResponseEntity<>(record,HttpStatus.OK);
    }
    @GetMapping("/watchExamResult/{userId}/{examId}")
    public ResponseEntity<Record> watchExamResult(@PathVariable("userId") Long userId,@PathVariable("examId") Long examId)
    {
        Optional<Record> record = recordService.findRecordByExamId(userId, examId);
        return new ResponseEntity<>(record.get(),HttpStatus.OK);
    }
    @GetMapping("/leaderboard/{examId}")
    public ResponseEntity<List<LeaderDTO>> leaderboard(@PathVariable("examId") Long examId)
    {
        return new ResponseEntity<>(recordService.findAllUserByExam(examId),HttpStatus.OK);
    }

}
