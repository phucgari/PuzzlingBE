package com.casestudymodule6.service.question;

import com.casestudymodule6.model.question.Question;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService
{

    @Override
    public Iterable<Question> findAll() {
        return null;
    }

    @Override
    public Optional<Question> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Question save(Question question) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
