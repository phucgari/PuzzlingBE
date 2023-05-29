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

}
