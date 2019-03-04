package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzps;
import com.google.android.gms.internal.zzps.zza;
import com.google.android.gms.internal.zzpw;
import com.google.android.gms.internal.zzpx;

public class Places {
    public static final Api<PlacesOptions> GEO_DATA_API = new Api(new zza(null, null), zzanT, new Scope[0]);
    public static final GeoDataApi GeoDataApi = new zzpr();
    public static final Api<PlacesOptions> PLACE_DETECTION_API = new Api(new zzpx.zza(null, null), zzanU, new Scope[0]);
    public static final PlaceDetectionApi PlaceDetectionApi = new zzpw();
    public static final zzc<zzps> zzanT = new zzc();
    public static final zzc<zzpx> zzanU = new zzc();

    private Places() {
    }
}
