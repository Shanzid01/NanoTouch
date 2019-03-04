package com.p019a.p020a.p023c;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p012b.C0226z;

/* compiled from: CLSUUID */
class C0390c {
    private static final AtomicLong f1312a = new AtomicLong(0);
    private static String f1313b;

    public C0390c(C0226z c0226z) {
        r0 = new byte[10];
        m2695a(r0);
        m2697b(r0);
        m2699c(r0);
        String a = C0214m.m1903a(c0226z.m1959b());
        String a2 = C0214m.m1905a(r0);
        f1313b = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{a2.substring(0, 12), a2.substring(12, 16), a2.subSequence(16, 20), a.substring(0, 12)}).toUpperCase(Locale.US);
    }

    private void m2695a(byte[] bArr) {
        long time = new Date().getTime();
        long j = time / 1000;
        time %= 1000;
        byte[] a = C0390c.m2696a(j);
        bArr[0] = a[0];
        bArr[1] = a[1];
        bArr[2] = a[2];
        bArr[3] = a[3];
        byte[] b = C0390c.m2698b(time);
        bArr[4] = b[0];
        bArr[5] = b[1];
    }

    private void m2697b(byte[] bArr) {
        byte[] b = C0390c.m2698b(f1312a.incrementAndGet());
        bArr[6] = b[0];
        bArr[7] = b[1];
    }

    private void m2699c(byte[] bArr) {
        byte[] b = C0390c.m2698b((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b[0];
        bArr[9] = b[1];
    }

    private static byte[] m2696a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] m2698b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public String toString() {
        return f1313b;
    }
}
