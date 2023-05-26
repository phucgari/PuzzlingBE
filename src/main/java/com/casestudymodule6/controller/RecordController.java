package com.casestudymodule6.controller;

import com.casestudymodule6.model.dto.RecordDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/puzzling/record")
public class RecordController
{

    @PostMapping("/createExamResult")
    public ResponseEntity<RecordDTO> getExamResult(@RequestBody RecordDTO recordDTO)
    {

        return new ResponseEntity<>(HttpStatus.OK);
    }




}
