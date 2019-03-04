package com.slideme.sam.manager.model.p061a;

import android.content.Context;
import com.google.android.gms.fitness.FitnessActivities;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

/* compiled from: CountryResolver */
public class C1813a {
    private Context f3244a;
    private String f3245b = FitnessActivities.UNKNOWN;
    private AsyncHttpClient f3246c = new AsyncHttpClient();

    public C1813a(Context context) {
        this.f3244a = context;
        try {
            this.f3245b = this.f3244a.getSharedPreferences("countryresolver_preferences", 0).getString("countryResolverCountry", context.getResources().getConfiguration().locale.getCountry());
        } catch (Exception e) {
            this.f3245b = FitnessActivities.UNKNOWN;
        }
    }

    public String m5421a() {
        m5422b();
        return this.f3245b;
    }

    public void m5422b() {
        if (m5419c()) {
            this.f3246c.post("https://geoip.slideme.org/slidegeoip.php", new RequestParams("key", "1ab7a877-05f1-4042-ae2a-f6d5687bd8db"), new C1814b(this));
        }
    }

    private boolean m5419c() {
        return System.currentTimeMillis() - m5420d() > 86400000;
    }

    private long m5420d() {
        return this.f3244a.getSharedPreferences("countryresolver_preferences", 0).getLong("countryResolverLastUpdate", 0);
    }
}
