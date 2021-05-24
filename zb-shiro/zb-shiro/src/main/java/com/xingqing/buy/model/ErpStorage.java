package com.xingqing.buy.model;

import javax.persistence.Table;

@Table(name ="spkfjc")
public class ErpStorage {
    private String spid;//商品id
    private Integer kcshl;//库存数量
    private Float kcje;//库存金额
    private Float chbdj;//产品单价
    private Float zgjj;//最高价格
    private Float zdjj;//最低价格
    private Float zhjj;//最后进价


    public Float getZhjj() {
        return zhjj;
    }

    public void setZhjj(Float zhjj) {
        this.zhjj = zhjj;
    }
    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public Integer getKcshl() {
        return kcshl;
    }

    public void setKcshl(Integer kcshl) {
        this.kcshl = kcshl;
    }

    public Float getKcje() {
        return kcje;
    }

    public void setKcje(Float kcje) {
        this.kcje = kcje;
    }

    public Float getChbdj() {
        return chbdj;
    }

    public void setChbdj(Float chbdj) {
        this.chbdj = chbdj;
    }

    public Float getZgjj() {
        return zgjj;
    }

    public void setZgjj(Float zgjj) {
        this.zgjj = zgjj;
    }

    public Float getZdjj() {
        return zdjj;
    }

    public void setZdjj(Float zdjj) {
        this.zdjj = zdjj;
    }
}
