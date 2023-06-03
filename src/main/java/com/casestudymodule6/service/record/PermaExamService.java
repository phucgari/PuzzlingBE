package com.casestudymodule6.service.record;

import com.casestudymodule6.model.record.PermaExam;
import com.casestudymodule6.repository.IPermaExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PermaExamService implements IPermaExamService{
    @Autowired
    IPermaExamRepository permaExamRepository;
    @Override
    public Iterable<PermaExam> findAll() {
        return permaExamRepository.findAll();
    }

    @Override
    public Optional<PermaExam> findById(Long id) {
        return permaExamRepository.findById(id);
    }

    @Override
    public PermaExam save(PermaExam permaExam) {
        return permaExamRepository.save(permaExam);
    }

    @Override
    public void remove(Long id) {
        permaExamRepository.deleteById(id);
    }
}
