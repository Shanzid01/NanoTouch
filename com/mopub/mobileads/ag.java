package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: MoPubView */
class ag extends BroadcastReceiver {
    final /* synthetic */ MoPubView f2406a;

    ag(MoPubView moPubView) {
        this.f2406a = moPubView;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f2406a.f2331e && intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                this.f2406a.setAdVisibility(true);
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                this.f2406a.setAdVisibility(false);
            }
        }
    }
}
