package com.github.jumpbyte.practice.gof.strategymode.two;

import com.github.jumpbyte.practice.gof.strategymode.PayInfo;

/**
 * @className: IDiscountStrategy
 * @author: yuanjinan
 * @create: 2018/11/08
 **/
public interface IDiscountStrategy {

    double calculateDiscount(PayInfo payInfo);
}
