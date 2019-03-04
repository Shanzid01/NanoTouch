package com.slideme.sam.manager.controller.fragment.p057b;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.slideme.sam.manager.util.C1922m;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;

/* compiled from: WebBuyFragment */
public class C1742g extends Fragment {
    private String f3092a;
    private WebView f3093b;
    private String f3094c = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3092a = getString(R.string.SLIDEME_WEBBUY_URL) + "/" + getArguments().getString("com.slideme.sam.manager.EXTRA_APP_NID") + "/sambuy";
        CookieSyncManager.createInstance(getActivity());
        CookieManager.getInstance().setCookie(getString(R.string.SLIDEME_HTTPS_URL), new StringBuilder(String.valueOf(SAM.f2614g.m5596a())).append("; domain=").append(getString(R.string.COOKIE_DOMAIN)).toString());
        if (bundle != null && this.f3093b != null) {
            this.f3093b.restoreState(bundle);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.f3093b.saveState(bundle);
    }

    public void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }

    public void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_topup, null);
        this.f3093b = (WebView) inflate.findViewById(R.id.webview);
        SafeViewFlipper safeViewFlipper = (SafeViewFlipper) inflate.findViewById(R.id.flipper);
        this.f3093b.getSettings().setJavaScriptEnabled(true);
        this.f3093b.getSettings().setUserAgentString(new StringBuilder(String.valueOf(this.f3093b.getSettings().getUserAgentString())).append(SAM.f2627t).toString());
        this.f3093b.setWebChromeClient(new WebChromeClient());
        this.f3093b.setWebViewClient(new C1743h(this, safeViewFlipper));
        CookieSyncManager.getInstance().sync();
        this.f3093b.requestFocus(130);
        this.f3093b.setOnTouchListener(new C1744i(this));
        this.f3093b.setOnKeyListener(new C1745j(this));
        String a = C1707i.m5084a(getActivity(), this.f3092a);
        C1922m.m5797b("WebBuyFragment", a);
        this.f3093b.loadUrl(a);
        return inflate;
    }
}
