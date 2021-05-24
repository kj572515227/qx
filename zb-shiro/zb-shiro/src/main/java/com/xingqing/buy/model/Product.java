package com.xingqing.buy.model;

import javax.persistence.Table;
import java.util.Date;

/**
 * CREATE TABLE `product` (
 *   `id` int NOT NULL AUTO_INCREMENT,
 *   `code` varchar(45) NOT NULL COMMENT 'erp商品编号',
 *   `name` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
 *   `factoryid` int DEFAULT NULL,
 *   `spec` varchar(45) DEFAULT NULL COMMENT '规格',
 *   `place` varchar(120) DEFAULT NULL COMMENT '产地',
 *   `gyzhunzi` varchar(45) DEFAULT NULL COMMENT '国药准字 ',
 *   `packunit` varchar(45) DEFAULT NULL COMMENT '包装单位，瓶，盒',
 *   `type` varchar(32) DEFAULT NULL COMMENT '药品类别，税率。中药，西药，生物制品',
 *   `create_time` datetime DEFAULT NULL COMMENT '商品创建时间',
 *   `packnum` int DEFAULT NULL COMMENT '计件量',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='目前货物的信息，包括成本和货物的数量。';
 */
@Table(name= "product")
public class Product {
    private Integer id;
    private String code;
    private String name;
    private String factory;
    private String spec;
    private String place;
    private String gyzhunzi;
    private Integer packunit;//包装单位
    private Integer type;
    private Integer packnum;
    private Date create_time;
    private Integer ywy;//业务员
    private String lastbuyercode;//


    public String getLastbuyercode() {
        return lastbuyercode;
    }

    public void setLastbuyercode(String lastbuyercode) {
        this.lastbuyercode = lastbuyercode;
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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getGyzhunzi() {
        return gyzhunzi;
    }

    public void setGyzhunzi(String gyzhunzi) {
        this.gyzhunzi = gyzhunzi;
    }

    public Integer getPackunit() {
        return packunit;
    }

    public void setPackunit(Integer packunit) {
        this.packunit = packunit;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPacknum() {
        return packnum;
    }

    public void setPacknum(Integer packnum) {
        this.packnum = packnum;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }


    public Integer getYwy() {
        return ywy;
    }

    public void setYwy(Integer ywy) {
        this.ywy = ywy;
    }

}
