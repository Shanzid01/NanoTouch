package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import com.mopub.common.p050b.C1484g;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.mopub.mobileads.p051a.C1525e;
import java.util.HashMap;
import java.util.Map;

public class CustomEventBannerAdapter implements CustomEventBannerListener {
    private boolean f2287a;
    private MoPubView f2288b;
    private Context f2289c;
    private CustomEventBanner f2290d;
    private Map<String, Object> f2291e;
    private Map<String, String> f2292f;
    private final Handler f2293g = new Handler();
    private final Runnable f2294h;
    private boolean f2295i;

    public CustomEventBannerAdapter(MoPubView moPubView, String str, String str2) {
        this.f2288b = moPubView;
        this.f2289c = moPubView.getContext();
        this.f2291e = new HashMap();
        this.f2292f = new HashMap();
        this.f2294h = new C1546q(this);
        Log.d("MoPub", "Attempting to invoke custom event: " + str);
        try {
            this.f2290d = C1525e.m4481a(str);
            try {
                this.f2292f = C1484g.m4070a(str2);
            } catch (Exception e) {
                Log.d("MoPub", "Failed to create Map from JSON: " + str2 + e.toString());
            }
            this.f2291e = this.f2288b.m4360n();
            if (this.f2288b.m4358l() != null) {
                this.f2291e.put("location", this.f2288b.m4358l());
            }
            if (this.f2288b.m4361o() != null) {
                this.f2291e.put("Ad-Configuration", this.f2288b.m4361o().m4264m());
            }
        } catch (Exception e2) {
            Log.d("MoPub", "Couldn't locate or instantiate custom event: " + str + ".");
            this.f2288b.m4347b(MoPubErrorCode.ADAPTER_NOT_FOUND);
        }
    }

    void m4298a() {
        if (!m4300c() && this.f2290d != null) {
            if (m4297e() > 0) {
                this.f2293g.postDelayed(this.f2294h, (long) m4297e());
            }
            this.f2290d.mo4103a(this.f2289c, this, this.f2291e, this.f2292f);
        }
    }

    void m4299b() {
        if (this.f2290d != null) {
            this.f2290d.mo4102a();
        }
        this.f2289c = null;
        this.f2290d = null;
        this.f2291e = null;
        this.f2292f = null;
        this.f2287a = true;
    }

    boolean m4300c() {
        return this.f2287a;
    }

    private void m4296d() {
        this.f2293g.removeCallbacks(this.f2294h);
    }

    private int m4297e() {
        if (this.f2288b == null || this.f2288b.m4350d() == null || this.f2288b.m4350d().intValue() < 0) {
            return 10000;
        }
        return this.f2288b.m4350d().intValue() * 1000;
    }

    public void onBannerLoaded(View view) {
        if (!m4300c()) {
            m4296d();
            if (this.f2288b != null) {
                this.f2288b.m4357k();
                this.f2288b.m4341a(view);
                if (!(view instanceof HtmlBannerWebView)) {
                    this.f2288b.m4352f();
                }
            }
        }
    }

    public void onBannerFailed(MoPubErrorCode moPubErrorCode) {
        if (!m4300c() && this.f2288b != null) {
            if (moPubErrorCode == null) {
                moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
            }
            m4296d();
            this.f2288b.m4347b(moPubErrorCode);
        }
    }

    public void onBannerExpanded() {
        if (!m4300c()) {
            this.f2295i = this.f2288b.getAutorefreshEnabled();
            this.f2288b.setAutorefreshEnabled(false);
            this.f2288b.m4354h();
        }
    }

    public void onBannerCollapsed() {
        if (!m4300c()) {
            this.f2288b.setAutorefreshEnabled(this.f2295i);
            this.f2288b.m4355i();
        }
    }

    public void onBannerClicked() {
        if (!m4300c() && this.f2288b != null) {
            this.f2288b.m4351e();
        }
    }

    public void onLeaveApplication() {
        onBannerClicked();
    }
}
