package com.slideme.sam.manager.controller.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import com.slideme.sam.manager.R;

/* compiled from: ApplicationDetailsFragment */
class C1750b extends BroadcastReceiver {
    final /* synthetic */ C1735a f3105a;

    C1750b(C1735a c1735a) {
        this.f3105a = c1735a;
    }

    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("com.slideme.sam.manager.EXTRA_APP_NID", -1);
        if (intExtra != -1 && this.f3105a.f2989a != null && this.f3105a.f2989a.app != null && Integer.valueOf(this.f3105a.f2989a.app.nodeId).intValue() == intExtra) {
            if ("com.slideme.sam.manager.ACTION_DOWNLOAD_END".equals(intent.getAction())) {
                this.f3105a.f2995g = false;
                this.f3105a.m5202m();
            } else if ("com.slideme.sam.manager.ACTION_DOWNLOAD_RESTART".equals(intent.getAction()) && this.f3105a.f2996h != null) {
                try {
                    Message obtain = Message.obtain(null, 2001);
                    obtain.arg1 = Integer.valueOf(this.f3105a.f2989a.app.nodeId).intValue();
                    obtain.replyTo = this.f3105a.f2997i;
                    this.f3105a.f2996h.send(obtain);
                } catch (RemoteException e) {
                }
            } else if (intent.getAction().equals("com.slideme.sam.manager.ACTION_SILENT_INSTALL_START")) {
                this.f3105a.m5200l();
                this.f3105a.f3014z.setText(this.f3105a.getString(R.string.installing));
                this.f3105a.f3012x.setIndeterminate(true);
                this.f3105a.f3013y.setVisibility(4);
            } else if (intent.getAction().equals("com.slideme.sam.manager.ACTION_SILENT_INSTALL_STOP")) {
                this.f3105a.f3012x.setIndeterminate(false);
                this.f3105a.f3013y.setVisibility(0);
                this.f3105a.f2995g = false;
                this.f3105a.m5202m();
            }
        }
    }
}
