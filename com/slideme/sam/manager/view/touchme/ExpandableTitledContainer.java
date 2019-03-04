package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.slideme.sam.manager.C1608b;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.util.p063a.C1908b;

public class ExpandableTitledContainer extends FrameLayout {
    private View f3677a;
    private ViewGroup f3678b;
    private TextView f3679c;
    private TextView f3680d;
    private ImageView f3681e;
    private ImageView f3682f;
    private boolean f3683g = false;
    private C1762l f3684h;
    private OnClickListener f3685i = new C1978k(this);

    public ExpandableTitledContainer(Context context) {
        super(context);
        m5952a(null);
    }

    public ExpandableTitledContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5952a(attributeSet);
    }

    public ExpandableTitledContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5952a(attributeSet);
    }

    private void m5952a(AttributeSet attributeSet) {
        int resourceId;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        layoutInflater.inflate(R.layout.widget_expandable_titled_container, this);
        this.f3677a = findViewById(R.id.title_layout);
        this.f3678b = (ViewGroup) findViewById(R.id.container_layout);
        this.f3679c = (TextView) findViewById(R.id.title);
        this.f3680d = (TextView) findViewById(R.id.subtitle);
        this.f3681e = (ImageView) findViewById(R.id.indicator);
        this.f3682f = (ImageView) findViewById(R.id.icon);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1608b.ExpandableTitledContainer);
            resourceId = obtainStyledAttributes.getResourceId(0, 0);
            m5960a(obtainStyledAttributes.getString(2));
            m5961b(obtainStyledAttributes.getString(3));
            m5958a(obtainStyledAttributes.getDrawable(1));
            obtainStyledAttributes.recycle();
        } else {
            resourceId = 0;
        }
        if (resourceId != 0) {
            layoutInflater.inflate(resourceId, this.f3678b);
        }
        this.f3677a.setOnClickListener(this.f3685i);
        this.f3678b.setVisibility(8);
        if (VERSION.SDK_INT >= 11) {
            C1908b.m5749a((ViewGroup) this);
        }
    }

    public void m5960a(CharSequence charSequence) {
        this.f3679c.setText(charSequence);
    }

    public void m5961b(CharSequence charSequence) {
        this.f3680d.setText(charSequence);
    }

    public void m5958a(Drawable drawable) {
        this.f3682f.setImageDrawable(drawable);
    }

    private void m5951a() {
        this.f3678b.setVisibility(0);
        this.f3683g = true;
        if (this.f3684h != null) {
            this.f3684h.mo4270a();
        }
    }

    private void m5954b() {
        this.f3678b.setVisibility(8);
        this.f3683g = false;
    }

    public void m5959a(C1762l c1762l) {
        this.f3684h = c1762l;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("STATE_SUPERSTATE", super.onSaveInstanceState());
        bundle.putBoolean("STATE_IS_VISIBLE", this.f3683g);
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("STATE_SUPERSTATE"));
            this.f3683g = bundle.getBoolean("STATE_IS_VISIBLE");
            if (this.f3683g) {
                m5951a();
                return;
            } else {
                m5954b();
                return;
            }
        }
        super.onRestoreInstanceState(parcelable);
    }
}
