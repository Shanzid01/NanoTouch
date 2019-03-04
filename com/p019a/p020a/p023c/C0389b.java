package com.p019a.p020a.p023c;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: ByteString */
final class C0389b {
    public static final C0389b f1249a = new C0389b(new byte[0]);
    private final byte[] f1250b;
    private volatile int f1251c = 0;

    private C0389b(byte[] bArr) {
        this.f1250b = bArr;
    }

    public int m2590a() {
        return this.f1250b.length;
    }

    public static C0389b m2589a(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new C0389b(obj);
    }

    public static C0389b m2588a(String str) {
        try {
            return new C0389b(str.getBytes("UTF-8"));
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public void m2591a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f1250b, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0389b)) {
            return false;
        }
        C0389b c0389b = (C0389b) obj;
        int length = this.f1250b.length;
        if (length != c0389b.f1250b.length) {
            return false;
        }
        byte[] bArr = this.f1250b;
        byte[] bArr2 = c0389b.f1250b;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f1251c;
        if (i == 0) {
            byte[] bArr = this.f1250b;
            int length = this.f1250b.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                int i3 = bArr[i2] + (i * 31);
                i2++;
                i = i3;
            }
            if (i == 0) {
                i = 1;
            }
            this.f1251c = i;
        }
        return i;
    }

    public InputStream m2592b() {
        return new ByteArrayInputStream(this.f1250b);
    }
}
