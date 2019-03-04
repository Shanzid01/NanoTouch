package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@zzgi
public class zzaz {
    public static final zzaz zzoZ = new zzaz();

    protected zzaz() {
    }

    public static zzaz zzbA() {
        return zzoZ;
    }

    public zzax zza(Context context, zzbo com_google_android_gms_internal_zzbo) {
        Date birthday = com_google_android_gms_internal_zzbo.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = com_google_android_gms_internal_zzbo.getContentUrl();
        int gender = com_google_android_gms_internal_zzbo.getGender();
        Collection keywords = com_google_android_gms_internal_zzbo.getKeywords();
        List unmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean isTestDevice = com_google_android_gms_internal_zzbo.isTestDevice(context);
        int zzbL = com_google_android_gms_internal_zzbo.zzbL();
        Location location = com_google_android_gms_internal_zzbo.getLocation();
        Bundle networkExtrasBundle = com_google_android_gms_internal_zzbo.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = com_google_android_gms_internal_zzbo.getManualImpressionsEnabled();
        String publisherProvidedId = com_google_android_gms_internal_zzbo.getPublisherProvidedId();
        SearchAdRequest zzbI = com_google_android_gms_internal_zzbo.zzbI();
        return new zzax(5, time, networkExtrasBundle, gender, unmodifiableList, isTestDevice, zzbL, manualImpressionsEnabled, publisherProvidedId, zzbI != null ? new zzbs(zzbI) : null, location, contentUrl, com_google_android_gms_internal_zzbo.zzbK(), com_google_android_gms_internal_zzbo.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(com_google_android_gms_internal_zzbo.zzbM())), com_google_android_gms_internal_zzbo.zzbH());
    }
}
