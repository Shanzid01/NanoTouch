package com.slideme.sam.manager;

import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Messenger;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.support.v4.content.C0090q;
import android.text.TextUtils;
import android.util.Log;
import com.google.analytics.tracking.android.C0771n;
import com.google.analytics.tracking.android.bm;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.mopub.mobileads.MoPubConversionTracker;
import com.p019a.p020a.C0367a;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0364x;
import com.p026b.p027a.p028a.p032b.p033a.C0464c;
import com.p026b.p027a.p034b.C0510g;
import com.p026b.p027a.p034b.C0513j;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;
import com.slideme.sam.manager.controller.p053a.C1610a;
import com.slideme.sam.manager.controller.p055b.C1703e;
import com.slideme.sam.manager.controller.p055b.C1704f;
import com.slideme.sam.manager.controller.p055b.C1706h;
import com.slideme.sam.manager.model.C1823a;
import com.slideme.sam.manager.model.data.AdProxyOfferReport;
import com.slideme.sam.manager.model.data.cache.helper.InstallReferrerCache;
import com.slideme.sam.manager.model.data.cache.helper.UpdatesDatabase;
import com.slideme.sam.manager.model.data.cache.helper.data.InstallReferrerCacheObject;
import com.slideme.sam.manager.model.data.cache.helper.data.UpdatesDatabaseObject;
import com.slideme.sam.manager.model.data.dynamic.child.AdProxyChild;
import com.slideme.sam.manager.model.p054b.C1831e;
import com.slideme.sam.manager.model.p054b.C1832f;
import com.slideme.sam.manager.model.p054b.C1833h;
import com.slideme.sam.manager.model.p054b.p062a.C1826c;
import com.slideme.sam.manager.model.p061a.C1813a;
import com.slideme.sam.manager.model.p061a.C1815c;
import com.slideme.sam.manager.model.p061a.C1816d;
import com.slideme.sam.manager.model.p061a.C1817e;
import com.slideme.sam.manager.model.p061a.C1818f;
import com.slideme.sam.manager.model.service.CheckPendingInstallNotificationsAlarmReceiver;
import com.slideme.sam.manager.model.service.DeleteFileAlarmReceiver;
import com.slideme.sam.manager.model.service.LaunchOrInstallService;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.C1867a;
import com.slideme.sam.manager.net.C1878k;
import com.slideme.sam.manager.net.response.AdProxyItem;
import com.slideme.sam.manager.util.C1913d;
import com.slideme.sam.manager.util.C1914e;
import com.slideme.sam.manager.util.C1915f;
import com.slideme.sam.manager.util.C1916g;
import com.slideme.sam.manager.util.C1917h;
import com.slideme.sam.manager.util.C1922m;
import com.slideme.sam.manager.util.cache.CacheItem;
import com.slideme.sam.manager.util.cache.PreferenceCache;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import p006b.p007a.p008a.p009a.C0326f;

public class SAM extends Application {
    private static Context f2607B;
    public static String f2608a;
    public static String f2609b;
    public static String f2610c;
    public static String f2611d;
    public static String f2612e;
    public static C1817e f2613f;
    public static C1867a f2614g;
    public static C1831e f2615h;
    public static C1826c f2616i;
    public static C1833h f2617j;
    public static C1813a f2618k;
    public static C1815c f2619l;
    public static C1818f f2620m;
    public static C1816d f2621n;
    public static C1610a f2622o;
    public static InstallReferrerCache f2623p;
    public static Properties f2624q;
    public static Messenger f2625r;
    public static String f2626s;
    public static String f2627t;
    public static boolean f2628u = true;
    public static boolean f2629v = false;
    private static List<String> f2630y;
    private OnAccountsUpdateListener f2631A;
    private Hashtable<String, AdProxyChild> f2632w = new Hashtable();
    private long f2633x = 0;
    private OnSharedPreferenceChangeListener f2634z;

    public static Context m4761a() {
        return f2607B;
    }

