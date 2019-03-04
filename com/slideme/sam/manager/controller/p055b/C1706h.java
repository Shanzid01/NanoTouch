package com.slideme.sam.manager.controller.p055b;

import android.content.Context;
import android.content.Intent;
import com.slideme.sam.manager.model.service.ApplicationUpdatesCheckService;

/* compiled from: ServiceHelper */
public abstract class C1706h {
    public static void m5082a(Context context, boolean z) {
        Intent intent = new Intent("com.slideme.sam.manager.ACTION_CHECK_UPDATES");
        intent.setClass(context, ApplicationUpdatesCheckService.class);
        intent.putExtra("com.slideme.sam.manager.EXTRA_FORCE", z);
        context.startService(intent);
    }
}
