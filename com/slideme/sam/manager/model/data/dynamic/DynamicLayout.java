package com.slideme.sam.manager.model.data.dynamic;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.p043a.C0673v;
import com.google.p043a.C0675w;
import com.google.p043a.C0744u;
import com.google.p043a.p044a.C0670c;
import com.slideme.sam.manager.net.response.DynamicLayoutChildrenTag;
import com.slideme.sam.manager.util.C1922m;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DynamicLayout implements Parcelable {
    public static final Creator<DynamicLayout> CREATOR = new C18461();
    @C0670c(a = "Applications")
    public DynamicLayoutChildrenTag applications;
    @C0670c(a = "Banners")
    public DynamicLayoutChildrenTag banners;
    private Context mContext;
    @C0670c(a = "Slide")
    public DynamicLayoutChildrenTag slides;
    @C0670c(a = "TemplateID")
    public Template template;
    @C0670c(a = "Title")
    public String title;

    class C18461 implements Creator<DynamicLayout> {
        C18461() {
        }

        public DynamicLayout createFromParcel(Parcel parcel) {
            return new DynamicLayout(parcel);
        }

        public DynamicLayout[] newArray(int i) {
            return new DynamicLayout[i];
        }
    }

    public enum Template {
        GRID
    }

    public class TemplateDeserializer implements C0673v<Template> {
        public Template deserialize(C0675w c0675w, Type type, C0744u c0744u) {
            return Template.values()[c0675w.mo1117e()];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.template.ordinal());
        parcel.writeString(this.title);
        if (this.applications == null || C1922m.m5794a(this.applications.getSorted())) {
            parcel.writeList(new ArrayList());
        } else {
            parcel.writeList(this.applications.getSorted());
        }
        if (this.banners == null || C1922m.m5794a(this.banners.getSorted())) {
            parcel.writeList(new ArrayList());
        } else {
            parcel.writeList(this.banners.getSorted());
        }
        if (this.slides == null || C1922m.m5794a(this.slides.getSorted())) {
            parcel.writeList(new ArrayList());
        } else {
            parcel.writeList(this.slides.getSorted());
        }
    }

    private DynamicLayout(Parcel parcel) {
        this.template = Template.values()[parcel.readInt()];
        this.title = parcel.readString();
        this.applications = new DynamicLayoutChildrenTag();
        this.banners = new DynamicLayoutChildrenTag();
        this.slides = new DynamicLayoutChildrenTag();
        this.applications.setSorted(parcel.readArrayList(DynamicLayoutChildrenTag.class.getClassLoader()));
        this.banners.setSorted(parcel.readArrayList(DynamicLayoutChildrenTag.class.getClassLoader()));
        this.slides.setSorted(parcel.readArrayList(DynamicLayoutChildrenTag.class.getClassLoader()));
    }
}
