package com.github.jumpbyte.practice.spi.impl;

import com.jumpbyte.github.spi.ISearch;

/**
 * @className: HBaseSearch
 * @author: yuanjinan
 * @create: 2019/03/14
 **/
public class HBaseSearch implements ISearch {

    @Override
    public void search() {
        System.out.println("从HBase中拿到数据....");
    }
}
