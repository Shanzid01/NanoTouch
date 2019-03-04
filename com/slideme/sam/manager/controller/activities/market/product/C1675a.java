package com.slideme.sam.manager.controller.activities.market.product;

import android.text.TextUtils;
import com.google.android.gms.fitness.FitnessActivities;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.net.wrappers.C1891a;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: ApplicationDetailsProxyActivity */
class C1675a implements Runnable {
    final /* synthetic */ ApplicationDetailsProxyActivity f2848a;

    C1675a(ApplicationDetailsProxyActivity applicationDetailsProxyActivity) {
        this.f2848a = applicationDetailsProxyActivity;
    }

    public void run() {
        if (TextUtils.isEmpty(this.f2848a.f2832b)) {
            this.f2848a.f2832b = FitnessActivities.UNKNOWN;
        }
        C1891a c1891a = new C1891a(this.f2848a.f2831a, true, true, this.f2848a.f2832b);
        c1891a.m5698b();
        if (this.f2848a != null) {
            if (c1891a.m5697a() == null || c1891a.m5697a().isEmpty()) {
                C1698a.m5059a(this.f2848a, false, null);
                C1922m.m5797b("AdProxy", "Application " + this.f2848a.f2831a + " not found");
            } else {
                this.f2848a.runOnUiThread(new C1676b(this, (Application) c1891a.m5697a().get(0)));
            }
            this.f2848a.finish();
            this.f2848a.overridePendingTransition(0, 0);
        }
    }
}
