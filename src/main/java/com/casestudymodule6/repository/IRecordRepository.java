package com.casestudymodule6.repository;


import com.casestudymodule6.model.record.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRecordRepository extends JpaRepository<Record, Long>
{

    @Query(nativeQuery = true, value = "select * from quiz.record record join quiz.user u on u.id = record.user_id" +
            " "+"join quiz.exam e on record.exam_id = e.id"+
            " "+"where record.exam_id = :examId and record.user_id = :userId")
    Optional<Record> findRecordByExamId(@Param("userId") Long userId,@Param("examId") Long examId);

}
