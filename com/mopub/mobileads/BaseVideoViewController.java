package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.VideoView;

abstract class BaseVideoViewController {
    private final Context f2283a;
    private final RelativeLayout f2284b = new RelativeLayout(this.f2283a);
    private final BaseVideoViewControllerListener f2285c;
    private long f2286d;

    interface BaseVideoViewControllerListener {
        void onFinish();

        void onSetContentView(View view);

        void onSetRequestedOrientation(int i);

        void onStartActivityForResult(Class<? extends Activity> cls, int i, Bundle bundle);
    }

    abstract VideoView mo4125b();

    abstract void mo4126c();

    abstract void mo4127d();

    abstract void mo4128e();

    BaseVideoViewController(Context context, long j, BaseVideoViewControllerListener baseVideoViewControllerListener) {
        this.f2283a = context.getApplicationContext();
        this.f2286d = j;
        this.f2285c = baseVideoViewControllerListener;
    }

    void mo4124a() {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.f2284b.addView(mo4125b(), 0, layoutParams);
        this.f2285c.onSetContentView(this.f2284b);
    }

    boolean mo4135f() {
        return true;
    }

    void mo4134a(int i, int i2, Intent intent) {
    }

    BaseVideoViewControllerListener m4290g() {
        return this.f2285c;
    }

    Context m4291h() {
        return this.f2283a;
    }

    ViewGroup m4292i() {
        return this.f2284b;
    }

    void m4283a(boolean z) {
        Log.d("MoPub", "Error: video can not be played.");
        m4282a("com.mopub.action.interstitial.fail");
        if (z) {
            this.f2285c.onFinish();
        }
    }

    void m4285b(boolean z) {
        if (z) {
            this.f2285c.onFinish();
        }
    }

    void m4293j() {
        m4282a("com.mopub.action.interstitial.click");
    }

    void m4282a(String str) {
        C1552s.m4654a(this.f2283a, this.f2286d, str);
    }
}
