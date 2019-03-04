package com.slideme.sam.manager.controller.fragment.p056a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.AdapterView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.net.wrappers.C1896f;
import com.slideme.sam.manager.net.wrappers.Catalog;

/* compiled from: LocalApplicationListFragment */
public class C1734z extends C1708i implements OnSharedPreferenceChangeListener {
    private SharedPreferences f2976a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2976a = PreferenceManager.getDefaultSharedPreferences(getActivity());
        this.f2976a.registerOnSharedPreferenceChangeListener(this);
    }

    protected void mo4257a(Catalog catalog) {
        catalog.m5675c(new StringBuilder(String.valueOf(SAM.f2613f.m5452i())).append("_").append(SAM.f2613f.m5451h()).toString());
        catalog.m5662a(C1896f.Local);
    }

    public void onDestroy() {
        this.f2976a.unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals(getString(R.string.key_settings_general_country)) || str.equals(getString(R.string.key_settings_general_language))) {
            this.g.m5675c(new StringBuilder(String.valueOf(SAM.f2613f.m5452i())).append("_").append(SAM.f2613f.m5451h()).toString());
            this.h = true;
        }
    }

    void mo4256a(AdapterView<?> adapterView, int i) {
        if (!this.d.m5844a() || i != this.d.getCount() - 1) {
            C1698a.m5055a(getActivity(), (Application) adapterView.getAdapter().getItem(i));
        }
    }
}
