package com.github.jumpbyte.code.check.ruler.detail.string;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.StringUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.STR_ID_CARD_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class StrIdCardRuler extends BaseRuler<String> {


    public StrIdCardRuler() {
        init(STR_ID_CARD_FAIL.getCode(), STR_ID_CARD_FAIL.getDesc());
    }

    public StrIdCardRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isIdCard(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
