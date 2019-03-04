package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.slideme.sam.manager.C1608b;
import com.slideme.sam.manager.R;

public class NotificationPanel extends RelativeLayout {
    private boolean f3719a = false;
    private TextView f3720b;
    private TextView f3721c;

    public NotificationPanel(Context context) {
        super(context);
        m5992a(null);
    }

    public NotificationPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5992a(attributeSet);
    }

    public NotificationPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5992a(attributeSet);
    }

    private void m5992a(AttributeSet attributeSet) {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.widget_text_panel, this);
        this.f3720b = (TextView) findViewById(16908308);
        this.f3721c = (TextView) findViewById(16908309);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1608b.ClosableTextPanel);
            m5997a(obtainStyledAttributes.getString(0));
            m5999b(obtainStyledAttributes.getString(1));
            obtainStyledAttributes.recycle();
        }
        findViewById(16908313).setOnClickListener(new C1991y(this));
    }

    public void setClosedState(boolean z) {
        if (z) {
            setVisibility(8);
        }
        this.f3719a = z;
    }

    public void m5997a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f3720b.setText(str);
        }
    }

    public void setTitle(int i) {
        m5997a(getResources().getString(i));
    }

    public String m5995a() {
        return this.f3720b.getText().toString();
    }

    public void m5999b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f3721c.setText(str);
            this.f3721c.setVisibility(0);
        }
    }

    public void setSubtitle(int i) {
        m5999b(getResources().getString(i));
    }

    public void m5998b() {
        m5996a(0);
    }

    public void m5996a(long j) {
        if (m5994c(m5995a())) {
            setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            Animator duration = ObjectAnimator.ofFloat((Object) this, "translationY", getResources().getDimension(R.dimen.ad_banner_height), 0.0f).setDuration((long) getResources().getInteger(17694722));
            duration.setStartDelay(j);
            duration.setInterpolator(new DecelerateInterpolator());
            animatorSet.play(duration);
            animatorSet.start();
            return;
        }
        setVisibility(8);
    }

    private boolean m5994c(String str) {
        return (TextUtils.isEmpty(str) || this.f3719a) ? false : true;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("STATE_SUPERSTATE", super.onSaveInstanceState());
        bundle.putBoolean("STATE_IS_CLOSED", this.f3719a);
        return bundle;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("STATE_SUPERSTATE"));
            this.f3719a = bundle.getBoolean("STATE_IS_CLOSED");
            if (this.f3719a) {
                setVisibility(8);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
