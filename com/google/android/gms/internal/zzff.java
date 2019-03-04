package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzfp.zza;

@zzgi
public class zzff extends zza implements ServiceConnection {
    private final Activity zzoi;
    private zzfc zzuY;
    zzfi zzuZ;
    private zzfl zzvb;
    private Context zzvh;
    private zzfn zzvi;
    private zzfg zzvj;
    private zzfk zzvk;
    private String zzvl = null;

    public zzff(Activity activity) {
        this.zzoi = activity;
        this.zzuZ = zzfi.zzm(this.zzoi.getApplicationContext());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1001) {
            boolean z = false;
            try {
                int zzd = zzab.zzaU().zzd(intent);
                if (i2 == -1) {
                    zzab.zzaU();
                    if (zzd == 0) {
                        if (this.zzvb.zza(this.zzvl, i2, intent)) {
                            z = true;
                        }
                        this.zzvi.recordPlayBillingResolution(zzd);
                        this.zzoi.finish();
                        zza(this.zzvi.getProductId(), z, i2, intent);
                    }
                }
                this.zzuZ.zza(this.zzvj);
                this.zzvi.recordPlayBillingResolution(zzd);
                this.zzoi.finish();
                zza(this.zzvi.getProductId(), z, i2, intent);
            } catch (RemoteException e) {
                zzhx.zzac("Fail to process purchase result.");
                this.zzoi.finish();
            } finally {
                this.zzvl = null;
            }
        }
    }

    public void onCreate() {
        zzfb zzc = zzfb.zzc(this.zzoi.getIntent());
        this.zzvk = zzc.zzuU;
        this.zzvb = zzc.zzmg;
        this.zzvi = zzc.zzuS;
        this.zzuY = new zzfc(this.zzoi.getApplicationContext());
        this.zzvh = zzc.zzuT;
        if (this.zzoi.getResources().getConfiguration().orientation == 2) {
            this.zzoi.setRequestedOrientation(zzab.zzaO().zzex());
        } else {
            this.zzoi.setRequestedOrientation(zzab.zzaO().zzey());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        this.zzoi.bindService(intent, this, 1);
    }

    public void onDestroy() {
        this.zzoi.unbindService(this);
        this.zzuY.destroy();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Throwable e;
        this.zzuY.zzx(iBinder);
        try {
            this.zzvl = this.zzvb.zzdB();
            Bundle zzb = this.zzuY.zzb(this.zzoi.getPackageName(), this.zzvi.getProductId(), this.zzvl);
            PendingIntent pendingIntent = (PendingIntent) zzb.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int zzf = zzab.zzaU().zzf(zzb);
                this.zzvi.recordPlayBillingResolution(zzf);
                zza(this.zzvi.getProductId(), false, zzf, null);
                this.zzoi.finish();
                return;
            }
            this.zzvj = new zzfg(this.zzvi.getProductId(), this.zzvl);
            this.zzuZ.zzb(this.zzvj);
            this.zzoi.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (RemoteException e2) {
            e = e2;
            zzhx.zzd("Error when connecting in-app billing service", e);
            this.zzoi.finish();
        } catch (SendIntentException e3) {
            e = e3;
            zzhx.zzd("Error when connecting in-app billing service", e);
            this.zzoi.finish();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzhx.zzaa("In-app billing service disconnected.");
        this.zzuY.destroy();
    }

    protected void zza(String str, boolean z, int i, Intent intent) {
        if (this.zzvk != null) {
            this.zzvk.zza(str, z, i, intent, this.zzvj);
        }
    }
}
