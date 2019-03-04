package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;

/* compiled from: ParameterLoaderImpl */
class bd implements bc {
    private final Context f2024a;

    public bd(Context context) {
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        this.f2024a = context.getApplicationContext();
    }

    private int m3839a(String str, String str2) {
        if (this.f2024a == null) {
            return 0;
        }
        return this.f2024a.getResources().getIdentifier(str, str2, this.f2024a.getPackageName());
    }

    public String mo1192a(String str) {
        int a = m3839a(str, "string");
        if (a == 0) {
            return null;
        }
        return this.f2024a.getString(a);
    }

    public boolean mo1194c(String str) {
        int a = m3839a(str, "bool");
        if (a == 0) {
            return false;
        }
        return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(this.f2024a.getString(a));
    }

    public int mo1191a(String str, int i) {
        int a = m3839a(str, "integer");
        if (a != 0) {
            try {
                i = Integer.parseInt(this.f2024a.getString(a));
            } catch (NumberFormatException e) {
                av.m3821h("NumberFormatException parsing " + this.f2024a.getString(a));
            }
        }
        return i;
    }

    public Double mo1193b(String str) {
        Double d = null;
        String a = mo1192a(str);
        if (!TextUtils.isEmpty(a)) {
            try {
                d = Double.valueOf(Double.parseDouble(a));
            } catch (NumberFormatException e) {
                av.m3821h("NumberFormatException parsing " + a);
            }
        }
        return d;
    }
}
