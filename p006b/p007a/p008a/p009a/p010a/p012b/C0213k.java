package p006b.p007a.p008a.p009a.p010a.p012b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: ApiKey */
public class C0213k {
    public String m1889a(Context context) {
        Object b = m1890b(context);
        if (TextUtils.isEmpty(b)) {
            b = m1891c(context);
        }
        if (TextUtils.isEmpty(b)) {
            m1892d(context);
        }
        return b;
    }

    protected String m1890b(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                str = bundle.getString("io.fabric.ApiKey");
                if (str == null) {
                    C0326f.m2298h().mo511a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                    str = bundle.getString("com.crashlytics.ApiKey");
                }
            }
        } catch (Exception e) {
            C0326f.m2298h().mo511a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
        }
        return str;
    }

    protected String m1891c(Context context) {
        int a = C0214m.m1894a(context, "io.fabric.ApiKey", "string");
        if (a == 0) {
            C0326f.m2298h().mo511a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a = C0214m.m1894a(context, "com.crashlytics.ApiKey", "string");
        }
        if (a != 0) {
            return context.getResources().getString(a);
        }
        return null;
    }

    protected void m1892d(Context context) {
        if (C0326f.m2299i() || C0214m.m1932i(context)) {
            throw new IllegalArgumentException(m1888a());
        }
        C0326f.m2298h().mo518e("Fabric", m1888a());
    }

    protected String m1888a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }
}
