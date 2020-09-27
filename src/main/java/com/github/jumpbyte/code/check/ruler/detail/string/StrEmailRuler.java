package com.github.jumpbyte.code.check.ruler.detail.string;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.StringUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.STR_EMAIL_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class StrEmailRuler extends BaseRuler<String> {


    public StrEmailRuler() {
        init(STR_EMAIL_FAIL.getCode(), STR_EMAIL_FAIL.getDesc());
    }

    public StrEmailRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isEmail(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
