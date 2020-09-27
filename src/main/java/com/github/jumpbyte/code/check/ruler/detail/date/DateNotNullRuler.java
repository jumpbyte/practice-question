package com.github.jumpbyte.code.check.ruler.detail.date;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.DateUtil;

import java.util.Date;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.DATE_NOT_NULL_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class DateNotNullRuler extends BaseRuler<Date> {


    public DateNotNullRuler() {
        init(DATE_NOT_NULL_FAIL.getCode(), DATE_NOT_NULL_FAIL.getDesc());
    }

    public DateNotNullRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Date checkTarget) {
        if (DateUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
