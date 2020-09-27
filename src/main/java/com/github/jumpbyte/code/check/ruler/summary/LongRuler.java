package com.github.jumpbyte.code.check.ruler.summary;

import com.github.jumpbyte.code.check.ruler.Ruler;
import com.github.jumpbyte.code.check.ruler.detail.number.LongEqRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.LongGtRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.LongGteRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.LongLtRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.LongLteRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.LongNotNullRuler;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class LongRuler {

    public static Ruler<Long> eq(Long norm) {
        return new LongEqRuler(norm);
    }

    public static Ruler<Long> eq(Long norm, int failCode, String failDesc) {
        return new LongEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Long> gt(Long norm) {
        return new LongGtRuler(norm);
    }

    public static Ruler<Long> gt(Long norm, int failCode, String failDesc) {
        return new LongGtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Long> gte(Long norm) {
        return new LongGteRuler(norm);
    }

    public static Ruler<Long> gte(Long norm, int failCode, String failDesc) {
        return new LongGteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Long> lt(Long norm) {
        return new LongLtRuler(norm);
    }

    public static Ruler<Long> lt(Long norm, int failCode, String failDesc) {
        return new LongLtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Long> lte(Long norm) {
        return new LongLteRuler(norm);
    }

    public static Ruler<Long> lte(Long norm, int failCode, String failDesc) {
        return new LongLteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Long> notNull() {
        return new LongNotNullRuler();
    }

    public static Ruler<Long> notNull(int failCode, String failDesc) {
        return new LongNotNullRuler(failCode, failDesc);
    }

}
