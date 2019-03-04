package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzgi
public class zzez implements zzex {
    private final Context mContext;
    final Set<WebView> zzuN = Collections.synchronizedSet(new HashSet());

    public zzez(Context context) {
        this.mContext = context;
    }

    public void zza(String str, final String str2, final String str3) {
        zzhx.zzY("Fetching assets for the given html");
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzez zzuQ;

            public void run() {
                final WebView zzdr = this.zzuQ.zzdr();
                zzdr.setWebViewClient(new WebViewClient(this) {
                    final /* synthetic */ C12031 zzuR;

                    public void onPageFinished(WebView webView, String str) {
                        zzhx.zzY("Loading assets have finished");
                        this.zzuR.zzuQ.zzuN.remove(zzdr);
                    }

                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        zzhx.zzac("Loading assets have failed.");
                        this.zzuR.zzuQ.zzuN.remove(zzdr);
                    }
                });
                this.zzuQ.zzuN.add(zzdr);
                zzdr.loadDataWithBaseURL(str2, str3, "text/html", "UTF-8", null);
                zzhx.zzY("Fetching assets finished.");
            }
        });
    }

    public WebView zzdr() {
        WebView webView = new WebView(this.mContext);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
