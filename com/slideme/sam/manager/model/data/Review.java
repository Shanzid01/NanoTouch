package com.slideme.sam.manager.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.p043a.C0673v;
import com.google.p043a.C0675w;
import com.google.p043a.C0744u;
import com.google.p043a.p044a.C0670c;
import java.lang.reflect.Type;
import java.util.Date;

public class Review implements Parcelable {
    public static final Creator<Review> CREATOR = new C18411();
    public String appUid;
    @C0670c(a = "version")
    public int appVersionCode;
    public String deviceName;
    public boolean hidden;
    @C0670c(a = "nid")
    public String id;
    @C0670c(a = "changed")
    public Date lastUpdated;
    public boolean promoted;
    public float rating;
    @C0670c(a = "body")
    public String text;
    @C0670c(a = "thumbcount")
    public int thumbCount;
    @C0670c(a = "thumbscore")
    public int thumbScore;
    public Thumbs userThumbs;
    public String username;
    public String video;

    class C18411 implements Creator<Review> {
        C18411() {
        }

        public Review createFromParcel(Parcel parcel) {
            return new Review(parcel);
        }

        public Review[] newArray(int i) {
            return new Review[i];
        }
    }

    public enum Thumbs {
        THUMBS_NONE,
        THUMBS_UP,
        THUMBS_DOWN,
        THUMBS_SPAM
    }

    public class ThumbsDeserializer implements C0673v<Thumbs> {
        public Thumbs deserialize(C0675w c0675w, Type type, C0744u c0744u) {
            return Thumbs.values()[c0675w.mo1117e()];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.id);
        parcel.writeString(this.appUid);
        parcel.writeString(this.username);
        parcel.writeString(this.text);
        parcel.writeFloat(this.rating);
        parcel.writeString(this.video);
        parcel.writeString(this.deviceName);
        parcel.writeInt(this.promoted ? 1 : 0);
        parcel.writeInt(this.appVersionCode);
        parcel.writeLong(this.lastUpdated.getTime());
        parcel.writeInt(this.userThumbs.ordinal());
        if (!this.hidden) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.thumbScore);
        parcel.writeInt(this.thumbCount);
    }

    private Review(Parcel parcel) {
        boolean z = true;
        this.id = "";
        this.appUid = "";
        this.username = "";
        this.text = "";
        this.rating = 0.0f;
        this.video = "";
        this.deviceName = "";
        this.promoted = false;
        this.appVersionCode = 0;
        this.lastUpdated = new Date(0);
        this.userThumbs = Thumbs.THUMBS_NONE;
        this.hidden = false;
        this.thumbScore = 0;
        this.thumbCount = 0;
        this.id = parcel.readString();
        this.appUid = parcel.readString();
        this.username = parcel.readString();
        this.text = parcel.readString();
        this.rating = parcel.readFloat();
        this.video = parcel.readString();
        this.deviceName = parcel.readString();
        this.promoted = parcel.readInt() == 1;
        this.appVersionCode = parcel.readInt();
        this.lastUpdated = new Date(parcel.readLong());
        this.userThumbs = Thumbs.values()[parcel.readInt()];
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.hidden = z;
        this.thumbScore = parcel.readInt();
        this.thumbCount = parcel.readInt();
    }

    public Review() {
        this.id = "";
        this.appUid = "";
        this.username = "";
        this.text = "";
        this.rating = 0.0f;
        this.video = "";
        this.deviceName = "";
        this.promoted = false;
        this.appVersionCode = 0;
        this.lastUpdated = new Date(0);
        this.userThumbs = Thumbs.THUMBS_NONE;
        this.hidden = false;
        this.thumbScore = 0;
        this.thumbCount = 0;
    }
}
