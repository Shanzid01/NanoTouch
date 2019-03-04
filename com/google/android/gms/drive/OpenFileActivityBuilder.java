package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.zzr;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private DriveId zzSA;
    private String zzSy;
    private String[] zzSz;

    public IntentSender build(GoogleApiClient googleApiClient) {
        zzx.zza(googleApiClient.isConnected(), (Object) "Client must be connected");
        if (this.zzSz == null) {
            this.zzSz = new String[0];
        }
        try {
            return ((zzr) googleApiClient.zza(Drive.zzGR)).zzkF().zza(new OpenFileIntentSenderRequest(this.zzSy, this.zzSz, this.zzSA));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.zzSA = (DriveId) zzx.zzl(driveId);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String str) {
        this.zzSy = (String) zzx.zzl(str);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] strArr) {
        zzx.zzb(strArr != null, (Object) "mimeTypes may not be null");
        this.zzSz = strArr;
        return this;
    }
}
