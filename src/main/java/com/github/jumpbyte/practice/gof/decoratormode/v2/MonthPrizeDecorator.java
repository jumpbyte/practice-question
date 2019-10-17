package com.github.jumpbyte.practice.gof.decoratormode.v2;

import com.jumpbyte.github.gof23.decoratormode.common.Repository;

import java.util.Date;

/**
 * 装饰器对象，计算当月业务奖金
 *
 * @className: MonthPrizeDecorator
 * @author: yuanjinan
 * @create: 2018/12/26
 **/
public class MonthPrizeDecorator extends PrizeDecorator {

    public MonthPrizeDecorator(PrizeComponent prizeComponent) {
        super(prizeComponent);
    }


    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //1：先获取前面运算出来的奖金
        double money = super.calcPrize(user, begin, end);
        //2：然后计算当月业务奖金,按人员和时间去获取当月业务额，然后再乘以3%
        double prize = Repository.MAP_MONTH_SALE_MONEY.get(user) * 0.03;
        System.out.println(user+"当月业务奖金"+prize);
        return money + prize;

    }
}
