package com.google.p043a.p045b;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Primitives */
public final class af {
    private static final Map<Class<?>, Class<?>> f1831a;
    private static final Map<Class<?>, Class<?>> f1832b;

    static {
        Map hashMap = new HashMap(16);
        Map hashMap2 = new HashMap(16);
        af.m3580a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        af.m3580a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        af.m3580a(hashMap, hashMap2, Character.TYPE, Character.class);
        af.m3580a(hashMap, hashMap2, Double.TYPE, Double.class);
        af.m3580a(hashMap, hashMap2, Float.TYPE, Float.class);
        af.m3580a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        af.m3580a(hashMap, hashMap2, Long.TYPE, Long.class);
        af.m3580a(hashMap, hashMap2, Short.TYPE, Short.class);
        af.m3580a(hashMap, hashMap2, Void.TYPE, Void.class);
        f1831a = Collections.unmodifiableMap(hashMap);
        f1832b = Collections.unmodifiableMap(hashMap2);
    }

    private static void m3580a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean m3581a(Type type) {
        return f1831a.containsKey(type);
    }

    public static <T> Class<T> m3579a(Class<T> cls) {
        Class<T> cls2 = (Class) f1831a.get(C0704a.m3573a((Object) cls));
        return cls2 == null ? cls : cls2;
    }
}
