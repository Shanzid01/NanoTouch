package com.slideme.sam.manager.model.data.cache.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.slideme.sam.manager.model.data.cache.helper.data.InstallReferrerCacheObject;

public class InstallReferrerCache extends SimpleCacheHelper<InstallReferrerCacheObject> {
    private static final String KEY_PACKAGE_NAME = "id";
    private static final String KEY_REFERRER = "referrer";
    private static final String KEY_STATE = "state";
    private static final String TABLE_NAME = "install_referrer";

    public InstallReferrerCache(Context context) {
        super(context, "CREATE TABLE IF NOT EXISTS install_referrer (id TEXT PRIMARY KEY, referrer TEXT NOT NULL, state INTEGER NOT NULL);");
    }

    public synchronized InstallReferrerCacheObject[] getAll() {
        InstallReferrerCacheObject[] installReferrerCacheObjectArr;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query(TABLE_NAME, null, null, null, null, null, null);
        installReferrerCacheObjectArr = new InstallReferrerCacheObject[query.getCount()];
        int i = 0;
        while (query.moveToNext()) {
            installReferrerCacheObjectArr[i] = new InstallReferrerCacheObject(query.getString(0), query.getString(1), query.getInt(2));
            i++;
        }
        query.close();
        return installReferrerCacheObjectArr;
    }

    public synchronized InstallReferrerCacheObject getItem(String str) {
        InstallReferrerCacheObject installReferrerCacheObject;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query(TABLE_NAME, null, "state = " + InstallReferrerCacheObject.STATE_INSTALLED + " OR " + KEY_STATE + " = " + InstallReferrerCacheObject.STATE_NEW, null, null, null, null);
        if (query == null || !query.moveToFirst()) {
            installReferrerCacheObject = null;
        } else {
            installReferrerCacheObject = new InstallReferrerCacheObject(query.getString(0), query.getString(1), query.getInt(2));
        }
        return installReferrerCacheObject;
    }

    public synchronized InstallReferrerCacheObject[] getAllPending() {
        InstallReferrerCacheObject[] installReferrerCacheObjectArr;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query(TABLE_NAME, null, "state = " + InstallReferrerCacheObject.STATE_INSTALLED, null, null, null, null);
        installReferrerCacheObjectArr = new InstallReferrerCacheObject[query.getCount()];
        int i = 0;
        while (query.moveToNext()) {
            installReferrerCacheObjectArr[i] = new InstallReferrerCacheObject(query.getString(0), query.getString(1), query.getInt(2));
            i++;
        }
        query.close();
        return installReferrerCacheObjectArr;
    }

    public synchronized boolean toggle(InstallReferrerCacheObject installReferrerCacheObject) {
        return false;
    }

    public synchronized void clear() {
        checkAndOpenDb();
        this.mDatabase.delete(TABLE_NAME, null, null);
    }

    public synchronized void add(InstallReferrerCacheObject installReferrerCacheObject) {
        checkAndOpenDb();
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(KEY_PACKAGE_NAME, installReferrerCacheObject.packageName);
        contentValues.put(KEY_REFERRER, installReferrerCacheObject.referrer);
        contentValues.put(KEY_STATE, Integer.valueOf(installReferrerCacheObject.state));
        this.mDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public synchronized void remove(InstallReferrerCacheObject installReferrerCacheObject) {
        checkAndOpenDb();
        this.mDatabase.delete(TABLE_NAME, "id=\"" + installReferrerCacheObject.packageName + "\"", null);
    }

    public synchronized void update(InstallReferrerCacheObject installReferrerCacheObject) {
        checkAndOpenDb();
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(KEY_PACKAGE_NAME, installReferrerCacheObject.packageName);
        if (!TextUtils.isEmpty(installReferrerCacheObject.referrer)) {
            contentValues.put(KEY_REFERRER, installReferrerCacheObject.referrer);
        }
        if (installReferrerCacheObject.state > 0) {
            contentValues.put(KEY_STATE, Integer.valueOf(installReferrerCacheObject.state));
        }
        this.mDatabase.update(TABLE_NAME, contentValues, "id=\"" + installReferrerCacheObject.packageName + "\"", null);
    }

    public synchronized boolean has(InstallReferrerCacheObject installReferrerCacheObject) {
        boolean moveToFirst;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query(TABLE_NAME, null, "id=\"" + installReferrerCacheObject.packageName + "\"", null, null, null, null);
        moveToFirst = query.moveToFirst();
        query.close();
        return moveToFirst;
    }

    public synchronized void addAll(InstallReferrerCacheObject[] installReferrerCacheObjectArr) {
        checkAndOpenDb();
        for (InstallReferrerCacheObject add : installReferrerCacheObjectArr) {
            add(add);
        }
    }
}
