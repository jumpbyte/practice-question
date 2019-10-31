package com.github.jumpbyte.practice.gof.strategymode.two;

import com.github.jumpbyte.practice.gof.strategymode.PayInfo;

/**
 * @className: ICBCdissStrategy
 * @author: yuanjinan
 * @create: 2018/11/09
 **/
public class ICBCdissStrategy implements IDiscountStrategy {


    @Override
    public double calculateDiscount(PayInfo payInfo) {
        return 0;
    }
}
