package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzlw;

public final class EventEntity implements SafeParcelable, Event {
    public static final EventEntityCreator CREATOR = new EventEntityCreator();
    private final String mName;
    private final int zzFG;
    private final String zzZO;
    private final Uri zzacc;
    private final String zzacn;
    private final String zzadJ;
    private final long zzadK;
    private final String zzadL;
    private final boolean zzadM;
    private final PlayerEntity zzadf;

    EventEntity(int i, String str, String str2, String str3, Uri uri, String str4, Player player, long j, String str5, boolean z) {
        this.zzFG = i;
        this.zzadJ = str;
        this.mName = str2;
        this.zzZO = str3;
        this.zzacc = uri;
        this.zzacn = str4;
        this.zzadf = new PlayerEntity(player);
        this.zzadK = j;
        this.zzadL = str5;
        this.zzadM = z;
    }

    public EventEntity(Event event) {
        this.zzFG = 1;
        this.zzadJ = event.getEventId();
        this.mName = event.getName();
        this.zzZO = event.getDescription();
        this.zzacc = event.getIconImageUri();
        this.zzacn = event.getIconImageUrl();
        this.zzadf = (PlayerEntity) event.getPlayer().freeze();
        this.zzadK = event.getValue();
        this.zzadL = event.getFormattedValue();
        this.zzadM = event.isVisible();
    }

    static int zza(Event event) {
        return zzw.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    static boolean zza(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return zzw.equal(event2.getEventId(), event.getEventId()) && zzw.equal(event2.getName(), event.getName()) && zzw.equal(event2.getDescription(), event.getDescription()) && zzw.equal(event2.getIconImageUri(), event.getIconImageUri()) && zzw.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && zzw.equal(event2.getPlayer(), event.getPlayer()) && zzw.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && zzw.equal(event2.getFormattedValue(), event.getFormattedValue()) && zzw.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    static String zzb(Event event) {
        return zzw.zzk(event).zza("Id", event.getEventId()).zza("Name", event.getName()).zza("Description", event.getDescription()).zza("IconImageUri", event.getIconImageUri()).zza("IconImageUrl", event.getIconImageUrl()).zza("Player", event.getPlayer()).zza("Value", Long.valueOf(event.getValue())).zza("FormattedValue", event.getFormattedValue()).zza("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Event freeze() {
        return this;
    }

    public String getDescription() {
        return this.zzZO;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzlw.zzb(this.zzZO, charArrayBuffer);
    }

    public String getEventId() {
        return this.zzadJ;
    }

    public String getFormattedValue() {
        return this.zzadL;
    }

    public void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        zzlw.zzb(this.zzadL, charArrayBuffer);
    }

    public Uri getIconImageUri() {
        return this.zzacc;
    }

    public String getIconImageUrl() {
        return this.zzacn;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer charArrayBuffer) {
        zzlw.zzb(this.mName, charArrayBuffer);
    }

    public Player getPlayer() {
        return this.zzadf;
    }

    public long getValue() {
        return this.zzadK;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isVisible() {
        return this.zzadM;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        EventEntityCreator.zza(this, parcel, i);
    }
}
