package com.slideme.sam.manager.controller.fragment.p056a;

import com.slideme.sam.manager.model.data.cache.helper.BookmarksCache;
import com.slideme.sam.manager.net.wrappers.Catalog;

/* compiled from: BookmarksApplicationListFragment */
public class C1724o extends C1708i {
    protected void mo4257a(Catalog catalog) {
        BookmarksCache bookmarksCache = new BookmarksCache(getActivity());
        catalog.m5667a(bookmarksCache.getAll());
        bookmarksCache.close();
    }

    boolean mo4258a() {
        return this.g.m5681e() > 0;
    }
}
