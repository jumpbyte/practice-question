package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.NumberUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.INT_EQ_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class IntEqRuler extends BaseRuler<Integer> {

    private Integer norm;

    public IntEqRuler(Integer norm) {
        init(norm, INT_EQ_FAIL.getCode(), INT_EQ_FAIL.getDesc());
    }

    public IntEqRuler(Integer norm, int failCode, String failDesc) {
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
        if (NumberUtil.isEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
