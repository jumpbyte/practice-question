package com.github.jumpbyte.code.check.ruler.detail.string;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.StringUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.STR_ALL_LETTER_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class StrAllLetterRuler extends BaseRuler<String> {


    public StrAllLetterRuler() {
        init(STR_ALL_LETTER_FAIL.getCode(), STR_ALL_LETTER_FAIL.getDesc());
    }

    public StrAllLetterRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isAllLetter(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
