package com.slideme.sam.manager.controller.p053a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.slideme.sam.manager.model.data.Review;
import com.slideme.sam.manager.model.data.Review.Thumbs;

/* compiled from: ReviewRateDialog */
class ac implements OnClickListener {
    private static /* synthetic */ int[] f2675b;
    final /* synthetic */ C1635z f2676a;

    ac(C1635z c1635z) {
        this.f2676a = c1635z;
    }

    static /* synthetic */ int[] m4852a() {
        int[] iArr = f2675b;
        if (iArr == null) {
            iArr = new int[Thumbs.values().length];
            try {
                iArr[Thumbs.THUMBS_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Thumbs.THUMBS_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Thumbs.THUMBS_SPAM.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Thumbs.THUMBS_UP.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            f2675b = iArr;
        }
        return iArr;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2676a.f2732a.userThumbs = Thumbs.values()[i + 1];
        if (this.f2676a.f2732a.userThumbs != this.f2676a.f2733b) {
            Review a;
            switch (ac.m4852a()[this.f2676a.f2732a.userThumbs.ordinal()]) {
                case 2:
                    a = this.f2676a.f2732a;
                    a.thumbScore++;
                    break;
                case 3:
                    a = this.f2676a.f2732a;
                    a.thumbScore--;
                    break;
            }
        }
        if (this.f2676a.getActivity() instanceof OnDismissListener) {
            ((OnDismissListener) this.f2676a.getActivity()).onDismiss(dialogInterface);
        }
    }
}
