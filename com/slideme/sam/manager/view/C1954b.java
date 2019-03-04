package com.slideme.sam.manager.view;

import android.os.Build.VERSION;
import android.util.Patterns;
import java.util.regex.Pattern;

/* compiled from: FormatUtils */
public abstract class C1954b {
    public static boolean m5862a(String str) {
        Pattern compile;
        if (VERSION.SDK_INT < 8) {
            compile = Pattern.compile("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", 2);
        } else {
            compile = Patterns.EMAIL_ADDRESS;
        }
        return compile.matcher(str).matches();
    }

    public static boolean m5863b(String str) {
        return str.length() > 5 && str.trim().length() == str.length();
    }
}
