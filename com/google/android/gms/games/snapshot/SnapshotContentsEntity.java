package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.zzlz;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public final class SnapshotContentsEntity implements SafeParcelable, SnapshotContents {
    public static final SnapshotContentsEntityCreator CREATOR = new SnapshotContentsEntityCreator();
    private static final Object zzakB = new Object();
    private final int zzFG;
    private Contents zzTO;

    SnapshotContentsEntity(int i, Contents contents) {
        this.zzFG = i;
        this.zzTO = contents;
    }

    public SnapshotContentsEntity(Contents contents) {
        this(1, contents);
    }

    private boolean zza(int i, byte[] bArr, int i2, int i3, boolean z) {
        zzx.zza(!isClosed(), (Object) "Must provide a previously opened SnapshotContents");
        synchronized (zzakB) {
            OutputStream fileOutputStream = new FileOutputStream(this.zzTO.getParcelFileDescriptor().getFileDescriptor());
            OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                channel.position((long) i);
                bufferedOutputStream.write(bArr, i2, i3);
                if (z) {
                    channel.truncate((long) bArr.length);
                }
                bufferedOutputStream.flush();
            } catch (Throwable e) {
                GamesLog.zza("SnapshotContentsEntity", "Failed to write snapshot data", e);
                return false;
            }
        }
        return true;
    }

    public void close() {
        this.zzTO = null;
    }

    public int describeContents() {
        return 0;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        zzx.zza(!isClosed(), (Object) "Cannot mutate closed contents!");
        return this.zzTO.getParcelFileDescriptor();
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public boolean isClosed() {
        return this.zzTO == null;
    }

    public boolean modifyBytes(int i, byte[] bArr, int i2, int i3) {
        return zza(i, bArr, i2, bArr.length, false);
    }

    public byte[] readFully() {
        byte[] zza;
        boolean z = false;
        if (!isClosed()) {
            z = true;
        }
        zzx.zza(z, (Object) "Must provide a previously opened Snapshot");
        synchronized (zzakB) {
            InputStream fileInputStream = new FileInputStream(this.zzTO.getParcelFileDescriptor().getFileDescriptor());
            InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                fileInputStream.getChannel().position(0);
                zza = zzlz.zza(bufferedInputStream, false);
                fileInputStream.getChannel().position(0);
            } catch (Throwable e) {
                GamesLog.zzb("SnapshotContentsEntity", "Failed to read snapshot data", e);
                throw e;
            }
        }
        return zza;
    }

    public boolean writeBytes(byte[] bArr) {
        return zza(0, bArr, 0, bArr.length, true);
    }

    public void writeToParcel(Parcel parcel, int i) {
        SnapshotContentsEntityCreator.zza(this, parcel, i);
    }

    public Contents zzkq() {
        return this.zzTO;
    }
}
