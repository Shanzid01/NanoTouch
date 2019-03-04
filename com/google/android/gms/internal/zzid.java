package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.widget.FacebookDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@zzgi
public class zzid extends WebViewClient {
    protected final zzic zzmu;
    private boolean zzng;
    private final Object zznh;
    private zzat zzoJ;
    private zzcy zzrJ;
    private zzu zzrK;
    private zzeb zzrL;
    private zzcw zzrN;
    private zzct zzry;
    private zzeh zztq;
    private zza zzvD;
    private final HashMap<String, List<zzcv>> zzzQ;
    private zzep zzzR;
    private boolean zzzS;
    private zzes zzzT;
    private final zzef zzzU;
    private boolean zzzV;
    private boolean zzzW;
    private int zzzX;

    public interface zza {
        void zza(zzic com_google_android_gms_internal_zzic, boolean z);
    }

    class zzb implements zzcv {
        final /* synthetic */ zzid zzzZ;

        private zzb(zzid com_google_android_gms_internal_zzid) {
            this.zzzZ = com_google_android_gms_internal_zzid;
        }

        public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                this.zzzZ.zzeN();
            } else if (map.keySet().contains("stop")) {
                this.zzzZ.zzeO();
            } else if (map.keySet().contains(FacebookDialog.COMPLETION_GESTURE_CANCEL)) {
                this.zzzZ.zzeP();
            }
        }
    }

    public zzid(zzic com_google_android_gms_internal_zzic, boolean z) {
        this(com_google_android_gms_internal_zzic, z, new zzef(com_google_android_gms_internal_zzic, com_google_android_gms_internal_zzic.zzeE(), new zzbu(com_google_android_gms_internal_zzic.getContext())));
    }

    zzid(zzic com_google_android_gms_internal_zzic, boolean z, zzef com_google_android_gms_internal_zzef) {
        this.zzzQ = new HashMap();
        this.zznh = new Object();
        this.zzzS = false;
        this.zzmu = com_google_android_gms_internal_zzic;
        this.zzng = z;
        this.zzzU = com_google_android_gms_internal_zzef;
    }

    private void zzeN() {
        this.zzzX++;
        zzeQ();
    }

    private void zzeO() {
        this.zzzX--;
        zzeQ();
    }

    private void zzeP() {
        this.zzzW = true;
        zzeQ();
    }

    private static boolean zzf(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void zzg(Uri uri) {
        String path = uri.getPath();
        List<zzcv> list = (List) this.zzzQ.get(path);
        if (list != null) {
            Map zzd = zzab.zzaM().zzd(uri);
            if (zzhx.zzA(2)) {
                zzhx.zzab("Received GMSG: " + path);
                for (String path2 : zzd.keySet()) {
                    zzhx.zzab("  " + path2 + ": " + ((String) zzd.get(path2)));
                }
            }
            for (zzcv zza : list) {
                zza.zza(this.zzmu, zzd);
            }
            return;
        }
        zzhx.zzab("No GMSG handler found for GMSG: " + uri);
    }

    public final void onLoadResource(WebView webView, String str) {
        zzhx.zzab("Loading resource: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzg(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        this.zzzV = true;
        zzeQ();
    }

    public final void reset() {
        synchronized (this.zznh) {
            this.zzzQ.clear();
            this.zzoJ = null;
            this.zzzR = null;
            this.zzvD = null;
            this.zzry = null;
            this.zzzS = false;
            this.zzng = false;
            this.zzrN = null;
            this.zzzT = null;
            if (this.zzrL != null) {
                this.zzrL.zzm(true);
                this.zzrL = null;
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzhx.zzab("AdWebView shouldOverrideUrlLoading: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzg(parse);
        } else if (this.zzzS && webView == this.zzmu && zzf(parse)) {
            return super.shouldOverrideUrlLoading(webView, str);
        } else {
            if (this.zzmu.willNotDraw()) {
                zzhx.zzac("AdWebView unable to handle URL: " + str);
            } else {
                Uri uri;
                try {
                    zzk zzeI = this.zzmu.zzeI();
                    if (zzeI != null && zzeI.zzb(parse)) {
                        parse = zzeI.zza(parse, this.zzmu.getContext());
                    }
                    uri = parse;
                } catch (zzl e) {
                    zzhx.zzac("Unable to append parameter to URL: " + str);
                    uri = parse;
                }
                if (this.zzrK == null || this.zzrK.zzaB()) {
                    zza(new zzek("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
                } else {
                    this.zzrK.zzd(str);
                }
            }
        }
        return true;
    }

    public void zzC(boolean z) {
        this.zzzS = z;
    }

    public final void zza(zzek com_google_android_gms_internal_zzek) {
        zzep com_google_android_gms_internal_zzep = null;
        boolean zzeK = this.zzmu.zzeK();
        zzat com_google_android_gms_internal_zzat = (!zzeK || this.zzmu.zzad().zzpb) ? this.zzoJ : null;
        if (!zzeK) {
            com_google_android_gms_internal_zzep = this.zzzR;
        }
        zza(new zzeo(com_google_android_gms_internal_zzek, com_google_android_gms_internal_zzat, com_google_android_gms_internal_zzep, this.zzzT, this.zzmu.zzeJ()));
    }

    public void zza(zzeo com_google_android_gms_internal_zzeo) {
        boolean z = false;
        boolean zzcP = this.zzrL != null ? this.zzrL.zzcP() : false;
        zzem zzaK = zzab.zzaK();
        Context context = this.zzmu.getContext();
        if (!zzcP) {
            z = true;
        }
        zzaK.zza(context, com_google_android_gms_internal_zzeo, z);
    }

    public void zza(zza com_google_android_gms_internal_zzid_zza) {
        this.zzvD = com_google_android_gms_internal_zzid_zza;
    }

    public final void zza(String str, zzcv com_google_android_gms_internal_zzcv) {
        synchronized (this.zznh) {
            List list = (List) this.zzzQ.get(str);
            if (list == null) {
                list = new ArrayList();
                this.zzzQ.put(str, list);
            }
            list.add(com_google_android_gms_internal_zzcv);
        }
    }

    public final void zza(boolean z, int i) {
        zzat com_google_android_gms_internal_zzat = (!this.zzmu.zzeK() || this.zzmu.zzad().zzpb) ? this.zzoJ : null;
        zza(new zzeo(com_google_android_gms_internal_zzat, this.zzzR, this.zzzT, this.zzmu, z, i, this.zzmu.zzeJ()));
    }

    public final void zza(boolean z, int i, String str) {
        zzep com_google_android_gms_internal_zzep = null;
        boolean zzeK = this.zzmu.zzeK();
        zzat com_google_android_gms_internal_zzat = (!zzeK || this.zzmu.zzad().zzpb) ? this.zzoJ : null;
        if (!zzeK) {
            com_google_android_gms_internal_zzep = this.zzzR;
        }
        zza(new zzeo(com_google_android_gms_internal_zzat, com_google_android_gms_internal_zzep, this.zzry, this.zzzT, this.zzmu, z, i, str, this.zzmu.zzeJ(), this.zzrN));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzeK = this.zzmu.zzeK();
        zzat com_google_android_gms_internal_zzat = (!zzeK || this.zzmu.zzad().zzpb) ? this.zzoJ : null;
        zza(new zzeo(com_google_android_gms_internal_zzat, zzeK ? null : this.zzzR, this.zzry, this.zzzT, this.zzmu, z, i, str, str2, this.zzmu.zzeJ(), this.zzrN));
    }

    public void zzb(int i, int i2) {
        this.zzzU.zzf(i, i2);
        if (this.zzrL != null) {
            this.zzrL.zzb(i, i2);
        }
    }

    public void zzb(zzat com_google_android_gms_internal_zzat, zzep com_google_android_gms_internal_zzep, zzct com_google_android_gms_internal_zzct, zzes com_google_android_gms_internal_zzes, boolean z, zzcw com_google_android_gms_internal_zzcw, zzcy com_google_android_gms_internal_zzcy, zzu com_google_android_gms_internal_zzu, zzeh com_google_android_gms_internal_zzeh) {
        if (com_google_android_gms_internal_zzu == null) {
            com_google_android_gms_internal_zzu = new zzu(false);
        }
        this.zzrL = new zzeb(this.zzmu, com_google_android_gms_internal_zzeh);
        zza("/appEvent", new zzcs(com_google_android_gms_internal_zzct));
        zza("/canOpenURLs", zzcu.zzrA);
        zza("/canOpenIntents", zzcu.zzrB);
        zza("/click", zzcu.zzrC);
        zza("/close", zzcu.zzrD);
        zza("/customClose", zzcu.zzrE);
        zza("/delayPageLoaded", new zzb());
        zza("/httpTrack", zzcu.zzrF);
        zza("/log", zzcu.zzrG);
        zza("/mraid", new zzcz(com_google_android_gms_internal_zzu, this.zzrL));
        zza("/open", new zzda(com_google_android_gms_internal_zzcw, com_google_android_gms_internal_zzu, this.zzrL));
        zza("/touch", zzcu.zzrH);
        zza("/video", zzcu.zzrI);
        if (com_google_android_gms_internal_zzcy != null) {
            zza("/setInterstitialProperties", new zzcx(com_google_android_gms_internal_zzcy));
        }
        this.zzoJ = com_google_android_gms_internal_zzat;
        this.zzzR = com_google_android_gms_internal_zzep;
        this.zzry = com_google_android_gms_internal_zzct;
        this.zzrN = com_google_android_gms_internal_zzcw;
        this.zzzT = com_google_android_gms_internal_zzes;
        this.zzrK = com_google_android_gms_internal_zzu;
        this.zztq = com_google_android_gms_internal_zzeh;
        this.zzrJ = com_google_android_gms_internal_zzcy;
        zzC(z);
    }

    public final void zzb(String str, zzcv com_google_android_gms_internal_zzcv) {
        synchronized (this.zznh) {
            List list = (List) this.zzzQ.get(str);
            if (list == null) {
                return;
            }
            list.remove(com_google_android_gms_internal_zzcv);
        }
    }

    public boolean zzba() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzng;
        }
        return z;
    }

    public final void zzde() {
        synchronized (this.zznh) {
            this.zzzS = false;
            this.zzng = true;
            this.zzmu.zzeL();
            final zzel zzeF = this.zzmu.zzeF();
            if (zzeF != null) {
                if (zzbe.zzbD().zzeC()) {
                    zzeF.zzde();
                } else {
                    zzhw.zzzG.post(new Runnable(this) {
                        final /* synthetic */ zzid zzzZ;

                        public void run() {
                            zzeF.zzde();
                        }
                    });
                }
            }
        }
    }

    public void zze(int i, int i2) {
        if (this.zzrL != null) {
            this.zzrL.zze(i, i2);
        }
    }

    public zzu zzeM() {
        return this.zzrK;
    }

    public final void zzeQ() {
        if (this.zzvD == null) {
            return;
        }
        if ((this.zzzV && this.zzzX == 0) || this.zzzW) {
            this.zzvD.zza(this.zzmu, !this.zzzW);
            this.zzvD = null;
        }
    }

    public void zzeR() {
        if (zzba()) {
            this.zzzU.zzcV();
        }
    }
}
