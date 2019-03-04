package com.slideme.sam.manager.controller.fragment.p057b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.inapp.InAppService;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: SAMJavaScriptInterface */
public class C1741f {
    public static final String NAME = "SAM";
    private static final String f3090b = C1741f.class.getName();
    Activity f3091a;

    public C1741f(Activity activity) {
        this.f3091a = activity;
    }

    @JavascriptInterface
    public void closeQuestionnaire() {
        C1922m.m5797b(f3090b, "closeQuestionnaire");
        AuthData.m4804a(this.f3091a, false);
        C1698a.m5059a(this.f3091a, true, null);
        this.f3091a.finish();
    }

    @JavascriptInterface
    public void notifyIapPurchase(int i, String str, String str2) {
        C1922m.m5797b(f3090b, "notifyIapPurchase");
        C1922m.m5797b(f3090b, "status: " + String.valueOf(i));
        C1922m.m5797b(f3090b, "data: " + str);
        C1922m.m5797b(f3090b, "signature: " + str2);
        if (i == 0) {
            this.f3091a.setResult(0);
        } else {
            Intent intent = new Intent();
            Bundle a = InAppService.m5342a(i);
            if (i == 1) {
                a.putString("com.slideme.sam.manager.inapp.BUNDLE_PURCHASE_DATA", str);
                a.putString("com.slideme.sam.manager.inapp.BUNDLE_SIGNATURE", str2);
            }
            intent.putExtra("com.slideme.sam.manager.inapp.extra.RESPONSE", a);
            this.f3091a.setResult(-1, intent);
        }
        this.f3091a.finish();
    }
}
