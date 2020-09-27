package com.github.jumpbyte.code.check;


/**
 * @author: diaowenjing
 * @date: Created in 18-6-27
 */
public class CheckException extends RuntimeException {

    /**
     * 校验结果码
     */
    private int code;

    /**
     * 校验结果描述
     */
    private String desc;

    public CheckException(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public CheckException(int code, String desc, CheckException e) {
        super(e);
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getMessage() {
        return "code=" + code + ", desc=" + desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
