package com.mopub.mobileads;

import android.content.Context;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;

/* compiled from: ResponseBodyInterstitial */
abstract class bx extends CustomEventInterstitial {
    protected Context f2307a;
    protected AdConfiguration f2308b;
    long f2309c;
    private C1552s f2310d;

    protected abstract void mo4106a(CustomEventInterstitialListener customEventInterstitialListener);

    protected abstract void mo4107a(Map<String, String> map);

    bx() {
    }

    protected void mo4105a(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2) {
        this.f2307a = context;
        if (m4313b(map2)) {
            mo4107a((Map) map2);
            this.f2308b = AdConfiguration.m4181a((Map) map);
            if (this.f2308b != null) {
                this.f2309c = this.f2308b.m4191d();
            }
            this.f2310d = new C1552s(customEventInterstitialListener, this.f2309c);
            this.f2310d.m4655a(context);
            mo4106a(customEventInterstitialListener);
            return;
        }
        customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
    }

    protected void mo4104a() {
        if (this.f2310d != null) {
            this.f2310d.m4656b();
        }
    }

    private boolean m4313b(Map<String, String> map) {
        return map.containsKey("Html-Response-Body");
    }
}
