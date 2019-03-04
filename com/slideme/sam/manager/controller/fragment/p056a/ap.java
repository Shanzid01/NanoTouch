package com.slideme.sam.manager.controller.fragment.p056a;

import android.os.Bundle;
import com.slideme.sam.manager.net.wrappers.C1896f;
import com.slideme.sam.manager.net.wrappers.Catalog;
import com.slideme.sam.manager.view.p064a.C1940j;
import com.slideme.sam.manager.view.p064a.p065a.C1923a;
import com.slideme.sam.manager.view.p064a.p065a.C1927e;

/* compiled from: VideoPreviewedApplicationListFragment */
public class ap extends C1708i {
    protected void mo4257a(Catalog catalog) {
        catalog.m5662a(C1896f.Video);
    }

    void mo4261a(Bundle bundle) {
        C1923a c1927e = new C1927e(getActivity());
        c1927e.mo4325a(this.e);
        if (bundle != null) {
            c1927e.m5815b(bundle.getInt("state_max_animated"));
        }
        this.d = new C1940j(c1927e, new C1723n(this));
    }
}
