package com.google.android.gms.appindexing;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzjj;

public final class AppIndex {
    public static final Api<NoOptions> API = zzim.zzFE;
    public static final Api<NoOptions> APP_INDEX_API = zzim.zzFE;
    public static final AppIndexApi AppIndexApi = new zzjj();

    private AppIndex() {
    }
}
