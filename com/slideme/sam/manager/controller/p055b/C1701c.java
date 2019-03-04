package com.slideme.sam.manager.controller.p055b;

import android.app.Activity;
import android.content.Intent;
import com.slideme.sam.manager.C1700p;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.market.product.ApplicationDetailsActivity;
import com.slideme.sam.manager.controller.activities.web.AdProxyWebViewActivity;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.dynamic.child.AdProxyChild;
import com.slideme.sam.manager.model.p054b.C1827a;
import com.slideme.sam.manager.model.p054b.C1828b;
import com.slideme.sam.manager.util.C1922m;
import java.util.Hashtable;

/* compiled from: ActivityHelper */
class C1701c implements C1700p {
    private final /* synthetic */ Activity f2898a;
    private final /* synthetic */ Application f2899b;
    private final /* synthetic */ boolean f2900c;

    C1701c(Activity activity, Application application, boolean z) {
        this.f2898a = activity;
        this.f2899b = application;
        this.f2900c = z;
    }

    public void mo4255a(Hashtable<String, AdProxyChild> hashtable, boolean z) {
        boolean z2 = true;
        C1922m.m5797b("AdProxy", "getInstallState: " + String.valueOf(C1827a.m5491a(this.f2898a, this.f2899b.packageName, this.f2899b.versionCode) != C1828b.UP_TO_DATE));
        C1922m.m5797b("AdProxy", "containsKey: " + String.valueOf(hashtable.containsKey(this.f2899b.packageName)));
        C1922m.m5797b("AdProxy", "skipHijack: " + String.valueOf(this.f2900c));
        C1922m.m5797b("AdProxy", "disableOffersHijacking: " + String.valueOf(SAM.f2619l.m5432f()));
        boolean containsKey = hashtable.containsKey(this.f2899b.packageName);
        if (C1827a.m5491a(this.f2898a, this.f2899b.packageName, this.f2899b.versionCode) == C1828b.UP_TO_DATE || !containsKey || this.f2900c || SAM.f2619l.m5432f()) {
            z2 = false;
        }
        C1922m.m5797b("AdProxy", "Hijack: " + String.valueOf(z2));
        AdProxyChild adProxyChild;
        Intent intent;
        if (z2) {
            adProxyChild = (AdProxyChild) hashtable.get(this.f2899b.packageName);
            C1922m.m5797b("AdProxy", "ClickUrl: " + String.valueOf(adProxyChild.clickUrl));
            intent = new Intent(this.f2898a, AdProxyWebViewActivity.class);
            intent.putExtra("com.slideme.sam.manager.EXTRA_DESTINATION_URL", adProxyChild.clickUrl);
            intent.putExtra("com.slideme.sam.manager.EXTRA_SAM_AVAILABLE_AD", adProxyChild.samAvailable);
            intent.putExtra("com.slideme.sam.manager.EXTRA_ADSLOT_ID", adProxyChild.adslotId);
            intent.putExtra("com.slideme.sam.manager.EXTRA_NETWORK_ID", adProxyChild.network);
            intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_ID", adProxyChild.offerId);
            intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_SHARE", adProxyChild.platform.contains("ios"));
            intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_PAYOUT", adProxyChild.payout);
            intent.putExtra("com.slideme.sam.manager.EXTRA_PACKAGE_NAME", this.f2899b.packageName);
            this.f2898a.startActivity(intent);
            this.f2898a.overridePendingTransition(0, 0);
        } else {
            intent = new Intent(this.f2898a, ApplicationDetailsActivity.class);
            intent.putExtra("com.slideme.sam.manager.EXTRA_BUNDLE_ID", this.f2899b.bundleId);
            intent.putExtra("com.slideme.sam.manager.EXTRA_TOKEN", this.f2899b.token);
            if (containsKey) {
                adProxyChild = (AdProxyChild) hashtable.get(this.f2899b.packageName);
                intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_SHARE", adProxyChild.platform.contains("ios"));
                intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_ID", adProxyChild.offerId);
                intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_PAYOUT", adProxyChild.payout);
            }
            this.f2898a.startActivity(intent);
        }
        this.f2898a.runOnUiThread(new C1702d(this, this.f2898a, z));
    }
}
