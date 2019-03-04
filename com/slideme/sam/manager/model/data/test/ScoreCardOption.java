package com.slideme.sam.manager.model.data.test;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ScoreCardOption implements Parcelable {
    public static final Creator<ScoreCardOption> CREATOR = new C18551();
    public int id;
    public String title;

    class C18551 implements Creator<ScoreCardOption> {
        C18551() {
        }

        public ScoreCardOption createFromParcel(Parcel parcel) {
            return new ScoreCardOption(parcel);
        }

        public ScoreCardOption[] newArray(int i) {
            return new ScoreCardOption[i];
        }
    }

    protected ScoreCardOption(Parcel parcel) {
        this.id = parcel.readInt();
        this.title = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
    }
}
