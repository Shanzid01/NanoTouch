package com.mopub.mobileads.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;

/* compiled from: Utils */
public class C1560f {
    public static boolean m4670a(Context context, Intent intent, String str) {
        try {
            if (!(context instanceof Activity)) {
                intent.addFlags(DriveFile.MODE_READ_ONLY);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            String str2 = "MoPub";
            if (str == null) {
                str = "Unable to start intent.";
            }
            Log.d(str2, str);
            return false;
        }
    }
}
