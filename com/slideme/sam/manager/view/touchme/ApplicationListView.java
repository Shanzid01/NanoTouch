package com.slideme.sam.manager.view.touchme;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.slideme.sam.manager.C1608b;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.net.wrappers.Catalog;
import com.slideme.sam.manager.view.p064a.C1940j;
import com.slideme.sam.manager.view.p064a.p065a.C1924b;
import java.util.ArrayList;
import java.util.List;

public class ApplicationListView extends LinearLayout {
    private int f3646a = 2;
    private C1940j f3647b = null;
    private Catalog f3648c;
    private String f3649d;
    private String f3650e;
    private Activity f3651f;

    public ApplicationListView(Context context) {
        super(context);
        m5908a(null);
    }

    public ApplicationListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5908a(attributeSet);
    }

    protected void m5908a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1608b.ApplicationListView);
            this.f3646a = obtainStyledAttributes.getInt(0, this.f3646a);
            this.f3649d = obtainStyledAttributes.getString(1);
            obtainStyledAttributes.recycle();
        }
        setOrientation(1);
        setGravity(17);
    }

    public void m5910a(String str) {
        this.f3650e = str;
    }

    public void m5909a(Catalog catalog) {
        this.f3648c = catalog;
        int i = this.f3650e == null ? this.f3646a : this.f3646a + 1;
        this.f3648c.m5659a(i);
        this.f3648c.m5670b(i);
        this.f3648c.m5660a(new C1968a(this));
    }

    public void m5906a() {
        removeAllViews();
        this.f3647b = new C1940j(new C1924b(this.f3651f));
        this.f3647b.m5842a(m5903a(this.f3648c.m5693i()));
        if (this.f3647b == null || this.f3647b.getCount() == 0) {
            inflate(getContext(), R.layout.widget_empty_indicator, this);
            ((TextView) findViewById(R.id.indicator)).setText(this.f3649d);
        } else if (this.f3647b != null && this.f3647b.getCount() > 0) {
            int applyDimension = (int) TypedValue.applyDimension(1, 3.0f, getContext().getResources().getDisplayMetrics());
            int[] iArr = new int[2];
            iArr[0] = R.attr.secondaryDivider;
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(iArr);
            int color = obtainStyledAttributes.getColor(0, -16777216);
            obtainStyledAttributes.recycle();
            int i = 0;
            while (i < this.f3647b.getCount() && i < this.f3646a) {
                View view = this.f3647b.getView(i, null, null);
                view.setOnClickListener(new C1969b(this, i));
                view.setBackgroundResource(R.drawable.bg_clickable_borderless);
                ((BeveledRelativeLayout) view).setShowBevels(false);
                addView(view);
                View view2 = new View(getContext());
                view2.setLayoutParams(new LayoutParams(-1, 1));
                view2.setPadding(0, applyDimension, 0, applyDimension);
                view2.setBackgroundColor(color);
                addView(view2);
                i++;
            }
        }
    }

    private List<Application> m5903a(ArrayList<Application> arrayList) {
        int i;
        if (this.f3650e != null) {
            i = 0;
            while (i < arrayList.size()) {
                if (((Application) arrayList.get(i)).bundleId.equals(this.f3650e)) {
                    break;
                }
                i++;
            }
        }
        i = -1;
        if (i != -1) {
            arrayList.remove(i);
        }
        return arrayList;
    }

    public void m5911b() {
        this.f3648c.m5685f();
    }

    public void m5907a(Activity activity) {
        this.f3651f = activity;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("STATE_SUPERSTATE", super.onSaveInstanceState());
        bundle.putInt("STATE_NUM_APPS", this.f3646a);
        bundle.putParcelable("STATE_CATALOG", this.f3648c);
        bundle.putString("STATE_IGNORE_UID", this.f3650e);
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("STATE_SUPERSTATE"));
            this.f3646a = bundle.getInt("STATE_NUM_APPS");
            bundle.setClassLoader(getClass().getClassLoader());
            this.f3648c = (Catalog) bundle.getParcelable("STATE_CATALOG");
            this.f3650e = bundle.getString("STATE_IGNORE_UID");
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
