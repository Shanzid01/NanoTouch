package com.slideme.sam.manager.net.wrappers;

import android.content.Context;
import android.text.TextUtils;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.p054b.C1829c;
import com.slideme.sam.manager.util.C1922m;
import java.io.File;

/* compiled from: ApplicationFileDownloader */
public class C1893b extends C1892h {
    private Application f3475b;
    private boolean f3476c;

    public C1893b(Application application, boolean z, Context context, C1856m c1856m) {
        super(context, C1893b.m5712b(application, context), C1893b.m5711a(application, context), c1856m);
        this.f3476c = z;
        this.f3475b = application;
    }

    public Application mo4318a() {
        return this.f3475b;
    }

    public boolean mo4319b() {
        return this.f3476c;
    }

    private static String m5711a(Application application, Context context) {
        String a;
        if (application.price <= 0.0d || C1829c.m5504f() >= 21) {
            a = C1892h.m5700a(context);
        } else {
            a = context.getFilesDir().getAbsolutePath();
        }
        File file = new File(a, application.bundleId + ".apk");
        if (!C1922m.m5792a((application.size * 3) + 10240, file)) {
            return null;
        }
        application.localFilePath = file.getAbsolutePath();
        return file.getAbsolutePath();
    }

    private static String m5712b(Application application, Context context) {
        return context.getString(R.string.SLIDEME_SERVICES_URL) + "/mobileapp/download/" + application.bundleId + ".apk" + (!TextUtils.isEmpty(application.token) ? "?token=" + application.token : "");
    }
}
