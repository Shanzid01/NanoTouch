package com.p026b.p027a.p034b.p035a;

import android.widget.ImageView;

/* compiled from: ViewScaleType */
public enum C0484l {
    FIT_INSIDE,
    CROP;

    public static C0484l fromImageView(ImageView imageView) {
        switch (C0485m.f1434a[imageView.getScaleType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return FIT_INSIDE;
            default:
                return CROP;
        }
    }
}
