package com.slideme.sam.manager.model.data.cache.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.slideme.sam.manager.model.data.cache.helper.data.UpdatesDatabaseObject;
import com.slideme.sam.manager.util.C1922m;

public class UpdatesDatabase extends SimpleCacheHelper<UpdatesDatabaseObject> {
    private static final String KEY_BUNDLE_ID = "id";
    private static final String KEY_TOKEN = "token";
    private static final String TABLE_NAME = "available_updates";

    public UpdatesDatabase(Context context) {
        super(context, "CREATE TABLE IF NOT EXISTS available_updates (id TEXT PRIMARY KEY NOT NULL, token TEXT);");
    }

    public synchronized UpdatesDatabaseObject[] getAll() {
        UpdatesDatabaseObject[] updatesDatabaseObjectArr;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query(TABLE_NAME, null, null, null, null, null, null);
        updatesDatabaseObjectArr = new UpdatesDatabaseObject[query.getCount()];
        int i = 0;
        while (query.moveToNext()) {
            updatesDatabaseObjectArr[i] = new UpdatesDatabaseObject(query.getString(0), query.getString(1));
            i++;
        }
        query.close();
        return updatesDatabaseObjectArr;
    }

    public synchronized boolean toggle(UpdatesDatabaseObject updatesDatabaseObject) {
        boolean z;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query(TABLE_NAME, null, "id=\"" + updatesDatabaseObject.bundleId + "\"", null, null, null, null);
        if (query.getCount() == 0) {
            add(updatesDatabaseObject);
            query.close();
            z = true;
        } else {
            remove(updatesDatabaseObject);
            query.close();
            z = false;
        }
        return z;
    }

    public synchronized void clear() {
        checkAndOpenDb();
        try {
            this.mDatabase.delete(TABLE_NAME, null, null);
        } catch (Throwable e) {
            C1922m.m5791a(e);
        }
    }

    public synchronized void addAll(UpdatesDatabaseObject[] updatesDatabaseObjectArr) {
        checkAndOpenDb();
        for (UpdatesDatabaseObject add : updatesDatabaseObjectArr) {
            add(add);
        }
    }

    public synchronized void add(UpdatesDatabaseObject updatesDatabaseObject) {
        checkAndOpenDb();
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(KEY_BUNDLE_ID, updatesDatabaseObject.bundleId);
        contentValues.put("token", updatesDatabaseObject.token);
        this.mDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public synchronized void remove(UpdatesDatabaseObject updatesDatabaseObject) {
        checkAndOpenDb();
        this.mDatabase.delete(TABLE_NAME, "id=\"" + updatesDatabaseObject + "\"", null);
    }

    public synchronized boolean has(UpdatesDatabaseObject updatesDatabaseObject) {
        boolean moveToFirst;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query(TABLE_NAME, null, "id=\"" + updatesDatabaseObject + "\"", null, null, null, null);
        moveToFirst = query.moveToFirst();
        query.close();
        return moveToFirst;
    }
}
