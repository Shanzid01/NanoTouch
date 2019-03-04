package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.mopub.common.p050b.C1486i;
import java.math.BigDecimal;

/* compiled from: LocationService */
public class C1515w {
    public static Location m4156a(Context context, int i, C1516x c1516x) {
        if (c1516x == C1516x.DISABLED) {
            return null;
        }
        Location lastKnownLocation;
        Location lastKnownLocation2;
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        try {
            lastKnownLocation = locationManager.getLastKnownLocation("gps");
        } catch (SecurityException e) {
            C1486i.m4076a("Failed to retrieve GPS location: access appears to be disabled.");
            lastKnownLocation = null;
        } catch (IllegalArgumentException e2) {
            C1486i.m4076a("Failed to retrieve GPS location: device has no GPS provider.");
            lastKnownLocation = null;
        }
        try {
            lastKnownLocation2 = locationManager.getLastKnownLocation("network");
        } catch (SecurityException e3) {
            C1486i.m4076a("Failed to retrieve network location: access appears to be disabled.");
            lastKnownLocation2 = null;
        } catch (IllegalArgumentException e4) {
            C1486i.m4076a("Failed to retrieve network location: device has no network provider.");
            lastKnownLocation2 = null;
        }
        if (lastKnownLocation == null && lastKnownLocation2 == null) {
            return null;
        }
        if (lastKnownLocation == null || lastKnownLocation2 == null) {
            if (lastKnownLocation == null) {
                lastKnownLocation = lastKnownLocation2;
            }
        } else if (lastKnownLocation.getTime() <= lastKnownLocation2.getTime()) {
            lastKnownLocation = lastKnownLocation2;
        }
        if (c1516x == C1516x.TRUNCATED) {
            lastKnownLocation.setLatitude(BigDecimal.valueOf(lastKnownLocation.getLatitude()).setScale(i, 5).doubleValue());
            lastKnownLocation.setLongitude(BigDecimal.valueOf(lastKnownLocation.getLongitude()).setScale(i, 5).doubleValue());
        }
        return lastKnownLocation;
    }
}
