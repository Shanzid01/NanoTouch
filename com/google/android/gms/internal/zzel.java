package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.location.places.Place;

@zzgi
public class zzel extends com.google.android.gms.internal.zzev.zza implements zzet {
    static final int zztV = Color.argb(0, 0, 0, 0);
    zzic zzmu;
    private final Activity zzoi;
    zzeo zztW;
    zzeq zztX;
    zzc zztY;
    zzer zztZ;
    RelativeLayout zzts;
    boolean zzua = false;
    FrameLayout zzub;
    CustomViewCallback zzuc;
    boolean zzud = false;
    boolean zzue = false;
    boolean zzuf = false;
    int zzug = 0;
    private boolean zzuh;
    private boolean zzui = false;
    private boolean zzuj = true;

    class C12001 implements com.google.android.gms.internal.zzid.zza {
        final /* synthetic */ zzel zzuk;

        C12001(zzel com_google_android_gms_internal_zzel) {
            this.zzuk = com_google_android_gms_internal_zzel;
        }

        public void zza(zzic com_google_android_gms_internal_zzic, boolean z) {
            com_google_android_gms_internal_zzic.zzeG().zzeR();
            com_google_android_gms_internal_zzic.zzdh();
        }
    }

    @zzgi
    final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    @zzgi
    final class zzb extends RelativeLayout {
        zzhs zzlL;

        public zzb(Context context, String str) {
            super(context);
            this.zzlL = new zzhs(context, str);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.zzlL.zzc(motionEvent);
            return false;
        }
    }

    @zzgi
    public class zzc {
        public final int index;
        public final Context zzlN;
        public final LayoutParams zzul;
        public final ViewGroup zzum;

