package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.zzfp;
import com.google.android.gms.internal.zzfu;
import com.google.android.gms.internal.zzhx;

public class InAppPurchaseActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
    public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
    private zzfp zzAx;

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.zzAx != null) {
                this.zzAx.onActivityResult(i, i2, intent);
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzAx = zzfu.zze(this);
        if (this.zzAx == null) {
            zzhx.zzac("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.zzAx.onCreate();
        } catch (Throwable e) {
            zzhx.zzd("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.zzAx != null) {
                this.zzAx.onDestroy();
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
