package com.xingqing.buy.model;

import javax.persistence.Table;
import java.util.Date;

/**
 * 购进单位
 */
@Table(name ="mchk")
public class ErpBuyCompany {
    private String dwbh;//编码
    private String dwmch;//名称
    private String zjm;//助记码
    private String telno;
    private String dzhdh;//单位地址
    private String ywy;//业务员
    private String jingyfw;//经营范围
    private String wtr;//联系人

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    public String getDwmch() {
        return dwmch;
    }

    public void setDwmch(String dwmch) {
        this.dwmch = dwmch;
    }

    public String getZjm() {
        return zjm;
    }

    public void setZjm(String zjm) {
        this.zjm = zjm;
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy;
    }

    public String getJingyfw() {
        return jingyfw;
    }

    public void setJingyfw(String jingyfw) {
        this.jingyfw = jingyfw;
    }

    public String getWtr() {
        return wtr;
    }

    public void setWtr(String wtr) {
        this.wtr = wtr;
    }


    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getDzhdh() {
        return dzhdh;
    }

    public void setDzhdh(String dzhdh) {
        this.dzhdh = dzhdh;
    }

}
