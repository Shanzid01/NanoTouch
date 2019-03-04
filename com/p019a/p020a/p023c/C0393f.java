package com.p019a.p020a.p023c;

import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: CodedOutputStream */
final class C0393f implements Flushable {
    private final byte[] f1329a;
    private final int f1330b;
    private int f1331c = 0;
    private final OutputStream f1332d;

    private C0393f(OutputStream outputStream, byte[] bArr) {
        this.f1332d = outputStream;
        this.f1329a = bArr;
        this.f1330b = bArr.length;
    }

    public static C0393f m2709a(OutputStream outputStream) {
        return C0393f.m2710a(outputStream, 4096);
    }

    public static C0393f m2710a(OutputStream outputStream, int i) {
        return new C0393f(outputStream, new byte[i]);
    }

    public void m2734a(int i, float f) {
        m2754g(i, 5);
        m2732a(f);
    }

    public void m2736a(int i, long j) {
        m2754g(i, 0);
        m2740a(j);
    }

    public void m2739a(int i, boolean z) {
        m2754g(i, 0);
        m2744a(z);
    }

    public void m2738a(int i, String str) {
        m2754g(i, 2);
        m2743a(str);
    }

    public void m2737a(int i, C0389b c0389b) {
        m2754g(i, 2);
        m2741a(c0389b);
    }

    public void m2735a(int i, int i2) {
        m2754g(i, 0);
        m2747b(i2);
    }

    public void m2748b(int i, int i2) {
        m2754g(i, 0);
        m2749c(i2);
    }

    public void m2750c(int i, int i2) {
        m2754g(i, 0);
        m2753d(i2);
    }

    public void m2732a(float f) {
        m2757m(Float.floatToRawIntBits(f));
    }

    public void m2740a(long j) {
        m2751c(j);
    }

    public void m2733a(int i) {
        if (i >= 0) {
            m2756k(i);
        } else {
            m2751c((long) i);
        }
    }

    public void m2744a(boolean z) {
        m2755i(z ? 1 : 0);
    }

    public void m2743a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m2756k(bytes.length);
        m2745a(bytes);
    }

    public void m2741a(C0389b c0389b) {
        m2756k(c0389b.m2590a());
        m2752c(c0389b);
    }

    public void m2747b(int i) {
        m2756k(i);
    }

    public void m2749c(int i) {
        m2733a(i);
    }

    public void m2753d(int i) {
        m2756k(C0393f.m2730n(i));
    }

    public static int m2713b(int i, float f) {
        return C0393f.m2728j(i) + C0393f.m2712b(f);
    }

    public static int m2714b(int i, long j) {
        return C0393f.m2728j(i) + C0393f.m2717b(j);
    }

    public static int m2716b(int i, boolean z) {
        return C0393f.m2728j(i) + C0393f.m2719b(z);
    }

    public static int m2715b(int i, C0389b c0389b) {
        return C0393f.m2728j(i) + C0393f.m2718b(c0389b);
    }

    public static int m2720d(int i, int i2) {
        return C0393f.m2728j(i) + C0393f.m2724f(i2);
    }

    public static int m2723e(int i, int i2) {
        return C0393f.m2728j(i) + C0393f.m2726g(i2);
    }

    public static int m2725f(int i, int i2) {
        return C0393f.m2728j(i) + C0393f.m2727h(i2);
    }

    public static int m2712b(float f) {
        return 4;
    }

    public static int m2717b(long j) {
        return C0393f.m2721d(j);
    }

    public static int m2722e(int i) {
        if (i >= 0) {
            return C0393f.m2729l(i);
        }
        return 10;
    }

    public static int m2719b(boolean z) {
        return 1;
    }

    public static int m2718b(C0389b c0389b) {
        return C0393f.m2729l(c0389b.m2590a()) + c0389b.m2590a();
    }

    public static int m2724f(int i) {
        return C0393f.m2729l(i);
    }

    public static int m2726g(int i) {
        return C0393f.m2722e(i);
    }

    public static int m2727h(int i) {
        return C0393f.m2729l(C0393f.m2730n(i));
    }

    private void m2711a() {
        if (this.f1332d == null) {
            throw new C0394g();
        }
        this.f1332d.write(this.f1329a, 0, this.f1331c);
        this.f1331c = 0;
    }

    public void flush() {
        if (this.f1332d != null) {
            m2711a();
        }
    }

    public void m2731a(byte b) {
        if (this.f1331c == this.f1330b) {
            m2711a();
        }
        byte[] bArr = this.f1329a;
        int i = this.f1331c;
        this.f1331c = i + 1;
        bArr[i] = b;
    }

    public void m2755i(int i) {
        m2731a((byte) i);
    }

    public void m2752c(C0389b c0389b) {
        m2742a(c0389b, 0, c0389b.m2590a());
    }

    public void m2745a(byte[] bArr) {
        m2746a(bArr, 0, bArr.length);
    }

    public void m2746a(byte[] bArr, int i, int i2) {
        if (this.f1330b - this.f1331c >= i2) {
            System.arraycopy(bArr, i, this.f1329a, this.f1331c, i2);
            this.f1331c += i2;
            return;
        }
        int i3 = this.f1330b - this.f1331c;
        System.arraycopy(bArr, i, this.f1329a, this.f1331c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f1331c = this.f1330b;
        m2711a();
        if (i3 <= this.f1330b) {
            System.arraycopy(bArr, i4, this.f1329a, 0, i3);
            this.f1331c = i3;
            return;
        }
        this.f1332d.write(bArr, i4, i3);
    }

    public void m2742a(C0389b c0389b, int i, int i2) {
        if (this.f1330b - this.f1331c >= i2) {
            c0389b.m2591a(this.f1329a, i, this.f1331c, i2);
            this.f1331c += i2;
            return;
        }
        int i3 = this.f1330b - this.f1331c;
        c0389b.m2591a(this.f1329a, i, this.f1331c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f1331c = this.f1330b;
        m2711a();
        if (i3 <= this.f1330b) {
            c0389b.m2591a(this.f1329a, i4, 0, i3);
            this.f1331c = i3;
            return;
        }
        InputStream b = c0389b.m2592b();
        if (((long) i4) != b.skip((long) i4)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i3 > 0) {
            i4 = Math.min(i3, this.f1330b);
            int read = b.read(this.f1329a, 0, i4);
            if (read != i4) {
                throw new IllegalStateException("Read failed.");
            }
            this.f1332d.write(this.f1329a, 0, read);
            i3 -= read;
        }
    }

    public void m2754g(int i, int i2) {
        m2756k(cd.m2707a(i, i2));
    }

    public static int m2728j(int i) {
        return C0393f.m2729l(cd.m2707a(i, 0));
    }

    public void m2756k(int i) {
        while ((i & -128) != 0) {
            m2755i((i & 127) | 128);
            i >>>= 7;
        }
        m2755i(i);
    }

    public static int m2729l(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    public void m2751c(long j) {
        while ((-128 & j) != 0) {
            m2755i((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m2755i((int) j);
    }

    public static int m2721d(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }

    public void m2757m(int i) {
        m2755i(i & 255);
        m2755i((i >> 8) & 255);
        m2755i((i >> 16) & 255);
        m2755i((i >> 24) & 255);
    }

    public static int m2730n(int i) {
        return (i << 1) ^ (i >> 31);
    }
}
