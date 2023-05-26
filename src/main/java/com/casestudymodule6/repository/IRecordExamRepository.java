package com.casestudymodule6.repository;


import com.casestudymodule6.model.record.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecordExamRepository extends JpaRepository<Record, Long>
{

}
