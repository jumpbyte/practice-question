package com.github.jumpbyte.code.check.ruler.detail.string;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.StringUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.STR_NUM_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class StrNumRuler extends BaseRuler<String> {


    public StrNumRuler() {
        init(STR_NUM_FAIL.getCode(), STR_NUM_FAIL.getDesc());
    }

    public StrNumRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(String checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (StringUtil.isNum(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
