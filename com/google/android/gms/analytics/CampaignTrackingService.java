package com.google.android.gms.analytics;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import java.io.IOException;
import java.io.OutputStream;

public class CampaignTrackingService extends IntentService {
    public CampaignTrackingService() {
        super("CampaignIntentService");
    }

    public CampaignTrackingService(String str) {
        super(str);
    }

    public void onHandleIntent(Intent intent) {
        zza(this, intent);
    }

    public void zza(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        if (stringExtra == null) {
            zzae.zzZ("Campaign data not found.");
            return;
        }
        try {
            OutputStream openFileOutput = context.openFileOutput("gaInstallData", 0);
            openFileOutput.write(stringExtra.getBytes());
            openFileOutput.close();
            zzae.zzab("Stored campaign information.");
        } catch (IOException e) {
            zzae.zzZ("Error storing install campaign.");
        }
    }
}
