package com.slideme.sam.manager.inapp.openiab.p058a;

import android.util.Log;
import com.google.android.gms.plus.PlusShare;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SkuDetails */
public class C1799a {
    String f3232a;
    String f3233b;
    String f3234c;
    String f3235d;
    String f3236e;

    public C1799a(String str, String str2, String str3, String str4, String str5) {
        this.f3233b = str;
        this.f3232a = str2;
        this.f3235d = str3;
        this.f3234c = str4;
        this.f3236e = str5;
    }

    public String m5382a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("productId", this.f3232a);
            jSONObject.put("type", this.f3233b);
            jSONObject.put("price", this.f3234c);
            jSONObject.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.f3235d);
            jSONObject.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.f3236e);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.e("SlideME", "Couldn't serialize " + getClass().getSimpleName());
            return "";
        }
    }

    public String toString() {
        return String.format("SkuDetails: type = %s, SKU = %s, title = %s, price = %s, description = %s", new Object[]{this.f3233b, this.f3232a, this.f3235d, this.f3234c, this.f3236e});
    }
}
