package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.NumberUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.DOUBLE_NOT_NULL_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class DoubleNotNullRuler extends BaseRuler<Double> {


    public DoubleNotNullRuler() {
        init(DOUBLE_NOT_NULL_FAIL.getCode(), DOUBLE_NOT_NULL_FAIL.getDesc());
    }

    public DoubleNotNullRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Double checkTarget) {
        if (NumberUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
