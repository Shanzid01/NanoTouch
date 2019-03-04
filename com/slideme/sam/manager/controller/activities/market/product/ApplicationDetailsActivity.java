package com.slideme.sam.manager.controller.activities.market.product;

import android.os.Bundle;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;
import com.slideme.sam.manager.controller.fragment.C1735a;
import com.slideme.sam.manager.view.touchme.MyReview;

public class ApplicationDetailsActivity extends FlipperFragmentActivity {
    private C1735a f2830a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2830a = (C1735a) getSupportFragmentManager().findFragmentByTag("content_fragment");
        m4985h();
    }

    public MyReview mo4242b() {
        return this.f2830a.m5219b();
    }

    public void m4985h() {
        if (this.f2830a == null) {
            this.f2830a = new C1735a();
            this.f2830a.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(m4798g().getId(), this.f2830a, "content_fragment").commit();
        }
        m4796e();
    }
}
