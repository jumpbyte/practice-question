package com.github.jumpbyte.code.check.ruler.summary;


import com.github.jumpbyte.code.check.ruler.Ruler;
import com.github.jumpbyte.code.check.ruler.detail.date.DateAfterOrEqRuler;
import com.github.jumpbyte.code.check.ruler.detail.date.DateAfterRuler;
import com.github.jumpbyte.code.check.ruler.detail.date.DateBeforeOrEqRuler;
import com.github.jumpbyte.code.check.ruler.detail.date.DateBeforeRuler;
import com.github.jumpbyte.code.check.ruler.detail.date.DateEqRuler;
import com.github.jumpbyte.code.check.ruler.detail.date.DateNotNullRuler;

import java.util.Date;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class DateRuler {

    public static Ruler<Date> eq(Date norm) {
        return new DateEqRuler(norm);
    }

    public static Ruler<Date> eq(Date norm, int failCode, String failDesc) {
        return new DateEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Date> after(Date norm) {
        return new DateAfterRuler(norm);
    }

    public static Ruler<Date> after(Date norm, int failCode, String failDesc) {
        return new DateAfterRuler(norm, failCode, failDesc);
    }

    public static Ruler<Date> afterOrEq(Date norm) {
        return new DateAfterOrEqRuler(norm);
    }

    public static Ruler<Date> afterOrEq(Date norm, int failCode, String failDesc) {
        return new DateAfterOrEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Date> before(Date norm) {
        return new DateBeforeRuler(norm);
    }

    public static Ruler<Date> before(Date norm, int failCode, String failDesc) {
        return new DateBeforeRuler(norm, failCode, failDesc);
    }

    public static Ruler<Date> beforeOrEq(Date norm) {
        return new DateBeforeOrEqRuler(norm);
    }

    public static Ruler<Date> beforeOrEq(Date norm, int failCode, String failDesc) {
        return new DateBeforeOrEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Date> notNull() {
        return new DateNotNullRuler();
    }

    public static Ruler<Date> notNull(int failCode, String failDesc) {
        return new DateNotNullRuler(failCode, failDesc);
    }

}
