package com.google.android.gms.internal;

public final class zzwn extends zzws<zzwn> {
    public zza[] zzaGS;

    public final class zza extends zzws<zza> {
        private static volatile zza[] zzaGT;
        public String name;
        public zza zzaGU;

        public final class zza extends zzws<zza> {
            private static volatile zza[] zzaGV;
            public int type;
            public zza zzaGW;

            public final class zza extends zzws<zza> {
                public byte[] zzaGX;
                public String zzaGY;
                public double zzaGZ;
                public float zzaHa;
                public long zzaHb;
                public int zzaHc;
                public int zzaHd;
                public boolean zzaHe;
                public zza[] zzaHf;
                public zza[] zzaHg;
                public String[] zzaHh;
                public long[] zzaHi;
                public float[] zzaHj;
                public long zzaHk;

                public zza() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    r0.zzvs();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zza.<init>():void");
                }

                public boolean equals(java.lang.Object r7) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r6 = this;
                    r0 = 0;
                    if (r7 != r6) goto L_0x0005;
                L_0x0003:
                    r0 = 1;
                L_0x0004:
                    return r0;
                L_0x0005:
                    r1 = r7 instanceof com.google.android.gms.internal.zzwn.zza.zza.zza;
                    if (r1 == 0) goto L_0x0004;
                L_0x0009:
                    r7 = (com.google.android.gms.internal.zzwn.zza.zza.zza) r7;
                    r1 = r6.zzaGX;
                    r2 = r7.zzaGX;
                    r1 = java.util.Arrays.equals(r1, r2);
                    if (r1 == 0) goto L_0x0004;
                L_0x0015:
                    r1 = r6.zzaGY;
                    if (r1 != 0) goto L_0x0095;
                L_0x0019:
                    r1 = r7.zzaGY;
                    if (r1 != 0) goto L_0x0004;
                L_0x001d:
                    r2 = r6.zzaGZ;
                    r2 = java.lang.Double.doubleToLongBits(r2);
                    r4 = r7.zzaGZ;
                    r4 = java.lang.Double.doubleToLongBits(r4);
                    r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r1 != 0) goto L_0x0004;
                L_0x002d:
                    r1 = r6.zzaHa;
                    r1 = java.lang.Float.floatToIntBits(r1);
                    r2 = r7.zzaHa;
                    r2 = java.lang.Float.floatToIntBits(r2);
                    if (r1 != r2) goto L_0x0004;
                L_0x003b:
                    r2 = r6.zzaHb;
                    r4 = r7.zzaHb;
                    r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r1 != 0) goto L_0x0004;
                L_0x0043:
                    r1 = r6.zzaHc;
                    r2 = r7.zzaHc;
                    if (r1 != r2) goto L_0x0004;
                L_0x0049:
                    r1 = r6.zzaHd;
                    r2 = r7.zzaHd;
                    if (r1 != r2) goto L_0x0004;
                L_0x004f:
                    r1 = r6.zzaHe;
                    r2 = r7.zzaHe;
                    if (r1 != r2) goto L_0x0004;
                L_0x0055:
                    r1 = r6.zzaHf;
                    r2 = r7.zzaHf;
                    r1 = com.google.android.gms.internal.zzww.equals(r1, r2);
                    if (r1 == 0) goto L_0x0004;
                L_0x005f:
                    r1 = r6.zzaHg;
                    r2 = r7.zzaHg;
                    r1 = com.google.android.gms.internal.zzww.equals(r1, r2);
                    if (r1 == 0) goto L_0x0004;
                L_0x0069:
                    r1 = r6.zzaHh;
                    r2 = r7.zzaHh;
                    r1 = com.google.android.gms.internal.zzww.equals(r1, r2);
                    if (r1 == 0) goto L_0x0004;
                L_0x0073:
                    r1 = r6.zzaHi;
                    r2 = r7.zzaHi;
                    r1 = com.google.android.gms.internal.zzww.equals(r1, r2);
                    if (r1 == 0) goto L_0x0004;
                L_0x007d:
                    r1 = r6.zzaHj;
                    r2 = r7.zzaHj;
                    r1 = com.google.android.gms.internal.zzww.equals(r1, r2);
                    if (r1 == 0) goto L_0x0004;
                L_0x0087:
                    r2 = r6.zzaHk;
                    r4 = r7.zzaHk;
                    r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r1 != 0) goto L_0x0004;
                L_0x008f:
                    r0 = r6.zza(r7);
                    goto L_0x0004;
                L_0x0095:
                    r1 = r6.zzaGY;
                    r2 = r7.zzaGY;
                    r1 = r1.equals(r2);
                    if (r1 != 0) goto L_0x001d;
                L_0x009f:
                    goto L_0x0004;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zza.equals(java.lang.Object):boolean");
                }

                public int hashCode() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r6 = 32;
                    r0 = r7.zzaGX;
                    r0 = java.util.Arrays.hashCode(r0);
                    r0 = r0 + 527;
                    r1 = r0 * 31;
                    r0 = r7.zzaGY;
                    if (r0 != 0) goto L_0x0084;
                L_0x0010:
                    r0 = 0;
                L_0x0011:
                    r0 = r0 + r1;
                    r2 = r7.zzaGZ;
                    r2 = java.lang.Double.doubleToLongBits(r2);
                    r0 = r0 * 31;
                    r4 = r2 >>> r6;
                    r2 = r2 ^ r4;
                    r1 = (int) r2;
                    r0 = r0 + r1;
                    r0 = r0 * 31;
                    r1 = r7.zzaHa;
                    r1 = java.lang.Float.floatToIntBits(r1);
                    r0 = r0 + r1;
                    r0 = r0 * 31;
                    r2 = r7.zzaHb;
                    r4 = r7.zzaHb;
                    r4 = r4 >>> r6;
                    r2 = r2 ^ r4;
                    r1 = (int) r2;
                    r0 = r0 + r1;
                    r0 = r0 * 31;
                    r1 = r7.zzaHc;
                    r0 = r0 + r1;
                    r0 = r0 * 31;
                    r1 = r7.zzaHd;
                    r0 = r0 + r1;
                    r1 = r0 * 31;
                    r0 = r7.zzaHe;
                    if (r0 == 0) goto L_0x008b;
                L_0x0042:
                    r0 = 1231; // 0x4cf float:1.725E-42 double:6.08E-321;
                L_0x0044:
                    r0 = r0 + r1;
                    r0 = r0 * 31;
                    r1 = r7.zzaHf;
                    r1 = com.google.android.gms.internal.zzww.hashCode(r1);
                    r0 = r0 + r1;
                    r0 = r0 * 31;
                    r1 = r7.zzaHg;
                    r1 = com.google.android.gms.internal.zzww.hashCode(r1);
                    r0 = r0 + r1;
                    r0 = r0 * 31;
                    r1 = r7.zzaHh;
                    r1 = com.google.android.gms.internal.zzww.hashCode(r1);
                    r0 = r0 + r1;
                    r0 = r0 * 31;
                    r1 = r7.zzaHi;
                    r1 = com.google.android.gms.internal.zzww.hashCode(r1);
                    r0 = r0 + r1;
                    r0 = r0 * 31;
                    r1 = r7.zzaHj;
                    r1 = com.google.android.gms.internal.zzww.hashCode(r1);
                    r0 = r0 + r1;
                    r0 = r0 * 31;
                    r2 = r7.zzaHk;
                    r4 = r7.zzaHk;
                    r4 = r4 >>> r6;
                    r2 = r2 ^ r4;
                    r1 = (int) r2;
                    r0 = r0 + r1;
                    r0 = r0 * 31;
                    r1 = r7.zzvL();
                    r0 = r0 + r1;
                    return r0;
                L_0x0084:
                    r0 = r7.zzaGY;
                    r0 = r0.hashCode();
                    goto L_0x0011;
                L_0x008b:
                    r0 = 1237; // 0x4d5 float:1.733E-42 double:6.11E-321;
                    goto L_0x0044;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zza.hashCode():int");
                }

                public void zza(com.google.android.gms.internal.zzwr r9) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r8 = this;
                    r6 = 0;
                    r1 = 0;
                    r0 = r8.zzaGX;
                    r2 = com.google.android.gms.internal.zzxb.zzaHV;
                    r0 = java.util.Arrays.equals(r0, r2);
                    if (r0 != 0) goto L_0x0013;
                L_0x000d:
                    r0 = 1;
                    r2 = r8.zzaGX;
                    r9.zza(r0, r2);
                L_0x0013:
                    r0 = r8.zzaGY;
                    r2 = "";
                    r0 = r0.equals(r2);
                    if (r0 != 0) goto L_0x0023;
                L_0x001d:
                    r0 = 2;
                    r2 = r8.zzaGY;
                    r9.zzb(r0, r2);
                L_0x0023:
                    r2 = r8.zzaGZ;
                    r2 = java.lang.Double.doubleToLongBits(r2);
                    r4 = 0;
                    r4 = java.lang.Double.doubleToLongBits(r4);
                    r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r0 == 0) goto L_0x0039;
                L_0x0033:
                    r0 = 3;
                    r2 = r8.zzaGZ;
                    r9.zza(r0, r2);
                L_0x0039:
                    r0 = r8.zzaHa;
                    r0 = java.lang.Float.floatToIntBits(r0);
                    r2 = 0;
                    r2 = java.lang.Float.floatToIntBits(r2);
                    if (r0 == r2) goto L_0x004c;
                L_0x0046:
                    r0 = 4;
                    r2 = r8.zzaHa;
                    r9.zzb(r0, r2);
                L_0x004c:
                    r2 = r8.zzaHb;
                    r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                    if (r0 == 0) goto L_0x0058;
                L_0x0052:
                    r0 = 5;
                    r2 = r8.zzaHb;
                    r9.zzb(r0, r2);
                L_0x0058:
                    r0 = r8.zzaHc;
                    if (r0 == 0) goto L_0x0062;
                L_0x005c:
                    r0 = 6;
                    r2 = r8.zzaHc;
                    r9.zzy(r0, r2);
                L_0x0062:
                    r0 = r8.zzaHd;
                    if (r0 == 0) goto L_0x006c;
                L_0x0066:
                    r0 = 7;
                    r2 = r8.zzaHd;
                    r9.zzz(r0, r2);
                L_0x006c:
                    r0 = r8.zzaHe;
                    if (r0 == 0) goto L_0x0077;
                L_0x0070:
                    r0 = 8;
                    r2 = r8.zzaHe;
                    r9.zzb(r0, r2);
                L_0x0077:
                    r0 = r8.zzaHf;
                    if (r0 == 0) goto L_0x0094;
                L_0x007b:
                    r0 = r8.zzaHf;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x0094;
                L_0x0080:
                    r0 = r1;
                L_0x0081:
                    r2 = r8.zzaHf;
                    r2 = r2.length;
                    if (r0 >= r2) goto L_0x0094;
                L_0x0086:
                    r2 = r8.zzaHf;
                    r2 = r2[r0];
                    if (r2 == 0) goto L_0x0091;
                L_0x008c:
                    r3 = 9;
                    r9.zza(r3, r2);
                L_0x0091:
                    r0 = r0 + 1;
                    goto L_0x0081;
                L_0x0094:
                    r0 = r8.zzaHg;
                    if (r0 == 0) goto L_0x00b1;
                L_0x0098:
                    r0 = r8.zzaHg;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x00b1;
                L_0x009d:
                    r0 = r1;
                L_0x009e:
                    r2 = r8.zzaHg;
                    r2 = r2.length;
                    if (r0 >= r2) goto L_0x00b1;
                L_0x00a3:
                    r2 = r8.zzaHg;
                    r2 = r2[r0];
                    if (r2 == 0) goto L_0x00ae;
                L_0x00a9:
                    r3 = 10;
                    r9.zza(r3, r2);
                L_0x00ae:
                    r0 = r0 + 1;
                    goto L_0x009e;
                L_0x00b1:
                    r0 = r8.zzaHh;
                    if (r0 == 0) goto L_0x00ce;
                L_0x00b5:
                    r0 = r8.zzaHh;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x00ce;
                L_0x00ba:
                    r0 = r1;
                L_0x00bb:
                    r2 = r8.zzaHh;
                    r2 = r2.length;
                    if (r0 >= r2) goto L_0x00ce;
                L_0x00c0:
                    r2 = r8.zzaHh;
                    r2 = r2[r0];
                    if (r2 == 0) goto L_0x00cb;
                L_0x00c6:
                    r3 = 11;
                    r9.zzb(r3, r2);
                L_0x00cb:
                    r0 = r0 + 1;
                    goto L_0x00bb;
                L_0x00ce:
                    r0 = r8.zzaHi;
                    if (r0 == 0) goto L_0x00e9;
                L_0x00d2:
                    r0 = r8.zzaHi;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x00e9;
                L_0x00d7:
                    r0 = r1;
                L_0x00d8:
                    r2 = r8.zzaHi;
                    r2 = r2.length;
                    if (r0 >= r2) goto L_0x00e9;
                L_0x00dd:
                    r2 = 12;
                    r3 = r8.zzaHi;
                    r4 = r3[r0];
                    r9.zzb(r2, r4);
                    r0 = r0 + 1;
                    goto L_0x00d8;
                L_0x00e9:
                    r2 = r8.zzaHk;
                    r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                    if (r0 == 0) goto L_0x00f6;
                L_0x00ef:
                    r0 = 13;
                    r2 = r8.zzaHk;
                    r9.zzb(r0, r2);
                L_0x00f6:
                    r0 = r8.zzaHj;
                    if (r0 == 0) goto L_0x0110;
                L_0x00fa:
                    r0 = r8.zzaHj;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x0110;
                L_0x00ff:
                    r0 = r8.zzaHj;
                    r0 = r0.length;
                    if (r1 >= r0) goto L_0x0110;
                L_0x0104:
                    r0 = 14;
                    r2 = r8.zzaHj;
                    r2 = r2[r1];
                    r9.zzb(r0, r2);
                    r1 = r1 + 1;
                    goto L_0x00ff;
                L_0x0110:
                    super.zza(r9);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zza.zza(com.google.android.gms.internal.zzwr):void");
                }

                public /* synthetic */ com.google.android.gms.internal.zzwy zzb(com.google.android.gms.internal.zzwq r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.zzx(r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zza.zzb(com.google.android.gms.internal.zzwq):com.google.android.gms.internal.zzwy");
                }

                protected int zzc() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r8 = this;
                    r6 = 0;
                    r1 = 0;
                    r0 = super.zzc();
                    r2 = r8.zzaGX;
                    r3 = com.google.android.gms.internal.zzxb.zzaHV;
                    r2 = java.util.Arrays.equals(r2, r3);
                    if (r2 != 0) goto L_0x0019;
                L_0x0011:
                    r2 = 1;
                    r3 = r8.zzaGX;
                    r2 = com.google.android.gms.internal.zzwr.zzb(r2, r3);
                    r0 = r0 + r2;
                L_0x0019:
                    r2 = r8.zzaGY;
                    r3 = "";
                    r2 = r2.equals(r3);
                    if (r2 != 0) goto L_0x002b;
                L_0x0023:
                    r2 = 2;
                    r3 = r8.zzaGY;
                    r2 = com.google.android.gms.internal.zzwr.zzj(r2, r3);
                    r0 = r0 + r2;
                L_0x002b:
                    r2 = r8.zzaGZ;
                    r2 = java.lang.Double.doubleToLongBits(r2);
                    r4 = 0;
                    r4 = java.lang.Double.doubleToLongBits(r4);
                    r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r2 == 0) goto L_0x0043;
                L_0x003b:
                    r2 = 3;
                    r4 = r8.zzaGZ;
                    r2 = com.google.android.gms.internal.zzwr.zzb(r2, r4);
                    r0 = r0 + r2;
                L_0x0043:
                    r2 = r8.zzaHa;
                    r2 = java.lang.Float.floatToIntBits(r2);
                    r3 = 0;
                    r3 = java.lang.Float.floatToIntBits(r3);
                    if (r2 == r3) goto L_0x0058;
                L_0x0050:
                    r2 = 4;
                    r3 = r8.zzaHa;
                    r2 = com.google.android.gms.internal.zzwr.zzc(r2, r3);
                    r0 = r0 + r2;
                L_0x0058:
                    r2 = r8.zzaHb;
                    r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                    if (r2 == 0) goto L_0x0066;
                L_0x005e:
                    r2 = 5;
                    r4 = r8.zzaHb;
                    r2 = com.google.android.gms.internal.zzwr.zzd(r2, r4);
                    r0 = r0 + r2;
                L_0x0066:
                    r2 = r8.zzaHc;
                    if (r2 == 0) goto L_0x0072;
                L_0x006a:
                    r2 = 6;
                    r3 = r8.zzaHc;
                    r2 = com.google.android.gms.internal.zzwr.zzA(r2, r3);
                    r0 = r0 + r2;
                L_0x0072:
                    r2 = r8.zzaHd;
                    if (r2 == 0) goto L_0x007e;
                L_0x0076:
                    r2 = 7;
                    r3 = r8.zzaHd;
                    r2 = com.google.android.gms.internal.zzwr.zzB(r2, r3);
                    r0 = r0 + r2;
                L_0x007e:
                    r2 = r8.zzaHe;
                    if (r2 == 0) goto L_0x008b;
                L_0x0082:
                    r2 = 8;
                    r3 = r8.zzaHe;
                    r2 = com.google.android.gms.internal.zzwr.zzc(r2, r3);
                    r0 = r0 + r2;
                L_0x008b:
                    r2 = r8.zzaHf;
                    if (r2 == 0) goto L_0x00ac;
                L_0x008f:
                    r2 = r8.zzaHf;
                    r2 = r2.length;
                    if (r2 <= 0) goto L_0x00ac;
                L_0x0094:
                    r2 = r0;
                    r0 = r1;
                L_0x0096:
                    r3 = r8.zzaHf;
                    r3 = r3.length;
                    if (r0 >= r3) goto L_0x00ab;
                L_0x009b:
                    r3 = r8.zzaHf;
                    r3 = r3[r0];
                    if (r3 == 0) goto L_0x00a8;
                L_0x00a1:
                    r4 = 9;
                    r3 = com.google.android.gms.internal.zzwr.zzc(r4, r3);
                    r2 = r2 + r3;
                L_0x00a8:
                    r0 = r0 + 1;
                    goto L_0x0096;
                L_0x00ab:
                    r0 = r2;
                L_0x00ac:
                    r2 = r8.zzaHg;
                    if (r2 == 0) goto L_0x00cd;
                L_0x00b0:
                    r2 = r8.zzaHg;
                    r2 = r2.length;
                    if (r2 <= 0) goto L_0x00cd;
                L_0x00b5:
                    r2 = r0;
                    r0 = r1;
                L_0x00b7:
                    r3 = r8.zzaHg;
                    r3 = r3.length;
                    if (r0 >= r3) goto L_0x00cc;
                L_0x00bc:
                    r3 = r8.zzaHg;
                    r3 = r3[r0];
                    if (r3 == 0) goto L_0x00c9;
                L_0x00c2:
                    r4 = 10;
                    r3 = com.google.android.gms.internal.zzwr.zzc(r4, r3);
                    r2 = r2 + r3;
                L_0x00c9:
                    r0 = r0 + 1;
                    goto L_0x00b7;
                L_0x00cc:
                    r0 = r2;
                L_0x00cd:
                    r2 = r8.zzaHh;
                    if (r2 == 0) goto L_0x00f2;
                L_0x00d1:
                    r2 = r8.zzaHh;
                    r2 = r2.length;
                    if (r2 <= 0) goto L_0x00f2;
                L_0x00d6:
                    r2 = r1;
                    r3 = r1;
                    r4 = r1;
                L_0x00d9:
                    r5 = r8.zzaHh;
                    r5 = r5.length;
                    if (r2 >= r5) goto L_0x00ee;
                L_0x00de:
                    r5 = r8.zzaHh;
                    r5 = r5[r2];
                    if (r5 == 0) goto L_0x00eb;
                L_0x00e4:
                    r4 = r4 + 1;
                    r5 = com.google.android.gms.internal.zzwr.zzdM(r5);
                    r3 = r3 + r5;
                L_0x00eb:
                    r2 = r2 + 1;
                    goto L_0x00d9;
                L_0x00ee:
                    r0 = r0 + r3;
                    r2 = r4 * 1;
                    r0 = r0 + r2;
                L_0x00f2:
                    r2 = r8.zzaHi;
                    if (r2 == 0) goto L_0x0114;
                L_0x00f6:
                    r2 = r8.zzaHi;
                    r2 = r2.length;
                    if (r2 <= 0) goto L_0x0114;
                L_0x00fb:
                    r2 = r1;
                L_0x00fc:
                    r3 = r8.zzaHi;
                    r3 = r3.length;
                    if (r1 >= r3) goto L_0x010d;
                L_0x0101:
                    r3 = r8.zzaHi;
                    r4 = r3[r1];
                    r3 = com.google.android.gms.internal.zzwr.zzN(r4);
                    r2 = r2 + r3;
                    r1 = r1 + 1;
                    goto L_0x00fc;
                L_0x010d:
                    r0 = r0 + r2;
                    r1 = r8.zzaHi;
                    r1 = r1.length;
                    r1 = r1 * 1;
                    r0 = r0 + r1;
                L_0x0114:
                    r2 = r8.zzaHk;
                    r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                    if (r1 == 0) goto L_0x0123;
                L_0x011a:
                    r1 = 13;
                    r2 = r8.zzaHk;
                    r1 = com.google.android.gms.internal.zzwr.zzd(r1, r2);
                    r0 = r0 + r1;
                L_0x0123:
                    r1 = r8.zzaHj;
                    if (r1 == 0) goto L_0x0138;
                L_0x0127:
                    r1 = r8.zzaHj;
                    r1 = r1.length;
                    if (r1 <= 0) goto L_0x0138;
                L_0x012c:
                    r1 = r8.zzaHj;
                    r1 = r1.length;
                    r1 = r1 * 4;
                    r0 = r0 + r1;
                    r1 = r8.zzaHj;
                    r1 = r1.length;
                    r1 = r1 * 1;
                    r0 = r0 + r1;
                L_0x0138:
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zza.zzc():int");
                }

                public com.google.android.gms.internal.zzwn.zza.zza.zza zzvs() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r6 = this;
                    r4 = 0;
                    r2 = 0;
                    r0 = com.google.android.gms.internal.zzxb.zzaHV;
                    r6.zzaGX = r0;
                    r0 = "";
                    r6.zzaGY = r0;
                    r0 = 0;
                    r6.zzaGZ = r0;
                    r0 = 0;
                    r6.zzaHa = r0;
                    r6.zzaHb = r4;
                    r6.zzaHc = r2;
                    r6.zzaHd = r2;
                    r6.zzaHe = r2;
                    r0 = com.google.android.gms.internal.zzwn.zza.zzvo();
                    r6.zzaHf = r0;
                    r0 = com.google.android.gms.internal.zzwn.zza.zza.zzvq();
                    r6.zzaHg = r0;
                    r0 = com.google.android.gms.internal.zzxb.zzaHT;
                    r6.zzaHh = r0;
                    r0 = com.google.android.gms.internal.zzxb.zzaHP;
                    r6.zzaHi = r0;
                    r0 = com.google.android.gms.internal.zzxb.zzaHQ;
                    r6.zzaHj = r0;
                    r6.zzaHk = r4;
                    r0 = 0;
                    r6.zzaHB = r0;
                    r0 = -1;
                    r6.zzaHM = r0;
                    return r6;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zza.zzvs():com.google.android.gms.internal.zzwn$zza$zza$zza");
                }

                public com.google.android.gms.internal.zzwn.zza.zza.zza zzx(com.google.android.gms.internal.zzwq r7) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r6 = this;
                    r1 = 0;
                L_0x0001:
                    r0 = r7.zzvu();
                    switch(r0) {
                        case 0: goto L_0x000e;
                        case 10: goto L_0x000f;
                        case 18: goto L_0x0016;
                        case 25: goto L_0x001d;
                        case 37: goto L_0x0024;
                        case 40: goto L_0x002b;
                        case 48: goto L_0x0032;
                        case 56: goto L_0x0039;
                        case 64: goto L_0x0040;
                        case 74: goto L_0x0047;
                        case 82: goto L_0x0087;
                        case 90: goto L_0x00c7;
                        case 96: goto L_0x00fb;
                        case 98: goto L_0x012f;
                        case 104: goto L_0x0171;
                        case 114: goto L_0x01ad;
                        case 117: goto L_0x0179;
                        default: goto L_0x0008;
                    };
                L_0x0008:
                    r0 = r6.zza(r7, r0);
                    if (r0 != 0) goto L_0x0001;
                L_0x000e:
                    return r6;
                L_0x000f:
                    r0 = r7.readBytes();
                    r6.zzaGX = r0;
                    goto L_0x0001;
                L_0x0016:
                    r0 = r7.readString();
                    r6.zzaGY = r0;
                    goto L_0x0001;
                L_0x001d:
                    r2 = r7.readDouble();
                    r6.zzaGZ = r2;
                    goto L_0x0001;
                L_0x0024:
                    r0 = r7.readFloat();
                    r6.zzaHa = r0;
                    goto L_0x0001;
                L_0x002b:
                    r2 = r7.zzvw();
                    r6.zzaHb = r2;
                    goto L_0x0001;
                L_0x0032:
                    r0 = r7.zzvx();
                    r6.zzaHc = r0;
                    goto L_0x0001;
                L_0x0039:
                    r0 = r7.zzvz();
                    r6.zzaHd = r0;
                    goto L_0x0001;
                L_0x0040:
                    r0 = r7.zzvy();
                    r6.zzaHe = r0;
                    goto L_0x0001;
                L_0x0047:
                    r0 = 74;
                    r2 = com.google.android.gms.internal.zzxb.zzc(r7, r0);
                    r0 = r6.zzaHf;
                    if (r0 != 0) goto L_0x0073;
                L_0x0051:
                    r0 = r1;
                L_0x0052:
                    r2 = r2 + r0;
                    r2 = new com.google.android.gms.internal.zzwn.zza[r2];
                    if (r0 == 0) goto L_0x005c;
                L_0x0057:
                    r3 = r6.zzaHf;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x005c:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x0077;
                L_0x0061:
                    r3 = new com.google.android.gms.internal.zzwn$zza;
                    r3.<init>();
                    r2[r0] = r3;
                    r3 = r2[r0];
                    r7.zza(r3);
                    r7.zzvu();
                    r0 = r0 + 1;
                    goto L_0x005c;
                L_0x0073:
                    r0 = r6.zzaHf;
                    r0 = r0.length;
                    goto L_0x0052;
                L_0x0077:
                    r3 = new com.google.android.gms.internal.zzwn$zza;
                    r3.<init>();
                    r2[r0] = r3;
                    r0 = r2[r0];
                    r7.zza(r0);
                    r6.zzaHf = r2;
                    goto L_0x0001;
                L_0x0087:
                    r0 = 82;
                    r2 = com.google.android.gms.internal.zzxb.zzc(r7, r0);
                    r0 = r6.zzaHg;
                    if (r0 != 0) goto L_0x00b3;
                L_0x0091:
                    r0 = r1;
                L_0x0092:
                    r2 = r2 + r0;
                    r2 = new com.google.android.gms.internal.zzwn.zza.zza[r2];
                    if (r0 == 0) goto L_0x009c;
                L_0x0097:
                    r3 = r6.zzaHg;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x009c:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x00b7;
                L_0x00a1:
                    r3 = new com.google.android.gms.internal.zzwn$zza$zza;
                    r3.<init>();
                    r2[r0] = r3;
                    r3 = r2[r0];
                    r7.zza(r3);
                    r7.zzvu();
                    r0 = r0 + 1;
                    goto L_0x009c;
                L_0x00b3:
                    r0 = r6.zzaHg;
                    r0 = r0.length;
                    goto L_0x0092;
                L_0x00b7:
                    r3 = new com.google.android.gms.internal.zzwn$zza$zza;
                    r3.<init>();
                    r2[r0] = r3;
                    r0 = r2[r0];
                    r7.zza(r0);
                    r6.zzaHg = r2;
                    goto L_0x0001;
                L_0x00c7:
                    r0 = 90;
                    r2 = com.google.android.gms.internal.zzxb.zzc(r7, r0);
                    r0 = r6.zzaHh;
                    if (r0 != 0) goto L_0x00ed;
                L_0x00d1:
                    r0 = r1;
                L_0x00d2:
                    r2 = r2 + r0;
                    r2 = new java.lang.String[r2];
                    if (r0 == 0) goto L_0x00dc;
                L_0x00d7:
                    r3 = r6.zzaHh;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x00dc:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x00f1;
                L_0x00e1:
                    r3 = r7.readString();
                    r2[r0] = r3;
                    r7.zzvu();
                    r0 = r0 + 1;
                    goto L_0x00dc;
                L_0x00ed:
                    r0 = r6.zzaHh;
                    r0 = r0.length;
                    goto L_0x00d2;
                L_0x00f1:
                    r3 = r7.readString();
                    r2[r0] = r3;
                    r6.zzaHh = r2;
                    goto L_0x0001;
                L_0x00fb:
                    r0 = 96;
                    r2 = com.google.android.gms.internal.zzxb.zzc(r7, r0);
                    r0 = r6.zzaHi;
                    if (r0 != 0) goto L_0x0121;
                L_0x0105:
                    r0 = r1;
                L_0x0106:
                    r2 = r2 + r0;
                    r2 = new long[r2];
                    if (r0 == 0) goto L_0x0110;
                L_0x010b:
                    r3 = r6.zzaHi;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x0110:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x0125;
                L_0x0115:
                    r4 = r7.zzvw();
                    r2[r0] = r4;
                    r7.zzvu();
                    r0 = r0 + 1;
                    goto L_0x0110;
                L_0x0121:
                    r0 = r6.zzaHi;
                    r0 = r0.length;
                    goto L_0x0106;
                L_0x0125:
                    r4 = r7.zzvw();
                    r2[r0] = r4;
                    r6.zzaHi = r2;
                    goto L_0x0001;
                L_0x012f:
                    r0 = r7.zzvB();
                    r3 = r7.zzip(r0);
                    r2 = r7.getPosition();
                    r0 = r1;
                L_0x013c:
                    r4 = r7.zzvG();
                    if (r4 <= 0) goto L_0x0148;
                L_0x0142:
                    r7.zzvw();
                    r0 = r0 + 1;
                    goto L_0x013c;
                L_0x0148:
                    r7.zzir(r2);
                    r2 = r6.zzaHi;
                    if (r2 != 0) goto L_0x0166;
                L_0x014f:
                    r2 = r1;
                L_0x0150:
                    r0 = r0 + r2;
                    r0 = new long[r0];
                    if (r2 == 0) goto L_0x015a;
                L_0x0155:
                    r4 = r6.zzaHi;
                    java.lang.System.arraycopy(r4, r1, r0, r1, r2);
                L_0x015a:
                    r4 = r0.length;
                    if (r2 >= r4) goto L_0x016a;
                L_0x015d:
                    r4 = r7.zzvw();
                    r0[r2] = r4;
                    r2 = r2 + 1;
                    goto L_0x015a;
                L_0x0166:
                    r2 = r6.zzaHi;
                    r2 = r2.length;
                    goto L_0x0150;
                L_0x016a:
                    r6.zzaHi = r0;
                    r7.zziq(r3);
                    goto L_0x0001;
                L_0x0171:
                    r2 = r7.zzvw();
                    r6.zzaHk = r2;
                    goto L_0x0001;
                L_0x0179:
                    r0 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
                    r2 = com.google.android.gms.internal.zzxb.zzc(r7, r0);
                    r0 = r6.zzaHj;
                    if (r0 != 0) goto L_0x019f;
                L_0x0183:
                    r0 = r1;
                L_0x0184:
                    r2 = r2 + r0;
                    r2 = new float[r2];
                    if (r0 == 0) goto L_0x018e;
                L_0x0189:
                    r3 = r6.zzaHj;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x018e:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x01a3;
                L_0x0193:
                    r3 = r7.readFloat();
                    r2[r0] = r3;
                    r7.zzvu();
                    r0 = r0 + 1;
                    goto L_0x018e;
                L_0x019f:
                    r0 = r6.zzaHj;
                    r0 = r0.length;
                    goto L_0x0184;
                L_0x01a3:
                    r3 = r7.readFloat();
                    r2[r0] = r3;
                    r6.zzaHj = r2;
                    goto L_0x0001;
                L_0x01ad:
                    r0 = r7.zzvB();
                    r2 = r7.zzip(r0);
                    r3 = r0 / 4;
                    r0 = r6.zzaHj;
                    if (r0 != 0) goto L_0x01d2;
                L_0x01bb:
                    r0 = r1;
                L_0x01bc:
                    r3 = r3 + r0;
                    r3 = new float[r3];
                    if (r0 == 0) goto L_0x01c6;
                L_0x01c1:
                    r4 = r6.zzaHj;
                    java.lang.System.arraycopy(r4, r1, r3, r1, r0);
                L_0x01c6:
                    r4 = r3.length;
                    if (r0 >= r4) goto L_0x01d6;
                L_0x01c9:
                    r4 = r7.readFloat();
                    r3[r0] = r4;
                    r0 = r0 + 1;
                    goto L_0x01c6;
                L_0x01d2:
                    r0 = r6.zzaHj;
                    r0 = r0.length;
                    goto L_0x01bc;
                L_0x01d6:
                    r6.zzaHj = r3;
                    r7.zziq(r2);
                    goto L_0x0001;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zza.zzx(com.google.android.gms.internal.zzwq):com.google.android.gms.internal.zzwn$zza$zza$zza");
                }
            }

            public zza() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                r0.zzvr();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.<init>():void");
            }

            public static com.google.android.gms.internal.zzwn.zza.zza[] zzvq() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = zzaGV;
                if (r0 != 0) goto L_0x0011;
            L_0x0004:
                r1 = com.google.android.gms.internal.zzww.zzaHL;
                monitor-enter(r1);
                r0 = zzaGV;
                if (r0 != 0) goto L_0x0010;
            L_0x000b:
                r0 = 0;
                r0 = new com.google.android.gms.internal.zzwn.zza.zza[r0];
                zzaGV = r0;
            L_0x0010:
                monitor-exit(r1);
            L_0x0011:
                r0 = zzaGV;
                return r0;
            L_0x0014:
                r0 = move-exception;
                monitor-exit(r1);
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zzvq():com.google.android.gms.internal.zzwn$zza$zza[]");
            }

            public boolean equals(java.lang.Object r4) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = 0;
                if (r4 != r3) goto L_0x0005;
            L_0x0003:
                r0 = 1;
            L_0x0004:
                return r0;
            L_0x0005:
                r1 = r4 instanceof com.google.android.gms.internal.zzwn.zza.zza;
                if (r1 == 0) goto L_0x0004;
            L_0x0009:
                r4 = (com.google.android.gms.internal.zzwn.zza.zza) r4;
                r1 = r3.type;
                r2 = r4.type;
                if (r1 != r2) goto L_0x0004;
            L_0x0011:
                r1 = r3.zzaGW;
                if (r1 != 0) goto L_0x001e;
            L_0x0015:
                r1 = r4.zzaGW;
                if (r1 != 0) goto L_0x0004;
            L_0x0019:
                r0 = r3.zza(r4);
                goto L_0x0004;
            L_0x001e:
                r1 = r3.zzaGW;
                r2 = r4.zzaGW;
                r1 = r1.equals(r2);
                if (r1 != 0) goto L_0x0019;
            L_0x0028:
                goto L_0x0004;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.type;
                r0 = r0 + 527;
                r1 = r0 * 31;
                r0 = r2.zzaGW;
                if (r0 != 0) goto L_0x0014;
            L_0x000a:
                r0 = 0;
            L_0x000b:
                r0 = r0 + r1;
                r0 = r0 * 31;
                r1 = r2.zzvL();
                r0 = r0 + r1;
                return r0;
            L_0x0014:
                r0 = r2.zzaGW;
                r0 = r0.hashCode();
                goto L_0x000b;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.hashCode():int");
            }

            public void zza(com.google.android.gms.internal.zzwr r3) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 1;
                r1 = r2.type;
                r3.zzy(r0, r1);
                r0 = r2.zzaGW;
                if (r0 == 0) goto L_0x0010;
            L_0x000a:
                r0 = 2;
                r1 = r2.zzaGW;
                r3.zza(r0, r1);
            L_0x0010:
                super.zza(r3);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zza(com.google.android.gms.internal.zzwr):void");
            }

            public /* synthetic */ com.google.android.gms.internal.zzwy zzb(com.google.android.gms.internal.zzwq r2) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.zzw(r2);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zzb(com.google.android.gms.internal.zzwq):com.google.android.gms.internal.zzwy");
            }

            protected int zzc() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = super.zzc();
                r1 = 1;
                r2 = r3.type;
                r1 = com.google.android.gms.internal.zzwr.zzA(r1, r2);
                r0 = r0 + r1;
                r1 = r3.zzaGW;
                if (r1 == 0) goto L_0x0018;
            L_0x0010:
                r1 = 2;
                r2 = r3.zzaGW;
                r1 = com.google.android.gms.internal.zzwr.zzc(r1, r2);
                r0 = r0 + r1;
            L_0x0018:
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zzc():int");
            }

            public com.google.android.gms.internal.zzwn.zza.zza zzvr() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r1 = 0;
                r0 = 1;
                r2.type = r0;
                r2.zzaGW = r1;
                r2.zzaHB = r1;
                r0 = -1;
                r2.zzaHM = r0;
                return r2;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zzvr():com.google.android.gms.internal.zzwn$zza$zza");
            }

            public com.google.android.gms.internal.zzwn.zza.zza zzw(com.google.android.gms.internal.zzwq r2) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
            L_0x0000:
                r0 = r2.zzvu();
                switch(r0) {
                    case 0: goto L_0x000d;
                    case 8: goto L_0x000e;
                    case 18: goto L_0x0019;
                    default: goto L_0x0007;
                };
            L_0x0007:
                r0 = r1.zza(r2, r0);
                if (r0 != 0) goto L_0x0000;
            L_0x000d:
                return r1;
            L_0x000e:
                r0 = r2.zzvx();
                switch(r0) {
                    case 1: goto L_0x0016;
                    case 2: goto L_0x0016;
                    case 3: goto L_0x0016;
                    case 4: goto L_0x0016;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0016;
                    case 7: goto L_0x0016;
                    case 8: goto L_0x0016;
                    case 9: goto L_0x0016;
                    case 10: goto L_0x0016;
                    case 11: goto L_0x0016;
                    case 12: goto L_0x0016;
                    case 13: goto L_0x0016;
                    case 14: goto L_0x0016;
                    case 15: goto L_0x0016;
                    default: goto L_0x0015;
                };
            L_0x0015:
                goto L_0x0000;
            L_0x0016:
                r1.type = r0;
                goto L_0x0000;
            L_0x0019:
                r0 = r1.zzaGW;
                if (r0 != 0) goto L_0x0024;
            L_0x001d:
                r0 = new com.google.android.gms.internal.zzwn$zza$zza$zza;
                r0.<init>();
                r1.zzaGW = r0;
            L_0x0024:
                r0 = r1.zzaGW;
                r2.zza(r0);
                goto L_0x0000;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza.zzw(com.google.android.gms.internal.zzwq):com.google.android.gms.internal.zzwn$zza$zza");
            }
        }

        public zza() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r0.<init>();
            r0.zzvp();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.<init>():void");
        }

        public static com.google.android.gms.internal.zzwn.zza[] zzvo() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = zzaGT;
            if (r0 != 0) goto L_0x0011;
        L_0x0004:
            r1 = com.google.android.gms.internal.zzww.zzaHL;
            monitor-enter(r1);
            r0 = zzaGT;
            if (r0 != 0) goto L_0x0010;
        L_0x000b:
            r0 = 0;
            r0 = new com.google.android.gms.internal.zzwn.zza[r0];
            zzaGT = r0;
        L_0x0010:
            monitor-exit(r1);
        L_0x0011:
            r0 = zzaGT;
            return r0;
        L_0x0014:
            r0 = move-exception;
            monitor-exit(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zzvo():com.google.android.gms.internal.zzwn$zza[]");
        }

        public boolean equals(java.lang.Object r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = 0;
            if (r4 != r3) goto L_0x0005;
        L_0x0003:
            r0 = 1;
        L_0x0004:
            return r0;
        L_0x0005:
            r1 = r4 instanceof com.google.android.gms.internal.zzwn.zza;
            if (r1 == 0) goto L_0x0004;
        L_0x0009:
            r4 = (com.google.android.gms.internal.zzwn.zza) r4;
            r1 = r3.name;
            if (r1 != 0) goto L_0x0020;
        L_0x000f:
            r1 = r4.name;
            if (r1 != 0) goto L_0x0004;
        L_0x0013:
            r1 = r3.zzaGU;
            if (r1 != 0) goto L_0x002b;
        L_0x0017:
            r1 = r4.zzaGU;
            if (r1 != 0) goto L_0x0004;
        L_0x001b:
            r0 = r3.zza(r4);
            goto L_0x0004;
        L_0x0020:
            r1 = r3.name;
            r2 = r4.name;
            r1 = r1.equals(r2);
            if (r1 != 0) goto L_0x0013;
        L_0x002a:
            goto L_0x0004;
        L_0x002b:
            r1 = r3.zzaGU;
            r2 = r4.zzaGU;
            r1 = r1.equals(r2);
            if (r1 != 0) goto L_0x001b;
        L_0x0035:
            goto L_0x0004;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r1 = 0;
            r0 = r3.name;
            if (r0 != 0) goto L_0x0017;
        L_0x0005:
            r0 = r1;
        L_0x0006:
            r0 = r0 + 527;
            r0 = r0 * 31;
            r2 = r3.zzaGU;
            if (r2 != 0) goto L_0x001e;
        L_0x000e:
            r0 = r0 + r1;
            r0 = r0 * 31;
            r1 = r3.zzvL();
            r0 = r0 + r1;
            return r0;
        L_0x0017:
            r0 = r3.name;
            r0 = r0.hashCode();
            goto L_0x0006;
        L_0x001e:
            r1 = r3.zzaGU;
            r1 = r1.hashCode();
            goto L_0x000e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.hashCode():int");
        }

        public void zza(com.google.android.gms.internal.zzwr r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = 1;
            r1 = r2.name;
            r3.zzb(r0, r1);
            r0 = r2.zzaGU;
            if (r0 == 0) goto L_0x0010;
        L_0x000a:
            r0 = 2;
            r1 = r2.zzaGU;
            r3.zza(r0, r1);
        L_0x0010:
            super.zza(r3);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zza(com.google.android.gms.internal.zzwr):void");
        }

        public /* synthetic */ com.google.android.gms.internal.zzwy zzb(com.google.android.gms.internal.zzwq r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.zzv(r2);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zzb(com.google.android.gms.internal.zzwq):com.google.android.gms.internal.zzwy");
        }

        protected int zzc() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = super.zzc();
            r1 = 1;
            r2 = r3.name;
            r1 = com.google.android.gms.internal.zzwr.zzj(r1, r2);
            r0 = r0 + r1;
            r1 = r3.zzaGU;
            if (r1 == 0) goto L_0x0018;
        L_0x0010:
            r1 = 2;
            r2 = r3.zzaGU;
            r1 = com.google.android.gms.internal.zzwr.zzc(r1, r2);
            r0 = r0 + r1;
        L_0x0018:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zzc():int");
        }

        public com.google.android.gms.internal.zzwn.zza zzv(com.google.android.gms.internal.zzwq r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
        L_0x0000:
            r0 = r2.zzvu();
            switch(r0) {
                case 0: goto L_0x000d;
                case 10: goto L_0x000e;
                case 18: goto L_0x0015;
                default: goto L_0x0007;
            };
        L_0x0007:
            r0 = r1.zza(r2, r0);
            if (r0 != 0) goto L_0x0000;
        L_0x000d:
            return r1;
        L_0x000e:
            r0 = r2.readString();
            r1.name = r0;
            goto L_0x0000;
        L_0x0015:
            r0 = r1.zzaGU;
            if (r0 != 0) goto L_0x0020;
        L_0x0019:
            r0 = new com.google.android.gms.internal.zzwn$zza$zza;
            r0.<init>();
            r1.zzaGU = r0;
        L_0x0020:
            r0 = r1.zzaGU;
            r2.zza(r0);
            goto L_0x0000;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zzv(com.google.android.gms.internal.zzwq):com.google.android.gms.internal.zzwn$zza");
        }

        public com.google.android.gms.internal.zzwn.zza zzvp() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:284)
	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:182)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r1 = 0;
            r0 = "";
            r2.name = r0;
            r2.zzaGU = r1;
            r2.zzaHB = r1;
            r0 = -1;
            r2.zzaHM = r0;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwn.zza.zzvp():com.google.android.gms.internal.zzwn$zza");
        }
    }

    public zzwn() {
        zzvn();
    }

    public static zzwn zzq(byte[] bArr) {
        return (zzwn) zzwy.zza(new zzwn(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzwn)) {
            return false;
        }
        zzwn com_google_android_gms_internal_zzwn = (zzwn) obj;
        return zzww.equals(this.zzaGS, com_google_android_gms_internal_zzwn.zzaGS) ? zza((zzws) com_google_android_gms_internal_zzwn) : false;
    }

    public int hashCode() {
        return ((zzww.hashCode(this.zzaGS) + 527) * 31) + zzvL();
    }

    public void zza(zzwr com_google_android_gms_internal_zzwr) {
        if (this.zzaGS != null && this.zzaGS.length > 0) {
            for (zzwy com_google_android_gms_internal_zzwy : this.zzaGS) {
                if (com_google_android_gms_internal_zzwy != null) {
                    com_google_android_gms_internal_zzwr.zza(1, com_google_android_gms_internal_zzwy);
                }
            }
        }
        super.zza(com_google_android_gms_internal_zzwr);
    }

    public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) {
        return zzu(com_google_android_gms_internal_zzwq);
    }

    protected int zzc() {
        int zzc = super.zzc();
        if (this.zzaGS != null && this.zzaGS.length > 0) {
            for (zzwy com_google_android_gms_internal_zzwy : this.zzaGS) {
                if (com_google_android_gms_internal_zzwy != null) {
                    zzc += zzwr.zzc(1, com_google_android_gms_internal_zzwy);
                }
            }
        }
        return zzc;
    }

    public zzwn zzu(zzwq com_google_android_gms_internal_zzwq) {
        while (true) {
            int zzvu = com_google_android_gms_internal_zzwq.zzvu();
            switch (zzvu) {
                case 0:
                    break;
                case 10:
                    int zzc = zzxb.zzc(com_google_android_gms_internal_zzwq, 10);
                    zzvu = this.zzaGS == null ? 0 : this.zzaGS.length;
                    Object obj = new zza[(zzc + zzvu)];
                    if (zzvu != 0) {
                        System.arraycopy(this.zzaGS, 0, obj, 0, zzvu);
                    }
                    while (zzvu < obj.length - 1) {
                        obj[zzvu] = new zza();
                        com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                        com_google_android_gms_internal_zzwq.zzvu();
                        zzvu++;
                    }
                    obj[zzvu] = new zza();
                    com_google_android_gms_internal_zzwq.zza(obj[zzvu]);
                    this.zzaGS = obj;
                    continue;
                default:
                    if (!zza(com_google_android_gms_internal_zzwq, zzvu)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public zzwn zzvn() {
        this.zzaGS = zza.zzvo();
        this.zzaHB = null;
        this.zzaHM = -1;
        return this;
    }
}
