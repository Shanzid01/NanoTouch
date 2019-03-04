package com.mopub.common;

import com.mopub.common.p050b.C1486i;
import com.mopub.common.p050b.C1490m;
import com.mopub.common.p050b.C1492o;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: CacheService */
public class C1497e {
    private static C1498f f2158a;

    public static String m4093a(String str) {
        return C1492o.m4090a(str);
    }

    public static boolean m4095b(String str) {
        if (f2158a == null) {
            return false;
        }
        try {
            if (f2158a.m4108a(C1497e.m4093a(str)) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static String m4096c(String str) {
        if (f2158a == null) {
            return null;
        }
        return f2158a.m4109a() + File.separator + C1497e.m4093a(str) + "." + 0;
    }

    public static boolean m4094a(String str, InputStream inputStream) {
        if (f2158a == null) {
            return false;
        }
        C1500h c1500h = null;
        try {
            c1500h = f2158a.m4110b(C1497e.m4093a(str));
            if (c1500h == null) {
                return false;
            }
            OutputStream bufferedOutputStream = new BufferedOutputStream(c1500h.m4116a(0));
            C1490m.m4086a(inputStream, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            f2158a.m4111b();
            c1500h.m4117a();
            return true;
        } catch (Throwable e) {
            C1486i.m4077a("Unable to put to DiskLruCache", e);
            if (c1500h == null) {
                return false;
            }
            try {
                c1500h.m4118b();
                return false;
            } catch (IOException e2) {
                return false;
            }
        }
    }
}
