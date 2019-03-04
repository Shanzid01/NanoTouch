package com.slideme.sam.manager.view.p064a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChooserArrayAdapter */
public class C1937h extends BaseAdapter {
    PackageManager f3552a;
    ArrayList<CharSequence> f3553b;
    ArrayList<Drawable> f3554c;
    LayoutInflater f3555d;

    public C1937h(Context context, List<String> list) {
        this.f3552a = context.getPackageManager();
        this.f3555d = LayoutInflater.from(context);
        this.f3553b = new ArrayList(list.size());
        this.f3554c = new ArrayList(list.size());
        for (String str : list) {
            try {
                this.f3553b.add(this.f3552a.getApplicationLabel(this.f3552a.getApplicationInfo(str, 0)));
                this.f3554c.add(this.f3552a.getApplicationIcon(str));
            } catch (NameNotFoundException e) {
            }
        }
    }

    public int getCount() {
        return this.f3553b.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1938i c1938i;
        if (view == null) {
            view = this.f3555d.inflate(R.layout.listitem_share_app, viewGroup, false);
            c1938i = new C1938i();
            c1938i.f3556a = (TextView) view.findViewById(R.id.title);
            c1938i.f3557b = (ImageView) view.findViewById(R.id.icon);
            view.setTag(c1938i);
        } else {
            c1938i = (C1938i) view.getTag();
        }
        c1938i.f3556a.setText((CharSequence) this.f3553b.get(i));
        c1938i.f3557b.setImageDrawable((Drawable) this.f3554c.get(i));
        return view;
    }
}
