package com.slideme.sam.manager.model.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteException;
import android.text.TextUtils;
import com.slideme.sam.manager.net.wrappers.C1893b;
import com.slideme.sam.manager.util.C1922m;
import java.io.File;

/* compiled from: ApplicationDownloadService */
final class C1862f extends Handler {
    final /* synthetic */ ApplicationDownloadService f3321a;

    public C1862f(ApplicationDownloadService applicationDownloadService, Looper looper) {
        this.f3321a = applicationDownloadService;
        super(looper);
    }

    public void handleMessage(Message message) {
        C1893b c1893b = (C1893b) this.f3321a.f3294c.get(Integer.valueOf(message.arg2));
        if (c1893b != null) {
            if (c1893b.mo4318a() == null || TextUtils.isEmpty(c1893b.mo4318a().localFilePath) || !new File(c1893b.mo4318a().localFilePath).exists() || !this.f3321a.m5550a(c1893b.mo4318a().localFilePath)) {
                this.f3321a.f3301j = message.replyTo;
                c1893b.m5706a(new C1863g(this, c1893b));
                if (this.f3321a.f3301j != null) {
                    try {
                        Message obtain = Message.obtain(null, 1000);
                        obtain.arg1 = message.arg2;
                        this.f3321a.f3301j.send(obtain);
                    } catch (RemoteException e) {
                    }
                }
                this.f3321a.f3293b = ((PowerManager) this.f3321a.getSystemService("power")).newWakeLock(1, "SlideMeDownloader");
                this.f3321a.m5543a(true);
                C1922m.m5797b("AppDownloder", "Starting FileDownloader download()");
                c1893b.m5707c();
                C1922m.m5797b("AppDownloder", "Finished FileDownloader download()");
                return;
            }
            C1922m.m5797b("AppDownloder", "APK already exists");
            this.f3321a.m5534a(c1893b.mo4318a(), c1893b.mo4319b());
        }
    }
}
