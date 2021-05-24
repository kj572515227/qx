package com.xingqing.buy.mapper.bi;

import com.xingqing.buy.model.LackProduct;
import com.xingqing.util.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BiLackProudctMapper extends MyMapper<LackProduct> {

    /**
     * 清空表的数据。
     */
    @Update("truncate table lack_product")
    void truncateTable();

    @Select("SELECT DISTINCT insidecode,code,name,factory,gyzhunzi,spec,dw,bzgg,packnum,stock,lastbuycompany,lastprice,ywy,lastcompanycode,upnum,downnum,onesalenum,threesalenum,downprice,upprice,create_time FROM xingqingbi.lack_product where ywy like concat(\"%\",(select username from user where user_id= #{userid}),\"%\")")
    List<LackProduct> getLackProductByUserName(String userid);

    @Insert("<script> insert into lack_product (insidecode,code,name,factory,gyzhunzi,spec,dw,bzgg,packnum,stock,lastbuycompany,lastprice,ywy,lastcompanycode,upnum,downnum,onesalenum,threesalenum,downprice,upprice,create_time) values  " +
            "  <foreach collection='lackProducts' item='item' separator=',' > " +
            "  (#{item.insidecode},#{item.code},#{item.name},#{item.factory},#{item.gyzhunzi},#{item.spec},#{item.dw},#{item.bzgg},#{item.packnum},#{item.stock},#{item.lastbuycompany},#{item.lastprice},#{item.ywy},#{item.lastcompanycode},#{item.upnum},#{item.downnum},#{item.onesalenum},#{item.threesalenum},#{item.downprice},#{item.upprice},#{item.create_time})\n" +
            "  </foreach> </script>")
    void intserList(@Param(value = "lackProducts")List<LackProduct> lackProducts);
}
