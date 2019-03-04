package com.slideme.sam.manager.model;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: UserInstanceTracker */
public class C1823a {
    private SharedPreferences f3261a;

    public C1823a(Context context) {
        this.f3261a = context.getSharedPreferences("user_instance", 0);
    }

    public boolean m5476a(String str) {
        if (str.equals(m5474a())) {
            return true;
        }
        m5475b(str);
        return false;
    }

    private String m5474a() {
        return this.f3261a.getString("user_id", "");
    }

    private void m5475b(String str) {
        this.f3261a.edit().putString("user_id", str).commit();
    }
}
