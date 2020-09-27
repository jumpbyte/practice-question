package com.github.jumpbyte.code.check.ruler.summary;

import com.github.jumpbyte.code.check.ruler.Ruler;
import com.github.jumpbyte.code.check.ruler.detail.object.ObjNotNullRuler;

/**
 * @author: liurenpeng
 * @date: Created in 2017-11-12
 */
public class ObjRuler {

    public static Ruler<Object> notNull() {
        return new ObjNotNullRuler();
    }

    public static Ruler<Object> notNull(int failCode, String failDesc) {
        return new ObjNotNullRuler(failCode, failDesc);
    }

}
