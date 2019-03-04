package com.slideme.sam.manager.controller.activities;

import android.os.Bundle;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.controller.activities.common.AccountAwareActivity;
import com.slideme.sam.manager.controller.p055b.C1698a;

public class SplashAccountFlowActivity extends AccountAwareActivity {
    public void onCreate(Bundle bundle) {
        m4786b(false);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_splash);
        m4796e();
    }

    public void mo4239a() {
        C1698a.m5060a(this, false, null, AuthData.m4813i(getApplicationContext()));
        finish();
    }
}
