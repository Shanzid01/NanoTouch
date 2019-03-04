package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.zzw;
import java.net.URI;
import java.net.URISyntaxException;

@zzgi
public class zzij extends WebViewClient {
    private final String zzAp;
    private boolean zzAq = false;
    private final zzfz zzAr;
    private final zzic zzmu;

    public zzij(zzfz com_google_android_gms_internal_zzfz, zzic com_google_android_gms_internal_zzic, String str) {
        this.zzAp = zzag(str);
        this.zzmu = com_google_android_gms_internal_zzic;
        this.zzAr = com_google_android_gms_internal_zzfz;
    }

    private String zzag(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                zzhx.zzZ(e.getMessage());
            }
        }
        return str;
    }

    public void onLoadResource(WebView webView, String str) {
        zzhx.zzY("JavascriptAdWebViewClient::onLoadResource: " + str);
        if (!zzaf(str)) {
            this.zzmu.zzeG().onLoadResource(this.zzmu.getWebView(), str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        zzhx.zzY("JavascriptAdWebViewClient::onPageFinished: " + str);
        if (!this.zzAq) {
            this.zzAr.zzdC();
            this.zzAq = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzhx.zzY("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + str);
        if (!zzaf(str)) {
            return this.zzmu.zzeG().shouldOverrideUrlLoading(this.zzmu.getWebView(), str);
        }
        zzhx.zzY("shouldOverrideUrlLoading: received passback url");
        return true;
    }

    protected boolean zzaf(String str) {
        Object zzag = zzag(str);
        if (TextUtils.isEmpty(zzag)) {
            return false;
        }
        try {
            URI uri = new URI(zzag);
            if ("passback".equals(uri.getScheme())) {
                zzhx.zzY("Passback received");
                this.zzAr.zzdD();
                return true;
            } else if (TextUtils.isEmpty(this.zzAp)) {
                return false;
            } else {
                URI uri2 = new URI(this.zzAp);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!zzw.equal(host, host2) || !zzw.equal(path, path2)) {
                    return false;
                }
                zzhx.zzY("Passback received");
                this.zzAr.zzdD();
                return true;
            }
        } catch (URISyntaxException e) {
            zzhx.zzZ(e.getMessage());
            return false;
        }
    }
}
