package com.github.jumpbyte.code.check.ruler.summary;

import com.github.jumpbyte.code.check.ruler.Ruler;
import com.github.jumpbyte.code.check.ruler.detail.number.DoubleEqRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.DoubleGtRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.DoubleGteRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.DoubleLtRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.DoubleLteRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.DoubleNotNullRuler;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class DoubleRuler {

    public static Ruler<Double> eq(Double norm) {
        return new DoubleEqRuler(norm);
    }

    public static Ruler<Double> eq(Double norm, int failCode, String failDesc) {
        return new DoubleEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Double> gt(Double norm) {
        return new DoubleGtRuler(norm);
    }

    public static Ruler<Double> gt(Double norm, int failCode, String failDesc) {
        return new DoubleGtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Double> gte(Double norm) {
        return new DoubleGteRuler(norm);
    }

    public static Ruler<Double> gte(Double norm, int failCode, String failDesc) {
        return new DoubleGteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Double> lt(Double norm) {
        return new DoubleLtRuler(norm);
    }

    public static Ruler<Double> lt(Double norm, int failCode, String failDesc) {
        return new DoubleLtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Double> lte(Double norm) {
        return new DoubleLteRuler(norm);
    }

    public static Ruler<Double> lte(Double norm, int failCode, String failDesc) {
        return new DoubleLteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Double> notNull() {
        return new DoubleNotNullRuler();
    }

    public static Ruler<Double> notNull(int failCode, String failDesc) {
        return new DoubleNotNullRuler(failCode, failDesc);
    }

}
