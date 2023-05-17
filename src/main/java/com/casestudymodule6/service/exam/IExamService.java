package com.casestudymodule6.service.exam;

import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IExamService extends IGeneralService<Exam>
{
    Iterable<Exam> findExamsByUser(@Param("userId") Long userId);

    Optional<Exam> findExamByUser(@Param("userId") Long userId);
}
