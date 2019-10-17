package com.github.jumpbyte.practice.gof.decoratormode.v2;

import java.util.Date;

/**
 * @className: PrizeDecorator
 * @author: yuanjinan
 * @create: 2018/12/26
 **/
public abstract class PrizeDecorator extends PrizeComponent {

    private  PrizeComponent prizeComponent;

    public PrizeDecorator(PrizeComponent prizeComponent){
        this.prizeComponent = prizeComponent;
    }


    @Override
    public double calcPrize(String user, Date begin, Date end) {
        return prizeComponent.calcPrize(user,begin,end);
    }
}
