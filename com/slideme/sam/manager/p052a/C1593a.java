package com.slideme.sam.manager.p052a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.p001a.p002a.C0019a;
import java.io.File;
import java.lang.reflect.Method;

/* compiled from: ApplicationManager */
public class C1593a {
    public final int f2635a = 2;
    private C1594b f2636b = new C1594b(this);
    private PackageManager f2637c;
    private Method f2638d;
    private C1595c f2639e;

    public C1593a(Context context) {
        this.f2637c = context.getPackageManager();
        this.f2638d = this.f2637c.getClass().getMethod("installPackage", new Class[]{Uri.class, C0019a.class, Integer.TYPE, String.class});
    }

    public void m4783a(C1595c c1595c) {
        this.f2639e = c1595c;
    }

    public void m4785a(String str) {
        m4784a(new File(str));
    }

    public void m4784a(File file) {
        if (file.exists()) {
            m4782a(Uri.fromFile(file));
            return;
        }
        throw new IllegalArgumentException();
    }

    public void m4782a(Uri uri) {
        Method method = this.f2638d;
        PackageManager packageManager = this.f2637c;
        Object[] objArr = new Object[4];
        objArr[0] = uri;
        objArr[1] = this.f2636b;
        objArr[2] = Integer.valueOf(2);
        method.invoke(packageManager, objArr);
    }
}
