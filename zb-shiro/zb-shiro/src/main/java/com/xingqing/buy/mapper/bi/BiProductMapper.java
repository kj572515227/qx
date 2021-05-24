package com.xingqing.buy.mapper.bi;

import com.xingqing.buy.model.Product;
import com.xingqing.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BiProductMapper extends MyMapper<Product> {

    @Select("select * from Product where code=#{code} ")
    Product selectByCode(String code);
}
