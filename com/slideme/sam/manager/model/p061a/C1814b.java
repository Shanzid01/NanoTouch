package com.slideme.sam.manager.model.p061a;

import android.content.SharedPreferences.Editor;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.json.JSONObject;

/* compiled from: CountryResolver */
class C1814b extends AsyncHttpResponseHandler {
    final /* synthetic */ C1813a f3247a;

    C1814b(C1813a c1813a) {
        this.f3247a = c1813a;
    }

    public void onSuccess(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("geoip")) {
                this.f3247a.f3245b = jSONObject.getJSONObject("geoip").getString("country_code");
                Editor edit = this.f3247a.f3244a.getSharedPreferences("countryresolver_preferences", 0).edit();
                edit.putLong("countryResolverLastUpdate", System.currentTimeMillis());
                edit.putString("countryResolverCountry", this.f3247a.f3245b);
                edit.commit();
            }
        } catch (Exception e) {
        }
    }
}
