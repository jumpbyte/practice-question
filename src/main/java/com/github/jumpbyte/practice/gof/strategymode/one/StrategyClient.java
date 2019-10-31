package com.github.jumpbyte.practice.gof.strategymode.one;

import com.github.jumpbyte.practice.gof.strategymode.PayInfo;
import com.github.jumpbyte.practice.gof.strategymode.PayType;

/**
 * @className: StrategyClient
 * @author: yuanjinan
 * @create: 2018/11/08
 **/
public class StrategyClient {


    public static void main(String[] args){

        PayInfo payInfo= new PayInfo();
        if (payInfo.getPayType() == PayType.ALIPAY) {
             DiscountHanlder.calculateDiscountForAliPay(payInfo);
        } else if (payInfo.getPayType() == PayType.WEIXIN_PAY) {
             DiscountHanlder.calculateDiscountForWxPay(payInfo);
        } else if (payInfo.getPayType() == PayType.UNION_PAY) {
             DiscountHanlder.calculateDiscountForUnionPay(payInfo);
        } else if (payInfo.getPayType() == PayType.JD_PAY) {
             DiscountHanlder.calculateDiscountForJDPay(payInfo);
        }
    }

}
