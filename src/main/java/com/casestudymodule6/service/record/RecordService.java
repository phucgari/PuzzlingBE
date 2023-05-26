package com.casestudymodule6.service.record;

import com.casestudymodule6.model.question.Option;
import com.casestudymodule6.model.question.Question;
import com.casestudymodule6.model.record.Answer;
import com.casestudymodule6.model.record.Record;
import com.casestudymodule6.model.record.RecordDetail;
import com.casestudymodule6.repository.IRecordDetailRepository;
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

    @Autowired
    private IRecordDetailRepository recordDetailRepository;

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
    public Iterable<RecordDetail> findRecordDetailByRecordId(Long recordId) {
        return recordDetailRepository.findRecordDetailByRecordId(recordId);
    }

    @Override
    public int scoreSumOfUser(Iterable<RecordDetail> recordDetails)
    {
        List<RecordDetail> recordDetailList = (List<RecordDetail>) recordDetails;

        int scoreOfUser = 0;

        for (RecordDetail rs: recordDetailList)
        {
            for (Answer answer: rs.getAnswers())
            {
                if (answer.getOption().getStatus().equals(answer.getAnswerStatus()) && answer.getOption().getStatus().equals("true"))
                {
                    if (rs.getQuestion().getLevel() == Question.Level.EASY)
                    {
                        scoreOfUser++;
                    }
                    else if (rs.getQuestion().getLevel() == Question.Level.MEDIUM)
                    {

                        scoreOfUser+=2;
                    }
                    else
                    {
                        scoreOfUser+=5;
                    }
                }

            }

        }

        return scoreOfUser;
    }


}
