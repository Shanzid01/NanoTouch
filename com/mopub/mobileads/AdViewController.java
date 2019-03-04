package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.C1508p;
import com.mopub.common.C1510r;
import com.mopub.common.C1515w;
import com.mopub.common.C1516x;
import com.mopub.common.p050b.C1481d;
import com.mopub.common.p050b.C1486i;
import com.mopub.mobileads.p051a.C1522b;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.http.HttpResponse;

public class AdViewController {
    private static final LayoutParams f2257a = new LayoutParams(-2, -2, 17);
    private static WeakHashMap<View, Boolean> f2258b = new WeakHashMap();
    private final Context f2259c;
    private C1510r f2260d;
    private MoPubView f2261e;
    private final WebViewAdUrlGenerator f2262f;
    private AdFetcher f2263g;
    private AdConfiguration f2264h;
    private final Runnable f2265i;
    private boolean f2266j;
    private Handler f2267k;
    private boolean f2268l;
    private String f2269m;
    private Map<String, Object> f2270n = new HashMap();
    private boolean f2271o = true;
    private boolean f2272p = true;
    private String f2273q;
    private Location f2274r;
    private C1516x f2275s = C1516x.NORMAL;
    private int f2276t = 6;
    private boolean f2277u = true;
    private boolean f2278v;
    private boolean f2279w;

    protected static void m4231a(View view) {
        f2258b.put(view, Boolean.valueOf(true));
    }

    private static boolean m4232c(View view) {
        return f2258b.get(view) != null;
    }

    public AdViewController(Context context, MoPubView moPubView) {
        this.f2259c = context;
        this.f2261e = moPubView;
        this.f2262f = new WebViewAdUrlGenerator(context);
        this.f2264h = new AdConfiguration(this.f2259c);
        this.f2263g = C1522b.m4475a(this, this.f2264h.m4204q());
        this.f2260d = new C1542k(this);
        C1508p.m4147e(this.f2259c);
        this.f2265i = new C1538g(this);
        this.f2267k = new Handler();
    }

    public MoPubView m4238a() {
        return this.f2261e;
    }

    public void m4244b() {
        this.f2279w = true;
        if (this.f2264h.m4187b() == null) {
            Log.d("MoPub", "Can't load an ad in this ad view because the ad unit ID is null. Did you forget to call setAdUnitId()?");
        } else if (m4237y()) {
            if (this.f2274r == null) {
                this.f2274r = C1515w.m4156a(this.f2259c, this.f2276t, this.f2275s);
            }
            C1508p.m4139a(this.f2259c, this.f2260d);
        } else {
            Log.d("MoPub", "Can't load an ad because there is no network connectivity.");
            m4272u();
        }
    }

    void m4241a(String str) {
        if (str != null) {
            Log.d("MoPub", "Loading url: " + str);
            if (!this.f2268l) {
                this.f2269m = str;
                this.f2264h.m4190c(null);
                this.f2268l = true;
                m4255d(this.f2269m);
            } else if (this.f2264h.m4187b() != null) {
                Log.i("MoPub", "Already loading an ad for " + this.f2264h.m4187b() + ", wait to finish.");
            }
        }
    }

    void m4240a(MoPubErrorCode moPubErrorCode) {
        this.f2268l = false;
        Log.v("MoPub", "MoPubErrorCode: " + (moPubErrorCode == null ? "" : moPubErrorCode.toString()));
        if (this.f2264h.m4195h() != null) {
            Log.d("MoPub", "Loading failover url: " + this.f2264h.m4195h());
            m4241a(this.f2264h.m4195h());
            return;
        }
        m4247b(MoPubErrorCode.NO_FILL);
    }

    void m4250c() {
        this.f2268l = false;
    }

    public void m4248b(String str) {
        this.f2273q = str;
    }

    public void m4243a(boolean z) {
        this.f2277u = z;
    }

    public Location m4254d() {
        return this.f2274r;
    }

    public String m4256e() {
        return this.f2264h.m4187b();
    }

