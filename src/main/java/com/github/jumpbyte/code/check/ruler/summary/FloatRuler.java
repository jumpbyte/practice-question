package com.github.jumpbyte.code.check.ruler.summary;

import com.github.jumpbyte.code.check.ruler.Ruler;
import com.github.jumpbyte.code.check.ruler.detail.number.FloatEqRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.FloatGtRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.FloatGteRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.FloatLtRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.FloatLteRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.FloatNotNullRuler;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class FloatRuler {

    public static Ruler<Float> eq(Float norm) {
        return new FloatEqRuler(norm);
    }

    public static Ruler<Float> eq(Float norm, int failCode, String failDesc) {
        return new FloatEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Float> gt(Float norm) {
        return new FloatGtRuler(norm);
    }

    public static Ruler<Float> gt(Float norm, int failCode, String failDesc) {
        return new FloatGtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Float> gte(Float norm) {
        return new FloatGteRuler(norm);
    }

    public static Ruler<Float> gte(Float norm, int failCode, String failDesc) {
        return new FloatGteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Float> lt(Float norm) {
        return new FloatLtRuler(norm);
    }

    public static Ruler<Float> lt(Float norm, int failCode, String failDesc) {
        return new FloatLtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Float> lte(Float norm) {
        return new FloatLteRuler(norm);
    }

    public static Ruler<Float> lte(Float norm, int failCode, String failDesc) {
        return new FloatLteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Float> notNull() {
        return new FloatNotNullRuler();
    }

    public static Ruler<Float> notNull(int failCode, String failDesc) {
        return new FloatNotNullRuler(failCode, failDesc);
    }

}
