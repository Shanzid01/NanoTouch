package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.android.gms.location.places.Place;
import com.mopub.common.p050b.C1483f;

public class MraidVideoPlayerActivity extends C1520p implements BaseVideoViewControllerListener {
    private BaseVideoViewController f2348a;
    private long f2349b;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(Place.TYPE_SUBLOCALITY_LEVEL_2);
        AdConfiguration a = m4378a();
        if (a != null) {
            this.f2349b = a.m4191d();
        } else {
            Log.d("MoPub", "Unable to obtain broadcast identifier. Video interactions cannot be tracked.");
        }
        try {
            this.f2348a = m4379b();
            this.f2348a.mo4124a();
        } catch (IllegalStateException e) {
            C1552s.m4654a(this, this.f2349b, "com.mopub.action.interstitial.fail");
            finish();
        }
    }

    protected void onPause() {
        this.f2348a.mo4126c();
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.f2348a.mo4127d();
    }

    protected void onDestroy() {
        this.f2348a.mo4128e();
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.f2348a.mo4135f()) {
            super.onBackPressed();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f2348a.mo4134a(i, i2, intent);
    }

    private AdConfiguration m4378a() {
        try {
            return (AdConfiguration) getIntent().getSerializableExtra("Ad-Configuration");
        } catch (ClassCastException e) {
            return null;
        }
    }

    private BaseVideoViewController m4379b() {
        String stringExtra = getIntent().getStringExtra("video_view_class_name");
        if ("vast".equals(stringExtra)) {
            return new VastVideoViewController(this, getIntent().getExtras(), this.f2349b, this);
        }
        if ("mraid".equals(stringExtra)) {
            return new MraidVideoViewController(this, getIntent().getExtras(), this.f2349b, this);
        }
        throw new IllegalStateException("Unsupported video type: " + stringExtra);
    }

    public void onSetContentView(View view) {
        setContentView(view);
    }

    public void onSetRequestedOrientation(int i) {
        setRequestedOrientation(i);
    }

    public void onFinish() {
        finish();
    }

    public void onStartActivityForResult(Class<? extends Activity> cls, int i, Bundle bundle) {
        if (cls != null) {
            try {
                startActivityForResult(C1483f.m4061a((Context) this, (Class) cls, bundle), i);
            } catch (ActivityNotFoundException e) {
                Log.d("MoPub", "Activity " + cls.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
            }
        }
    }
}
