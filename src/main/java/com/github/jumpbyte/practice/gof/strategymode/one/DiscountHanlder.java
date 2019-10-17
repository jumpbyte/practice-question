package com.github.jumpbyte.practice.gof.strategymode.one;

import com.jumpbyte.github.gof23.strategymode.PayInfo;

/**
 * @className: DiscountHanlder
 * @author: yuanjinan
 * @create: 2018/11/08
 **/
public class DiscountHanlder {


    public static double calculateDiscountForAliPay(PayInfo payInfo){
        //计算优惠逻辑 a
        return  0.0;
    }

    public static double calculateDiscountForWxPay(PayInfo payInfo){
        //计算优惠逻辑 b
        return  0.0;
    }

    public  static double calculateDiscountForUnionPay(PayInfo payInfo){
        //计算优惠逻辑 c
        return  0.0;
    }
    public static double calculateDiscountForJDPay(PayInfo payInfo){
        //计算优惠逻辑 d
        return  0.0;
    }
}
