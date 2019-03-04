package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.mopub.common.p050b.C1484g;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.p051a.C1527g;
import java.util.HashMap;
import java.util.Map;

public class CustomEventInterstitialAdapter implements CustomEventInterstitialListener {
    private final MoPubInterstitial f2296a;
    private boolean f2297b;
    private CustomEventInterstitialAdapterListener f2298c;
    private CustomEventInterstitial f2299d;
    private Context f2300e;
    private Map<String, Object> f2301f;
    private Map<String, String> f2302g;
    private final Handler f2303h = new Handler();
    private final Runnable f2304i;

    interface CustomEventInterstitialAdapterListener {
        void onCustomEventInterstitialClicked();

        void onCustomEventInterstitialDismissed();

        void onCustomEventInterstitialFailed(MoPubErrorCode moPubErrorCode);

        void onCustomEventInterstitialLoaded();

        void onCustomEventInterstitialShown();
    }

    public CustomEventInterstitialAdapter(MoPubInterstitial moPubInterstitial, String str, String str2) {
        this.f2296a = moPubInterstitial;
        this.f2302g = new HashMap();
        this.f2301f = new HashMap();
        this.f2300e = moPubInterstitial.m4371d();
        this.f2304i = new C1547r(this);
        Log.d("MoPub", "Attempting to invoke custom event: " + str);
        try {
            this.f2299d = C1527g.m4485a(str);
        } catch (Exception e) {
            Log.d("MoPub", "Couldn't locate or instantiate custom event: " + str + ".");
            if (this.f2298c != null) {
                this.f2298c.onCustomEventInterstitialFailed(MoPubErrorCode.ADAPTER_NOT_FOUND);
            }
        }
        try {
            this.f2302g = C1484g.m4070a(str2);
        } catch (Exception e2) {
            Log.d("MoPub", "Failed to create Map from JSON: " + str2);
        }
        this.f2301f = moPubInterstitial.m4373f();
        if (moPubInterstitial.m4372e() != null) {
            this.f2301f.put("location", moPubInterstitial.m4372e());
        }
        AdViewController o = moPubInterstitial.m4370c().m4361o();
        if (o != null) {
            this.f2301f.put("Ad-Configuration", o.m4264m());
        }
    }

    void m4305a() {
        if (!m4308c() && this.f2299d != null) {
            if (m4304e() > 0) {
                this.f2303h.postDelayed(this.f2304i, (long) m4304e());
            }
            this.f2299d.mo4105a(this.f2300e, this, this.f2301f, this.f2302g);
        }
    }

    void m4307b() {
        if (this.f2299d != null) {
            this.f2299d.mo4104a();
        }
        this.f2299d = null;
        this.f2300e = null;
        this.f2302g = null;
        this.f2301f = null;
        this.f2298c = null;
        this.f2297b = true;
    }

    boolean m4308c() {
        return this.f2297b;
    }

    void m4306a(CustomEventInterstitialAdapterListener customEventInterstitialAdapterListener) {
        this.f2298c = customEventInterstitialAdapterListener;
    }

    private void m4303d() {
        this.f2303h.removeCallbacks(this.f2304i);
    }

    private int m4304e() {
        if (this.f2296a == null || this.f2296a.m4369b() == null || this.f2296a.m4369b().intValue() < 0) {
            return 30000;
        }
        return this.f2296a.m4369b().intValue() * 1000;
    }

    public void onInterstitialLoaded() {
        if (!m4308c()) {
            m4303d();
            if (this.f2298c != null) {
                this.f2298c.onCustomEventInterstitialLoaded();
            }
        }
    }

    public void onInterstitialFailed(MoPubErrorCode moPubErrorCode) {
        if (!m4308c() && this.f2298c != null) {
            if (moPubErrorCode == null) {
                moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
            }
            m4303d();
            this.f2298c.onCustomEventInterstitialFailed(moPubErrorCode);
        }
    }

    public void onInterstitialShown() {
        if (!m4308c() && this.f2298c != null) {
            this.f2298c.onCustomEventInterstitialShown();
        }
    }

    public void onInterstitialClicked() {
        if (!m4308c() && this.f2298c != null) {
            this.f2298c.onCustomEventInterstitialClicked();
        }
    }

    public void onLeaveApplication() {
        onInterstitialClicked();
    }

    public void onInterstitialDismissed() {
        if (!m4308c() && this.f2298c != null) {
            this.f2298c.onCustomEventInterstitialDismissed();
        }
    }
}
