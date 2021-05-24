package com.xingqing.buy.mapper.erp;

import com.xingqing.buy.model.ErpLackProduct;
import com.xingqing.buy.model.LackProduct;
import com.xingqing.buy.model.Test;
import com.xingqing.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;


public interface ErpLackProdutMapper {

    /**
     * 获取所有的缺货信息
     *
     * @return
     */
    @Select("select DISTINCT product.spid AS spid ,product.spbh,spmch,zjm,dw,shpchd,shpgg,pizhwh,jlgg,bzgg,last_dwbh,sale.zhdwmch AS gjdwmc,kcsx,kcxx,kcshl,sale.xsshl1 AS onesalenum,sale.xsshl2 AS threesalenum,zhjj,zgjj,zdjj,ywy from spkfk AS product inner JOIN spkfjc AS storage ON product.spid=storage.spid JOIN sp_SaleMsg AS sale ON sale.spid=product.spid  WHERE kcshl<=kcxx AND beactive ='是' AND sale.xsshl2 > 0")
    List<ErpLackProduct> getAllLackProduct();

    /**
     * 根据产品编码 查询入库信息
     * @param productId
     * @return
     */
    @Select("SELECT TOP #{time} mx.djbh,spid,hz.dwbh,mchk.dwmch, mx.rq,shl,mx.je,mx.dj FROM jh_rkmx AS mx JOIN jh_rkhz AS hz ON mx.djbh=hz.djbh JOIN mchk ON mchk.dwbh=hz.dwbh \n" +
            "\n" +
            "WHERE spid=#{productId} ORDER BY rq desc")
    List<HashMap<String,String>> getBuyCompany(String productId,Integer time);
}
