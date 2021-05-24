package com.xingqing.buy.model;

/**
 CREATE TABLE [dbo].[jxddmx](
 Fkey int not null,
 [djbh] [char](15) NOT NULL,  --单据编号
 [dj_sn] [int] NOT NULL,   --行号
 [spid] [char](11) NULL,   --商品ID
 [is_zx] [char](2) NULL,   --是否执行
 [dw] [char](6) NULL,   --单位
 [hw] [char](11) NULL,   --货位
 [baozhshl] [int] NULL,   --整件数量
 [lingsshl] [decimal](14, 2) NULL, --零货数量
 [shl] [decimal](14, 2) NULL,  --数量
 [dj] [decimal](14, 6) NULL,   --单价

 [hshj] [decimal](14, 6) NULL,  --含税价
 [je] [decimal](14, 4) NULL,   --金额
 [hsje] [decimal](14, 4) NULL,  --价税合计
 [yiwchsl] [decimal](14, 0) NULL, ---已完成数量
 [beizhu] [char](100) NULL,   --备注
 [dwbh] [char](11) NULL    --单位内码

 ) ON ps_bill(Fkey)
 */
public class ErpOrderDetail {
    private Integer Fkey;//订单Fkey
    private String djbh ;//单据编号
    private Integer dj_sn;//行号
    private String spid ;//商品ID
    private String is_zx ;// 是否执行,
    private String dw;//单位
    private String hw ;//货位
    private String baozhshl ;//整件数量
    private Float lingsshl ;//备注
    private Float shl;//数量
    private Float dj ;//单价
    private Float hshj      ;//含税金额
    private Float je ;// --金额
    private Float hsje;//--价税合计
    private Float yiwchsl ;//已完成数量
    private String beizhu      ;//备注
    private String dwbh ;// --单位内吗

    public Integer getFkey() {
        return Fkey;
    }

    public void setFkey(Integer fkey) {
        Fkey = fkey;
    }

    public String getDjbh() {
        return djbh;
    }

    public void setDjbh(String djbh) {
        this.djbh = djbh;
    }

    public Integer getDj_sn() {
        return dj_sn;
    }

    public void setDj_sn(Integer dj_sn) {
        this.dj_sn = dj_sn;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getIs_zx() {
        return is_zx;
    }

    public void setIs_zx(String is_zx) {
        this.is_zx = is_zx;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getHw() {
        return hw;
    }

    public void setHw(String hw) {
        this.hw = hw;
    }

    public String getBaozhshl() {
        return baozhshl;
    }

    public void setBaozhshl(String baozhshl) {
        this.baozhshl = baozhshl;
    }

    public Float getLingsshl() {
        return lingsshl;
    }

    public void setLingsshl(Float lingsshl) {
        this.lingsshl = lingsshl;
    }

    public Float getShl() {
        return shl;
    }

    public void setShl(Float shl) {
        this.shl = shl;
    }

    public Float getDj() {
        return dj;
    }

    public void setDj(Float dj) {
        this.dj = dj;
    }

    public Float getHshj() {
        return hshj;
    }

    public void setHshj(Float hshj) {
        this.hshj = hshj;
    }

    public Float getJe() {
        return je;
    }

    public void setJe(Float je) {
        this.je = je;
    }

    public Float getHsje() {
        return hsje;
    }

    public void setHsje(Float hsje) {
        this.hsje = hsje;
    }

    public Float getYiwchsl() {
        return yiwchsl;
    }

    public void setYiwchsl(Float yiwchsl) {
        this.yiwchsl = yiwchsl;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }
}
