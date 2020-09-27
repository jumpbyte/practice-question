package com.github.jumpbyte.code.check.ruler.detail.string;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.StringUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.STR_LENGTH_EQ_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class StrLengthEqRuler extends BaseRuler<String> {

    private int norm;

    public StrLengthEqRuler(int norm) {
        init(norm, STR_LENGTH_EQ_FAIL.getCode(), STR_LENGTH_EQ_FAIL.getDesc());
    }

    public StrLengthEqRuler(int norm, int failCode, String failDesc) {
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
        if (StringUtil.isLengthEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
