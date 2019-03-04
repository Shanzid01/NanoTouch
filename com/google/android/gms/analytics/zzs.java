package com.google.android.gms.analytics;

public final class zzs {
    static String zzE(int i) {
        return zzd("&cd", i);
    }

    static String zzF(int i) {
        return zzd("&cm", i);
    }

    public static String zzG(int i) {
        return zzd("&pr", i);
    }

    public static String zzH(int i) {
        return zzd("&promo", i);
    }

    public static String zzI(int i) {
        return zzd("pi", i);
    }

    public static String zzJ(int i) {
        return zzd("&il", i);
    }

    public static String zzK(int i) {
        return zzd("cd", i);
    }

    public static String zzL(int i) {
        return zzd("cm", i);
    }

    private static String zzd(String str, int i) {
        if (i >= 1) {
            return str + i;
        }
        zzae.zzZ("index out of range for " + str + " (" + i + ")");
        return "";
    }
}
