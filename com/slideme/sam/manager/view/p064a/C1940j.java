package com.slideme.sam.manager.view.p064a;

import android.view.View;
import android.view.ViewGroup;
import com.p026b.p027a.p034b.p035a.C0476d;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.view.p064a.p065a.C1923a;

/* compiled from: HybridApplicationListAdapter */
public class C1940j extends C1939o<Application> {
    C0476d f3562a;

    public C1940j(C1923a c1923a, C0476d c0476d) {
        super(c1923a);
        this.f3562a = c0476d;
    }

    public C1940j(C1923a c1923a) {
        this(c1923a, null);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i == this.c.size()) {
            return this.b.mo4320a();
        }
        return this.b.mo4322a(i, new ApplicationHolder((Application) getItem(i)), view, viewGroup, this.f3562a);
    }
}
