package com.github.jumpbyte.code.check.ruler.detail.string;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.StringUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.STR_STANDARD_DATE_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class StrStandardDateRuler extends BaseRuler<String> {


    public StrStandardDateRuler() {
        init(STR_STANDARD_DATE_FAIL.getCode(), STR_STANDARD_DATE_FAIL.getDesc());
    }

    public StrStandardDateRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isStandardDate(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
