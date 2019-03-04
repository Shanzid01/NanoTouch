package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public class zzif extends WebView implements OnGlobalLayoutListener, DownloadListener, zzic {
    private final zza zzAa;
    private zzel zzAb;
    private boolean zzAc;
    private boolean zzAd;
    private boolean zzAe;
    private boolean zzAf;
    private boolean zzAg;
    private int zzAh;
    boolean zzAi;
    private final Object zznh = new Object();
    private final zzhy zznl;
    private final WindowManager zznu;
    private zzba zzsF;
    private int zztI = -1;
    private int zztJ = -1;
    private int zztL = -1;
    private int zztM = -1;
    private final zzid zzvy;
    private final zzk zzwg;
    private Boolean zzyV;

    @zzgi
    public class zza extends MutableContextWrapper {
        private Activity zzAj;
        private Context zzAk;
        private Context zznk;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Object getSystemService(String str) {
            return this.zzAk.getSystemService(str);
        }

        public void setBaseContext(Context context) {
            this.zznk = context.getApplicationContext();
            this.zzAj = context instanceof Activity ? (Activity) context : null;
            this.zzAk = context;
            super.setBaseContext(this.zznk);
        }

        public void startActivity(Intent intent) {
            if (this.zzAj == null || zzme.zzkk()) {
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                this.zznk.startActivity(intent);
                return;
            }
            this.zzAj.startActivity(intent);
        }

        public Activity zzeD() {
            return this.zzAj;
        }

        public Context zzeE() {
            return this.zzAk;
        }
    }

    protected zzif(zza com_google_android_gms_internal_zzif_zza, zzba com_google_android_gms_internal_zzba, boolean z, boolean z2, zzk com_google_android_gms_internal_zzk, zzhy com_google_android_gms_internal_zzhy) {
        super(com_google_android_gms_internal_zzif_zza);
        this.zzAa = com_google_android_gms_internal_zzif_zza;
        this.zzsF = com_google_android_gms_internal_zzba;
        this.zzAe = z;
        this.zzAg = false;
        this.zzAh = -1;
        this.zzwg = com_google_android_gms_internal_zzk;
        this.zznl = com_google_android_gms_internal_zzhy;
        this.zznu = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        zzab.zzaM().zza((Context) com_google_android_gms_internal_zzif_zza, com_google_android_gms_internal_zzhy.zzzH, settings);
        zzab.zzaO().zza(getContext(), settings);
        setDownloadListener(this);
        this.zzvy = zzab.zzaO().zzb((zzic) this, z2);
        setWebViewClient(this.zzvy);
        setWebChromeClient(zzab.zzaO().zzb((zzic) this));
        zzeW();
    }

    static zzif zzb(Context context, zzba com_google_android_gms_internal_zzba, boolean z, boolean z2, zzk com_google_android_gms_internal_zzk, zzhy com_google_android_gms_internal_zzhy) {
        return new zzif(new zza(context), com_google_android_gms_internal_zzba, z, z2, com_google_android_gms_internal_zzk, com_google_android_gms_internal_zzhy);
    }

    private void zzeT() {
        synchronized (this.zznh) {
            this.zzyV = zzab.zzaP().zzek();
            if (this.zzyV == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    zzb(Boolean.valueOf(true));
                } catch (IllegalStateException e) {
                    zzb(Boolean.valueOf(false));
                }
            }
        }
    }

    private void zzeU() {
        Activity zzeD = zzeD();
        if (this.zzAg && zzeD != null) {
            zzab.zzaO().zzb(zzeD, (OnGlobalLayoutListener) this);
            this.zzAg = false;
        }
    }

    private void zzeW() {
        synchronized (this.zznh) {
            if (this.zzAe || this.zzsF.zzpb) {
                if (VERSION.SDK_INT < 14) {
                    zzhx.zzY("Disabling hardware acceleration on an overlay.");
                    zzeX();
                } else {
                    zzhx.zzY("Enabling hardware acceleration on an overlay.");
                    zzeY();
                }
            } else if (VERSION.SDK_INT < 18) {
                zzhx.zzY("Disabling hardware acceleration on an AdView.");
                zzeX();
            } else {
                zzhx.zzY("Enabling hardware acceleration on an AdView.");
                zzeY();
            }
        }
    }

    private void zzeX() {
        synchronized (this.zznh) {
            if (!this.zzAf) {
                zzab.zzaO().zzk(this);
            }
            this.zzAf = true;
        }
    }

    private void zzeY() {
        synchronized (this.zznh) {
            if (this.zzAf) {
                zzab.zzaO().zzj(this);
            }
            this.zzAf = false;
        }
    }

    public void destroy() {
        synchronized (this.zznh) {
            zzeU();
            if (this.zzAb != null) {
                this.zzAb.close();
                this.zzAb.onDestroy();
                this.zzAb = null;
            }
            this.zzvy.reset();
            if (this.zzAd) {
                return;
            }
            this.zzAd = true;
            super.destroy();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void evaluateJavascript(java.lang.String r3, android.webkit.ValueCallback<java.lang.String> r4) {
        /*
        r2 = this;
        r1 = r2.zznh;
        monitor-enter(r1);
        r0 = r2.isDestroyed();	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x0016;
    L_0x0009:
        r0 = "The webview is destroyed. Ignoring action.";
        com.google.android.gms.internal.zzhx.zzac(r0);	 Catch:{ all -> 0x001b }
        if (r4 == 0) goto L_0x0014;
    L_0x0010:
        r0 = 0;
        r4.onReceiveValue(r0);	 Catch:{ all -> 0x001b }
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
    L_0x0015:
        return;
    L_0x0016:
        super.evaluateJavascript(r3, r4);	 Catch:{ all -> 0x001b }
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x0015;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzif.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    public int getRequestedOrientation() {
        int i;
        synchronized (this.zznh) {
            i = this.zzAh;
        }
        return i;
    }

    public WebView getWebView() {
        return this;
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzAd;
        }
        return z;
    }

    public void loadData(String str, String str2, String str3) {
        synchronized (this.zznh) {
            if (isDestroyed()) {
                zzhx.zzac("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.zznh) {
            if (isDestroyed()) {
                zzhx.zzac("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    protected void onAttachedToWindow() {
        synchronized (this.zznh) {
            super.onAttachedToWindow();
            this.zzAi = true;
            if (this.zzvy.zzba()) {
                zzeV();
            }
        }
    }

    protected void onDetachedFromWindow() {
        synchronized (this.zznh) {
            zzeU();
            this.zzAi = false;
            super.onDetachedFromWindow();
        }
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            zzhx.zzY("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
        }
    }

    protected void onDraw(Canvas canvas) {
        if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
            super.onDraw(canvas);
        }
    }

    public void onGlobalLayout() {
        boolean zzeS = zzeS();
        zzel zzeF = zzeF();
        if (zzeF != null && zzeS) {
            zzeF.zzdg();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r10, int r11) {
        /*
        r9 = this;
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = 8;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = r9.zznh;
        monitor-enter(r4);
        r1 = r9.isInEditMode();	 Catch:{ all -> 0x0038 }
        if (r1 != 0) goto L_0x0016;
    L_0x0012:
        r1 = r9.zzAe;	 Catch:{ all -> 0x0038 }
        if (r1 == 0) goto L_0x001b;
    L_0x0016:
        super.onMeasure(r10, r11);	 Catch:{ all -> 0x0038 }
        monitor-exit(r4);	 Catch:{ all -> 0x0038 }
    L_0x001a:
        return;
    L_0x001b:
        r1 = r9.zzsF;	 Catch:{ all -> 0x0038 }
        r1 = r1.zzpb;	 Catch:{ all -> 0x0038 }
        if (r1 == 0) goto L_0x003b;
    L_0x0021:
        r0 = new android.util.DisplayMetrics;	 Catch:{ all -> 0x0038 }
        r0.<init>();	 Catch:{ all -> 0x0038 }
        r1 = r9.zznu;	 Catch:{ all -> 0x0038 }
        r1 = r1.getDefaultDisplay();	 Catch:{ all -> 0x0038 }
        r1.getMetrics(r0);	 Catch:{ all -> 0x0038 }
        r1 = r0.widthPixels;	 Catch:{ all -> 0x0038 }
        r0 = r0.heightPixels;	 Catch:{ all -> 0x0038 }
        r9.setMeasuredDimension(r1, r0);	 Catch:{ all -> 0x0038 }
        monitor-exit(r4);	 Catch:{ all -> 0x0038 }
        goto L_0x001a;
    L_0x0038:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0038 }
        throw r0;
    L_0x003b:
        r2 = android.view.View.MeasureSpec.getMode(r10);	 Catch:{ all -> 0x0038 }
        r3 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x0038 }
        r5 = android.view.View.MeasureSpec.getMode(r11);	 Catch:{ all -> 0x0038 }
        r1 = android.view.View.MeasureSpec.getSize(r11);	 Catch:{ all -> 0x0038 }
        if (r2 == r6) goto L_0x004f;
    L_0x004d:
        if (r2 != r8) goto L_0x00e4;
    L_0x004f:
        r2 = r3;
    L_0x0050:
        if (r5 == r6) goto L_0x0054;
    L_0x0052:
        if (r5 != r8) goto L_0x0055;
    L_0x0054:
        r0 = r1;
    L_0x0055:
        r5 = r9.zzsF;	 Catch:{ all -> 0x0038 }
        r5 = r5.widthPixels;	 Catch:{ all -> 0x0038 }
        if (r5 > r2) goto L_0x0061;
    L_0x005b:
        r2 = r9.zzsF;	 Catch:{ all -> 0x0038 }
        r2 = r2.heightPixels;	 Catch:{ all -> 0x0038 }
        if (r2 <= r0) goto L_0x00ce;
    L_0x0061:
        r0 = r9.zzAa;	 Catch:{ all -> 0x0038 }
        r0 = r0.getResources();	 Catch:{ all -> 0x0038 }
        r0 = r0.getDisplayMetrics();	 Catch:{ all -> 0x0038 }
        r0 = r0.density;	 Catch:{ all -> 0x0038 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0038 }
        r2.<init>();	 Catch:{ all -> 0x0038 }
        r5 = "Not enough space to show ad. Needs ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x0038 }
        r5 = r9.zzsF;	 Catch:{ all -> 0x0038 }
        r5 = r5.widthPixels;	 Catch:{ all -> 0x0038 }
        r5 = (float) r5;	 Catch:{ all -> 0x0038 }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x0038 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x0038 }
        r5 = "x";
        r2 = r2.append(r5);	 Catch:{ all -> 0x0038 }
        r5 = r9.zzsF;	 Catch:{ all -> 0x0038 }
        r5 = r5.heightPixels;	 Catch:{ all -> 0x0038 }
        r5 = (float) r5;	 Catch:{ all -> 0x0038 }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x0038 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x0038 }
        r5 = " dp, but only has ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x0038 }
        r3 = (float) r3;	 Catch:{ all -> 0x0038 }
        r3 = r3 / r0;
        r3 = (int) r3;	 Catch:{ all -> 0x0038 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x0038 }
        r3 = "x";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0038 }
        r1 = (float) r1;	 Catch:{ all -> 0x0038 }
        r0 = r1 / r0;
        r0 = (int) r0;	 Catch:{ all -> 0x0038 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0038 }
        r1 = " dp.";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0038 }
        r0 = r0.toString();	 Catch:{ all -> 0x0038 }
        com.google.android.gms.internal.zzhx.zzac(r0);	 Catch:{ all -> 0x0038 }
        r0 = r9.getVisibility();	 Catch:{ all -> 0x0038 }
        if (r0 == r7) goto L_0x00c6;
    L_0x00c2:
        r0 = 4;
        r9.setVisibility(r0);	 Catch:{ all -> 0x0038 }
    L_0x00c6:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0038 }
    L_0x00cb:
        monitor-exit(r4);	 Catch:{ all -> 0x0038 }
        goto L_0x001a;
    L_0x00ce:
        r0 = r9.getVisibility();	 Catch:{ all -> 0x0038 }
        if (r0 == r7) goto L_0x00d8;
    L_0x00d4:
        r0 = 0;
        r9.setVisibility(r0);	 Catch:{ all -> 0x0038 }
    L_0x00d8:
        r0 = r9.zzsF;	 Catch:{ all -> 0x0038 }
        r0 = r0.widthPixels;	 Catch:{ all -> 0x0038 }
        r1 = r9.zzsF;	 Catch:{ all -> 0x0038 }
        r1 = r1.heightPixels;	 Catch:{ all -> 0x0038 }
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0038 }
        goto L_0x00cb;
    L_0x00e4:
        r2 = r0;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzif.onMeasure(int, int):void");
    }

    public void onPause() {
        if (!isDestroyed()) {
            try {
                super.onPause();
            } catch (Throwable e) {
                zzhx.zzb("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            try {
                super.onResume();
            } catch (Throwable e) {
                zzhx.zzb("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zzwg != null) {
            this.zzwg.zza(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setContext(Context context) {
        this.zzAa.setBaseContext(context);
    }

    public void setRequestedOrientation(int i) {
        synchronized (this.zznh) {
            this.zzAh = i;
            if (this.zzAb != null) {
                this.zzAb.setRequestedOrientation(this.zzAh);
            }
        }
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                zzhx.zzb("Could not stop loading webview.", e);
            }
        }
    }

    public void zzA(boolean z) {
        synchronized (this.zznh) {
            this.zzAe = z;
            zzeW();
        }
    }

    public void zzB(boolean z) {
        synchronized (this.zznh) {
            if (this.zzAb != null) {
                this.zzAb.zza(this.zzvy.zzba(), z);
            } else {
                this.zzAc = z;
            }
        }
    }

    public void zza(Context context, zzba com_google_android_gms_internal_zzba) {
        synchronized (this.zznh) {
            zzeU();
            setContext(context);
            this.zzAb = null;
            this.zzsF = com_google_android_gms_internal_zzba;
            this.zzAe = false;
            this.zzAc = false;
            this.zzAh = -1;
            zzab.zzaO().zzb((WebView) this);
            loadUrl("about:blank");
            this.zzvy.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
        }
    }

    public void zza(zzba com_google_android_gms_internal_zzba) {
        synchronized (this.zznh) {
            this.zzsF = com_google_android_gms_internal_zzba;
            requestLayout();
        }
    }

    public void zza(zzel com_google_android_gms_internal_zzel) {
        synchronized (this.zznh) {
            this.zzAb = com_google_android_gms_internal_zzel;
        }
    }

    protected void zza(String str, ValueCallback<String> valueCallback) {
        synchronized (this.zznh) {
            if (isDestroyed()) {
                zzhx.zzac("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    public void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzb(str, jSONObject.toString());
    }

    public zzba zzad() {
        zzba com_google_android_gms_internal_zzba;
        synchronized (this.zznh) {
            com_google_android_gms_internal_zzba = this.zzsF;
        }
        return com_google_android_gms_internal_zzba;
    }

    protected void zzad(String str) {
        synchronized (this.zznh) {
            if (isDestroyed()) {
                zzhx.zzac("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    protected void zzae(String str) {
        if (zzme.zzkj()) {
            if (zzek() == null) {
                zzeT();
            }
            if (zzek().booleanValue()) {
                zza(str, null);
                return;
            } else {
                zzad("javascript:" + str);
                return;
            }
        }
        zzad("javascript:" + str);
    }

    void zzb(Boolean bool) {
        this.zzyV = bool;
        zzab.zzaP().zzb(bool);
    }

    public void zzb(String str, String str2) {
        zzae(str + "(" + str2 + ");");
    }

    public void zzb(String str, Map<String, ?> map) {
        try {
            zzb(str, zzab.zzaM().zzw((Map) map));
        } catch (JSONException e) {
            zzhx.zzac("Could not convert parameters to JSON.");
        }
    }

    public void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        zzhx.zzab("Dispatching AFMA event: " + stringBuilder.toString());
        zzae(stringBuilder.toString());
    }

    public void zzdh() {
        Map hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.zznl.zzzH);
        zzb("onshow", hashMap);
    }

    public Activity zzeD() {
        return this.zzAa.zzeD();
    }

    public Context zzeE() {
        return this.zzAa.zzeE();
    }

    public zzel zzeF() {
        zzel com_google_android_gms_internal_zzel;
        synchronized (this.zznh) {
            com_google_android_gms_internal_zzel = this.zzAb;
        }
        return com_google_android_gms_internal_zzel;
    }

    public zzid zzeG() {
        return this.zzvy;
    }

    public boolean zzeH() {
        return this.zzAc;
    }

    public zzk zzeI() {
        return this.zzwg;
    }

    public zzhy zzeJ() {
        return this.zznl;
    }

    public boolean zzeK() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzAe;
        }
        return z;
    }

    public void zzeL() {
        synchronized (this.zznh) {
            zzeV();
        }
    }

    public boolean zzeS() {
        if (!zzeG().zzba()) {
            return false;
        }
        int i;
        int i2;
        DisplayMetrics zza = zzab.zzaM().zza(this.zznu);
        int zzb = zzbe.zzbD().zzb(zza, zza.widthPixels);
        int zzb2 = zzbe.zzbD().zzb(zza, zza.heightPixels);
        Activity zzeD = zzeD();
        if (zzeD == null || zzeD.getWindow() == null) {
            i = zzb2;
            i2 = zzb;
        } else {
            int[] zzg = zzab.zzaM().zzg(zzeD);
            i2 = zzbe.zzbD().zzb(zza, zzg[0]);
            i = zzbe.zzbD().zzb(zza, zzg[1]);
        }
        if (this.zztI == zzb && this.zztJ == zzb2 && this.zztL == i2 && this.zztM == i) {
            return false;
        }
        boolean z = (this.zztI == zzb && this.zztJ == zzb2) ? false : true;
        this.zztI = zzb;
        this.zztJ = zzb2;
        this.zztL = i2;
        this.zztM = i;
        new zzeg(this).zza(zzb, zzb2, i2, i, zza.density, this.zznu.getDefaultDisplay().getRotation());
        return z;
    }

    void zzeV() {
        Activity zzeD = zzeD();
        if (!this.zzAg && zzeD != null && this.zzAi) {
            zzab.zzaM().zza(zzeD, (OnGlobalLayoutListener) this);
            this.zzAg = true;
        }
    }

    Boolean zzek() {
        Boolean bool;
        synchronized (this.zznh) {
            bool = this.zzyV;
        }
        return bool;
    }

    public void zzp(int i) {
        Map hashMap = new HashMap(1);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.zznl.zzzH);
        zzb("onhide", hashMap);
    }
}
