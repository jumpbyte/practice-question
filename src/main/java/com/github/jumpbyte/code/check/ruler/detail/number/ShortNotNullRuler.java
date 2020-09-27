package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.NumberUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.SHORT_NOT_NULL_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class ShortNotNullRuler extends BaseRuler<Short> {


    public ShortNotNullRuler() {
        init(SHORT_NOT_NULL_FAIL.getCode(), SHORT_NOT_NULL_FAIL.getDesc());
    }

    public ShortNotNullRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Short checkTarget) {
        if (NumberUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
