package com.slideme.sam.manager.view.p064a;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap.Config;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ak;
import android.support.v7.widget.bg;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.p026b.p027a.p034b.C0509f;
import com.p026b.p027a.p034b.C0510g;
import com.p026b.p027a.p034b.p035a.C0476d;
import com.p026b.p027a.p034b.p035a.C0477e;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.net.response.AdProxyItem;
import com.slideme.sam.manager.util.C1914e;
import com.slideme.sam.manager.util.p063a.C1910d;
import com.slideme.sam.manager.view.C1950a;
import java.util.ArrayList;

/* compiled from: AdsListAdapter */
public class C1930a extends ak<C1932c> {
    private static int f3529a = -1;
    private Drawable f3530b;
    private Drawable f3531c;
    private int f3532d = 1;
    private int f3533e;
    private ArrayList<AdProxyItem> f3534f = new ArrayList();
    private Activity f3535g;
    private String f3536h;

    public /* synthetic */ bg mo4328a(ViewGroup viewGroup, int i) {
        return m5837c(viewGroup, i);
    }

    public C1930a(Activity activity, int i, String str) {
        this.f3535g = activity;
        this.f3532d = i;
        this.f3536h = str;
        this.f3533e = C1910d.m5753a(this.f3535g).x;
        int[] iArr = new int[3];
        iArr[0] = R.attr.backgroundListItemEven;
        iArr[1] = R.attr.backgroundListItemOdd;
        TypedArray obtainStyledAttributes = this.f3535g.getTheme().obtainStyledAttributes(iArr);
        this.f3530b = obtainStyledAttributes.getDrawable(0).mutate();
        if (this.f3530b instanceof BitmapDrawable) {
            ((BitmapDrawable) this.f3530b).setTileModeXY(TileMode.REPEAT, TileMode.REPEAT);
        }
        this.f3531c = obtainStyledAttributes.getDrawable(1).mutate();
        if (this.f3531c instanceof BitmapDrawable) {
            ((BitmapDrawable) this.f3531c).setTileModeXY(TileMode.REPEAT, TileMode.REPEAT);
        }
        obtainStyledAttributes.recycle();
    }

    private void m5830a(ImageView imageView, String str, C0476d c0476d) {
        try {
            C0510g.m3081a().m3084a(str, imageView, new C0509f().m3079b().m3076a(Config.RGB_565).m3077a(C0477e.IN_SAMPLE_INT).m3074a().m3075a((int) R.drawable.ic_loading).m3080c(), c0476d);
        } catch (OutOfMemoryError e) {
            if (C1914e.f3493a) {
                e.printStackTrace();
            }
        }
    }

    public void m5836a(ArrayList<AdProxyItem> arrayList) {
        this.f3534f = arrayList;
        m1537c();
    }

    public int mo4327a() {
        return this.f3534f.size();
    }

    public void m5835a(C1932c c1932c, int i) {
        AdProxyItem adProxyItem = (AdProxyItem) this.f3534f.get(i);
        c1932c.a.setBackgroundDrawable(i % (this.f3532d * 2) < this.f3532d ? this.f3530b : this.f3531c);
        m5830a(c1932c.f3539i, adProxyItem.image, null);
        c1932c.f3540j.setText(C1950a.m5855a(adProxyItem.name));
        if (TextUtils.isEmpty(adProxyItem.description)) {
            c1932c.f3541k.setVisibility(8);
        } else {
            c1932c.f3541k.setVisibility(0);
            c1932c.f3541k.setText(C1950a.m5855a(adProxyItem.description));
        }
        c1932c.a.setOnClickListener(new C1931b(this, adProxyItem));
    }

    public C1932c m5837c(ViewGroup viewGroup, int i) {
        return new C1932c(LayoutInflater.from(this.f3535g).inflate(R.layout.listitem_offer, viewGroup, false));
    }
}
