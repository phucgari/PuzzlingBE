package com.casestudymodule6.repository;


import com.casestudymodule6.dto.LeaderDTO;
import com.casestudymodule6.model.record.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRecordRepository extends JpaRepository<Record, Long>
{

    @Query(nativeQuery = true, value = "select * from quiz.record record join quiz.user u on u.id = record.user_id" +
            " "+"join quiz.exam e on record.exam_id = e.id"+
            " "+"where record.exam_id = :examId and record.user_id = :userId")
    Optional<Record> findRecordByExamId(@Param("userId") Long userId,@Param("examId") Long examId);


    @Query(nativeQuery = true, value = "select account.username as 'username',Max((record.user_point / record.exam_point) * 100) as 'score' from quiz.record record join quiz.user u on u.id = record.user_id" +" "+
            "join quiz.account account on account.user_id = u.id where record.exam_id = :examId group by account.username order by score desc limit 10")
    List<LeaderDTO> findAllUserByExam(@Param("examId") Long examId);

}
