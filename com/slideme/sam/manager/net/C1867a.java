package com.slideme.sam.manager.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import com.facebook.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.plus.PlusShare;
import com.google.p043a.C0743k;
import com.google.p043a.C0751r;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.p019a.p020a.C0367a;
import com.p019a.p020a.p023c.C0395h;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.controller.p055b.C1705g;
import com.slideme.sam.manager.model.data.AdProxyOfferHealthReport;
import com.slideme.sam.manager.model.data.AdProxyOfferReport;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.InstalledApplication;
import com.slideme.sam.manager.model.data.Review;
import com.slideme.sam.manager.model.data.Review.Thumbs;
import com.slideme.sam.manager.model.data.Review.ThumbsDeserializer;
import com.slideme.sam.manager.model.data.UserProfile;
import com.slideme.sam.manager.model.data.dynamic.DynamicLayout.Template;
import com.slideme.sam.manager.model.data.dynamic.DynamicLayout.TemplateDeserializer;
import com.slideme.sam.manager.model.data.test.ScoreCardData;
import com.slideme.sam.manager.model.p054b.C1829c;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.BookmarksLoadAllResponse;
import com.slideme.sam.manager.net.response.CheckUserDataResponse;
import com.slideme.sam.manager.net.response.CurrencyResponse;
import com.slideme.sam.manager.net.response.DailyServiceResponse;
import com.slideme.sam.manager.net.response.DeviceRegisterResponse;
import com.slideme.sam.manager.net.response.DynamicContainerResponse;
import com.slideme.sam.manager.net.response.FeedsPageResponse;
import com.slideme.sam.manager.net.response.InAppConsumeResponse;
import com.slideme.sam.manager.net.response.InAppListResponse;
import com.slideme.sam.manager.net.response.InAppPurchaseResponse;
import com.slideme.sam.manager.net.response.InAppPurchasesListResponse;
import com.slideme.sam.manager.net.response.LoginResponse;
import com.slideme.sam.manager.net.response.MyAppsResponse;
import com.slideme.sam.manager.net.response.PreloadedAppsResponse;
import com.slideme.sam.manager.net.response.PurchaseResponse;
import com.slideme.sam.manager.net.response.PurchaseResponse.PurchaseStatus;
import com.slideme.sam.manager.net.response.PurchaseResponse.PurchaseStatusDeserializer;
import com.slideme.sam.manager.net.response.RegisterResponse;
import com.slideme.sam.manager.net.response.ReviewChartResponse;
import com.slideme.sam.manager.net.response.ReviewListResponse;
import com.slideme.sam.manager.net.response.ReviewResponse;
import com.slideme.sam.manager.net.response.ScorecardResponse;
import com.slideme.sam.manager.net.response.WalletResponse;
import com.slideme.sam.manager.net.wrappers.C1896f;
import com.slideme.sam.manager.util.C1911a;
import com.slideme.sam.manager.util.C1913d;
import com.slideme.sam.manager.util.C1914e;
import com.slideme.sam.manager.util.C1921l;
import com.slideme.sam.manager.util.C1922m;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.cookie.Cookie;

