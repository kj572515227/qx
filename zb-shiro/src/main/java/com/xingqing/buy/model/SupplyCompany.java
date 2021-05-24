package com.xingqing.buy.model;

import java.util.Date;

/**
 * SELECT TOP 10 mx.djbh,spid,hz.dwbh,mchk.dwmch, mx.rq,shl,mx.je,mx.dj

 *
 * WHERE spid='SPH00003760' ORDER BY rq desc
 */
public class SupplyCompany {
    private String productcode;
    private String buycode;//购进编码
    private String buyname;//购进单位名称
    private String time;//购进日期
    private String price;//价格
    private String total;//总价
    private Integer num;//数量

    public String getBuycode() {
        return buycode;
    }

    public void setBuycode(String buycode) {
        this.buycode = buycode;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }


    public String getBuyname() {
        return buyname;
    }

    public void setBuyname(String buyname) {
        this.buyname = buyname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}
