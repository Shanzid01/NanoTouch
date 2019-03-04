package com.slideme.sam.manager.inapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.actionbarsherlock.view.Menu;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0364x;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.common.AccountAwareActivity;
import com.slideme.sam.manager.controller.activities.common.C1665j;
import com.slideme.sam.manager.controller.activities.web.WebViewActivity;
import com.slideme.sam.manager.inapp.openiab.C1806c;
import com.slideme.sam.manager.model.data.inapp.InAppProduct;
import com.slideme.sam.manager.net.response.InAppPurchaseResponse;
import com.slideme.sam.manager.util.C1922m;
import java.math.BigDecimal;
import java.util.Currency;

public class InAppPurchasingActivity extends AccountAwareActivity {
    private static final int f3188a = C1665j.values().length;
    private static final int f3189b = (f3188a + 1);
    private static final int f3190c = (f3188a + 2);
    private C1791h f3191d;
    private InAppProduct f3192e;
    private String f3193f;
    private String f3194g;
    private int f3195h;
    private boolean f3196i = false;
    private boolean f3197j = false;
    private String f3198l;
    private int f3199m = 0;
    private InAppPurchaseResponse f3200n;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3198l = getIntent().getStringExtra("com.slideme.sam.manager.extra.IAP_ID");
        this.f3193f = getIntent().getStringExtra("com.slideme.sam.manager.extra.CALLER_PACKAGE");
        this.f3194g = getIntent().getStringExtra("com.slideme.sam.manager.extra.DEVELOPER_PAYLOAD");
        this.f3195h = getIntent().getIntExtra("com.slideme.sam.manager.extra.API_VERSION", -1);
        this.f3196i = bundle != null;
        this.f3197j = getIntent().getBooleanExtra("OPENIAB", false);
        m4793a(getLayoutInflater().inflate(R.layout.widget_iap_error, null), f3188a);
        m4793a(getLayoutInflater().inflate(R.layout.widget_iap_already_owned, null), f3189b);
        m4793a(getLayoutInflater().inflate(R.layout.widget_iap_success, null), f3190c);
        m4798g();
        m5331l();
        if (bundle != null) {
            bundle.setClassLoader(InAppProduct.class.getClassLoader());
            this.f3192e = (InAppProduct) bundle.getParcelable("state_product");
        }
        this.f3191d = (C1791h) getSupportFragmentManager().findFragmentByTag("content_fragment");
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.options_iap_purchasing, menu);
        return true;
    }

    private void m5331l() {
        OnClickListener c1789f = new C1789f(this);
        Button button = (Button) findViewById(R.id.purchase_ok_button);
        button.setText(getString(R.string.iap_success_button, new Object[]{m5341k()}));
        button.setOnClickListener(c1789f);
        button = (Button) findViewById(R.id.purchase_already_owned_button);
        button.setText(getString(R.string.iap_success_button, new Object[]{m5341k()}));
        button.setOnClickListener(c1789f);
        findViewById(R.id.purchase_error_button).setOnClickListener(c1789f);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("state_product", this.f3192e);
    }

    public void mo4239a() {
        if (this.f3192e != null || this.f3191d != null) {
            m5332m();
        } else if (TextUtils.isEmpty(this.f3198l)) {
            m5339i();
        } else {
            SAM.f2614g.m5600a(this.f3195h, this.f3198l, this.f3193f, new C1790g(this));
        }
    }

    private void m5332m() {
        if (this.f3191d == null) {
            this.f3191d = new C1791h();
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.slideme.sam.manager.extra.IAP_PRODUCT", this.f3192e);
            bundle.putString("com.slideme.sam.manager.extra.CALLER_PACKAGE", this.f3193f);
            bundle.putString("com.slideme.sam.manager.extra.DEVELOPER_PAYLOAD", this.f3194g);
            bundle.putInt("com.slideme.sam.manager.extra.API_VERSION", this.f3195h);
            this.f3191d.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(m4798g().getId(), this.f3191d, "content_fragment").commit();
            m4796e();
        }
        if (!this.f3196i) {
            m4796e();
        }
    }

    public void mo4273f() {
        super.mo4273f();
    }

    void m5334a(InAppPurchaseResponse inAppPurchaseResponse) {
        m5330c(1);
        m4792a(f3190c);
        C0345b.m2427c().m2439a(new C0364x().m2496a(BigDecimal.valueOf((double) this.f3192e.price)).m2497a(Currency.getInstance("USD")).m2501b(this.f3192e.title).m2502c("inapp").m2495a(this.f3192e.productId));
        this.f3200n = inAppPurchaseResponse;
    }

    void mo4242b() {
        m5330c(5);
        m4792a(f3189b);
    }

    void m5338h() {
        m5330c(4);
        m4792a(f3188a);
    }

    void m5335a(String str) {
        m5330c(6);
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("com.slideme.sam.manager.extra.URL", str);
        intent.setFlags(33554432);
        startActivity(intent);
    }

    void m5339i() {
        m5330c(2);
        m4792a(f3188a);
        C1922m.m5791a(new Exception("Invalid product nid!"));
    }

    void m5340j() {
        m5330c(3);
        m4792a(f3188a);
        C1922m.m5791a(new Exception("Item out of stock!"));
    }

    private void m5330c(int i) {
        this.f3199m = i;
    }

    public void finish() {
        if (this.f3199m == 0) {
            setResult(0);
        } else {
            Intent intent = new Intent();
            if (this.f3197j) {
                intent.putExtra("RESPONSE_CODE", C1806c.m5411a(this.f3199m));
                if (this.f3199m == 1) {
                    intent.putExtra("INAPP_PURCHASE_DATA", this.f3200n.data);
                    intent.putExtra("INAPP_DATA_SIGNATURE", this.f3200n.signature);
                }
            } else {
                Bundle a = InAppService.m5342a(this.f3199m);
                if (this.f3199m == 1) {
                    a.putString("com.slideme.sam.manager.inapp.BUNDLE_PURCHASE_DATA", this.f3200n.data);
                    a.putString("com.slideme.sam.manager.inapp.BUNDLE_SIGNATURE", this.f3200n.signature);
                    intent.putExtra("com.slideme.sam.manager.inapp.extra.RESPONSE", a);
                }
            }
            setResult(-1, intent);
        }
        super.finish();
    }

    public CharSequence m5341k() {
        try {
            return getPackageManager().getApplicationLabel(getPackageManager().getApplicationInfo(this.f3193f, 128));
        } catch (Exception e) {
            C1922m.m5790a(e);
            return "";
        }
    }
}
