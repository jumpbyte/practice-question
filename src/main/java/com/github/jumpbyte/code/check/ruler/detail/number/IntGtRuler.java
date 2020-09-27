package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.NumberUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.INT_GT_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class IntGtRuler extends BaseRuler<Integer> {

    private Integer norm;

    public IntGtRuler(Integer norm) {
        init(norm, INT_GT_FAIL.getCode(), INT_GT_FAIL.getDesc());
    }

    public IntGtRuler(Integer norm, int failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Integer norm, int failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Integer checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (NumberUtil.isGt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
