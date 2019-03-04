package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerService extends IntentService {
    CampaignTrackingService zzayQ;
    Context zzayR;

    public InstallReferrerService() {
        super("InstallReferrerService");
    }

    public InstallReferrerService(String str) {
        super(str);
    }

    private void zzc(Context context, Intent intent) {
        if (this.zzayQ == null) {
            this.zzayQ = new CampaignTrackingService();
        }
        this.zzayQ.zza(context, intent);
    }

    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        Context applicationContext = this.zzayR != null ? this.zzayR : getApplicationContext();
        zzaw.zzh(applicationContext, stringExtra);
        zzc(applicationContext, intent);
    }
}
