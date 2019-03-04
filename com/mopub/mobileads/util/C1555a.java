package com.mopub.mobileads.util;

import java.io.UnsupportedEncodingException;

/* compiled from: Base64 */
public class C1555a {
    static final /* synthetic */ boolean f2547a;

    static {
        boolean z;
        if (C1555a.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f2547a = z;
    }

    public static String m4657a(byte[] bArr, int i) {
        try {
            return new String(C1555a.m4659b(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] m4659b(byte[] bArr, int i) {
        return C1555a.m4658a(bArr, 0, bArr.length, i);
    }

    public static byte[] m4658a(byte[] bArr, int i, int i2, int i3) {
        C1557c c1557c = new C1557c(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!c1557c.f2554d) {
            switch (i2 % 3) {
                case 0:
                    break;
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (c1557c.f2555e && i2 > 0) {
            int i5;
            int i6 = ((i2 - 1) / 57) + 1;
            if (c1557c.f2556f) {
                i5 = 2;
            } else {
                i5 = 1;
            }
            i4 += i5 * i6;
        }
        c1557c.a = new byte[i4];
        c1557c.m4660a(bArr, i, i2, true);
        if (f2547a || c1557c.b == i4) {
            return c1557c.a;
        }
        throw new AssertionError();
    }

    private C1555a() {
    }
}
