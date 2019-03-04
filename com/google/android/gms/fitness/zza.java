package com.google.android.gms.fitness;

import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public final class zza {
    public static String zzbH(String str) {
        return str.equals(Scopes.FITNESS_ACTIVITY_READ) ? Scopes.FITNESS_ACTIVITY_READ_WRITE : str.equals(Scopes.FITNESS_LOCATION_READ) ? Scopes.FITNESS_LOCATION_READ_WRITE : str.equals(Scopes.FITNESS_BODY_READ) ? Scopes.FITNESS_BODY_READ_WRITE : str.equals("https://www.googleapis.com/auth/fitness.nutrition.read") ? "https://www.googleapis.com/auth/fitness.nutrition.write" : str;
    }

    public static List<String> zzj(List<String> list) {
        Collection hashSet = new HashSet(list.size());
        for (String str : list) {
            String zzbH = zzbH(str);
            if (zzbH.equals(str) || !list.contains(zzbH)) {
                hashSet.add(str);
            }
        }
        return new ArrayList(hashSet);
    }
}
