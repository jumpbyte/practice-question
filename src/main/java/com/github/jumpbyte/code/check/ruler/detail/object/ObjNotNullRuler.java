package com.github.jumpbyte.code.check.ruler.detail.object;

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import com.github.jumpbyte.code.check.util.ObjectUtil;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.OBJ_NOT_NULL_FAIL;

/**
 * @author: diaowenjing
 * @date: Created in 2017-11-12
 */
public class ObjNotNullRuler extends BaseRuler<Object> {


    public ObjNotNullRuler() {
        init(OBJ_NOT_NULL_FAIL.getCode(), OBJ_NOT_NULL_FAIL.getDesc());
    }

    public ObjNotNullRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Object checkTarget) {
        if (ObjectUtil.isNotNull(checkTarget)) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }

}
