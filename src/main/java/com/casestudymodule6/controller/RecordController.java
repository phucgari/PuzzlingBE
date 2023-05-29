package com.casestudymodule6.controller;

import com.casestudymodule6.model.record.Record;
import com.casestudymodule6.model.record.RecordDetail;
import com.casestudymodule6.service.exam.IExamService;
import com.casestudymodule6.service.record.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        int scoreSumOfExam = examService.scoreSumOfExam(record.getExam().getId());
        int scoreSumOfUser = recordService.scoreSumOfUser(record.getRecordDetails());
        record.setExamPoint(scoreSumOfExam);
        record.setUserPoint(scoreSumOfUser);
        return new ResponseEntity<>(recordService.save(record),HttpStatus.OK);
    }
}
