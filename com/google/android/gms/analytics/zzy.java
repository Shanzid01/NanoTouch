package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

class zzy {
    private static final zzy zzCU = new zzy();
    private SortedSet<zza> zzCR = new TreeSet();
    private StringBuilder zzCS = new StringBuilder();
    private boolean zzCT = false;

    public enum zza {
        MAP_BUILDER_SET,
        MAP_BUILDER_SET_ALL,
        MAP_BUILDER_GET,
        MAP_BUILDER_SET_CAMPAIGN_PARAMS,
        BLANK_04,
        BLANK_05,
        BLANK_06,
        BLANK_07,
        BLANK_08,
        GET,
        SET,
        SEND,
        BLANK_12,
        BLANK_13,
        BLANK_14,
        BLANK_15,
        BLANK_16,
        BLANK_17,
        BLANK_18,
        BLANK_19,
        BLANK_20,
        BLANK_21,
        BLANK_22,
        BLANK_23,
        BLANK_24,
        BLANK_25,
        BLANK_26,
        BLANK_27,
        BLANK_28,
        BLANK_29,
        SET_EXCEPTION_PARSER,
        GET_EXCEPTION_PARSER,
        CONSTRUCT_TRANSACTION,
        CONSTRUCT_EXCEPTION,
        CONSTRUCT_RAW_EXCEPTION,
        CONSTRUCT_TIMING,
        CONSTRUCT_SOCIAL,
        BLANK_37,
        BLANK_38,
        GET_TRACKER,
        GET_DEFAULT_TRACKER,
        SET_DEFAULT_TRACKER,
        SET_APP_OPT_OUT,
        GET_APP_OPT_OUT,
        DISPATCH,
        SET_DISPATCH_PERIOD,
        BLANK_46,
        REPORT_UNCAUGHT_EXCEPTIONS,
        SET_AUTO_ACTIVITY_TRACKING,
        SET_SESSION_TIMEOUT,
        CONSTRUCT_EVENT,
        CONSTRUCT_ITEM,
        BLANK_52,
        BLANK_53,
        SET_DRY_RUN,
        GET_DRY_RUN,
        SET_LOGGER,
        SET_FORCE_LOCAL_DISPATCH,
        GET_TRACKER_NAME,
        CLOSE_TRACKER,
        EASY_TRACKER_ACTIVITY_START,
        EASY_TRACKER_ACTIVITY_STOP,
        CONSTRUCT_APP_VIEW
    }

    private zzy() {
    }

    public static zzy zzfV() {
        return zzCU;
    }

    public synchronized void zzF(boolean z) {
        this.zzCT = z;
    }

    public synchronized void zza(zza com_google_android_gms_analytics_zzy_zza) {
        if (!this.zzCT) {
            this.zzCR.add(com_google_android_gms_analytics_zzy_zza);
            this.zzCS.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(com_google_android_gms_analytics_zzy_zza.ordinal()));
        }
    }

    public synchronized String zzfW() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        int i = 6;
        int i2 = 0;
        while (this.zzCR.size() > 0) {
            zza com_google_android_gms_analytics_zzy_zza = (zza) this.zzCR.first();
            this.zzCR.remove(com_google_android_gms_analytics_zzy_zza);
            int ordinal = com_google_android_gms_analytics_zzy_zza.ordinal();
            while (ordinal >= i) {
                stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
                i += 6;
                i2 = 0;
            }
            i2 += 1 << (com_google_android_gms_analytics_zzy_zza.ordinal() % 6);
        }
        if (i2 > 0 || stringBuilder.length() == 0) {
            stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
        }
        this.zzCR.clear();
        return stringBuilder.toString();
    }

    public synchronized String zzfX() {
        String stringBuilder;
        if (this.zzCS.length() > 0) {
            this.zzCS.insert(0, ".");
        }
        stringBuilder = this.zzCS.toString();
        this.zzCS = new StringBuilder();
        return stringBuilder;
    }
}
