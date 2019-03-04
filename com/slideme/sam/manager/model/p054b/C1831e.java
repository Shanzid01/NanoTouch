package com.slideme.sam.manager.model.p054b;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.util.p063a.C1910d;
import java.util.HashMap;

/* compiled from: FeatureDetector */
public class C1831e {
    private static HashMap<String, Void> f3273c;
    private static HashMap<String, Void> f3274d;
    private Context f3275a;
    private PackageManager f3276b;
    private boolean f3277e = false;

    public C1831e(Context context, boolean z) {
        this.f3275a = context;
        this.f3276b = this.f3275a.getPackageManager();
        this.f3277e = z;
        m5507a();
        m5510b();
    }

    protected HashMap<String, Void> m5507a() {
        if (f3273c == null) {
            FeatureInfo[] systemAvailableFeatures = this.f3276b.getSystemAvailableFeatures();
            f3273c = new HashMap(systemAvailableFeatures.length);
            for (int i = 0; i < systemAvailableFeatures.length; i++) {
                if (systemAvailableFeatures[i].name != null) {
                    f3273c.put(systemAvailableFeatures[i].name, null);
                }
            }
        }
        return f3273c;
    }

    protected HashMap<String, Void> m5510b() {
        if (f3274d == null) {
            String[] systemSharedLibraryNames = this.f3276b.getSystemSharedLibraryNames();
            f3274d = new HashMap(systemSharedLibraryNames.length);
            for (Object put : systemSharedLibraryNames) {
                f3274d.put(put, null);
            }
        }
        return f3274d;
    }

    public boolean m5509a(String str) {
        if (m5506d(str)) {
            return true;
        }
        return f3273c.containsKey(str);
    }

    private boolean m5506d(String str) {
        if (VERSION.SDK_INT > 12 || (!str.equals("android.hardware.screen.landscape") && !str.equals("android.hardware.screen.portrait"))) {
            return false;
        }
        return true;
    }

    public boolean m5511b(String str) {
        int i;
        boolean z;
        int i2 = 1;
        Configuration configuration = this.f3275a.getResources().getConfiguration();
        int i3 = 1 & ((configuration.navigation != 1 ? 1 : 0) == Integer.parseInt(str.substring(0, 1)) ? 1 : 0);
        int parseInt = Integer.parseInt(str.substring(1, 2));
        if (configuration.keyboard != 1) {
            i = 1;
        } else {
            i = 0;
        }
        boolean z2 = i3 & (i == parseInt ? 1 : 0);
        i = Integer.parseInt(str.substring(2, 3));
        if (i != 0) {
            if (configuration.keyboard == i) {
                i = 1;
            } else {
                i = 0;
            }
            z = i & z2;
        } else {
            z = z2;
        }
        i3 = Integer.parseInt(str.substring(3, 4));
        if (i3 != 0) {
            if (configuration.navigation == i3) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            z &= i3;
        }
        i3 = Integer.parseInt(str.substring(4, 5));
        if (i3 == 0) {
            return z;
        }
        if (VERSION.SDK_INT >= 16 && i3 == 2) {
            i3 = 3;
        }
        if (configuration.touchscreen != i3) {
            i2 = 0;
        }
        return z & i2;
    }

    public boolean m5508a(Application application) {
        Configuration configuration = this.f3275a.getResources().getConfiguration();
        if (this.f3277e) {
            return true;
        }
        int i = 1 << ((configuration.screenLayout & 15) - 1);
        boolean z = true & ((application.compatibility.screenCompat.supportedScreens & i) == i ? 1 : 0);
        if (VERSION.SDK_INT >= 13) {
            return z & C1910d.m5754a(configuration, application.compatibility.screenCompat.requiresSmallestWidth);
        }
        return z;
    }

    public boolean m5513c(String str) {
        return f3274d.containsKey(Integer.valueOf(str.hashCode()));
    }

    public boolean m5512c() {
        try {
            this.f3276b.getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
