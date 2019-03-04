package com.mopub.common.p050b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.mopub.common.MoPubBrowser;
import com.mopub.mobileads.MoPubActivity;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ManifestUtils */
public class C1485h {
    private static final List<Class<? extends Activity>> f2148a = new ArrayList(4);
    private static final List<Class<? extends Activity>> f2149b = new ArrayList(1);

    static {
        f2148a.add(MoPubActivity.class);
        f2148a.add(MraidActivity.class);
        f2148a.add(MraidVideoPlayerActivity.class);
        f2148a.add(MoPubBrowser.class);
        f2149b.add(MoPubBrowser.class);
    }

    public static void m4071a(Context context) {
        C1485h.m4072a(context, f2148a);
    }

    static void m4072a(Context context, List<Class<? extends Activity>> list) {
        if (context != null) {
            List b = C1485h.m4074b(context, list);
            if (!b.isEmpty()) {
                if (C1485h.m4075b(context)) {
                    String str = "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities.";
                    Toast makeText = Toast.makeText(context, "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities.", 1);
                    makeText.setGravity(7, 0, 0);
                    makeText.show();
                }
                C1485h.m4073a(b);
            }
        }
    }

    static boolean m4075b(Context context) {
        if (context == null || context.getApplicationInfo() == null) {
            return false;
        }
        return C1492o.m4091a(context.getApplicationInfo().flags, 2);
    }

    private static List<String> m4074b(Context context, List<Class<? extends Activity>> list) {
        List<String> arrayList = new ArrayList();
        for (Class cls : list) {
            if (!C1483f.m4063a(context, new Intent(context, cls))) {
                arrayList.add(cls.getName());
            }
        }
        return arrayList;
    }

    private static void m4073a(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder("AndroidManifest permissions for the following required MoPub activities are missing:\n");
        for (String append : list) {
            stringBuilder.append("\n\t").append(append);
        }
        stringBuilder.append("\n\nPlease update your manifest to include them.");
        C1486i.m4078b(stringBuilder.toString());
    }
}
