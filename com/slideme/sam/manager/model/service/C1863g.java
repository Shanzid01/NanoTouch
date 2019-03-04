package com.slideme.sam.manager.model.service;

import com.slideme.sam.manager.controller.p055b.C1704f;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.net.wrappers.C1751l;
import com.slideme.sam.manager.net.wrappers.C1893b;
import com.slideme.sam.manager.net.wrappers.C1900k;

/* compiled from: ApplicationDownloadService */
class C1863g implements C1751l {
    Application f3322a;
    boolean f3323b;
    final /* synthetic */ C1862f f3324c;

    C1863g(C1862f c1862f, C1893b c1893b) {
        this.f3324c = c1862f;
        this.f3322a = c1893b.mo4318a();
        this.f3323b = c1893b.mo4319b();
    }

    public void mo4266a() {
        this.f3324c.f3321a.m5534a(this.f3322a, this.f3323b);
    }

    public void mo4269b() {
        this.f3324c.f3321a.m5531a(this.f3322a, this.f3322a.localFilePath);
    }

    public void mo4268a(C1900k c1900k) {
        this.f3324c.f3321a.m5533a(this.f3322a, this.f3322a.localFilePath, false);
    }

    public void mo4267a(int i, int i2) {
        if (this.f3324c.f3321a.f3302k) {
            this.f3324c.f3321a.f3300i.notify(Integer.valueOf(this.f3322a.nodeId).intValue(), C1704f.m5074a(this.f3324c.f3321a, this.f3322a, false, i, i2));
        }
    }
}
