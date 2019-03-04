package com.slideme.sam.manager.controller.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.common.CommonActivity;
import com.slideme.sam.manager.controller.fragment.bc;
import com.slideme.sam.manager.controller.fragment.bf;

public class SamUpdateActivity extends CommonActivity implements bf {
    private ProgressBar f2734a;
    private TextView f2735b;
    private bc f2736c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_sam_update);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.f2736c = (bc) supportFragmentManager.findFragmentByTag("task_fragment");
        if (this.f2736c == null) {
            this.f2736c = new bc();
            supportFragmentManager.beginTransaction().add(this.f2736c, "task_fragment").commit();
        }
        this.f2734a = (ProgressBar) findViewById(R.id.download_progress);
        this.f2735b = (TextView) findViewById(R.id.download_progress_text);
        m4901b(0);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private void m4900b() {
        runOnUiThread(new C1654b(this));
    }

    private void m4901b(int i) {
        runOnUiThread(new C1655c(this, i));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        finish();
    }

    public void mo4236a(int i) {
        m4901b(i);
    }

    public void mo4235a() {
        m4900b();
    }
}
