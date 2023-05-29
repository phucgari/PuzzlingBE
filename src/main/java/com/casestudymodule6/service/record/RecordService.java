package com.casestudymodule6.service.record;

import com.casestudymodule6.model.question.Question;
import com.casestudymodule6.model.record.Answer;
import com.casestudymodule6.model.record.Record;
import com.casestudymodule6.model.record.RecordDetail;
import com.casestudymodule6.repository.IRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService implements IRecordService
{
    @Autowired
    private IRecordRepository recordRepository;


    @Override
    public Iterable<Record> findAll() {
        return recordRepository.findAll();
    }

    @Override
    public Optional<Record> findById(Long id) {
        return recordRepository.findById(id);
    }

    @Override
    public Record save(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public void remove(Long id)
    {
       recordRepository.deleteById(id);
    }


    @Override
    public int scoreSumOfUser(Iterable<RecordDetail> recordDetails)
    {
        List<RecordDetail> recordDetailList = (List<RecordDetail>) recordDetails;

        int scoreOfUser = 0;

        for (RecordDetail rs: recordDetailList)
        {
            boolean checkAnswer = true;
            for (Answer answer: rs.getAnswers())
            {
                if (answer.getOption().getStatus().equals(answer.getAnswerStatus()))
                {
                    switch (rs.getQuestion().getLevel())
                    {
                        case EASY -> scoreOfUser++;
                        case MEDIUM -> scoreOfUser += 2;
                        default -> scoreOfUser += 5;
                    }
                }
                else
                {
                    checkAnswer = false;
                }
            }
            if (!checkAnswer)
            {
                break;
            }
        }
        return scoreOfUser;
    }


}
