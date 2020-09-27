package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.NumberUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.FLOAT_EQ_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class FloatEqRuler extends BaseRuler<Float> {

    private Float norm;

    public FloatEqRuler(Float norm) {
        init(norm, FLOAT_EQ_FAIL.getCode(), FLOAT_EQ_FAIL.getDesc());
    }

    public FloatEqRuler(Float norm, int failCode, String failDesc) {
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
        if (NumberUtil.isEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
