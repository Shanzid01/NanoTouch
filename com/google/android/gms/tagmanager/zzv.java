package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlx;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class zzv implements zzc {
    private static final String zzayn = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    private final Context mContext;
    private final Executor zzayo;
    private zza zzayp;
    private int zzayq;
    private zzlv zzmW;

    class zza extends SQLiteOpenHelper {
        final /* synthetic */ zzv zzayt;

        zza(zzv com_google_android_gms_tagmanager_zzv, Context context, String str) {
            this.zzayt = com_google_android_gms_tagmanager_zzv;
            super(context, str, null, 1);
        }

        private void zza(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
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
                        zzbf.zzac("Error querying for table " + str);
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
                zzbf.zzac("Error querying for table " + str);
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
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.zzayt.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            zzak.zzam(sQLiteDatabase.getPath());
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
            if (zza("datalayer", sQLiteDatabase)) {
                zza(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(zzv.zzayn);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    class zzb {
        final byte[] zzayw;
        final String zzqd;

        zzb(String str, byte[] bArr) {
            this.zzqd = str;
            this.zzayw = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.zzqd + " serialized hash = " + Arrays.hashCode(this.zzayw);
        }
    }

    public zzv(Context context) {
        this(context, zzlx.zzkc(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    zzv(Context context, zzlv com_google_android_gms_internal_zzlv, String str, int i, Executor executor) {
        this.mContext = context;
        this.zzmW = com_google_android_gms_internal_zzlv;
        this.zzayq = i;
        this.zzayo = executor;
        this.zzayp = new zza(this, this.mContext, str);
    }

    private void zzG(long j) {
        SQLiteDatabase zzar = zzar("Error opening database for deleteOlderThan.");
        if (zzar != null) {
            try {
                zzbf.zzab("Deleted " + zzar.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                zzbf.zzac("Error deleting old entries.");
            }
        }
    }

    private SQLiteDatabase zzar(String str) {
        try {
            return this.zzayp.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbf.zzac(str);
            return null;
        }
    }

    private synchronized void zzb(List<zzb> list, long j) {
        try {
            long currentTimeMillis = this.zzmW.currentTimeMillis();
            zzG(currentTimeMillis);
            zzhd(list.size());
            zzc(list, currentTimeMillis + j);
            zztb();
        } catch (Throwable th) {
            zztb();
        }
    }

    private void zzc(List<zzb> list, long j) {
        SQLiteDatabase zzar = zzar("Error opening database for writeEntryToDatabase.");
        if (zzar != null) {
            for (zzb com_google_android_gms_tagmanager_zzv_zzb : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", com_google_android_gms_tagmanager_zzv_zzb.zzqd);
                contentValues.put("value", com_google_android_gms_tagmanager_zzv_zzb.zzayw);
                zzar.insert("datalayer", null, contentValues);
            }
        }
    }

    private void zzcX(String str) {
        SQLiteDatabase zzar = zzar("Error opening database for clearKeysWithPrefix.");
        if (zzar != null) {
            try {
                zzbf.zzab("Cleared " + zzar.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                zzbf.zzac("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                zztb();
            }
        }
    }

    private void zzg(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase zzar = zzar("Error opening database for deleteEntries.");
            if (zzar != null) {
                try {
                    zzar.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    zzbf.zzac("Error deleting entries " + Arrays.toString(strArr));
                }
            }
        }
    }

    private void zzhd(int i) {
        int zzta = (zzta() - this.zzayq) + i;
        if (zzta > 0) {
            List zzhe = zzhe(zzta);
            zzbf.zzaa("DataLayer store full, deleting " + zzhe.size() + " entries to make room.");
            zzg((String[]) zzhe.toArray(new String[0]));
        }
    }

    private List<String> zzhe(int i) {
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            zzbf.zzac("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase zzar = zzar("Error opening database for peekEntryIds.");
        if (zzar == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = zzar.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
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
                    zzbf.zzac("Error in peekEntries fetching entryIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
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
            zzbf.zzac("Error in peekEntries fetching entryIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    private Object zzk(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream.readObject();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = objectInputStream2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private byte[] zzp(Object obj) {
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private List<zza> zzr(List<zzb> list) {
        List<zza> arrayList = new ArrayList();
        for (zzb com_google_android_gms_tagmanager_zzv_zzb : list) {
            arrayList.add(new zza(com_google_android_gms_tagmanager_zzv_zzb.zzqd, zzk(com_google_android_gms_tagmanager_zzv_zzb.zzayw)));
        }
        return arrayList;
    }

    private List<zzb> zzs(List<zza> list) {
        List<zzb> arrayList = new ArrayList();
        for (zza com_google_android_gms_tagmanager_DataLayer_zza : list) {
            arrayList.add(new zzb(com_google_android_gms_tagmanager_DataLayer_zza.zzqd, zzp(com_google_android_gms_tagmanager_DataLayer_zza.zzzt)));
        }
        return arrayList;
    }

    private List<zza> zzsY() {
        try {
            zzG(this.zzmW.currentTimeMillis());
            List<zza> zzr = zzr(zzsZ());
            return zzr;
        } finally {
            zztb();
        }
    }

    private List<zzb> zzsZ() {
        SQLiteDatabase zzar = zzar("Error opening database for loadSerialized.");
        List<zzb> arrayList = new ArrayList();
        if (zzar == null) {
            return arrayList;
        }
        Cursor query = zzar.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzb(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int zzta() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase zzar = zzar("Error opening database for getNumStoredEntries.");
        if (zzar != null) {
            try {
                cursor = zzar.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                zzbf.zzac("Error getting numStoredEntries");
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

    private void zztb() {
        try {
            this.zzayp.close();
        } catch (SQLiteException e) {
        }
    }

    public void zza(final com.google.android.gms.tagmanager.DataLayer.zzc.zza com_google_android_gms_tagmanager_DataLayer_zzc_zza) {
        this.zzayo.execute(new Runnable(this) {
            final /* synthetic */ zzv zzayt;

            public void run() {
                com_google_android_gms_tagmanager_DataLayer_zzc_zza.zzq(this.zzayt.zzsY());
            }
        });
    }

    public void zza(List<zza> list, final long j) {
        final List zzs = zzs(list);
        this.zzayo.execute(new Runnable(this) {
            final /* synthetic */ zzv zzayt;

            public void run() {
                this.zzayt.zzb(zzs, j);
            }
        });
    }

    public void zzcW(final String str) {
        this.zzayo.execute(new Runnable(this) {
            final /* synthetic */ zzv zzayt;

            public void run() {
                this.zzayt.zzcX(str);
            }
        });
    }
}
