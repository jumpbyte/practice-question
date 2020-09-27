package com.github.jumpbyte.code.check.ruler.detail.date;



import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.DateUtil;

import java.util.Date;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.DATE_BEFORE_OR_EQ_FAIL;


/**
 * @author diaowenjing
 * Date  2018-12-4
 * Time  11:04
 */
public class DateBeforeOrEqRuler extends BaseRuler<Date> {

    private Date norm;

    public DateBeforeOrEqRuler(Date norm) {
        init(norm, DATE_BEFORE_OR_EQ_FAIL.getCode(), DATE_BEFORE_OR_EQ_FAIL.getDesc());
    }

    public DateBeforeOrEqRuler(Date norm, int failCode, String failDesc) {
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
        if (DateUtil.isBeforeOrEq(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm, norm));
    }

}
