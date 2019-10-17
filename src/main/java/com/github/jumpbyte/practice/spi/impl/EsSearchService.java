package com.github.jumpbyte.practice.spi.impl;

import com.jumpbyte.github.spi.ISearch;

/**
 * @className: EsSearchService
 * @author: yuanjinan
 * @create: 2019/03/14
 **/
public class EsSearchService implements ISearch {

    @Override
    public void search() {
        System.out.println("从ES中搜索出数据......");
    }
}
