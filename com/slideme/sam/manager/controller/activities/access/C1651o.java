package com.slideme.sam.manager.controller.activities.access;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.slideme.sam.manager.R;

/* compiled from: SimpleRegisterActivity */
class C1651o extends BaseAdapter {
    LayoutInflater f2776a;
    String[] f2777b;
    String[] f2778c;
    final /* synthetic */ SimpleRegisterActivity f2779d;

    private C1651o(SimpleRegisterActivity simpleRegisterActivity) {
        this.f2779d = simpleRegisterActivity;
        this.f2776a = (LayoutInflater) simpleRegisterActivity.getSystemService("layout_inflater");
        this.f2777b = simpleRegisterActivity.getResources().getStringArray(R.array.register_button_titles);
        this.f2778c = simpleRegisterActivity.getResources().getStringArray(R.array.register_button_descr);
    }

    public int getCount() {
        return 2;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.f2776a.inflate(R.layout.btn_register_choice, null);
        if (i == 0) {
            this.f2779d.f2756e = inflate;
        } else {
            this.f2779d.f2755a = inflate;
        }
        ((TextView) inflate.findViewById(16908308)).setText(this.f2777b[i]);
        ((TextView) inflate.findViewById(16908309)).setText(this.f2778c[i]);
        return inflate;
    }
}
