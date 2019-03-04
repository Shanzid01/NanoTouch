package com.slideme.sam.manager.net.wrappers;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import com.slideme.sam.manager.model.data.Application;
import java.io.File;

/* compiled from: ObbFilesDownloader */
public class C1901n extends C1892h {
    private Application f3478b;

    public String mo4318a() {
        return this.a.getAbsolutePath();
    }

    public C1901n(Application application, Context context, String str) {
        this(context, str, C1901n.m5727a(context, str, application.packageName));
        this.f3478b = application;
    }

    public C1901n(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public static String m5726a(Context context, String str) {
        return Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "obb" + File.separator + str;
    }

    public static String m5727a(Context context, String str, String str2) {
        String a = C1901n.m5726a(context, str2);
        File file = new File(a);
        if (!file.exists()) {
            file.mkdir();
        }
        return new StringBuilder(String.valueOf(a)).append(File.separator).append(Uri.parse(str).getLastPathSegment()).toString();
    }
}
