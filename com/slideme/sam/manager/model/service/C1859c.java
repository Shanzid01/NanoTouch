package com.slideme.sam.manager.model.service;

import com.slideme.sam.manager.controller.p055b.C1704f;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.net.wrappers.C1751l;
import com.slideme.sam.manager.net.wrappers.C1900k;
import com.slideme.sam.manager.net.wrappers.C1901n;
import com.slideme.sam.manager.net.wrappers.C1902o;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: ApplicationDownloadService */
class C1859c implements C1751l {
    final /* synthetic */ ApplicationDownloadService f3313a;
    private final /* synthetic */ Application f3314b;
    private final /* synthetic */ int f3315c;
    private final /* synthetic */ String f3316d;
    private final /* synthetic */ C1901n f3317e;

    C1859c(ApplicationDownloadService applicationDownloadService, Application application, int i, String str, C1901n c1901n) {
        this.f3313a = applicationDownloadService;
        this.f3314b = application;
        this.f3315c = i;
        this.f3316d = str;
        this.f3317e = c1901n;
    }

    public void mo4267a(int i, int i2) {
        C1902o c1902o = (C1902o) this.f3313a.f3296e.get(Integer.valueOf(this.f3314b.nodeId));
        if (c1902o != null) {
            c1902o.f3479a = i2;
            c1902o.f3480b = i;
            c1902o.f3481c = this.f3315c + 2;
            c1902o.f3482d = this.f3314b.obbFiles.size() + 1;
            if (this.f3313a.f3302k) {
                this.f3313a.f3300i.notify(Integer.valueOf(this.f3314b.nodeId).intValue(), C1704f.m5074a(this.f3313a, this.f3314b, false, c1902o.f3480b, c1902o.f3479a));
            }
        }
    }

    public void mo4266a() {
        C1922m.m5797b("AppDownloder", "onFinish " + this.f3316d + " obb downloader");
        C1902o c1902o = (C1902o) this.f3313a.f3296e.get(Integer.valueOf(this.f3314b.nodeId));
        if (c1902o == null) {
            return;
        }
        if (c1902o.f3481c == this.f3314b.obbFiles.size() + 1) {
            C1922m.m5797b("AppDownloder", "This finished both main + patch downloading for " + this.f3314b.nodeId);
            this.f3313a.m5546c(Integer.valueOf(this.f3314b.nodeId).intValue());
            this.f3313a.m5530a(this.f3314b);
            return;
        }
        C1922m.m5797b("AppDownloder", "This finished an obb download for " + this.f3314b.nodeId + " but we still have pending");
    }

    public void mo4268a(C1900k c1900k) {
        C1922m.m5797b("AppDownloder", "onError " + this.f3316d + " obb downloader");
        this.f3313a.m5533a(this.f3314b, this.f3317e.mo4318a(), false);
    }

    public void mo4269b() {
        C1922m.m5797b("AppDownloder", "onCancelled " + this.f3316d + " obb downloader");
        this.f3313a.m5531a(this.f3314b, this.f3317e.mo4318a());
    }
}
