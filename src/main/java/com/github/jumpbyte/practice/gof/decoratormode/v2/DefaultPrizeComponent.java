package com.github.jumpbyte.practice.gof.decoratormode.v2;

import java.util.Date;

/**
 * 基本的实现计算奖金的类，也是被装饰器装饰的对象
 * @className: DefaultPrizeComponent
 * @author: yuanjinan
 * @create: 2018/12/26
 **/
public class DefaultPrizeComponent extends PrizeComponent {

    /**
     * 计算某人在某段时间内的奖金，有些参数在演示中并不会使用，
     * 但是在实际业务实现上是会用的，为了表示这是个具体的业务方法，
     *
     * @param user  被计算奖金的人员
     * @param begin 计算奖金的开始时间
     * @param end   计算奖金的结束时间
     * @return 某人在某段时间内的奖金
     */
    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //只是一个默认的实现，默认没有奖金
        return 0;
    }
}
