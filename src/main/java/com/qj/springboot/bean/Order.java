package com.qj.springboot.bean;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 买卖订单
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    // 主键Id
    private Long fid;
    // 用户id
    private Integer fuid;
    // 买卖类型 0买 1卖
    private Integer fsideid;
    // 交易类型 0限价 1市价
    private Integer ftype;
    // 货币id
    private Integer fcoinid;
    // 买卖账户钱包的coinid
    private Integer faccountcoinid;
    // 系统id
    private Integer fsystemid;
    // 交易数量
    private BigDecimal fquantity;
    // 未交易数量
    private BigDecimal fleftquantity;
    // 交易价格 单价 汇率换算后
    private BigDecimal fprice;
    // 交易价格 单价 汇率换算前
    private BigDecimal foriginalprice;
    // 汇率
    private BigDecimal ffx;
    // 手续费
    private BigDecimal ffees;
    private BigDecimal fleftfees;
    // 来源
    private Integer fsource;
    // 创建时间
    private Long fcreatetime;
    // 更新时间
    private Long fupdattime;
    // 订单状态
    private Integer fstatus;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Integer getFuid() {
        return fuid;
    }

    public void setFuid(Integer fuid) {
        this.fuid = fuid;
    }

    public Integer getFsideid() {
        return fsideid;
    }

    public void setFsideid(Integer fsideid) {
        this.fsideid = fsideid;
    }

    public Integer getFtype() {
        return ftype;
    }

    public void setFtype(Integer ftype) {
        this.ftype = ftype;
    }

    public Integer getFcoinid() {
        return fcoinid;
    }

    public void setFcoinid(Integer fcoinid) {
        this.fcoinid = fcoinid;
    }

    public Integer getFaccountcoinid() {
        return faccountcoinid;
    }

    public void setFaccountcoinid(Integer faccountcoinid) {
        this.faccountcoinid = faccountcoinid;
    }

    public Integer getFsystemid() {
        return fsystemid;
    }

    public void setFsystemid(Integer fsystemid) {
        this.fsystemid = fsystemid;
    }

    public BigDecimal getFquantity() {
        return fquantity;
    }

    public void setFquantity(BigDecimal fquantity) {
        this.fquantity = fquantity;
    }

    public BigDecimal getFleftquantity() {
        return fleftquantity;
    }

    public void setFleftquantity(BigDecimal fleftquantity) {
        this.fleftquantity = fleftquantity;
    }

    public BigDecimal getFprice() {
        return fprice;
    }

    public void setFprice(BigDecimal fprice) {
        this.fprice = fprice;
    }

    public BigDecimal getForiginalprice() {
        return foriginalprice;
    }

    public void setForiginalprice(BigDecimal foriginalprice) {
        this.foriginalprice = foriginalprice;
    }

    public BigDecimal getFfx() {
        return ffx;
    }

    public void setFfx(BigDecimal ffx) {
        this.ffx = ffx;
    }

    public BigDecimal getFfees() {
        return ffees;
    }

    public void setFfees(BigDecimal ffees) {
        this.ffees = ffees;
    }

    public BigDecimal getFleftfees() {
        return fleftfees;
    }

    public void setFleftfees(BigDecimal fleftfees) {
        this.fleftfees = fleftfees;
    }

    public Integer getFsource() {
        return fsource;
    }

    public void setFsource(Integer fsource) {
        this.fsource = fsource;
    }

    public Long getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Long fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public Long getFupdattime() {
        return fupdattime;
    }

    public void setFupdattime(Long fupdattime) {
        this.fupdattime = fupdattime;
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }


}
