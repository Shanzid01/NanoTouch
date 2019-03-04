package com.slideme.sam.manager.view.featured;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.p026b.p027a.p034b.p035a.C0483k;
import com.p026b.p027a.p034b.p038c.C0494b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: DynamicLayoutGridView */
class C1957b extends C0483k {
    final Set<String> f3610a;
    final /* synthetic */ DynamicLayoutGridView f3611b;

    private C1957b(DynamicLayoutGridView dynamicLayoutGridView) {
        this.f3611b = dynamicLayoutGridView;
        this.f3610a = Collections.synchronizedSet(new HashSet());
    }

    public void mo931a(String str, View view, Bitmap bitmap) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) view;
            if ((this.f3610a.contains(str) ? null : 1) != null) {
                C0494b.m3007a(imageView, 500);
                this.f3610a.add(str);
            }
        }
    }
}