        public zzc(zzic com_google_android_gms_internal_zzic) {
            this.zzul = com_google_android_gms_internal_zzic.getLayoutParams();
            ViewParent parent = com_google_android_gms_internal_zzic.getParent();
            this.zzlN = com_google_android_gms_internal_zzic.zzeE();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new zza("Could not get the parent of the WebView for an overlay.");
            }
            this.zzum = (ViewGroup) parent;
            this.index = this.zzum.indexOfChild(com_google_android_gms_internal_zzic.getWebView());
            this.zzum.removeView(com_google_android_gms_internal_zzic.getWebView());
            com_google_android_gms_internal_zzic.zzA(true);
        }
    }

    public zzel(Activity activity) {
        this.zzoi = activity;
    }

    static RelativeLayout.LayoutParams zzd(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    public void close() {
        this.zzug = 2;
        this.zzoi.finish();
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.zzud = z;
        try {
            this.zztW = zzeo.zzb(this.zzoi.getIntent());
            if (this.zztW == null) {
                throw new zza("Could not get info for ad overlay.");
            }
            if (this.zzoi.getIntent() != null) {
                this.zzuj = this.zzoi.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.zztW.zzuz != null) {
                this.zzue = this.zztW.zzuz.zzml;
            } else {
                this.zzue = false;
            }
            if (bundle == null) {
                if (this.zztW.zzup != null && this.zzuj) {
                    this.zztW.zzup.zzag();
                }
                if (!(this.zztW.zzuw == 1 || this.zztW.zzuo == null)) {
                    this.zztW.zzuo.onAdClicked();
                }
            }
            this.zzts = new zzb(this.zzoi, this.zztW.zzuy);
            switch (this.zztW.zzuw) {
                case 1:
                    zzt(false);
                    return;
                case 2:
                    this.zztY = new zzc(this.zztW.zzuq);
                    zzt(false);
                    return;
                case 3:
                    zzt(true);
                    return;
                case 4:
                    if (this.zzud) {
                        this.zzug = 3;
                        this.zzoi.finish();
                        return;
                    } else if (!zzab.zzaJ().zza(this.zzoi, this.zztW.zzun, this.zztW.zzuv)) {
                        this.zzug = 3;
                        this.zzoi.finish();
                        return;
                    } else {
                        return;
                    }
                default:
                    throw new zza("Could not determine ad overlay type.");
            }
        } catch (zza e) {
            zzhx.zzac(e.getMessage());
            this.zzug = 3;
            this.zzoi.finish();
        }
    }

    public void onDestroy() {
        if (this.zztX != null) {
            this.zztX.destroy();
        }
        if (this.zzmu != null) {
            this.zzts.removeView(this.zzmu.getWebView());
        }
        zzdf();
    }

    public void onPause() {
        if (this.zztX != null) {
            this.zztX.pause();
        }
        zzdc();
        if (this.zzmu != null && (!this.zzoi.isFinishing() || this.zztY == null)) {
            zzab.zzaO().zza(this.zzmu.getWebView());
        }
        zzdf();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.zztW != null && this.zztW.zzuw == 4) {
            if (this.zzud) {
                this.zzug = 3;
                this.zzoi.finish();
            } else {
                this.zzud = true;
            }
        }
        if (this.zzmu == null || this.zzmu.isDestroyed()) {
            zzhx.zzac("The webview does not exit. Ignoring action.");
        } else {
            zzab.zzaO().zzb(this.zzmu.getWebView());
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzud);
    }

    public void onStart() {
    }

    public void onStop() {
        zzdf();
    }

    public void setRequestedOrientation(int i) {
        this.zzoi.setRequestedOrientation(i);
    }

    public void zzX() {
        this.zzuh = true;
    }

    public void zza(View view, CustomViewCallback customViewCallback) {
        this.zzub = new FrameLayout(this.zzoi);
        this.zzub.setBackgroundColor(-16777216);
        this.zzub.addView(view, -1, -1);
        this.zzoi.setContentView(this.zzub);
        zzX();
        this.zzuc = customViewCallback;
        this.zzua = true;
    }

    public void zza(boolean z, boolean z2) {
        if (this.zztZ != null) {
            this.zztZ.zza(z, z2);
        }
    }

    public zzeq zzdb() {
        return this.zztX;
    }

    public void zzdc() {
        if (this.zztW != null && this.zzua) {
            setRequestedOrientation(this.zztW.orientation);
        }
        if (this.zzub != null) {
            this.zzoi.setContentView(this.zzts);
            zzX();
            this.zzub.removeAllViews();
            this.zzub = null;
        }
        if (this.zzuc != null) {
            this.zzuc.onCustomViewHidden();
            this.zzuc = null;
        }
        this.zzua = false;
    }

    public void zzdd() {
        this.zzug = 1;
        this.zzoi.finish();
    }

    public void zzde() {
        this.zzts.removeView(this.zztZ);
        zzs(true);
    }

    protected void zzdf() {
        if (this.zzoi.isFinishing() && !this.zzui) {
            this.zzui = true;
            if (this.zzoi.isFinishing()) {
                if (this.zzmu != null) {
                    zzp(this.zzug);
                    this.zzts.removeView(this.zzmu.getWebView());
                    if (this.zztY != null) {
                        this.zzmu.setContext(this.zztY.zzlN);
                        this.zzmu.zzA(false);
                        this.zztY.zzum.addView(this.zzmu.getWebView(), this.zztY.index, this.zztY.zzul);
                        this.zztY = null;
                    }
                }
                if (this.zztW != null && this.zztW.zzup != null) {
                    this.zztW.zzup.zzaf();
                }
            }
        }
    }

    public void zzdg() {
        if (this.zzuf) {
            this.zzuf = false;
            zzdh();
        }
    }

    protected void zzdh() {
        this.zzmu.zzdh();
    }

    public void zze(int i, int i2, int i3, int i4) {
        if (this.zztX != null) {
            this.zztX.setLayoutParams(zzd(i, i2, i3, i4));
        }
    }

    public void zzf(int i, int i2, int i3, int i4) {
        if (this.zztX == null) {
            this.zztX = new zzeq(this.zzoi, this.zzmu);
            this.zzts.addView(this.zztX, 0, zzd(i, i2, i3, i4));
            this.zzmu.zzeG().zzC(false);
        }
    }

    protected void zzp(int i) {
        this.zzmu.zzp(i);
    }

    public void zzs(boolean z) {
        this.zztZ = new zzer(this.zzoi, z ? 50 : 32, this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.zztZ.zza(z, this.zztW.zzut);
        this.zzts.addView(this.zztZ, layoutParams);
    }

    protected void zzt(boolean z) {
        if (!this.zzuh) {
            this.zzoi.requestWindowFeature(1);
        }
        Window window = this.zzoi.getWindow();
        if (window == null) {
            throw new zza("Invalid activity, no window available.");
        }
        if (!this.zzue || (this.zztW.zzuz != null && this.zztW.zzuz.zzmy)) {
            window.setFlags(Place.TYPE_SUBLOCALITY_LEVEL_2, Place.TYPE_SUBLOCALITY_LEVEL_2);
        }
        this.zzuf = false;
        if (this.zztW.orientation == zzab.zzaO().zzex()) {
            this.zzuf = this.zzoi.getResources().getConfiguration().orientation == 1;
        } else if (this.zztW.orientation == zzab.zzaO().zzey()) {
            this.zzuf = this.zzoi.getResources().getConfiguration().orientation == 2;
        }
        zzhx.zzY("Delay onShow to next orientation change: " + this.zzuf);
        setRequestedOrientation(this.zztW.orientation);
        if (zzab.zzaO().zza(window)) {
            zzhx.zzY("Hardware acceleration on the AdActivity window enabled.");
        }
        if (this.zzue) {
            this.zzts.setBackgroundColor(zztV);
        } else {
            this.zzts.setBackgroundColor(-16777216);
        }
        this.zzoi.setContentView(this.zzts);
        zzX();
        boolean zzba = this.zztW.zzuq.zzeG().zzba();
        if (z) {
            this.zzmu = zzab.zzaN().zza(this.zzoi, this.zztW.zzuq.zzad(), true, zzba, null, this.zztW.zzlP);
            this.zzmu.zzeG().zzb(null, null, this.zztW.zzur, this.zztW.zzuv, true, this.zztW.zzux, null, this.zztW.zzuq.zzeG().zzeM(), null);
            this.zzmu.zzeG().zza(new C12001(this));
            if (this.zztW.zztR != null) {
                this.zzmu.loadUrl(this.zztW.zztR);
            } else if (this.zztW.zzuu != null) {
                this.zzmu.loadDataWithBaseURL(this.zztW.zzus, this.zztW.zzuu, "text/html", "UTF-8", null);
            } else {
                throw new zza("No URL or HTML to display in ad overlay.");
            }
        }
        this.zzmu = this.zztW.zzuq;
        this.zzmu.setContext(this.zzoi);
        this.zzmu.zza(this);
        ViewParent parent = this.zzmu.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.zzmu.getWebView());
        }
        if (this.zzue) {
            this.zzmu.setBackgroundColor(zztV);
        }
        this.zzts.addView(this.zzmu.getWebView(), -1, -1);
        if (!(z || this.zzuf)) {
            zzdh();
        }
        zzs(zzba);
        if (this.zzmu.zzeH()) {
            zza(zzba, true);
        }
    }
}
