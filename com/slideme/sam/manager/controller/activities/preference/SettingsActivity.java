package com.slideme.sam.manager.controller.activities.preference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceActivity.Header;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.util.C1914e;
import java.lang.reflect.Method;
import java.util.List;

public class SettingsActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener {
    protected Method f2876a = null;
    protected Method f2877b = null;

    public void onBuildHeaders(List<Header> list) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        C1698a.m5059a((Activity) this, true, null);
        return true;
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        try {
            this.f2876a = getClass().getMethod("loadHeadersFromResource", new Class[]{Integer.TYPE, List.class});
            this.f2877b = getClass().getMethod("hasHeaders", new Class[0]);
        } catch (NoSuchMethodException e) {
        }
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences_general);
        addPreferencesFromResource(R.xml.preferences_local);
        addPreferencesFromResource(R.xml.preferences_parental_control);
        addPreferencesFromResource(R.xml.preferences_cache);
        addPreferencesFromResource(R.xml.preferences_advanced);
        if (bundle == null) {
            m5029a();
        }
        m5030b();
        try {
            z = getResources().getBoolean(R.bool.show_ads_switch_in_prefs);
        } catch (NotFoundException e2) {
            if (C1914e.f3493a) {
                e2.printStackTrace();
            }
            z = true;
        }
        if (!z) {
            getPreferenceScreen().removePreference(findPreference(getString(R.string.key_settings_show_only_apps_without_ads)));
        }
        getPreferenceManager();
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
    }

    protected void onDestroy() {
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    private void m5029a() {
        SAM.f2617j.m5515a(SAM.f2617j.m5516a());
    }

    private void m5030b() {
        boolean z;
        boolean z2 = false;
        boolean e = SAM.f2617j.m5522e();
        findPreference(getString(R.string.key_settings_unlock_parental)).setEnabled(e);
        Preference findPreference = findPreference(getString(R.string.key_settings_parental_checklist));
        if (e) {
            z = false;
        } else {
            z = true;
        }
        findPreference.setEnabled(z);
        findPreference = findPreference(getString(R.string.key_settings_use_pin_to_download));
        if (e) {
            z = false;
        } else {
            z = true;
        }
        findPreference.setEnabled(z);
        Preference findPreference2 = findPreference(getString(R.string.key_settings_manage_pin));
        if (!e) {
            z2 = true;
        }
        findPreference2.setEnabled(z2);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals(getString(R.string.key_settings_unlock_parental))) {
            m5030b();
        }
    }
}
