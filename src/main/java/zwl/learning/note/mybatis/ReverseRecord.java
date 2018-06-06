package zwl.learning.note.mybatis;

import java.util.Date;

public class ReverseRecord {
    private Integer id;

    private Integer userId;

    private String orderNo;

    private String tradeNo;

    private String externalTradeNo;

    private Byte reverseStatus;

    private String note;

    private Byte sysVersion;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getExternalTradeNo() {
        return externalTradeNo;
    }

    public void setExternalTradeNo(String externalTradeNo) {
        this.externalTradeNo = externalTradeNo == null ? null : externalTradeNo.trim();
    }

    public Byte getReverseStatus() {
        return reverseStatus;
    }

    public void setReverseStatus(Byte reverseStatus) {
        this.reverseStatus = reverseStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Byte getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(Byte sysVersion) {
        this.sysVersion = sysVersion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}