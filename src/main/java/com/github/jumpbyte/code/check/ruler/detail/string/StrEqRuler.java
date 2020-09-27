package com.github.jumpbyte.code.check.ruler.detail.string;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.StringUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.STR_EQ_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class StrEqRuler extends BaseRuler<String> {

    private String norm;

    public StrEqRuler(String norm) {
        init(norm, STR_EQ_FAIL.getCode(), STR_EQ_FAIL.getDesc());
    }

    public StrEqRuler(String norm, int failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(String norm, int failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
