package com.mopub.mobileads;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.mopub.common.p050b.C1493p;

public class BaseHtmlWebView extends BaseWebView implements UserClickListener {
    private final ViewGestureDetector f2281b;
    private boolean f2282c;

    public BaseHtmlWebView(Context context, AdConfiguration adConfiguration) {
        super(context);
        m4276a();
        getSettings().setJavaScriptEnabled(true);
        this.f2281b = new ViewGestureDetector(context, (View) this, adConfiguration);
        this.f2281b.m4468a((UserClickListener) this);
        if (C1493p.currentApiLevel().isAtLeast(C1493p.ICE_CREAM_SANDWICH)) {
            m4274c(true);
        }
        setBackgroundColor(0);
    }

    public void m4278a(boolean z) {
        m4279b(z);
    }

    public void loadUrl(String str) {
        if (str != null) {
            Log.d("MoPub", "Loading url: " + str);
            if (str.startsWith("javascript:")) {
                super.loadUrl(str);
            }
        }
    }

    private void m4276a() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
    }

    void m4277a(String str) {
        loadDataWithBaseURL("http://ads.mopub.com/", str, "text/html", "utf-8", null);
    }

    void m4279b(boolean z) {
        setOnTouchListener(new C1543l(this, z));
    }

    public void onUserClick() {
        this.f2282c = true;
    }

    public void onResetUserClick() {
        this.f2282c = false;
    }

    public boolean wasClicked() {
        return this.f2282c;
    }
}
