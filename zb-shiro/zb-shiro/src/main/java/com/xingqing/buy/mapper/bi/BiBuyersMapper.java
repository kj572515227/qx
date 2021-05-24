package com.xingqing.buy.mapper.bi;

import com.xingqing.buy.model.BuyCompany;
import com.xingqing.buy.model.Product;
import com.xingqing.util.MyMapper;
import org.apache.ibatis.annotations.Select;

public interface BiBuyersMapper extends MyMapper<BuyCompany> {

    @Select("select * from buyers where code=#{code} ")
    BuyCompany selectByCode(String code);
}
