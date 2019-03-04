package com.mopub.common.p050b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;

/* compiled from: IntentUtils */
public class C1483f {
    public static Intent m4061a(Context context, Class cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    public static boolean m4063a(Context context, Intent intent) {
        try {
            if (context.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
                return false;
            }
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static boolean m4066a(String str) {
        if (str == null) {
            return false;
        }
        String scheme = Uri.parse(str).getScheme();
        if ("http".equals(scheme) || "https".equals(scheme)) {
            return true;
        }
        return false;
    }

    private static boolean m4068c(String str) {
        if (str == null) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        if ("play.google.com".equals(host) || "market.android.com".equals(host)) {
            return true;
        }
        if ("market".equals(scheme)) {
            return true;
        }
        return false;
    }

    public static boolean m4067b(String str) {
        return C1483f.m4068c(str) || !C1483f.m4066a(str);
    }

    public static boolean m4062a(Context context) {
        return C1483f.m4065a(context, "twitter://timeline", false);
    }

    public static boolean m4064a(Context context, String str) {
        return C1483f.m4065a(context, str, true);
    }

    public static boolean m4065a(Context context, String str, boolean z) {
        if (C1483f.m4063a(context, new Intent("android.intent.action.VIEW", Uri.parse(str)))) {
            return true;
        }
        if (z) {
            Log.w("MoPub", "Could not handle application specific action: " + str + ". " + "You may be running in the emulator or another device which does not " + "have the required application.");
        }
        return false;
    }
}
