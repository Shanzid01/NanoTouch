package com.slideme.sam.manager.controller.activities.access;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.net.C1883p;

@Deprecated
public class UpgradeProfileActivity extends RegisterActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (AuthData.m4808d(this)) {
            View textView = new TextView(this);
            textView.setText(R.string.limited_account_notice);
            float applyDimension = TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics());
            textView.setPadding((int) applyDimension, ((int) applyDimension) / 2, (int) applyDimension, ((int) applyDimension) / 2);
            textView.setTextAppearance(this, 16842817);
            ((ViewGroup) findViewById(R.id.scrollable_content)).addView(textView, 0);
        }
        this.e.setVisibility(8);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    protected void mo4242b() {
        String charSequence = this.i.m6053a().toString();
        int checkedRadioButtonId = this.j.getCheckedRadioButtonId();
        C1883p c1883p = checkedRadioButtonId == R.id.male ? C1883p.MALE : checkedRadioButtonId == R.id.female ? C1883p.FEMALE : C1883p.UNSPECIFIED;
        SAM.f2614g.m5626a(this.f.m6053a().toString(), charSequence, AuthData.m4812h(this), c1883p, new C1653q(this));
        mo4228a(true);
    }
}
