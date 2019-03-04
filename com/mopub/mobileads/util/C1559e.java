package com.mopub.mobileads.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import com.mopub.common.p050b.C1483f;
import com.mopub.common.p050b.C1493p;
import com.mopub.mobileads.MraidVideoPlayerActivity;

/* compiled from: Mraids */
public class C1559e {
    public static boolean m4665a(Context context) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return C1483f.m4063a(context, intent);
    }

    public static boolean m4666b(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return C1483f.m4063a(context, intent);
    }

    public static boolean m4667c(Context context) {
        return "mounted".equals(Environment.getExternalStorageState()) && context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static boolean m4668d(Context context) {
        return C1493p.currentApiLevel().isAtLeast(C1493p.ICE_CREAM_SANDWICH) && C1483f.m4063a(context, new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event"));
    }

    public static boolean m4669e(Context context) {
        return C1483f.m4063a(context, new Intent(context, MraidVideoPlayerActivity.class));
    }
}
