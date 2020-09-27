package com.github.jumpbyte.code.check.ruler.detail.collection;


import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;

import java.util.Collection;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.COLL_SIZE_LTE_FAIL;


/**
 * @author diaowenjing
 * Date  2018-12-7
 * Time  10:51
 */
public class CollSizeLteRuler extends BaseRuler<Collection> {

    private int norm;

    public CollSizeLteRuler(int norm) {
        init(norm, COLL_SIZE_LTE_FAIL.getCode(), COLL_SIZE_LTE_FAIL.getDesc());
    }

    public CollSizeLteRuler(int norm, int failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(int norm, int failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Collection checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (checkTarget.size()<=norm) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
