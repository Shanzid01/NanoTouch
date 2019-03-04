package com.mopub.common.p050b;

import java.lang.reflect.Method;

/* compiled from: Reflection */
public class C1487j {
    public static Method m4080a(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static boolean m4081a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
