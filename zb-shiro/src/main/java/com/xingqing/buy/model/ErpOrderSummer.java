package com.xingqing.buy.model;

/**
 *CREATE TABLE [dbo].[jxddhz](
 *  Fkey int not null ,
 *  [djbh] [char](15) NOT NULL, 单据编号
 *  [rq] [char](10) NULL,  日期
 *  [dwbh] [char](11) NULL,  单位内码
 *  [is_zx] [char](2) NULL,  是否执行
 *  [bm] [varchar](20) NULL, 部门
 *  [ywy] [varchar](20) NULL, 采购员
 *  [username] [char](12) NULL, 操用员
 *  beizhu  varchar(100) null 备注
 * ) ON ps_bill(Fkey)
 */
public class ErpOrderSummer {
    private Integer Fkey;//订单Fkey

    private String bh ;//订单编号
    private String rq;//1.价格高。2超最高限量
    private String dwbh ;//单位内码
    private String is_zx ;// 是否执行,
    private String bm;//部门
    private String ywy ;//采购元
    private String username ;//操作元
    private String beizhu ;//备注


    public Integer getFkey() {
        return Fkey;
    }

    public void setFkey(Integer fkey) {
        Fkey = fkey;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getRq() {
        return rq;
    }

    public void setRq(String rq) {
        this.rq = rq;
    }

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    public String getIs_zx() {
        return is_zx;
    }

    public void setIs_zx(String is_zx) {
        this.is_zx = is_zx;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }


}
