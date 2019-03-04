package com.slideme.sam.manager.controller.fragment;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.slideme.sam.manager.model.data.cache.helper.BookmarksCache;

/* compiled from: ApplicationDetailsFragment */
class C1753d implements OnCheckedChangeListener {
    final /* synthetic */ C1735a f3123a;

    C1753d(C1735a c1735a) {
        this.f3123a = c1735a;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        BookmarksCache bookmarksCache = new BookmarksCache(this.f3123a.getActivity());
        bookmarksCache.toggle(this.f3123a.f2989a.app.bundleId);
        bookmarksCache.close();
    }
}
