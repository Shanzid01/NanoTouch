package com.slideme.sam.manager.net.wrappers;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.p054b.C1829c;
import com.slideme.sam.manager.util.C1922m;
import java.io.File;
import java.net.URLEncoder;

/* compiled from: SamDownloader */
public class C1905r extends C1892h {
    public C1905r(SAM sam) {
        super(sam, C1905r.m5743a(sam), C1905r.m5744b(sam));
    }

    public static String m5744b(Context context) {
        return C1892h.m5700a(context) + File.separator + "SAM.apk";
    }

    private static String m5743a(SAM sam) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = sam.getPackageManager().getPackageInfo(sam.getPackageName(), 0);
        } catch (Throwable e) {
            C1922m.m5791a(e);
        }
        StringBuilder stringBuilder = new StringBuilder(SAM.f2608a);
        stringBuilder.append("/sam-download?");
        try {
            stringBuilder.append("device=").append(URLEncoder.encode(C1829c.m5500b(), "UTF-8")).append('_').append(URLEncoder.encode(C1829c.m5499a(), "UTF-8"));
        } catch (Throwable e2) {
            C1922m.m5791a(e2);
        }
        stringBuilder.append("&region=misc");
        stringBuilder.append("&language=misc");
        stringBuilder.append("&api_level=").append(C1829c.m5504f());
        stringBuilder.append("&partner=").append(sam.m4780d());
        if (packageInfo != null) {
            stringBuilder.append("&version_code=").append(packageInfo.versionCode);
            stringBuilder.append("&version_name=").append(packageInfo.versionName);
        }
        return stringBuilder.toString();
    }
}
