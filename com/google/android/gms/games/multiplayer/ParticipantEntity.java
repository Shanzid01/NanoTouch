package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzlw;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
    private final int zzFG;
    private final int zzIM;
    private final String zzSJ;
    private final Uri zzacc;
    private final Uri zzacd;
    private final String zzacn;
    private final String zzaco;
    private final String zzadN;
    private final PlayerEntity zzadf;
    private final String zzaeO;
    private final boolean zzajD;
    private final ParticipantResult zzajE;
    private final int zzrX;

    final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        ParticipantEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzdf(parcel);
        }

        public ParticipantEntity zzdf(Parcel parcel) {
            Object obj = 1;
            if (GamesDowngradeableSafeParcel.zzd(zzh.zziX()) || zzh.zzbf(ParticipantEntity.class.getCanonicalName())) {
                return super.zzdf(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            Uri parse2 = readString4 == null ? null : Uri.parse(readString4);
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                obj = null;
            }
            return new ParticipantEntity(3, readString, readString2, parse, parse2, readInt, readString5, z, obj != null ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }
    }

    ParticipantEntity(int i, String str, String str2, Uri uri, Uri uri2, int i2, String str3, boolean z, PlayerEntity playerEntity, int i3, ParticipantResult participantResult, String str4, String str5) {
        this.zzFG = i;
        this.zzaeO = str;
        this.zzSJ = str2;
        this.zzacc = uri;
        this.zzacd = uri2;
        this.zzrX = i2;
        this.zzadN = str3;
        this.zzajD = z;
        this.zzadf = playerEntity;
        this.zzIM = i3;
        this.zzajE = participantResult;
        this.zzacn = str4;
        this.zzaco = str5;
    }

    public ParticipantEntity(Participant participant) {
        this.zzFG = 3;
        this.zzaeO = participant.getParticipantId();
        this.zzSJ = participant.getDisplayName();
        this.zzacc = participant.getIconImageUri();
        this.zzacd = participant.getHiResImageUri();
        this.zzrX = participant.getStatus();
        this.zzadN = participant.zznl();
        this.zzajD = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.zzadf = player == null ? null : new PlayerEntity(player);
        this.zzIM = participant.getCapabilities();
        this.zzajE = participant.getResult();
        this.zzacn = participant.getIconImageUrl();
        this.zzaco = participant.getHiResImageUrl();
    }

    static int zza(Participant participant) {
        return zzw.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zznl(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    static boolean zza(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return zzw.equal(participant2.getPlayer(), participant.getPlayer()) && zzw.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && zzw.equal(participant2.zznl(), participant.zznl()) && zzw.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && zzw.equal(participant2.getDisplayName(), participant.getDisplayName()) && zzw.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && zzw.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && zzw.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && zzw.equal(participant2.getResult(), participant.getResult()) && zzw.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    static String zzb(Participant participant) {
        return zzw.zzk(participant).zza("ParticipantId", participant.getParticipantId()).zza("Player", participant.getPlayer()).zza("Status", Integer.valueOf(participant.getStatus())).zza("ClientAddress", participant.zznl()).zza("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).zza("DisplayName", participant.getDisplayName()).zza("IconImage", participant.getIconImageUri()).zza("IconImageUrl", participant.getIconImageUrl()).zza("HiResImage", participant.getHiResImageUri()).zza("HiResImageUrl", participant.getHiResImageUrl()).zza("Capabilities", Integer.valueOf(participant.getCapabilities())).zza("Result", participant.getResult()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    public int getCapabilities() {
        return this.zzIM;
    }

    public String getDisplayName() {
        return this.zzadf == null ? this.zzSJ : this.zzadf.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.zzadf == null) {
            zzlw.zzb(this.zzSJ, charArrayBuffer);
        } else {
            this.zzadf.getDisplayName(charArrayBuffer);
        }
    }

    public Uri getHiResImageUri() {
        return this.zzadf == null ? this.zzacd : this.zzadf.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return this.zzadf == null ? this.zzaco : this.zzadf.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return this.zzadf == null ? this.zzacc : this.zzadf.getIconImageUri();
    }

    public String getIconImageUrl() {
        return this.zzadf == null ? this.zzacn : this.zzadf.getIconImageUrl();
    }

    public String getParticipantId() {
        return this.zzaeO;
    }

    public Player getPlayer() {
        return this.zzadf;
    }

    public ParticipantResult getResult() {
        return this.zzajE;
    }

    public int getStatus() {
        return this.zzrX;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConnectedToRoom() {
        return this.zzajD;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str = null;
        int i2 = 0;
        if (zziY()) {
            parcel.writeString(this.zzaeO);
            parcel.writeString(this.zzSJ);
            parcel.writeString(this.zzacc == null ? null : this.zzacc.toString());
            if (this.zzacd != null) {
                str = this.zzacd.toString();
            }
            parcel.writeString(str);
            parcel.writeInt(this.zzrX);
            parcel.writeString(this.zzadN);
            parcel.writeInt(this.zzajD ? 1 : 0);
            if (this.zzadf != null) {
                i2 = 1;
            }
            parcel.writeInt(i2);
            if (this.zzadf != null) {
                this.zzadf.writeToParcel(parcel, i);
                return;
            }
            return;
        }
        ParticipantEntityCreator.zza(this, parcel, i);
    }

    public String zznl() {
        return this.zzadN;
    }
}
