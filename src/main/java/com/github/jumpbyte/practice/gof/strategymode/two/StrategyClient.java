package com.github.jumpbyte.practice.gof.strategymode.two;

import com.github.jumpbyte.practice.gof.strategymode.PayInfo;

/**
 * 场景类
 * @className: StrategyClient
 * @author: yuanjinan
 * @create: 2018/11/08
 **/
public class StrategyClient {


    public static void main(String[] args){

        PayInfo payInfo= new PayInfo();

        DiscountContext discountContext = new DiscountContext(StrategygFacyory.getDiscountStrategy(payInfo));
        discountContext.calculateDiscount(payInfo);


    }
}
