package com.slideme.sam.manager.controller.fragment.p057b;

import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.AdProxyOfferHealthReport;
import com.slideme.sam.manager.util.C1913d;
import com.slideme.sam.manager.util.C1922m;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;

/* compiled from: AdProxyWebViewFragment */
public class C1736a extends Fragment {
    private String f3074a;
    private WebView f3075b;
    private boolean f3076c;
    private String f3077d;
    private String f3078e;
    private String f3079f;
    private boolean f3080g;
    private String f3081h;
    private double f3082i;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3074a = getActivity().getIntent().getExtras().getString("com.slideme.sam.manager.EXTRA_DESTINATION_URL");
        this.f3076c = getActivity().getIntent().getExtras().getBoolean("com.slideme.sam.manager.EXTRA_SAM_AVAILABLE_AD");
        this.f3077d = getActivity().getIntent().getExtras().getString("com.slideme.sam.manager.EXTRA_ADSLOT_ID");
        this.f3079f = getActivity().getIntent().getExtras().getString("com.slideme.sam.manager.EXTRA_NETWORK_ID");
        this.f3078e = getActivity().getIntent().getExtras().getString("com.slideme.sam.manager.EXTRA_OFFER_ID");
        this.f3080g = getActivity().getIntent().getExtras().getBoolean("com.slideme.sam.manager.EXTRA_OFFER_SHARE");
        this.f3082i = getActivity().getIntent().getExtras().getDouble("com.slideme.sam.manager.EXTRA_OFFER_PAYOUT");
        this.f3081h = getActivity().getIntent().getExtras().getString("com.slideme.sam.manager.EXTRA_PACKAGE_NAME");
        if (bundle != null && this.f3075b != null) {
            this.f3075b.restoreState(bundle);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.f3075b.saveState(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_topup, null);
        this.f3075b = (WebView) inflate.findViewById(R.id.webview);
        SafeViewFlipper safeViewFlipper = (SafeViewFlipper) inflate.findViewById(R.id.flipper);
        if (!this.f3076c) {
            TextView textView = (TextView) inflate.findViewById(R.id.message);
            textView.setText(getString(R.string.redirecting_to) + " Google Play");
            textView.setVisibility(0);
        }
        this.f3075b.getSettings().setJavaScriptEnabled(true);
        this.f3075b.getSettings().setUserAgentString(new StringBuilder(String.valueOf(this.f3075b.getSettings().getUserAgentString())).append(SAM.f2627t).toString());
        this.f3075b.setWebChromeClient(new WebChromeClient());
        this.f3075b.setWebViewClient(new C1737b(this, safeViewFlipper));
        this.f3075b.requestFocus(130);
        this.f3075b.setOnTouchListener(new C1739d(this));
        C1922m.m5797b("AdProxy", "Starting redirect flow: " + this.f3074a);
        this.f3075b.loadUrl(this.f3074a);
        return inflate;
    }

    private void m5275a(boolean z) {
        int i = 0;
        if (getActivity() != null) {
            if (!(z || getActivity().isFinishing() || TextUtils.isEmpty(this.f3081h))) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("sam://details?id=" + this.f3081h));
                intent.addFlags(65536);
                startActivity(intent);
            }
            try {
                i = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionCode;
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
            SAM.f2614g.m5603a(getActivity(), new AdProxyOfferHealthReport(this.f3078e, this.f3079f, getResources().getString(R.string.sam_version_num), i, z, C1913d.m5766c(getActivity())), new C1740e(this, z));
            getActivity().finish();
        }
    }
}
