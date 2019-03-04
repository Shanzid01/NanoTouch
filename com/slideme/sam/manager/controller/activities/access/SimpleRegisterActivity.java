package com.slideme.sam.manager.controller.activities.access;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.view.touchme.VerifyableEditText;
import com.slideme.sam.manager.view.touchme.bc;

@Deprecated
public class SimpleRegisterActivity extends LoginActivity {
    private static /* synthetic */ int[] f2754l;
    private View f2755a;
    private View f2756e;
    private VerifyableEditText f2757f;
    private TextView f2758g;
    private LinearLayout f2759h;
    private boolean f2760i = false;
    private ProgressDialog f2761j;

    static /* synthetic */ int[] m4925b() {
        int[] iArr = f2754l;
        if (iArr == null) {
            iArr = new int[bc.values().length];
            try {
                iArr[bc.UNVERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[bc.VERIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[bc.VERIFYING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f2754l = iArr;
        }
        return iArr;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_simple_register);
        m4796e();
        this.f2761j = new ProgressDialog(this);
        this.f2761j.setIndeterminate(true);
        this.f2761j.setMessage(getString(R.string.registering));
        this.f2761j.setCancelable(false);
        this.f2757f = (VerifyableEditText) findViewById(R.id.email);
        this.f2759h = (LinearLayout) findViewById(R.id.button_container);
        C1651o c1651o = new C1651o();
        for (int i = 0; i < c1651o.getCount(); i++) {
            this.f2759h.addView(c1651o.getView(i, null, null));
        }
        this.f2757f.m6054a(new C1647k(this));
        this.f2757f.m6055a(new C1652p());
        this.f2757f.m6057a(null);
        this.f2755a.setOnClickListener(new C1648l(this));
        this.f2756e.setOnClickListener(new C1649m(this));
        this.f2758g = (TextView) findViewById(R.id.indicator);
        m4923a(bc.UNVERIFIED, -1);
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    private void m4923a(bc bcVar, int i) {
        switch (m4925b()[bcVar.ordinal()]) {
            case 2:
                this.f2756e.setEnabled(true);
                this.f2755a.setEnabled(true);
                this.f2758g.setBackgroundResource(R.drawable.bg_indicator_register_green);
                this.f2758g.setText(R.string.usernameIndicatorOk);
                return;
            default:
                if (this.f2757f.m6053a().length() != 0) {
                    this.f2756e.setEnabled(false);
                    this.f2755a.setEnabled(false);
                    this.f2758g.setBackgroundResource(R.drawable.bg_indicator_register_pink);
                    if (i == 0) {
                        this.f2758g.setText(R.string.usernameIndicatorHint);
                        return;
                    } else {
                        this.f2758g.setText(R.string.usernameIndicatorNotOk);
                        return;
                    }
                }
                this.f2756e.setEnabled(false);
                this.f2755a.setEnabled(false);
                this.f2758g.setBackgroundResource(R.drawable.bg_indicator_register_grey);
                this.f2758g.setText(R.string.usernameIndicatorHint);
                return;
        }
    }

    private void m4926c(boolean z) {
        if (z) {
            this.f2761j.show();
        } else {
            this.f2761j.dismiss();
        }
        this.f2756e.setEnabled(!z);
        this.f2760i = z;
    }

    protected void onDestroy() {
        super.onDestroy();
        m4926c(false);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("r", this.f2760i);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        m4926c(bundle.getBoolean("r"));
    }
}
