package com.slideme.sam.manager.model.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.google.android.gms.games.GamesStatusCodes;
import java.lang.ref.WeakReference;

/* compiled from: ApplicationDownloadService */
class C1860d extends Handler {
    final /* synthetic */ ApplicationDownloadService f3318a;
    private final WeakReference<ApplicationDownloadService> f3319b;

    public C1860d(ApplicationDownloadService applicationDownloadService, ApplicationDownloadService applicationDownloadService2) {
        this.f3318a = applicationDownloadService;
        this.f3319b = new WeakReference(applicationDownloadService2);
    }

    public void handleMessage(Message message) {
        Messenger messenger;
        Bundle bundle;
        Message obtain;
        switch (message.what) {
            case 2000:
                try {
                    messenger = message.replyTo;
                    bundle = new Bundle();
                    bundle.putIntArray("KEY_PROGRESS", ((ApplicationDownloadService) this.f3319b.get()).m5551a(message.arg1, new int[4]));
                    obtain = Message.obtain(null, 2000);
                    obtain.setData(bundle);
                    messenger.send(obtain);
                    return;
                } catch (RemoteException e) {
                    return;
                }
            case 2001:
                try {
                    messenger = message.replyTo;
                    bundle = new Bundle();
                    bundle.putBoolean("KEY_IS_DOWNLOADING", ((ApplicationDownloadService) this.f3319b.get()).m5552b(message.arg1));
                    obtain = Message.obtain(null, 2001);
                    obtain.setData(bundle);
                    messenger.send(obtain);
                    return;
                } catch (RemoteException e2) {
                    return;
                }
            case GamesStatusCodes.STATUS_ACHIEVEMENT_UNLOCK_FAILURE /*3000*/:
                ((ApplicationDownloadService) this.f3319b.get()).m5549a(message.arg1);
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
