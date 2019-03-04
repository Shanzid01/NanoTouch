package com.mopub.common;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.google.android.gms.cast.TextTrackStyle;
import com.mopub.common.p050b.C1482e;
import com.slideme.sam.manager.model.data.dynamic.LayoutTagTable;

public class MoPubBrowser extends Activity {
    private WebView f2127a;
    private ImageButton f2128b;
    private ImageButton f2129c;
    private ImageButton f2130d;
    private ImageButton f2131e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(-1);
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        setContentView(m4009d());
        m4004a();
        m4006b();
        m4008c();
    }

    private void m4004a() {
        WebSettings settings = this.f2127a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        this.f2127a.loadUrl(getIntent().getStringExtra(LayoutTagTable.URL));
        this.f2127a.setWebViewClient(new C1517y(this));
        this.f2127a.setWebChromeClient(new C1518z(this));
    }

    private void m4006b() {
        this.f2128b.setBackgroundColor(0);
        this.f2128b.setOnClickListener(new aa(this));
        this.f2129c.setBackgroundColor(0);
        this.f2129c.setOnClickListener(new ab(this));
        this.f2130d.setBackgroundColor(0);
        this.f2130d.setOnClickListener(new ac(this));
        this.f2131e.setBackgroundColor(0);
        this.f2131e.setOnClickListener(new ad(this));
    }

    private void m4008c() {
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    protected void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }

    protected void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }

    private View m4009d() {
        View linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new LayoutParams(-1, -2));
        linearLayout.addView(relativeLayout);
        View linearLayout2 = new LinearLayout(this);
        linearLayout2.setId(1);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setBackgroundDrawable(C1482e.BACKGROUND.decodeImage(this));
        relativeLayout.addView(linearLayout2);
        this.f2128b = m4002a(C1482e.LEFT_ARROW.decodeImage(this));
        this.f2129c = m4002a(C1482e.RIGHT_ARROW.decodeImage(this));
        this.f2130d = m4002a(C1482e.REFRESH.decodeImage(this));
        this.f2131e = m4002a(C1482e.CLOSE.decodeImage(this));
        linearLayout2.addView(this.f2128b);
        linearLayout2.addView(this.f2129c);
        linearLayout2.addView(this.f2130d);
        linearLayout2.addView(this.f2131e);
        this.f2127a = new WebView(this);
        ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, 1);
        this.f2127a.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.f2127a);
        return linearLayout;
    }

    private ImageButton m4002a(Drawable drawable) {
        ImageButton imageButton = new ImageButton(this);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2, TextTrackStyle.DEFAULT_FONT_SCALE);
        layoutParams.gravity = 16;
        imageButton.setLayoutParams(layoutParams);
        imageButton.setImageDrawable(drawable);
        return imageButton;
    }
}
