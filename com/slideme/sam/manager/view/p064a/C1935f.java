package com.slideme.sam.manager.view.p064a;

import com.slideme.sam.manager.model.data.Category;
import java.util.Comparator;

/* compiled from: CategoryExpandableListAdapter */
class C1935f implements Comparator<Category> {
    final /* synthetic */ C1934e f3549a;

    C1935f(C1934e c1934e) {
        this.f3549a = c1934e;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5841a((Category) obj, (Category) obj2);
    }

    public int m5841a(Category category, Category category2) {
        return category2.count - category.count;
    }
}