    public void m4252c(String str) {
        this.f2264h.m4185a(str);
    }

    public void m4239a(int i) {
        if (this.f2263g != null) {
            this.f2263g.m4223a(i);
        }
    }

    public int m4257f() {
        return this.f2264h.m4198k();
    }

    public int m4258g() {
        return this.f2264h.m4199l();
    }

    public boolean m4259h() {
        return this.f2271o;
    }

    void m4260i() {
        this.f2272p = this.f2271o;
        m4234d(false);
    }

    void m4261j() {
        m4234d(this.f2272p);
    }

    void m4249b(boolean z) {
        this.f2272p = z;
        m4234d(z);
    }

    private void m4234d(boolean z) {
        Object obj = (!this.f2279w || this.f2271o == z) ? null : 1;
        if (obj != null) {
            C1486i.m4076a("Refresh " + (z ? "enabled" : "disabled") + " for ad unit (" + (this.f2264h != null ? this.f2264h.m4187b() : null) + ").");
        }
        this.f2271o = z;
        if (this.f2279w && this.f2271o) {
            m4272u();
        } else if (!this.f2271o) {
            m4235w();
        }
    }

    public boolean m4262k() {
        return this.f2278v;
    }

    public void m4253c(boolean z) {
        this.f2278v = z;
    }

    int m4263l() {
        return this.f2276t;
    }

    void m4245b(int i) {
        this.f2276t = Math.max(0, i);
    }

    AdConfiguration m4264m() {
        return this.f2264h;
    }

    boolean m4265n() {
        return this.f2266j;
    }

    void m4266o() {
        if (!this.f2266j) {
            m4234d(false);
            m4235w();
            this.f2263g.m4225b();
            this.f2263g = null;
            this.f2264h.m4183a();
            this.f2261e = null;
            this.f2266j = true;
        }
    }

    void m4242a(HttpResponse httpResponse) {
        this.f2264h.m4186a(httpResponse);
    }

    Integer m4267p() {
        return this.f2264h.m4200m();
    }

    int m4268q() {
        return this.f2264h.m4201n();
    }

    @Deprecated
    void m4251c(int i) {
        this.f2264h.m4184a(i);
    }

    void m4269r() {
        new Thread(new C1539h(this)).start();
    }

    void m4270s() {
        new Thread(new C1540i(this)).start();
    }

    void m4255d(String str) {
        if (this.f2263g != null) {
            this.f2263g.m4224a(str);
        }
    }

    String m4271t() {
        return this.f2262f.m4029a(this.f2264h.m4187b()).m4034b(this.f2273q).m4030a(this.f2277u).m4028a(this.f2274r).mo4136k(m4236x());
    }

    void m4247b(MoPubErrorCode moPubErrorCode) {
        Log.i("MoPub", "Ad failed to load.");
        m4250c();
        m4272u();
        m4238a().mo4113a(moPubErrorCode);
    }

    void m4272u() {
        m4235w();
        if (this.f2271o && this.f2264h.m4201n() > 0) {
            this.f2267k.postDelayed(this.f2265i, (long) this.f2264h.m4201n());
        }
    }

    Map<String, Object> m4273v() {
        if (this.f2270n != null) {
            return new HashMap(this.f2270n);
        }
        return new HashMap();
    }

    private void m4235w() {
        this.f2267k.removeCallbacks(this.f2265i);
    }

    private String m4236x() {
        return this.f2278v ? "testing.ads.mopub.com" : "ads.mopub.com";
    }

    private boolean m4237y() {
        if (this.f2259c.checkCallingPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f2259c.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    void m4246b(View view) {
        this.f2267k.post(new C1541j(this, view));
    }

    private LayoutParams m4233d(View view) {
        int k = this.f2264h.m4198k();
        int l = this.f2264h.m4199l();
        if (!m4232c(view) || k <= 0 || l <= 0) {
            return f2257a;
        }
        return new LayoutParams(C1481d.m4060d((float) k, this.f2259c), C1481d.m4060d((float) l, this.f2259c), 17);
    }
}
