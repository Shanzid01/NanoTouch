package com.slideme.sam.manager.view.preference;

import android.app.Activity;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.slideme.sam.manager.controller.p055b.C1698a;

/* compiled from: ThemePreference */
class C1966h implements OnPreferenceChangeListener {
    final /* synthetic */ ThemePreference f3644a;

    C1966h(ThemePreference themePreference) {
        this.f3644a = themePreference;
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        C1698a.m5059a((Activity) this.f3644a.getContext(), false, null);
        return true;
    }
}
