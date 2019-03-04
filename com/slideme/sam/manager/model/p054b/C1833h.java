package com.slideme.sam.manager.model.p054b;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.p061a.C1817e;
import com.slideme.sam.manager.util.p063a.C1908b;
import java.util.Set;

/* compiled from: ParentalControlHelper */
public class C1833h {
    private SharedPreferences f3287a;
    private Resources f3288b;

    public C1833h(SharedPreferences sharedPreferences, Resources resources) {
        this.f3288b = resources;
        this.f3287a = sharedPreferences;
    }

    public boolean m5516a() {
        return this.f3287a.getString(this.f3288b.getString(R.string.key_settings_pin), null) != null;
    }

    public boolean m5517a(String str) {
        if (str != null) {
            return str.equals(this.f3287a.getString(this.f3288b.getString(R.string.key_settings_pin), null));
        }
        throw new NullPointerException("checkPin() input can't be null");
    }

    public void m5518b() {
        this.f3287a.edit().remove(this.f3288b.getString(R.string.key_settings_pin)).commit();
    }

    public int[] m5520c() {
        Set a;
        if (VERSION.SDK_INT >= 11) {
            a = C1908b.m5747a(this.f3287a, this.f3288b.getString(R.string.key_settings_parental_checklist), null);
        } else {
            a = C1817e.m5439a(this.f3287a, this.f3288b.getString(R.string.key_settings_parental_checklist), null);
        }
        if (r1 == null || r1.size() == 0) {
            return new int[1];
        }
        int[] iArr = new int[r1.size()];
        int i = 0;
        for (String parseInt : r1) {
            iArr[i] = Integer.parseInt(parseInt);
            i++;
        }
        return iArr;
    }

    public void m5519b(String str) {
        this.f3287a.edit().putString(this.f3288b.getString(R.string.key_settings_pin), str).commit();
    }

    public boolean m5521d() {
        return this.f3287a.getBoolean(this.f3288b.getString(R.string.key_settings_use_pin_to_download), this.f3288b.getBoolean(R.bool.default_settings_parental_use_pin_to_download)) && m5516a();
    }

    public boolean m5522e() {
        return this.f3287a.getBoolean(this.f3288b.getString(R.string.key_settings_unlock_parental), false);
    }

    public void m5515a(boolean z) {
        this.f3287a.edit().putBoolean(this.f3288b.getString(R.string.key_settings_unlock_parental), z).commit();
    }

    public boolean m5523f() {
        return this.f3287a.getBoolean(this.f3288b.getString(R.string.key_settings_pin_for_purchases_only), this.f3288b.getBoolean(R.bool.default_settings_pin_for_purchases_only));
    }
}
