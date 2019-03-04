package com.slideme.sam.manager.view.actionview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.content.C0090q;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AuthData;

public class WalletView extends FrameLayout {
    private BroadcastReceiver f3595a = new C1951a(this);
    private BroadcastReceiver f3596b = new C1952b(this);

    public WalletView(Context context) {
        super(context);
        m5860a();
    }

    public WalletView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5860a();
    }

    public WalletView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5860a();
    }

    private void m5860a() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.widget_wallet, this);
        if (AuthData.m4814j(getContext()) < 0.0f) {
            setWalletText(GroundOverlayOptions.NO_DIMENSION);
        } else {
            setWalletText(AuthData.m4814j(getContext()));
        }
        setOnClickListener(new C1953c(this));
        setBackgroundResource(R.drawable.bg_clickable_borderless);
        setLayoutParams(new LayoutParams(-2, -1));
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0090q.m145a(getContext()).m149a(this.f3596b, new IntentFilter("com.slideme.sam.manager.ACTION_WALLET_REFRESH_INITIATED"));
        C0090q.m145a(getContext()).m149a(this.f3595a, new IntentFilter("com.slideme.sam.manager.ACTION_WALLET_REFRESH_FINISHED"));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0090q.m145a(getContext()).m148a(this.f3596b);
        C0090q.m145a(getContext()).m148a(this.f3595a);
    }

    private void setWalletText(float f) {
        CharSequence string;
        if (f < 0.0f) {
            string = getContext().getString(R.string.loading);
        } else {
            Object a = SAM.f2616i.m5487a((double) f);
        }
        ((TextView) findViewById(R.id.balance)).setText(string);
    }
}
