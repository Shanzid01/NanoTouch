package com.slideme.sam.manager.util;

import android.content.Context;
import android.widget.Toast;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.p054b.C1829c;

/* compiled from: ToastCompat */
public class C1920k {
    public static Toast m5781a(Context context, int i, int i2) {
        return C1920k.m5782a(context, context.getString(i), i2);
    }

    public static Toast m5782a(Context context, String str, int i) {
        Toast makeText = Toast.makeText(context, str, i);
        if (C1829c.m5504f() < 23) {
            makeText.getView().setBackgroundResource(R.drawable.toast_frame);
        }
        return makeText;
    }
}
