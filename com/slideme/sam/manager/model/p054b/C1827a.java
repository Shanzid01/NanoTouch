package com.slideme.sam.manager.model.p054b;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.InstalledApplication;
import com.slideme.sam.manager.util.C1914e;
import com.slideme.sam.manager.util.C1920k;
import com.slideme.sam.manager.util.C1922m;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

/* compiled from: ApplicationUtils */
public abstract class C1827a {
    public static C1828b m5491a(Context context, String str, int i) {
        try {
            if (i > context.getPackageManager().getPackageInfo(str, 128).versionCode) {
                return C1828b.NEEDS_UPDATE;
            }
            return C1828b.UP_TO_DATE;
        } catch (NameNotFoundException e) {
            return C1828b.NOT_INSTALLED;
        }
    }

    public static void m5494a(Context context, Application application) {
        if (application.packageName != null && application.className != null) {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(application.packageName);
                if (launchIntentForPackage != null) {
                    context.startActivity(launchIntentForPackage);
                    C1922m.m5799c(context);
                    return;
                }
                C1920k.m5781a(context, (int) R.string.application_not_launchable, 0).show();
            } catch (ActivityNotFoundException e) {
            } catch (Exception e2) {
                C1922m.m5790a(e2);
            }
        }
    }

    public static boolean m5497a(Application application, C1831e c1831e) {
        int i;
        boolean z = true;
        int i2 = 0;
        application.isCompatible = true;
        try {
            JSONArray jSONArray = new JSONArray(application.compatibility.features);
            i = 0;
            while (i < jSONArray.length()) {
                if (c1831e.m5509a(jSONArray.getString(i))) {
                    i++;
                } else {
                    application.isCompatible = false;
                    application.compatibilityMessage = application.getName() + " requires feature " + jSONArray.getString(i);
                    if (C1914e.f3493a) {
                        Log.i("Compatibility checker", application.getName() + " incompatible because of feature: " + jSONArray.getString(i));
                    }
                    return application.isCompatible;
                }
            }
        } catch (Throwable e) {
            C1922m.m5791a(e);
        }
        application.isCompatible &= c1831e.m5508a(application);
        if (application.isCompatible) {
            try {
                JSONArray jSONArray2 = new JSONArray(application.compatibility.configurations);
                if (jSONArray2.length() != 0) {
                    z = false;
                }
                i = 0;
                while (i < jSONArray2.length() && !z) {
                    boolean b = c1831e.m5511b(jSONArray2.getString(i));
                    i++;
                    z = b;
                }
                application.isCompatible &= z;
                if (!application.isCompatible) {
                    application.compatibilityMessage = application.getName() + " requires a configuration missing from your device";
                    if (!C1914e.f3493a) {
                        return z;
                    }
                    Log.i("Compatibility checker", application.getName() + " incompatible because of configuration");
                    return z;
                }
            } catch (Throwable e2) {
                C1922m.m5791a(e2);
            }
            try {
                JSONArray jSONArray3 = new JSONArray(application.compatibility.libraries);
                while (i2 < jSONArray3.length()) {
                    if (c1831e.m5513c(jSONArray3.getString(i2))) {
                        i2++;
                    } else {
                        application.isCompatible = false;
                        application.compatibilityMessage = application.getName() + " incompatible because of library: " + jSONArray3.getString(i2);
                        if (C1914e.f3493a) {
                            Log.i("Compatibility checker", application.getName() + " incompatible because of library: " + jSONArray3.getString(i2));
                        }
                        return application.isCompatible;
                    }
                }
            } catch (Throwable e22) {
                C1922m.m5791a(e22);
            }
            return application.isCompatible;
        }
        application.compatibilityMessage = application.getName() + " isn't matching your screen configuration";
        if (C1914e.f3493a) {
            Log.i("Compatibility checker", application.getName() + " incompatible because of screen config");
        }
        return application.isCompatible;
    }

    public static ArrayList<InstalledApplication> m5493a(Context context) {
        ArrayList<InstalledApplication> arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(1)) {
            if (!C1827a.m5496a(applicationInfo)) {
                arrayList.add(new InstalledApplication(applicationInfo.packageName, packageManager.getApplicationLabel(applicationInfo)));
            }
        }
        return arrayList;
    }

    public static void m5495a(Context context, String str) {
        C1922m.m5797b("AutoDownload", "AutoDownload completed");
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(str, true);
        edit.commit();
    }

    public static boolean m5498b(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, false);
    }

    private static boolean m5496a(ApplicationInfo applicationInfo) {
        return (129 & applicationInfo.flags) != 0;
    }

    public static Application m5492a(ArrayList<Application> arrayList, String str) {
        if (arrayList == null || arrayList.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Application application = (Application) it.next();
            if (application.packageName.equals(str)) {
                return application;
            }
        }
        return null;
    }
}
