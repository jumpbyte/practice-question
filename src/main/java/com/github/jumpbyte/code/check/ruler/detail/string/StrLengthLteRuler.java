package com.github.jumpbyte.code.check.ruler.detail.string;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.StringUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.STR_LENGTH_LTE_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class StrLengthLteRuler extends BaseRuler<String> {

    private int norm;

    public StrLengthLteRuler(int norm) {
        init(norm, STR_LENGTH_LTE_FAIL.getCode(), STR_LENGTH_LTE_FAIL.getDesc());
    }

    public StrLengthLteRuler(int norm, int failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(int norm, int failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isLengthLte(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
