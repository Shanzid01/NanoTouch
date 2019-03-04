package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzfr.zza;

@zzgi
public final class zzfh extends zza implements ServiceConnection {
    private Context mContext;
    zzfc zzuY;
    private String zzvf;
    private zzfg zzvj;
    private boolean zzvp = false;
    private int zzvq;
    private Intent zzvr;

    public zzfh(Context context, String str, boolean z, int i, Intent intent, zzfg com_google_android_gms_internal_zzfg) {
        this.zzvf = str;
        this.zzvq = i;
        this.zzvr = intent;
        this.zzvp = z;
        this.mContext = context;
        this.zzvj = com_google_android_gms_internal_zzfg;
    }

    public void finishPurchase() {
        int zzd = zzab.zzaU().zzd(this.zzvr);
        if (this.zzvq == -1 && zzd == 0) {
            this.zzuY = new zzfc(this.mContext);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            zzlo.zzka().zza(this.mContext, intent, (ServiceConnection) this, 1);
        }
    }

    public String getProductId() {
        return this.zzvf;
    }

    public Intent getPurchaseData() {
        return this.zzvr;
    }

    public int getResultCode() {
        return this.zzvq;
    }

    public boolean isVerified() {
        return this.zzvp;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzhx.zzaa("In-app billing service connected.");
        this.zzuY.zzx(iBinder);
        String zzM = zzab.zzaU().zzM(zzab.zzaU().zze(this.zzvr));
        if (zzM != null) {
            if (this.zzuY.zzg(this.mContext.getPackageName(), zzM) == 0) {
                zzfi.zzm(this.mContext).zza(this.zzvj);
            }
            zzlo.zzka().zza(this.mContext, this);
            this.zzuY.destroy();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzhx.zzaa("In-app billing service disconnected.");
        this.zzuY.destroy();
    }
}
