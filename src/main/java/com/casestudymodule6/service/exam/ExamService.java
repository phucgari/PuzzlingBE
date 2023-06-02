package com.casestudymodule6.service.exam;


import com.casestudymodule6.model.question.Category;
import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.question.Question;
import com.casestudymodule6.model.user.User;
import com.casestudymodule6.repository.IExamRepository;
import com.casestudymodule6.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
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
    public Iterable<Exam> findExamsByCategoryAndUser(Category category, User user) {
        return examRepository.findExamsByCategoryAndUser(category,user);
    }

    @Override
    public Iterable<Exam> findExamsRandomByCategory(Category category) {
        return examRepository.findExamsRandomByCategory(category);
    }

    @Override
    public int scoreSumOfExam(Long examId)
    {
        Set<Question> questions = questionRepository.findQuestionByExamId(examId);
        return questions.stream().mapToInt(question -> question.getLevel().getScore()).sum();
    }

    @Override
    public Exam findRandomExam()
    {
        Random random = new Random();
        List<Exam> examList = (List<Exam>) findAll();
        Exam exam = examList.get(random.nextInt(examList.size()));
        if (exam.getQuestions().size() >= 5)
        {
            return exam;
        }
        return null;
    }

}
