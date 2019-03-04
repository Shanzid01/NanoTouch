package com.slideme.sam.manager.controller.fragment.p056a;

import com.slideme.sam.manager.model.data.Category;
import com.slideme.sam.manager.net.wrappers.Catalog;
import com.slideme.sam.manager.net.wrappers.Catalog.Sort;

/* compiled from: CategoryApplicationListFragment */
public class C1725p extends C1708i {
    protected void mo4257a(Catalog catalog) {
        catalog.m5663a(String.valueOf(((Category) getArguments().getParcelable("com.slideme.sam.manager.extra.CATEGORY")).categoryId));
        Sort sort = (Sort) getArguments().getParcelable("com.slideme.sam.manager.extra.SORT");
        if (sort != null) {
            catalog.m5658a(sort);
        }
    }
}
