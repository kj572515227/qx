package com.xingqing.buy.model;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 采购异常审批流程
 */
@Table(name="ask")
public class Ask {
    private Integer id;//自增id
    private String pcode ;//药品编码
    private Integer reason;//1.价格高。2超最高限量
    private String remarks ;//备注
    private Integer state ;// 1,申请，2.审批，3.驳回，4，审批成功,5,
    private String applicant;//申请人
    private String own ;//当前责任
    private String orderid ;//订单key值
    private String rkid ;//入库key值
    private String gjdwcode;//购进单位
    @Transient
    private Date create_time ;//创建时间
    @Transient
    private Date update_time;//更新时间

    public String getGjdwcode() {
        return gjdwcode;
    }

    public void setGjdwcode(String gjdwcode) {
        this.gjdwcode = gjdwcode;
    }

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

    public Integer getReason() {
        return reason;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getOwn() {
        return own;
    }

    public void setOwn(String own) {
        this.own = own;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getRkid() {
        return rkid;
    }

    public void setRkid(String rkid) {
        this.rkid = rkid;
    }


}
