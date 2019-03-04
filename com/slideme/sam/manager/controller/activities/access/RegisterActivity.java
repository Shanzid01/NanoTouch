package com.slideme.sam.manager.controller.activities.access;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.model.data.UserProfile;
import com.slideme.sam.manager.view.touchme.VerifyableEditText;
import com.slideme.sam.manager.view.touchme.ba;

public class RegisterActivity extends LoginActivity {
    private static String f2741l = "register";
    private static String f2742m = "username";
    private static String f2743n = "pass";
    private static String f2744o = "fullname";
    private static String f2745p = "gender";
    protected Button f2746a;
    protected VerifyableEditText f2747e;
    protected VerifyableEditText f2748f;
    protected VerifyableEditText f2749g;
    protected VerifyableEditText f2750h;
    protected VerifyableEditText f2751i;
    protected RadioGroup f2752j;
    private ba f2753q = new C1638b(this);

    private boolean m4912b(Intent intent) {
        return (intent == null || intent.getAction() == null || !intent.getAction().equals("android.intent.action.VIEW") || intent.getData() == null) ? false : true;
    }

    private void m4913c(Intent intent) {
        if (m4912b(intent)) {
            if (!TextUtils.isEmpty(intent.getData().getQueryParameter("fullname"))) {
                this.f2751i.m6056a(intent.getData().getQueryParameter("fullname"));
            }
            if (!TextUtils.isEmpty(intent.getData().getQueryParameter("username"))) {
                this.f2748f.m6056a(intent.getData().getQueryParameter("username"));
            }
            if (!TextUtils.isEmpty(intent.getData().getQueryParameter("password"))) {
                this.f2749g.m6056a(intent.getData().getQueryParameter("password"));
                this.f2750h.m6056a(intent.getData().getQueryParameter("password"));
            }
            if (!TextUtils.isEmpty(intent.getData().getQueryParameter("email"))) {
                this.f2747e.m6056a(intent.getData().getQueryParameter("email"));
            }
            if (!TextUtils.isEmpty(intent.getData().getQueryParameter("gender"))) {
                if ("male".equals(intent.getData().getQueryParameter("gender"))) {
                    this.f2752j.check(R.id.male);
                } else if ("female".equals(intent.getData().getQueryParameter("gender"))) {
                    this.f2752j.check(R.id.female);
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        if (m4912b(getIntent())) {
            getIntent().putExtra("is_adding_new_account", true);
        }
        super.onCreate(bundle);
        m4915i();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CharSequence string = extras.getString("com.slideme.sam.manager.EXTRA_EIMAIL");
            if (string != null) {
                ((TextView) findViewById(R.id.email)).setText(string);
            }
        }
        m4914h();
        m4913c(getIntent());
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    private void m4914h() {
        this.f2747e = (VerifyableEditText) findViewById(R.id.email);
        this.f2748f = (VerifyableEditText) findViewById(R.id.username);
        this.f2749g = (VerifyableEditText) findViewById(R.id.password);
        this.f2750h = (VerifyableEditText) findViewById(R.id.password2);
        this.f2751i = (VerifyableEditText) findViewById(R.id.fullname);
        this.f2752j = (RadioGroup) findViewById(R.id.gender);
        this.f2747e.m6054a(this.f2753q);
        this.f2749g.m6054a(this.f2753q);
        this.f2750h.m6054a(this.f2753q);
        this.f2748f.m6054a(this.f2753q);
        this.f2751i.m6054a(this.f2753q);
        this.f2749g.setUnverifiedText(R.string.password_too_small);
        this.f2750h.setUnverifiedText(R.string.passwords_dont_match);
        this.f2747e.m6055a(new C1639c(this));
        this.f2748f.m6055a(new C1640d(this));
        this.f2749g.m6055a(new C1641e(this));
        this.f2750h.m6055a(new C1642f(this));
    }

    private void m4915i() {
        setContentView((int) R.layout.activity_register);
        m4796e();
        this.f2746a = (Button) findViewById(R.id.button);
        this.f2746a.setOnClickListener(new C1643g(this));
        findViewById(R.id.privacy).setOnClickListener(new C1644h(this));
        findViewById(R.id.terms).setOnClickListener(new C1645i(this));
        this.b.setMessage(getString(R.string.registering));
    }

    protected void mo4242b() {
        int checkedRadioButtonId = this.f2752j.getCheckedRadioButtonId();
        UserProfile userProfile = new UserProfile(this.f2748f.m6053a().toString(), this.f2749g.m6053a().toString());
        userProfile.setFullName(this.f2751i.m6053a().toString());
        checkedRadioButtonId = checkedRadioButtonId == R.id.male ? 1 : checkedRadioButtonId == R.id.female ? 2 : 0;
        userProfile.setGender(checkedRadioButtonId);
        userProfile.setMail(this.f2747e.m6053a().toString());
        mo4228a(true);
        SAM.f2614g.m5613a(userProfile, new C1646j(this));
    }

    protected void mo4228a(boolean z) {
        super.mo4228a(z);
        this.f2746a.setEnabled(!z);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(f2741l, this.c);
        bundle.putString(f2742m, this.f2748f.m6053a().toString());
        bundle.putString(f2743n, this.f2749g.m6053a().toString());
        bundle.putString(f2744o, this.f2751i.m6053a().toString());
        bundle.putInt(f2745p, this.f2752j.getCheckedRadioButtonId());
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        mo4228a(bundle.getBoolean(f2741l));
        this.f2748f.m6056a(bundle.getString(f2742m));
        this.f2749g.m6056a(bundle.getString(f2743n));
        this.f2751i.m6056a(bundle.getString(f2744o));
        this.f2752j.check(bundle.getInt(f2745p));
    }

    protected void mo4241a(Intent intent) {
        super.mo4241a(intent);
        if (m4912b(getIntent())) {
            C1698a.m5062a((Context) this, false);
        }
    }
}
