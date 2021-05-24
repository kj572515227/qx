package com.xingqing.buy.model;

import javax.persistence.Table;

/**
 select product.spid AS spid ,spmch,zjm,dw,shpchd,shpgg,pizhwh,jlgg,bzgg,last_dwbh,sale.zhdwmch AS gjdwmc,
 kcsx,kcxx,kcshl,sale.xsshl1 AS onesalenum,sale.xsshl2 AS threesalenum,zgjj,zdjj,ywy
 from spkfk AS product inner JOIN spkfjc AS storage ON product.spid=storage.spid
 JOIN sp_SaleMsg AS sale ON sale.spid=product.spid  WHERE kcshl<=kcxx AND beactive ='是' AND sale.xsshl2 > 0
 * 购进单位
 */
public class ErpLackProduct {
    private String spid;//商品id
    private String spbh;//商品内部编码
    private String spmch;//商品名称
    private String zjm;//助记码
    private String dw;//单位
    private String shpchd;//商品产地
    private String shpgg;//商品规格
    private String pizhwh;//国药准字
    private Integer bzgg;//包装规格
    private Integer kcshl;//库存数量
    private String gjdwmc;//购进单位名称
    private String last_dwbh;//最后一次购进单位编码
    private Integer kcsx;//库存上限
    private Integer kcxx;//库存下线
    private Integer onesalenum;//1月销量
    private Integer threesalenum;//3月销量
    private Integer jlgg;//件装量
    private String ywy;//采购员 编码
    private float zgjj;//最高进价
    private float zdjj;//最低价格 chuffl
    private float zhjj;//最后价格


    public String getSpbh() {
        return spbh;
    }

    public void setSpbh(String spbh) {
        this.spbh = spbh;
    }


    public float getZhjj() {
        return zhjj;
    }

    public void setZhjj(float zhjj) {
        this.zhjj = zhjj;
    }


    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getSpmch() {
        return spmch;
    }

    public void setSpmch(String spmch) {
        this.spmch = spmch;
    }

    public String getZjm() {
        return zjm;
    }

    public void setZjm(String zjm) {
        this.zjm = zjm;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getShpchd() {
        return shpchd;
    }

    public void setShpchd(String shpchd) {
        this.shpchd = shpchd;
    }

    public String getShpgg() {
        return shpgg;
    }

    public void setShpgg(String shpgg) {
        this.shpgg = shpgg;
    }

    public String getPizhwh() {
        return pizhwh;
    }

    public void setPizhwh(String pizhwh) {
        this.pizhwh = pizhwh;
    }

    public Integer getBzgg() {
        return bzgg;
    }

    public void setBzgg(Integer bzgg) {
        this.bzgg = bzgg;
    }

    public Integer getKcshl() {
        return kcshl;
    }

    public void setKcshl(Integer kcshl) {
        this.kcshl = kcshl;
    }

    public String getGjdwmc() {
        return gjdwmc;
    }

    public void setGjdwmc(String gjdwmc) {
        this.gjdwmc = gjdwmc;
    }

    public Integer getKcsx() {
        return kcsx;
    }

    public void setKcsx(Integer kcsx) {
        this.kcsx = kcsx;
    }

    public Integer getKcxx() {
        return kcxx;
    }

    public void setKcxx(Integer kcxx) {
        this.kcxx = kcxx;
    }

    public Integer getOnesalenum() {
        return onesalenum;
    }

    public void setOnesalenum(Integer onesalenum) {
        this.onesalenum = onesalenum;
    }

    public Integer getThreesalenum() {
        return threesalenum;
    }

    public void setThreesalenum(Integer threesalenum) {
        this.threesalenum = threesalenum;
    }

    public Integer getJlgg() {
        return jlgg;
    }

    public void setJlgg(Integer jlgg) {
        this.jlgg = jlgg;
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy;
    }

    public float getZgjj() {
        return zgjj;
    }

    public void setZgjj(float zgjj) {
        this.zgjj = zgjj;
    }

    public float getZdjj() {
        return zdjj;
    }

    public void setZdjj(float zdjj) {
        this.zdjj = zdjj;
    }

    public String getLast_dwbh() {
        return last_dwbh;
    }

    public void setLast_dwbh(String last_dwbh) {
        this.last_dwbh = last_dwbh;
    }



}
