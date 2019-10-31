package com.github.jumpbyte.practice.gof.decoratormode;

import com.github.jumpbyte.practice.gof.decoratormode.v2.DefaultPrizeComponent;
import com.github.jumpbyte.practice.gof.decoratormode.v2.GroupPrizeDecorator;
import com.github.jumpbyte.practice.gof.decoratormode.v2.MonthPrizeDecorator;
import com.github.jumpbyte.practice.gof.decoratormode.v2.PrizeComponent;
import com.github.jumpbyte.practice.gof.decoratormode.v2.PrizeDecorator;
import com.github.jumpbyte.practice.gof.decoratormode.v2.SumPrizeDecorator;

/**
 * 场景类
 *
 * @className: Client
 * @author: yuanjinan
 * @create: 2018/12/26
 **/
public class Client {


    public static void main(String[] args) {

//        //V1版本
//        //先创建计算奖金的对象
//        PrizeManager p = new PrizeManager();
//
//        double zs = p.calcPrize("张三",null,null);
//        System.out.println("==========张三应得奖金："+zs);
//        double ls = p.calcPrize("李四",null,null);
//        System.out.println("==========李四应得奖金："+ls);
//        double ww = p.calcPrize("王五",null,null);
//        System.out.println("==========王经理应得奖金："+ww);

        //v2版本
        //先创建计算基本奖金的类，这也是被装饰的对象
        PrizeComponent c1 = new DefaultPrizeComponent();

        //然后对计算的基本奖金进行装饰，这里要组合各个装饰
        //说明，各个装饰者之间最好是不要有先后顺序的限制，
        //也就是先装饰谁和后装饰谁都应该是一样的

        //先组合普通业务人员的奖金计算
        PrizeDecorator d1 = new MonthPrizeDecorator(c1);
        PrizeDecorator d2 = new SumPrizeDecorator(d1);

        //注意：这里只需使用最后组合好的对象调用业务方法即可，会依次调用回去
        double zs = d2.calcPrize("张三",null,null);
        System.out.println("==========张三应得奖金："+zs);
        double ls = d2.calcPrize("李四",null,null);
        System.out.println("==========李四应得奖金："+ls);

        //如果是业务经理，还需要一个计算团队的奖金计算
        PrizeDecorator d3 = new GroupPrizeDecorator(d2);


        double ww = d3.calcPrize("王五",null,null);
        System.out.println("==========王经理应得奖金："+ww);

    }
}
