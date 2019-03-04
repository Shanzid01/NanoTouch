package com.slideme.sam.manager.controller.fragment.p056a;

import com.slideme.sam.manager.net.wrappers.Catalog;
import com.slideme.sam.manager.net.wrappers.Catalog.Sort;

/* compiled from: FilterableApplicationListFragment */
public class C1710s extends C1708i {
    private static /* synthetic */ int[] f2924n;
    private static /* synthetic */ int[] f2925o;
    private static /* synthetic */ int[] f2926p;
    private static /* synthetic */ int[] f2927q;
    private static /* synthetic */ int[] f2928r;
    private static /* synthetic */ int[] f2929s;
    public C1732x f2930a = C1732x.RELEVANCE;
    public C1730v f2931b = C1730v.ALL;
    public C1731w f2932i = C1731w.ALL;
    public C1728t f2933j = C1728t.ALL;
    public C1729u f2934k = C1729u.ANY;
    public C1733y f2935l = C1733y.ANY;
    public String f2936m;

    static /* synthetic */ int[] m5115g() {
        int[] iArr = f2924n;
        if (iArr == null) {
            iArr = new int[C1732x.values().length];
            try {
                iArr[C1732x.ALPHA_AZ.ordinal()] = 7;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C1732x.ALPHA_ZA.ordinal()] = 8;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1732x.DATE_ADDED_LAT.ordinal()] = 5;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C1732x.DATE_ADDED_OLD.ordinal()] = 6;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[C1732x.LAST_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[C1732x.POPULARITY.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[C1732x.RATING.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[C1732x.RELEVANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            f2924n = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] m5116h() {
        int[] iArr = f2925o;
        if (iArr == null) {
            iArr = new int[C1730v.values().length];
            try {
                iArr[C1730v.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C1730v.FREE.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1730v.PAID.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            f2925o = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] m5117i() {
        int[] iArr = f2926p;
        if (iArr == null) {
            iArr = new int[C1731w.values().length];
            try {
                iArr[C1731w.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C1731w.PHONE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1731w.TABLET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C1731w.TV.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f2926p = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] m5118j() {
        int[] iArr = f2927q;
        if (iArr == null) {
            iArr = new int[C1728t.values().length];
            try {
                iArr[C1728t.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C1728t.CT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1728t.G.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C1728t.NC17.ordinal()] = 7;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[C1728t.PG.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[C1728t.PG13.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[C1728t.R.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            f2927q = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] m5119k() {
        int[] iArr = f2928r;
        if (iArr == null) {
            iArr = new int[C1733y.values().length];
            try {
                iArr[C1733y.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C1733y.VIB_ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            f2928r = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] m5120l() {
        int[] iArr = f2929s;
        if (iArr == null) {
            iArr = new int[C1729u.values().length];
            try {
                iArr[C1729u.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C1729u.NOT_REQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1729u.REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            f2929s = iArr;
        }
        return iArr;
    }

    void m5122b(Catalog catalog) {
        switch (C1710s.m5115g()[this.f2930a.ordinal()]) {
            case 2:
                catalog.m5658a(new Sort(1, 3));
                return;
            case 3:
                catalog.m5658a(new Sort(1, 1));
                return;
            case 4:
                catalog.m5658a(new Sort(1, 6));
                return;
            case 5:
                catalog.m5658a(new Sort(1, 5));
                return;
            case 6:
                catalog.m5658a(new Sort(0, 5));
                return;
            case 7:
                catalog.m5658a(new Sort(0, 0));
                return;
            case 8:
                catalog.m5658a(new Sort(1, 0));
                return;
            default:
                catalog.m5658a(null);
                return;
        }
    }

    void m5123c(Catalog catalog) {
        switch (C1710s.m5116h()[this.f2931b.ordinal()]) {
            case 2:
                catalog.m5674c(1);
                return;
            case 3:
                catalog.m5674c(0);
                return;
            default:
                catalog.m5674c(-1);
                return;
        }
    }

    void m5124d(Catalog catalog) {
        switch (C1710s.m5117i()[this.f2932i.ordinal()]) {
            case 2:
                catalog.m5679d("YNN,YYN,YYY");
                catalog.m5683e("OR");
                return;
            case 3:
                catalog.m5679d("NYN,YYN,YYY");
                catalog.m5683e("OR");
                return;
            case 4:
                catalog.m5679d("NNY,NYY,YYY");
                catalog.m5683e("OR");
                return;
            default:
                catalog.m5679d(null);
                catalog.m5683e(null);
                return;
        }
    }

    void m5125e(Catalog catalog) {
        switch (C1710s.m5118j()[this.f2933j.ordinal()]) {
            case 2:
                catalog.m5682e(10);
                return;
            case 3:
                catalog.m5682e(20);
                return;
            case 4:
                catalog.m5682e(30);
                return;
            case 5:
                catalog.m5682e(40);
                return;
            case 6:
                catalog.m5682e(50);
                return;
            case 7:
                catalog.m5682e(60);
                return;
            default:
                catalog.m5682e(0);
                return;
        }
    }

    void m5127f(Catalog catalog) {
        switch (C1710s.m5119k()[this.f2935l.ordinal()]) {
            case 2:
                catalog.m5687f("android.permission.VIBRATE");
                return;
            default:
                catalog.m5687f(null);
                return;
        }
    }

    void m5128g(Catalog catalog) {
        switch (C1710s.m5120l()[this.f2934k.ordinal()]) {
            case 2:
                catalog.m5686f(2);
                return;
            case 3:
                catalog.m5686f(1);
                return;
            default:
                catalog.m5686f(0);
                return;
        }
    }

    void m5129h(Catalog catalog) {
        catalog.m5691g(this.f2936m);
    }

    protected void mo4257a(Catalog catalog) {
        m5125e(catalog);
        m5128g(catalog);
        m5123c(catalog);
        m5124d(catalog);
        m5122b(catalog);
        m5127f(catalog);
        m5129h(catalog);
    }

    public void m5126f() {
        mo4257a(this.g);
        m5094c();
    }
}
