package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzgi
public class zzhe {
    public final int errorCode;
    public final int orientation;
    public final zzdj zzsL;
    public final zzds zzsM;
    public final String zzsN;
    public final zzdm zzsO;
    public final List<String> zzst;
    public final List<String> zzsu;
    public final long zzsx;
    public final zzic zzuq;
    public final String zzwD;
    public final long zzwH;
    public final boolean zzwI;
    public final long zzwJ;
    public final List<String> zzwK;
    public final String zzwN;
    public final zzax zzwn;
    public final String zzwq;
    public final JSONObject zzys;
    public final zzdk zzyt;
    public final zzba zzyu;
    public final long zzyv;
    public final long zzyw;
    public final com.google.android.gms.internal.zzcn.zza zzyx;

    @zzgi
    public final class zza {
        public final int errorCode;
        public final zzba zzlV;
        public final JSONObject zzys;
        public final zzdk zzyt;
        public final long zzyv;
        public final long zzyw;
        public final zzgo zzyy;
        public final zzgq zzyz;

        public zza(zzgo com_google_android_gms_internal_zzgo, zzgq com_google_android_gms_internal_zzgq, zzdk com_google_android_gms_internal_zzdk, zzba com_google_android_gms_internal_zzba, int i, long j, long j2, JSONObject jSONObject) {
            this.zzyy = com_google_android_gms_internal_zzgo;
            this.zzyz = com_google_android_gms_internal_zzgq;
            this.zzyt = com_google_android_gms_internal_zzdk;
            this.zzlV = com_google_android_gms_internal_zzba;
            this.errorCode = i;
            this.zzyv = j;
            this.zzyw = j2;
            this.zzys = jSONObject;
        }
    }

    public zzhe(zzax com_google_android_gms_internal_zzax, zzic com_google_android_gms_internal_zzic, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, zzdj com_google_android_gms_internal_zzdj, zzds com_google_android_gms_internal_zzds, String str2, zzdk com_google_android_gms_internal_zzdk, zzdm com_google_android_gms_internal_zzdm, long j2, zzba com_google_android_gms_internal_zzba, long j3, long j4, long j5, String str3, JSONObject jSONObject, com.google.android.gms.internal.zzcn.zza com_google_android_gms_internal_zzcn_zza, String str4) {
        this.zzwn = com_google_android_gms_internal_zzax;
        this.zzuq = com_google_android_gms_internal_zzic;
        this.zzst = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i;
        this.zzsu = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzwK = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.orientation = i2;
        this.zzsx = j;
        this.zzwq = str;
        this.zzwI = z;
        this.zzsL = com_google_android_gms_internal_zzdj;
        this.zzsM = com_google_android_gms_internal_zzds;
        this.zzsN = str2;
        this.zzyt = com_google_android_gms_internal_zzdk;
        this.zzsO = com_google_android_gms_internal_zzdm;
        this.zzwJ = j2;
        this.zzyu = com_google_android_gms_internal_zzba;
        this.zzwH = j3;
        this.zzyv = j4;
        this.zzyw = j5;
        this.zzwN = str3;
        this.zzys = jSONObject;
        this.zzyx = com_google_android_gms_internal_zzcn_zza;
        this.zzwD = str4;
    }

    public zzhe(zza com_google_android_gms_internal_zzhe_zza, zzic com_google_android_gms_internal_zzic, zzdj com_google_android_gms_internal_zzdj, zzds com_google_android_gms_internal_zzds, String str, zzdm com_google_android_gms_internal_zzdm, com.google.android.gms.internal.zzcn.zza com_google_android_gms_internal_zzcn_zza) {
        this(com_google_android_gms_internal_zzhe_zza.zzyy.zzwn, com_google_android_gms_internal_zzic, com_google_android_gms_internal_zzhe_zza.zzyz.zzst, com_google_android_gms_internal_zzhe_zza.errorCode, com_google_android_gms_internal_zzhe_zza.zzyz.zzsu, com_google_android_gms_internal_zzhe_zza.zzyz.zzwK, com_google_android_gms_internal_zzhe_zza.zzyz.orientation, com_google_android_gms_internal_zzhe_zza.zzyz.zzsx, com_google_android_gms_internal_zzhe_zza.zzyy.zzwq, com_google_android_gms_internal_zzhe_zza.zzyz.zzwI, com_google_android_gms_internal_zzdj, com_google_android_gms_internal_zzds, str, com_google_android_gms_internal_zzhe_zza.zzyt, com_google_android_gms_internal_zzdm, com_google_android_gms_internal_zzhe_zza.zzyz.zzwJ, com_google_android_gms_internal_zzhe_zza.zzlV, com_google_android_gms_internal_zzhe_zza.zzyz.zzwH, com_google_android_gms_internal_zzhe_zza.zzyv, com_google_android_gms_internal_zzhe_zza.zzyw, com_google_android_gms_internal_zzhe_zza.zzyz.zzwN, com_google_android_gms_internal_zzhe_zza.zzys, com_google_android_gms_internal_zzcn_zza, com_google_android_gms_internal_zzhe_zza.zzyy.zzwD);
    }

    public boolean zzba() {
        return (this.zzuq == null || this.zzuq.zzeG() == null) ? false : this.zzuq.zzeG().zzba();
    }
}
