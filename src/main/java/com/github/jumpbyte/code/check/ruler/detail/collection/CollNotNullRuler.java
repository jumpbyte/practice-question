package com.github.jumpbyte.code.check.ruler.detail.collection;



import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;

import java.util.Collection;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.COLL_NOT_NULL_FAIL;


/**
 * @author diaowenjing
 * Date  2018-12-7
 * Time  10:51
 */
public class CollNotNullRuler extends BaseRuler<Collection> {


    public CollNotNullRuler() {
        init(COLL_NOT_NULL_FAIL.getCode(), COLL_NOT_NULL_FAIL.getDesc());
    }

    public CollNotNullRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Collection checkTarget) {
        if (null!=checkTarget) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
