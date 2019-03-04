package com.slideme.sam.manager.controller.fragment.p056a;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.p026b.p027a.p034b.p035a.C0483k;
import com.p026b.p027a.p034b.p038c.C0494b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ApplicationListFragment */
public class C1723n extends C0483k {
    final Set<String> f2967a = Collections.synchronizedSet(new HashSet());
    final /* synthetic */ C1708i f2968b;

    protected C1723n(C1708i c1708i) {
        this.f2968b = c1708i;
    }

    public void mo931a(String str, View view, Bitmap bitmap) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) view;
            if ((this.f2967a.contains(str) ? null : 1) != null) {
                C0494b.m3007a(imageView, 500);
                this.f2967a.add(str);
            }
        }
    }
}
