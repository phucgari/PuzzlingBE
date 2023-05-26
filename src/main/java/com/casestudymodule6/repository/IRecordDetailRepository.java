package com.casestudymodule6.repository;


import com.casestudymodule6.model.record.RecordDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecordDetailRepository extends JpaRepository<RecordDetail, Long>
{
    @Query("select recordDetail from RecordDetail recordDetail join recordDetail.record record where record.id = :recordId")
    Iterable<RecordDetail> findRecordDetailByRecordId(@Param("recordId") Long recordId);

}
