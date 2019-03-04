package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.slideme.sam.manager.R;

public class VerifyableEditText extends FrameLayout {
    Handler f3760a = new Handler();
    private int f3761b = 750;
    private Runnable f3762c = new aw(this);
    private bb f3763d = new ax(this);
    private ba f3764e;
    private SafeViewFlipper f3765f;
    private EditText f3766g;
    private String f3767h;
    private bc f3768i = bc.UNVERIFIED;

    public VerifyableEditText(Context context) {
        super(context);
        m6045a(null);
    }

    public VerifyableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6045a(attributeSet);
    }

    public VerifyableEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6045a(attributeSet);
    }

    private void m6045a(AttributeSet attributeSet) {
        int i;
        CharSequence charSequence;
        int i2;
        LengthFilter lengthFilter = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16843088, 16843296, 16843364, 16843104});
            String string = obtainStyledAttributes.getString(0);
            i = obtainStyledAttributes.getInt(1, 0);
            int i3 = obtainStyledAttributes.getInt(2, 6);
            int i4 = obtainStyledAttributes.getInt(3, -1);
            if (i4 > 0) {
                lengthFilter = new LengthFilter(i4);
            }
            obtainStyledAttributes.recycle();
            charSequence = string;
            i2 = i;
            i = i3;
            InputFilter inputFilter = lengthFilter;
        } else {
            i = 6;
            i2 = 0;
            charSequence = null;
            Object obj = null;
        }
        inflate(getContext(), R.layout.widget_verifyable_edittext, this);
        this.f3765f = (SafeViewFlipper) findViewById(R.id.status);
        this.f3766g = (EditText) findViewById(R.id.text);
        this.f3766g.setHint(charSequence);
        this.f3766g.setInputType(i2);
        this.f3766g.setImeOptions(i);
        if (inputFilter != null) {
            this.f3766g.setFilters(new InputFilter[]{inputFilter});
        }
        this.f3766g.addTextChangedListener(new ay(this));
        this.f3765f.setOnClickListener(new az(this));
        this.f3767h = getContext().getString(R.string.generic_empty);
    }

    public CharSequence m6053a() {
        return this.f3766g.getText();
    }

    public void m6056a(CharSequence charSequence) {
        this.f3766g.setText(charSequence);
        this.f3762c.run();
    }

    private void m6047a(bc bcVar) {
        this.f3768i = bcVar;
        this.f3765f.setDisplayedChild(bcVar.ordinal());
        if (this.f3764e != null) {
            this.f3764e.mo4243a(bcVar);
        }
    }

    public void m6055a(bb bbVar) {
        this.f3763d = bbVar;
    }

    public void setDelay(int i) {
        this.f3761b = i;
    }

    public void m6054a(ba baVar) {
        this.f3764e = baVar;
    }

    public void m6057a(String str) {
        this.f3767h = str;
    }

    public void setUnverifiedText(int i) {
        this.f3767h = getResources().getString(i);
    }

    public boolean m6058b() {
        return this.f3768i == bc.VERIFIED;
    }

    public void m6059c() {
        this.f3760a.removeCallbacks(this.f3762c);
        this.f3760a.postDelayed(this.f3762c, (long) this.f3761b);
    }

    public bb m6060d() {
        return this.f3763d;
    }

    public void setHint(int i) {
        this.f3766g.setHint(i);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.f3766g.setFilters(inputFilterArr);
    }
}
