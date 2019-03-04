package com.slideme.sam.manager.model.p061a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import com.slideme.sam.manager.R;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: PreferenceHelper */
public class C1817e {
    private SharedPreferences f3251a;
    private Resources f3252b;

    public C1817e(Context context) {
        this.f3251a = PreferenceManager.getDefaultSharedPreferences(context);
        this.f3252b = context.getResources();
    }

    public void m5441a(String str, boolean z) {
        Editor edit = this.f3251a.edit();
        edit.putBoolean("fbsharedialogshow_" + str, z);
        edit.commit();
    }

    public boolean m5444a(String str) {
        return this.f3251a.getBoolean("fbsharedialogshow_" + str, true);
    }

    public void m5442a(boolean z) {
        Editor edit = this.f3251a.edit();
        edit.putBoolean("httpOnly", z);
        edit.putBoolean("httpOnlyChecked", true);
        edit.commit();
    }

    public boolean m5443a() {
        return this.f3251a.getBoolean("httpOnly", false);
    }

    public boolean m5445b() {
        return !this.f3251a.getBoolean("httpOnlyChecked", false);
    }

    public int m5446c() {
        return this.f3251a.getInt(this.f3252b.getString(R.string.key_settings_general_apps_per_page), this.f3252b.getInteger(R.integer.default_settings_general_apps_per_page));
    }

    public int m5447d() {
        return Integer.parseInt(this.f3251a.getString(this.f3252b.getString(R.string.key_settings_theme), String.valueOf(this.f3252b.getInteger(R.integer.default_settings_general_theme))));
    }

    public boolean m5448e() {
        return this.f3251a.getBoolean(this.f3252b.getString(R.string.key_settings_limit_screenshots), this.f3252b.getBoolean(R.bool.default_settings_general_limit_screenshots));
    }

    public int m5449f() {
        return this.f3251a.getInt(this.f3252b.getString(R.string.key_settings_screenshot_count), this.f3252b.getInteger(R.integer.default_settings_general_screenshot_count));
    }

    public boolean m5450g() {
        return this.f3251a.getBoolean(this.f3252b.getString(R.string.key_settings_advanced_auto_download_new_version), this.f3252b.getBoolean(R.bool.default_settings_advanced_auto_download_new_version));
    }

    public String m5451h() {
        return this.f3251a.getString(this.f3252b.getString(R.string.key_settings_general_country), Locale.getDefault().getCountry());
    }

    public String m5452i() {
        return this.f3251a.getString(this.f3252b.getString(R.string.key_settings_general_language), Locale.getDefault().getLanguage());
    }

    public boolean m5453j() {
        return this.f3251a.getBoolean(this.f3252b.getString(R.string.key_settings_advanced_show_incompatible_apps), this.f3252b.getBoolean(R.bool.default_settings_advanced_show_incompatible_apps));
    }

    public boolean m5454k() {
        return this.f3251a.getBoolean(this.f3252b.getString(R.string.key_settings_show_only_apps_without_ads), this.f3252b.getBoolean(R.bool.default_show_only_apps_without_ads));
    }

    public static void m5440a(Editor editor, String str, Set<String> set) {
        editor.putInt(new StringBuilder(String.valueOf(str)).append("_count").toString(), set.size());
        int i = 0;
        for (String str2 : set) {
            StringBuilder append = new StringBuilder(String.valueOf(str)).append("_");
            int i2 = i + 1;
            editor.putString(append.append(i).toString(), str2);
            i = i2;
        }
        editor.commit();
    }

    public static Set<String> m5439a(SharedPreferences sharedPreferences, String str, Set<String> set) {
        int i = sharedPreferences.getInt(new StringBuilder(String.valueOf(str)).append("_count").toString(), -1);
        if (i != -1) {
            set = new HashSet(i);
            for (int i2 = 0; i2 < i; i2++) {
                set.add(sharedPreferences.getString(new StringBuilder(String.valueOf(str)).append("_").append(i2).toString(), ""));
            }
        }
        return set;
    }
}
