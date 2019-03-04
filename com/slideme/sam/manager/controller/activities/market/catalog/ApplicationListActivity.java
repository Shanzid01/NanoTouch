package com.slideme.sam.manager.controller.activities.market.catalog;

import android.os.Bundle;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;
import com.slideme.sam.manager.controller.fragment.p056a.C1708i;

public abstract class ApplicationListActivity extends FlipperFragmentActivity {
    protected C1708i f2798a;
    private int f2799b = -1;

    protected abstract void mo4242b();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f2799b != -1) {
            setContentView(this.f2799b);
        }
        this.f2798a = (C1708i) getSupportFragmentManager().findFragmentByTag("content_fragment");
        m4957h();
    }

    protected void m4956c(int i) {
        this.f2799b = i;
    }

    public void m4957h() {
        if (this.f2798a == null) {
            mo4242b();
            if (getIntent().getExtras() != null) {
                this.f2798a.setArguments(new Bundle(getIntent().getExtras()));
            }
            getSupportFragmentManager().beginTransaction().add(this.f2799b == -1 ? m4798g().getId() : R.id.applist, this.f2798a, "content_fragment").commit();
        }
        m4796e();
    }
}
