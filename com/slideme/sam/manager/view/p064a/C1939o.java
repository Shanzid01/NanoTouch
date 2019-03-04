package com.slideme.sam.manager.view.p064a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.slideme.sam.manager.view.p064a.p065a.C1923a;
import com.slideme.sam.manager.view.p064a.p065a.C1924b;
import java.util.List;

/* compiled from: SamListAdapter */
public class C1939o<T> extends BaseAdapter {
    private boolean f3558a = false;
    final C1923a f3559b;
    protected List<T> f3560c;
    private int f3561d = 0;

    public C1939o(C1923a c1923a) {
        this.f3559b = c1923a;
        if (c1923a == null) {
            throw new IllegalArgumentException("null factory");
        }
    }

    public void m5842a(List<T> list) {
        this.f3560c = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        int i = this.f3561d;
        int i2 = (this.f3561d <= 0 || !this.f3558a) ? 0 : 1;
        return i2 + i;
    }

    public void m5843a(boolean z) {
        this.f3558a = z;
    }

    public boolean m5844a() {
        return this.f3558a;
    }

    public T getItem(int i) {
        return this.f3560c != null ? this.f3560c.get(i) : null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i == this.f3560c.size()) {
            return this.f3559b.mo4320a();
        }
        return this.f3559b.mo4321a(i, getItem(i), view, viewGroup);
    }

    public void notifyDataSetChanged() {
        this.f3561d = this.f3560c != null ? this.f3560c.size() : 0;
        if (this.f3559b instanceof C1924b) {
            ((C1924b) this.f3559b).m5816c();
        }
        super.notifyDataSetChanged();
    }

    public C1923a m5845b() {
        return this.f3559b;
    }
}
