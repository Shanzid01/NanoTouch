package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class zzag implements zzd {
    private static final String zzES = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private static final String zzET = String.format("SELECT COUNT(*), MIN(%s), MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hit_time", "hits2"});
    private final Context mContext;
    private zzo zzBr;
    private volatile boolean zzBs;
    private final zze zzCb;
    private final zza zzEU;
    private volatile zzr zzEV;
    private final String zzEW;
    private zzaf zzEX;
    private long zzEY;
    private final int zzEZ;
    private zzlv zzmW;

    class zza extends SQLiteOpenHelper {
        private boolean zzFa;
        private long zzFb = 0;
        final /* synthetic */ zzag zzFc;

        zza(zzag com_google_android_gms_analytics_zzag, Context context, String str) {
            this.zzFc = com_google_android_gms_analytics_zzag;
            super(context, str, null, 1);
        }

        private void zza(SQLiteDatabase sQLiteDatabase) {
            Object obj = null;
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (hashSet.remove("hit_id") && hashSet.remove("hit_url") && hashSet.remove("hit_string") && hashSet.remove("hit_time")) {
                    if (!hashSet.remove("hit_app_id")) {
                        obj = 1;
                    }
                    if (!hashSet.isEmpty()) {
                        throw new SQLiteException("Database has extra columns");
                    } else if (obj != null) {
                        sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                        return;
                    } else {
                        return;
                    }
                }
                throw new SQLiteException("Database column missing");
            } finally {
                rawQuery.close();
            }
        }

        private boolean zza(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        zzae.zzac("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                zzae.zzac("Error querying for table " + str);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.zzFa || this.zzFb + 3600000 <= this.zzFc.zzmW.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.zzFa = true;
                this.zzFb = this.zzFc.zzmW.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.zzFc.mContext.getDatabasePath(this.zzFc.zzEW).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.zzFa = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            zzt.zzam(sQLiteDatabase.getPath());
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (zza("hits2", sQLiteDatabase)) {
                zza(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(zzag.zzES);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    zzag(zze com_google_android_gms_analytics_zze, Context context, zzo com_google_android_gms_analytics_zzo) {
        this(com_google_android_gms_analytics_zze, context, "google_analytics_v4.db", 2000, com_google_android_gms_analytics_zzo);
    }

    zzag(zze com_google_android_gms_analytics_zze, Context context, String str, int i, zzo com_google_android_gms_analytics_zzo) {
        this.zzBs = true;
        this.mContext = context.getApplicationContext();
        this.zzBr = com_google_android_gms_analytics_zzo;
        this.zzEW = str;
        this.zzCb = com_google_android_gms_analytics_zze;
        this.zzmW = zzlx.zzkc();
        this.zzEU = new zza(this, this.mContext, this.zzEW);
        this.zzEV = new zzh(new DefaultHttpClient(), this.mContext, this.zzBr);
        this.zzEY = 0;
        this.zzEZ = i;
    }

    static String zzD(Map<String, String> map) {
        Iterable arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(zzac.encode((String) entry.getKey()) + "=" + zzac.encode((String) entry.getValue()));
        }
        return TextUtils.join("&", arrayList);
    }

    private synchronized void zza(Map<String, String> map, long j, String str) {
        SQLiteDatabase zzar = zzar("Error opening database for putHit");
        if (zzar != null) {
            long parseLong;
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_string", zzD(map));
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
                zzae.zzac("Empty path: not sending hit");
            } else {
                contentValues.put("hit_url", str);
                try {
                    zzar.insert("hits2", null, contentValues);
                    this.zzCb.zzD(false);
                } catch (SQLiteException e2) {
                    zzae.zzac("Error storing hit");
                }
            }
        }
    }

    private void zza(Map<String, String> map, Collection<zzik> collection) {
        String substring = "&_v".substring(1);
        if (collection != null) {
            for (zzik com_google_android_gms_internal_zzik : collection) {
                if (Command.APPEND_VERSION.equals(com_google_android_gms_internal_zzik.getId())) {
                    map.put(substring, com_google_android_gms_internal_zzik.getValue());
                    return;
                }
            }
        }
    }

    private synchronized SQLiteDatabase zzar(String str) {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = this.zzEU.getWritableDatabase();
        } catch (SQLiteException e) {
            zzae.zzac(str);
            writableDatabase = null;
        }
        return writableDatabase;
    }

    private void zzgy() {
        int zzgA = (zzgA() - this.zzEZ) + 1;
        if (zzgA > 0) {
            List zzM = zzM(zzgA);
            zzae.zzab("Store full, deleting " + zzM.size() + " hits to make room.");
            zzb((String[]) zzM.toArray(new String[0]));
        }
    }

    public void dispatch() {
        boolean z = true;
        zzae.zzab("Dispatch running...");
        if (this.zzEV.zzfk()) {
            List zzN = zzN(20);
            if (zzN.isEmpty()) {
                zzae.zzab("...nothing to dispatch");
                this.zzCb.zzD(true);
                return;
            }
            if (this.zzEX == null) {
                this.zzEX = new zzaf("_t=dispatch&_v=ma4.0.6", false);
            }
            if (zzgA() > zzN.size()) {
                z = false;
            }
            int zza = this.zzEV.zza(zzN, this.zzEX, z);
            zzae.zzab("sent " + zza + " of " + zzN.size() + " hits");
            zzb(zzN.subList(0, Math.min(zza, zzN.size())));
            if (zza != zzN.size() || zzgA() <= 0) {
                this.zzEX = null;
            } else {
                GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
            }
        }
    }

    public void setDryRun(boolean z) {
        this.zzBs = z;
        if (this.zzEV != null) {
            this.zzEV.setDryRun(z);
        }
    }

    synchronized List<String> zzM(int i) {
        List<String> list;
        Cursor query;
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            zzae.zzac("Invalid maxHits specified. Skipping");
            list = arrayList;
        } else {
            SQLiteDatabase zzar = zzar("Error opening database for peekHitIds.");
            if (zzar == null) {
                list = arrayList;
            } else {
                try {
                    query = zzar.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
                    try {
                        if (query.moveToFirst()) {
                            do {
                                arrayList.add(String.valueOf(query.getLong(0)));
                            } while (query.moveToNext());
                        }
                        if (query != null) {
                            query.close();
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        try {
                            zzae.zzac("Error in peekHits fetching hitIds: " + e.getMessage());
                            if (query != null) {
                                query.close();
                            }
                            list = arrayList;
                            return list;
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    query = null;
                    zzae.zzac("Error in peekHits fetching hitIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    list = arrayList;
                    return list;
                } catch (Throwable th3) {
                    th = th3;
                    query = null;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
                list = arrayList;
            }
        }
        return list;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.google.android.gms.analytics.zzab> zzN(int r17) {
        /*
        r16 = this;
        monitor-enter(r16);
        r11 = new java.util.ArrayList;	 Catch:{ all -> 0x00fd }
        r11.<init>();	 Catch:{ all -> 0x00fd }
        r2 = "Error opening database for peekHits";
        r0 = r16;
        r2 = r0.zzar(r2);	 Catch:{ all -> 0x00fd }
        if (r2 != 0) goto L_0x0013;
    L_0x0010:
        r2 = r11;
    L_0x0011:
        monitor-exit(r16);
        return r2;
    L_0x0013:
        r12 = 0;
        r3 = "hits2";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00d8, all -> 0x0100 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00d8, all -> 0x0100 }
        r5 = 1;
        r6 = "hit_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00d8, all -> 0x0100 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x00d8, all -> 0x0100 }
        r13 = 0;
        r14 = "hit_id";
        r10[r13] = r14;	 Catch:{ SQLiteException -> 0x00d8, all -> 0x0100 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x00d8, all -> 0x0100 }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x00d8, all -> 0x0100 }
        r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x00d8, all -> 0x0100 }
        r12 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0182, all -> 0x017c }
        r12.<init>();	 Catch:{ SQLiteException -> 0x0182, all -> 0x017c }
        r3 = r13.moveToFirst();	 Catch:{ SQLiteException -> 0x0188, all -> 0x017c }
        if (r3 == 0) goto L_0x0063;
    L_0x0048:
        r4 = new com.google.android.gms.analytics.zzab;	 Catch:{ SQLiteException -> 0x0188, all -> 0x017c }
        r5 = 0;
        r3 = 0;
        r6 = r13.getLong(r3);	 Catch:{ SQLiteException -> 0x0188, all -> 0x017c }
        r3 = 1;
        r8 = r13.getLong(r3);	 Catch:{ SQLiteException -> 0x0188, all -> 0x017c }
        r10 = "";
        r4.<init>(r5, r6, r8, r10);	 Catch:{ SQLiteException -> 0x0188, all -> 0x017c }
        r12.add(r4);	 Catch:{ SQLiteException -> 0x0188, all -> 0x017c }
        r3 = r13.moveToNext();	 Catch:{ SQLiteException -> 0x0188, all -> 0x017c }
        if (r3 != 0) goto L_0x0048;
    L_0x0063:
        if (r13 == 0) goto L_0x0068;
    L_0x0065:
        r13.close();	 Catch:{ all -> 0x00fd }
    L_0x0068:
        r11 = 0;
        r3 = "hits2";
        r4 = 3;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x017a }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x017a }
        r5 = 1;
        r6 = "hit_string";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x017a }
        r5 = 2;
        r6 = "hit_url";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x017a }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x017a }
        r14 = 0;
        r15 = "hit_id";
        r10[r14] = r15;	 Catch:{ SQLiteException -> 0x017a }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x017a }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x017a }
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x017a }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        if (r2 == 0) goto L_0x00d0;
    L_0x009d:
        r4 = r11;
    L_0x009e:
        r0 = r3;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r2 = r0;
        r2 = r2.getWindow();	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r2 = r2.getNumRows();	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        if (r2 <= 0) goto L_0x0107;
    L_0x00ac:
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r2 = (com.google.android.gms.analytics.zzab) r2;	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r2.zzap(r5);	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r2 = (com.google.android.gms.analytics.zzab) r2;	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r5 = 2;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r2.zzaq(r5);	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
    L_0x00c8:
        r2 = r4 + 1;
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        if (r4 != 0) goto L_0x018e;
    L_0x00d0:
        if (r3 == 0) goto L_0x00d5;
    L_0x00d2:
        r3.close();	 Catch:{ all -> 0x00fd }
    L_0x00d5:
        r2 = r12;
        goto L_0x0011;
    L_0x00d8:
        r2 = move-exception;
        r3 = r2;
        r4 = r12;
        r2 = r11;
    L_0x00dc:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x017f }
        r5.<init>();	 Catch:{ all -> 0x017f }
        r6 = "Error in peekHits fetching hitIds: ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x017f }
        r3 = r3.getMessage();	 Catch:{ all -> 0x017f }
        r3 = r5.append(r3);	 Catch:{ all -> 0x017f }
        r3 = r3.toString();	 Catch:{ all -> 0x017f }
        com.google.android.gms.analytics.zzae.zzac(r3);	 Catch:{ all -> 0x017f }
        if (r4 == 0) goto L_0x0011;
    L_0x00f8:
        r4.close();	 Catch:{ all -> 0x00fd }
        goto L_0x0011;
    L_0x00fd:
        r2 = move-exception;
        monitor-exit(r16);
        throw r2;
    L_0x0100:
        r2 = move-exception;
    L_0x0101:
        if (r12 == 0) goto L_0x0106;
    L_0x0103:
        r12.close();	 Catch:{ all -> 0x00fd }
    L_0x0106:
        throw r2;	 Catch:{ all -> 0x00fd }
    L_0x0107:
        r5 = "HitString for hitId %d too large.  Hit will be deleted.";
        r2 = 1;
        r6 = new java.lang.Object[r2];	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r7 = 0;
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r2 = (com.google.android.gms.analytics.zzab) r2;	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r8 = r2.zzgs();	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r6[r7] = r2;	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        r2 = java.lang.String.format(r5, r6);	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        com.google.android.gms.analytics.zzae.zzac(r2);	 Catch:{ SQLiteException -> 0x0125, all -> 0x0177 }
        goto L_0x00c8;
    L_0x0125:
        r2 = move-exception;
        r13 = r3;
    L_0x0127:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0170 }
        r3.<init>();	 Catch:{ all -> 0x0170 }
        r4 = "Error in peekHits fetching hitString: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0170 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0170 }
        r2 = r3.append(r2);	 Catch:{ all -> 0x0170 }
        r2 = r2.toString();	 Catch:{ all -> 0x0170 }
        com.google.android.gms.analytics.zzae.zzac(r2);	 Catch:{ all -> 0x0170 }
        r3 = new java.util.ArrayList;	 Catch:{ all -> 0x0170 }
        r3.<init>();	 Catch:{ all -> 0x0170 }
        r4 = 0;
        r5 = r12.iterator();	 Catch:{ all -> 0x0170 }
    L_0x014b:
        r2 = r5.hasNext();	 Catch:{ all -> 0x0170 }
        if (r2 == 0) goto L_0x0163;
    L_0x0151:
        r2 = r5.next();	 Catch:{ all -> 0x0170 }
        r2 = (com.google.android.gms.analytics.zzab) r2;	 Catch:{ all -> 0x0170 }
        r6 = r2.zzgr();	 Catch:{ all -> 0x0170 }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x0170 }
        if (r6 == 0) goto L_0x016c;
    L_0x0161:
        if (r4 == 0) goto L_0x016b;
    L_0x0163:
        if (r13 == 0) goto L_0x0168;
    L_0x0165:
        r13.close();	 Catch:{ all -> 0x00fd }
    L_0x0168:
        r2 = r3;
        goto L_0x0011;
    L_0x016b:
        r4 = 1;
    L_0x016c:
        r3.add(r2);	 Catch:{ all -> 0x0170 }
        goto L_0x014b;
    L_0x0170:
        r2 = move-exception;
    L_0x0171:
        if (r13 == 0) goto L_0x0176;
    L_0x0173:
        r13.close();	 Catch:{ all -> 0x00fd }
    L_0x0176:
        throw r2;	 Catch:{ all -> 0x00fd }
    L_0x0177:
        r2 = move-exception;
        r13 = r3;
        goto L_0x0171;
    L_0x017a:
        r2 = move-exception;
        goto L_0x0127;
    L_0x017c:
        r2 = move-exception;
        r12 = r13;
        goto L_0x0101;
    L_0x017f:
        r2 = move-exception;
        r12 = r4;
        goto L_0x0101;
    L_0x0182:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r11;
        goto L_0x00dc;
    L_0x0188:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r12;
        goto L_0x00dc;
    L_0x018e:
        r4 = r2;
        goto L_0x009e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.zzag.zzN(int):java.util.List<com.google.android.gms.analytics.zzab>");
    }

    public void zza(Map<String, String> map, long j, String str, Collection<zzik> collection) {
        zzgz();
        zzgy();
        zza(map, collection);
        zza(map, j, str);
    }

    @Deprecated
    void zzb(Collection<zzab> collection) {
        if (collection == null || collection.isEmpty()) {
            zzae.zzac("Empty/Null collection passed to deleteHits.");
            return;
        }
        String[] strArr = new String[collection.size()];
        int i = 0;
        for (zzab zzgs : collection) {
            int i2 = i + 1;
            strArr[i] = String.valueOf(zzgs.zzgs());
            i = i2;
        }
        zzb(strArr);
    }

    synchronized void zzb(String[] strArr) {
        boolean z = true;
        synchronized (this) {
            if (strArr != null) {
                if (strArr.length != 0) {
                    SQLiteDatabase zzar = zzar("Error opening database for deleteHits.");
                    if (zzar != null) {
                        try {
                            zzar.delete("hits2", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                            zze com_google_android_gms_analytics_zze = this.zzCb;
                            if (zzgA() != 0) {
                                z = false;
                            }
                            com_google_android_gms_analytics_zze.zzD(z);
                        } catch (SQLiteException e) {
                            zzae.zzac("Error deleting hits " + TextUtils.join(",", strArr));
                        }
                    }
                }
            }
            zzae.zzac("Empty hitIds passed to deleteHits.");
        }
    }

    public zzr zzff() {
        return this.zzEV;
    }

    public synchronized Pair<Long, Long> zzfg() {
        Pair<Long, Long> create;
        Cursor cursor = null;
        synchronized (this) {
            zzx.zzbe("getMinMaxHitTimes may not be called from the main thread");
            create = Pair.create(Long.valueOf(0), Long.valueOf(0));
            SQLiteDatabase zzar = zzar("Error opening database for getMinMaxHitTimes.");
            if (zzar != null) {
                try {
                    cursor = zzar.rawQuery(zzET, null);
                    if (cursor.moveToFirst()) {
                        create = Pair.create(Long.valueOf(cursor.getLong(1)), Long.valueOf(cursor.getLong(2)));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteException e) {
                    zzae.zzac("Error getting minMaxHitTimes");
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        return create;
    }

    synchronized int zzgA() {
        Cursor cursor = null;
        int i = 0;
        synchronized (this) {
            SQLiteDatabase zzar = zzar("Error opening database for getNumStoredHits.");
            if (zzar != null) {
                try {
                    cursor = zzar.rawQuery("SELECT COUNT(*) from hits2", null);
                    if (cursor.moveToFirst()) {
                        i = (int) cursor.getLong(0);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteException e) {
                    zzae.zzac("Error getting numStoredHits");
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        return i;
    }

    synchronized int zzgz() {
        int i;
        boolean z = false;
        synchronized (this) {
            long currentTimeMillis = this.zzmW.currentTimeMillis();
            if (currentTimeMillis > this.zzEY + 86400000) {
                this.zzEY = currentTimeMillis;
                SQLiteDatabase zzar = zzar("Error opening database for deleteStaleHits.");
                if (zzar != null) {
                    int delete = zzar.delete("hits2", "HIT_TIME < ?", new String[]{Long.toString(this.zzmW.currentTimeMillis() - 2592000000L)});
                    zze com_google_android_gms_analytics_zze = this.zzCb;
                    if (zzgA() == 0) {
                        z = true;
                    }
                    com_google_android_gms_analytics_zze.zzD(z);
                    i = delete;
                }
            }
        }
        return i;
    }

    public synchronized void zzl(long j) {
        boolean z = true;
        synchronized (this) {
            SQLiteDatabase zzar = zzar("Error opening database for clearHits");
            if (zzar != null) {
                if (j == 0) {
                    zzar.delete("hits2", null, null);
                } else {
                    zzar.delete("hits2", "hit_app_id = ?", new String[]{Long.valueOf(j).toString()});
                }
                zze com_google_android_gms_analytics_zze = this.zzCb;
                if (zzgA() != 0) {
                    z = false;
                }
                com_google_android_gms_analytics_zze.zzD(z);
            }
        }
    }
}
