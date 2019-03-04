package com.slideme.sam.manager.model.service;

import com.slideme.sam.manager.util.C1920k;

/* compiled from: LaunchOrInstallService */
class C1865i implements Runnable {
    final /* synthetic */ LaunchOrInstallService f3327a;
    private final /* synthetic */ int f3328b;

    C1865i(LaunchOrInstallService launchOrInstallService, int i) {
        this.f3327a = launchOrInstallService;
        this.f3328b = i;
    }

    public void run() {
        C1920k.m5781a(this.f3327a, this.f3328b, 0).show();
    }
}
