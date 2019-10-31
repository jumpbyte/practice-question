package com.github.jumpbyte.practice.gof.strategymode.two;

import com.github.jumpbyte.practice.gof.strategymode.PayInfo;

/**
 * @className: AliPayDiscountStrategy
 * @author: yuanjinan
 * @create: 2018/11/08
 **/
public class AliPayDiscountStrategy implements IDiscountStrategy {

    @Override
    public double calculateDiscount(PayInfo payInfo) {
        //独有优惠计算逻辑....
        return 0;
    }
}
