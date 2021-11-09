package com.top.commons.utils;

import java.lang.ref.WeakReference;

public class CommonUtils {

    public static String hello() {
        return "hello";
    }

    public static <T> T getWeakReference(T t) {
        return new WeakReference<>(t).get();
    }
}
