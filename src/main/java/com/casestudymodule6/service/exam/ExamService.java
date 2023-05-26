package com.casestudymodule6.service.exam;


import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.question.Question;
import com.casestudymodule6.model.user.User;
import com.casestudymodule6.repository.IExamRepository;
import com.casestudymodule6.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        int scoreSum = 0;
        for (Question question: questions)
        {
            if (question.getLevel() == Question.Level.EASY)
            {
                scoreSum++;
            }
            else if (question.getLevel() == Question.Level.MEDIUM)
            {
                scoreSum+= 2;
            }
            else
            {
                scoreSum+= 5;
            }
        }
        return scoreSum;
    }
}
