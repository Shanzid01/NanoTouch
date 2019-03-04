package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.slideme.sam.manager.R;

public class ReviewFilterControlView extends FrameLayout {
    private Spinner f3733a = null;
    private Spinner f3734b = null;
    private LinearLayout f3735c = null;
    private ArrayAdapter<CharSequence> f3736d = null;
    private ah f3737e = new ac(this);

    public ReviewFilterControlView(Context context) {
        super(context);
        m6013a();
    }

    public ReviewFilterControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6013a();
    }

    public ReviewFilterControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6013a();
    }

    private void m6013a() {
        addView(((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.widget_filter_control, null));
        this.f3733a = (Spinner) findViewById(R.id.primarySpinner);
        this.f3734b = (Spinner) findViewById(R.id.secondarySpinner);
        this.f3734b.setAdapter(this.f3736d);
        this.f3735c = (LinearLayout) findViewById(R.id.secondaryContainer);
        this.f3733a.setOnItemSelectedListener(new ad(this));
    }

    private void setEntries(CharSequence[] charSequenceArr) {
        this.f3736d = new ArrayAdapter(getContext(), 17367048, charSequenceArr);
        this.f3736d.setDropDownViewResource(17367049);
        this.f3734b.setAdapter(this.f3736d);
    }

    public void m6017a(ah ahVar) {
        this.f3737e = ahVar;
    }
}
