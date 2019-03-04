package com.slideme.sam.manager.view.p064a.p065a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.p026b.p027a.p034b.p035a.C0476d;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.Category;

/* compiled from: CategoryViewFactory */
public class C1926d extends C1923a<Category> {
    private Activity f3518a;

    public C1926d(Activity activity) {
        this.f3518a = activity;
    }

    public View m5819a(int i, Category category, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.f3518a.getSystemService("layout_inflater")).inflate(R.layout.listitem_category, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.category_display_name)).setText(category.name);
        ((TextView) view.findViewById(R.id.category_display_count)).setText(String.valueOf(category.count));
        return view;
    }

    public View mo4320a() {
        return null;
    }

    public View m5820a(int i, Category category, View view, ViewGroup viewGroup, C0476d c0476d) {
        return m5820a(i, category, view, viewGroup, null);
    }
}
