package com.slideme.sam.manager.controller.activities.market.product;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.actionbarsherlock.view.Menu;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0359q;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.common.AccountAwareActivity;
import com.slideme.sam.manager.controller.p053a.C1614e;
import com.slideme.sam.manager.controller.p053a.C1623n;
import com.slideme.sam.manager.controller.p053a.C1626q;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.model.p054b.C1683i;
import com.slideme.sam.manager.model.service.ApplicationDownloadService;
import com.slideme.sam.manager.util.C1915f;
import com.slideme.sam.manager.util.C1920k;

public class TermsActivity extends AccountAwareActivity implements C1626q {
    private static /* synthetic */ int[] f2835n;
    private final int f2836a = 1;
    private ApplicationHolder f2837b;
    private C1614e f2838c;
    private C1683i f2839d;
    private boolean f2840e = false;
    private Button f2841f;
    private TextView f2842g;
    private C1693r f2843h = C1693r.UNCHECKED;
    private OnClickListener f2844i;
    private OnClickListener f2845j = new C1678d(this);
    private OnClickListener f2846l = new C1681g(this);
    @Deprecated
    private OnClickListener f2847m = new C1682h(this);

    static /* synthetic */ int[] m4993b() {
        int[] iArr = f2835n;
        if (iArr == null) {
            iArr = new int[C1693r.values().length];
            try {
                iArr[C1693r.FREE.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C1693r.PURCHASED.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1693r.UNCHECKED.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C1693r.UNPURCHASED.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            f2835n = iArr;
        }
        return iArr;
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(5);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_terms);
        this.f2838c = new C1614e();
        this.f2837b = (ApplicationHolder) getIntent().getParcelableExtra("com.slideme.sam.manager.EXTRA_APPHOLDER");
        m5002h();
        this.f2839d = new C1684i(this);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        setSupportProgressBarIndeterminateVisibility(false);
    }

    private void m5002h() {
        this.f2837b.downloadTerms(new C1685j(this));
        this.f2837b.downloadPrivacyPolicy(new C1687l(this));
        if (!(getResources().getBoolean(R.bool.disableCompatibillityNotice) || this.f2837b.app.isCompatible)) {
            findViewById(R.id.incompatibleTitle).setVisibility(0);
            findViewById(R.id.incompatibleText).setVisibility(0);
            if (!TextUtils.isEmpty(this.f2837b.app.compatibilityMessage)) {
                TextView textView = (TextView) findViewById(R.id.incompatibleReason);
                textView.setVisibility(0);
                textView.setText(this.f2837b.app.compatibilityMessage);
            }
        }
        findViewById(R.id.negative).setOnClickListener(new C1689n(this));
        this.f2841f = (Button) findViewById(R.id.positive);
        this.f2842g = (TextView) findViewById(R.id.terms_price);
        this.f2841f.setOnClickListener(new C1690o(this));
    }

    private void m5003i() {
        m4995c(true);
        m4997d(true);
        SAM.f2614g.m5641d(new C1691p(this));
    }

    private void m4995c(boolean z) {
        this.f2841f.setEnabled(!z);
    }

    private void m5005j() {
        Intent intent = new Intent(this, ApplicationDownloadService.class);
        C1915f.m5769a(intent, "com.slideme.sam.manager.EXTRA_APPLICATION", this.f2837b.app);
        startService(intent);
        finish();
    }

    private void m5006k() {
        m4997d(false);
        runOnUiThread(new C1679e(this));
    }

    private void m5007l() {
        if (this.f2837b.app.token != null) {
            m5005j();
        } else if (this.f2839d.m5018c()) {
            C1920k.m5781a((Context) this, (int) R.string.please_wait, 0).show();
        } else {
            this.f2839d.m5015a(this.f2837b.app);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.options_terms, menu);
        return true;
    }

    private void m4997d(boolean z) {
        runOnUiThread(new C1680f(this, z));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i2) {
            case -1:
                if (intent != null) {
                    C0345b.m2427c().m2437a((C0359q) ((C0359q) new C0359q("Download Purchase").m2364a("type", "app")).m2364a("id", this.f2837b.app.bundleId));
                    this.f2837b.app.token = intent.getExtras().getString("com.slideme.sam.manager.RESULT_WEBBUY_TOKEN");
                    SAM.m4763a((Context) this);
                    m5007l();
                    return;
                }
                return;
            case 0:
                C0345b.m2427c().m2437a((C0359q) ((C0359q) new C0359q("Cancelled Purchase").m2364a("type", "app")).m2364a("id", this.f2837b.app.bundleId));
                C1920k.m5781a((Context) this, (int) R.string.purchase_canceled, 0).show();
                return;
            case 2:
                C1920k.m5781a((Context) this, (int) R.string.untrusted_host, 0).show();
                return;
            default:
                return;
        }
    }

    private void m4990a(C1693r c1693r) {
        this.f2843h = c1693r;
        switch (m4993b()[this.f2843h.ordinal()]) {
            case 1:
                this.f2841f.setText(R.string.check_previous_purchase);
                this.f2844i = this.f2847m;
                this.f2842g.setText(SAM.f2616i.m5487a(this.f2837b.app.price));
                return;
            case 2:
                this.f2841f.setText(R.string.purchase);
                this.f2844i = this.f2846l;
                this.f2842g.setText(SAM.f2616i.m5487a(this.f2837b.app.price));
                return;
            case 3:
                this.f2841f.setText(R.string.download);
                this.f2844i = this.f2846l;
                this.f2842g.setText(R.string.already_purchased_free);
                return;
            case 4:
                this.f2841f.setText(R.string.download);
                this.f2844i = this.f2845j;
                this.f2842g.setText(R.string.free);
                return;
            default:
                return;
        }
    }

    public void mo4247a(boolean z) {
        if (!z) {
            C1920k.m5781a((Context) this, (int) R.string.incorrect_pin, 0).show();
        } else if (this.f2844i != null) {
            this.f2844i.onClick(this.f2841f);
        }
    }

    private void m5008m() {
        new C1623n().show(getSupportFragmentManager(), "dialog");
    }

    protected void onPause() {
        super.onPause();
        this.f2840e = true;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f2839d.m5017b();
    }

    public void mo4239a() {
        SAM.m4763a((Context) this);
        m4796e();
        if (this.f2837b.app.price <= 0.0d) {
            m4990a(C1693r.FREE);
        } else if (this.f2837b.app.token != null) {
            m4990a(C1693r.PURCHASED);
        } else {
            m4990a(C1693r.UNPURCHASED);
            m5003i();
        }
    }
}
