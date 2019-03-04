package com.p026b.p027a.p034b.p039d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import com.google.android.gms.fitness.FitnessStatusCodes;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: BaseImageDownloader */
public class C0499a implements C0498c {
    protected final Context f1462a;
    protected final int f1463b = FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS;
    protected final int f1464c = 20000;

    public C0499a(Context context) {
        this.f1462a = context.getApplicationContext();
    }

    public InputStream mo936a(String str, Object obj) {
        switch (C0500b.f1465a[C0501d.ofUri(str).ordinal()]) {
            case 1:
            case 2:
                return m3016b(str, obj);
            case 3:
                return m3017c(str, obj);
            case 4:
                return m3018d(str, obj);
            case 5:
                return m3019e(str, obj);
            case 6:
                return m3020f(str, obj);
            default:
                return m3021g(str, obj);
        }
    }

    protected InputStream m3016b(String str, Object obj) {
        HttpURLConnection a = m3014a(str);
        int i = 0;
        while (a.getResponseCode() / 100 == 3 && i < 5) {
            a = m3014a(a.getHeaderField("Location"));
            i++;
        }
        return new BufferedInputStream(a.getInputStream(), 8192);
    }

    private HttpURLConnection m3014a(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).openConnection();
        httpURLConnection.setConnectTimeout(this.f1463b);
        httpURLConnection.setReadTimeout(this.f1464c);
        httpURLConnection.connect();
        return httpURLConnection;
    }

    protected InputStream m3017c(String str, Object obj) {
        return new BufferedInputStream(new FileInputStream(C0501d.FILE.crop(str)), 8192);
    }

    protected InputStream m3018d(String str, Object obj) {
        return this.f1462a.getContentResolver().openInputStream(Uri.parse(str));
    }

    protected InputStream m3019e(String str, Object obj) {
        return this.f1462a.getAssets().open(C0501d.ASSETS.crop(str));
    }

    protected InputStream m3020f(String str, Object obj) {
        Bitmap bitmap = ((BitmapDrawable) this.f1462a.getResources().getDrawable(Integer.parseInt(C0501d.DRAWABLE.crop(str)))).getBitmap();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    protected InputStream m3021g(String str, Object obj) {
        throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[]{str}));
    }
}
