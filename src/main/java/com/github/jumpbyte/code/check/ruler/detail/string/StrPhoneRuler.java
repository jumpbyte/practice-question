package com.github.jumpbyte.code.check.ruler.detail.string;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.StringUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.STR_PHONE_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class StrPhoneRuler extends BaseRuler<String> {


    public StrPhoneRuler() {
        init(STR_PHONE_FAIL.getCode(), STR_PHONE_FAIL.getDesc());
    }

    public StrPhoneRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isPhone(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
