package com.github.jumpbyte.code.check.ruler;

/**
 * @author: diaowenjing
 * @date: Created in 18-6-27
 */
public abstract class BaseRuler<T> implements Ruler<T> {

    protected int failCode;
    protected String failDesc;

    protected void init(int failCode, String failDesc) {
        this.failCode = failCode;
        this.failDesc = failDesc;
    }

}
