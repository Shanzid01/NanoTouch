package com.slideme.sam.manager.controller.fragment.p056a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;

/* compiled from: ApplicationListFragment */
class C1720k implements OnSharedPreferenceChangeListener {
    final /* synthetic */ C1708i f2964a;

    C1720k(C1708i c1708i) {
        this.f2964a = c1708i;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals(this.f2964a.getString(R.string.key_settings_parental_checklist))) {
            this.f2964a.f2910g.m5666a(SAM.f2617j.m5520c());
            this.f2964a.f2911h = true;
        } else if (str.equals(this.f2964a.getString(R.string.key_settings_advanced_show_incompatible_apps))) {
            this.f2964a.f2910g.m5684e(SAM.f2613f.m5453j());
            this.f2964a.f2911h = true;
        } else if (str.equals(this.f2964a.getString(R.string.key_settings_show_only_apps_without_ads))) {
            this.f2964a.f2910g.m5678d(SAM.f2613f.m5454k() ? 0 : -1);
            this.f2964a.f2911h = true;
        }
    }
}
