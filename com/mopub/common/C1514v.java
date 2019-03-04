package com.mopub.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* compiled from: HttpResponses */
public final class C1514v {
    public static Bitmap m4154a(C1505m c1505m) {
        if (c1505m == null) {
            return null;
        }
        byte[] a = c1505m.m4131a();
        return BitmapFactory.decodeByteArray(a, 0, a.length);
    }

    public static String m4155b(C1505m c1505m) {
        if (c1505m == null) {
            return null;
        }
        try {
            return new String(c1505m.m4131a(), "UTF-8");
        } catch (Exception e) {
            return null;
        }
    }
}
