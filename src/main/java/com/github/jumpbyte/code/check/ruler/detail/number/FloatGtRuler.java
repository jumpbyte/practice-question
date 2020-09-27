package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.NumberUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.FLOAT_GT_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class FloatGtRuler extends BaseRuler<Float> {

    private Float norm;

    public FloatGtRuler(Float norm) {
        init(norm, FLOAT_GT_FAIL.getCode(), FLOAT_GT_FAIL.getDesc());
    }

    public FloatGtRuler(Float norm, int failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Float norm, int failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Float checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (NumberUtil.isGt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
