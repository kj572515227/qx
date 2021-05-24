package com.xingqing.buy.model;

import javax.persistence.Table;

@Table(name="ask")
public class Ask {
    private Integer id;
    private String pcode ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }


}
