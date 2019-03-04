package com.slideme.sam.manager.controller.activities.web;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.slideme.sam.manager.controller.activities.common.CommonActivity;
import com.slideme.sam.manager.controller.fragment.p057b.C1736a;

public class AdProxyWebViewActivity extends CommonActivity {
    private Fragment f2892a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2892a = getSupportFragmentManager().findFragmentById(16908290);
        if (this.f2892a == null) {
            this.f2892a = new C1736a();
            this.f2892a.setRetainInstance(true);
            getSupportFragmentManager().beginTransaction().add(16908290, this.f2892a).commit();
        }
    }
}
