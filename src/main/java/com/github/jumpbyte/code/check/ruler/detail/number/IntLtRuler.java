package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.NumberUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.INT_LT_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class IntLtRuler extends BaseRuler<Integer> {

    private Integer norm;

    public IntLtRuler(Integer norm) {
        init(norm, INT_LT_FAIL.getCode(), INT_LT_FAIL.getDesc());
    }

    public IntLtRuler(Integer norm, int failCode, String failDesc) {
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
        if (NumberUtil.isLt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
