package com.slideme.sam.manager;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.C0090q;

/* compiled from: SAM */
class C1609c extends Handler {
    final /* synthetic */ SAM f2670a;

    C1609c(SAM sam) {
        this.f2670a = sam;
    }

    public void handleMessage(Message message) {
        Intent intent = new Intent();
        intent.putExtra("com.slideme.sam.manager.EXTRA_APP_NID", message.arg2);
        switch (message.what) {
            case 1000:
                intent.setAction("com.slideme.sam.manager.ACTION_DOWNLOAD_RESTART");
                C0090q.m145a(this.f2670a).m150a(intent);
                return;
            case 1001:
                intent.setAction("com.slideme.sam.manager.ACTION_DOWNLOAD_END");
                C0090q.m145a(this.f2670a).m150a(intent);
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
