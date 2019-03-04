package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.internal.zzhe.zza;

@zzgi
public class zzge extends zzgd {
    private Object zzvT = new Object();
    private PopupWindow zzvU;
    private boolean zzvV = false;

    zzge(Context context, zza com_google_android_gms_internal_zzhe_zza, zzic com_google_android_gms_internal_zzic, zzgc.zza com_google_android_gms_internal_zzgc_zza) {
        super(context, com_google_android_gms_internal_zzhe_zza, com_google_android_gms_internal_zzic, com_google_android_gms_internal_zzgc_zza);
    }

    private void zzdH() {
        synchronized (this.zzvT) {
            this.zzvV = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzvU = null;
            }
            if (this.zzvU != null) {
                if (this.zzvU.isShowing()) {
                    this.zzvU.dismiss();
                }
                this.zzvU = null;
            }
        }
    }

    public void onStop() {
        zzdH();
        super.onStop();
    }

    protected void zzdG() {
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.mContext).isDestroyed()) {
            View frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            frameLayout.addView(this.zzmu.getWebView(), -1, -1);
            synchronized (this.zzvT) {
                if (this.zzvV) {
                    return;
                }
                this.zzvU = new PopupWindow(frameLayout, 1, 1, false);
                this.zzvU.setOutsideTouchable(true);
                this.zzvU.setClippingEnabled(false);
                zzhx.zzY("Displaying the 1x1 popup off the screen.");
                try {
                    this.zzvU.showAtLocation(window.getDecorView(), 0, -1, -1);
                } catch (Exception e) {
                    this.zzvU = null;
                }
            }
        }
    }

    protected void zzh(zzhe com_google_android_gms_internal_zzhe) {
        zzdH();
        super.zzh(com_google_android_gms_internal_zzhe);
    }
}
