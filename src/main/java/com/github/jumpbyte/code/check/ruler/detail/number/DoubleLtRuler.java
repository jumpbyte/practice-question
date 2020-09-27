package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.NumberUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.DOUBLE_LT_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class DoubleLtRuler extends BaseRuler<Double> {

    private Double norm;

    public DoubleLtRuler(Double norm) {
        init(norm, DOUBLE_LT_FAIL.getCode(), DOUBLE_LT_FAIL.getDesc());
    }

    public DoubleLtRuler(Double norm, int failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Double norm, int failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Double checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (NumberUtil.isLt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