/* compiled from: NetworkUtils */
public class C1867a {
    private static final String f3330A = (SAM.f2608a + "/services/rest/service_mobileapp/wallet_getbalance.json");
    private static final String f3331B = (SAM.f2608a + "/services/rest/service_mobileapp/setapp.json");
    private static final String f3332C = (SAM.f2608a + "/services/rest/service_mobileapp/stars.json");
    private static final String f3333D = (SAM.f2608a + "/services/rest/service_mobileapp/review_save.json");
    private static final String f3334E = (SAM.f2608a + "/services/rest/service_mobileapp/user_social.json");
    private static final String f3335F = (SAM.f2610c + "/scorecards/cards/");
    private static final String f3336G = (SAM.f2610c + "/scorecards/answers/");
    private static final String f3337H = (SAM.f2608a + "/services/rest/service_mobileapp/buy5.json");
    private static final String f3338I = (SAM.f2608a + "/services/rest/service_mobileapp/review_loadAll.json");
    private static final String f3339J = (SAM.f2608a + "/services/rest/service_mobileapp/dailyservice.json");
    private static final String f3340K = (SAM.f2608a + "/sam-version");
    private static final String f3341L = (SAM.f2608a + "/services/rest/service_mobileiap/list.json");
    private static final String f3342M = (SAM.f2608a + "/services/rest/service_mobileiap/purchases_list.json");
    private static final String f3343N = (SAM.f2608a + "/services/rest/service_mobileiap/purchase.json");
    private static final String f3344O = (SAM.f2608a + "/services/rest/service_mobileiap/consume.json");
    private static final String f3345P = (SAM.f2611d + "/api/providers/sam/callback");
    private static final String f3346Q = (SAM.f2611d + "/api/reports/add");
    private static final String f3347R = (SAM.f2612e + "/offers/add_sam");
    private static final String f3348S = (SAM.f2610c + "/uidpackages/");
    private static CookieStore f3349Y;
    public static final String f3350a = (SAM.f2611d + "/api/offers/feed");
    private static /* synthetic */ int[] aa;
    public static C0743k f3351b;
    private static final String f3352c = (SAM.f2609b + "/catalog");
    private static final String f3353d = (SAM.f2608a + "/services/rest/service_system/connect5.json");
    private static final String f3354e = (SAM.f2608a + "/services/rest/service_device/register.json");
    private static final String f3355f = (SAM.f2608a + "/services/rest/service_device/device_specs.json");
    private static final String f3356g = (SAM.f2608a + "/services/rest/service_user/login5.json");
    private static final String f3357h = (SAM.f2608a + "/services/rest/service_user/check_password.json?");
    private static final String f3358i = (SAM.f2608a + "/services/rest/service_user/logout.json");
    private static final String f3359j = (SAM.f2608a + "/services/rest/service_user/accept5.json");
    private static final String f3360k = (SAM.f2608a + "/services/rest/service_user/upgrade.json");
    private static final String f3361l = (SAM.f2608a + "/services/rest/service_mobileapp/checkuserdata.json");
    private static final String f3362m = (SAM.f2608a + "/services/rest/service_mobileapp/download5.json");
    private static final String f3363n = (SAM.f2608a + "/services/rest/service_mobileapp/uninstall.json");
    private static final String f3364o = (SAM.f2608a + "/services/rest/service_mobileapp/install5.json");
    private static final String f3365p = (SAM.f2608a + "/services/rest/service_mobileapp/bookmarks_set.json");
    private static final String f3366q = (SAM.f2608a + "/services/rest/service_mobileapp/bookmarks_loadAll.json");
    private static final String f3367r = (SAM.f2608a + "/services/rest/service_mobileapp/purchases.json");
    private static final String f3368s = (SAM.f2608a + "/services/rest/service_mobileapp/network_update.json");
    private static final String f3369t = (SAM.f2608a + "/services/rest/service_mobileapp/reviewthumbs_save.json");
    private static final String f3370u = (SAM.f2608a + "/services/rest/service_mobileapp/review_load.json");
    private static final String f3371v = (SAM.f2608a + "/services/rest/service_mobileapp/getsupport.json");
    private static final String f3372w = (SAM.f2610c + "/rates.json");
    private static final String f3373x = (SAM.f2608a + "/services/rest/service_mobileapp/userregister.json");
    private static final String f3374y = (SAM.f2608a + "/services/rest/service_user/myapps.json");
    private static final String f3375z = (SAM.f2608a + "/services/rest/service_mobileapp/report.json");
    private C1889t f3376T = new C1889t();
    private C1890u f3377U = new C1890u();
    private C1889t f3378V = new C1889t();
    private C1890u f3379W = new C1890u();
    private C1889t f3380X = new C1889t();
    private SAM f3381Z;

