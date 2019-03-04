package com.slideme.sam.manager.controller.activities.web;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.common.CommonActivity;
import com.slideme.sam.manager.controller.fragment.p057b.C1742g;
import com.slideme.sam.manager.model.data.ApplicationHolder;

public class WebBuyFragmentActivity extends CommonActivity {
    private Fragment f2894a;
    private ApplicationHolder f2895b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(false);
        }
        this.f2895b = (ApplicationHolder) getIntent().getParcelableExtra("com.slideme.sam.manager.EXTRA_APPHOLDER");
        setTitle(getString(R.string.activity_webbuy, new Object[]{this.f2895b.app.getName()}));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(false);
        }
        this.f2894a = getSupportFragmentManager().findFragmentById(16908290);
        if (this.f2894a == null) {
            this.f2894a = new C1742g();
            Bundle bundle2 = new Bundle();
            bundle2.putString("com.slideme.sam.manager.EXTRA_APP_NID", this.f2895b.app.nodeId);
            this.f2894a.setArguments(bundle2);
            this.f2894a.setRetainInstance(true);
            getSupportFragmentManager().beginTransaction().add(16908290, this.f2894a).commit();
        }
    }
}
