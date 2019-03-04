package com.slideme.sam.manager.util;

import android.content.Context;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.ZipFile;

/* compiled from: PropertyReader */
public class C1916g {
    private Context f3495a;
    private Properties f3496b = new Properties();
    private C1917h f3497c;

    public C1916g(Context context, C1917h c1917h) {
        this.f3495a = context;
        this.f3497c = c1917h;
    }

    public Properties m5771a(String str) {
        try {
            InputStream open;
            if (this.f3497c == C1917h.ASSETS) {
                open = this.f3495a.getAssets().open(str);
            } else {
                ZipFile zipFile = new ZipFile(this.f3495a.getPackageCodePath());
                open = zipFile.getInputStream(zipFile.getEntry("META-INF/" + str));
            }
            this.f3496b.load(open);
            return this.f3496b;
        } catch (Exception e) {
            return null;
        }
    }
}
