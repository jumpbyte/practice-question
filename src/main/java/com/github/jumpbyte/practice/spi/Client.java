package com.github.jumpbyte.practice.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @className: Client
 * @author: yuanjinan
 * @create: 2019/03/14
 **/
public class Client {

    public static void main(String[] args) {

        //两种方式：ServiceLoader.load或者Service.providers
        Iterator<ISearch> providers = Service.providers(ISearch.class);
        ServiceLoader<ISearch> load = ServiceLoader.load(ISearch.class);

        while(providers.hasNext()) {
            ISearch search = providers.next();
            search.search();
        }
        System.out.println("--------------------------------");
        Iterator<ISearch> iterator = load.iterator();
        while(iterator.hasNext()) {
            ISearch search = iterator.next();
            search.search();
        }
    }
}
