package com.github.jumpbyte.practice.gof.strategymode.two;

import com.jumpbyte.github.gof23.strategymode.PayInfo;

/**
 * @className: StrategygFacyory
 * @author: yuanjinan
 * @create: 2018/11/09
 **/
public class StrategygFacyory {


    public static IDiscountStrategy getDiscountStrategy(PayInfo payInfo){

        IDiscountStrategy instance = null;

        //TODO 识别具体策略....

        return  instance;
    }
}
