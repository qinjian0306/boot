package com.qj.springboot.bean;

import java.math.BigDecimal;

/**
 * 接受kafka回传 实体
 */
public class Transaction {

    private Long id;
    private Integer buySystemId;
    private Long buyOrderId;
    private Integer sellSystemId;
    private Long sellOrderId;
    private BigDecimal dealQuantities;
    private BigDecimal dealPrice;
    private BigDecimal buyCharge;
    private BigDecimal sellCharge;
    private Long dealTime;
    private Integer cancel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBuySystemId() {
        return buySystemId;
    }

    public void setBuySystemId(Integer buySystemId) {
        this.buySystemId = buySystemId;
    }

    public Long getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(Long buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public Integer getSellSystemId() {
        return sellSystemId;
    }

    public void setSellSystemId(Integer sellSystemId) {
        this.sellSystemId = sellSystemId;
    }

    public Long getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(Long sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    public BigDecimal getDealQuantities() {
        return dealQuantities;
    }

    public void setDealQuantities(BigDecimal dealQuantities) {
        this.dealQuantities = dealQuantities;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public BigDecimal getBuyCharge() {
        return buyCharge;
    }

    public void setBuyCharge(BigDecimal buyCharge) {
        this.buyCharge = buyCharge;
    }

    public BigDecimal getSellCharge() {
        return sellCharge;
    }

    public void setSellCharge(BigDecimal sellCharge) {
        this.sellCharge = sellCharge;
    }

    public Long getDealTime() {
        return dealTime;
    }

    public void setDealTime(Long dealTime) {
        this.dealTime = dealTime;
    }

    public Integer getCancel() {
        return cancel;
    }

    public void setCancel(Integer cancel) {
        this.cancel = cancel;
    }
}
