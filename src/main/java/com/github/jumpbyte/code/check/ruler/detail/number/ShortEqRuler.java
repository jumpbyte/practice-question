package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.NumberUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.SHORT_EQ_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class ShortEqRuler extends BaseRuler<Short> {

    private Short norm;

    public ShortEqRuler(Short norm) {
        init(norm, SHORT_EQ_FAIL.getCode(), SHORT_EQ_FAIL.getDesc());
    }

    public ShortEqRuler(Short norm, int failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Short norm, int failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Short checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (NumberUtil.isEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
