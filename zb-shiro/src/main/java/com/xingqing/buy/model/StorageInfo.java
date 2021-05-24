package com.xingqing.buy.model;

import javax.persistence.Table;
import java.util.Date;

@Table(name= "proudct_keyinfo")
public class StorageInfo {
    private Integer id;
    private String code;//产品编码
    private Integer storagenum;//库存数量
    private String avgnum;//平均量
    private String downnum;//下限
    private String upnum;//上限
    private Float price;
    private Float downprice;//
    private Float upprice;
    private Float lastprice;
    private Date create_time;
    private Integer lastbuyer;//业务员

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStoragenum() {
        return storagenum;
    }

    public void setStoragenum(Integer storagenum) {
        this.storagenum = storagenum;
    }

    public String getAvgnum() {
        return avgnum;
    }

    public void setAvgnum(String avgnum) {
        this.avgnum = avgnum;
    }

    public String getDownnum() {
        return downnum;
    }

    public void setDownnum(String downnum) {
        this.downnum = downnum;
    }

    public String getUpnum() {
        return upnum;
    }

    public void setUpnum(String upnum) {
        this.upnum = upnum;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDownprice() {
        return downprice;
    }

    public void setDownprice(Float downprice) {
        this.downprice = downprice;
    }

    public Float getUpprice() {
        return upprice;
    }

    public void setUpprice(Float upprice) {
        this.upprice = upprice;
    }

    public Float getLastprice() {
        return lastprice;
    }

    public void setLastprice(Float lastprice) {
        this.lastprice = lastprice;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getLastbuyer() {
        return lastbuyer;
    }

    public void setLastbuyer(Integer lastbuyer) {
        this.lastbuyer = lastbuyer;
    }


}
