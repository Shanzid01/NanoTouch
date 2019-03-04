package com.slideme.sam.manager.controller.fragment;

import android.content.Intent;
import android.net.Uri;
import com.p019a.p020a.C0367a;
import com.slideme.sam.manager.net.wrappers.C1751l;
import com.slideme.sam.manager.net.wrappers.C1892h;
import com.slideme.sam.manager.net.wrappers.C1900k;
import java.io.File;

/* compiled from: SAMUpdateTaskFragment */
class bd implements C1751l {
    final /* synthetic */ bc f3113a;

    bd(bc bcVar) {
        this.f3113a = bcVar;
    }

    public void mo4266a() {
        if (this.f3113a.f3112d != null) {
            this.f3113a.f3111c = new File(C1892h.m5700a(this.f3113a.f3112d), "SAM.apk");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(this.f3113a.f3111c), "application/vnd.android.package-archive");
            this.f3113a.startActivityForResult(intent, 100);
        }
    }

    public void mo4268a(C1900k c1900k) {
        if (this.f3113a.f3109a != null) {
            this.f3113a.f3109a.mo4235a();
        }
        C0367a.m2509e().f1149c.m2778a(new Throwable("Failed to Update SAM with Error: " + c1900k.toString()));
    }

    public void mo4269b() {
        if (this.f3113a.f3109a != null) {
            this.f3113a.f3109a.mo4235a();
        }
    }

    public void mo4267a(int i, int i2) {
        if (this.f3113a.f3109a != null) {
            this.f3113a.f3109a.mo4236a((int) Math.floor((double) ((((float) i) / ((float) i2)) * 100.0f)));
        }
    }
}
