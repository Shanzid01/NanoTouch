package com.slideme.sam.manager.model.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.content.C0090q;
import com.google.android.gms.drive.DriveFile;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.market.InstallDelegateActivity;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.p054b.C1827a;
import com.slideme.sam.manager.model.p054b.C1828b;
import com.slideme.sam.manager.p052a.C1593a;
import com.slideme.sam.manager.util.C1915f;
import com.slideme.sam.manager.util.C1922m;
import java.io.File;

public class LaunchOrInstallService extends IntentService {
    private Handler f3309a;

    public LaunchOrInstallService() {
        super(LaunchOrInstallService.class.getName());
        setIntentRedelivery(true);
    }

    public void onCreate() {
        super.onCreate();
        this.f3309a = new Handler();
    }

    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.setClassLoader(LaunchOrInstallService.class.getClassLoader());
            Application application = (Application) C1915f.m5770a(intent, "com.slideme.sam.manager.EXTRA_APPLICATION", Application.CREATOR);
            if (C1827a.m5491a(this, application.packageName, application.versionCode) == C1828b.UP_TO_DATE) {
                C1827a.m5494a((Context) this, application);
            } else if (new File(application.localFilePath).exists()) {
                m5561a(application);
            } else {
                Intent intent2 = new Intent(this, ApplicationDownloadService.class);
                C1915f.m5769a(intent, "com.slideme.sam.manager.EXTRA_APPLICATION", (Parcelable) application);
                startService(intent2);
                m5560a((int) R.string.apk_deleted_redowloading);
            }
        }
    }

    private void m5561a(Application application) {
        C1922m.m5797b("Install", "requestInstall for " + application.name);
        Intent intent;
        try {
            C1593a c1593a = new C1593a(this);
            c1593a.m4783a(new C1864h(this, application));
            c1593a.m4785a(application.localFilePath);
            intent = new Intent("com.slideme.sam.manager.ACTION_SILENT_INSTALL_START");
            intent.putExtra("com.slideme.sam.manager.EXTRA_APP_NID", Integer.valueOf(application.nodeId));
            C0090q.m145a(getApplication()).m150a(intent);
        } catch (Exception e) {
            C1922m.m5797b("Install", "Silent Install failed for " + application.name + " with message " + e.getMessage() + " starting native installer");
            intent = new Intent(this, InstallDelegateActivity.class);
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            C1915f.m5769a(intent, "com.slideme.sam.manager.EXTRA_APPLICATION", (Parcelable) application);
            startActivity(intent);
        }
    }

    public static boolean m5562a(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.delete()) {
            return false;
        }
        return true;
    }

    private void m5560a(int i) {
        this.f3309a.post(new C1865i(this, i));
    }
}
