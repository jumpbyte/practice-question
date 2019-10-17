package com.github.jumpbyte.practice.gof.strategymode;

/**
 * 支付请求信息
 * @className: PayInfo
 * @author: yuanjinan
 * @create: 2018/11/08
 **/
public class PayInfo {

    private PayType payType;
    private double payMoney;
    private long userId;
    private long orderId;

    public PayInfo() {
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
