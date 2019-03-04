package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.internal.zzg;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private int mSize;
    private View zzauj;
    private int zzauk;
    private int zzaul;
    private OnPlusOneClickListener zzaum;
    private String zzxX;

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    public class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener zzaun;
        final /* synthetic */ PlusOneButton zzauo;

        public DefaultOnPlusOneClickListener(PlusOneButton plusOneButton, OnPlusOneClickListener onPlusOneClickListener) {
            this.zzauo = plusOneButton;
            this.zzaun = onPlusOneClickListener;
        }

        public void onClick(View view) {
            Intent intent = (Intent) this.zzauo.zzauj.getTag();
            if (this.zzaun != null) {
                this.zzaun.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = this.zzauo.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, this.zzauo.zzaul);
            }
        }
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSize = getSize(context, attributeSet);
        this.zzauk = getAnnotation(context, attributeSet);
        this.zzaul = -1;
        zzN(getContext());
        if (!isInEditMode()) {
        }
    }

    protected static int getAnnotation(Context context, AttributeSet attributeSet) {
        String zza = zzag.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attributeSet, true, false, "PlusOneButton");
        return "INLINE".equalsIgnoreCase(zza) ? 2 : !"NONE".equalsIgnoreCase(zza) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attributeSet) {
        String zza = zzag.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attributeSet, true, false, "PlusOneButton");
        return "SMALL".equalsIgnoreCase(zza) ? 0 : "MEDIUM".equalsIgnoreCase(zza) ? 1 : "TALL".equalsIgnoreCase(zza) ? 2 : 3;
    }

    private void zzN(Context context) {
        if (this.zzauj != null) {
            removeView(this.zzauj);
        }
        this.zzauj = zzg.zza(context, this.mSize, this.zzauk, this.zzxX, this.zzaul);
        setOnPlusOneClickListener(this.zzaum);
        addView(this.zzauj);
    }

    public void initialize(String str, int i) {
        zzx.zza(getContext() instanceof Activity, (Object) "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.zzxX = str;
        this.zzaul = i;
        zzN(getContext());
    }

    public void initialize(String str, OnPlusOneClickListener onPlusOneClickListener) {
        this.zzxX = str;
        this.zzaul = 0;
        zzN(getContext());
        setOnPlusOneClickListener(onPlusOneClickListener);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.zzauj.layout(0, 0, i3 - i, i4 - i2);
    }

    protected void onMeasure(int i, int i2) {
        View view = this.zzauj;
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setAnnotation(int i) {
        this.zzauk = i;
        zzN(getContext());
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
        this.zzaum = onPlusOneClickListener;
        this.zzauj.setOnClickListener(new DefaultOnPlusOneClickListener(this, onPlusOneClickListener));
    }

    public void setSize(int i) {
        this.mSize = i;
        zzN(getContext());
    }
}
