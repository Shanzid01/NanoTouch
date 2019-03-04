package com.slideme.sam.manager.model.data.test;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.p043a.p044a.C0670c;
import java.util.ArrayList;

public class ScoreCardItem implements Parcelable {
    public static final Creator<ScoreCardItem> CREATOR = new C18541();
    public static final String TYPE_RADIO = "radio";
    public static final String TYPE_SLIDER = "slider";
    public Integer answer;
    public String description;
    @C0670c(a = "qid")
    public int id;
    @C0670c(a = "widget_options")
    public ArrayList<String> options;
    public boolean required;
    @C0670c(a = "question_text")
    public String title;
    @C0670c(a = "widget_type")
    public String type;

    class C18541 implements Creator<ScoreCardItem> {
        C18541() {
        }

        public ScoreCardItem createFromParcel(Parcel parcel) {
            return new ScoreCardItem(parcel);
        }

        public ScoreCardItem[] newArray(int i) {
            return new ScoreCardItem[i];
        }
    }

    protected ScoreCardItem(Parcel parcel) {
        boolean z = true;
        this.id = parcel.readInt();
        this.type = parcel.readString();
        this.description = parcel.readString();
        this.title = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            this.options = new ArrayList();
            parcel.readList(this.options, String.class.getClassLoader());
        } else {
            this.options = null;
        }
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.required = z;
        this.answer = parcel.readByte() == (byte) 0 ? null : Integer.valueOf(parcel.readInt());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeInt(this.id);
        parcel.writeString(this.type);
        parcel.writeString(this.description);
        parcel.writeString(this.title);
        if (this.options == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this.options);
        }
        if (this.required) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.answer == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeInt(this.answer.intValue());
    }
}
