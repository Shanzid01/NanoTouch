package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.drive.DriveFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

public class NativeAppCallContentProvider extends ContentProvider {
    private static final String ATTACHMENT_URL_BASE = "content://com.facebook.app.NativeAppCallContentProvider";
    private static final String TAG = NativeAppCallContentProvider.class.getName();
    private final AttachmentDataSource dataSource;

    interface AttachmentDataSource {
        File openAttachment(UUID uuid, String str);
    }

    public NativeAppCallContentProvider() {
        this(new NativeAppCallAttachmentStore());
    }

    NativeAppCallContentProvider(AttachmentDataSource attachmentDataSource) {
        this.dataSource = attachmentDataSource;
    }

    public static String getAttachmentUrl(String str, UUID uuid, String str2) {
        return String.format("%s%s/%s/%s", new Object[]{ATTACHMENT_URL_BASE, str, uuid.toString(), str2});
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        Pair parseCallIdAndAttachmentName = parseCallIdAndAttachmentName(uri);
        if (parseCallIdAndAttachmentName == null) {
            throw new FileNotFoundException();
        }
        try {
            return ParcelFileDescriptor.open(this.dataSource.openAttachment((UUID) parseCallIdAndAttachmentName.first, (String) parseCallIdAndAttachmentName.second), DriveFile.MODE_READ_ONLY);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Got unexpected exception:" + e);
            throw e;
        }
    }

    Pair<UUID, String> parseCallIdAndAttachmentName(Uri uri) {
        try {
            String[] split = uri.getPath().substring(1).split("/");
            String str = split[0];
            return new Pair(UUID.fromString(str), split[1]);
        } catch (Exception e) {
            return null;
        }
    }
}
