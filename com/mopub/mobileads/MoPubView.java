package com.mopub.mobileads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import com.mopub.common.C1516x;
import com.mopub.common.p050b.C1485h;
import com.mopub.common.p050b.C1489l;
import com.mopub.mobileads.p051a.C1523c;
import com.mopub.mobileads.p051a.C1524d;
import java.util.Collections;
import java.util.Map;

public class MoPubView extends FrameLayout {
    private Context f2327a;
    protected AdViewController f2328b;
    protected CustomEventBannerAdapter f2329c;
    private BroadcastReceiver f2330d;
    private boolean f2331e;
    private C1516x f2332f;
    private BannerAdListener f2333g;
    private OnAdLoadedListener f2334h;
    private OnAdFailedListener f2335i;
    private OnAdPresentedOverlayListener f2336j;
    private OnAdClosedListener f2337k;
    private OnAdClickedListener f2338l;

    public interface BannerAdListener {
        void onBannerClicked(MoPubView moPubView);

        void onBannerCollapsed(MoPubView moPubView);

        void onBannerExpanded(MoPubView moPubView);

        void onBannerFailed(MoPubView moPubView, MoPubErrorCode moPubErrorCode);

        void onBannerLoaded(MoPubView moPubView);
    }

    @Deprecated
    public interface OnAdClickedListener {
        void OnAdClicked(MoPubView moPubView);
    }

    @Deprecated
    public interface OnAdClosedListener {
        void OnAdClosed(MoPubView moPubView);
    }

    @Deprecated
    public interface OnAdFailedListener {
        void OnAdFailed(MoPubView moPubView);
    }

    @Deprecated
    public interface OnAdLoadedListener {
        void OnAdLoaded(MoPubView moPubView);
    }

    @Deprecated
    public interface OnAdPresentedOverlayListener {
        void OnAdPresentedOverlay(MoPubView moPubView);
    }

    @Deprecated
    public interface OnAdWillLoadListener {
        void OnAdWillLoad(MoPubView moPubView, String str);
    }

    public MoPubView(Context context) {
        this(context, null);
    }

