package com.github.jumpbyte.code.check.ruler.summary;


import com.github.jumpbyte.code.check.ruler.Ruler;
import com.github.jumpbyte.code.check.ruler.detail.collection.CollNotContainsDupRuler;
import com.github.jumpbyte.code.check.ruler.detail.collection.CollNotContainsNullRuler;
import com.github.jumpbyte.code.check.ruler.detail.collection.CollNotEmptyRuler;
import com.github.jumpbyte.code.check.ruler.detail.collection.CollNotNullRuler;
import com.github.jumpbyte.code.check.ruler.detail.collection.CollSizeEqRuler;
import com.github.jumpbyte.code.check.ruler.detail.collection.CollSizeGtRuler;
import com.github.jumpbyte.code.check.ruler.detail.collection.CollSizeGteRuler;
import com.github.jumpbyte.code.check.ruler.detail.collection.CollSizeLtRuler;
import com.github.jumpbyte.code.check.ruler.detail.collection.CollSizeLteRuler;

import java.util.Collection;

/**
 * @author diaowenjing
 * Date  2018-12-7
 * Time  10:51
 */
public class CollRuler {

    private static Ruler<Collection> notEmpty() {
        return new CollNotEmptyRuler();
    }

    public static Ruler<Collection> notEmpty(int failCode, String failDesc) {
        return new CollNotEmptyRuler(failCode, failDesc);
    }

    public static Ruler<Collection> sizeEq(int norm) {
        return new CollSizeEqRuler(norm);
    }

    public static Ruler<Collection> sizeEq(int norm, int failCode, String failDesc) {
        return new CollSizeEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<Collection> sizeGt(int norm) {
        return new CollSizeGtRuler(norm);
    }

    public static Ruler<Collection> sizeGt(int norm, int failCode, String failDesc) {
        return new CollSizeGtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Collection> sizeGte(int norm) {
        return new CollSizeGteRuler(norm);
    }

    public static Ruler<Collection> sizeGte(int norm, int failCode, String failDesc) {
        return new CollSizeGteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Collection> sizeLt(int norm) {
        return new CollSizeLtRuler(norm);
    }

    public static Ruler<Collection> sizeLt(int norm, int failCode, String failDesc) {
        return new CollSizeLtRuler(norm, failCode, failDesc);
    }

    public static Ruler<Collection> sizeLte(int norm) {
        return new CollSizeLteRuler(norm);
    }

    public static Ruler<Collection> sizeLte(int norm, int failCode, String failDesc) {
        return new CollSizeLteRuler(norm, failCode, failDesc);
    }

    public static Ruler<Collection> notContainsNull() {
        return new CollNotContainsNullRuler();
    }

    public static Ruler<Collection> notContainsNull(int failCode, String failDesc) {
        return new CollNotContainsNullRuler(failCode, failDesc);
    }

    public static Ruler<Collection> notContainsDup() {
        return new CollNotContainsDupRuler();
    }

    public static Ruler<Collection> notContainsDup(int failCode, String failDesc) {
        return new CollNotContainsDupRuler(failCode, failDesc);
    }

    public static Ruler<Collection> notNull() {
        return new CollNotNullRuler();
    }

    public static Ruler<Collection> notNull(int failCode, String failDesc) {
        return new CollNotNullRuler(failCode, failDesc);
    }

}
