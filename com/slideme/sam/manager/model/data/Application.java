package com.slideme.sam.manager.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.p043a.p044a.C0670c;
import com.slideme.sam.manager.model.data.tags.AnalyticsTag;
import com.slideme.sam.manager.model.data.tags.AntiVirusTag;
import com.slideme.sam.manager.model.data.tags.CompatibilityTag;
import com.slideme.sam.manager.model.data.tags.ResourcesTag;
import com.slideme.sam.manager.model.data.tags.ScreenCompatTag;
import com.slideme.sam.manager.view.C1950a;
import java.util.ArrayList;

public class Application implements Parcelable {
    public static final Creator<Application> CREATOR = new C18351();
    public static final int DISPLAY_MASK_LARGE = 4;
    public static final int DISPLAY_MASK_NORMAL = 2;
    public static final int DISPLAY_MASK_SMALL = 1;
    public static final int DISPLAY_MASK_XLARGE = 8;
    public String adSlotId;
    @C0670c(a = "Advertisements")
    public int advertisement;
    @C0670c(a = "Analytics")
    public AnalyticsTag analytics;
    @C0670c(a = "AntiVirus")
    public AntiVirusTag antivirus;
    @C0670c(a = "UID")
    public String bundleId;
    @C0670c(a = "Category")
    public String category;
    @C0670c(a = "ChangeLog")
    public String changelogUrl;
    @C0670c(a = "Class")
    public String className;
    public String clickUrl;
    @C0670c(a = "Compatibility")
    public CompatibilityTag compatibility;
    public String compatibilityMessage;
    public long createdTime;
    @C0670c(a = "LongDescription")
    public String descriptionUrl;
    public boolean isCompatible;
    @C0670c(a = "SamOnly")
    private int isPrivate;
    @C0670c(a = "LastTouched")
    public long lastTouch;
    public boolean limitedStorageError;
    public String localFilePath;
    public long modifiedTime;
    @C0670c(a = "Name")
    public String name;
    @C0670c(a = "nid")
    public String nodeId;
    public ArrayList<String> obbFiles;
    @C0670c(a = "Organization")
    public String organization;
    @C0670c(a = "Package")
    public String packageName;
    @C0670c(a = "Parental")
    public int parentalRating;
    public double payout;
    @C0670c(a = "Price")
    public double price;
    @C0670c(a = "OldPrice")
    public double priceOld;
    @C0670c(a = "PrivacyPolicy")
    public String privacyUrl;
    @C0670c(a = "PromoIcon")
    public String promoIcon;
    @C0670c(a = "PromoIconSmall")
    public String promoIconSmall;
    @C0670c(a = "Quality")
    public int quality;
    @C0670c(a = "Rating")
    public double rating;
    public String referrer;
    @C0670c(a = "Resources")
    public ResourcesTag resources;
    @C0670c(a = "Size")
    public long size;
    @C0670c(a = "TermsAndConditions")
    public String termsUrl;
    public String token;
    @C0670c(a = "Vendor")
    public String vendor;
    @C0670c(a = "Version")
    public String version;
    public int versionCode;
    public String videoThumb;
    public String videoURL;

    class C18351 implements Creator<Application> {
        C18351() {
        }

        public Application createFromParcel(Parcel parcel) {
            return new Application(parcel);
        }

        public Application[] newArray(int i) {
            return new Application[i];
        }
    }

    public enum ImageSize {
        SMALL("small".intern()),
        NORMAL("normal".intern()),
        LARGE("large".intern()),
        MLARGE("mlarge".intern());
        
        public final String string;

        private ImageSize(String str) {
            this.string = str;
        }

        public String toString() {
            return this.string;
        }
    }

    public boolean isPrivate() {
        return this.isPrivate != 0;
    }

    public Application() {
        this.quality = 0;
        this.versionCode = Integer.MIN_VALUE;
        this.lastTouch = 0;
        this.descriptionUrl = "";
        this.changelogUrl = "";
        this.version = "";
        this.size = 0;
        this.name = null;
        this.bundleId = null;
        this.vendor = null;
        this.className = null;
        this.createdTime = 0;
        this.parentalRating = 0;
        this.rating = 0.0d;
        this.termsUrl = "";
        this.nodeId = null;
        this.modifiedTime = 0;
        this.category = null;
        this.privacyUrl = "";
        this.advertisement = 0;
        this.videoURL = null;
        this.videoThumb = null;
        this.price = 0.0d;
        this.priceOld = -1.0d;
        this.isCompatible = true;
        this.compatibilityMessage = "";
        this.token = null;
        this.localFilePath = null;
        this.limitedStorageError = false;
    }

