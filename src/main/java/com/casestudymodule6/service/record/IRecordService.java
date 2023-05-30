package com.casestudymodule6.service.record;

import com.casestudymodule6.dto.LeaderDTO;
import com.casestudymodule6.model.record.Record;
import com.casestudymodule6.model.record.RecordDetail;
import com.casestudymodule6.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IRecordService extends IGeneralService<Record>
{


    int scoreSumOfUser(Iterable<RecordDetail> recordDetails);


    List<LeaderDTO> findAllUserByExam(Long examId);




}
