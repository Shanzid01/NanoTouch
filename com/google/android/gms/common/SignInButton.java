package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzg.zza;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private View zzLI;
    private OnClickListener zzLJ;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzLJ = null;
        setStyle(0, 0);
    }

    private void zzN(Context context) {
        if (this.zzLI != null) {
            removeView(this.zzLI);
        }
        try {
            this.zzLI = zzac.zzb(context, this.mSize, this.mColor);
        } catch (zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.zzLI = zza(context, this.mSize, this.mColor);
        }
        addView(this.zzLI);
        this.zzLI.setEnabled(isEnabled());
        this.zzLI.setOnClickListener(this);
    }

    private static Button zza(Context context, int i, int i2) {
        Button com_google_android_gms_common_internal_zzad = new zzad(context);
        com_google_android_gms_common_internal_zzad.zza(context.getResources(), i, i2);
        return com_google_android_gms_common_internal_zzad;
    }

    public void onClick(View view) {
        if (this.zzLJ != null && view == this.zzLI) {
            this.zzLJ.onClick(this);
        }
    }

    public void setColorScheme(int i) {
        setStyle(this.mSize, i);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.zzLI.setEnabled(z);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.zzLJ = onClickListener;
        if (this.zzLI != null) {
            this.zzLI.setOnClickListener(this);
        }
    }

    public void setSize(int i) {
        setStyle(i, this.mColor);
    }

    public void setStyle(int i, int i2) {
        boolean z = i >= 0 && i < 3;
        zzx.zza(z, "Unknown button size %d", Integer.valueOf(i));
        z = i2 >= 0 && i2 < 2;
        zzx.zza(z, "Unknown color scheme %s", Integer.valueOf(i2));
        this.mSize = i;
        this.mColor = i2;
        zzN(getContext());
    }
}
