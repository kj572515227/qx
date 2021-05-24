package com.xingqing.buy.model;

import lombok.Data;

import javax.persistence.Table;

/**
 * erp的产品 信息表
 */
@Data
@Table(name="spkfk")
public class ErpProduct {
    private String spid;//商品id
    private String sptm;//商品条码
    private String spmch;//商品名称
    private String zjm;//助记码
    private String dw;//单位
    private String shpchd;//商品产地
    private String shpgg;//商品规格
    private String pizhwh;//国药准字
    private String leibie;//10.抗生素，11，20中成药30.生物制品
    private Integer jlgg;//件装量
    private String jj;//进价
    private String ywy;//采购员 编码
    private String zuidshj;//最低售价
    private String shdjg;//设定价格 chuffl
    private String chuffl;//处方分类
    private String shengccj;//生产厂家
    private String last_dwbh;//最后一次购进单位编码


    public String getLast_dwbh() {
        return last_dwbh;
    }

    public void setLast_dwbh(String last_dwbh) {
        this.last_dwbh = last_dwbh;
    }



    public String getShengccj() {
        return shengccj;
    }

    public void setShengccj(String shengccj) {
        this.shengccj = shengccj;
    }



    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getSptm() {
        return sptm;
    }

    public void setSptm(String sptm) {
        this.sptm = sptm;
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

    public String getLeibie() {
        return leibie;
    }

    public void setLeibie(String leibie) {
        this.leibie = leibie;
    }

    public Integer getJlgg() {
        return jlgg;
    }

    public void setJlgg(Integer jlgg) {
        this.jlgg = jlgg;
    }

    public String getJj() {
        return jj;
    }

    public void setJj(String jj) {
        this.jj = jj;
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy;
    }

    public String getZuidshj() {
        return zuidshj;
    }

    public void setZuidshj(String zuidshj) {
        this.zuidshj = zuidshj;
    }

    public String getShdjg() {
        return shdjg;
    }

    public void setShdjg(String shdjg) {
        this.shdjg = shdjg;
    }

    public String getChuffl() {
        return chuffl;
    }

    public void setChuffl(String chuffl) {
        this.chuffl = chuffl;
    }

    public String getSpmch() {
        return spmch;
    }

    public void setSpmch(String spmch) {
        this.spmch = spmch;
    }


}
