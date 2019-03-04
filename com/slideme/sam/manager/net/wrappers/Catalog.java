package com.slideme.sam.manager.net.wrappers;

import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.loopj.android.http.RequestParams;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.model.data.Category;
import com.slideme.sam.manager.model.p054b.C1827a;
import com.slideme.sam.manager.net.C1599q;
import com.slideme.sam.manager.net.response.FeedsPageResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Catalog implements Parcelable {
    public static final Creator<Catalog> CREATOR = new C1894c();
    private String f3414A;
    private int f3415B;
    private int f3416C;
    private int[] f3417D;
    private String f3418E;
    private String f3419F;
    private String f3420G;
    private boolean f3421H;
    private int f3422I;
    private int f3423J;
    private int f3424K;
    private int f3425L;
    private boolean f3426M;
    private String f3427N;
    private int f3428O;
    private boolean f3429P;
    private String[] f3430Q;
    protected ArrayList<Category> f3431a;
    protected ArrayList<Application> f3432b;
    private C1896f f3433c;
    private C1711e f3434d;
    private C1599q f3435e;
    private C1895d f3436f;
    private Sort f3437g;
    private int f3438h;
    private int f3439i;
    private int f3440j;
    private String f3441k;
    private int f3442l;
    private final String f3443m;
    private boolean f3444n;
    private boolean f3445o;
    private boolean f3446p;
    private boolean f3447q;
    private boolean f3448r;
    private String f3449s;
    private int f3450t;
    private int f3451u;
    private String f3452v;
    private String f3453w;
    private int f3454x;
    private boolean f3455y;
    private boolean f3456z;

    public final class Sort implements Parcelable {
        public static final Creator<Sort> CREATOR = new C1897g();
        public static String[] f3410b = new String[]{"ASC", "DESC"};
        public static String[] f3411d = new String[]{"NAME", "RATING", "PRICE", "POPULARITY", "VENDOR", "CREATED", "UPDATED", "QUALITY", "RATING_NEWEST", "TRXS"};
        public String f3412a;
        public String f3413c;

        public Sort() {
            this.f3412a = null;
            this.f3413c = null;
        }

        public Sort(int i, int i2) {
            this.f3412a = null;
            this.f3413c = null;
            this.f3412a = f3410b[m5654b(i)];
            this.f3413c = f3411d[m5653a(i2)];
        }

        private int m5653a(int i) {
            if (i < 0) {
                return 0;
            }
            if (i > f3411d.length) {
                return f3411d.length;
            }
            return i;
        }

        private int m5654b(int i) {
            if (i < 0) {
                return 0;
            }
            if (i > f3410b.length) {
                return f3410b.length;
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Sort) {
                return ((Sort) obj).f3413c == this.f3413c && ((Sort) obj).f3412a == this.f3412a;
            } else {
                return false;
            }
        }

        public int describeContents() {
            return 0;
        }

        private Sort(Parcel parcel) {
            this.f3412a = null;
            this.f3413c = null;
            this.f3413c = parcel.readString();
            this.f3412a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f3413c);
            parcel.writeString(this.f3412a);
        }
    }

    public boolean m5668a() {
        return this.f3422I < this.f3438h || (this.f3425L != -1 && this.f3423J >= this.f3425L);
    }

    public void m5659a(int i) {
        this.f3425L = i;
    }

    public void m5660a(C1599q c1599q) {
        this.f3435e = c1599q;
    }

    public int m5669b() {
        return this.f3423J;
    }

    public Catalog(String str, int i) {
        this.f3433c = C1896f.Normal;
        this.f3437g = null;
        this.f3431a = new ArrayList();
        this.f3432b = new ArrayList();
        this.f3438h = 30;
        this.f3439i = 0;
        this.f3440j = -1;
        this.f3441k = null;
        this.f3444n = false;
        this.f3445o = false;
        this.f3446p = false;
        this.f3447q = false;
        this.f3448r = false;
        this.f3449s = "";
        this.f3450t = -1;
        this.f3451u = -1;
        this.f3454x = 0;
        this.f3455y = false;
        this.f3456z = false;
        this.f3415B = 0;
        this.f3416C = -1;
        this.f3417D = null;
        this.f3421H = false;
        this.f3422I = 0;
        this.f3423J = 0;
        this.f3424K = 0;
        this.f3425L = -1;
        this.f3426M = true;
        this.f3428O = 0;
        this.f3429P = true;
        this.f3430Q = null;
        this.f3443m = str;
        this.f3438h = i;
        this.f3414A = new StringBuilder(String.valueOf(Locale.getDefault().getLanguage())).append('_').append(Locale.getDefault().getCountry()).toString();
    }

    public Catalog(String str) {
        this(str, 10);
    }

    public void m5662a(C1896f c1896f) {
        this.f3437g = null;
        this.f3433c = c1896f;
    }

    public void m5664a(boolean z) {
        this.f3421H = z;
    }

    public int m5670b(int i) {
        int i2 = this.f3438h;
        this.f3438h = i;
        return i2;
    }

    public void m5663a(String str) {
        this.f3453w = str;
    }

    public void m5672b(boolean z) {
        this.f3445o = z;
    }

    public void m5676c(boolean z) {
        this.f3446p = z;
    }

    public void m5680d(boolean z) {
        this.f3448r = z;
    }

    public void m5665a(boolean z, String str) {
        this.f3447q = z;
        if (z) {
            this.f3449s = str;
        }
    }

    public void m5674c(int i) {
        this.f3440j = i;
    }

    public void m5673c() {
        this.f3454x = 0;
        this.f3422I = 0;
        this.f3424K = 0;
        this.f3423J = 0;
        this.f3431a.clear();
        this.f3432b.clear();
    }

    public void m5671b(String str) {
        this.f3441k = str;
    }

    public Sort m5658a(Sort sort) {
        Sort sort2 = this.f3437g;
        this.f3437g = sort;
        return sort2;
    }

    public void m5677d() {
        this.f3456z = true;
    }

    public void m5678d(int i) {
        this.f3450t = i;
    }

    public int m5681e() {
        if (this.f3430Q != null) {
            int length = this.f3430Q.length - (this.f3454x * this.f3438h);
            if (length > 0) {
                return length < this.f3438h ? length % this.f3438h : this.f3438h;
            } else {
                return 0;
            }
        } else if (this.f3424K >= this.f3438h) {
            return this.f3438h;
        } else {
            return 0;
        }
    }

    public void m5685f() {
        this.f3436f = new C1895d();
        this.f3436f.execute(new Void[0]);
    }

    public void m5689g() {
        this.f3422I = 0;
        RequestParams requestParams = new RequestParams();
        requestParams.put("v", 110);
        requestParams.put("json", 1);
        requestParams.put("locale", this.f3414A);
        requestParams.put("showFeatures", 1);
        requestParams.put("showLibraries", 1);
        requestParams.put("showConf", 1);
        requestParams.put("showScreenCompat", 1);
        requestParams.put("showPerm", 1);
        requestParams.put("api", VERSION.SDK_INT);
        requestParams.put("httpsImgTxt", 1);
        requestParams.put("page", this.f3430Q != null ? 0 : this.f3454x);
        requestParams.put("pageSize", this.f3438h);
        if (this.f3441k != null) {
            requestParams.put("q", this.f3441k);
        }
        if (this.f3439i > 0) {
            requestParams.put("addons", this.f3439i);
        }
        switch (this.f3440j) {
            case 0:
                requestParams.put("free", "y");
                break;
            case 1:
                requestParams.put("paid", 1);
                break;
        }
        if (this.f3443m != null) {
            requestParams.put("partner", this.f3443m);
        }
        if (this.f3430Q != null) {
            requestParams.put("bundle", m5657h(this.f3454x));
        }
        if (this.f3452v != null) {
            requestParams.put("category", this.f3452v);
        }
        if (this.f3456z) {
            requestParams.put("summary", "y");
        }
        if (this.f3415B != 0) {
            requestParams.put("filterGPlay", this.f3415B);
        }
        if (this.f3455y) {
            requestParams.put("featured", "y");
        }
        if (this.f3428O == 1) {
            requestParams.put("sLocker", 1);
        }
        if (!(this.f3416C == -1 || this.f3416C == 0)) {
            requestParams.put("ParentalLessOrEq", this.f3416C);
        }
        if (!(this.f3417D == null || (this.f3417D.length == 1 && this.f3417D[0] == 0))) {
            requestParams.put("allowedRatings", m5656b(this.f3417D));
        }
        if (this.f3446p) {
            requestParams.put("showAnalytics", 1);
        }
        if (this.f3444n) {
            requestParams.put("showMetaData", 1);
        }
        if (this.f3448r) {
            requestParams.put("privAppOffer", 1);
        }
        if (this.f3447q) {
            requestParams.put("showSimilar", 1);
            requestParams.put("bundle", this.f3449s);
        }
        if (this.f3450t != -1) {
            requestParams.put("filterAdverts", this.f3450t);
        }
        if (this.f3453w != null) {
            requestParams.put("tid53", this.f3453w);
        }
        if (this.f3451u != -1) {
            requestParams.put("filterOffers", this.f3451u);
        }
        if (this.f3418E != null) {
            requestParams.put("filtOptFor", this.f3418E);
        }
        if (this.f3419F != null) {
            requestParams.put("filtComb", this.f3419F);
        }
        if (this.f3420G != null) {
            requestParams.put("filtPerms", this.f3420G);
        }
        if (this.f3437g != null) {
            requestParams.put("sort", this.f3437g.f3413c);
            requestParams.put("order", this.f3437g.f3412a);
        }
        if (this.f3421H) {
            requestParams.put("showSamePub", 1);
        }
        FeedsPageResponse a = SAM.f2614g.m5591a(this.f3433c, requestParams);
        if (a != null) {
            if (this.f3456z) {
                this.f3431a = a.getCategories();
            } else {
                this.f3422I = a.getApplications().size();
                this.f3424K += this.f3422I;
                for (int size = a.getApplications().size() - 1; size >= 0; size--) {
                    Application application = (Application) a.getApplications().get(size);
                    C1827a.m5497a(application, SAM.f2615h);
                    if (!this.f3429P && !application.isCompatible) {
                        a.getApplications().remove(application);
                    } else if (this.f3434d == null || this.f3434d.mo4259a(application)) {
                        this.f3423J++;
                    }
                }
                this.f3432b.addAll(a.getApplications());
            }
            this.f3454x++;
        }
    }

    private String m5656b(int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int append : iArr) {
            stringBuilder.append(append).append(',');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private String m5657h(int i) {
        int i2 = 0;
        StringBuilder stringBuilder = null;
        if (this.f3430Q != null && this.f3430Q.length > 0) {
            int i3 = this.f3438h * i;
            int length = this.f3430Q.length - i3;
            length = length > 0 ? length < this.f3438h ? length % this.f3438h : this.f3438h : 0;
            if (length > 0) {
                stringBuilder = new StringBuilder((length * 36) + 8);
                while (i2 < length) {
                    stringBuilder.append(this.f3430Q[i2 + i3]).append(',');
                    i2++;
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
        if (stringBuilder == null) {
            return "";
        }
        return stringBuilder.toString();
    }

    public ArrayList<Category> m5692h() {
        return this.f3431a;
    }

    public ArrayList<Application> m5693i() {
        return this.f3432b;
    }

    public void m5661a(C1711e c1711e) {
        this.f3434d = c1711e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeValue(this.f3433c);
        parcel.writeInt(this.f3439i);
        parcel.writeInt(this.f3442l);
        parcel.writeList(this.f3432b);
        parcel.writeList(this.f3431a);
        parcel.writeString(this.f3452v);
        parcel.writeInt(this.f3440j);
        parcel.writeInt(this.f3451u);
        parcel.writeInt(this.f3430Q == null ? 0 : this.f3430Q.length);
        if (!(this.f3430Q == null || this.f3430Q.length == 0)) {
            parcel.writeArray(this.f3430Q);
        }
        if (this.f3455y) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.f3454x);
        parcel.writeInt(this.f3438h);
        parcel.writeString(this.f3443m);
        parcel.writeString(this.f3441k);
        if (this.f3446p) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f3445o) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f3444n) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f3447q) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f3449s);
        parcel.writeParcelable(this.f3437g, 0);
        if (this.f3456z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f3414A);
        parcel.writeInt(this.f3415B);
        parcel.writeInt(this.f3416C);
        parcel.writeString(this.f3418E);
        parcel.writeString(this.f3419F);
        parcel.writeString(this.f3420G);
        parcel.writeIntArray(this.f3417D);
        parcel.writeInt(this.f3422I);
        parcel.writeInt(this.f3423J);
        parcel.writeInt(this.f3424K);
        parcel.writeInt(this.f3425L);
        parcel.writeInt(this.f3450t);
        parcel.writeInt(this.f3428O);
        parcel.writeInt(this.f3429P ? 1 : 0);
        if (!this.f3448r) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.f3427N);
    }

    private Catalog(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f3433c = C1896f.Normal;
        this.f3437g = null;
        this.f3431a = new ArrayList();
        this.f3432b = new ArrayList();
        this.f3438h = 30;
        this.f3439i = 0;
        this.f3440j = -1;
        this.f3441k = null;
        this.f3444n = false;
        this.f3445o = false;
        this.f3446p = false;
        this.f3447q = false;
        this.f3448r = false;
        this.f3449s = "";
        this.f3450t = -1;
        this.f3451u = -1;
        this.f3454x = 0;
        this.f3455y = false;
        this.f3456z = false;
        this.f3415B = 0;
        this.f3416C = -1;
        this.f3417D = null;
        this.f3421H = false;
        this.f3422I = 0;
        this.f3423J = 0;
        this.f3424K = 0;
        this.f3425L = -1;
        this.f3426M = true;
        this.f3428O = 0;
        this.f3429P = true;
        this.f3430Q = null;
        this.f3433c = (C1896f) parcel.readValue(C1896f.class.getClassLoader());
        this.f3439i = parcel.readInt();
        this.f3442l = parcel.readInt();
        this.f3432b = parcel.readArrayList(Application.class.getClassLoader());
        this.f3431a = parcel.readArrayList(Category.class.getClassLoader());
        this.f3452v = parcel.readString();
        this.f3440j = parcel.readInt();
        this.f3451u = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.f3430Q = new String[readInt];
            parcel.readStringArray(this.f3430Q);
        }
        this.f3455y = parcel.readInt() == 1;
        this.f3454x = parcel.readInt();
        this.f3438h = parcel.readInt();
        this.f3443m = parcel.readString();
        this.f3441k = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3446p = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3445o = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3444n = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3447q = z;
        this.f3449s = parcel.readString();
        this.f3437g = (Sort) parcel.readParcelable(Sort.class.getClassLoader());
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3456z = z;
        this.f3414A = parcel.readString();
        this.f3415B = parcel.readInt();
        this.f3416C = parcel.readInt();
        this.f3418E = parcel.readString();
        this.f3419F = parcel.readString();
        this.f3420G = parcel.readString();
        this.f3417D = parcel.createIntArray();
        this.f3422I = parcel.readInt();
        this.f3423J = parcel.readInt();
        this.f3424K = parcel.readInt();
        this.f3425L = parcel.readInt();
        this.f3450t = parcel.readInt();
        this.f3428O = parcel.readInt();
        this.f3429P = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f3448r = z2;
        this.f3427N = parcel.readString();
    }

    public void m5675c(String str) {
        this.f3414A = str;
    }

    public void m5679d(String str) {
        this.f3418E = str;
    }

    public void m5682e(int i) {
        this.f3416C = i;
    }

    public void m5683e(String str) {
        this.f3419F = str;
    }

    public void m5686f(int i) {
        this.f3415B = i;
    }

    public void m5687f(String str) {
        this.f3420G = str;
    }

    public void m5666a(int[] iArr) {
        Arrays.sort(iArr);
        this.f3417D = iArr;
    }

    public int[] m5694j() {
        return this.f3417D;
    }

    public void m5690g(int i) {
        this.f3428O = i;
    }

    public void m5684e(boolean z) {
        this.f3429P = z;
    }

    public void m5667a(String[] strArr) {
        this.f3430Q = strArr;
    }

    public void m5691g(String str) {
        this.f3427N = str;
    }

    public boolean m5695k() {
        return this.f3429P;
    }

    public boolean m5696l() {
        return this.f3436f != null && this.f3436f.getStatus() == Status.RUNNING;
    }

    public void m5688f(boolean z) {
        if (this.f3436f != null) {
            this.f3436f.cancel(true);
            this.f3436f = null;
        }
    }
}
