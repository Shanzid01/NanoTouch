package com.slideme.sam.manager.model.p061a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.market.product.ApplicationDetailsActivity;
import com.slideme.sam.manager.controller.activities.preference.SettingsActivity;
import com.slideme.sam.manager.net.response.DailyServiceResponse;

/* compiled from: DailyServiceManager */
public class C1815c {
    private Context f3248a;
    private float f3249b = 0.0f;

    public C1815c(Context context) {
        this.f3248a = context;
    }

    public void m5425a(DailyServiceResponse dailyServiceResponse) {
        Editor edit = this.f3248a.getSharedPreferences("dailyServiceManager_preferences", 0).edit();
        edit.putLong("dailyServiceManagerLastRun", System.currentTimeMillis());
        if (dailyServiceResponse.daily != null) {
            edit.putBoolean("adsEnabledGlobal", dailyServiceResponse.daily.enableAds);
            edit.putBoolean("adsEnabledFreeApsWithAds", dailyServiceResponse.daily.enableAdsFreeWithAds);
            edit.putBoolean("offersEnabled", dailyServiceResponse.daily.offers);
            edit.putString("offersSource", dailyServiceResponse.daily.offersSource);
            edit.putBoolean("offersHijackDisabled", dailyServiceResponse.daily.offersHijackDisable);
            edit.putFloat("rewardsPercent", dailyServiceResponse.daily.rewardPercent);
            if (dailyServiceResponse.daily.notification != null) {
                edit.putString("notificationMessage", dailyServiceResponse.daily.notification.message);
                edit.putBoolean("notificationSticky", dailyServiceResponse.daily.notification.sticky);
                edit.putString("notificationActivity", dailyServiceResponse.daily.notification.action);
            }
        }
        edit.commit();
    }

    public boolean m5426a() {
        return System.currentTimeMillis() - m5423j() > 86400000;
    }

    private long m5423j() {
        return this.f3248a.getSharedPreferences("dailyServiceManager_preferences", 0).getLong("dailyServiceManagerLastRun", 0);
    }

    public float m5428b() {
        if (this.f3249b > 0.0f) {
            return this.f3249b;
        }
        return this.f3248a.getSharedPreferences("dailyServiceManager_preferences", 0).getFloat("rewardsPercent", 50.0f);
    }

    public boolean m5429c() {
        if (this.f3248a.getResources().getBoolean(R.bool.forceHideAds)) {
            return false;
        }
        return this.f3248a.getSharedPreferences("dailyServiceManager_preferences", 0).getBoolean("adsEnabledGlobal", false) || this.f3248a.getResources().getBoolean(R.bool.forceShowAds);
    }

    public boolean m5430d() {
        return this.f3248a.getSharedPreferences("dailyServiceManager_preferences", 0).getBoolean("adsEnabledFreeApsWithAds", false) || this.f3248a.getResources().getBoolean(R.bool.forceShowAds);
    }

    public boolean m5427a(boolean z) {
        return m5429c() || (m5430d() && z);
    }

    public boolean m5431e() {
        return this.f3248a.getSharedPreferences("dailyServiceManager_preferences", 0).getBoolean("offersEnabled", true) || this.f3248a.getResources().getBoolean(R.bool.forceShowOffers);
    }

    public boolean m5432f() {
        return this.f3248a.getSharedPreferences("dailyServiceManager_preferences", 0).getBoolean("offersHijackDisabled", false);
    }

    public String m5433g() {
        return this.f3248a.getSharedPreferences("dailyServiceManager_preferences", 0).getString("offersSource", "");
    }

    public String m5434h() {
        return this.f3248a.getSharedPreferences("dailyServiceManager_preferences", 0).getString("notificationMessage", "");
    }

    public Intent m5424a(Context context) {
        Uri parse = Uri.parse(this.f3248a.getSharedPreferences("dailyServiceManager_preferences", 0).getString("notificationActivity", ""));
        String scheme = parse.getScheme();
        if ("activity".equals(scheme)) {
            scheme = parse.getHost();
            if ("details".equals(scheme)) {
                return new Intent(context, ApplicationDetailsActivity.class).putExtra("com.slideme.sam.manager.EXTRA_BUNDLE_ID", parse.getLastPathSegment());
            } else if ("settings".equals(scheme)) {
                return new Intent(context, SettingsActivity.class);
            } else {
                return null;
            }
        } else if ("http".equals(scheme)) {
            return new Intent("android.intent.action.VIEW").setData(parse);
        } else {
            return null;
        }
    }

    public boolean m5435i() {
        return this.f3248a.getSharedPreferences("dailyServiceManager_preferences", 0).getBoolean("notificationSticky", false);
    }
}
