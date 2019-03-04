package com.slideme.sam.manager.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.slideme.sam.manager.util.C1922m;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Changelog implements Parcelable {
    public static final Creator<Changelog> CREATOR = new C18401();
    private ArrayList<String[]> mChanges;

    class C18401 implements Creator<Changelog> {
        C18401() {
        }

        public Changelog createFromParcel(Parcel parcel) {
            return new Changelog(parcel);
        }

        public Changelog[] newArray(int i) {
            return new Changelog[i];
        }
    }

    Changelog(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                this.mChanges = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.mChanges.add(new String[]{String.valueOf(jSONObject.getLong("time")), jSONObject.getString("log")});
                }
            } catch (Throwable e) {
                C1922m.m5791a(e);
            }
        }
    }

    public int getCount() {
        if (this.mChanges == null) {
            return 0;
        }
        return this.mChanges.size();
    }

    public ArrayList<String[]> getChanges() {
        return this.mChanges;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.mChanges);
    }

    private Changelog(Parcel parcel) {
        this.mChanges = parcel.readArrayList(String[].class.getClassLoader());
    }
}
