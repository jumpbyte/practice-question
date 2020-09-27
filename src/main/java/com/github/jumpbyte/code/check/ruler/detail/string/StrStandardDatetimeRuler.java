package com.github.jumpbyte.code.check.ruler.detail.string;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.StringUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.STR_STANDARD_DATETIME_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class StrStandardDatetimeRuler extends BaseRuler<String> {


    public StrStandardDatetimeRuler() {
        init(STR_STANDARD_DATETIME_FAIL.getCode(), STR_STANDARD_DATETIME_FAIL.getDesc());
    }

    public StrStandardDatetimeRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isStandardDatetime(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
