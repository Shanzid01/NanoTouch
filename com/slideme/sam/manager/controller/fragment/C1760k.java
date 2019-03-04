package com.slideme.sam.manager.controller.fragment;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* compiled from: ApplicationDetailsFragment */
class C1760k implements ServiceConnection {
    final /* synthetic */ C1735a f3136a;

    C1760k(C1735a c1735a) {
        this.f3136a = c1735a;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f3136a.f2996h = null;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3136a.f2996h = new Messenger(iBinder);
        if (this.f3136a.f2989a != null && this.f3136a.f2989a.app != null && this.f3136a.f2996h != null) {
            try {
                Message obtain = Message.obtain(null, 2001);
                obtain.arg1 = Integer.valueOf(this.f3136a.f2989a.app.nodeId).intValue();
                obtain.replyTo = this.f3136a.f2997i;
                this.f3136a.f2996h.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }
}
