package com.xingqing.buy.model;



import javax.persistence.*;
import java.util.Date;

/**
 * 对应缺货管理主界面字段
 */
@Table(name="lack_product")
public class LackProduct {
    @Id
    private Integer id;//产品id

    private String insidecode;//商品内部编码
    private String code;//产品code。
    private String name;
    private String factory;
    private String gyzhunzi;
    private String spec;//商品规格
    private String dw;
    private Integer bzgg;//包装规格
    private Integer packnum;//件装量
    private Integer stock;//库存
    private String lastbuycompany;
    private Float lastprice;
    private String ywy;//业务员编码
    private String lastcompanycode;
    private Integer upnum;//库存上限
    private Integer downnum;//库存下线
    private Integer onesalenum;//1月销量
    private Integer threesalenum;//3月销量
    private Float downprice;//最di进价
    private Float upprice;//
    @Transient
    private Integer status;//缺货状态
    @Transient
    private Integer lacknum;//缺货状态
    private Date create_time;



    public Integer getLacknum() {
        return lacknum;
    }

    public void setLacknum(Integer lacknum) {
        this.lacknum = lacknum;
    }

    public String getInsidecode() {
        return insidecode;
    }

    public void setInsidecode(String insidecode) {
        this.insidecode = insidecode;
    }

    public Integer getUpnum() {
        return upnum;
    }

    public void setUpnum(Integer upnum) {
        this.upnum = upnum;
    }

    public Integer getDownnum() {
        return downnum;
    }

    public void setDownnum(Integer downnum) {
        this.downnum = downnum;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getGyzhunzi() {
        return gyzhunzi;
    }

    public void setGyzhunzi(String gyzhunzi) {
        this.gyzhunzi = gyzhunzi;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public Integer getBzgg() {
        return bzgg;
    }

    public void setBzgg(Integer bzgg) {
        this.bzgg = bzgg;
    }

    public Integer getPacknum() {
        return packnum;
    }

    public void setPacknum(Integer packnum) {
        this.packnum = packnum;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getLastbuycompany() {
        return lastbuycompany;
    }

    public void setLastbuycompany(String lastbuycompany) {
        this.lastbuycompany = lastbuycompany;
    }

    public Float getLastprice() {
        return lastprice;
    }

    public void setLastprice(Float lastprice) {
        this.lastprice = lastprice;
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy;
    }

    public String getLastcompanycode() {
        return lastcompanycode;
    }

    public void setLastcompanycode(String lastcompanycode) {
        this.lastcompanycode = lastcompanycode;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
