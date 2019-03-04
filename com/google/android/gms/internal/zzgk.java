package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public class zzgk extends zzhl implements com.google.android.gms.internal.zzgl.zza {
    private final Context mContext;
    Object zznh = new Object();
    zzdk zzsf;
    private final Object zzvM = new Object();
    zzgq zzvO;
    private final com.google.android.gms.internal.zzgj.zza zzwe;
    private final com.google.android.gms.internal.zzgo.zza zzwf;
    private final zzk zzwg;
    zzhl zzwh;

    class C12111 implements Runnable {
        final /* synthetic */ zzgk zzwi;

        C12111(zzgk com_google_android_gms_internal_zzgk) {
            this.zzwi = com_google_android_gms_internal_zzgk;
        }

        public void run() {
            this.zzwi.onStop();
        }
    }

    @zzgi
    final class zza extends Exception {
        private final int zzvR;

        public zza(String str, int i) {
            super(str);
            this.zzvR = i;
        }

        public int getErrorCode() {
            return this.zzvR;
        }
    }

    public zzgk(Context context, com.google.android.gms.internal.zzgo.zza com_google_android_gms_internal_zzgo_zza, zzk com_google_android_gms_internal_zzk, com.google.android.gms.internal.zzgj.zza com_google_android_gms_internal_zzgj_zza) {
        this.zzwe = com_google_android_gms_internal_zzgj_zza;
        this.mContext = context;
        this.zzwf = com_google_android_gms_internal_zzgo_zza;
        this.zzwg = com_google_android_gms_internal_zzk;
    }

    public void onStop() {
        synchronized (this.zzvM) {
            if (this.zzwh != null) {
                this.zzwh.cancel();
            }
        }
    }

    zzhl zza(zzgo com_google_android_gms_internal_zzgo) {
        return zzgl.zza(this.mContext, com_google_android_gms_internal_zzgo, this);
    }

    protected zzba zzb(zzgo com_google_android_gms_internal_zzgo) {
        if (this.zzvO.zzwL == null) {
            throw new zza("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.zzvO.zzwL.split("x");
        if (split.length != 2) {
            throw new zza("Invalid ad size format from the ad response: " + this.zzvO.zzwL, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (zzba com_google_android_gms_internal_zzba : com_google_android_gms_internal_zzgo.zzlV.zzpc) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = com_google_android_gms_internal_zzba.width == -1 ? (int) (((float) com_google_android_gms_internal_zzba.widthPixels) / f) : com_google_android_gms_internal_zzba.width;
                int i2 = com_google_android_gms_internal_zzba.height == -2 ? (int) (((float) com_google_android_gms_internal_zzba.heightPixels) / f) : com_google_android_gms_internal_zzba.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new zzba(com_google_android_gms_internal_zzba, com_google_android_gms_internal_zzgo.zzlV.zzpc);
                }
            }
            throw new zza("The ad size from the ad response was not one of the requested sizes: " + this.zzvO.zzwL, 0);
        } catch (NumberFormatException e) {
            throw new zza("Invalid ad size number from the ad response: " + this.zzvO.zzwL, 0);
        }
    }

    public void zzb(zzgq com_google_android_gms_internal_zzgq) {
        synchronized (this.zznh) {
            zzhx.zzY("Received ad response.");
            this.zzvO = com_google_android_gms_internal_zzgq;
            this.zznh.notify();
        }
    }

    protected boolean zzd(long j) {
        long elapsedRealtime = 60000 - (zzab.zzaQ().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zznh.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new zza("Ad request cancelled.", -1);
        }
    }

    protected void zzdI() {
        if (this.zzvO.errorCode != -3) {
            if (TextUtils.isEmpty(this.zzvO.zzwG)) {
                throw new zza("No fill from ad server.", 3);
            }
            zzab.zzaP().zza(this.mContext, this.zzvO.zzwv);
            if (this.zzvO.zzwI) {
                try {
                    this.zzsf = new zzdk(this.zzvO.zzwG);
                } catch (JSONException e) {
                    throw new zza("Could not parse mediation config: " + this.zzvO.zzwG, 0);
                }
            }
        }
    }

    public void zzdw() {
        zza e;
        synchronized (this.zznh) {
            long elapsedRealtime;
            zzba zzb;
            JSONObject jSONObject;
            final com.google.android.gms.internal.zzhe.zza com_google_android_gms_internal_zzhe_zza;
            zzhx.zzY("AdLoaderBackgroundTask started.");
            zzgo com_google_android_gms_internal_zzgo = new zzgo(this.zzwf, this.zzwg.zzC().zza(this.mContext), zzz.zzj(this.mContext).getClientId());
            int i = -2;
            long j = -1;
            try {
                elapsedRealtime = zzab.zzaQ().elapsedRealtime();
                zzhl zza = zza(com_google_android_gms_internal_zzgo);
                synchronized (this.zzvM) {
                    this.zzwh = zza;
                    if (this.zzwh == null) {
                        throw new zza("Could not start the ad request service.", 0);
                    }
                }
                zzh(elapsedRealtime);
                j = zzab.zzaQ().elapsedRealtime();
                zzdI();
                zzb = com_google_android_gms_internal_zzgo.zzlV.zzpc != null ? zzb(com_google_android_gms_internal_zzgo) : null;
                try {
                    zzv(this.zzvO.zzwT);
                    elapsedRealtime = j;
                } catch (zza e2) {
                    e = e2;
                    i = e.getErrorCode();
                    if (i == 3 || i == -1) {
                        zzhx.zzaa(e.getMessage());
                    } else {
                        zzhx.zzac(e.getMessage());
                    }
                    if (this.zzvO == null) {
                        this.zzvO = new zzgq(i);
                    } else {
                        this.zzvO = new zzgq(i, this.zzvO.zzsx);
                    }
                    zzhw.zzzG.post(new C12111(this));
                    elapsedRealtime = j;
                    if (!TextUtils.isEmpty(this.zzvO.zzwQ)) {
                        try {
                            jSONObject = new JSONObject(this.zzvO.zzwQ);
                        } catch (Throwable e3) {
                            zzhx.zzb("Error parsing the JSON for Active View.", e3);
                        }
                        com_google_android_gms_internal_zzhe_zza = new com.google.android.gms.internal.zzhe.zza(com_google_android_gms_internal_zzgo, this.zzvO, this.zzsf, zzb, i, elapsedRealtime, this.zzvO.zzwM, jSONObject);
                        zzhw.zzzG.post(new Runnable(this) {
                            final /* synthetic */ zzgk zzwi;

                            public void run() {
                                synchronized (this.zzwi.zznh) {
                                    this.zzwi.zzwe.zza(com_google_android_gms_internal_zzhe_zza);
                                }
                            }
                        });
                    }
                    jSONObject = null;
                    com_google_android_gms_internal_zzhe_zza = new com.google.android.gms.internal.zzhe.zza(com_google_android_gms_internal_zzgo, this.zzvO, this.zzsf, zzb, i, elapsedRealtime, this.zzvO.zzwM, jSONObject);
                    zzhw.zzzG.post(/* anonymous class already generated */);
                }
            } catch (zza e4) {
                e = e4;
                zzb = null;
            }
            if (TextUtils.isEmpty(this.zzvO.zzwQ)) {
                jSONObject = new JSONObject(this.zzvO.zzwQ);
                com_google_android_gms_internal_zzhe_zza = new com.google.android.gms.internal.zzhe.zza(com_google_android_gms_internal_zzgo, this.zzvO, this.zzsf, zzb, i, elapsedRealtime, this.zzvO.zzwM, jSONObject);
                zzhw.zzzG.post(/* anonymous class already generated */);
            }
            jSONObject = null;
            com_google_android_gms_internal_zzhe_zza = new com.google.android.gms.internal.zzhe.zza(com_google_android_gms_internal_zzgo, this.zzvO, this.zzsf, zzb, i, elapsedRealtime, this.zzvO.zzwM, jSONObject);
            zzhw.zzzG.post(/* anonymous class already generated */);
        }
    }

    protected void zzh(long j) {
        while (zzd(j)) {
            if (this.zzvO != null) {
                synchronized (this.zzvM) {
                    this.zzwh = null;
                }
                if (this.zzvO.errorCode != -2 && this.zzvO.errorCode != -3) {
                    throw new zza("There was a problem getting an ad response. ErrorCode: " + this.zzvO.errorCode, this.zzvO.errorCode);
                }
                return;
            }
        }
        throw new zza("Timed out waiting for ad response.", 2);
    }

    protected void zzv(boolean z) {
        zzab.zzaP().zzz(z);
        zzan zzo = zzab.zzaP().zzo(this.mContext);
        if (zzo != null && !zzo.isAlive()) {
            zzhx.zzY("start fetching content...");
            zzo.zzbt();
        }
    }
}
