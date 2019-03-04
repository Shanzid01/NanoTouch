package com.mopub.mobileads;

import android.app.Activity;
import android.location.Location;
import android.util.Log;
import com.mopub.common.p050b.C1489l;
import com.mopub.mobileads.p051a.C1526f;
import java.util.Map;

public class MoPubInterstitial implements CustomEventInterstitialAdapterListener {
    private MoPubInterstitialView f2340a;
    private CustomEventInterstitialAdapter f2341b;
    private InterstitialAdListener f2342c;
    private Activity f2343d;
    private af f2344e;
    private boolean f2345f;
    private MoPubInterstitialListener f2346g;

    public interface InterstitialAdListener {
        void onInterstitialClicked(MoPubInterstitial moPubInterstitial);

        void onInterstitialDismissed(MoPubInterstitial moPubInterstitial);

        void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode);

        void onInterstitialLoaded(MoPubInterstitial moPubInterstitial);

        void onInterstitialShown(MoPubInterstitial moPubInterstitial);
    }

    @Deprecated
    public interface MoPubInterstitialListener {
        void OnInterstitialFailed();

        void OnInterstitialLoaded();
    }

    public class MoPubInterstitialView extends MoPubView {
        final /* synthetic */ MoPubInterstitial f2339a;

        protected void mo4114a(Map<String, String> map) {
            if (map == null) {
                Log.d("MoPub", "Couldn't invoke custom event because the server did not specify one.");
                m4347b(MoPubErrorCode.ADAPTER_NOT_FOUND);
                return;
            }
            if (this.f2339a.f2341b != null) {
                this.f2339a.f2341b.m4307b();
            }
            Log.d("MoPub", "Loading custom event interstitial adapter.");
            this.f2339a.f2341b = C1526f.m4483a(this.f2339a, (String) map.get(C1489l.CUSTOM_EVENT_NAME.getKey()), (String) map.get(C1489l.CUSTOM_EVENT_DATA.getKey()));
            this.f2339a.f2341b.m4306a(this.f2339a);
            this.f2339a.f2341b.m4305a();
        }

        protected void mo4112a() {
            Log.d("MoPub", "Tracking impression for interstitial.");
            if (this.b != null) {
                this.b.m4269r();
            }
        }

        protected void mo4113a(MoPubErrorCode moPubErrorCode) {
            if (this.f2339a.f2342c != null) {
                this.f2339a.f2342c.onInterstitialFailed(this.f2339a, moPubErrorCode);
            }
        }
    }

    boolean m4368a() {
        return this.f2345f;
    }

    Integer m4369b() {
        return this.f2340a.m4350d();
    }

    MoPubInterstitialView m4370c() {
        return this.f2340a;
    }

    public Activity m4371d() {
        return this.f2343d;
    }

    public Location m4372e() {
        return this.f2340a.m4358l();
    }

    public Map<String, Object> m4373f() {
        return this.f2340a.m4360n();
    }

    public void onCustomEventInterstitialLoaded() {
        if (!this.f2345f) {
            this.f2344e = af.CUSTOM_EVENT_AD_READY;
            if (this.f2342c != null) {
                this.f2342c.onInterstitialLoaded(this);
            } else if (this.f2346g != null) {
                this.f2346g.OnInterstitialLoaded();
            }
        }
    }

    public void onCustomEventInterstitialFailed(MoPubErrorCode moPubErrorCode) {
        if (!m4368a()) {
            this.f2344e = af.NOT_READY;
            this.f2340a.m4347b(moPubErrorCode);
        }
    }

    public void onCustomEventInterstitialShown() {
        if (!m4368a()) {
            this.f2340a.mo4112a();
            if (this.f2342c != null) {
                this.f2342c.onInterstitialShown(this);
            }
        }
    }

    public void onCustomEventInterstitialClicked() {
        if (!m4368a()) {
            this.f2340a.m4351e();
            if (this.f2342c != null) {
                this.f2342c.onInterstitialClicked(this);
            }
        }
    }

    public void onCustomEventInterstitialDismissed() {
        if (!m4368a()) {
            this.f2344e = af.NOT_READY;
            if (this.f2342c != null) {
                this.f2342c.onInterstitialDismissed(this);
            }
        }
    }
}
