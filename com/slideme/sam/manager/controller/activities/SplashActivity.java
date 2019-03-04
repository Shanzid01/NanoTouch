package com.slideme.sam.manager.controller.activities;

import android.os.Bundle;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;
import com.slideme.sam.manager.controller.p055b.C1698a;

public class SplashActivity extends FlipperFragmentActivity {
    public void onCreate(Bundle bundle) {
        m4786b(false);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_splash);
    }

    protected void onPostResume() {
        super.onPostResume();
        m4796e();
    }

    public void b_() {
        super.b_();
        C1698a.m5060a(this, false, null, AuthData.m4813i(getApplicationContext()));
        finish();
    }
}