    public void onCreate() {
        super.onCreate();
        C0326f.m2289a((Context) this, new C0367a());
        f2608a = getString(R.string.SLIDEME_SERVICES_URL);
        f2609b = getString(R.string.SLIDEME_FEEDS_URL);
        f2610c = getString(R.string.SLIDEME_PAPI_URL);
        f2611d = getString(R.string.SLIDEME_OFFERS_URL);
        f2612e = getString(R.string.ADFILL_SEVICES_URL);
        f2614g = new C1867a(this);
        f2625r = new Messenger(new C1609c(this));
        f2607B = this;
        f2629v = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("eulaAgreed", false);
        f2615h = new C1831e(this, getResources().getBoolean(R.bool.skipScreenCompatibillityCheck));
        f2617j = new C1833h(PreferenceManager.getDefaultSharedPreferences(this), getResources());
        f2622o = new C1610a(this);
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (NameNotFoundException e) {
        }
        f2624q = new C1916g(this, C1917h.META_INF).m5771a("SLIDEME.PROPERTIES");
        String str = "SAM/" + getString(R.string.sam_version_num) + "-" + m4780d() + "-r" + packageInfo.versionCode;
        f2626s = new StringBuilder(String.valueOf(str)).append(" (Linux; U; Android ").append(VERSION.RELEASE).append(")").toString();
        f2627t = " " + str;
        f2613f = new C1817e(this);
        f2620m = new C1818f(this);
        new StringBuilder("&").append("sam_version=").append(getString(R.string.sam_version_num)).append("&partner=").append(m4780d());
        C0367a.m2509e().f1149c.m2782b(C1913d.m5766c(this));
        C0367a.m2509e().f1149c.m2777a("Channel", m4780d());
        C0367a.m2509e().f1149c.m2777a("UDID(Old)", C1913d.m5768d(this));
        if (f2613f.m5445b()) {
            f2614g.m5619a("https://google.com", new C1781h(this));
        }
        f2614g.m5623a(getString(R.string.SLIDEME_CDN_URL) + "/files/trusted", new C1783i(this));
        f2619l = new C1815c(this);
        f2618k = new C1813a(this);
        f2618k.m5422b();
        f2621n = new C1816d(this);
        f2621n.m5438a();
        f2616i = new C1826c(this);
        if (TextUtils.isEmpty(getString(R.string.currency_code))) {
            f2616i.m5489a(PreferenceManager.getDefaultSharedPreferences(this).getString(getString(R.string.key_settings_currency), C1826c.m5486b()));
        } else {
            f2616i.m5489a(PreferenceManager.getDefaultSharedPreferences(this).getString(getString(R.string.key_settings_currency), getString(R.string.currency_code)));
        }
        this.f2634z = new C1808j(this);
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this.f2634z);
        this.f2631A = new C1809k(this);
        AccountManager.get(this).addOnAccountsUpdatedListener(this.f2631A, null, true);
        m4773i();
        C0771n.m3938a().m3945a((Context) this);
        bm b = C0771n.m3940b();
        b.mo1208a(1, String.valueOf(f2615h.m5512c()));
        b.mo1208a(3, C1913d.m5757a((Context) this));
        new MoPubConversionTracker().m4336a((Context) this);
        boolean z = getResources().getBoolean(R.bool.showPlayApps) && f2619l.m5431e();
        f2628u = z;
        f2623p = new InstallReferrerCache(this);
        f2620m.m5467b();
        C1706h.m5082a(this, false);
    }

    private void m4770f() {
        C0367a.m2509e().f1149c.m2784c(AuthData.m4811g(this));
        if (AuthData.m4805a((Context) this)) {
            C1914e.f3493a = true;
        }
        if (!new C1823a(this).m5476a(AuthData.m4810f(this))) {
            UpdatesDatabase updatesDatabase = new UpdatesDatabase(this);
            updatesDatabase.clear();
            updatesDatabase.close();
            f2621n.m5438a();
            C1706h.m5082a(this, true);
        }
        C1922m.m5799c(this);
        m4771g();
        m4769b(true);
        m4763a((Context) this);
        new C1832f(new C1811l(this), getApplicationContext()).m5514a(AuthData.m4810f(this));
        m4772h();
        bm b = C0771n.m3940b();
        b.mo1211a(true);
        b.mo1208a(2, m4780d());
    }

    public static void m4763a(Context context) {
        AuthData.m4802a(context, (float) GroundOverlayOptions.NO_DIMENSION);
        C0090q.m145a(context).m150a(new Intent("com.slideme.sam.manager.ACTION_WALLET_REFRESH_INITIATED"));
        f2614g.m5643e(new C1812m(context));
    }

    private void m4771g() {
        f2614g.m5641d(new C1866n(this));
    }

    private void m4769b(boolean z) {
        if (z || f2619l.m5426a()) {
            f2614g.m5636b(new C1906o(this));
        }
    }

    private void m4772h() {
        f2614g.m5639c(new C1777d(this));
    }

    private void m4773i() {
        C0510g.m3081a().m3083a(new C0513j(getApplicationContext()).m3111a(new C0464c(m4760a(((ActivityManager) getApplicationContext().getSystemService("activity")).getMemoryClass(), 25))).m3110a());
    }

    private static int m4760a(int i, int i2) {
        int i3;
        if (i == 0) {
            i = 12;
        }
        if (i2 < 0) {
            i3 = 0;
        } else {
            i3 = i2;
        }
        if (i3 > 81) {
            i3 = 80;
        }
        i3 = (int) (((((long) (i3 * i)) * 1024) * 1024) / 100);
        if (i3 <= 0) {
            return 4194304;
        }
        return i3;
    }

    public void m4775a(com.slideme.sam.manager.model.data.Application application, boolean z) {
        f2614g.m5632b(application, z ? C1878k.SUCCESS : C1878k.FAILED, new C1600v());
        if (!TextUtils.isEmpty(application.referrer)) {
            if (z) {
                if (!(this.f2632w == null || this.f2632w.isEmpty() || !this.f2632w.containsKey(application.packageName))) {
                    AdProxyChild adProxyChild = (AdProxyChild) this.f2632w.get(application.packageName);
                    C0345b.m2427c().m2439a(((C0364x) new C0364x().m2496a(BigDecimal.valueOf(adProxyChild.payout)).m2497a(Currency.getInstance("USD")).m2501b(adProxyChild.title).m2502c("offer").m2495a(adProxyChild.offerId).m2364a("network", adProxyChild.network)).m2498a(z));
                }
                f2614g.m5604a((Context) this, new AdProxyOfferReport(Secure.getString(getContentResolver(), "android_id"), application.adSlotId, application.clickUrl), new C1778e(this));
                f2623p.update(new InstallReferrerCacheObject(application.packageName, application.referrer, InstallReferrerCacheObject.STATE_INSTALLED));
            }
            C1922m.m5789a(this, new Intent(this, CheckPendingInstallNotificationsAlarmReceiver.class), 60000);
        } else if (application.price > 0.0d) {
            C0345b.m2427c().m2439a(new C0364x().m2496a(BigDecimal.valueOf(application.price)).m2497a(Currency.getInstance("USD")).m2501b(application.getName()).m2502c("app").m2495a(application.bundleId).m2498a(z));
        } else {
            C0345b.m2427c().m2439a(new C0364x().m2501b(application.getName()).m2502c("free").m2495a(application.bundleId).m2498a(z));
        }
        ((NotificationManager) getSystemService("notification")).notify(Integer.valueOf(application.nodeId).intValue(), C1704f.m5073a(this, application, z));
        if (z || application.price != 0.0d) {
            LaunchOrInstallService.m5562a(application.localFilePath);
        } else {
            Intent intent = new Intent(this, DeleteFileAlarmReceiver.class);
            C1915f.m5769a(intent, "com.slideme.sam.manager.EXTRA_APPLICATION", (Parcelable) application);
            C1922m.m5789a(this, intent, 420000);
        }
        if (z) {
            UpdatesDatabase updatesDatabase = new UpdatesDatabase(this);
            updatesDatabase.remove(new UpdatesDatabaseObject(application.bundleId));
            updatesDatabase.close();
        }
    }

    public List<String> m4778b() {
        if (f2630y == null) {
            return new ArrayList(0);
        }
        return f2630y;
    }

    public boolean m4779c() {
        return !TextUtils.isEmpty(getString(R.string.test_channel)) && AuthData.m4806b(this);
    }

    public String m4780d() {
        String string = getString(R.string.live_channel);
        if (m4779c() || string == null || string.equals("")) {
            return getString(R.string.test_channel);
        }
        return string;
    }

    public void m4776a(String str) {
        if (C1914e.f3493a) {
            Log.d("AccountManager", "Init networkUtils session with token: " + str);
        }
        f2614g.m5617a(str);
        m4770f();
    }

    public void m4781e() {
        m4769b(false);
    }

    public void m4774a(Activity activity, C1700p c1700p) {
        if (this.f2632w == null || this.f2632w.isEmpty()) {
            String str = "everypage";
            str = "offers_everypage";
            PreferenceCache preferenceCache = new PreferenceCache(this);
            CacheItem fetch = preferenceCache.fetch("offers_everypage");
            if (fetch != null) {
                C1922m.m5797b("AdProxy", "Use cached available offers");
                m4767a("everypage", fetch.payload, c1700p);
                return;
            } else if (System.currentTimeMillis() - this.f2633x > 900000) {
                C1922m.m5797b("AdProxy", "Downloading available offers");
                if (activity instanceof FlipperFragmentActivity) {
                    try {
                        ((FlipperFragmentActivity) activity).mo4273f();
                    } catch (Exception e) {
                    }
                }
                f2614g.m5602a(this, -1, "everypage", "1000", "all", true, new C1779f(this, preferenceCache, c1700p));
                return;
            } else if (c1700p != null) {
                c1700p.mo4255a(new Hashtable(), false);
                return;
            } else {
                return;
            }
        }
        C1922m.m5797b("AdProxy", "Offers already populated");
        if (c1700p != null) {
            c1700p.mo4255a(this.f2632w, true);
        }
    }

    public void m4777a(boolean z) {
        AccountManager.get(this).invalidateAuthToken("com.slideme.user_account", f2614g.m5596a());
        f2614g.m5617a(null);
        f2622o.m4846a();
        if (z) {
            C1922m.m5801e(this);
        } else {
            C1922m.m5800d(this);
        }
    }

    private void m4767a(String str, String str2, C1700p c1700p) {
        try {
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray != null && jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        AdProxyItem a = C1703e.m5067a(jSONArray.getJSONObject(i));
                        if (a != null && a.samAvailable) {
                            arrayList.add(a);
                            stringBuilder.append(a.packageName);
                            stringBuilder.append(",");
                        }
                    } catch (Exception e) {
                        if (C1914e.f3493a) {
                            e.printStackTrace();
                        }
                    }
                }
                new Thread(new C1780g(this, stringBuilder, jSONArray, arrayList, str, c1700p)).start();
            } else if (c1700p != null) {
                c1700p.mo4255a(new Hashtable(), false);
            }
        } catch (JSONException e2) {
            if (C1914e.f3493a) {
                e2.printStackTrace();
            }
            if (c1700p != null) {
                c1700p.mo4255a(new Hashtable(), false);
            }
        }
    }
}
