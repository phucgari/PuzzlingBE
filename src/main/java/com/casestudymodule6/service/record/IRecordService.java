package com.casestudymodule6.service.record;

import com.casestudymodule6.model.record.Record;
import com.casestudymodule6.model.record.RecordDetail;
import com.casestudymodule6.service.IGeneralService;

public interface IRecordService extends IGeneralService<Record>
{

    int scoreSumOfUser(Iterable<RecordDetail> recordDetails);







}
