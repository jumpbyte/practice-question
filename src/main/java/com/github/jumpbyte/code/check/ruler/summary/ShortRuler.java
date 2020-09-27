package com.github.jumpbyte.code.check.ruler.summary;

import com.github.jumpbyte.code.check.ruler.Ruler;
import com.github.jumpbyte.code.check.ruler.detail.number.ShortEqRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.ShortGtRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.ShortGteRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.ShortLtRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.ShortLteRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.ShortNotNullRuler;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class ShortRuler {

    public static Ruler<Short> eq(Short norm) {
        return new ShortEqRuler(norm);
    }

    public static Ruler<Short> eq(Short norm, int failCode, String failDesc) {
        return new ShortEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Short> gt(Short norm) {
        return new ShortGtRuler(norm);
    }

    public static Ruler<Short> gt(Short norm, int failCode, String failDesc) {
        return new ShortGtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Short> gte(Short norm) {
        return new ShortGteRuler(norm);
    }

    public static Ruler<Short> gte(Short norm, int failCode, String failDesc) {
        return new ShortGteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Short> lt(Short norm) {
        return new ShortLtRuler(norm);
    }

    public static Ruler<Short> lt(Short norm, int failCode, String failDesc) {
        return new ShortLtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Short> lte(Short norm) {
        return new ShortLteRuler(norm);
    }

    public static Ruler<Short> lte(Short norm, int failCode, String failDesc) {
        return new ShortLteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Short> notNull() {
        return new ShortNotNullRuler();
    }

    public static Ruler<Short> notNull(int failCode, String failDesc) {
        return new ShortNotNullRuler(failCode, failDesc);
    }

}
