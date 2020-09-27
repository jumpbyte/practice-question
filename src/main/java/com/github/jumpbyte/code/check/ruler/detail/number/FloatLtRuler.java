package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.NumberUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.FLOAT_LT_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class FloatLtRuler extends BaseRuler<Float> {

    private Float norm;

    public FloatLtRuler(Float norm) {
        init(norm, FLOAT_LT_FAIL.getCode(), FLOAT_LT_FAIL.getDesc());
    }

    public FloatLtRuler(Float norm, int failCode, String failDesc) {
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
        if (NumberUtil.isLt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
