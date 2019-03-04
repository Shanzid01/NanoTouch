package com.slideme.sam.manager.model.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.PowerManager.WakeLock;
import android.support.v4.content.C0090q;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.p055b.C1704f;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.p054b.C1827a;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.C1878k;
import com.slideme.sam.manager.net.wrappers.C1893b;
import com.slideme.sam.manager.net.wrappers.C1901n;
import com.slideme.sam.manager.net.wrappers.C1902o;
import com.slideme.sam.manager.util.C1915f;
import com.slideme.sam.manager.util.C1922m;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class ApplicationDownloadService extends Service {
    final Messenger f3292a = new Messenger(new C1860d(this, this));
    private WakeLock f3293b;
    private HashMap<Integer, C1893b> f3294c = new HashMap();
    private HashMap<String, C1901n> f3295d = new HashMap();
    private HashMap<Integer, C1902o> f3296e = new HashMap();
    private HashMap<Integer, Notification> f3297f = new HashMap();
    private Looper f3298g;
    private C1862f f3299h;
    private NotificationManager f3300i;
    private Messenger f3301j;
    private boolean f3302k = true;
    private C1861e f3303l = new C1861e(this);

    public IBinder onBind(Intent intent) {
        return this.f3292a.getBinder();
    }

    private void m5543a(boolean z) {
        if (VERSION.SDK_INT > 13 && this.f3293b != null) {
            if (z) {
                try {
                    this.f3293b.acquire(600000);
                } catch (Exception e) {
                }
            } else if (this.f3293b.isHeld()) {
                this.f3293b.release();
            }
        }
    }

    public void onCreate() {
        HandlerThread handlerThread = new HandlerThread(getClass().getName(), 1);
        handlerThread.start();
        this.f3298g = handlerThread.getLooper();
        this.f3299h = new C1862f(this, this.f3298g);
        this.f3300i = (NotificationManager) getSystemService("notification");
        this.f3302k = getResources().getBoolean(R.bool.showDownloadProgressNotifications);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            Application application = (Application) C1915f.m5770a(intent, "com.slideme.sam.manager.EXTRA_APPLICATION", Application.CREATOR);
            boolean booleanExtra = intent.getBooleanExtra("com.slideme.sam.manager.EXTRA_AUTO_DOWNLOAD", false);
            C1922m.m5797b("AppDownloder", "Starting download for " + application.nodeId);
            Notification a = C1704f.m5074a(this, application, true, 0, 0);
            this.f3297f.put(Integer.valueOf(application.nodeId), a);
            this.f3300i.notify(Integer.valueOf(application.nodeId).intValue(), a);
            if (this.f3294c.containsKey(Integer.valueOf(application.nodeId))) {
                C1922m.m5797b("AppDownloder", "Already enqueued, ignoring new request.");
                stopSelf(i2);
            } else {
                this.f3294c.put(Integer.valueOf(application.nodeId), new C1893b(application, booleanExtra, this, new C1857a(this, application)));
                Message obtainMessage = this.f3299h.obtainMessage();
                obtainMessage.arg1 = i2;
                obtainMessage.arg2 = Integer.valueOf(application.nodeId).intValue();
                this.f3301j = obtainMessage.replyTo;
                this.f3299h.sendMessage(obtainMessage);
            }
        }
        return 3;
    }

    private void m5534a(Application application, boolean z) {
        C1922m.m5797b("AppDownloder", "onDownloadFinished " + String.valueOf(application.nodeId));
        this.f3294c.remove(Integer.valueOf(application.nodeId));
        if (z) {
            C1827a.m5495a((Context) this, application.bundleId);
        }
        SAM.f2614g.m5609a(application, C1878k.SUCCESS, new C1858b(this));
        if (C1922m.m5794a(application.obbFiles)) {
            C1922m.m5797b("AppDownloder", "App doesn't have Obb files");
            m5546c(Integer.valueOf(application.nodeId).intValue());
            m5530a(application);
            return;
        }
        C1922m.m5797b("AppDownloder", "Adding obb progress downloader to hashmap");
        this.f3296e.put(Integer.valueOf(application.nodeId), new C1902o());
        for (int i = 0; i < application.obbFiles.size() && this.f3296e.containsKey(Integer.valueOf(application.nodeId)); i++) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL((String) application.obbFiles.get(i)).openConnection();
                httpURLConnection.setInstanceFollowRedirects(false);
                m5532a(application, httpURLConnection.getHeaderField("Location"), i);
            } catch (Exception e) {
                m5533a(application, application.localFilePath, false);
                C1922m.m5790a(e);
            }
        }
    }

    private void m5532a(Application application, String str, int i) {
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        C1922m.m5797b("AppDownloder", "Downloading obb " + lastPathSegment);
        String str2 = application.nodeId + (lastPathSegment.startsWith("main") ? "_main" : "_patch");
        C1901n c1901n = new C1901n(application, getApplicationContext(), str);
        c1901n.m5706a(new C1859c(this, application, i, str2, c1901n));
        this.f3295d.put(str2, c1901n);
        C1922m.m5797b("AppDownloder", "Starting " + str2 + " obb downloader");
        c1901n.m5707c();
        C1922m.m5797b("AppDownloder", "Finished " + str2 + " obb downloader");
    }

    private void m5530a(Application application) {
        C1922m.m5797b("AppDownloder", "launchOrInstall" + String.valueOf(application.nodeId));
        Intent intent = new Intent(this, LaunchOrInstallService.class);
        C1915f.m5769a(intent, "com.slideme.sam.manager.EXTRA_APPLICATION", (Parcelable) application);
        startService(intent);
        this.f3300i.notify(Integer.valueOf(application.nodeId).intValue(), C1704f.m5072a((Context) this, application));
        m5543a(false);
        C1922m.m5797b("AppDownloder", "Removing obbDownloaders and obbProgress");
    }

    private void m5533a(Application application, String str, boolean z) {
        C1922m.m5797b("AppDownloder", "onDownloadError" + String.valueOf(application.nodeId));
        this.f3300i.notify(Integer.valueOf(application.nodeId).intValue(), C1704f.m5077b(this, application, z));
        SAM.f2614g.m5609a(application, C1878k.FAILED, new C1600v());
        LaunchOrInstallService.m5562a(str);
        m5543a(false);
        m5546c(Integer.valueOf(application.nodeId).intValue());
    }

    private void m5531a(Application application, String str) {
        C1922m.m5797b("AppDownloder", "onDownloadCancelled" + String.valueOf(application.nodeId));
        this.f3300i.cancel(Integer.valueOf(application.nodeId).intValue());
        SAM.f2614g.m5609a(application, C1878k.CANCELLED, new C1600v());
        LaunchOrInstallService.m5562a(str);
        m5543a(false);
        m5546c(Integer.valueOf(application.nodeId).intValue());
    }

    private void m5546c(int i) {
        C1922m.m5797b("AppDownloder", "informEnd " + String.valueOf(i));
        C1922m.m5797b("AppDownloder", "Removing downloader");
        this.f3294c.remove(Integer.valueOf(i));
        this.f3297f.remove(Integer.valueOf(i));
        this.f3296e.remove(Integer.valueOf(i));
        this.f3295d.remove(String.valueOf(i) + "_main");
        this.f3295d.remove(String.valueOf(i) + "_patch");
        Intent intent = new Intent("com.slideme.sam.manager.ACTION_DOWNLOAD_END");
        intent.putExtra("com.slideme.sam.manager.EXTRA_APP_NID", i);
        C0090q.m145a((Context) this).m150a(intent);
        if (this.f3294c.isEmpty() && this.f3295d.isEmpty()) {
            C1922m.m5797b("AppDownloder", "Empty queue.. stopping");
            this.f3301j = null;
            stopSelf();
        }
    }

    public void m5549a(int i) {
        C1922m.m5797b("AppDownloder", "stopDownloading " + String.valueOf(i));
        if (this.f3294c.containsKey(Integer.valueOf(i)) || this.f3295d.containsKey(String.valueOf(i) + "_main") || this.f3295d.containsKey(String.valueOf(i) + "_patch")) {
            C1893b c1893b = (C1893b) this.f3294c.get(Integer.valueOf(i));
            if (c1893b != null) {
                C1922m.m5797b("AppDownloder", "appDownloader cancel");
                c1893b.m5710f();
            }
            C1901n c1901n = (C1901n) this.f3295d.get(String.valueOf(i) + "_main");
            if (c1901n != null) {
                C1922m.m5797b("AppDownloder", "main obb cancel");
                c1901n.m5710f();
            }
            c1901n = (C1901n) this.f3295d.get(String.valueOf(i) + "_patch");
            if (c1901n != null) {
                C1922m.m5797b("AppDownloder", "patch obb cancel");
                c1901n.m5710f();
            }
            m5546c(i);
        }
    }

    public boolean m5552b(int i) {
        return this.f3294c.containsKey(Integer.valueOf(i)) || this.f3295d.containsKey(Integer.valueOf(i)) || this.f3295d.containsKey(String.valueOf(i) + "_main") || this.f3295d.containsKey(String.valueOf(i) + "_patch");
    }

    public int[] m5551a(int i, int[] iArr) {
        C1893b c1893b = (C1893b) this.f3294c.get(Integer.valueOf(i));
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        if (c1893b != null) {
            iArr[0] = c1893b.m5708d();
            iArr[1] = c1893b.m5709e();
            iArr[2] = 1;
            iArr[3] = c1893b.mo4318a().obbFiles.size() + 1;
        } else {
            C1902o c1902o = (C1902o) this.f3296e.get(Integer.valueOf(i));
            if (c1902o != null) {
                iArr[0] = c1902o.f3480b;
                iArr[1] = c1902o.f3479a;
                iArr[2] = c1902o.f3481c;
                iArr[3] = c1902o.f3482d;
            }
        }
        return iArr;
    }

    protected boolean m5550a(String str) {
        try {
            if (getApplicationContext().getPackageManager().getPackageArchiveInfo(str, 1) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
