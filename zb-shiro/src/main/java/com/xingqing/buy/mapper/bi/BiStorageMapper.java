package com.xingqing.buy.mapper.bi;

import com.xingqing.buy.model.BuyCompany;
import com.xingqing.buy.model.StorageInfo;
import com.xingqing.util.MyMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BiStorageMapper extends MyMapper<StorageInfo> {
    /**
     * 清空表的数据。
     */
    @Update("truncate table proudct_keyinfo")
    void truncateTable();
}
