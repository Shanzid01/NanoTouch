package com.mopub.common.p050b;

import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Utils */
public class C1492o {
    private static final AtomicLong f2157a = new AtomicLong(1);

    public static String m4090a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bytes = str.getBytes("UTF-8");
            instance.update(bytes, 0, bytes.length);
            int length = instance.digest().length;
            for (int i = 0; i < length; i++) {
                stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(r2[i])}));
            }
            return stringBuilder.toString().toLowerCase();
        } catch (Exception e) {
            return "";
        }
    }

    public static long m4089a() {
        long j;
        long j2;
        do {
            j = f2157a.get();
            j2 = j + 1;
            if (j2 > 9223372036854775806L) {
                j2 = 1;
            }
        } while (!f2157a.compareAndSet(j, j2));
        return j;
    }

    public static boolean m4091a(int i, int i2) {
        return (i & i2) != 0;
    }
}
