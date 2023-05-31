package com.casestudymodule6.service.exam;

import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.user.User;
import com.casestudymodule6.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IExamService extends IGeneralService<Exam>
{
    Iterable<Exam> findExamsByUser(User user);

    int scoreSumOfExam(Long id);


    Optional<Exam> findRandomExam();

}
