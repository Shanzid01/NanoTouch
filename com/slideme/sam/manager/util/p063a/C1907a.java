package com.slideme.sam.manager.util.p063a;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* compiled from: FroyoCompatHelper */
public abstract class C1907a {
    public static File m5746a(Context context, String str) {
        if (context == null) {
            return Environment.getExternalStorageDirectory();
        }
        return context.getExternalFilesDir(null);
    }
}
