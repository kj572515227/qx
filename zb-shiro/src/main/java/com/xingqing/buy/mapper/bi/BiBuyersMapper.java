package com.xingqing.buy.mapper.bi;

import com.xingqing.buy.model.BuyCompany;
import com.xingqing.buy.model.Product;
import com.xingqing.util.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BiBuyersMapper extends MyMapper<BuyCompany> {

    @Select("select * from buyers where code=#{code} ")
    BuyCompany selectByCode(String code);

    @Insert("<script> insert into buyers (code,name,tel,zjm,address,ywy,scope,contact,incode,create_time) values  " +
            "  <foreach collection='buyCompanies' item='item' separator=',' > " +
            "  (#{item.code},#{item.name},#{item.tel},#{item.zjm},#{item.address},#{item.ywy},#{item.scope},#{item.contact},#{item.incode},#{item.create_time} )" +
            "  </foreach> </script>")
    void insertBuyCompanys(@Param(value = "buyCompanies")List<BuyCompany> buyCompanies);


    /**
     * 清空表的数据。
     */
    @Update("truncate table buyers")
    void truncateTable();

}
