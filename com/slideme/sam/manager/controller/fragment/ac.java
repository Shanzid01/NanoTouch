package com.slideme.sam.manager.controller.fragment;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;

/* compiled from: CategoryListFragment */
class ac implements OnSharedPreferenceChangeListener {
    final /* synthetic */ aa f3024a;

    ac(aa aaVar) {
        this.f3024a = aaVar;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals(this.f3024a.getString(R.string.key_settings_parental_checklist))) {
            this.f3024a.f3019e.m5666a(SAM.f2617j.m5520c());
            this.f3024a.f3015a = true;
        } else if (str.equals(this.f3024a.getString(R.string.key_settings_advanced_show_incompatible_apps))) {
            this.f3024a.f3019e.m5684e(SAM.f2613f.m5453j());
            this.f3024a.f3015a = true;
        } else if (str.equals(this.f3024a.getString(R.string.key_settings_show_only_apps_without_ads))) {
            this.f3024a.f3019e.m5678d(SAM.f2613f.m5454k() ? 0 : -1);
            this.f3024a.f3015a = true;
        }
    }
}
