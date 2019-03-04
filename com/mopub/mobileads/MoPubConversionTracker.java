package com.mopub.mobileads;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.mopub.common.C1508p;
import com.mopub.common.ae;

public class MoPubConversionTracker {
    private Context f2322a;
    private String f2323b;
    private SharedPreferences f2324c;
    private String f2325d;
    private ac f2326e = new ac(this);

    public void m4336a(Context context) {
        if (context != null) {
            this.f2322a = context;
            this.f2325d = this.f2322a.getPackageName();
            this.f2323b = this.f2325d + " tracked";
            this.f2324c = ae.m4049a(this.f2322a);
            if (m4332a()) {
                Log.d("MoPub", "Conversion already tracked");
            } else {
                C1508p.m4144b(this.f2322a, this.f2326e);
            }
        }
    }

    private boolean m4332a() {
        return this.f2324c.getBoolean(this.f2323b, false);
    }
}
