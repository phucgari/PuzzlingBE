package com.casestudymodule6.repository;

import com.casestudymodule6.model.question.Exam;
import com.casestudymodule6.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExamRepository extends JpaRepository<Exam, Long>
{
      Iterable<Exam> findExamsByUser(User user);

}
