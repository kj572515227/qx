package com.xingqing.buy.model;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 采购异常审批流程
 */
@Table(name="asklog")
public class AskLog {
    private Integer id;//自增id
    private Integer askid ;//申请的key
    private String operator;//操作人员
    private String operate ;//：操作动作名称  result，可以和
    private Integer result ;//：操作结果：1：成功，0 失败
    private String remarks ;//备注
    @Transient
    private Date update_time;//操作记录时间


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAskid() {
        return askid;
    }

    public void setAskid(Integer askid) {
        this.askid = askid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }



}
