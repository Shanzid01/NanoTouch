package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: PersistentAnalyticsStore */
class be implements C0761h {
    private static final String f2025a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private final bh f2026b;
    private volatile C0763m f2027c;
    private final C0770i f2028d;
    private final Context f2029e;
    private final String f2030f;
    private long f2031g;
    private C0762l f2032h;

    be(C0770i c0770i, Context context) {
        this(c0770i, context, "google_analytics_v2.db");
    }

    @VisibleForTesting
    be(C0770i c0770i, Context context, String str) {
        this.f2029e = context.getApplicationContext();
        this.f2030f = str;
        this.f2028d = c0770i;
        this.f2032h = new bf(this);
        this.f2026b = new bh(this, this.f2029e, this.f2030f);
        this.f2027c = new bk(this, m3856e(), this.f2029e);
        this.f2031g = 0;
    }

    private au m3856e() {
        return new bg(this);
    }

    public void mo1196a(long j) {
        boolean z = true;
        SQLiteDatabase a = m3847a("Error opening database for clearHits");
        if (a != null) {
            if (j == 0) {
                a.delete("hits2", null, null);
            } else {
                a.delete("hits2", "hit_app_id = ?", new String[]{Long.valueOf(j).toString()});
            }
            C0770i c0770i = this.f2028d;
            if (m3864c() != 0) {
                z = false;
            }
            c0770i.mo1219a(z);
        }
    }

    public void mo1197a(Map<String, String> map, long j, String str, Collection<Command> collection) {
        m3863b();
        m3852a(map, collection);
        m3857f();
        m3850a((Map) map, j, str);
    }

    private void m3852a(Map<String, String> map, Collection<Command> collection) {
        for (Command command : collection) {
            if (command.getId().equals(Command.APPEND_VERSION)) {
                m3851a((Map) map, command.getUrlParam(), command.getValue());
                return;
            }
        }
    }

    private void m3851a(Map<String, String> map, String str, String str2) {
        Object obj;
        if (str2 == null) {
            obj = "";
        } else {
            obj = str2 + "";
        }
        if (str != null) {
            map.put(str, obj);
        }
    }

    private void m3857f() {
        int c = (m3864c() - 2000) + 1;
        if (c > 0) {
            Collection a = m3858a(c);
            av.m3822i("Store full, deleting " + a.size() + " hits to make room");
            m3861a(a);
        }
    }

    private void m3850a(Map<String, String> map, long j, String str) {
        SQLiteDatabase a = m3847a("Error opening database for putHit");
        if (a != null) {
            long parseLong;
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_string", m3849a((Map) map));
            contentValues.put("hit_time", Long.valueOf(j));
            if (map.containsKey("AppUID")) {
                try {
                    parseLong = Long.parseLong((String) map.get("AppUID"));
                } catch (NumberFormatException e) {
                    parseLong = 0;
                }
            } else {
                parseLong = 0;
            }
            contentValues.put("hit_app_id", Long.valueOf(parseLong));
            if (str == null) {
                str = "http://www.google-analytics.com/collect";
            }
            if (str.length() == 0) {
                av.m3821h("empty path: not sending hit");
                return;
            }
            contentValues.put("hit_url", str);
            try {
                a.insert("hits2", null, contentValues);
                this.f2028d.mo1219a(false);
            } catch (SQLiteException e2) {
                av.m3821h("Error storing hit");
            }
        }
    }

