package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ViewSwitcher;
import com.facebook.AppEventsConstants;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@zzgi
public class zzt extends com.google.android.gms.internal.zzbi.zza implements zzac, zzat, zzct, zzcw, zzcy, zzdl, zzeh, zzep, zzes, zzfk, com.google.android.gms.internal.zzgc.zza, com.google.android.gms.internal.zzgj.zza, zzhi, zzv {
    private zzce zzlA;
    private zzce zzlB;
    private zzax zzlC;
    private final zzdr zzlD;
    private final zzb zzlE;
    private final zzaa zzlF;
    private final zzae zzlG;
    private boolean zzlH;
    private zzcf zzlz;

    @zzgi
    public final class zza extends ViewSwitcher {
        private final zzhs zzlL;

        public zza(Context context) {
            super(context);
            this.zzlL = new zzhs(context);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.zzlL.zzc(motionEvent);
            return false;
        }

        public void removeAllViews() {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt != null && (childAt instanceof zzic)) {
                    ((zzic) childAt).destroy();
                }
            }
            super.removeAllViews();
        }
    }

    @zzgi
    class zzb implements OnGlobalLayoutListener {
        public final String zzlM;
        public final Context zzlN;
        public final zzk zzlO;
        public final zzhy zzlP;
        public zzhl zzlQ;
        public zzbg zzlR;
        public zza zzlS;
        public zzbh zzlT;
        public zzhl zzlU;
        public zzba zzlV;
        public zzhe zzlW;
        public com.google.android.gms.internal.zzhe.zza zzlX;
        public zzhf zzlY;
        public zzbk zzlZ;
        public zzfs zzma;
        public zzfo zzmb;
        public zzcq zzmc;
        public zzcr zzmd;
        public zzcj zzme;
        public List<String> zzmf;
        public zzfl zzmg;
        public zzhj zzmh;
        public View zzmi;
        public int zzmj;
        public boolean zzmk;
        public boolean zzml;
        public zzbl zzmm;
        private HashSet<zzhf> zzmn;
        private int zzmo;
        private int zzmp;

        public zzb(Context context, zzba com_google_android_gms_internal_zzba, String str, zzhy com_google_android_gms_internal_zzhy) {
            this(context, com_google_android_gms_internal_zzba, str, com_google_android_gms_internal_zzhy, null);
        }

        zzb(Context context, zzba com_google_android_gms_internal_zzba, String str, zzhy com_google_android_gms_internal_zzhy, zzk com_google_android_gms_internal_zzk) {
            this.zzmh = null;
            this.zzmi = null;
            this.zzmj = 0;
            this.zzmk = false;
            this.zzml = false;
            this.zzmn = null;
            this.zzmo = -1;
            this.zzmp = -1;
            if (com_google_android_gms_internal_zzba.zzpb) {
                this.zzlS = null;
            } else {
                this.zzlS = new zza(context);
                this.zzlS.setMinimumWidth(com_google_android_gms_internal_zzba.widthPixels);
                this.zzlS.setMinimumHeight(com_google_android_gms_internal_zzba.heightPixels);
                this.zzlS.setVisibility(4);
            }
            if (!(context == null || !(context instanceof Activity) || this.zzlS == null)) {
                zzab.zzaM().zza((Activity) context, (OnGlobalLayoutListener) this);
            }
            this.zzlV = com_google_android_gms_internal_zzba;
            this.zzlM = str;
            this.zzlN = context;
            this.zzlP = com_google_android_gms_internal_zzhy;
            if (com_google_android_gms_internal_zzk == null) {
                com_google_android_gms_internal_zzk = new zzk(new zzw(this));
            }
            this.zzlO = com_google_android_gms_internal_zzk;
        }

        public void destroy() {
            this.zzlT = null;
            this.zzlZ = null;
            this.zzma = null;
            this.zzmb = null;
            this.zzme = null;
            this.zzmm = null;
            if (!(this.zzlN == null || !(this.zzlN instanceof Activity) || this.zzlS == null)) {
                zzab.zzaO().zzb((Activity) this.zzlN, (OnGlobalLayoutListener) this);
            }
            zzf(false);
            if (this.zzlS != null) {
                this.zzlS.removeAllViews();
            }
            zzay();
            zzaA();
            this.zzlW = null;
        }

        public void onGlobalLayout() {
            if (this.zzlS != null && this.zzlW != null && this.zzlW.zzuq != null && this.zzlW.zzuq.zzeG().zzba()) {
                int[] iArr = new int[2];
                this.zzlS.getLocationOnScreen(iArr);
                int zzc = zzbe.zzbD().zzc(this.zzlN, iArr[0]);
                int zzc2 = zzbe.zzbD().zzc(this.zzlN, iArr[1]);
                if (zzc != this.zzmo || zzc2 != this.zzmp) {
                    this.zzmo = zzc;
                    this.zzmp = zzc2;
                    this.zzlW.zzuq.zzeG().zzb(this.zzmo, this.zzmp);
                }
            }
        }

        public void zza(HashSet<zzhf> hashSet) {
            this.zzmn = hashSet;
        }

        public void zzaA() {
            if (this.zzlW != null && this.zzlW.zzsM != null) {
                try {
                    this.zzlW.zzsM.destroy();
                } catch (RemoteException e) {
                    zzhx.zzac("Could not destroy mediation adapter.");
                }
            }
        }

        public HashSet<zzhf> zzax() {
            return this.zzmn;
        }

        public void zzay() {
            if (this.zzlW != null && this.zzlW.zzuq != null) {
                this.zzlW.zzuq.destroy();
            }
        }

        public void zzaz() {
            if (this.zzlW != null && this.zzlW.zzuq != null) {
                this.zzlW.zzuq.stopLoading();
            }
        }

        public void zzf(boolean z) {
            if (this.zzmj == 0) {
                zzaz();
            }
            if (this.zzlQ != null) {
                this.zzlQ.cancel();
            }
            if (this.zzlU != null) {
                this.zzlU.cancel();
            }
            if (z) {
                this.zzlW = null;
            }
        }
    }

    public zzt(Context context, zzba com_google_android_gms_internal_zzba, String str, zzdr com_google_android_gms_internal_zzdr, zzhy com_google_android_gms_internal_zzhy) {
        this(new zzb(context, com_google_android_gms_internal_zzba, str, com_google_android_gms_internal_zzhy), com_google_android_gms_internal_zzdr, null);
    }

    zzt(zzb com_google_android_gms_internal_zzt_zzb, zzdr com_google_android_gms_internal_zzdr, zzaa com_google_android_gms_internal_zzaa) {
        zzca.zzl(com_google_android_gms_internal_zzt_zzb.zzlN);
        this.zzlE = com_google_android_gms_internal_zzt_zzb;
        this.zzlD = com_google_android_gms_internal_zzdr;
        if (com_google_android_gms_internal_zzaa == null) {
            com_google_android_gms_internal_zzaa = new zzaa(this);
        }
        this.zzlF = com_google_android_gms_internal_zzaa;
        zzab.zzaM().zzu(this.zzlE.zzlN);
        zzab.zzaP().zzb(this.zzlE.zzlN, this.zzlE.zzlP);
        this.zzlG = zzab.zzaP().zzel();
    }

    private com.google.android.gms.internal.zzgo.zza zza(zzax com_google_android_gms_internal_zzax, Bundle bundle) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.zzlE.zzlN.getApplicationInfo();
        try {
            packageInfo = this.zzlE.zzlN.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzlE.zzlN.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.zzlE.zzlV.zzpb || this.zzlE.zzlS.getParent() == null)) {
            int[] iArr = new int[2];
            this.zzlE.zzlS.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = this.zzlE.zzlS.getWidth();
            int height = this.zzlE.zzlS.getHeight();
            int i3 = 0;
            if (this.zzlE.zzlS.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i3);
        }
        String zzee = zzab.zzaP().zzee();
        this.zzlE.zzlY = new zzhf(zzee, this.zzlE.zzlM);
        this.zzlE.zzlY.zze(com_google_android_gms_internal_zzax);
        String zza = zzab.zzaM().zza(this.zzlE.zzlN, this.zzlE.zzlS, this.zzlE.zzlV);
        int zzaF = zzz.zzj(this.zzlE.zzlN).zzaF();
        boolean isInitialized = zzz.zzj(this.zzlE.zzlN).isInitialized();
        long j = 0;
        if (this.zzlE.zzmm != null) {
            try {
                j = this.zzlE.zzmm.getValue();
            } catch (RemoteException e2) {
                zzhx.zzac("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        return new com.google.android.gms.internal.zzgo.zza(bundle2, com_google_android_gms_internal_zzax, this.zzlE.zzlV, this.zzlE.zzlM, applicationInfo, packageInfo, zzee, zzab.zzaP().getSessionId(), this.zzlE.zzlP, zzab.zzaP().zza(this.zzlE.zzlN, this, zzee), this.zzlE.zzmf, bundle, zzab.zzaP().zzei(), new Messenger(new zzey(this.zzlE.zzlN)), displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, zza, isInitialized, zzaF, j, uuid);
    }

    private zzic zza(zzu com_google_android_gms_internal_zzu) {
        if (this.zzlE.zzlV.zzpb) {
            zzic zza = zzab.zzaN().zza(this.zzlE.zzlN, this.zzlE.zzlV, false, false, this.zzlE.zzlO, this.zzlE.zzlP);
            zza.zzeG().zzb(this, null, this, this, ((Boolean) zzca.zzqJ.get()).booleanValue(), this, this, com_google_android_gms_internal_zzu, null);
            return zza;
        }
        zzic com_google_android_gms_internal_zzic;
        View nextView = this.zzlE.zzlS.getNextView();
        if (nextView instanceof zzic) {
            com_google_android_gms_internal_zzic = (zzic) nextView;
            com_google_android_gms_internal_zzic.zza(this.zzlE.zzlN, this.zzlE.zzlV);
        } else {
            if (nextView != null) {
                this.zzlE.zzlS.removeView(nextView);
            }
            com_google_android_gms_internal_zzic = zzab.zzaN().zza(this.zzlE.zzlN, this.zzlE.zzlV, false, false, this.zzlE.zzlO, this.zzlE.zzlP);
            if (this.zzlE.zzlV.zzpc == null) {
                zzc(com_google_android_gms_internal_zzic.getWebView());
            }
        }
        com_google_android_gms_internal_zzic.zzeG().zzb(this, this, this, this, false, this, null, com_google_android_gms_internal_zzu, this);
        return com_google_android_gms_internal_zzic;
    }

    private void zza(int i) {
        zzhx.zzac("Failed to load ad: " + i);
        if (this.zzlE.zzlT != null) {
            try {
                this.zzlE.zzlT.onAdFailedToLoad(i);
            } catch (Throwable e) {
                zzhx.zzd("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    private void zzap() {
        zzhx.zzaa("Ad closing.");
        if (this.zzlE.zzlT != null) {
            try {
                this.zzlE.zzlT.onAdClosed();
            } catch (Throwable e) {
                zzhx.zzd("Could not call AdListener.onAdClosed().", e);
            }
        }
    }

    private void zzaq() {
        zzhx.zzaa("Ad leaving application.");
        if (this.zzlE.zzlT != null) {
            try {
                this.zzlE.zzlT.onAdLeftApplication();
            } catch (Throwable e) {
                zzhx.zzd("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
    }

    private void zzar() {
        zzhx.zzaa("Ad opening.");
        if (this.zzlE.zzlT != null) {
            try {
                this.zzlE.zzlT.onAdOpened();
            } catch (Throwable e) {
                zzhx.zzd("Could not call AdListener.onAdOpened().", e);
            }
        }
    }

    private void zzas() {
        zzhx.zzaa("Ad finished loading.");
        if (this.zzlE.zzlT != null) {
            try {
                this.zzlE.zzlT.onAdLoaded();
            } catch (Throwable e) {
                zzhx.zzd("Could not call AdListener.onAdLoaded().", e);
            }
        }
    }

    private void zzat() {
        try {
            if ((this.zzlE.zzlW.zzyx instanceof zzcl) && this.zzlE.zzmc != null) {
                this.zzlE.zzmc.zza((zzcl) this.zzlE.zzlW.zzyx);
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }

    private void zzau() {
        try {
            if ((this.zzlE.zzlW.zzyx instanceof zzcm) && this.zzlE.zzmd != null) {
                this.zzlE.zzmd.zza((zzcm) this.zzlE.zzlW.zzyx);
            }
        } catch (Throwable e) {
            zzhx.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }

    private void zzaw() {
        if (this.zzlE.zzmj == 0) {
            this.zzlE.zzay();
            this.zzlE.zzlW = null;
            this.zzlE.zzml = false;
        }
    }

    private boolean zzb(zzhe com_google_android_gms_internal_zzhe) {
        View view;
        if (com_google_android_gms_internal_zzhe.zzwI) {
            try {
                view = (View) zze.zzf(com_google_android_gms_internal_zzhe.zzsM.getView());
                View nextView = this.zzlE.zzlS.getNextView();
                if (nextView != null) {
                    if (nextView instanceof zzic) {
                        ((zzic) nextView).destroy();
                    }
                    this.zzlE.zzlS.removeView(nextView);
                }
                try {
                    zzc(view);
                } catch (Throwable th) {
                    zzhx.zzd("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (Throwable th2) {
                zzhx.zzd("Could not get View from mediation adapter.", th2);
                return false;
            }
        } else if (com_google_android_gms_internal_zzhe.zzyu != null) {
            com_google_android_gms_internal_zzhe.zzuq.zza(com_google_android_gms_internal_zzhe.zzyu);
            this.zzlE.zzlS.removeAllViews();
            this.zzlE.zzlS.setMinimumWidth(com_google_android_gms_internal_zzhe.zzyu.widthPixels);
            this.zzlE.zzlS.setMinimumHeight(com_google_android_gms_internal_zzhe.zzyu.heightPixels);
            zzc(com_google_android_gms_internal_zzhe.zzuq.getWebView());
        }
        if (this.zzlE.zzlS.getChildCount() > 1) {
            this.zzlE.zzlS.showNext();
        }
        if (this.zzlE.zzlW != null) {
            view = this.zzlE.zzlS.getNextView();
            if (view instanceof zzic) {
                ((zzic) view).zza(this.zzlE.zzlN, this.zzlE.zzlV);
            } else if (view != null) {
                this.zzlE.zzlS.removeView(view);
            }
            this.zzlE.zzaA();
        }
        this.zzlE.zzlS.setVisibility(0);
        return true;
    }

    private void zze(boolean z) {
        if (this.zzlE.zzlW == null) {
            zzhx.zzac("Ad state was null when trying to ping impression URLs.");
            return;
        }
        zzhx.zzY("Pinging Impression URLs.");
        this.zzlE.zzlY.zzdX();
        if (this.zzlE.zzlW.zzsu != null) {
            zzab.zzaM().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, zzb(this.zzlE.zzlW.zzsu));
        }
        if (!(this.zzlE.zzlW.zzyt == null || this.zzlE.zzlW.zzyt.zzsu == null)) {
            zzab.zzaV().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, this.zzlE.zzlW, this.zzlE.zzlM, z, zzb(this.zzlE.zzlW.zzyt.zzsu));
        }
        if (this.zzlE.zzlW.zzsL != null && this.zzlE.zzlW.zzsL.zzsp != null) {
            zzab.zzaV().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, this.zzlE.zzlW, this.zzlE.zzlM, z, this.zzlE.zzlW.zzsL.zzsp);
        }
    }

    public void destroy() {
        zzx.zzbd("destroy must be called on the main UI thread.");
        this.zzlF.cancel();
        this.zzlG.zze(this.zzlE.zzlW);
        this.zzlE.destroy();
    }

    public String getMediationAdapterClassName() {
        return this.zzlE.zzlW != null ? this.zzlE.zzlW.zzsN : null;
    }

    public boolean isReady() {
        zzx.zzbd("isLoaded must be called on the main UI thread.");
        return this.zzlE.zzlQ == null && this.zzlE.zzlU == null && this.zzlE.zzlW != null;
    }

    public void onAdClicked() {
        recordClick();
    }

    public void onAppEvent(String str, String str2) {
        if (this.zzlE.zzlZ != null) {
            try {
                this.zzlE.zzlZ.onAppEvent(str, str2);
            } catch (Throwable e) {
                zzhx.zzd("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        zzx.zzbd("pause must be called on the main UI thread.");
        if (this.zzlE.zzlW != null && this.zzlE.zzmj == 0) {
            zzab.zzaO().zza(this.zzlE.zzlW.zzuq.getWebView());
        }
        if (!(this.zzlE.zzlW == null || this.zzlE.zzlW.zzsM == null)) {
            try {
                this.zzlE.zzlW.zzsM.pause();
            } catch (RemoteException e) {
                zzhx.zzac("Could not pause mediation adapter.");
            }
        }
        this.zzlG.zzf(this.zzlE.zzlW);
        this.zzlF.pause();
    }

    public void recordClick() {
        if (this.zzlE.zzlW == null) {
            zzhx.zzac("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzhx.zzY("Pinging click URLs.");
        this.zzlE.zzlY.zzdY();
        if (this.zzlE.zzlW.zzst != null) {
            zzab.zzaM().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, zzb(this.zzlE.zzlW.zzst));
        }
        if (!(this.zzlE.zzlW.zzyt == null || this.zzlE.zzlW.zzyt.zzst == null)) {
            zzab.zzaV().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, this.zzlE.zzlW, this.zzlE.zzlM, false, zzb(this.zzlE.zzlW.zzyt.zzst));
        }
        if (this.zzlE.zzlR != null) {
            try {
                this.zzlE.zzlR.onAdClicked();
            } catch (Throwable e) {
                zzhx.zzd("Could not notify onAdClicked event.", e);
            }
        }
    }

    public void recordImpression() {
        zze(false);
    }

    public void resume() {
        zzx.zzbd("resume must be called on the main UI thread.");
        if (this.zzlE.zzlW != null && this.zzlE.zzmj == 0) {
            zzab.zzaO().zzb(this.zzlE.zzlW.zzuq.getWebView());
        }
        if (!(this.zzlE.zzlW == null || this.zzlE.zzlW.zzsM == null)) {
            try {
                this.zzlE.zzlW.zzsM.resume();
            } catch (RemoteException e) {
                zzhx.zzac("Could not resume mediation adapter.");
            }
        }
        this.zzlF.resume();
        this.zzlG.zzg(this.zzlE.zzlW);
    }

    public void showInterstitial() {
        zzx.zzbd("showInterstitial must be called on the main UI thread.");
        if (!this.zzlE.zzlV.zzpb) {
            zzhx.zzac("Cannot call showInterstitial on a banner ad.");
        } else if (this.zzlE.zzlW == null) {
            zzhx.zzac("The interstitial has not loaded.");
        } else if (this.zzlE.zzmj == 1) {
        } else {
            if (this.zzlE.zzlW.zzuq.zzeK()) {
                zzhx.zzac("The interstitial is already showing.");
                return;
            }
            this.zzlE.zzlW.zzuq.zzA(true);
            if (this.zzlE.zzlW.zzuq.zzeG().zzba() || this.zzlE.zzlW.zzys != null) {
                zzaf zza = this.zzlG.zza(this.zzlE.zzlV, this.zzlE.zzlW);
                if (this.zzlE.zzlW.zzuq.zzeG().zzba() && zza != null) {
                    zza.zza((zzac) this);
                }
            }
            if (this.zzlE.zzlW.zzwI) {
                try {
                    this.zzlE.zzlW.zzsM.showInterstitial();
                    return;
                } catch (Throwable e) {
                    zzhx.zzd("Could not show interstitial.", e);
                    zzaw();
                    return;
                }
            }
            zzx com_google_android_gms_internal_zzx = new zzx(this.zzlE.zzml, zzao());
            int requestedOrientation = this.zzlE.zzlW.zzuq.getRequestedOrientation();
            if (requestedOrientation == -1) {
                requestedOrientation = this.zzlE.zzlW.orientation;
            }
            zzab.zzaK().zza(this.zzlE.zzlN, new zzeo(this, this, this, this.zzlE.zzlW.zzuq, requestedOrientation, this.zzlE.zzlP, this.zzlE.zzlW.zzwN, com_google_android_gms_internal_zzx));
        }
    }

    public void stopLoading() {
        zzx.zzbd("stopLoading must be called on the main UI thread.");
        this.zzlE.zzf(true);
    }

    Bundle zza(zzan com_google_android_gms_internal_zzan) {
        if (com_google_android_gms_internal_zzan == null) {
            return null;
        }
        String zzbm;
        if (com_google_android_gms_internal_zzan.zzbx()) {
            com_google_android_gms_internal_zzan.wakeup();
        }
        zzak zzbv = com_google_android_gms_internal_zzan.zzbv();
        if (zzbv != null) {
            zzbm = zzbv.zzbm();
            zzhx.zzY("In AdManger: loadAd, " + zzbv.toString());
        } else {
            zzbm = null;
        }
        if (zzbm == null) {
            return null;
        }
        Bundle bundle = new Bundle(1);
        bundle.putString("fingerprint", zzbm);
        bundle.putInt("v", 1);
        return bundle;
    }

    public String zza(String str, String str2, int i) {
        return (((Boolean) zzca.zzqL.get()).booleanValue() && zzz.zzj(this.zzlE.zzlN).isInitialized() && !TextUtils.isEmpty(str)) ? Uri.parse(str).buildUpon().appendQueryParameter("ga_cid", str2).appendQueryParameter("ga_hid", String.valueOf(i)).build().toString() : str;
    }

    public void zza(int i, int i2, int i3, int i4) {
        zzar();
    }

    public void zza(zzaf com_google_android_gms_internal_zzaf, boolean z) {
        if (this.zzlE.zzlW != null && this.zzlE.zzlW.zzuq != null) {
            Map hashMap = new HashMap();
            hashMap.put("isVisible", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.zzlE.zzlW.zzuq.zzb("onAdVisibilityChanged", hashMap);
        }
    }

    public void zza(zzba com_google_android_gms_internal_zzba) {
        zzx.zzbd("setAdSize must be called on the main UI thread.");
        this.zzlE.zzlV = com_google_android_gms_internal_zzba;
        if (this.zzlE.zzlW != null && this.zzlE.zzmj == 0) {
            this.zzlE.zzlW.zzuq.zza(com_google_android_gms_internal_zzba);
        }
        if (this.zzlE.zzlS.getChildCount() > 1) {
            this.zzlE.zzlS.removeView(this.zzlE.zzlS.getNextView());
        }
        this.zzlE.zzlS.setMinimumWidth(com_google_android_gms_internal_zzba.widthPixels);
        this.zzlE.zzlS.setMinimumHeight(com_google_android_gms_internal_zzba.heightPixels);
        this.zzlE.zzlS.requestLayout();
    }

    public void zza(zzbg com_google_android_gms_internal_zzbg) {
        zzx.zzbd("setAdListener must be called on the main UI thread.");
        this.zzlE.zzlR = com_google_android_gms_internal_zzbg;
    }

    public void zza(zzbh com_google_android_gms_internal_zzbh) {
        zzx.zzbd("setAdListener must be called on the main UI thread.");
        this.zzlE.zzlT = com_google_android_gms_internal_zzbh;
    }

    public void zza(zzbk com_google_android_gms_internal_zzbk) {
        zzx.zzbd("setAppEventListener must be called on the main UI thread.");
        this.zzlE.zzlZ = com_google_android_gms_internal_zzbk;
    }

    public void zza(zzbl com_google_android_gms_internal_zzbl) {
        zzx.zzbd("setCorrelationIdProvider must be called on the main UI thread");
        this.zzlE.zzmm = com_google_android_gms_internal_zzbl;
    }

    public void zza(zzcj com_google_android_gms_internal_zzcj) {
        zzx.zzbd("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzlE.zzme = com_google_android_gms_internal_zzcj;
    }

    public void zza(zzfo com_google_android_gms_internal_zzfo) {
        zzx.zzbd("setInAppPurchaseListener must be called on the main UI thread.");
        this.zzlE.zzmb = com_google_android_gms_internal_zzfo;
    }

    public void zza(zzfs com_google_android_gms_internal_zzfs, String str) {
        zzx.zzbd("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.zzlE.zzmg = new zzfl(str);
        this.zzlE.zzma = com_google_android_gms_internal_zzfs;
        if (!zzab.zzaP().zzeh() && com_google_android_gms_internal_zzfs != null) {
            new zzfd(this.zzlE.zzlN, this.zzlE.zzma, this.zzlE.zzmg).start();
        }
    }

    public void zza(com.google.android.gms.internal.zzhe.zza com_google_android_gms_internal_zzhe_zza) {
        zzic com_google_android_gms_internal_zzic;
        String str = null;
        this.zzlz.zza(this.zzlA, "arf");
        this.zzlB = this.zzlz.zzcq();
        this.zzlE.zzlQ = null;
        this.zzlE.zzlX = com_google_android_gms_internal_zzhe_zza;
        zza(null);
        if (com_google_android_gms_internal_zzhe_zza.zzyz.zzwS) {
            com_google_android_gms_internal_zzic = null;
        } else {
            final zzu com_google_android_gms_internal_zzu = new zzu();
            com_google_android_gms_internal_zzic = zza(com_google_android_gms_internal_zzu);
            com_google_android_gms_internal_zzu.zza(new com.google.android.gms.internal.zzu.zzb(com_google_android_gms_internal_zzhe_zza, com_google_android_gms_internal_zzic));
            com_google_android_gms_internal_zzic.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ zzt zzlJ;

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    com_google_android_gms_internal_zzu.recordClick();
                    return false;
                }
            });
            com_google_android_gms_internal_zzic.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ zzt zzlJ;

                public void onClick(View view) {
                    com_google_android_gms_internal_zzu.recordClick();
                }
            });
        }
        if (com_google_android_gms_internal_zzhe_zza.zzlV != null) {
            this.zzlE.zzlV = com_google_android_gms_internal_zzhe_zza.zzlV;
        }
        if (com_google_android_gms_internal_zzhe_zza.errorCode != -2) {
            zza(new zzhe(com_google_android_gms_internal_zzhe_zza, com_google_android_gms_internal_zzic, null, null, null, null, null));
            return;
        }
        if (!com_google_android_gms_internal_zzhe_zza.zzyz.zzwI && com_google_android_gms_internal_zzhe_zza.zzyz.zzwR) {
            if (com_google_android_gms_internal_zzhe_zza.zzyz.zzus != null) {
                str = Uri.parse(com_google_android_gms_internal_zzhe_zza.zzyz.zzus).buildUpon().query(null).build().toString();
            }
            zzci com_google_android_gms_internal_zzcg = new zzcg(this, str, com_google_android_gms_internal_zzhe_zza.zzyz.zzwG);
            try {
                if (this.zzlE.zzme != null) {
                    this.zzlE.zzmj = 1;
                    this.zzlE.zzme.zza(com_google_android_gms_internal_zzcg);
                    return;
                }
            } catch (Throwable e) {
                zzhx.zzd("Could not call the onCustomRenderedAdLoadedListener.", e);
            }
        }
        this.zzlE.zzmj = 0;
        this.zzlE.zzlU = zzab.zzaL().zza(this.zzlE.zzlN, this, com_google_android_gms_internal_zzhe_zza, com_google_android_gms_internal_zzic, this.zzlD, this);
        zzhx.zzY("AdRenderer: " + this.zzlE.zzlU.getClass().getName());
    }

    public void zza(zzhe com_google_android_gms_internal_zzhe) {
        this.zzlz.zza(this.zzlB, "awr");
        this.zzlz.zza(this.zzlA, "ttc");
        this.zzlE.zzlU = null;
        boolean z = com_google_android_gms_internal_zzhe.zzyx != null;
        if (!(com_google_android_gms_internal_zzhe.errorCode == -2 || com_google_android_gms_internal_zzhe.errorCode == 3)) {
            zzab.zzaP().zzb(this.zzlE.zzax());
        }
        if (com_google_android_gms_internal_zzhe.errorCode != -1) {
            if (zza(com_google_android_gms_internal_zzhe, z)) {
                zzhx.zzY("Ad refresh scheduled.");
            }
            if (!(com_google_android_gms_internal_zzhe.errorCode != 3 || com_google_android_gms_internal_zzhe.zzyt == null || com_google_android_gms_internal_zzhe.zzyt.zzsv == null)) {
                zzhx.zzY("Pinging no fill URLs.");
                zzab.zzaV().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, com_google_android_gms_internal_zzhe, this.zzlE.zzlM, false, com_google_android_gms_internal_zzhe.zzyt.zzsv);
            }
            if (com_google_android_gms_internal_zzhe.errorCode != -2) {
                zza(com_google_android_gms_internal_zzhe.errorCode);
                return;
            }
            int i;
            int i2;
            if (!(this.zzlE.zzlV.zzpb || z || this.zzlE.zzmj != 0)) {
                if (!zzb(com_google_android_gms_internal_zzhe)) {
                    zza(0);
                    return;
                } else if (this.zzlE.zzlS != null) {
                    this.zzlE.zzlS.zzlL.zzV(com_google_android_gms_internal_zzhe.zzwN);
                }
            }
            if (!(this.zzlE.zzlW == null || this.zzlE.zzlW.zzsO == null)) {
                this.zzlE.zzlW.zzsO.zza(null);
            }
            if (com_google_android_gms_internal_zzhe.zzsO != null) {
                com_google_android_gms_internal_zzhe.zzsO.zza((zzdl) this);
            }
            this.zzlG.zzd(this.zzlE.zzlW);
            this.zzlE.zzlW = com_google_android_gms_internal_zzhe;
            this.zzlE.zzlY.zzj(com_google_android_gms_internal_zzhe.zzyv);
            this.zzlE.zzlY.zzk(com_google_android_gms_internal_zzhe.zzyw);
            this.zzlE.zzlY.zzx(this.zzlE.zzlV.zzpb);
            this.zzlE.zzlY.zzy(com_google_android_gms_internal_zzhe.zzwI);
            if (!(this.zzlE.zzlV.zzpb || z || this.zzlE.zzmj != 0)) {
                zze(false);
            }
            if (this.zzlE.zzmh == null) {
                this.zzlE.zzmh = new zzhj(this.zzlE.zzlM);
            }
            if (com_google_android_gms_internal_zzhe.zzyt != null) {
                i = com_google_android_gms_internal_zzhe.zzyt.zzsy;
                i2 = com_google_android_gms_internal_zzhe.zzyt.zzsz;
            } else {
                i2 = 0;
                i = 0;
            }
            this.zzlE.zzmh.zzg(i, i2);
            if (this.zzlE.zzmj == 0) {
                if (!(this.zzlE.zzlV.zzpb || com_google_android_gms_internal_zzhe.zzuq == null || (!com_google_android_gms_internal_zzhe.zzuq.zzeG().zzba() && com_google_android_gms_internal_zzhe.zzys == null))) {
                    zzaf zza = this.zzlG.zza(this.zzlE.zzlV, this.zzlE.zzlW);
                    if (com_google_android_gms_internal_zzhe.zzuq.zzeG().zzba() && zza != null) {
                        zza.zza((zzac) this);
                    }
                }
                if (this.zzlE.zzlW.zzuq != null) {
                    this.zzlE.zzlW.zzuq.zzeG().zzeR();
                }
                if (z) {
                    com.google.android.gms.internal.zzcn.zza com_google_android_gms_internal_zzcn_zza = com_google_android_gms_internal_zzhe.zzyx;
                    if ((com_google_android_gms_internal_zzcn_zza instanceof zzcm) && this.zzlE.zzmd != null) {
                        zzau();
                    } else if (!(com_google_android_gms_internal_zzcn_zza instanceof zzcl) || this.zzlE.zzmc == null) {
                        zzhx.zzac("No matching listener for retrieved native ad template.");
                        zza(0);
                        return;
                    } else {
                        zzat();
                    }
                }
                zzas();
            } else if (!(this.zzlE.zzmi == null || com_google_android_gms_internal_zzhe.zzys == null)) {
                this.zzlG.zza(this.zzlE.zzlV, this.zzlE.zzlW, this.zzlE.zzmi);
            }
            if (zzab.zzaP().zzeg() != null) {
                zzab.zzaP().zzeg().zza(this.zzlz);
            }
        }
    }

    public void zza(String str, ArrayList<String> arrayList) {
        zzfn com_google_android_gms_internal_zzfe = new zzfe(str, arrayList, this.zzlE.zzlN, this.zzlE.zzlP.zzzH);
        if (this.zzlE.zzmb == null) {
            zzhx.zzac("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!zzbe.zzbD().zzA(this.zzlE.zzlN)) {
                zzhx.zzac("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            } else if (this.zzlE.zzma == null) {
                zzhx.zzac("PlayStorePurchaseListener is not set.");
                return;
            } else if (this.zzlE.zzmg == null) {
                zzhx.zzac("PlayStorePurchaseVerifier is not initialized.");
                return;
            } else if (this.zzlE.zzmk) {
                zzhx.zzac("An in-app purchase request is already in progress, abort");
                return;
            } else {
                this.zzlE.zzmk = true;
                try {
                    if (this.zzlE.zzma.isValidPurchase(str)) {
                        zzab.zzaU().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzK, new zzfb(this.zzlE.zzlN, this.zzlE.zzmg, com_google_android_gms_internal_zzfe, this));
                        return;
                    } else {
                        this.zzlE.zzmk = false;
                        return;
                    }
                } catch (RemoteException e) {
                    zzhx.zzac("Could not start In-App purchase.");
                    this.zzlE.zzmk = false;
                    return;
                }
            }
        }
        try {
            this.zzlE.zzmb.zza(com_google_android_gms_internal_zzfe);
        } catch (RemoteException e2) {
            zzhx.zzac("Could not start In-App purchase.");
        }
    }

    public void zza(String str, boolean z, int i, final Intent intent, zzfg com_google_android_gms_internal_zzfg) {
        try {
            if (this.zzlE.zzma != null) {
                this.zzlE.zzma.zza(new zzfh(this.zzlE.zzlN, str, z, i, intent, com_google_android_gms_internal_zzfg));
            }
        } catch (RemoteException e) {
            zzhx.zzac("Fail to invoke PlayStorePurchaseListener.");
        }
        zzhw.zzzG.postDelayed(new Runnable(this) {
            final /* synthetic */ zzt zzlJ;

            public void run() {
                int zzd = zzab.zzaU().zzd(intent);
                zzab.zzaU();
                if (!(zzd != 0 || this.zzlJ.zzlE.zzlW == null || this.zzlJ.zzlE.zzlW.zzuq == null || this.zzlJ.zzlE.zzlW.zzuq.zzeF() == null)) {
                    this.zzlJ.zzlE.zzlW.zzuq.zzeF().close();
                }
                this.zzlJ.zzlE.zzmk = false;
            }
        }, 500);
    }

    public void zza(HashSet<zzhf> hashSet) {
        this.zzlE.zza(hashSet);
    }

    public void zza(List<String> list) {
        zzx.zzbd("setNativeTemplates must be called on the main UI thread.");
        this.zzlE.zzmf = list;
    }

    public boolean zza(zzax com_google_android_gms_internal_zzax) {
        zzx.zzbd("loadAd must be called on the main UI thread.");
        if (this.zzlE.zzlQ != null || this.zzlE.zzlU != null) {
            if (this.zzlC != null) {
                zzhx.zzac("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            }
            this.zzlC = com_google_android_gms_internal_zzax;
            return false;
        } else if (this.zzlE.zzlV.zzpb && this.zzlE.zzlW != null) {
            zzhx.zzac("An interstitial is already loading. Aborting.");
            return false;
        } else if (!zzav()) {
            return false;
        } else {
            zzhx.zzaa("Starting ad request.");
            zzab();
            this.zzlA = this.zzlz.zzcq();
            if (!com_google_android_gms_internal_zzax.zzoO) {
                zzhx.zzaa("Use AdRequest.Builder.addTestDevice(\"" + zzbe.zzbD().zzz(this.zzlE.zzlN) + "\") to get test ads on this device.");
            }
            Bundle zza = zza(zzab.zzaP().zzo(this.zzlE.zzlN));
            this.zzlF.cancel();
            this.zzlE.zzmj = 0;
            com.google.android.gms.internal.zzgo.zza zza2 = zza(com_google_android_gms_internal_zzax, zza);
            this.zzlE.zzlQ = zzab.zzaI().zza(this.zzlE.zzlN, zza2, this.zzlE.zzlO, this);
            return true;
        }
    }

    boolean zza(zzhe com_google_android_gms_internal_zzhe, boolean z) {
        zzax com_google_android_gms_internal_zzax;
        int i = 0;
        if (this.zzlC != null) {
            com_google_android_gms_internal_zzax = this.zzlC;
            this.zzlC = null;
        } else {
            com_google_android_gms_internal_zzax = com_google_android_gms_internal_zzhe.zzwn;
            if (com_google_android_gms_internal_zzax.extras != null) {
                i = com_google_android_gms_internal_zzax.extras.getBoolean("_noRefresh", false);
            }
        }
        i |= z;
        if (this.zzlE.zzlV.zzpb) {
            if (this.zzlE.zzmj == 0) {
                zzab.zzaO().zza(com_google_android_gms_internal_zzhe.zzuq.getWebView());
            }
        } else if (i == 0 && this.zzlE.zzmj == 0) {
            if (com_google_android_gms_internal_zzhe.zzsx > 0) {
                this.zzlF.zza(com_google_android_gms_internal_zzax, com_google_android_gms_internal_zzhe.zzsx);
            } else if (com_google_android_gms_internal_zzhe.zzyt != null && com_google_android_gms_internal_zzhe.zzyt.zzsx > 0) {
                this.zzlF.zza(com_google_android_gms_internal_zzax, com_google_android_gms_internal_zzhe.zzyt.zzsx);
            } else if (!com_google_android_gms_internal_zzhe.zzwI && com_google_android_gms_internal_zzhe.errorCode == 2) {
                this.zzlF.zzc(com_google_android_gms_internal_zzax);
            }
        }
        return this.zzlF.zzaG();
    }

    void zzab() {
        this.zzlz = new zzcf("load_ad");
        this.zzlA = new zzce(-1, null, null);
        this.zzlB = new zzce(-1, null, null);
    }

    public zzd zzac() {
        zzx.zzbd("getAdFrame must be called on the main UI thread.");
        return zze.zzn(this.zzlE.zzlS);
    }

    public zzba zzad() {
        zzx.zzbd("getAdSize must be called on the main UI thread.");
        return this.zzlE.zzlV;
    }

    public void zzae() {
        zzaq();
    }

    public void zzaf() {
        this.zzlG.zzd(this.zzlE.zzlW);
        if (this.zzlE.zzlV.zzpb) {
            zzaw();
        }
        this.zzlH = false;
        zzap();
        this.zzlE.zzlY.zzdZ();
    }

    public void zzag() {
        if (this.zzlE.zzlV.zzpb) {
            zze(false);
        }
        this.zzlH = true;
        zzar();
    }

    public void zzah() {
        onAdClicked();
    }

    public void zzai() {
        zzaf();
    }

    public void zzaj() {
        zzae();
    }

    public void zzak() {
        zzag();
    }

    public void zzal() {
        if (this.zzlE.zzlW != null) {
            zzhx.zzac("Mediation adapter " + this.zzlE.zzlW.zzsN + " refreshed, but mediation adapters should never refresh.");
        }
        zze(true);
        zzas();
    }

    public void zzam() {
        zzap();
    }

    public void zzan() {
        zzx.zzbd("recordManualImpression must be called on the main UI thread.");
        if (this.zzlE.zzlW == null) {
            zzhx.zzac("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzhx.zzY("Pinging manual tracking URLs.");
        if (this.zzlE.zzlW.zzwK != null) {
            zzab.zzaM().zza(this.zzlE.zzlN, this.zzlE.zzlP.zzzH, this.zzlE.zzlW.zzwK);
        }
    }

    protected boolean zzao() {
        if (!(this.zzlE.zzlN instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.zzlE.zzlN).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        boolean z = (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
        return z;
    }

    public boolean zzav() {
        boolean z = true;
        if (!zzab.zzaM().zza(this.zzlE.zzlN.getPackageManager(), this.zzlE.zzlN.getPackageName(), "android.permission.INTERNET")) {
            if (!this.zzlE.zzlV.zzpb) {
                zzbe.zzbD().zza(this.zzlE.zzlS, this.zzlE.zzlV, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            z = false;
        }
        if (!zzab.zzaM().zzt(this.zzlE.zzlN)) {
            if (!this.zzlE.zzlV.zzpb) {
                zzbe.zzbD().zza(this.zzlE.zzlS, this.zzlE.zzlV, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            z = false;
        }
        if (!(z || this.zzlE.zzlV.zzpb)) {
            this.zzlE.zzlS.setVisibility(0);
        }
        return z;
    }

    public ArrayList<String> zzb(List<String> list) {
        String str = this.zzlE.zzlW.zzwD;
        int zzaF = zzz.zzj(this.zzlE.zzlN).zzaF();
        ArrayList<String> arrayList = new ArrayList();
        for (String zza : list) {
            arrayList.add(zza(zza, str, zzaF));
        }
        return arrayList;
    }

    public void zzb(View view) {
        this.zzlE.zzmi = view;
        zza(new zzhe(this.zzlE.zzlX, null, null, null, null, null, null));
    }

    public void zzb(zzax com_google_android_gms_internal_zzax) {
        ViewParent parent = this.zzlE.zzlS.getParent();
        if ((parent instanceof View) && ((View) parent).isShown() && zzab.zzaM().zzes() && !this.zzlH) {
            zza(com_google_android_gms_internal_zzax);
            return;
        }
        zzhx.zzaa("Ad is not visible. Not refreshing ad.");
        this.zzlF.zzc(com_google_android_gms_internal_zzax);
    }

    protected void zzc(View view) {
        this.zzlE.zzlS.addView(view, new LayoutParams(-2, -2));
    }

    public void zzd(boolean z) {
        this.zzlE.zzml = z;
    }
}
