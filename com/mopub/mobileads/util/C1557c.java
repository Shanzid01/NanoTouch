package com.mopub.mobileads.util;

/* compiled from: Base64 */
class C1557c extends C1556b {
    static final /* synthetic */ boolean f2550g;
    private static final byte[] f2551h = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    private static final byte[] f2552i = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
    int f2553c;
    public final boolean f2554d;
    public final boolean f2555e;
    public final boolean f2556f;
    private final byte[] f2557j;
    private int f2558k;
    private final byte[] f2559l;

    static {
        boolean z;
        if (C1555a.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f2550g = z;
    }

    public C1557c(int i, byte[] bArr) {
        boolean z;
        boolean z2 = true;
        this.a = bArr;
        this.f2554d = (i & 1) == 0;
        if ((i & 2) == 0) {
            z = true;
        } else {
            z = false;
        }
        this.f2555e = z;
        if ((i & 4) == 0) {
            z2 = false;
        }
        this.f2556f = z2;
        this.f2559l = (i & 8) == 0 ? f2551h : f2552i;
        this.f2557j = new byte[2];
        this.f2553c = 0;
        this.f2558k = this.f2555e ? 19 : -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m4660a(byte[] r12, int r13, int r14, boolean r15) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r11 = this;
        r6 = r11.f2559l;
        r7 = r11.a;
        r1 = 0;
        r0 = r11.f2558k;
        r8 = r14 + r13;
        r2 = -1;
        r3 = r11.f2553c;
        switch(r3) {
            case 0: goto L_0x00b4;
            case 1: goto L_0x00b7;
            case 2: goto L_0x00da;
            default: goto L_0x000f;
        };
    L_0x000f:
        r3 = r13;
    L_0x0010:
        r4 = -1;
        if (r2 == r4) goto L_0x0241;
    L_0x0013:
        r4 = 1;
        r5 = r2 >> 18;
        r5 = r5 & 63;
        r5 = r6[r5];
        r7[r1] = r5;
        r1 = 2;
        r5 = r2 >> 12;
        r5 = r5 & 63;
        r5 = r6[r5];
        r7[r4] = r5;
        r4 = 3;
        r5 = r2 >> 6;
        r5 = r5 & 63;
        r5 = r6[r5];
        r7[r1] = r5;
        r1 = 4;
        r2 = r2 & 63;
        r2 = r6[r2];
        r7[r4] = r2;
        r0 = r0 + -1;
        if (r0 != 0) goto L_0x0241;
    L_0x0039:
        r0 = r11.f2556f;
        if (r0 == 0) goto L_0x0245;
    L_0x003d:
        r0 = 5;
        r2 = 13;
        r7[r1] = r2;
    L_0x0042:
        r1 = r0 + 1;
        r2 = 10;
        r7[r0] = r2;
        r0 = 19;
        r5 = r0;
        r4 = r1;
    L_0x004c:
        r0 = r3 + 3;
        if (r0 <= r8) goto L_0x00fd;
    L_0x0050:
        if (r15 == 0) goto L_0x01fd;
    L_0x0052:
        r0 = r11.f2553c;
        r0 = r3 - r0;
        r1 = r8 + -1;
        if (r0 != r1) goto L_0x015e;
    L_0x005a:
        r2 = 0;
        r0 = r11.f2553c;
        if (r0 <= 0) goto L_0x0155;
    L_0x005f:
        r0 = r11.f2557j;
        r1 = 1;
        r0 = r0[r2];
        r2 = r3;
    L_0x0065:
        r0 = r0 & 255;
        r3 = r0 << 4;
        r0 = r11.f2553c;
        r0 = r0 - r1;
        r11.f2553c = r0;
        r1 = r4 + 1;
        r0 = r3 >> 6;
        r0 = r0 & 63;
        r0 = r6[r0];
        r7[r4] = r0;
        r0 = r1 + 1;
        r3 = r3 & 63;
        r3 = r6[r3];
        r7[r1] = r3;
        r1 = r11.f2554d;
        if (r1 == 0) goto L_0x0090;
    L_0x0084:
        r1 = r0 + 1;
        r3 = 61;
        r7[r0] = r3;
        r0 = r1 + 1;
        r3 = 61;
        r7[r1] = r3;
    L_0x0090:
        r1 = r11.f2555e;
        if (r1 == 0) goto L_0x023a;
    L_0x0094:
        r1 = r11.f2556f;
        if (r1 == 0) goto L_0x009f;
    L_0x0098:
        r1 = r0 + 1;
        r3 = 13;
        r7[r0] = r3;
        r0 = r1;
    L_0x009f:
        r4 = r0 + 1;
        r1 = 10;
        r7[r0] = r1;
        r3 = r2;
    L_0x00a6:
        r0 = f2550g;
        if (r0 != 0) goto L_0x01f1;
    L_0x00aa:
        r0 = r11.f2553c;
        if (r0 == 0) goto L_0x01f1;
    L_0x00ae:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x00b4:
        r3 = r13;
        goto L_0x0010;
    L_0x00b7:
        r3 = r13 + 2;
        if (r3 > r8) goto L_0x000f;
    L_0x00bb:
        r2 = r11.f2557j;
        r3 = 0;
        r2 = r2[r3];
        r2 = r2 & 255;
        r2 = r2 << 16;
        r3 = r13 + 1;
        r4 = r12[r13];
        r4 = r4 & 255;
        r4 = r4 << 8;
        r2 = r2 | r4;
        r13 = r3 + 1;
        r3 = r12[r3];
        r3 = r3 & 255;
        r2 = r2 | r3;
        r3 = 0;
        r11.f2553c = r3;
        r3 = r13;
        goto L_0x0010;
    L_0x00da:
        r3 = r13 + 1;
        if (r3 > r8) goto L_0x000f;
    L_0x00de:
        r2 = r11.f2557j;
        r3 = 0;
        r2 = r2[r3];
        r2 = r2 & 255;
        r2 = r2 << 16;
        r3 = r11.f2557j;
        r4 = 1;
        r3 = r3[r4];
        r3 = r3 & 255;
        r3 = r3 << 8;
        r2 = r2 | r3;
        r3 = r13 + 1;
        r4 = r12[r13];
        r4 = r4 & 255;
        r2 = r2 | r4;
        r4 = 0;
        r11.f2553c = r4;
        goto L_0x0010;
    L_0x00fd:
        r0 = r12[r3];
        r0 = r0 & 255;
        r0 = r0 << 16;
        r1 = r3 + 1;
        r1 = r12[r1];
        r1 = r1 & 255;
        r1 = r1 << 8;
        r0 = r0 | r1;
        r1 = r3 + 2;
        r1 = r12[r1];
        r1 = r1 & 255;
        r0 = r0 | r1;
        r1 = r0 >> 18;
        r1 = r1 & 63;
        r1 = r6[r1];
        r7[r4] = r1;
        r1 = r4 + 1;
        r2 = r0 >> 12;
        r2 = r2 & 63;
        r2 = r6[r2];
        r7[r1] = r2;
        r1 = r4 + 2;
        r2 = r0 >> 6;
        r2 = r2 & 63;
        r2 = r6[r2];
        r7[r1] = r2;
        r1 = r4 + 3;
        r0 = r0 & 63;
        r0 = r6[r0];
        r7[r1] = r0;
        r3 = r3 + 3;
        r1 = r4 + 4;
        r0 = r5 + -1;
        if (r0 != 0) goto L_0x0241;
    L_0x013f:
        r0 = r11.f2556f;
        if (r0 == 0) goto L_0x023e;
    L_0x0143:
        r0 = r1 + 1;
        r2 = 13;
        r7[r1] = r2;
    L_0x0149:
        r1 = r0 + 1;
        r2 = 10;
        r7[r0] = r2;
        r0 = 19;
        r5 = r0;
        r4 = r1;
        goto L_0x004c;
    L_0x0155:
        r1 = r3 + 1;
        r0 = r12[r3];
        r10 = r2;
        r2 = r1;
        r1 = r10;
        goto L_0x0065;
    L_0x015e:
        r0 = r11.f2553c;
        r0 = r3 - r0;
        r1 = r8 + -2;
        if (r0 != r1) goto L_0x01d5;
    L_0x0166:
        r2 = 0;
        r0 = r11.f2553c;
        r1 = 1;
        if (r0 <= r1) goto L_0x01c8;
    L_0x016c:
        r0 = r11.f2557j;
        r1 = 1;
        r0 = r0[r2];
    L_0x0171:
        r0 = r0 & 255;
        r9 = r0 << 10;
        r0 = r11.f2553c;
        if (r0 <= 0) goto L_0x01cf;
    L_0x0179:
        r0 = r11.f2557j;
        r2 = r1 + 1;
        r0 = r0[r1];
        r1 = r2;
    L_0x0180:
        r0 = r0 & 255;
        r0 = r0 << 2;
        r0 = r0 | r9;
        r2 = r11.f2553c;
        r1 = r2 - r1;
        r11.f2553c = r1;
        r1 = r4 + 1;
        r2 = r0 >> 12;
        r2 = r2 & 63;
        r2 = r6[r2];
        r7[r4] = r2;
        r2 = r1 + 1;
        r4 = r0 >> 6;
        r4 = r4 & 63;
        r4 = r6[r4];
        r7[r1] = r4;
        r1 = r2 + 1;
        r0 = r0 & 63;
        r0 = r6[r0];
        r7[r2] = r0;
        r0 = r11.f2554d;
        if (r0 == 0) goto L_0x0237;
    L_0x01ab:
        r0 = r1 + 1;
        r2 = 61;
        r7[r1] = r2;
    L_0x01b1:
        r1 = r11.f2555e;
        if (r1 == 0) goto L_0x0234;
    L_0x01b5:
        r1 = r11.f2556f;
        if (r1 == 0) goto L_0x01c0;
    L_0x01b9:
        r1 = r0 + 1;
        r2 = 13;
        r7[r0] = r2;
        r0 = r1;
    L_0x01c0:
        r4 = r0 + 1;
        r1 = 10;
        r7[r0] = r1;
        goto L_0x00a6;
    L_0x01c8:
        r1 = r3 + 1;
        r0 = r12[r3];
        r3 = r1;
        r1 = r2;
        goto L_0x0171;
    L_0x01cf:
        r2 = r3 + 1;
        r0 = r12[r3];
        r3 = r2;
        goto L_0x0180;
    L_0x01d5:
        r0 = r11.f2555e;
        if (r0 == 0) goto L_0x00a6;
    L_0x01d9:
        if (r4 <= 0) goto L_0x00a6;
    L_0x01db:
        r0 = 19;
        if (r5 == r0) goto L_0x00a6;
    L_0x01df:
        r0 = r11.f2556f;
        if (r0 == 0) goto L_0x0232;
    L_0x01e3:
        r0 = r4 + 1;
        r1 = 13;
        r7[r4] = r1;
    L_0x01e9:
        r4 = r0 + 1;
        r1 = 10;
        r7[r0] = r1;
        goto L_0x00a6;
    L_0x01f1:
        r0 = f2550g;
        if (r0 != 0) goto L_0x020d;
    L_0x01f5:
        if (r3 == r8) goto L_0x020d;
    L_0x01f7:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x01fd:
        r0 = r8 + -1;
        if (r3 != r0) goto L_0x0213;
    L_0x0201:
        r0 = r11.f2557j;
        r1 = r11.f2553c;
        r2 = r1 + 1;
        r11.f2553c = r2;
        r2 = r12[r3];
        r0[r1] = r2;
    L_0x020d:
        r11.b = r4;
        r11.f2558k = r5;
        r0 = 1;
        return r0;
    L_0x0213:
        r0 = r8 + -2;
        if (r3 != r0) goto L_0x020d;
    L_0x0217:
        r0 = r11.f2557j;
        r1 = r11.f2553c;
        r2 = r1 + 1;
        r11.f2553c = r2;
        r2 = r12[r3];
        r0[r1] = r2;
        r0 = r11.f2557j;
        r1 = r11.f2553c;
        r2 = r1 + 1;
        r11.f2553c = r2;
        r2 = r3 + 1;
        r2 = r12[r2];
        r0[r1] = r2;
        goto L_0x020d;
    L_0x0232:
        r0 = r4;
        goto L_0x01e9;
    L_0x0234:
        r4 = r0;
        goto L_0x00a6;
    L_0x0237:
        r0 = r1;
        goto L_0x01b1;
    L_0x023a:
        r3 = r2;
        r4 = r0;
        goto L_0x00a6;
    L_0x023e:
        r0 = r1;
        goto L_0x0149;
    L_0x0241:
        r5 = r0;
        r4 = r1;
        goto L_0x004c;
    L_0x0245:
        r0 = r1;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.util.c.a(byte[], int, int, boolean):boolean");
    }
}
