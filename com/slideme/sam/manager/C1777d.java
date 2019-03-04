package com.slideme.sam.manager;

import com.slideme.sam.manager.model.data.cache.helper.BookmarksCache;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.BookmarksLoadAllResponse;

/* compiled from: SAM */
class C1777d extends C1600v {
    final /* synthetic */ SAM f3165a;

    C1777d(SAM sam) {
        this.f3165a = sam;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        BookmarksLoadAllResponse bookmarksLoadAllResponse = (BookmarksLoadAllResponse) baseNetworkResponse;
        BookmarksCache bookmarksCache = new BookmarksCache(this.f3165a);
        bookmarksCache.clear();
        bookmarksCache.addAll(bookmarksLoadAllResponse.bookmarks == null ? new String[0] : bookmarksLoadAllResponse.bookmarks);
        bookmarksCache.close();
    }
}
