package com.casestudymodule6.repository;

import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IExamRepository extends JpaRepository<Exam, Long>
{
      @Query("select exam from Exam exam join exam.user user where user.account.username = :username")
      Iterable<Exam> findExamsByUsername(@Param("username") String username);


}
