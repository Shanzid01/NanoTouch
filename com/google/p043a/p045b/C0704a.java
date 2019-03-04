package com.google.p043a.p045b;

/* compiled from: $Gson$Preconditions */
public final class C0704a {
    public static <T> T m3573a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static void m3574a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
