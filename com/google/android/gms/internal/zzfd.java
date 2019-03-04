package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzgi
public class zzfd extends zzhl implements ServiceConnection {
    private Context mContext;
    private final Object zznh;
    private boolean zzuW;
    private zzfs zzuX;
    private zzfc zzuY;
    private zzfi zzuZ;
    private List<zzfg> zzva;
    private zzfl zzvb;

    public zzfd(Context context, zzfs com_google_android_gms_internal_zzfs, zzfl com_google_android_gms_internal_zzfl) {
        this(context, com_google_android_gms_internal_zzfs, com_google_android_gms_internal_zzfl, new zzfc(context), zzfi.zzm(context.getApplicationContext()));
    }

    zzfd(Context context, zzfs com_google_android_gms_internal_zzfs, zzfl com_google_android_gms_internal_zzfl, zzfc com_google_android_gms_internal_zzfc, zzfi com_google_android_gms_internal_zzfi) {
        this.zznh = new Object();
        this.zzuW = false;
        this.zzva = null;
        this.mContext = context;
        this.zzuX = com_google_android_gms_internal_zzfs;
        this.zzvb = com_google_android_gms_internal_zzfl;
        this.zzuY = com_google_android_gms_internal_zzfc;
        this.zzuZ = com_google_android_gms_internal_zzfi;
        this.zzva = this.zzuZ.zze(10);
    }

    private void zzc(long j) {
        do {
            if (!zzd(j)) {
                zzhx.zzab("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.zzuW);
    }

    private boolean zzd(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zznh.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            zzhx.zzac("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zznh) {
            this.zzuY.zzx(iBinder);
            zzdx();
            this.zzuW = true;
            this.zznh.notify();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzhx.zzaa("In-app billing service disconnected.");
        this.zzuY.destroy();
    }

    public void onStop() {
        synchronized (this.zznh) {
            zzlo.zzka().zza(this.mContext, this);
            this.zzuY.destroy();
        }
    }

    protected void zza(final zzfg com_google_android_gms_internal_zzfg, String str, String str2) {
        final Intent intent = new Intent();
        zzab.zzaU();
        intent.putExtra("RESPONSE_CODE", 0);
        zzab.zzaU();
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        zzab.zzaU();
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzfd zzve;

            public void run() {
                try {
                    if (this.zzve.zzvb.zza(com_google_android_gms_internal_zzfg.zzvn, -1, intent)) {
                        this.zzve.zzuX.zza(new zzfh(this.zzve.mContext, com_google_android_gms_internal_zzfg.zzvo, true, -1, intent, com_google_android_gms_internal_zzfg));
                    } else {
                        this.zzve.zzuX.zza(new zzfh(this.zzve.mContext, com_google_android_gms_internal_zzfg.zzvo, false, -1, intent, com_google_android_gms_internal_zzfg));
                    }
                } catch (RemoteException e) {
                    zzhx.zzac("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    public void zzdw() {
        synchronized (this.zznh) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            zzlo.zzka().zza(this.mContext, intent, (ServiceConnection) this, 1);
            zzc(SystemClock.elapsedRealtime());
            zzlo.zzka().zza(this.mContext, this);
            this.zzuY.destroy();
        }
    }

    protected void zzdx() {
        if (!this.zzva.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (zzfg com_google_android_gms_internal_zzfg : this.zzva) {
                hashMap.put(com_google_android_gms_internal_zzfg.zzvo, com_google_android_gms_internal_zzfg);
            }
            String str = null;
            while (true) {
                Bundle zzh = this.zzuY.zzh(this.mContext.getPackageName(), str);
                if (zzh == null || zzab.zzaU().zzf(zzh) != 0) {
                    break;
                }
                ArrayList stringArrayList = zzh.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList stringArrayList2 = zzh.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList stringArrayList3 = zzh.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String string = zzh.getString("INAPP_CONTINUATION_TOKEN");
                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (hashMap.containsKey(stringArrayList.get(i))) {
                        str = (String) stringArrayList.get(i);
                        String str2 = (String) stringArrayList2.get(i);
                        String str3 = (String) stringArrayList3.get(i);
                        zzfg com_google_android_gms_internal_zzfg2 = (zzfg) hashMap.get(str);
                        if (com_google_android_gms_internal_zzfg2.zzvn.equals(zzab.zzaU().zzL(str2))) {
                            zza(com_google_android_gms_internal_zzfg2, str2, str3);
                            hashMap.remove(str);
                        }
                    }
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str4 : hashMap.keySet()) {
                this.zzuZ.zza((zzfg) hashMap.get(str4));
            }
        }
    }
}
