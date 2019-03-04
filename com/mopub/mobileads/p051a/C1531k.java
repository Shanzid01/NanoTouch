package com.mopub.mobileads.p051a;

import android.content.Context;
import com.mopub.mobileads.AdConfiguration;
import com.mopub.mobileads.MraidView;
import com.mopub.mobileads.MraidView.ExpansionStyle;
import com.mopub.mobileads.MraidView.NativeCloseButtonStyle;
import com.mopub.mobileads.MraidView.PlacementType;

/* compiled from: MraidViewFactory */
public class C1531k {
    protected static C1531k f2399a = new C1531k();

    public static MraidView m4494a(Context context, AdConfiguration adConfiguration, ExpansionStyle expansionStyle, NativeCloseButtonStyle nativeCloseButtonStyle, PlacementType placementType) {
        return f2399a.m4495b(context, adConfiguration, expansionStyle, nativeCloseButtonStyle, placementType);
    }

    protected MraidView m4495b(Context context, AdConfiguration adConfiguration, ExpansionStyle expansionStyle, NativeCloseButtonStyle nativeCloseButtonStyle, PlacementType placementType) {
        return new MraidView(context, adConfiguration, expansionStyle, nativeCloseButtonStyle, placementType);
    }
}
