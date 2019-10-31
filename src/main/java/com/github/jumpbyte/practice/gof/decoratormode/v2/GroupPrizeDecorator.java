package com.github.jumpbyte.practice.gof.decoratormode.v2;

import com.github.jumpbyte.practice.gof.decoratormode.common.Repository;

import java.util.Date;

/**
 * 装饰器对象，计算当月团队业务奖金
 * @className: GroupPrizeDecorator
 * @author: yuanjinan
 * @create: 2018/12/26
 **/
public class GroupPrizeDecorator extends PrizeDecorator {

    public GroupPrizeDecorator(PrizeComponent prizeComponent) {
        super(prizeComponent);
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //1：先获取前面运算出来的奖金
        double money = super.calcPrize(user, begin, end);
        //2：然后计算当月团队业务奖金，先计算出团队总的业务额，然后再乘以1%
        //假设都是一个团队的
        double group = 0.0;
        for(double d : Repository.MAP_MONTH_SALE_MONEY.values()){
            group += d;
        }
        double prize = group * 0.01;
        System.out.println(user+"当月团队业务奖金"+prize);
        return money + prize;
    }
}
