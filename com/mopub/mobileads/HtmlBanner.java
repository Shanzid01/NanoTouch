package com.mopub.mobileads;

import android.content.Context;
import android.net.Uri;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.mopub.mobileads.p051a.C1528h;
import java.util.Map;

public class HtmlBanner extends CustomEventBanner {
    private HtmlBannerWebView f2306a;

    protected void mo4103a(Context context, CustomEventBannerListener customEventBannerListener, Map<String, Object> map, Map<String, String> map2) {
        if (m4309a(map2)) {
            String decode = Uri.decode((String) map2.get("Html-Response-Body"));
            String str = (String) map2.get("Redirect-Url");
            String str2 = (String) map2.get("Clickthrough-Url");
            Boolean valueOf = Boolean.valueOf((String) map2.get("Scrollable"));
            AdConfiguration a = AdConfiguration.m4181a((Map) map);
            this.f2306a = C1528h.m4487a(context, customEventBannerListener, valueOf.booleanValue(), str, str2, a);
            AdViewController.m4231a(this.f2306a);
            this.f2306a.m4277a(decode);
            return;
        }
        customEventBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
    }

    protected void mo4102a() {
        if (this.f2306a != null) {
            this.f2306a.destroy();
        }
    }

    private boolean m4309a(Map<String, String> map) {
        return map.containsKey("Html-Response-Body");
    }
}
