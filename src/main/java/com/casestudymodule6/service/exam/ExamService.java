package com.casestudymodule6.service.exam;


import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.question.Question;
import com.casestudymodule6.model.user.User;
import com.casestudymodule6.repository.IExamRepository;
import com.casestudymodule6.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ExamService implements IExamService
{
    @Autowired
    private IExamRepository examRepository;


    @Autowired
    private IQuestionRepository questionRepository;

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
    public Iterable<Exam> findExamsByUser(User user) {
        return examRepository.findExamsByUser(user);
    }

    @Override
    public int scoreSumOfExam(Long examId)
    {
        Set<Question> questions = questionRepository.findQuestionByExamId(examId);
        return questions.stream().mapToInt(question -> question.getLevel().getScore()).sum();
    }

    @Override
    public Optional<Exam> findRandomExam()
    {
        List<Exam> examList = (List<Exam>)findAll();
        return Optional.empty();
    }
}
