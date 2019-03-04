package com.google.android.gms.internal;

public final class zzxb {
    public static final int[] zzaHO = new int[0];
    public static final long[] zzaHP = new long[0];
    public static final float[] zzaHQ = new float[0];
    public static final double[] zzaHR = new double[0];
    public static final boolean[] zzaHS = new boolean[0];
    public static final String[] zzaHT = new String[0];
    public static final byte[][] zzaHU = new byte[0][];
    public static final byte[] zzaHV = new byte[0];

    static int zzD(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean zzb(zzwq com_google_android_gms_internal_zzwq, int i) {
        return com_google_android_gms_internal_zzwq.zzin(i);
    }

    public static final int zzc(zzwq com_google_android_gms_internal_zzwq, int i) {
        int i2 = 1;
        int position = com_google_android_gms_internal_zzwq.getPosition();
        com_google_android_gms_internal_zzwq.zzin(i);
        while (com_google_android_gms_internal_zzwq.zzvu() == i) {
            com_google_android_gms_internal_zzwq.zzin(i);
            i2++;
        }
        com_google_android_gms_internal_zzwq.zzir(position);
        return i2;
    }

    static int zziH(int i) {
        return i & 7;
    }

    public static int zziI(int i) {
        return i >>> 3;
    }
}
