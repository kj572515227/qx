package com.xingqing.buy.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name="zhiydoc")
public class ErpUser {
    private String dzycode;
    private String dzyname;
    private String zjm;

    public String getDzycode() {
        return dzycode;
    }

    public void setDzycode(String dzycode) {
        this.dzycode = dzycode;
    }

    public String getDzyname() {
        return dzyname;
    }

    public void setDzyname(String dzyname) {
        this.dzyname = dzyname;
    }

    public String getZjm() {
        return zjm;
    }

    public void setZjm(String zjm) {
        this.zjm = zjm;
    }



}
