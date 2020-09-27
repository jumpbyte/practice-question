package com.github.jumpbyte.code.check.ruler.detail.collection;



import com.github.jumpbyte.code.check.CheckException;
import com.github.jumpbyte.code.check.ruler.BaseRuler;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static com.daojia.suyun.driver.common.check.CheckResultCodeEnum.COLL_NOT_CONTAINS_DUP_FAIL;


/**
 * @author diaowenjing
 * Date  2018-12-7
 * Time  10:51
 */
public class CollNotContainsDupRuler extends BaseRuler<Collection> {


    public CollNotContainsDupRuler() {
        init(COLL_NOT_CONTAINS_DUP_FAIL.getCode(), COLL_NOT_CONTAINS_DUP_FAIL.getDesc());
    }

    public CollNotContainsDupRuler(int failCode, String failDesc) {
        init(failCode, failDesc);
    }

    @Override
    public void check(Collection checkTarget) {
        if (null == checkTarget) {
            return;
        }
        if (isNotContainsDup(checkTarget.toArray())) {
            return;
        }
        throw new CheckException(failCode, failDesc);
    }
    public static boolean isContainsDup(Object[] target) {
        Set<Object> targetSet = new HashSet<>();
        CollectionUtils.addAll(targetSet, target);
        return targetSet.size() != target.length;
    }

    public static boolean isNotContainsDup(Object[] target) {
        return !isContainsDup(target);
    }
}
