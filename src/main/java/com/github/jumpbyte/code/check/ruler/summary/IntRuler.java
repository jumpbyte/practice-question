package com.github.jumpbyte.code.check.ruler.summary;

import com.github.jumpbyte.code.check.ruler.Ruler;
import com.github.jumpbyte.code.check.ruler.detail.number.IntEqRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.IntGtRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.IntGteRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.IntLtRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.IntLteRuler;
import com.github.jumpbyte.code.check.ruler.detail.number.IntNotNullRuler;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class IntRuler {

    public static Ruler<Integer> eq(Integer norm) {
        return new IntEqRuler(norm);
    }

    public static Ruler<Integer> eq(Integer norm, int failCode, String failDesc) {
        return new IntEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Integer> gt(Integer norm) {
        return new IntGtRuler(norm);
    }

    public static Ruler<Integer> gt(Integer norm, int failCode, String failDesc) {
        return new IntGtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Integer> gte(Integer norm) {
        return new IntGteRuler(norm);
    }

    public static Ruler<Integer> gte(Integer norm, int failCode, String failDesc) {
        return new IntGteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Integer> lt(Integer norm) {
        return new IntLtRuler(norm);
    }

    public static Ruler<Integer> lt(Integer norm, int failCode, String failDesc) {
        return new IntLtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Integer> lte(Integer norm) {
        return new IntLteRuler(norm);
    }

    public static Ruler<Integer> lte(Integer norm, int failCode, String failDesc) {
        return new IntLteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Integer> notNull() {
        return new IntNotNullRuler();
    }

    public static Ruler<Integer> notNull(int failCode, String failDesc) {
        return new IntNotNullRuler(failCode, failDesc);
    }

}
