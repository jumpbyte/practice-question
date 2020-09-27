package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.CheckResultCodeEnum;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.NumberUtil;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class FloatLteRuler extends BaseRuler<Float> {

    private Float norm;

    public FloatLteRuler(Float norm) {
        init(norm, CheckResultCodeEnum.FLOAT_LTE_FAIL.getCode(), CheckResultCodeEnum.FLOAT_LTE_FAIL.getDesc());
    }

    public FloatLteRuler(Float norm, int failCode, String failDesc) {
        init(norm, failCode, failDesc);
    }

    private void init(Float norm, int failCode, String failDesc) {
        this.norm = norm;
        init(failCode, failDesc);
    }

    @Override
    public void check(Float checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (NumberUtil.isLte(checkTarget, norm)) {
            return;
        }
        throw new CheckException(failCode, String.format(failDesc, norm));
    }

}
