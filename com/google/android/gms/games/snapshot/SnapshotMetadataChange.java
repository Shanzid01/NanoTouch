package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.zza;

public abstract class SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    public final class Builder {
        private String zzZO;
        private Long zzakE;
        private Long zzakF;
        private zza zzakG;
        private Uri zzakH;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.zzZO, this.zzakE, this.zzakG, this.zzakH, this.zzakF);
        }

        public Builder fromMetadata(SnapshotMetadata snapshotMetadata) {
            this.zzZO = snapshotMetadata.getDescription();
            this.zzakE = Long.valueOf(snapshotMetadata.getPlayedTime());
            this.zzakF = Long.valueOf(snapshotMetadata.getProgressValue());
            if (this.zzakE.longValue() == -1) {
                this.zzakE = null;
            }
            this.zzakH = snapshotMetadata.getCoverImageUri();
            if (this.zzakH != null) {
                this.zzakG = null;
            }
            return this;
        }

        public Builder setCoverImage(Bitmap bitmap) {
            this.zzakG = new zza(bitmap);
            this.zzakH = null;
            return this;
        }

        public Builder setDescription(String str) {
            this.zzZO = str;
            return this;
        }

        public Builder setPlayedTimeMillis(long j) {
            this.zzakE = Long.valueOf(j);
            return this;
        }

        public Builder setProgressValue(long j) {
            this.zzakF = Long.valueOf(j);
            return this;
        }
    }

    protected SnapshotMetadataChange() {
    }

    public abstract Bitmap getCoverImage();

    public abstract String getDescription();

    public abstract Long getPlayedTimeMillis();

    public abstract Long getProgressValue();

    public abstract zza zzpc();
}
