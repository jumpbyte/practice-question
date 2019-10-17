package com.github.jumpbyte.practice.gof.strategymode.two;

import com.jumpbyte.github.gof23.strategymode.PayInfo;

/**
 * @className: DiscountContext
 * @author: yuanjinan
 * @create: 2018/11/08
 **/
public class DiscountContext {

    private IDiscountStrategy discountStrategy;


    public DiscountContext(IDiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateDiscount(PayInfo payInfo){
       return discountStrategy.calculateDiscount(payInfo);
    }

}
