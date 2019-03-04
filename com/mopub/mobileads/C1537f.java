package com.mopub.mobileads;

import android.net.Uri;
import android.util.Log;
import com.mopub.common.p050b.C1484g;
import com.mopub.common.p050b.C1489l;
import com.mopub.common.p050b.C1491n;
import com.mopub.mobileads.util.C1558d;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

/* compiled from: AdLoadTask */
class C1537f {
    private final HttpResponse f2504a;
    private final AdViewController f2505b;
    private String f2506c;
    private String f2507d;
    private String f2508e;

    C1537f(HttpResponse httpResponse, AdViewController adViewController) {
        this.f2504a = httpResponse;
        this.f2505b = adViewController;
    }

    C1534c m4647a() {
        this.f2506c = C1558d.m4662a(this.f2504a, C1489l.AD_TYPE);
        this.f2508e = C1558d.m4662a(this.f2504a, C1489l.FULL_AD_TYPE);
        Log.d("MoPub", "Loading ad type: " + AdTypeTranslator.m4227a(this.f2506c, this.f2508e));
        this.f2507d = AdTypeTranslator.m4226a(this.f2505b.m4238a(), this.f2506c, this.f2508e);
        if ("custom".equals(this.f2506c)) {
            return m4643b();
        }
        if (m4644b(this.f2506c)) {
            return m4645c();
        }
        return m4646d();
    }

    private C1534c m4643b() {
        Log.i("MoPub", "Performing custom event.");
        this.f2507d = C1558d.m4662a(this.f2504a, C1489l.CUSTOM_EVENT_NAME);
        if (this.f2507d != null) {
            return m4642a(C1558d.m4662a(this.f2504a, C1489l.CUSTOM_EVENT_DATA));
        }
        return new C1536e(this.f2505b, this.f2504a.getFirstHeader(C1489l.CUSTOM_SELECTOR.getKey()));
    }

    private C1534c m4645c() {
        HttpEntity entity = this.f2504a.getEntity();
        String a = entity != null ? C1491n.m4087a(entity.getContent()) : "";
        this.f2505b.m4264m().m4188b(a);
        String a2 = C1558d.m4662a(this.f2504a, C1489l.REDIRECT_URL);
        String a3 = C1558d.m4662a(this.f2504a, C1489l.CLICKTHROUGH_URL);
        boolean a4 = C1558d.m4663a(this.f2504a, C1489l.SCROLLABLE, false);
        Map hashMap = new HashMap();
        hashMap.put("Html-Response-Body", Uri.encode(a));
        hashMap.put("Scrollable", Boolean.toString(a4));
        if (a2 != null) {
            hashMap.put("Redirect-Url", a2);
        }
        if (a3 != null) {
            hashMap.put("Clickthrough-Url", a3);
        }
        return m4642a(C1484g.m4069a(hashMap));
    }

    private C1534c m4646d() {
        return m4642a(C1558d.m4662a(this.f2504a, C1489l.NATIVE_PARAMS));
    }

    private C1534c m4642a(String str) {
        Map hashMap = new HashMap();
        hashMap.put(C1489l.CUSTOM_EVENT_NAME.getKey(), this.f2507d);
        if (str != null) {
            hashMap.put(C1489l.CUSTOM_EVENT_DATA.getKey(), str);
        }
        return new C1535d(this.f2505b, hashMap);
    }

    private boolean m4644b(String str) {
        return "mraid".equals(str) || "html".equals(str) || ("interstitial".equals(str) && "vast".equals(this.f2508e));
    }
}
