package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date f1942a;
    private final Gender f1943b;
    private final Set<String> f1944c;
    private final boolean f1945d;
    private final Location f1946e;

    public MediationAdRequest(Date date, Gender gender, Set<String> set, boolean z, Location location) {
        this.f1942a = date;
        this.f1943b = gender;
        this.f1944c = set;
        this.f1945d = z;
        this.f1946e = location;
    }
}
