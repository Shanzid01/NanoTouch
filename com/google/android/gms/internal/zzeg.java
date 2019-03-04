package com.google.android.gms.internal;

import org.json.JSONObject;

@zzgi
public class zzeg {
    private final zzic zzmu;
    private final String zztP;

    public zzeg(zzic com_google_android_gms_internal_zzic) {
        this(com_google_android_gms_internal_zzic, "");
    }

    public zzeg(zzic com_google_android_gms_internal_zzic, String str) {
        this.zzmu = com_google_android_gms_internal_zzic;
        this.zztP = str;
    }

    public void zzH(String str) {
        try {
            this.zzmu.zzb("onError", new JSONObject().put("message", str).put("action", this.zztP));
        } catch (Throwable e) {
            zzhx.zzb("Error occurred while dispatching error event.", e);
        }
    }

    public void zzI(String str) {
        try {
            this.zzmu.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (Throwable e) {
            zzhx.zzb("Error occured while dispatching ready Event.", e);
        }
    }

    public void zzJ(String str) {
        try {
            this.zzmu.zzb("onStateChanged", new JSONObject().put("state", str));
        } catch (Throwable e) {
            zzhx.zzb("Error occured while dispatching state change.", e);
        }
    }

    public void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzmu.zzb("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (Throwable e) {
            zzhx.zzb("Error occured while obtaining screen information.", e);
        }
    }

    public void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzmu.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            zzhx.zzb("Error occured while dispatching size change.", e);
        }
    }

    public void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzmu.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            zzhx.zzb("Error occured while dispatching default position.", e);
        }
    }
}
