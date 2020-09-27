package com.github.jumpbyte.code.check.ruler.detail.collection;

/**
 * @author diaowenjing
 * Date  2018-12-7
 * Time  10:51
 */

import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Collection;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.COLL_NOT_CONTAINS_NULL_FAIL;

/**
 * @author diaowenjing
 * Date  2018-12-7
 * Time  10:51
 */
public class CollNotContainsNullRuler extends BaseRuler<Collection> {


    public CollNotContainsNullRuler() {
        init(COLL_NOT_CONTAINS_NULL_FAIL.getCode(), COLL_NOT_CONTAINS_NULL_FAIL.getDesc());
    }

    public CollNotContainsNullRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Collection checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (isNotContainsNull(checkTarget.toArray())) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }
    public static boolean isContainsNull(Object[] target) {
        return ArrayUtils.contains(target, null);
    }

    public static boolean isNotContainsNull(Object[] target) {
        return !isContainsNull(target);
    }

}
