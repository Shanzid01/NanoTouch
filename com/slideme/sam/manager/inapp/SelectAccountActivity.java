package com.slideme.sam.manager.inapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.C0090q;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.common.AccountAwareActivity;

public class SelectAccountActivity extends AccountAwareActivity {
    private boolean f3212a = false;

    public void onCreate(Bundle bundle) {
        m4786b(false);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_splash);
        m4796e();
    }

    public void mo4239a() {
        this.f3212a = true;
        Intent intent = new Intent("com.slideme.sam.manager.ACTION_IAP_ACCOUNT_HANDLED");
        intent.putExtra("com.slideme.sam.manager.extra.ACCOUNT_HANDLED", this.f3212a);
        C0090q.m145a(getApplicationContext()).m150a(intent);
        finish();
    }
}
