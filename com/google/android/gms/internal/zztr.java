package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.zzld.zza;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zztr extends zzle implements ItemScope {
    public static final zzts CREATOR = new zzts();
    private static final HashMap<String, zza<?, ?>> zzauW = new HashMap();
    String mName;
    String zzFA;
    final int zzFG;
    String zzZO;
    double zzalQ;
    double zzalR;
    final Set<Integer> zzauX;
    zztr zzauY;
    List<String> zzauZ;
    String zzavA;
    zztr zzavB;
    zztr zzavC;
    zztr zzavD;
    List<zztr> zzavE;
    String zzavF;
    String zzavG;
    String zzavH;
    String zzavI;
    zztr zzavJ;
    String zzavK;
    String zzavL;
    String zzavM;
    zztr zzavN;
    String zzavO;
    String zzavP;
    String zzavQ;
    String zzavR;
    zztr zzava;
    String zzavb;
    String zzavc;
    String zzavd;
    List<zztr> zzave;
    int zzavf;
    List<zztr> zzavg;
    zztr zzavh;
    List<zztr> zzavi;
    String zzavj;
    String zzavk;
    zztr zzavl;
    String zzavm;
    String zzavn;
    List<zztr> zzavo;
    String zzavp;
    String zzavq;
    String zzavr;
    String zzavs;
    String zzavt;
    String zzavu;
    String zzavv;
    String zzavw;
    zztr zzavx;
    String zzavy;
    String zzavz;
    String zzpn;
    String zzxV;
    String zzxX;

    static {
        zzauW.put("about", zza.zza("about", 2, zztr.class));
        zzauW.put("additionalName", zza.zzm("additionalName", 3));
        zzauW.put("address", zza.zza("address", 4, zztr.class));
        zzauW.put("addressCountry", zza.zzl("addressCountry", 5));
        zzauW.put("addressLocality", zza.zzl("addressLocality", 6));
        zzauW.put("addressRegion", zza.zzl("addressRegion", 7));
        zzauW.put("associated_media", zza.zzb("associated_media", 8, zztr.class));
        zzauW.put("attendeeCount", zza.zzi("attendeeCount", 9));
        zzauW.put("attendees", zza.zzb("attendees", 10, zztr.class));
        zzauW.put("audio", zza.zza("audio", 11, zztr.class));
        zzauW.put("author", zza.zzb("author", 12, zztr.class));
        zzauW.put("bestRating", zza.zzl("bestRating", 13));
        zzauW.put("birthDate", zza.zzl("birthDate", 14));
        zzauW.put("byArtist", zza.zza("byArtist", 15, zztr.class));
        zzauW.put("caption", zza.zzl("caption", 16));
        zzauW.put("contentSize", zza.zzl("contentSize", 17));
        zzauW.put("contentUrl", zza.zzl("contentUrl", 18));
        zzauW.put("contributor", zza.zzb("contributor", 19, zztr.class));
        zzauW.put("dateCreated", zza.zzl("dateCreated", 20));
        zzauW.put("dateModified", zza.zzl("dateModified", 21));
        zzauW.put("datePublished", zza.zzl("datePublished", 22));
        zzauW.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, zza.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        zzauW.put("duration", zza.zzl("duration", 24));
        zzauW.put("embedUrl", zza.zzl("embedUrl", 25));
        zzauW.put("endDate", zza.zzl("endDate", 26));
        zzauW.put("familyName", zza.zzl("familyName", 27));
        zzauW.put("gender", zza.zzl("gender", 28));
        zzauW.put("geo", zza.zza("geo", 29, zztr.class));
        zzauW.put("givenName", zza.zzl("givenName", 30));
        zzauW.put("height", zza.zzl("height", 31));
        zzauW.put("id", zza.zzl("id", 32));
        zzauW.put("image", zza.zzl("image", 33));
        zzauW.put("inAlbum", zza.zza("inAlbum", 34, zztr.class));
        zzauW.put("latitude", zza.zzj("latitude", 36));
        zzauW.put("location", zza.zza("location", 37, zztr.class));
        zzauW.put("longitude", zza.zzj("longitude", 38));
        zzauW.put("name", zza.zzl("name", 39));
        zzauW.put("partOfTVSeries", zza.zza("partOfTVSeries", 40, zztr.class));
        zzauW.put("performers", zza.zzb("performers", 41, zztr.class));
        zzauW.put("playerType", zza.zzl("playerType", 42));
        zzauW.put("postOfficeBoxNumber", zza.zzl("postOfficeBoxNumber", 43));
        zzauW.put("postalCode", zza.zzl("postalCode", 44));
        zzauW.put("ratingValue", zza.zzl("ratingValue", 45));
        zzauW.put("reviewRating", zza.zza("reviewRating", 46, zztr.class));
        zzauW.put("startDate", zza.zzl("startDate", 47));
        zzauW.put("streetAddress", zza.zzl("streetAddress", 48));
        zzauW.put("text", zza.zzl("text", 49));
        zzauW.put("thumbnail", zza.zza("thumbnail", 50, zztr.class));
        zzauW.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, zza.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        zzauW.put("tickerSymbol", zza.zzl("tickerSymbol", 52));
        zzauW.put("type", zza.zzl("type", 53));
        zzauW.put("url", zza.zzl("url", 54));
        zzauW.put("width", zza.zzl("width", 55));
        zzauW.put("worstRating", zza.zzl("worstRating", 56));
    }

    public zztr() {
        this.zzFG = 1;
        this.zzauX = new HashSet();
    }

    zztr(Set<Integer> set, int i, zztr com_google_android_gms_internal_zztr, List<String> list, zztr com_google_android_gms_internal_zztr2, String str, String str2, String str3, List<zztr> list2, int i2, List<zztr> list3, zztr com_google_android_gms_internal_zztr3, List<zztr> list4, String str4, String str5, zztr com_google_android_gms_internal_zztr4, String str6, String str7, String str8, List<zztr> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, zztr com_google_android_gms_internal_zztr5, String str18, String str19, String str20, String str21, zztr com_google_android_gms_internal_zztr6, double d, zztr com_google_android_gms_internal_zztr7, double d2, String str22, zztr com_google_android_gms_internal_zztr8, List<zztr> list6, String str23, String str24, String str25, String str26, zztr com_google_android_gms_internal_zztr9, String str27, String str28, String str29, zztr com_google_android_gms_internal_zztr10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.zzauX = set;
        this.zzFG = i;
        this.zzauY = com_google_android_gms_internal_zztr;
        this.zzauZ = list;
        this.zzava = com_google_android_gms_internal_zztr2;
        this.zzavb = str;
        this.zzavc = str2;
        this.zzavd = str3;
        this.zzave = list2;
        this.zzavf = i2;
        this.zzavg = list3;
        this.zzavh = com_google_android_gms_internal_zztr3;
        this.zzavi = list4;
        this.zzavj = str4;
        this.zzavk = str5;
        this.zzavl = com_google_android_gms_internal_zztr4;
        this.zzavm = str6;
        this.zzavn = str7;
        this.zzpn = str8;
        this.zzavo = list5;
        this.zzavp = str9;
        this.zzavq = str10;
        this.zzavr = str11;
        this.zzZO = str12;
        this.zzavs = str13;
        this.zzavt = str14;
        this.zzavu = str15;
        this.zzavv = str16;
        this.zzavw = str17;
        this.zzavx = com_google_android_gms_internal_zztr5;
        this.zzavy = str18;
        this.zzavz = str19;
        this.zzFA = str20;
        this.zzavA = str21;
        this.zzavB = com_google_android_gms_internal_zztr6;
        this.zzalQ = d;
        this.zzavC = com_google_android_gms_internal_zztr7;
        this.zzalR = d2;
        this.mName = str22;
        this.zzavD = com_google_android_gms_internal_zztr8;
        this.zzavE = list6;
        this.zzavF = str23;
        this.zzavG = str24;
        this.zzavH = str25;
        this.zzavI = str26;
        this.zzavJ = com_google_android_gms_internal_zztr9;
        this.zzavK = str27;
        this.zzavL = str28;
        this.zzavM = str29;
        this.zzavN = com_google_android_gms_internal_zztr10;
        this.zzavO = str30;
        this.zzavP = str31;
        this.zzxV = str32;
        this.zzxX = str33;
        this.zzavQ = str34;
        this.zzavR = str35;
    }

    public zztr(Set<Integer> set, zztr com_google_android_gms_internal_zztr, List<String> list, zztr com_google_android_gms_internal_zztr2, String str, String str2, String str3, List<zztr> list2, int i, List<zztr> list3, zztr com_google_android_gms_internal_zztr3, List<zztr> list4, String str4, String str5, zztr com_google_android_gms_internal_zztr4, String str6, String str7, String str8, List<zztr> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, zztr com_google_android_gms_internal_zztr5, String str18, String str19, String str20, String str21, zztr com_google_android_gms_internal_zztr6, double d, zztr com_google_android_gms_internal_zztr7, double d2, String str22, zztr com_google_android_gms_internal_zztr8, List<zztr> list6, String str23, String str24, String str25, String str26, zztr com_google_android_gms_internal_zztr9, String str27, String str28, String str29, zztr com_google_android_gms_internal_zztr10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.zzauX = set;
        this.zzFG = 1;
        this.zzauY = com_google_android_gms_internal_zztr;
        this.zzauZ = list;
        this.zzava = com_google_android_gms_internal_zztr2;
        this.zzavb = str;
        this.zzavc = str2;
        this.zzavd = str3;
        this.zzave = list2;
        this.zzavf = i;
        this.zzavg = list3;
        this.zzavh = com_google_android_gms_internal_zztr3;
        this.zzavi = list4;
        this.zzavj = str4;
        this.zzavk = str5;
        this.zzavl = com_google_android_gms_internal_zztr4;
        this.zzavm = str6;
        this.zzavn = str7;
        this.zzpn = str8;
        this.zzavo = list5;
        this.zzavp = str9;
        this.zzavq = str10;
        this.zzavr = str11;
        this.zzZO = str12;
        this.zzavs = str13;
        this.zzavt = str14;
        this.zzavu = str15;
        this.zzavv = str16;
        this.zzavw = str17;
        this.zzavx = com_google_android_gms_internal_zztr5;
        this.zzavy = str18;
        this.zzavz = str19;
        this.zzFA = str20;
        this.zzavA = str21;
        this.zzavB = com_google_android_gms_internal_zztr6;
        this.zzalQ = d;
        this.zzavC = com_google_android_gms_internal_zztr7;
        this.zzalR = d2;
        this.mName = str22;
        this.zzavD = com_google_android_gms_internal_zztr8;
        this.zzavE = list6;
        this.zzavF = str23;
        this.zzavG = str24;
        this.zzavH = str25;
        this.zzavI = str26;
        this.zzavJ = com_google_android_gms_internal_zztr9;
        this.zzavK = str27;
        this.zzavL = str28;
        this.zzavM = str29;
        this.zzavN = com_google_android_gms_internal_zztr10;
        this.zzavO = str30;
        this.zzavP = str31;
        this.zzxV = str32;
        this.zzxX = str33;
        this.zzavQ = str34;
        this.zzavR = str35;
    }

    public int describeContents() {
        zzts com_google_android_gms_internal_zzts = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zztr)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zztr com_google_android_gms_internal_zztr = (zztr) obj;
        for (zza com_google_android_gms_internal_zzld_zza : zzauW.values()) {
            if (zza(com_google_android_gms_internal_zzld_zza)) {
                if (!com_google_android_gms_internal_zztr.zza(com_google_android_gms_internal_zzld_zza)) {
                    return false;
                }
                if (!zzb(com_google_android_gms_internal_zzld_zza).equals(com_google_android_gms_internal_zztr.zzb(com_google_android_gms_internal_zzld_zza))) {
                    return false;
                }
            } else if (com_google_android_gms_internal_zztr.zza(com_google_android_gms_internal_zzld_zza)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzsc();
    }

    public ItemScope getAbout() {
        return this.zzauY;
    }

    public List<String> getAdditionalName() {
        return this.zzauZ;
    }

    public ItemScope getAddress() {
        return this.zzava;
    }

    public String getAddressCountry() {
        return this.zzavb;
    }

    public String getAddressLocality() {
        return this.zzavc;
    }

    public String getAddressRegion() {
        return this.zzavd;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.zzave;
    }

    public int getAttendeeCount() {
        return this.zzavf;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.zzavg;
    }

    public ItemScope getAudio() {
        return this.zzavh;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.zzavi;
    }

    public String getBestRating() {
        return this.zzavj;
    }

    public String getBirthDate() {
        return this.zzavk;
    }

    public ItemScope getByArtist() {
        return this.zzavl;
    }

    public String getCaption() {
        return this.zzavm;
    }

    public String getContentSize() {
        return this.zzavn;
    }

    public String getContentUrl() {
        return this.zzpn;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.zzavo;
    }

    public String getDateCreated() {
        return this.zzavp;
    }

    public String getDateModified() {
        return this.zzavq;
    }

    public String getDatePublished() {
        return this.zzavr;
    }

    public String getDescription() {
        return this.zzZO;
    }

    public String getDuration() {
        return this.zzavs;
    }

    public String getEmbedUrl() {
        return this.zzavt;
    }

    public String getEndDate() {
        return this.zzavu;
    }

    public String getFamilyName() {
        return this.zzavv;
    }

    public String getGender() {
        return this.zzavw;
    }

    public ItemScope getGeo() {
        return this.zzavx;
    }

    public String getGivenName() {
        return this.zzavy;
    }

    public String getHeight() {
        return this.zzavz;
    }

    public String getId() {
        return this.zzFA;
    }

    public String getImage() {
        return this.zzavA;
    }

    public ItemScope getInAlbum() {
        return this.zzavB;
    }

    public double getLatitude() {
        return this.zzalQ;
    }

    public ItemScope getLocation() {
        return this.zzavC;
    }

    public double getLongitude() {
        return this.zzalR;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.zzavD;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.zzavE;
    }

    public String getPlayerType() {
        return this.zzavF;
    }

    public String getPostOfficeBoxNumber() {
        return this.zzavG;
    }

    public String getPostalCode() {
        return this.zzavH;
    }

    public String getRatingValue() {
        return this.zzavI;
    }

    public ItemScope getReviewRating() {
        return this.zzavJ;
    }

    public String getStartDate() {
        return this.zzavK;
    }

    public String getStreetAddress() {
        return this.zzavL;
    }

    public String getText() {
        return this.zzavM;
    }

    public ItemScope getThumbnail() {
        return this.zzavN;
    }

    public String getThumbnailUrl() {
        return this.zzavO;
    }

    public String getTickerSymbol() {
        return this.zzavP;
    }

    public String getType() {
        return this.zzxV;
    }

    public String getUrl() {
        return this.zzxX;
    }

    public String getWidth() {
        return this.zzavQ;
    }

    public String getWorstRating() {
        return this.zzavR;
    }

    public boolean hasAbout() {
        return this.zzauX.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName() {
        return this.zzauX.contains(Integer.valueOf(3));
    }

    public boolean hasAddress() {
        return this.zzauX.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry() {
        return this.zzauX.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality() {
        return this.zzauX.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion() {
        return this.zzauX.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media() {
        return this.zzauX.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount() {
        return this.zzauX.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees() {
        return this.zzauX.contains(Integer.valueOf(10));
    }

    public boolean hasAudio() {
        return this.zzauX.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor() {
        return this.zzauX.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating() {
        return this.zzauX.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate() {
        return this.zzauX.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist() {
        return this.zzauX.contains(Integer.valueOf(15));
    }

    public boolean hasCaption() {
        return this.zzauX.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize() {
        return this.zzauX.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl() {
        return this.zzauX.contains(Integer.valueOf(18));
    }

    public boolean hasContributor() {
        return this.zzauX.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated() {
        return this.zzauX.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified() {
        return this.zzauX.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished() {
        return this.zzauX.contains(Integer.valueOf(22));
    }

    public boolean hasDescription() {
        return this.zzauX.contains(Integer.valueOf(23));
    }

    public boolean hasDuration() {
        return this.zzauX.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl() {
        return this.zzauX.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate() {
        return this.zzauX.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName() {
        return this.zzauX.contains(Integer.valueOf(27));
    }

    public boolean hasGender() {
        return this.zzauX.contains(Integer.valueOf(28));
    }

    public boolean hasGeo() {
        return this.zzauX.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName() {
        return this.zzauX.contains(Integer.valueOf(30));
    }

    public boolean hasHeight() {
        return this.zzauX.contains(Integer.valueOf(31));
    }

    public boolean hasId() {
        return this.zzauX.contains(Integer.valueOf(32));
    }

    public boolean hasImage() {
        return this.zzauX.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum() {
        return this.zzauX.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude() {
        return this.zzauX.contains(Integer.valueOf(36));
    }

    public boolean hasLocation() {
        return this.zzauX.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude() {
        return this.zzauX.contains(Integer.valueOf(38));
    }

    public boolean hasName() {
        return this.zzauX.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries() {
        return this.zzauX.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers() {
        return this.zzauX.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType() {
        return this.zzauX.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.zzauX.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode() {
        return this.zzauX.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue() {
        return this.zzauX.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating() {
        return this.zzauX.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate() {
        return this.zzauX.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress() {
        return this.zzauX.contains(Integer.valueOf(48));
    }

    public boolean hasText() {
        return this.zzauX.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail() {
        return this.zzauX.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl() {
        return this.zzauX.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol() {
        return this.zzauX.contains(Integer.valueOf(52));
    }

    public boolean hasType() {
        return this.zzauX.contains(Integer.valueOf(53));
    }

    public boolean hasUrl() {
        return this.zzauX.contains(Integer.valueOf(54));
    }

    public boolean hasWidth() {
        return this.zzauX.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating() {
        return this.zzauX.contains(Integer.valueOf(56));
    }

    public int hashCode() {
        int i = 0;
        for (zza com_google_android_gms_internal_zzld_zza : zzauW.values()) {
            int hashCode;
            if (zza(com_google_android_gms_internal_zzld_zza)) {
                hashCode = zzb(com_google_android_gms_internal_zzld_zza).hashCode() + (i + com_google_android_gms_internal_zzld_zza.zzjG());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzts com_google_android_gms_internal_zzts = CREATOR;
        zzts.zza(this, parcel, i);
    }

    protected boolean zza(zza com_google_android_gms_internal_zzld_zza) {
        return this.zzauX.contains(Integer.valueOf(com_google_android_gms_internal_zzld_zza.zzjG()));
    }

    protected Object zzb(zza com_google_android_gms_internal_zzld_zza) {
        switch (com_google_android_gms_internal_zzld_zza.zzjG()) {
            case 2:
                return this.zzauY;
            case 3:
                return this.zzauZ;
            case 4:
                return this.zzava;
            case 5:
                return this.zzavb;
            case 6:
                return this.zzavc;
            case 7:
                return this.zzavd;
            case 8:
                return this.zzave;
            case 9:
                return Integer.valueOf(this.zzavf);
            case 10:
                return this.zzavg;
            case 11:
                return this.zzavh;
            case 12:
                return this.zzavi;
            case 13:
                return this.zzavj;
            case 14:
                return this.zzavk;
            case 15:
                return this.zzavl;
            case 16:
                return this.zzavm;
            case 17:
                return this.zzavn;
            case 18:
                return this.zzpn;
            case 19:
                return this.zzavo;
            case 20:
                return this.zzavp;
            case 21:
                return this.zzavq;
            case 22:
                return this.zzavr;
            case 23:
                return this.zzZO;
            case 24:
                return this.zzavs;
            case 25:
                return this.zzavt;
            case 26:
                return this.zzavu;
            case 27:
                return this.zzavv;
            case 28:
                return this.zzavw;
            case 29:
                return this.zzavx;
            case 30:
                return this.zzavy;
            case 31:
                return this.zzavz;
            case 32:
                return this.zzFA;
            case 33:
                return this.zzavA;
            case 34:
                return this.zzavB;
            case 36:
                return Double.valueOf(this.zzalQ);
            case 37:
                return this.zzavC;
            case 38:
                return Double.valueOf(this.zzalR);
            case 39:
                return this.mName;
            case 40:
                return this.zzavD;
            case 41:
                return this.zzavE;
            case 42:
                return this.zzavF;
            case 43:
                return this.zzavG;
            case 44:
                return this.zzavH;
            case 45:
                return this.zzavI;
            case 46:
                return this.zzavJ;
            case 47:
                return this.zzavK;
            case 48:
                return this.zzavL;
            case 49:
                return this.zzavM;
            case 50:
                return this.zzavN;
            case 51:
                return this.zzavO;
            case 52:
                return this.zzavP;
            case 53:
                return this.zzxV;
            case 54:
                return this.zzxX;
            case 55:
                return this.zzavQ;
            case 56:
                return this.zzavR;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + com_google_android_gms_internal_zzld_zza.zzjG());
        }
    }

    public /* synthetic */ Map zzjz() {
        return zzsb();
    }

    public HashMap<String, zza<?, ?>> zzsb() {
        return zzauW;
    }

    public zztr zzsc() {
        return this;
    }
}
