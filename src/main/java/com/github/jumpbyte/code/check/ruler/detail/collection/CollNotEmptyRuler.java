package com.github.jumpbyte.code.check.ruler.detail.collection;


import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.COLL_NOT_EMPTY_FAIL;

/**
 * @author diaowenjing
 * Date  2018-12-7
 * Time  10:51
 */
public class CollNotEmptyRuler extends BaseRuler<Collection> {


    public CollNotEmptyRuler() {
        init(COLL_NOT_EMPTY_FAIL.getCode(), COLL_NOT_EMPTY_FAIL.getDesc());
    }

    public CollNotEmptyRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Collection checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (CollectionUtils.isNotEmpty(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
