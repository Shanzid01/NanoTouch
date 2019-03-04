package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;
import org.json.JSONObject;

@zzgi
public interface zzic {
    void destroy();

    Context getContext();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getRequestedOrientation();

    WebView getWebView();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void setBackgroundColor(int i);

    void setContext(Context context);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebViewClient(WebViewClient webViewClient);

    void setWillNotDraw(boolean z);

    void stopLoading();

    boolean willNotDraw();

    void zzA(boolean z);

    void zzB(boolean z);

    void zza(Context context, zzba com_google_android_gms_internal_zzba);

    void zza(zzba com_google_android_gms_internal_zzba);

    void zza(zzel com_google_android_gms_internal_zzel);

    void zza(String str, JSONObject jSONObject);

    zzba zzad();

    void zzb(String str, String str2);

    void zzb(String str, Map<String, ?> map);

    void zzb(String str, JSONObject jSONObject);

    void zzdh();

    Activity zzeD();

    Context zzeE();

    zzel zzeF();

    zzid zzeG();

    boolean zzeH();

    zzk zzeI();

    zzhy zzeJ();

    boolean zzeK();

    void zzeL();

    void zzp(int i);
}
