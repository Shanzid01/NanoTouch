package com.google.android.gms.internal;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@zzgi
public class zzhp {

    class zza extends zzhp {
        zza() {
            super();
        }

        public boolean zza(Request request) {
            request.setShowRunningNotification(true);
            return true;
        }

        public int zzex() {
            return 6;
        }

        public int zzey() {
            return 7;
        }
    }

    class zzb extends zza {
        zzb() {
        }

        public boolean zza(Request request) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            return true;
        }

        public boolean zza(Context context, WebSettings webSettings) {
            if (context.getCacheDir() != null) {
                webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
                webSettings.setAppCacheMaxSize(0);
                webSettings.setAppCacheEnabled(true);
            }
            webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
            webSettings.setDatabaseEnabled(true);
            webSettings.setDomStorageEnabled(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setSupportZoom(true);
            return true;
        }

        public boolean zza(Window window) {
            window.setFlags(16777216, 16777216);
            return true;
        }

        public boolean zza(WebView webView) {
            webView.onPause();
            return true;
        }

        public WebChromeClient zzb(zzic com_google_android_gms_internal_zzic) {
            return new zzig(com_google_android_gms_internal_zzic);
        }

        public zzid zzb(zzic com_google_android_gms_internal_zzic, boolean z) {
            return new zzih(com_google_android_gms_internal_zzic, z);
        }

        public boolean zzb(WebView webView) {
            webView.onResume();
            return true;
        }

        public Set<String> zze(Uri uri) {
            return uri.getQueryParameterNames();
        }

        public boolean zzj(View view) {
            view.setLayerType(0, null);
            return true;
        }

        public boolean zzk(View view) {
            view.setLayerType(1, null);
            return true;
        }
    }

    class zzc extends zzb {
        zzc() {
        }

        public WebChromeClient zzb(zzic com_google_android_gms_internal_zzic) {
            return new zzii(com_google_android_gms_internal_zzic);
        }
    }

    class zzf extends zzc {
        zzf() {
        }

        public void zzb(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
                window.getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        }
    }

    class zzd extends zzf {
        zzd() {
        }

        public String getDefaultUserAgent(Context context) {
            return WebSettings.getDefaultUserAgent(context);
        }

        public boolean zza(Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            webSettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }
    }

    class zze extends zzd {
        zze() {
        }

        public int zzez() {
            return 14;
        }

        public boolean zzi(View view) {
            return super.zzi(view) || view.getWindowId() != null;
        }
    }

    class zzg extends zze {
        zzg() {
        }

        public boolean zzi(View view) {
            return view.isAttachedToWindow();
        }
    }

    private zzhp() {
    }

    public static zzhp zzz(int i) {
        return i >= 19 ? new zzg() : i >= 18 ? new zze() : i >= 17 ? new zzd() : i >= 16 ? new zzf() : i >= 14 ? new zzc() : i >= 11 ? new zzb() : i >= 9 ? new zza() : new zzhp();
    }

    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean zza(Request request) {
        return false;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean zza(Window window) {
        return false;
    }

    public boolean zza(WebView webView) {
        return false;
    }

    public WebChromeClient zzb(zzic com_google_android_gms_internal_zzic) {
        return null;
    }

    public zzid zzb(zzic com_google_android_gms_internal_zzic, boolean z) {
        return new zzid(com_google_android_gms_internal_zzic, z);
    }

    public void zzb(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    public boolean zzb(WebView webView) {
        return false;
    }

    public Set<String> zze(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        Set linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public int zzex() {
        return 0;
    }

    public int zzey() {
        return 1;
    }

    public int zzez() {
        return 5;
    }

    public boolean zzi(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public boolean zzj(View view) {
        return false;
    }

    public boolean zzk(View view) {
        return false;
    }
}
