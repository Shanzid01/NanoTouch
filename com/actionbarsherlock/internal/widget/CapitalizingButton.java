package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.Button;
import java.util.Locale;

public class CapitalizingButton extends Button {
    private static final boolean IS_GINGERBREAD;
    private static final int[] R_styleable_Button = new int[]{16843660};
    private static final int R_styleable_Button_textAllCaps = 0;
    private static final boolean SANS_ICE_CREAM = (VERSION.SDK_INT < 14);
    private boolean mAllCaps;

    static {
        boolean z;
        if (VERSION.SDK_INT >= 9) {
            z = true;
        } else {
            z = false;
        }
        IS_GINGERBREAD = z;
    }

    public CapitalizingButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R_styleable_Button);
        this.mAllCaps = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    public void setTextCompat(CharSequence charSequence) {
        if (!SANS_ICE_CREAM || !this.mAllCaps || charSequence == null) {
            setText(charSequence);
        } else if (IS_GINGERBREAD) {
            setText(charSequence.toString().toUpperCase(Locale.ROOT));
        } else {
            setText(charSequence.toString().toUpperCase());
        }
    }
}
