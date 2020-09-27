package com.github.jumpbyte.code.check.ruler.detail.date;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.CheckResultCodeEnum;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.DateUtil;

import java.util.Date;

/**
 * @author diaowenjing
 * Date  2018-12-4
 * Time  11:04
 */
public class DateAfterRuler extends BaseRuler<Date> {

    private Date norm;

    public DateAfterRuler(Date norm) {
        init(norm, CheckResultCodeEnum.DATE_AFTER_FAIL.getCode(), CheckResultCodeEnum.DATE_AFTER_FAIL.getDesc());
    }

    public DateAfterRuler(Date norm, int failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Date norm, int failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Date checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (DateUtil.isAfter(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm, norm));
    }

}
