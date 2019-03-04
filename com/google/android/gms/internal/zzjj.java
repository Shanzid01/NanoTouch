package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class zzjj implements AppIndexApi, zzjd {

    abstract class zzb<T extends Result> extends com.google.android.gms.common.api.zza.zza<T, zzjh> {
        public zzb(GoogleApiClient googleApiClient) {
            super(zzim.zzFC, googleApiClient);
        }

        protected abstract void zza(zzje com_google_android_gms_internal_zzje);

        protected final void zza(zzjh com_google_android_gms_internal_zzjh) {
            zza(com_google_android_gms_internal_zzjh.zzgY());
        }
    }

    abstract class zzc<T extends Result> extends zzb<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status status) {
            return zzb(status);
        }

        protected Status zzb(Status status) {
            return status;
        }
    }

    @Deprecated
    final class zza implements ActionResult {
        private zzjj zzGG;
        private PendingResult<Status> zzGH;
        private Action zzGI;

        zza(zzjj com_google_android_gms_internal_zzjj, PendingResult<Status> pendingResult, Action action) {
            this.zzGG = com_google_android_gms_internal_zzjj;
            this.zzGH = pendingResult;
            this.zzGI = action;
        }

        public PendingResult<Status> end(GoogleApiClient googleApiClient) {
            String packageName = googleApiClient.getContext().getPackageName();
            zzjb zza = zzji.zza(this.zzGI, System.currentTimeMillis(), packageName, 3);
            return this.zzGG.zza(googleApiClient, zza);
        }

        public PendingResult<Status> getPendingResult() {
            return this.zzGH;
        }
    }

    final class zzd extends zzjg<Status> {
        public zzd(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(Status status) {
            this.zzGC.zzd(status);
        }
    }

    public static Intent zza(String str, Uri uri) {
        zzb(str, uri);
        List pathSegments = uri.getPathSegments();
        String str2 = (String) pathSegments.get(0);
        Builder builder = new Builder();
        builder.scheme(str2);
        if (pathSegments.size() > 1) {
            builder.authority((String) pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); i++) {
                builder.appendPath((String) pathSegments.get(i));
            }
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return new Intent("android.intent.action.VIEW", builder.build());
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Action action, int i) {
        String packageName = googleApiClient.getContext().getPackageName();
        return zza(googleApiClient, zzji.zza(action, System.currentTimeMillis(), packageName, i));
    }

    private static void zzb(String str, Uri uri) {
        if ("android-app".equals(uri.getScheme())) {
            String host = uri.getHost();
            if (str == null || str.equals(host)) {
                List pathSegments = uri.getPathSegments();
                if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                    throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
                }
                return;
            }
            throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
        throw new IllegalArgumentException("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
    }

    public static void zze(List<AppIndexingLink> list) {
        if (list != null) {
            for (AppIndexingLink appIndexingLink : list) {
                zzb(null, appIndexingLink.appIndexingUrl);
            }
        }
    }

    public ActionResult action(GoogleApiClient googleApiClient, Action action) {
        return new zza(this, zza(googleApiClient, action, 0), action);
    }

    public PendingResult<Status> end(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 3);
    }

    public PendingResult<Status> start(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 0);
    }

    public PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Intent intent, String str, Uri uri, List<AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zze(list);
        return zza(googleApiClient, new zzjb(packageName, intent, str, uri, null, list));
    }

    public PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Uri uri, String str, Uri uri2, List<AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzb(packageName, uri);
        return view(googleApiClient, activity, zza(packageName, uri), str, uri2, (List) list);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Intent intent) {
        zzjb com_google_android_gms_internal_zzjb = new zzjb(zzjb.zza(googleApiClient.getContext().getPackageName(), intent), System.currentTimeMillis(), 3);
        return zza(googleApiClient, com_google_android_gms_internal_zzjb);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Uri uri) {
        return viewEnd(googleApiClient, activity, zza(googleApiClient.getContext().getPackageName(), uri));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final zzjb... com_google_android_gms_internal_zzjbArr) {
        final String packageName = googleApiClient.getContext().getPackageName();
        return googleApiClient.zza(new zzc<Status>(this, googleApiClient) {
            final /* synthetic */ zzjj zzGF;

            protected void zza(zzje com_google_android_gms_internal_zzje) {
                com_google_android_gms_internal_zzje.zza(new zzd(this), packageName, com_google_android_gms_internal_zzjbArr);
            }
        });
    }
}
