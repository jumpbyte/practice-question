package com.github.jumpbyte.code.check;

/**
 * @author diaowenjing
 * Date  2018-12-4
 * Time  11:04
 */
public enum CheckResultCodeEnum {

    /**
     * object
     */
    OBJ_NOT_NULL_FAIL(-10000, "不能为Null"),

    /**
     * string
     */
    STR_NOT_EMPTY_FAIL(-11000,"不能为空"),
    STR_LENGTH_EQ_FAIL(-11001,"的长度必须等于%d"),
    STR_LENGTH_GT_FAIL(-11002,"的长度必须大于%d"),
    STR_LENGTH_GTE_FAIL(-11003,"的长度必须大于或等于%d"),
    STR_LENGTH_LT_FAIL(-11004,"的长度必须小于%d"),
    STR_LENGTH_LTE_FAIL(-11005,"的长度必须小于或等于%d"),
    STR_EQ_FAIL(-11006,"的值必须是%s"),
    STR_ID_CARD_FAIL(-11007, "必须符合身份证格式"),
    STR_EMAIL_FAIL(-11008, "必须符合邮箱格式"),
    STR_PHONE_FAIL(-11009, "必须符合手机号格式"),
    STR_STANDARD_DATE_FAIL(-11010, "必须符合yyyy-MM-dd格式"),
    STR_STANDARD_DATETIME_FAIL(-11011, "必须符合yyyy-MM-dd HH:mm:ss格式"),
    STR_NUM_FAIL(-11012, "必须符合数字格式"),
    STR_NOT_NULL_FAIL(-11013, "不能为Null"),
    STR_URL_FAIL(-11014,"必须符合URL规则"),
    STR_ALL_LETTER_FAIL(-11015,"必须符合全字母规则"),
    STR_EMPTY_FAIL(-11016,"必须为空"),

    /**
     * date
     */
    DATE_EQ_FAIL(-12000, "必须是%tc(时间戳:%tQ)"),
    DATE_AFTER_FAIL(-12001, "必须晚于%tc(时间戳:%tQ)"),
    DATE_AFTER_OR_EQ_FAIL(-12002, "必须晚于或等于%tc(时间戳:%tQ)"),
    DATE_BEFORE_FAIL(-12003, "必须早于%tc(时间戳:%tQ)"),
    DATE_BEFORE_OR_EQ_FAIL(-12004, "必须早于或等于%tc(时间戳:%tQ)"),
    DATE_NOT_NULL_FAIL(-12005, "不能为Null"),
    /**
     * short
     */
    SHORT_EQ_FAIL(-17001,"必须等于%d"),
    SHORT_GT_FAIL(-17002,"必须大于%d"),
    SHORT_GTE_FAIL(-17003,"必须大于或等于%d"),
    SHORT_LT_FAIL(-17004,"必须小于%d"),
    SHORT_LTE_FAIL(-17005,"必须小于或等于%d"),
    SHORT_NOT_NULL_FAIL(-17006, "不能为Null"),

    /**
     * int
     */
    INT_EQ_FAIL(-18001,"必须等于%d"),
    INT_GT_FAIL(-18002,"必须大于%d"),
    INT_GTE_FAIL(-18003,"必须大于或等于%d"),
    INT_LT_FAIL(-18004,"必须小于%d"),
    INT_LTE_FAIL(-18005,"必须小于或等于%d"),
    INT_NOT_NULL_FAIL(-18006, "不能为Null"),

    /**
     * long
     */
    LONG_EQ_FAIL(-19001,"必须等于%d"),
    LONG_GT_FAIL(-19002,"必须大于%d"),
    LONG_GTE_FAIL(-19003,"必须大于或等于%d"),
    LONG_LT_FAIL(-19004,"必须小于%d"),
    LONG_LTE_FAIL(-19005,"必须小于或等于%d"),
    LONG_NOT_NULL_FAIL(-19006, "不能为Null"),

    /**
     * float
     */
    FLOAT_EQ_FAIL(-20001,"必须等于%f"),
    FLOAT_GT_FAIL(-20002,"必须大于%f"),
    FLOAT_GTE_FAIL(-20003,"必须大于或等于%f"),
    FLOAT_LT_FAIL(-20004,"必须小于%f"),
    FLOAT_LTE_FAIL(-20005,"必须小于或等于%f"),
    FLOAT_NOT_NULL_FAIL(-20006, "不能为Null"),

    /**
     * double
     */
    DOUBLE_EQ_FAIL(-21001,"必须等于%f"),
    DOUBLE_GT_FAIL(-21002,"必须大于%f"),
    DOUBLE_GTE_FAIL(-21003,"必须大于或等于%f"),
    DOUBLE_LT_FAIL(-21004,"必须小于%f"),
    DOUBLE_LTE_FAIL(-21005,"必须小于或等于%f"),
    DOUBLE_NOT_NULL_FAIL(-21006, "不能为Null"),
    /**
     * collection
     */
    COLL_NOT_EMPTY_FAIL(-14000,"不能为空"),
    COLL_SIZE_EQ_FAIL(-14001,"的长度必须等于%d"),
    COLL_SIZE_GT_FAIL(-14002,"的长度必须大于%d"),
    COLL_SIZE_GTE_FAIL(-14003,"的长度必须大于或等于%d"),
    COLL_SIZE_LT_FAIL(-14004,"的长度必须小于%d"),
    COLL_SIZE_LTE_FAIL(-14005,"的长度必须小于或等于%d"),
    COLL_NOT_CONTAINS_NULL_FAIL(-14006,"中不能有空值"),
    COLL_NOT_CONTAINS_DUP_FAIL(-14007,"中不能有重复值"),
    COLL_NOT_NULL_FAIL(-14008, "不能为Null"),
    /**
     * bigdecimal
     */

    BIGDECIMAL_NOT_NULL_FAIL(-22001, "不能为Null");


    private int code;
    private String desc;

    CheckResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
