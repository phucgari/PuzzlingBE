package com.casestudymodule6.controller;

import com.casestudymodule6.model.dto.RecordDTO;
import com.casestudymodule6.model.record.Record;
import com.casestudymodule6.model.record.RecordDetail;
import com.casestudymodule6.service.exam.IExamService;
import com.casestudymodule6.service.record.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Record> getExamResult(@RequestBody RecordDTO recordDTO)
    {
        Record record = new Record();
        int scoreSumOfExam = examService.scoreSumOfExam(recordDTO.getExam().getId());
        int scoreSumOfUser = recordService.scoreSumOfUser(recordDTO.getRecordDetais());
        record.setExam(recordDTO.getExam());
        record.setExamPoint(scoreSumOfExam);
        record.setUserPoint((scoreSumOfUser));
        record.setUser(recordDTO.getUser());
        record.setSubmitTime(recordDTO.getSubmitTime());
        return new ResponseEntity<>(recordService.save(record),HttpStatus.OK);
    }

}
