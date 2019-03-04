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

public class ClosableTextPanel extends RelativeLayout {
    private boolean f3658a = false;
    private TextView f3659b;
    private TextView f3660c;
    private C1972e f3661d = C1972e.CLOSABLE_PANEL;

    public ClosableTextPanel(Context context) {
        super(context);
        m5916a(null);
    }

    public ClosableTextPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5916a(attributeSet);
    }

    public ClosableTextPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5916a(attributeSet);
    }

    private void m5916a(AttributeSet attributeSet) {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.widget_text_panel, this);
        this.f3659b = (TextView) findViewById(16908308);
        this.f3660c = (TextView) findViewById(16908309);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1608b.ClosableTextPanel);
            m5922a(obtainStyledAttributes.getString(0));
            m5924b(obtainStyledAttributes.getString(1));
            obtainStyledAttributes.recycle();
        }
        findViewById(16908313).setOnClickListener(new C1970c(this));
    }

    public void setClosedState(boolean z) {
        if (z) {
            setVisibility(8);
        }
        this.f3658a = z;
    }

    public void m5921a(C1972e c1972e) {
        this.f3661d = c1972e;
    }

    public C1972e m5920a() {
        return this.f3661d;
    }

    public void m5922a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f3659b.setText(str);
            if (this.f3661d == C1972e.CLOSABLE_PANEL) {
                if (!m5919d().equals(str)) {
                    setShowNextTime(true);
                }
                getContext().getSharedPreferences("text_panel_prefs", 0).edit().putString("stickyMessage", str).commit();
            }
        }
    }

    public void setTitle(int i) {
        m5922a(getResources().getString(i));
    }

    public String m5923b() {
        return this.f3659b.getText().toString();
    }

    public void m5924b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f3660c.setText(str);
            this.f3660c.setVisibility(0);
        }
    }

    public void setSubtitle(int i) {
        m5924b(getResources().getString(i));
    }

    public void m5925c() {
        if (m5918c(m5923b())) {
            setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            Animator duration = ObjectAnimator.ofFloat((Object) this, "translationY", getResources().getDimension(R.dimen.ad_banner_height), 0.0f).setDuration((long) getResources().getInteger(17694722));
            duration.setInterpolator(new DecelerateInterpolator());
            animatorSet.play(duration);
            animatorSet.start();
            return;
        }
        setVisibility(8);
    }

    private String m5919d() {
        return getContext().getSharedPreferences("text_panel_prefs", 0).getString("stickyMessage", "");
    }

    private boolean m5918c(String str) {
        if (TextUtils.isEmpty(str) || this.f3658a) {
            return false;
        }
        if (this.f3661d == C1972e.UPDATE_PANEL || this.f3661d == C1972e.STICKY_PANEL) {
            return true;
        }
        return getContext().getSharedPreferences("text_panel_prefs", 0).getBoolean("showPanel", true);
    }

    public void setShowNextTime(boolean z) {
        getContext().getSharedPreferences("text_panel_prefs", 0).edit().putBoolean("showPanel", z).commit();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("STATE_SUPERSTATE", super.onSaveInstanceState());
        bundle.putBoolean("STATE_IS_CLOSED", this.f3658a);
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("STATE_SUPERSTATE"));
            this.f3658a = bundle.getBoolean("STATE_IS_CLOSED");
            if (this.f3658a) {
                setVisibility(8);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
