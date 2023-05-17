package com.casestudymodule6.repository;

import com.casestudymodule6.model.question.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IExamRepository extends JpaRepository<Exam, Long>
{
      @Query("select exam from Exam exam join exam.user user where user.id = :userId ")
      Iterable<Exam> findExamsByUser(@Param("userId") Long userId);


     @Query("select exam from Exam exam join exam.user user where user.id = :userId ")
     Optional<Exam> findExamByUser(@Param("userId") Long userId);

}
