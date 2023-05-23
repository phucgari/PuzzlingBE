package com.casestudymodule6.service.question;

import com.casestudymodule6.model.question.Question;
import com.casestudymodule6.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService
{

    @Autowired
    private IQuestionRepository questionRepository;
    @Override
    public Iterable<Question> findAll()
    {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void remove(Long id)
    {
        questionRepository.deleteById(id);
    }
}
