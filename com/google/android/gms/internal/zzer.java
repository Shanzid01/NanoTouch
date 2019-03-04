package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

@zzgi
public class zzer extends FrameLayout implements OnClickListener {
    private final ImageButton zzuJ;
    private final zzet zzuK;

    public zzer(Context context, int i, zzet com_google_android_gms_internal_zzet) {
        super(context);
        this.zzuK = com_google_android_gms_internal_zzet;
        setOnClickListener(this);
        this.zzuJ = new ImageButton(context);
        this.zzuJ.setImageResource(17301527);
        this.zzuJ.setBackgroundColor(0);
        this.zzuJ.setOnClickListener(this);
        this.zzuJ.setPadding(0, 0, 0, 0);
        this.zzuJ.setContentDescription("Interstitial close button");
        int zzb = zzbe.zzbD().zzb(context, i);
        addView(this.zzuJ, new LayoutParams(zzb, zzb, 17));
    }

    public void onClick(View view) {
        if (this.zzuK != null) {
            this.zzuK.zzdd();
        }
    }

    public void zza(boolean z, boolean z2) {
        if (!z2) {
            this.zzuJ.setVisibility(0);
        } else if (z) {
            this.zzuJ.setVisibility(4);
        } else {
            this.zzuJ.setVisibility(8);
        }
    }
}
