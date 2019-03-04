package com.slideme.sam.manager.controller.activities.market.product;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.util.C1922m;

public class ApplicationDetailsProxyActivity extends FlipperFragmentActivity {
    String f2831a;
    String f2832b;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().getData() != null && "android.intent.action.VIEW".equals(getIntent().getAction())) {
            if (!TextUtils.isEmpty(getIntent().getData().getQueryParameter("id"))) {
                this.f2831a = getIntent().getData().getQueryParameter("id");
            } else if (TextUtils.isEmpty(getIntent().getData().getQueryParameter("q"))) {
                C1698a.m5059a((Activity) this, false, null);
                finish();
                overridePendingTransition(0, 0);
                return;
            } else {
                this.f2831a = getIntent().getData().getQueryParameter("q");
            }
            try {
                this.f2832b = getString(R.string.live_channel);
            } catch (ExceptionInInitializerError e) {
                C1922m.m5797b("AdProxy", e.toString());
            }
            C1922m.m5797b("AdProxy", "Got intent: " + getIntent().getData().toString());
            C1922m.m5797b("AdProxy", "Extracted Package: " + this.f2831a);
            new Thread(new C1675a(this)).start();
        }
    }
}
