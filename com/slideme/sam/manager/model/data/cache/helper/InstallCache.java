package com.slideme.sam.manager.model.data.cache.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.slideme.sam.manager.model.data.cache.helper.data.InstallCacheObject;

@Deprecated
public class InstallCache extends SimpleCacheHelper<InstallCacheObject> {
    private static final String KEY_BUNDLE_ID = "id";
    private static final String KEY_VERSION_CODE = "versioncode";
    private static final String TABLE_NAME = "updates";

    public InstallCache(Context context) {
        super(context, "CREATE TABLE IF NOT EXISTS updates (id TEXT PRIMARY KEY, versioncode INTEGER NOT NULL);");
    }

    public synchronized InstallCacheObject[] getAll() {
        InstallCacheObject[] installCacheObjectArr;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query(TABLE_NAME, null, null, null, null, null, null);
        installCacheObjectArr = new InstallCacheObject[query.getCount()];
        int i = 0;
        while (query.moveToNext()) {
            installCacheObjectArr[i] = new InstallCacheObject(query.getString(0), query.getInt(1));
            i++;
        }
        query.close();
        return installCacheObjectArr;
    }

    public synchronized boolean toggle(InstallCacheObject installCacheObject) {
        return false;
    }

    public synchronized void clear() {
        checkAndOpenDb();
        this.mDatabase.delete(TABLE_NAME, null, null);
    }

    public synchronized void add(InstallCacheObject installCacheObject) {
        checkAndOpenDb();
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(KEY_BUNDLE_ID, installCacheObject.bundleId);
        contentValues.put(KEY_VERSION_CODE, Integer.valueOf(installCacheObject.versionCode));
        this.mDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public synchronized void remove(InstallCacheObject installCacheObject) {
        checkAndOpenDb();
        this.mDatabase.delete(TABLE_NAME, "id=\"" + installCacheObject.bundleId + "\"", null);
    }

    public synchronized boolean has(InstallCacheObject installCacheObject) {
        boolean moveToFirst;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query(TABLE_NAME, null, "id=\"" + installCacheObject.bundleId + "\"", null, null, null, null);
        moveToFirst = query.moveToFirst();
        query.close();
        return moveToFirst;
    }

    public synchronized void addAll(InstallCacheObject[] installCacheObjectArr) {
        checkAndOpenDb();
        for (InstallCacheObject add : installCacheObjectArr) {
            add(add);
        }
    }

    public synchronized String[] getBundlesArray() {
        String[] strArr;
        checkAndOpenDb();
        InstallCacheObject[] all = getAll();
        strArr = new String[all.length];
        for (int i = 0; i < all.length; i++) {
            strArr[i] = all[i].bundleId;
        }
        return strArr;
    }
}
