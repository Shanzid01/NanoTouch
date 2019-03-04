package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzaj;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzlz;
import com.google.android.gms.internal.zzmi;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<CompletionEvent> CREATOR = new zzb();
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    final int zzFG;
    final String zzHg;
    final DriveId zzRX;
    final ParcelFileDescriptor zzSP;
    final ParcelFileDescriptor zzSQ;
    final MetadataBundle zzSR;
    final List<String> zzSS;
    final IBinder zzST;
    private boolean zzSU = false;
    private boolean zzSV = false;
    private boolean zzSW = false;
    final int zzrX;

    CompletionEvent(int i, DriveId driveId, String str, ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2, MetadataBundle metadataBundle, List<String> list, int i2, IBinder iBinder) {
        this.zzFG = i;
        this.zzRX = driveId;
        this.zzHg = str;
        this.zzSP = parcelFileDescriptor;
        this.zzSQ = parcelFileDescriptor2;
        this.zzSR = metadataBundle;
        this.zzSS = list;
        this.zzrX = i2;
        this.zzST = iBinder;
    }

    private void zzP(boolean z) {
        zzkA();
        this.zzSW = true;
        zzlz.zza(this.zzSP);
        zzlz.zza(this.zzSQ);
        if (this.zzSR.zzc(zzmi.zzVU)) {
            ((zza) this.zzSR.zza(zzmi.zzVU)).release();
        }
        if (this.zzST == null) {
            zzw.zzs("CompletionEvent", "No callback on " + (z ? "snooze" : "dismiss"));
            return;
        }
        try {
            zzaj.zza.zzaf(this.zzST).zzP(z);
        } catch (RemoteException e) {
            zzw.zzs("CompletionEvent", "RemoteException on " + (z ? "snooze" : "dismiss") + ": " + e);
        }
    }

    private void zzkA() {
        if (this.zzSW) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void dismiss() {
        zzP(false);
    }

    public String getAccountName() {
        zzkA();
        return this.zzHg;
    }

    public InputStream getBaseContentsInputStream() {
        zzkA();
        if (this.zzSP == null) {
            return null;
        }
        if (this.zzSU) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzSU = true;
        return new FileInputStream(this.zzSP.getFileDescriptor());
    }

    public DriveId getDriveId() {
        zzkA();
        return this.zzRX;
    }

    public InputStream getModifiedContentsInputStream() {
        zzkA();
        if (this.zzSQ == null) {
            return null;
        }
        if (this.zzSV) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzSV = true;
        return new FileInputStream(this.zzSQ.getFileDescriptor());
    }

    public MetadataChangeSet getModifiedMetadataChangeSet() {
        zzkA();
        return this.zzSR != null ? new MetadataChangeSet(this.zzSR) : null;
    }

    public int getStatus() {
        zzkA();
        return this.zzrX;
    }

    public List<String> getTrackingTags() {
        zzkA();
        return new ArrayList(this.zzSS);
    }

    public int getType() {
        return 2;
    }

    public void snooze() {
        zzP(true);
    }

    public String toString() {
        String str = this.zzSS == null ? "<null>" : "'" + TextUtils.join("','", this.zzSS) + "'";
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[]{this.zzRX, Integer.valueOf(this.zzrX), str});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
