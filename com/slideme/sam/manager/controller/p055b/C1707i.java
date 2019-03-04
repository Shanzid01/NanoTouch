package com.slideme.sam.manager.controller.p055b;

import android.app.Activity;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;

/* compiled from: WebViewUtils */
public class C1707i {
    public static boolean m5085a(String str, Activity activity) {
        if (activity != null) {
            for (String startsWith : activity.getResources().getStringArray(R.array.default_webbuy_trusted_hosts)) {
                if (str.startsWith(startsWith)) {
                    return true;
                }
            }
            for (String startsWith2 : ((SAM) activity.getApplication()).m4778b()) {
                if (str.startsWith(startsWith2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String m5084a(Activity activity, String str) {
        return new StringBuilder(String.valueOf(str)).append(str.contains("=") ? "&" : "?").append("theme=").append(C1707i.m5083a(activity)).append(str.contains("samstaging") ? "&theme_default=slideme_sam" : "").append("&partner=").append(activity.getString(R.string.live_channel)).append("&language=").append(activity.getResources().getConfiguration().locale.getLanguage()).toString();
    }

    public static String m5083a(Activity activity) {
        try {
            return activity.getResources().getStringArray(R.array.themeEntries)[SAM.f2613f.m5447d()].toLowerCase();
        } catch (Exception e) {
            return "light";
        }
    }
}