    private Application(Parcel parcel) {
        int i;
        boolean z;
        boolean z2 = false;
        this.quality = 0;
        this.versionCode = Integer.MIN_VALUE;
        this.lastTouch = 0;
        this.descriptionUrl = "";
        this.changelogUrl = "";
        this.version = "";
        this.size = 0;
        this.name = null;
        this.bundleId = null;
        this.vendor = null;
        this.className = null;
        this.createdTime = 0;
        this.parentalRating = 0;
        this.rating = 0.0d;
        this.termsUrl = "";
        this.nodeId = null;
        this.modifiedTime = 0;
        this.category = null;
        this.privacyUrl = "";
        this.advertisement = 0;
        this.videoURL = null;
        this.videoThumb = null;
        this.price = 0.0d;
        this.priceOld = -1.0d;
        this.isCompatible = true;
        this.compatibilityMessage = "";
        this.token = null;
        this.localFilePath = null;
        this.limitedStorageError = false;
        this.versionCode = parcel.readInt();
        this.size = parcel.readLong();
        this.createdTime = parcel.readLong();
        this.modifiedTime = parcel.readLong();
        this.rating = parcel.readDouble();
        this.price = parcel.readDouble();
        this.priceOld = parcel.readDouble();
        this.organization = parcel.readString();
        this.promoIcon = parcel.readString();
        this.promoIconSmall = parcel.readString();
        this.nodeId = parcel.readString();
        this.packageName = parcel.readString();
        this.token = parcel.readString();
        this.category = parcel.readString();
        this.name = parcel.readString();
        this.bundleId = parcel.readString();
        this.vendor = parcel.readString();
        this.version = parcel.readString();
        this.className = parcel.readString();
        this.localFilePath = parcel.readString();
        this.videoURL = parcel.readString();
        this.videoThumb = parcel.readString();
        this.advertisement = parcel.readInt();
        this.parentalRating = parcel.readInt();
        this.quality = parcel.readInt();
        this.lastTouch = parcel.readLong();
        this.descriptionUrl = parcel.readString();
        this.termsUrl = parcel.readString();
        this.privacyUrl = parcel.readString();
        this.changelogUrl = parcel.readString();
        this.isPrivate = parcel.readInt();
        this.analytics = new AnalyticsTag();
        this.analytics.downloadCount = parcel.readInt();
        this.analytics.commentCount = parcel.readInt();
        this.analytics.installCount = parcel.readInt();
        this.analytics.reviewCount = parcel.readInt();
        this.compatibility = new CompatibilityTag();
        this.compatibility.optimizedFor = parcel.readString();
        this.compatibility.permissions = parcel.readString();
        this.compatibility.screenCompat = new ScreenCompatTag();
        this.compatibility.screenCompat.requiresSmallestWidth = parcel.readInt();
        this.compatibility.screenCompat.largestWidthLimit = parcel.readInt();
        this.compatibility.screenCompat.compatibleWidthLimit = parcel.readInt();
        this.compatibility.screenCompat.supportedScreens = parcel.readInt();
        int readInt = parcel.readInt();
        this.compatibility.locales = new ArrayList(readInt);
        for (i = 0; i < readInt; i++) {
            this.compatibility.locales.add(parcel.readString());
        }
        this.compatibility.features = parcel.readString();
        this.compatibility.libraries = parcel.readString();
        this.compatibility.permissions = parcel.readString();
        this.compatibility.configurations = parcel.readString();
        this.antivirus = new AntiVirusTag();
        this.antivirus.riskLevel = parcel.readInt();
        this.antivirus.clamScan = parcel.readInt();
        this.antivirus.marvinSafe = parcel.readInt();
        this.resources = new ResourcesTag();
        this.resources.icon = parcel.readString();
        readInt = parcel.readInt();
        this.resources.screenshots = new ArrayList(readInt);
        for (i = 0; i < readInt; i++) {
            this.resources.screenshots.add(parcel.readString());
        }
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isCompatible = z;
        this.compatibilityMessage = parcel.readString();
        if (parcel.readInt() == 1) {
            z2 = true;
        }
        this.limitedStorageError = z2;
        this.referrer = parcel.readString();
        this.clickUrl = parcel.readString();
        this.adSlotId = parcel.readString();
        this.payout = parcel.readDouble();
        if (parcel.readByte() == (byte) 1) {
            this.obbFiles = new ArrayList();
            parcel.readList(this.obbFiles, String.class.getClassLoader());
            return;
        }
        this.obbFiles = null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3;
        parcel.writeInt(this.versionCode);
        parcel.writeLong(this.size);
        parcel.writeLong(this.createdTime);
        parcel.writeLong(this.modifiedTime);
        parcel.writeDouble(this.rating);
        parcel.writeDouble(this.price);
        parcel.writeDouble(this.priceOld);
        parcel.writeString(this.organization);
        parcel.writeString(this.promoIcon);
        parcel.writeString(this.promoIconSmall);
        parcel.writeString(this.nodeId);
        parcel.writeString(this.packageName);
        parcel.writeString(this.token);
        parcel.writeString(this.category);
        parcel.writeString(this.name);
        parcel.writeString(this.bundleId);
        parcel.writeString(this.vendor);
        parcel.writeString(this.version);
        parcel.writeString(this.className);
        parcel.writeString(this.localFilePath);
        parcel.writeString(this.videoURL);
        parcel.writeString(this.videoThumb);
        parcel.writeInt(this.advertisement);
        parcel.writeInt(this.parentalRating);
        parcel.writeInt(this.quality);
        parcel.writeLong(this.lastTouch);
        parcel.writeString(this.descriptionUrl);
        parcel.writeString(this.termsUrl);
        parcel.writeString(this.privacyUrl);
        parcel.writeString(this.changelogUrl);
        parcel.writeInt(this.isPrivate);
        if (this.analytics == null) {
            this.analytics = new AnalyticsTag();
        }
        parcel.writeInt(this.analytics.downloadCount);
        parcel.writeInt(this.analytics.commentCount);
        parcel.writeInt(this.analytics.installCount);
        parcel.writeInt(this.analytics.reviewCount);
        if (this.compatibility == null) {
            this.compatibility = new CompatibilityTag();
        }
        parcel.writeString(this.compatibility.optimizedFor);
        parcel.writeString(this.compatibility.permissions);
        if (this.compatibility.screenCompat == null) {
            this.compatibility.screenCompat = new ScreenCompatTag();
        }
        parcel.writeInt(this.compatibility.screenCompat.requiresSmallestWidth);
        parcel.writeInt(this.compatibility.screenCompat.largestWidthLimit);
        parcel.writeInt(this.compatibility.screenCompat.compatibleWidthLimit);
        parcel.writeInt(this.compatibility.screenCompat.supportedScreens);
        if (this.compatibility.locales == null) {
            this.compatibility.locales = new ArrayList();
        }
        parcel.writeInt(this.compatibility.locales.size());
        for (i2 = 0; i2 < this.compatibility.locales.size(); i2++) {
            parcel.writeString((String) this.compatibility.locales.get(i2));
        }
        parcel.writeString(this.compatibility.features);
        parcel.writeString(this.compatibility.libraries);
        parcel.writeString(this.compatibility.permissions);
        parcel.writeString(this.compatibility.configurations);
        if (this.antivirus == null) {
            this.antivirus = new AntiVirusTag();
        }
        parcel.writeInt(this.antivirus.riskLevel);
        parcel.writeInt(this.antivirus.clamScan);
        parcel.writeInt(this.antivirus.marvinSafe);
        if (this.resources == null) {
            this.resources = new ResourcesTag();
        }
        parcel.writeString(this.resources.icon);
        if (this.resources.screenshots == null) {
            this.resources.screenshots = new ArrayList();
        }
        parcel.writeInt(this.resources.screenshots.size());
        for (i2 = 0; i2 < this.resources.screenshots.size(); i2++) {
            parcel.writeString((String) this.resources.screenshots.get(i2));
        }
        if (this.isCompatible) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.compatibilityMessage);
        if (this.limitedStorageError) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.referrer);
        parcel.writeString(this.clickUrl);
        parcel.writeString(this.adSlotId);
        parcel.writeDouble(this.payout);
        if (this.obbFiles == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeList(this.obbFiles);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        if (TextUtils.isEmpty(this.name)) {
            return "";
        }
        return C1950a.m5855a(this.name.trim()).toString();
    }

    public String getCategory() {
        if (TextUtils.isEmpty(this.category)) {
            return "";
        }
        return C1950a.m5855a(this.category.trim()).toString();
    }

    public String getOrganization() {
        if (TextUtils.isEmpty(this.organization)) {
            return C1950a.m5855a(this.vendor.trim()).toString();
        }
        return C1950a.m5855a(this.organization.trim()).toString();
    }
}
