package com.mopub.common.p050b;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: Dips */
public class C1481d {
    public static float m4056a(float f, Context context) {
        return C1481d.m4057a(context) * f;
    }

    public static int m4058b(float f, Context context) {
        return (int) (C1481d.m4056a(f, context) + 0.5f);
    }

    private static float m4057a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float m4059c(float f, Context context) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int m4060d(float f, Context context) {
        return (int) (C1481d.m4059c(f, context) + 0.5f);
    }
}
