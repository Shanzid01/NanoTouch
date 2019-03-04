package com.slideme.sam.manager.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.p043a.p044a.C0670c;

public class Category implements Parcelable {
    public static final Creator<Category> CREATOR = new C18391();
    @C0670c(a = "TID")
    public int categoryId;
    @C0670c(a = "Count")
    public int count;
    @C0670c(a = "Name")
    public String name;
    @C0670c(a = "PID")
    public int parentId;

    class C18391 implements Creator<Category> {
        C18391() {
        }

        public Category createFromParcel(Parcel parcel) {
            return new Category(parcel);
        }

        public Category[] newArray(int i) {
            return new Category[i];
        }
    }

    public Category(String str, int i, int i2, int i3) {
        this.name = null;
        this.count = 0;
        this.categoryId = 0;
        this.parentId = 0;
        this.name = str;
        this.count = i;
        this.categoryId = i2;
        this.parentId = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.count);
        parcel.writeInt(this.categoryId);
        parcel.writeInt(this.parentId);
    }

    private Category(Parcel parcel) {
        this.name = null;
        this.count = 0;
        this.categoryId = 0;
        this.parentId = 0;
        this.name = parcel.readString();
        this.count = parcel.readInt();
        this.categoryId = parcel.readInt();
        this.parentId = parcel.readInt();
    }

    public String toString() {
        return this.name;
    }
}
