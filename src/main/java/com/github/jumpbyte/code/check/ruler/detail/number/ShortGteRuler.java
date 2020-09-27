package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.NumberUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.SHORT_GTE_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class ShortGteRuler extends BaseRuler<Short> {

    private Short norm;

    public ShortGteRuler(Short norm) {
        init(norm, SHORT_GTE_FAIL.getCode(), SHORT_GTE_FAIL.getDesc());
    }

    public ShortGteRuler(Short norm, int failCode, String failDesc) {
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
        if (NumberUtil.isGte(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