    static /* synthetic */ int[] m5588d() {
        int[] iArr = aa;
        if (iArr == null) {
            iArr = new int[C1896f.values().length];
            try {
                iArr[C1896f.Local.ordinal()] = 8;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C1896f.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1896f.Offers.ordinal()] = 7;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C1896f.TopFree.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[C1896f.TopNew.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[C1896f.TopPaid.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[C1896f.Trending.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[C1896f.Video.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            aa = iArr;
        }
        return iArr;
    }

    private static AsyncHttpResponseHandler m5583b(String str, RequestParams requestParams, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        return new C1868b(str, requestParams, asyncHttpResponseHandler);
    }

    public C1867a(SAM sam) {
        this.f3381Z = sam;
        f3349Y = new PersistentCookieStore(sam);
        this.f3376T.setUserAgent(SAM.f2626s);
        this.f3376T.setTimeout(20000);
        this.f3376T.setCookieStore(f3349Y);
        if (C1914e.f3493a) {
            this.f3376T.setBasicAuth("dev", "123slide");
        }
        this.f3376T.getHttpClient().getParams().setParameter("http.protocol.allow-circular-redirects", Boolean.valueOf(true));
        this.f3377U.setUserAgent(SAM.f2626s);
        this.f3377U.setTimeout(20000);
        this.f3377U.setCookieStore(f3349Y);
        if (C1914e.f3493a) {
            this.f3377U.setBasicAuth("dev", "123slide");
        }
        this.f3377U.getHttpClient().getParams().setParameter("http.protocol.allow-circular-redirects", Boolean.valueOf(true));
        this.f3378V.setUserAgent(SAM.f2626s);
        this.f3378V.setTimeout(60000);
        this.f3378V.setCookieStore(f3349Y);
        this.f3378V.getHttpClient().getParams().setParameter("http.protocol.allow-circular-redirects", Boolean.valueOf(true));
        this.f3379W.setUserAgent(SAM.f2626s);
        this.f3379W.setTimeout(60000);
        this.f3379W.setCookieStore(f3349Y);
        this.f3379W.getHttpClient().getParams().setParameter("http.protocol.allow-circular-redirects", Boolean.valueOf(true));
        f3351b = new C0751r().m3702a(PurchaseStatus.class, new PurchaseStatusDeserializer()).m3702a(Template.class, new TemplateDeserializer()).m3702a(Thumbs.class, new ThumbsDeserializer()).m3701a("ss").m3700a();
    }

    public void m5617a(String str) {
        f3349Y.clear();
        if (!TextUtils.isEmpty(str)) {
            f3349Y.addCookie(C1922m.m5786a(str));
        }
    }

    public String m5596a() {
        return C1922m.m5785a(C1922m.m5788a(f3349Y));
    }

    public void m5619a(String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        this.f3376T.get(str, asyncHttpResponseHandler);
    }

    public void m5605a(Context context, C1599q c1599q) {
        this.f3376T.get(f3355f, m5584b(context), m5575a(c1599q, Void.class));
    }

    public void m5622a(String str, C1599q c1599q) {
        RequestParams e = m5589e();
        if (!TextUtils.isEmpty(str)) {
            e.put("udid_base", str);
        }
        this.f3376T.get(f3354e, e, m5575a(c1599q, DeviceRegisterResponse.class));
    }

    public HashMap<String, String> m5599a(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("android_id", Secure.getString(context.getContentResolver(), "android_id"));
        hashMap.put("build_board", C1829c.m5502d());
        hashMap.put("cput_abi", C1829c.m5501c());
        hashMap.put("cpu_info", C1913d.m5756a());
        hashMap.put("manufacturer", C1829c.m5503e());
        hashMap.put("model", C1829c.m5499a());
        String[] a = C1705g.m5078a(context, context.getResources());
        hashMap.put("screen_resolution", a[0] + "x" + a[1]);
        hashMap.put("screen_dpi", String.valueOf(C1705g.m5080c(context, context.getResources())));
        hashMap.put("API_level", String.valueOf(C1829c.m5504f()));
        hashMap.put("software_version", telephonyManager.getDeviceSoftwareVersion());
        hashMap.put("language_iso", locale.getLanguage());
        hashMap.put("country_iso", locale.getCountry());
        hashMap.put("network_iso", telephonyManager.getNetworkCountryIso());
        hashMap.put("network_op", telephonyManager.getNetworkOperator());
        hashMap.put("network_op_name", telephonyManager.getNetworkOperatorName());
        hashMap.put("sim_iso", telephonyManager.getSimCountryIso());
        hashMap.put("sim_op", telephonyManager.getSimOperator());
        hashMap.put("sim_serial", telephonyManager.getSimSerialNumber());
        hashMap.put("subscriber_id", telephonyManager.getSubscriberId());
        hashMap.put("hps", String.valueOf(SAM.f2615h.m5512c() ? 1 : 0));
        if (VERSION.SDK_INT >= 9) {
            hashMap.put("build_serial", C1921l.m5783a());
        }
        if (VERSION.SDK_INT >= 8) {
            hashMap.put("cpu_abi2", C1921l.m5784b());
        }
        return hashMap;
    }

    private RequestParams m5584b(Context context) {
        RequestParams e = m5589e();
        HashMap a = m5599a(context);
        for (String str : a.keySet()) {
            e.put(str, (String) a.get(str));
        }
        return e;
    }

    public void m5613a(UserProfile userProfile, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("email", userProfile.getMail());
        e.put("username", userProfile.getUserName());
        e.put("fullname", userProfile.getFullName());
        e.put("password", userProfile.getPassword());
        e.put("gender", userProfile.getGender());
        this.f3376T.get(f3373x, e, m5575a(c1599q, RegisterResponse.class));
    }

    public void m5637b(String str, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put(ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN, str);
        this.f3376T.get(f3334E, e, m5575a(c1599q, LoginResponse.class));
    }

    public void m5626a(String str, String str2, String str3, C1883p c1883p, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("username", str);
        e.put("fullname", str2);
        e.put("password", str3);
        String str4 = "gender";
        String str5 = c1883p == C1883p.MALE ? AppEventsConstants.EVENT_PARAM_VALUE_YES : c1883p == C1883p.FEMALE ? "2" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        e.put(str4, str5);
        this.f3376T.get(f3360k, e, m5575a(c1599q, RegisterResponse.class));
    }

    public void m5611a(Application application, boolean z, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("bundle_id", application.bundleId);
        e.put("set", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "-1");
        this.f3376T.get(f3331B, e, m5575a(c1599q, Void.class));
    }

    public void m5640c(String str, C1599q c1599q) {
        this.f3376T.get(f3335F + str, null, m5575a(new C1869c(this, c1599q), ScorecardResponse.class));
    }

    public void m5621a(String str, ScoreCardData scoreCardData, C1599q c1599q) {
        this.f3376T.m5652a(this.f3381Z, f3336G + str, scoreCardData, m5575a(c1599q, Void.class));
    }

    public void m5642d(String str, C1599q c1599q) {
        this.f3376T.get(f3336G + str, null, m5575a(c1599q, ScorecardResponse.class));
    }

    public void m5615a(C1599q c1599q) {
        this.f3376T.get(f3372w, m5575a(c1599q, CurrencyResponse.class));
    }

    public void m5624a(String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        RequestParams requestParams = null;
        C1889t c1889t = new C1889t();
        c1889t.addHeader("Accept", "application/json");
        if (f3350a.contains("advm")) {
            requestParams = new RequestParams("advm", Integer.valueOf(1));
        }
        c1889t.get(f3347R + "/" + str + "/" + str2, requestParams, asyncHttpResponseHandler);
    }

    public void m5602a(Context context, int i, String str, String str2, String str3, boolean z, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        C1911a.m5755a(context, new C1872e(this, str, context, i, str2, str3, z, asyncHttpResponseHandler));
    }

    public String m5597a(Context context, int i, String str, String str2, String str3, boolean z, String str4, boolean z2) {
        try {
            return this.f3379W.get(f3350a, C1888s.m5651a(context, i, str, str2, str3, this.f3381Z.m4780d(), z, str4, z2));
        } catch (Throwable e) {
            m5582a(e, null);
            return null;
        }
    }

    public void m5604a(Context context, AdProxyOfferReport adProxyOfferReport, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        RequestParams e = m5589e();
        e.put("v", "2");
        C1922m.m5797b("AdProxy", AsyncHttpClient.getUrlWithQueryString(f3345P, e));
        this.f3378V.m5652a(context, AsyncHttpClient.getUrlWithQueryString(f3345P, e), adProxyOfferReport, asyncHttpResponseHandler);
    }

    public void m5603a(Context context, AdProxyOfferHealthReport adProxyOfferHealthReport, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        RequestParams e = m5589e();
        e.put("v", "2");
        C1922m.m5797b("AdProxy", AsyncHttpClient.getUrlWithQueryString(f3346Q, e));
        this.f3378V.m5652a(context, AsyncHttpClient.getUrlWithQueryString(f3346Q, e), adProxyOfferHealthReport, asyncHttpResponseHandler);
    }

    public void m5627a(String str, ArrayList<InstalledApplication> arrayList, C1599q c1599q) {
        if (!TextUtils.isEmpty(str)) {
            this.f3376T.m5652a(this.f3381Z, f3348S + str + "?key=" + "4ba9e17f6bcc32c036fa683a79f9494a", arrayList, m5575a(c1599q, Void.class));
        }
    }

    public void m5612a(Review review, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("nid", review.id);
        e.put("thumbs_dir", String.valueOf(review.userThumbs.ordinal()));
        this.f3376T.get(f3369t, e, m5575a(c1599q, Void.class));
    }

    public void m5635b(Review review, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("bundle_id", review.appUid);
        e.put("body", review.text);
        e.put("rating", String.valueOf(review.rating * 20.0f));
        e.put("video", review.video);
        this.f3376T.get(f3333D, e, m5575a(c1599q, Void.class));
    }

    public void m5625a(String str, String str2, String str3, C1881n c1881n, C1599q c1599q) {
        RequestParams e = m5589e();
        if (str != null) {
            e.put("bundle_id", str);
        }
        e.put("subject", str2);
        e.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, str3);
        e.put("destination", String.valueOf(c1881n.ordinal()));
        this.f3376T.get(f3371v, e, m5575a(c1599q, Void.class));
    }

    public void m5636b(C1599q c1599q) {
        this.f3376T.get(f3339J, m5589e(), m5575a(c1599q, DailyServiceResponse.class));
    }

    public void m5610a(Application application, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("bundle_id", application.bundleId);
        this.f3376T.get(f3370u, e, m5575a(c1599q, ReviewResponse.class));
    }

    public void m5616a(C1782r c1782r) {
        RequestParams e = m5589e();
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f3381Z.getPackageManager().getPackageInfo(this.f3381Z.getPackageName(), 0);
        } catch (Throwable e2) {
            C1922m.m5791a(e2);
        }
        e.put("version_code", packageInfo.versionCode);
        e.put("version_name", packageInfo.versionName);
        e.put("partner", this.f3381Z.m4780d());
        e.put("device", C1829c.m5500b() + "_" + C1829c.m5500b());
        e.put("region", "misc");
        e.put("language", "misc");
        e.put("API_level".toLowerCase(), String.valueOf(C1829c.m5504f()));
        m5620a(f3340K, e, c1782r);
    }

    public void m5609a(Application application, C1878k c1878k, C1599q c1599q) {
        String str;
        RequestParams e = m5589e();
        e.put("package_name", application.packageName);
        e.put(ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN, application.token != null ? application.token : "free");
        String str2 = "status";
        if (c1878k == C1878k.SUCCESS) {
            str = "downloaded";
        } else if (c1878k == C1878k.CANCELLED) {
            str = "canceled";
        } else {
            str = "failed";
        }
        e.put(str2, str);
        e.put("app_version_name", application.version);
        e.put("app_version_code", String.valueOf(application.versionCode));
        e.put("bundle_id", application.bundleId);
        this.f3376T.get(f3362m, e, m5575a(c1599q, Void.class));
    }

    public void m5632b(Application application, C1878k c1878k, C1599q c1599q) {
        String str;
        RequestParams e = m5589e();
        e.put("package_name", application.packageName);
        e.put(ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN, application.token != null ? application.token : "free");
        String str2 = "status";
        if (c1878k == C1878k.SUCCESS) {
            str = "installed";
        } else if (c1878k == C1878k.CANCELLED) {
            str = "canceled";
        } else {
            str = "failed";
        }
        e.put(str2, str);
        e.put("app_version_name", application.version);
        e.put("app_version_code", String.valueOf(application.versionCode));
        e.put("bundle_id", application.bundleId);
        this.f3376T.get(f3364o, e, m5575a(c1599q, Void.class));
    }

    public void m5607a(TelephonyManager telephonyManager, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("network_iso", telephonyManager.getNetworkCountryIso());
        e.put("network_op", telephonyManager.getNetworkOperator());
        e.put("network_op_name", telephonyManager.getNetworkOperatorName());
        e.put("sim_iso", telephonyManager.getSimCountryIso());
        e.put("sim_op", telephonyManager.getSimOperator());
        this.f3376T.get(f3368s, e, m5575a(c1599q, Void.class));
    }

    public void m5634b(Application application, boolean z, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("bundle_id", application.bundleId);
        e.put("action", String.valueOf(z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO));
        this.f3376T.get(f3365p, e, m5575a(c1599q, Void.class));
    }

    public void m5633b(Application application, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("bundle_id", application.bundleId);
        this.f3376T.get(f3332C, e, m5575a(c1599q, ReviewChartResponse.class));
    }

    public void m5618a(String str, int i, int i2, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("bundle_id", str);
        e.put("start", i);
        e.put("count", i2);
        this.f3376T.get(f3338I, e, m5575a(c1599q, ReviewListResponse.class));
    }

    public void m5639c(C1599q c1599q) {
        m5589e();
        this.f3376T.get(f3366q, m5589e(), m5575a(c1599q, BookmarksLoadAllResponse.class));
    }

    public void m5614a(C1879l c1879l, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("type", c1879l.toString());
        this.f3376T.get(f3374y, e, m5575a(c1599q, MyAppsResponse.class));
    }

    public void m5641d(C1599q c1599q) {
        this.f3376T.get(f3367r, m5589e(), m5575a(c1599q, PurchaseResponse.class));
    }

    public void m5601a(int i, String str, String str2, String str3, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("api_version", i);
        e.put("product_id", str);
        e.put("app_nid", str2);
        e.put("developer_payload", str3);
        this.f3376T.get(f3343N, e, m5575a(c1599q, InAppPurchaseResponse.class));
    }

    public void m5600a(int i, String str, String str2, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("api_version", i);
        e.put("product_id", str);
        e.put("app_nid", str2);
        this.f3376T.get(f3341L, e, m5575a(c1599q, InAppListResponse.class));
    }

    public void m5608a(Application application, int i, String str, C1599q c1599q) {
        RequestParams e = m5589e();
        e.put("bundle_id", application.bundleId);
        e.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, application.versionCode);
        e.put("reason", i);
        e.put("objection", str);
        this.f3376T.get(f3375z, e, m5575a(c1599q, Void.class));
    }

    public void m5643e(C1599q c1599q) {
        this.f3376T.get(f3330A, m5589e(), m5575a(c1599q, WalletResponse.class));
    }

    public void m5644e(String str, C1599q c1599q) {
        RequestParams e = m5589e();
        e.remove("udid");
        e.put("v", 110);
        e.put("json", 1);
        this.f3376T.get(str, e, m5575a(c1599q, DynamicContainerResponse.class));
    }

    public void m5623a(String str, C1782r c1782r) {
        m5620a(str, null, c1782r);
    }

    public void m5620a(String str, RequestParams requestParams, C1782r c1782r) {
        this.f3376T.get(str, requestParams, new C1873f(this, c1782r));
    }

    public InAppConsumeResponse m5592a(int i, String str, String str2) {
        String str3 = null;
        RequestParams e = m5589e();
        e.put("api_version", i);
        e.put("tid", str);
        e.put("app_nid", str2);
        try {
            return (InAppConsumeResponse) m5585b(this.f3377U.get(f3344O, e), InAppConsumeResponse.class);
        } catch (Throwable e2) {
            m5582a(e2, str3);
            return str3;
        }
    }

    public InAppListResponse m5593a(int i, List<String> list, String str) {
        String str2 = null;
        RequestParams e = m5589e();
        e.put("api_version", i);
        e.put("app_nid", str);
        e.put("product_id", C1922m.m5796b((List) list));
        try {
            return (InAppListResponse) m5585b(this.f3377U.get(f3341L, e), InAppListResponse.class);
        } catch (Throwable e2) {
            m5582a(e2, str2);
            return str2;
        }
    }

    public InAppPurchasesListResponse m5594a(int i, String str) {
        String str2 = null;
        RequestParams e = m5589e();
        e.put("api_version", i);
        e.put("app_nid", str);
        try {
            return (InAppPurchasesListResponse) m5585b(this.f3377U.get(f3342M, e), InAppPurchasesListResponse.class);
        } catch (Throwable e2) {
            m5582a(e2, str2);
            return str2;
        }
    }

    public ArrayList<String> m5598a(C1879l c1879l) {
        String str = null;
        RequestParams e = m5589e();
        e.put("type", c1879l.toString());
        try {
            MyAppsResponse myAppsResponse = (MyAppsResponse) m5585b(this.f3377U.get(f3374y, e), MyAppsResponse.class);
            if (myAppsResponse == null) {
                return new ArrayList(0);
            }
            return myAppsResponse.myApps;
        } catch (Throwable e2) {
            m5582a(e2, str);
            return str;
        }
    }

    public ArrayList<String> m5631b() {
        String str = null;
        try {
            String str2 = "preapps_" + this.f3381Z.m4780d() + ".json";
            PreloadedAppsResponse preloadedAppsResponse = (PreloadedAppsResponse) f3351b.m3675a(this.f3377U.get("https://s.slideme.org/files/" + str2 + ("?cb=" + DateFormat.format("yyyy-MM-dd", new Date())), m5589e()), PreloadedAppsResponse.class);
            if (preloadedAppsResponse == null) {
                return new ArrayList(0);
            }
            return preloadedAppsResponse.apps;
        } catch (Throwable e) {
            m5582a(e, str);
            return str;
        }
    }

    public boolean m5628a(C1882o c1882o, String str) {
        RequestParams e = m5589e();
        e.put("datatype", c1882o.ordinal());
        e.put("data", str);
        try {
            CheckUserDataResponse checkUserDataResponse = (CheckUserDataResponse) m5585b(this.f3377U.get(f3361l, e), CheckUserDataResponse.class);
            if (checkUserDataResponse == null) {
                return false;
            }
            return checkUserDataResponse.available;
        } catch (Throwable e2) {
            m5582a(e2, null);
            return false;
        }
    }

    public UserProfile m5638c() {
        try {
            m5589e();
            LoginResponse loginResponse = (LoginResponse) m5585b(this.f3377U.get(f3353d, m5589e()), LoginResponse.class);
            Cookie a = C1922m.m5788a(f3349Y);
            if (a != null) {
                f3349Y.clear();
                f3349Y.addCookie(a);
            }
            return loginResponse.user;
        } catch (Throwable e) {
            m5582a(e, "");
            return null;
        }
    }

    public void m5606a(Context context, String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        RequestParams e = m5589e();
        e.put("udid", C1913d.m5766c(context));
        e.put("password", str);
        this.f3376T.get(f3357h, e, asyncHttpResponseHandler);
    }

    public AuthData m5590a(String str, String str2, String str3, boolean z) {
        if (z) {
            f3349Y.clear();
        }
        RequestParams e = m5589e();
        Cookie a = C1922m.m5788a(f3349Y);
        try {
            UserProfile c = m5638c();
            if (c.isAuthenticated()) {
                return new AuthData(C1922m.m5785a(a), c);
            }
            e.put("username", str);
            e.put("password", str2);
            LoginResponse loginResponse = (LoginResponse) m5585b(this.f3377U.get(f3356g, e), LoginResponse.class);
            Cookie a2 = C1922m.m5788a(f3349Y);
            f3349Y.clear();
            f3349Y.addCookie(a2);
            if (loginResponse != null && loginResponse.user != null && loginResponse.user.isAuthenticated()) {
                return new AuthData(C1922m.m5785a(a2), loginResponse.user);
            }
            C1922m.m5797b("SAM Network", "Could not log in. Username: " + str);
            return null;
        } catch (Throwable e2) {
            m5582a(e2, "");
            return null;
        }
    }

    public PurchaseResponse m5595a(Application application) {
        String str = null;
        RequestParams e = m5589e();
        e.put("bundle_id", application.bundleId);
        e.put("price", String.valueOf(application.price));
        try {
            return (PurchaseResponse) m5585b(this.f3377U.get(f3337H, e), PurchaseResponse.class);
        } catch (Throwable e2) {
            m5582a(e2, str);
            return str;
        }
    }

    public PurchaseResponse m5629b(Application application) {
        String str = null;
        RequestParams e = m5589e();
        e.put("bundle_id", application.bundleId);
        if (application.token != null) {
            e.put(ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN, application.token);
        }
        try {
            return (PurchaseResponse) m5585b(this.f3377U.get(f3367r, e), PurchaseResponse.class);
        } catch (Throwable e2) {
            m5582a(e2, str);
            return str;
        }
    }

    public FeedsPageResponse m5591a(C1896f c1896f, RequestParams requestParams) {
        String str = null;
        try {
            return (FeedsPageResponse) m5585b(this.f3377U.get(f3352c + m5580a(c1896f), requestParams), FeedsPageResponse.class);
        } catch (Throwable e) {
            m5582a(e, str);
            return str;
        }
    }

    public String m5630b(String str) {
        return this.f3377U.get(str);
    }

    private BaseNetworkResponse m5578a(String str, Class<?> cls) {
        if (cls == Void.class) {
            return null;
        }
        if (cls.getSuperclass() != BaseNetworkResponse.class) {
            throw new IllegalArgumentException("Won't parse non-NetworkResponse types.");
        }
        try {
            if (cls != CurrencyResponse.class) {
                return (BaseNetworkResponse) f3351b.m3675a(str, (Class) cls);
            }
            BaseNetworkResponse currencyResponse = new CurrencyResponse();
            currencyResponse.rates = (HashMap) f3351b.m3676a(str, new C1874g(this).m3661b());
            return currencyResponse;
        } catch (Exception e) {
            C1922m.m5790a(e);
            if (cls != null) {
                C1922m.m5797b("SAM Network", cls.getSimpleName());
            }
            String str2 = "SAM Network";
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            C1922m.m5797b(str2, str);
            return null;
        }
    }

    private RequestParams m5589e() {
        RequestParams requestParams = new RequestParams();
        SAM sam = this.f3381Z;
        requestParams.put("udid", C1913d.m5766c(sam.getApplicationContext()));
        requestParams.put("partner", sam.m4780d());
        requestParams.put("sam_version", sam.getString(R.string.sam_version_num));
        requestParams.put("locale", new StringBuilder(String.valueOf(Locale.getDefault().getLanguage())).append('_').append(Locale.getDefault().getCountry()).toString());
        return requestParams;
    }

    private AsyncHttpResponseHandler m5575a(C1599q c1599q, Class<?> cls) {
        return new C1875h(this, cls, c1599q);
    }

    private String m5580a(C1896f c1896f) {
        switch (C1867a.m5588d()[c1896f.ordinal()]) {
            case 2:
                return "/topNew";
            case 3:
                return "/trending";
            case 4:
                return "/topPaid";
            case 5:
                return "/free";
            case 6:
                return "/videos";
            case 7:
                return "/offers";
            case 8:
                return "/local";
            default:
                return "";
        }
    }

    private BaseNetworkResponse m5585b(String str, Class<?> cls) {
        if (C1914e.f3493a) {
            String str2;
            Log.i("SAM Network", TextUtils.isEmpty(str) ? "" : str);
            C0395h c0395h = C0367a.m2509e().f1149c;
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = str;
            }
            c0395h.m2776a(str2);
        }
        BaseNetworkResponse a = m5578a(str, (Class) cls);
        if (!(a == null || TextUtils.isEmpty(a.message))) {
            Log.e("SAM Network", a.message);
            C0367a.m2509e().f1149c.m2776a(a.message);
        }
        return a;
    }

    private void m5582a(Throwable th, String str) {
        if (C1914e.f3493a) {
            String str2 = "SAM Network";
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.e(str2, str);
            th.printStackTrace();
        } else {
            C0367a.m2509e().f1149c.m2778a(th);
            C0395h c0395h = C0367a.m2509e().f1149c;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            c0395h.m2776a(str);
        }
        if ((th instanceof SocketTimeoutException) || (th instanceof ConnectTimeoutException)) {
            try {
                new Handler(Looper.getMainLooper()).post(new C1876i(this));
            } catch (Throwable e) {
                C0367a.m2509e().f1149c.m2778a(e);
            }
        } else if (th instanceof HttpResponseException) {
            C1922m.m5790a(new Exception("HTTP ERROR " + ((HttpResponseException) th).getStatusCode(), th));
            ((HttpResponseException) th).getStatusCode();
        }
    }
}
