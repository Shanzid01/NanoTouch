package com.slideme.sam.manager.view.touchme;

import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.model.p054b.C1827a;
import com.slideme.sam.manager.model.p054b.C1828b;

/* compiled from: DownloadButton */
class C1974g implements OnClickListener {
    private static /* synthetic */ int[] f3827b;
    final /* synthetic */ DownloadButton f3828a;

    C1974g(DownloadButton downloadButton) {
        this.f3828a = downloadButton;
    }

    static /* synthetic */ int[] m6110a() {
        int[] iArr = f3827b;
        if (iArr == null) {
            iArr = new int[C1828b.values().length];
            try {
                iArr[C1828b.NEEDS_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C1828b.NOT_INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1828b.UP_TO_DATE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            f3827b = iArr;
        }
        return iArr;
    }

    public void onClick(View view) {
        if (AuthData.m4808d(this.f3828a.getContext().getApplicationContext())) {
            C1698a.m5064b(this.f3828a.getContext());
        } else if (this.f3828a.f3663a != null) {
            switch (C1974g.m6110a()[this.f3828a.f3663a.getInstallState(this.f3828a.getContext()).ordinal()]) {
                case 1:
                    C1827a.m5494a(this.f3828a.getContext(), this.f3828a.f3663a.app);
                    return;
                default:
                    this.f3828a.m5931b();
                    return;
            }
        }
    }
}
