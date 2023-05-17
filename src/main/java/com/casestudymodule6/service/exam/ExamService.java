package com.casestudymodule6.service.exam;


import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.repository.IExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExamService implements IExamService
{
    @Autowired
    private IExamRepository examRepository;

    @Override
    public Iterable<Exam> findAll() {
        return examRepository.findAll() ;
    }

    @Override
    public Optional<Exam> findById(Long id) {
        return examRepository.findById(id);
    }

    @Override
    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public void remove(Long id)
    {
       examRepository.deleteById(id);
    }

    @Override
    public Iterable<Exam> findExamsByUser(Long userId) {
        return examRepository.findExamsByUser(userId);
    }

}
