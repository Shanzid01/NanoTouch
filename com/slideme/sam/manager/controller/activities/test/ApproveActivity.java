package com.slideme.sam.manager.controller.activities.test;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.common.CommonActivity;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.net.C1867a;

public class ApproveActivity extends CommonActivity {
    private Spinner f2878a;
    private ApplicationHolder f2879b;
    private boolean f2880c = false;

    public void onCreate(Bundle bundle) {
        requestWindowFeature(5);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_approve);
        this.f2879b = (ApplicationHolder) getIntent().getParcelableExtra("com.slideme.sam.manager.EXTRA_APPHOLDER");
        this.f2878a = (Spinner) findViewById(R.id.approveSpinner);
        this.f2878a.setAdapter(new ArrayAdapter(this, 17367049, getResources().getStringArray(R.array.approve_options)));
        if (bundle != null) {
            this.f2878a.setSelection(bundle.getInt("approval"), false);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("approval", this.f2878a.getSelectedItemPosition());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.options_test, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z = false;
        if (this.f2880c) {
            return false;
        }
        switch (menuItem.getItemId()) {
            case R.id.skip:
                finish();
                return true;
            case R.id.done:
                setSupportProgressBarIndeterminateVisibility(true);
                this.f2880c = true;
                C1867a c1867a = SAM.f2614g;
                Application application = this.f2879b.app;
                if (this.f2878a.getSelectedItemPosition() == 0) {
                    z = true;
                }
                c1867a.m5611a(application, z, new C1695a(this));
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
