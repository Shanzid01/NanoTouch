package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.p019a.p020a.p021a.C0343a;
import com.p019a.p020a.p021a.C0345b;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.market.product.ApplicationDetailsActivity;
import com.slideme.sam.manager.controller.activities.market.product.TermsActivity;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.model.p054b.C1828b;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;

public class DownloadButton extends FrameLayout {
    private static /* synthetic */ int[] f3662h;
    private ApplicationHolder f3663a = null;
    private TextView f3664b = null;
    private TextView f3665c = null;
    private TextView f3666d = null;
    private View f3667e = null;
    private ViewGroup f3668f = null;
    private ApplicationDetailsActivity f3669g;

    static /* synthetic */ int[] m5927d() {
        int[] iArr = f3662h;
        if (iArr == null) {
            iArr = new int[C1828b.values().length];
            try {
                iArr[C1828b.NEEDS_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C1828b.NOT_INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1828b.UP_TO_DATE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            f3662h = iArr;
        }
        return iArr;
    }

    public DownloadButton(Context context) {
        super(context);
        m5928a();
    }

    public DownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5928a();
    }

    public void m5928a() {
        ((LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.widget_download_button, this).findViewById(R.id.full)).setOnFocusChangeListener(new C1973f(this));
        this.f3664b = (TextView) findViewById(R.id.title);
        this.f3667e = findViewById(R.id.separator);
        this.f3665c = (TextView) findViewById(R.id.price_old);
        this.f3666d = (TextView) findViewById(R.id.price_new);
        this.f3668f = (ViewGroup) findViewById(R.id.price_container);
        this.f3665c.setPaintFlags(this.f3665c.getPaintFlags() | 16);
        findViewById(R.id.full).setOnClickListener(new C1974g(this));
    }

    public void m5931b() {
        if (this.f3663a.app.price > 0.0d) {
            C0345b.m2427c().m2431a(new C0343a().m2369a(BigDecimal.valueOf(this.f3663a.app.price)).m2370a(Currency.getInstance("USD")).m2373b(this.f3663a.app.getName()).m2374c("app").m2368a(this.f3663a.app.bundleId));
        }
        Intent intent = new Intent(getContext(), TermsActivity.class);
        intent.putExtra("com.slideme.sam.manager.EXTRA_APPHOLDER", this.f3663a);
        this.f3669g.startActivity(intent);
    }

    public void m5930a(ApplicationHolder applicationHolder) {
        this.f3663a = applicationHolder;
        m5932c();
    }

    public void m5929a(ApplicationDetailsActivity applicationDetailsActivity) {
        this.f3669g = applicationDetailsActivity;
    }

    public void m5932c() {
        int i = 8;
        if (this.f3663a != null) {
            float f = (float) this.f3663a.app.priceOld;
            float f2 = (float) this.f3663a.app.price;
            switch (m5927d()[this.f3663a.getInstallState(getContext()).ordinal()]) {
                case 1:
                    this.f3664b.setText(R.string.open);
                    this.f3668f.setVisibility(8);
                    this.f3665c.setVisibility(8);
                    this.f3666d.setVisibility(8);
                    this.f3667e.setVisibility(8);
                    break;
                case 2:
                    if (f2 != 0.0f) {
                        this.f3664b.setText(R.string.download);
                        this.f3668f.setVisibility(0);
                        TextView textView = this.f3665c;
                        if (f > 0.0f) {
                            i = 0;
                        }
                        textView.setVisibility(i);
                        this.f3666d.setVisibility(0);
                        this.f3667e.setVisibility(0);
                        NumberFormat.getInstance().setMinimumFractionDigits(2);
                        this.f3665c.setText(SAM.f2616i.m5487a((double) f));
                        this.f3666d.setText(SAM.f2616i.m5487a((double) f2));
                        break;
                    }
                    this.f3664b.setText(R.string.download);
                    this.f3666d.setText(R.string.free);
                    this.f3668f.setVisibility(0);
                    this.f3666d.setVisibility(0);
                    this.f3665c.setVisibility(8);
                    this.f3667e.setVisibility(0);
                    break;
                case 3:
                    this.f3664b.setText(R.string.update);
                    this.f3668f.setVisibility(8);
                    this.f3665c.setVisibility(8);
                    this.f3666d.setVisibility(8);
                    this.f3667e.setVisibility(8);
                    break;
            }
            if (!this.f3663a.app.isCompatible && getResources().getBoolean(R.bool.showIncompatibilityIndicators)) {
                this.f3664b.setText(R.string.incompatible);
            }
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        findViewById(R.id.full).setEnabled(z);
    }
}
