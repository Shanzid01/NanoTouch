package com.slideme.sam.manager.controller.fragment.p057b;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.p055b.C1707i;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;

/* compiled from: WebViewFragment */
public class C1746k extends Fragment {
    protected String f3099a;
    protected WebView f3100b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f3099a = arguments.getString("com.slideme.sam.manager.extra.URL");
        }
        CookieSyncManager.createInstance(getActivity());
        CookieManager.getInstance().setCookie(getString(R.string.SLIDEME_HTTPS_URL), new StringBuilder(String.valueOf(SAM.f2614g.m5596a())).append("; domain=").append(getString(R.string.COOKIE_DOMAIN)).toString());
        if (bundle != null && this.f3100b != null) {
            this.f3100b.restoreState(bundle);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.f3100b.saveState(bundle);
    }

    public void onResume() {
        super.onResume();
        m5289a();
        CookieSyncManager.getInstance().startSync();
    }

    public void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_topup, null);
        this.f3100b = (WebView) inflate.findViewById(R.id.webview);
        SafeViewFlipper safeViewFlipper = (SafeViewFlipper) inflate.findViewById(R.id.flipper);
        this.f3100b.getSettings().setJavaScriptEnabled(true);
        this.f3100b.getSettings().setUserAgentString(new StringBuilder(String.valueOf(this.f3100b.getSettings().getUserAgentString())).append(SAM.f2627t).toString());
        this.f3100b.addJavascriptInterface(new C1741f(getActivity()), C1741f.NAME);
        this.f3100b.setWebChromeClient(new WebChromeClient());
        this.f3100b.setWebViewClient(new C1747l(this, safeViewFlipper));
        CookieSyncManager.getInstance().sync();
        this.f3100b.requestFocus(130);
        this.f3100b.setOnTouchListener(new C1748m(this));
        this.f3100b.setOnKeyListener(new C1749n(this));
        this.f3100b.loadUrl(C1707i.m5084a(getActivity(), this.f3099a));
        return inflate;
    }

    private void m5289a() {
        if (TextUtils.isEmpty(this.f3099a)) {
            throw new IllegalArgumentException("Destination parameter missing. Use IntentConstants.Extra.URL.");
        }
    }
}
