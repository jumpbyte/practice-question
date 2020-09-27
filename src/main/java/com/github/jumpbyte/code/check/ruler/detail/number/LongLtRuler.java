package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.NumberUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.LONG_LT_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class LongLtRuler extends BaseRuler<Long> {

    private Long norm;

    public LongLtRuler(Long norm) {
        init(norm, LONG_LT_FAIL.getCode(), LONG_LT_FAIL.getDesc());
    }

    public LongLtRuler(Long norm, int failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Long norm, int failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Long checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (NumberUtil.isLt(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
