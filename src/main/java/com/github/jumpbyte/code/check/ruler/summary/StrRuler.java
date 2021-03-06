package com.github.jumpbyte.code.check.ruler.summary;

import com.github.jumpbyte.code.check.ruler.Ruler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrAllLetterRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrEmailRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrEmptyRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrEqRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrIdCardRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrLengthEqRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrLengthGtRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrLengthGteRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrLengthLtRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrLengthLteRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrNotEmptyRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrNotNullRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrNumRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrPhoneRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrStandardDateRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrStandardDatetimeRuler;
import com.github.jumpbyte.code.check.ruler.detail.string.StrUrlRuler;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class StrRuler {

    public static Ruler<String> notEmpty() {
        return new StrNotEmptyRuler();
    }

    public static Ruler<String> notEmpty(int failCode, String failDesc) {
        return new StrNotEmptyRuler(failCode, failDesc);
    }

    public static Ruler<String> lengthEq(int norm) {
        return new StrLengthEqRuler(norm);
    }

    public static Ruler<String> lengthEq(int norm, int failCode, String failDesc) {
        return new StrLengthEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> lengthGt(int norm) {
        return new StrLengthGtRuler(norm);
    }

    public static Ruler<String> lengthGt(int norm, int failCode, String failDesc) {
        return new StrLengthGtRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> lengthGte(int norm) {
        return new StrLengthGteRuler(norm);
    }

    public static Ruler<String> lengthGte(int norm, int failCode, String failDesc) {
        return new StrLengthGteRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> lengthLt(int norm) {
        return new StrLengthLtRuler(norm);
    }

    public static Ruler<String> lengthLt(int norm, int failCode, String failDesc) {
        return new StrLengthLtRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> lengthLte(int norm) {
        return new StrLengthLteRuler(norm);
    }

    public static Ruler<String> lengthLte(int norm, int failCode, String failDesc) {
        return new StrLengthLteRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> eq(String norm) {
        return new StrEqRuler(norm);
    }

    public static Ruler<String> eq(String norm, int failCode, String failDesc) {
        return new StrEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> idCard() {
        return new StrIdCardRuler();
    }

    public static Ruler<String> idCard(int failCode, String failDesc) {
        return new StrIdCardRuler(failCode, failDesc);
    }

    public static Ruler<String> email() {
        return new StrEmailRuler();
    }

    public static Ruler<String> email(int failCode, String failDesc) {
        return new StrEmailRuler(failCode, failDesc);
    }

    public static Ruler<String> phone() {
        return new StrPhoneRuler();
    }

    public static Ruler<String> phone(int failCode, String failDesc) {
        return new StrPhoneRuler(failCode, failDesc);
    }

    public static Ruler<String> standardDate() {
        return new StrStandardDateRuler();
    }

    public static Ruler<String> standardDate(int failCode, String failDesc) {
        return new StrStandardDateRuler(failCode, failDesc);
    }

    public static Ruler<String> standardDatetime() {
        return new StrStandardDatetimeRuler();
    }

    public static Ruler<String> standardDatetime(int failCode, String failDesc) {
        return new StrStandardDatetimeRuler(failCode, failDesc);
    }

    public static Ruler<String> num() {
        return new StrNumRuler();
    }

    public static Ruler<String> num(int failCode, String failDesc) {
        return new StrNumRuler(failCode, failDesc);
    }

    public static Ruler<String> notNull() {
        return new StrNotNullRuler();
    }

    public static Ruler<String> notNull(int failCode, String failDesc) {
        return new StrNotNullRuler(failCode, failDesc);
    }

    public static Ruler<String> url() {
        return new StrUrlRuler();
    }

    public static Ruler<String> url(int failCode, String failDesc) {
        return new StrUrlRuler(failCode, failDesc);
    }

    public static Ruler<String> allLetter() {
        return new StrAllLetterRuler();
    }

    public static Ruler<String> allLetter(int failCode, String failDesc) {
        return new StrAllLetterRuler(failCode, failDesc);
    }

    public static Ruler<String> empty() {
        return new StrEmptyRuler();
    }

    public static Ruler<String> empty(int failCode, String failDesc) {
        return new StrEmptyRuler(failCode, failDesc);
    }

}
