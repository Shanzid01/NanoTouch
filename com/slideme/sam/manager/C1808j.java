package com.slideme.sam.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.slideme.sam.manager.model.p054b.p062a.C1826c;

/* compiled from: SAM */
class C1808j implements OnSharedPreferenceChangeListener {
    final /* synthetic */ SAM f3240a;

    C1808j(SAM sam) {
        this.f3240a = sam;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals(this.f3240a.getString(R.string.key_settings_currency))) {
            SAM.f2616i.m5489a(sharedPreferences.getString(str, C1826c.m5486b()));
        }
    }
}
