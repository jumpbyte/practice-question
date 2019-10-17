package com.github.jumpbyte.practice.gof.decoratormode.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据仓库
 *
 * @className: Repository
 * @author: yuanjinan
 * @create: 2018/12/26
 **/
public class Repository {


    private Repository(){

    }

    /**
     * 记录每个人的月度销售额
     */
    public static final Map<String,Double> MAP_MONTH_SALE_MONEY = new HashMap<>();

    static {
        //填充测试数据
        MAP_MONTH_SALE_MONEY.put("张三",10000.0);
        MAP_MONTH_SALE_MONEY.put("李四",20000.0);
        MAP_MONTH_SALE_MONEY.put("王五",30000.0);
    }

}
