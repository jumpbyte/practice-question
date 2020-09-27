package com.github.jumpbyte.code.check.ruler.summary;



import com.github.jumpbyte.code.check.ruler.Ruler;
import com.github.jumpbyte.code.check.ruler.detail.number.BigDecimalNotNullRuler;

import java.math.BigDecimal;

/**
 * @author diaowenjing
 * Date  2018-12-7
 * Time  10:51
 */
public class BigDecimalRuler {
    public static Ruler<BigDecimal> notNull() {
        return new BigDecimalNotNullRuler();
    }

    public static Ruler<BigDecimal> notNull(int failCode, String failDesc) {
        return new BigDecimalNotNullRuler(failCode, failDesc);
    }

}
