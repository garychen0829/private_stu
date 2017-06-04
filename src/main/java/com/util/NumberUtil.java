package com.util;

import java.util.UUID;

/**
 * Created by xql on 2017/5/31.
 */
public class NumberUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
