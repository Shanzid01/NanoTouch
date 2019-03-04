package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.internal.zzom;
import java.util.List;

public abstract class FitnessSensorService extends Service {
    public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
    private zza zzabV;

    class zza extends com.google.android.gms.internal.zzoo.zza {
        private final FitnessSensorService zzabW;

        private zza(FitnessSensorService fitnessSensorService) {
            this.zzabW = fitnessSensorService;
        }

        public void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zznv com_google_android_gms_internal_zznv) {
            this.zzabW.zzmv();
            if (this.zzabW.onRegister(fitnessSensorServiceRequest)) {
                com_google_android_gms_internal_zznv.zzi(Status.zzNo);
            } else {
                com_google_android_gms_internal_zznv.zzi(new Status(13));
            }
        }

        public void zza(zzok com_google_android_gms_internal_zzok, zznh com_google_android_gms_internal_zznh) {
            this.zzabW.zzmv();
            com_google_android_gms_internal_zznh.zza(new DataSourcesResult(this.zzabW.onFindDataSources(com_google_android_gms_internal_zzok.getDataTypes()), Status.zzNo));
        }

        public void zza(zzom com_google_android_gms_internal_zzom, zznv com_google_android_gms_internal_zznv) {
            this.zzabW.zzmv();
            if (this.zzabW.onUnregister(com_google_android_gms_internal_zzom.getDataSource())) {
                com_google_android_gms_internal_zznv.zzi(Status.zzNo);
            } else {
                com_google_android_gms_internal_zznv.zzi(new Status(13));
            }
        }
    }

    public final IBinder onBind(Intent intent) {
        if (!SERVICE_INTERFACE.equals(intent.getAction())) {
            return null;
        }
        if (Log.isLoggable("FitnessSensorService", 3)) {
            Log.d("FitnessSensorService", "Intent " + intent + " received by " + getClass().getName());
        }
        return this.zzabV.asBinder();
    }

    public void onCreate() {
        super.onCreate();
        this.zzabV = new zza();
    }

    public abstract List<DataSource> onFindDataSources(List<DataType> list);

    public abstract boolean onRegister(FitnessSensorServiceRequest fitnessSensorServiceRequest);

    public abstract boolean onUnregister(DataSource dataSource);

    protected void zzmv() {
        int callingUid = Binder.getCallingUid();
        String str = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE;
        if (zzme.zzkj()) {
            ((AppOpsManager) getSystemService("appops")).checkPackage(callingUid, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
            return;
        }
        String[] packagesForUid = getPackageManager().getPackagesForUid(callingUid);
        if (packagesForUid != null) {
            int length = packagesForUid.length;
            int i = 0;
            while (i < length) {
                if (!packagesForUid[i].equals(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE)) {
                    i++;
                } else {
                    return;
                }
            }
        }
        throw new SecurityException("Unauthorized caller");
    }
}
