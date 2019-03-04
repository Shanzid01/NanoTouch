package com.slideme.sam.manager.model.service;

import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.net.wrappers.C1856m;
import com.slideme.sam.manager.net.wrappers.C1892h;
import com.slideme.sam.manager.util.C1920k;

/* compiled from: ApplicationDownloadService */
class C1857a implements C1856m {
    final /* synthetic */ ApplicationDownloadService f3310a;
    private final /* synthetic */ Application f3311b;

    C1857a(ApplicationDownloadService applicationDownloadService, Application application) {
        this.f3310a = applicationDownloadService;
        this.f3311b = application;
    }

    public void mo4306a(C1892h c1892h) {
        c1892h.m5706a(null);
        this.f3310a.m5533a(this.f3311b, this.f3311b.localFilePath, true);
        C1920k.m5781a(this.f3310a.getApplicationContext(), (int) R.string.download_failed_no_space, 1).show();
    }
}