    public static String m3849a(Map<String, String> map) {
        Iterable arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(((String) entry.getKey()) + "=" + at.m3809a((String) entry.getValue()));
        }
        return TextUtils.join("&", arrayList);
    }

    public List<as> m3858a(int i) {
        Cursor query;
        Cursor query2;
        SQLiteException e;
        Throwable th;
        List<as> arrayList;
        SQLiteDatabase a = m3847a("Error opening database for peekHits");
        if (a == null) {
            return new ArrayList();
        }
        Cursor cursor = null;
        ArrayList arrayList2 = new ArrayList();
        try {
            query = a.query("hits2", new String[]{"hit_id", "hit_time", "hit_url"}, null, null, null, null, String.format("%s ASC, %s ASC", new Object[]{"hit_url", "hit_id"}), Integer.toString(i));
            try {
                List<as> arrayList3 = new ArrayList();
                if (query.moveToFirst()) {
                    do {
                        as asVar = new as(null, query.getLong(0), query.getLong(1));
                        asVar.m3805b(query.getString(2));
                        arrayList3.add(asVar);
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
                try {
                    query2 = a.query("hits2", new String[]{"hit_id", "hit_string"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
                    try {
                        if (query2.moveToFirst()) {
                            int i2 = 0;
                            while (true) {
                                if (!(query2 instanceof SQLiteCursor)) {
                                    ((as) arrayList3.get(i2)).m3803a(query2.getString(1));
                                } else if (((SQLiteCursor) query2).getWindow().getNumRows() > 0) {
                                    ((as) arrayList3.get(i2)).m3803a(query2.getString(1));
                                } else {
                                    av.m3821h("hitString for hitId " + ((as) arrayList3.get(i2)).m3804b() + " too large.  Hit will be deleted.");
                                }
                                int i3 = i2 + 1;
                                if (!query2.moveToNext()) {
                                    break;
                                }
                                i2 = i3;
                            }
                        }
                        if (query2 != null) {
                            query2.close();
                        }
                        return arrayList3;
                    } catch (SQLiteException e2) {
                        e = e2;
                        query = query2;
                    } catch (Throwable th2) {
                        th = th2;
                        query = query2;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    try {
                        av.m3821h("error in peekHits fetching hitString: " + e.getMessage());
                        List<as> arrayList4 = new ArrayList();
                        Object obj = null;
                        for (as asVar2 : arrayList3) {
                            if (TextUtils.isEmpty(asVar2.m3802a())) {
                                if (obj != null) {
                                    break;
                                }
                                obj = 1;
                            }
                            arrayList4.add(asVar2);
                        }
                        if (query != null) {
                            query.close();
                        }
                        return arrayList4;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (SQLiteException e4) {
                e = e4;
                query2 = query;
                try {
                    av.m3821h("error in peekHits fetching hitIds: " + e.getMessage());
                    arrayList = new ArrayList();
                    if (query2 != null) {
                        return arrayList;
                    }
                    query2.close();
                    return arrayList;
                } catch (Throwable th4) {
                    th = th4;
                    cursor = query2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            query2 = null;
            av.m3821h("error in peekHits fetching hitIds: " + e.getMessage());
            arrayList = new ArrayList();
            if (query2 != null) {
                return arrayList;
            }
            query2.close();
            return arrayList;
        } catch (Throwable th6) {
            th = th6;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (query != null) {
            query.close();
        }
        throw th;
    }

    int m3863b() {
        boolean z = true;
        long a = this.f2032h.mo1198a();
        if (a <= this.f2031g + 86400000) {
            return 0;
        }
        this.f2031g = a;
        SQLiteDatabase a2 = m3847a("Error opening database for deleteStaleHits");
        if (a2 == null) {
            return 0;
        }
        int delete = a2.delete("hits2", "HIT_TIME < ?", new String[]{Long.toString(this.f2032h.mo1198a() - 2592000000L)});
        C0770i c0770i = this.f2028d;
        if (m3864c() != 0) {
            z = false;
        }
        c0770i.mo1219a(z);
        return delete;
    }

    public void m3861a(Collection<as> collection) {
        boolean z = false;
        if (collection == null) {
            throw new NullPointerException("hits cannot be null");
        } else if (!collection.isEmpty()) {
            SQLiteDatabase a = m3847a("Error opening database for deleteHit");
            if (a != null) {
                String[] strArr = new String[collection.size()];
                String format = String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))});
                int i = 0;
                for (as b : collection) {
                    int i2 = i + 1;
                    strArr[i] = Long.toString(b.m3804b());
                    i = i2;
                }
                try {
                    a.delete("hits2", format, strArr);
                    C0770i c0770i = this.f2028d;
                    if (m3864c() == 0) {
                        z = true;
                    }
                    c0770i.mo1219a(z);
                } catch (SQLiteException e) {
                    av.m3821h("Error deleting hit " + collection);
                }
            }
        }
    }

    int m3864c() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase a = m3847a("Error opening database for requestNumHitsPending");
        if (a != null) {
            try {
                cursor = a.rawQuery("SELECT COUNT(*) from hits2", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                av.m3821h("Error getting numStoredHits");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    public void mo1195a() {
        av.m3820g("dispatch running...");
        if (this.f2027c.mo1201a()) {
            List a = m3858a(40);
            if (a.isEmpty()) {
                av.m3820g("...nothing to dispatch");
                this.f2028d.mo1219a(true);
                return;
            }
            int a2 = this.f2027c.mo1200a(a);
            av.m3820g("sent " + a2 + " of " + a.size() + " hits");
            m3861a(a.subList(0, Math.min(a2, a.size())));
            if (a2 == a.size() && m3864c() > 0) {
                C0778v.m3961a().mo1218c();
            }
        }
    }

    private SQLiteDatabase m3847a(String str) {
        try {
            return this.f2026b.getWritableDatabase();
        } catch (SQLiteException e) {
            av.m3821h(str);
            return null;
        }
    }
}
