package com.github.jumpbyte.code.check.ruler.detail.string;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.StringUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.STR_EMPTY_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class StrEmptyRuler extends BaseRuler<String> {


    public StrEmptyRuler() {
        init(STR_EMPTY_FAIL.getCode(), STR_EMPTY_FAIL.getDesc());
    }

    public StrEmptyRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isEmpty(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
