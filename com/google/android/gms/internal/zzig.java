package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

@zzgi
public class zzig extends WebChromeClient {
    private final zzic zzmu;

    final class C12401 implements OnCancelListener {
        final /* synthetic */ JsResult zzAl;

        C12401(JsResult jsResult) {
            this.zzAl = jsResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.zzAl.cancel();
        }
    }

    final class C12412 implements OnClickListener {
        final /* synthetic */ JsResult zzAl;

        C12412(JsResult jsResult) {
            this.zzAl = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzAl.cancel();
        }
    }

    final class C12423 implements OnClickListener {
        final /* synthetic */ JsResult zzAl;

        C12423(JsResult jsResult) {
            this.zzAl = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzAl.confirm();
        }
    }

    final class C12434 implements OnCancelListener {
        final /* synthetic */ JsPromptResult zzAm;

        C12434(JsPromptResult jsPromptResult) {
            this.zzAm = jsPromptResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.zzAm.cancel();
        }
    }

    final class C12445 implements OnClickListener {
        final /* synthetic */ JsPromptResult zzAm;

        C12445(JsPromptResult jsPromptResult) {
            this.zzAm = jsPromptResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzAm.cancel();
        }
    }

    final class C12456 implements OnClickListener {
        final /* synthetic */ JsPromptResult zzAm;
        final /* synthetic */ EditText zzAn;

        C12456(JsPromptResult jsPromptResult, EditText editText) {
            this.zzAm = jsPromptResult;
            this.zzAn = editText;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzAm.confirm(this.zzAn.getText().toString());
        }
    }

    /* synthetic */ class C12467 {
        static final /* synthetic */ int[] zzAo = new int[MessageLevel.values().length];

        static {
            try {
                zzAo[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzAo[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzAo[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzAo[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                zzAo[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public zzig(zzic com_google_android_gms_internal_zzic) {
        this.zzmu = com_google_android_gms_internal_zzic;
    }

    private static void zza(Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new C12423(jsResult)).setNegativeButton(17039360, new C12412(jsResult)).setOnCancelListener(new C12401(jsResult)).create().show();
    }

    private static void zza(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new C12456(jsPromptResult, editText)).setNegativeButton(17039360, new C12445(jsPromptResult)).setOnCancelListener(new C12434(jsPromptResult)).create().show();
    }

    private final Context zzc(WebView webView) {
        if (!(webView instanceof zzic)) {
            return webView.getContext();
        }
        zzic com_google_android_gms_internal_zzic = (zzic) webView;
        Context zzeD = com_google_android_gms_internal_zzic.zzeD();
        return zzeD == null ? com_google_android_gms_internal_zzic.getContext() : zzeD;
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof zzic) {
            zzel zzeF = ((zzic) webView).zzeF();
            if (zzeF == null) {
                zzhx.zzac("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                zzeF.close();
                return;
            }
        }
        zzhx.zzac("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (C12467.zzAo[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                zzhx.zzZ(str);
                break;
            case 2:
                zzhx.zzac(str);
                break;
            case 3:
            case 4:
                zzhx.zzaa(str);
                break;
            case 5:
                zzhx.zzY(str);
                break;
            default:
                zzhx.zzaa(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.zzmu.zzeG());
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > 1048576) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(Math.min(131072, j4) + j, 1048576);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onHideCustomView() {
        zzel zzeF = this.zzmu.zzeF();
        if (zzeF == null) {
            zzhx.zzac("Could not get ad overlay when hiding custom view.");
        } else {
            zzeF.zzdc();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzc(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzc(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzc(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzc(webView), str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        long j3 = 131072 + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        zza(view, -1, customViewCallback);
    }

    protected final void zza(View view, int i, CustomViewCallback customViewCallback) {
        zzel zzeF = this.zzmu.zzeF();
        if (zzeF == null) {
            zzhx.zzac("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzeF.zza(view, customViewCallback);
        zzeF.setRequestedOrientation(i);
    }

    protected boolean zza(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            if (z) {
                zza(context, builder, str2, str3, jsPromptResult);
            } else {
                zza(builder, str2, jsResult);
            }
        } catch (Throwable e) {
            zzhx.zzd("Fail to display Dialog.", e);
        }
        return true;
    }
}
