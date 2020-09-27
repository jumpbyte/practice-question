package com.github.jumpbyte.code.check.ruler.detail.number;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;

import java.math.BigDecimal;

import static com.github.jumpbyte.code.check.CheckResultCodeEnum.BIGDECIMAL_NOT_NULL_FAIL;


/**
 * @author diaowenjing
 * Date  2018-12-7
 * Time  10:48
 */
public class BigDecimalNotNullRuler extends BaseRuler<BigDecimal> {

    public BigDecimalNotNullRuler() {
        init(BIGDECIMAL_NOT_NULL_FAIL.getCode(), BIGDECIMAL_NOT_NULL_FAIL.getDesc());
    }

    public BigDecimalNotNullRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(BigDecimal checkTarget) {
        if(checkTarget==null){
            throw new CheckException(failCode, failDesc);
        }
    }
}

