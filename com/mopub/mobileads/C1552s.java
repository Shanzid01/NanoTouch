package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.C0090q;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

/* compiled from: EventForwardingBroadcastReceiver */
class C1552s extends BroadcastReceiver {
    private static IntentFilter f2540d;
    private final CustomEventInterstitialListener f2541a;
    private final long f2542b;
    private Context f2543c;

    public C1552s(CustomEventInterstitialListener customEventInterstitialListener, long j) {
        this.f2541a = customEventInterstitialListener;
        this.f2542b = j;
        f2540d = C1552s.m4653a();
    }

    static void m4654a(Context context, long j, String str) {
        Intent intent = new Intent(str);
        intent.putExtra("broadcastIdentifier", j);
        C0090q.m145a(context.getApplicationContext()).m150a(intent);
    }

    static IntentFilter m4653a() {
        if (f2540d == null) {
            f2540d = new IntentFilter();
            f2540d.addAction("com.mopub.action.interstitial.fail");
            f2540d.addAction("com.mopub.action.interstitial.show");
            f2540d.addAction("com.mopub.action.interstitial.dismiss");
            f2540d.addAction("com.mopub.action.interstitial.click");
        }
        return f2540d;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f2541a != null) {
            if (this.f2542b == intent.getLongExtra("broadcastIdentifier", -1)) {
                String action = intent.getAction();
                if ("com.mopub.action.interstitial.fail".equals(action)) {
                    this.f2541a.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
                } else if ("com.mopub.action.interstitial.show".equals(action)) {
                    this.f2541a.onInterstitialShown();
                } else if ("com.mopub.action.interstitial.dismiss".equals(action)) {
                    this.f2541a.onInterstitialDismissed();
                    m4656b();
                } else if ("com.mopub.action.interstitial.click".equals(action)) {
                    this.f2541a.onInterstitialClicked();
                }
            }
        }
    }

    public void m4655a(Context context) {
        this.f2543c = context;
        C0090q.m145a(this.f2543c).m149a(this, f2540d);
    }

    public void m4656b() {
        if (this.f2543c != null) {
            C0090q.m145a(this.f2543c).m148a((BroadcastReceiver) this);
            this.f2543c = null;
        }
    }
}
