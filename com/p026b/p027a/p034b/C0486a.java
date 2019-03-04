package com.p026b.p027a.p034b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.p026b.p027a.p028a.p029a.C0450b;
import com.p026b.p027a.p028a.p029a.p030a.C0453a;
import com.p026b.p027a.p028a.p029a.p030a.C0454b;
import com.p026b.p027a.p028a.p029a.p030a.C0455c;
import com.p026b.p027a.p028a.p029a.p031b.C0456a;
import com.p026b.p027a.p028a.p029a.p031b.C0457b;
import com.p026b.p027a.p028a.p032b.C0459c;
import com.p026b.p027a.p028a.p032b.p033a.C0463b;
import com.p026b.p027a.p028a.p032b.p033a.C0464c;
import com.p026b.p027a.p034b.p035a.C0482j;
import com.p026b.p027a.p034b.p035a.p036a.C0468c;
import com.p026b.p027a.p034b.p037b.C0487d;
import com.p026b.p027a.p034b.p037b.C0488a;
import com.p026b.p027a.p034b.p038c.C0493a;
import com.p026b.p027a.p034b.p038c.C0496d;
import com.p026b.p027a.p034b.p039d.C0498c;
import com.p026b.p027a.p034b.p039d.C0499a;
import com.p026b.p027a.p041c.C0525e;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DefaultConfigurationFactory */
public class C0486a {
    public static Executor m2983a(int i, int i2, C0482j c0482j) {
        return new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, (c0482j == C0482j.LIFO ? 1 : null) != null ? new C0468c() : new LinkedBlockingQueue(), C0486a.m2986b(i2));
    }

    public static C0456a m2978a() {
        return new C0457b();
    }

    public static C0450b m2980a(Context context, C0456a c0456a, int i, int i2) {
        if (i > 0) {
            return new C0454b(C0525e.m3157b(context), c0456a, i);
        }
        if (i2 > 0) {
            return new C0453a(C0525e.m3157b(context), c0456a, i2);
        }
        return new C0455c(C0525e.m3156a(context), c0456a);
    }

    public static C0450b m2979a(Context context) {
        File cacheDir = context.getCacheDir();
        File file = new File(cacheDir, "uil-images");
        if (file.exists() || file.mkdir()) {
            cacheDir = file;
        }
        return new C0454b(cacheDir, 2097152);
    }

    public static C0459c<String, Bitmap> m2981a(int i) {
        if (i == 0) {
            i = (int) (Runtime.getRuntime().maxMemory() / 8);
        }
        if (VERSION.SDK_INT >= 9) {
            return new C0464c(i);
        }
        return new C0463b(i);
    }

    public static C0498c m2985b(Context context) {
        return new C0499a(context);
    }

    public static C0487d m2982a(boolean z) {
        return new C0488a(z);
    }

    public static C0493a m2984b() {
        return new C0496d();
    }

    private static ThreadFactory m2986b(int i) {
        return new C0492b(i);
    }
}
