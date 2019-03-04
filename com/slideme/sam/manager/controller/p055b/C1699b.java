package com.slideme.sam.manager.controller.p055b;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.market.product.ApplicationDetailsActivity;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.model.p054b.C1827a;
import com.slideme.sam.manager.model.p054b.C1828b;
import com.slideme.sam.manager.model.service.ApplicationDownloadService;
import com.slideme.sam.manager.net.wrappers.C1891a;
import com.slideme.sam.manager.util.C1915f;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: ActivityHelper */
class C1699b implements Runnable {
    private final /* synthetic */ String f2896a;
    private final /* synthetic */ Activity f2897b;

    C1699b(String str, Activity activity) {
        this.f2896a = str;
        this.f2897b = activity;
    }

    public void run() {
        C1891a c1891a = new C1891a(this.f2896a, true, false, this.f2897b.getString(R.string.live_channel));
        c1891a.m5698b();
        if (c1891a.m5697a() == null || c1891a.m5697a().isEmpty()) {
            C1922m.m5797b("AutoDownload", "AutoDownload application could not be found");
            C1827a.m5495a(this.f2897b, this.f2896a);
            C1698a.m5059a(this.f2897b, false, null);
            return;
        }
        Application application = (Application) c1891a.m5697a().get(0);
        if (C1827a.m5491a(this.f2897b, application.packageName, application.versionCode) != C1828b.UP_TO_DATE) {
            C1922m.m5797b("AutoDownload", "AutoDownload app with bundleId: " + this.f2896a);
            Intent intent = new Intent(this.f2897b, ApplicationDownloadService.class);
            C1915f.m5769a(intent, "com.slideme.sam.manager.EXTRA_APPLICATION", (Parcelable) application);
            intent.putExtra("com.slideme.sam.manager.EXTRA_AUTO_DOWNLOAD", true);
            this.f2897b.startService(intent);
        } else {
            C1922m.m5797b("AutoDownload", "AutoDownload application already exists and up to date");
            C1827a.m5495a(this.f2897b, application.bundleId);
        }
        Parcelable applicationHolder = new ApplicationHolder(application);
        applicationHolder.downloadPrimarySynch(this.f2897b);
        Intent intent2 = new Intent(this.f2897b, ApplicationDetailsActivity.class);
        intent2.putExtra("com.slideme.sam.manager.EXTRA_APPHOLDER", applicationHolder);
        intent2.addFlags(67108864);
        this.f2897b.startActivity(intent2);
    }
}