    public MoPubView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C1485h.m4071a(context);
        this.f2327a = context;
        this.f2331e = getVisibility() == 0;
        this.f2332f = C1516x.NORMAL;
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (WebViewDatabase.getInstance(context) == null) {
            Log.e("MoPub", "Disabling MoPub. Local cache file is inaccessible so MoPub will fail if we try to create a WebView. Details of this Android bug found at:http://code.google.com/p/android/issues/detail?id=10789");
            return;
        }
        this.f2328b = C1523c.m4477a(context, this);
        mo4112a();
    }

    private void mo4112a() {
        this.f2330d = new ag(this);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f2327a.registerReceiver(this.f2330d, intentFilter);
    }

    private void m4340p() {
        try {
            this.f2327a.unregisterReceiver(this.f2330d);
        } catch (Exception e) {
            Log.d("MoPub", "Failed to unregister screen state broadcast receiver (never registered).");
        }
    }

    public void m4346b() {
        if (this.f2328b != null) {
            this.f2328b.m4244b();
        }
    }

    public void m4349c() {
        m4340p();
        removeAllViews();
        if (this.f2328b != null) {
            this.f2328b.m4266o();
            this.f2328b = null;
        }
        if (this.f2329c != null) {
            this.f2329c.m4299b();
            this.f2329c = null;
        }
    }

    Integer m4350d() {
        return this.f2328b != null ? this.f2328b.m4267p() : null;
    }

    protected void m4347b(MoPubErrorCode moPubErrorCode) {
        if (this.f2328b != null) {
            this.f2328b.m4240a(moPubErrorCode);
        }
    }

    protected void mo4114a(Map<String, String> map) {
        if (map == null) {
            Log.d("MoPub", "Couldn't invoke custom event because the server did not specify one.");
            m4347b(MoPubErrorCode.ADAPTER_NOT_FOUND);
            return;
        }
        if (this.f2329c != null) {
            this.f2329c.m4299b();
        }
        Log.d("MoPub", "Loading custom event adapter.");
        this.f2329c = C1524d.m4479a(this, (String) map.get(C1489l.CUSTOM_EVENT_NAME.getKey()), (String) map.get(C1489l.CUSTOM_EVENT_DATA.getKey()));
        this.f2329c.m4298a();
    }

    protected void m4351e() {
        if (this.f2328b != null) {
            this.f2328b.m4270s();
            m4356j();
        }
    }

    protected void m4352f() {
        Log.d("MoPub", "Tracking impression for native adapter.");
        if (this.f2328b != null) {
            this.f2328b.m4269r();
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        boolean z = i == 0;
        this.f2331e = z;
        setAdVisibility(z);
    }

    private void setAdVisibility(boolean z) {
        if (this.f2328b != null) {
            if (z) {
                this.f2328b.m4261j();
            } else {
                this.f2328b.m4260i();
            }
        }
    }

    protected void m4353g() {
        Log.d("MoPub", "adLoaded");
        if (this.f2333g != null) {
            this.f2333g.onBannerLoaded(this);
        } else if (this.f2334h != null) {
            this.f2334h.OnAdLoaded(this);
        }
    }

    protected void mo4113a(MoPubErrorCode moPubErrorCode) {
        if (this.f2333g != null) {
            this.f2333g.onBannerFailed(this, moPubErrorCode);
        } else if (this.f2335i != null) {
            this.f2335i.OnAdFailed(this);
        }
    }

    protected void m4354h() {
        if (this.f2333g != null) {
            this.f2333g.onBannerExpanded(this);
        } else if (this.f2336j != null) {
            this.f2336j.OnAdPresentedOverlay(this);
        }
    }

    protected void m4355i() {
        if (this.f2333g != null) {
            this.f2333g.onBannerCollapsed(this);
        } else if (this.f2337k != null) {
            this.f2337k.OnAdClosed(this);
        }
    }

    protected void m4356j() {
        if (this.f2333g != null) {
            this.f2333g.onBannerClicked(this);
        } else if (this.f2338l != null) {
            this.f2338l.OnAdClicked(this);
        }
    }

    protected void m4357k() {
        if (this.f2328b != null) {
            this.f2328b.m4272u();
        }
        m4353g();
    }

    public void m4344a(String str) {
        if (this.f2328b != null) {
            this.f2328b.m4252c(str);
        }
    }

    public void m4348b(String str) {
        if (this.f2328b != null) {
            this.f2328b.m4248b(str);
        }
    }

    public void setFacebookSupported(boolean z) {
        if (this.f2328b != null) {
            this.f2328b.m4243a(z);
        }
    }

    public Location m4358l() {
        return this.f2328b != null ? this.f2328b.m4254d() : null;
    }

    public void setTimeout(int i) {
        if (this.f2328b != null) {
            this.f2328b.m4239a(i);
        }
    }

    public int getAdWidth() {
        return this.f2328b != null ? this.f2328b.m4257f() : 0;
    }

    public int getAdHeight() {
        return this.f2328b != null ? this.f2328b.m4258g() : 0;
    }

    public Activity m4359m() {
        return (Activity) this.f2327a;
    }

    public void m4343a(BannerAdListener bannerAdListener) {
        this.f2333g = bannerAdListener;
    }

    public void setLocationPrecision(int i) {
        if (this.f2328b != null) {
            this.f2328b.m4245b(i);
        }
    }

    public int getLocationPrecision() {
        return this.f2328b != null ? this.f2328b.m4263l() : 0;
    }

    public Map<String, Object> m4360n() {
        if (this.f2328b != null) {
            return this.f2328b.m4273v();
        }
        return Collections.emptyMap();
    }

    public void setAutorefreshEnabled(boolean z) {
        if (this.f2328b != null) {
            this.f2328b.m4249b(z);
        }
    }

    public boolean getAutorefreshEnabled() {
        if (this.f2328b != null) {
            return this.f2328b.m4259h();
        }
        Log.d("MoPub", "Can't get autorefresh status for destroyed MoPubView. Returning false.");
        return false;
    }

    public void m4341a(View view) {
        if (this.f2328b != null) {
            this.f2328b.m4246b(view);
        }
    }

    public void setTesting(boolean z) {
        if (this.f2328b != null) {
            this.f2328b.m4253c(z);
        }
    }

    public boolean getTesting() {
        if (this.f2328b != null) {
            return this.f2328b.m4262k();
        }
        Log.d("MoPub", "Can't get testing status for destroyed MoPubView. Returning false.");
        return false;
    }

    AdViewController m4361o() {
        return this.f2328b;
    }
}
