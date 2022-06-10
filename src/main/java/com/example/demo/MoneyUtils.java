package com.example.demo;

import java.util.Collection;

public class MoneyUtils {
    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    /**
     * 判断集合是否为空
     */
    public static boolean collectionIsEmpty(Collection<? extends Object> data) {
        return null == data || data.size() <= 0;
    }

    /**
     * 判断集合是否越界
     */
    public static boolean collectionIsSafe(Collection<? extends Object> data, int pos) {
        if (null == data || data.size() <= 0) {
            return false;
        }
        if (pos < 0 || pos > data.size() - 1) {
            return false;
        }
        return true;
    }
}
