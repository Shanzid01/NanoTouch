package com.p026b.p027a.p034b.p037b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.p026b.p027a.p034b.p035a.C0477e;
import com.p026b.p027a.p034b.p035a.C0478f;
import com.p026b.p027a.p041c.C0521a;
import com.p026b.p027a.p041c.C0523c;
import com.p026b.p027a.p041c.C0524d;
import java.io.InputStream;

/* compiled from: BaseImageDecoder */
public class C0488a implements C0487d {
    protected boolean f1435a;

    public C0488a(boolean z) {
        this.f1435a = z;
    }

    public Bitmap mo934a(C0491e c0491e) {
        C0490c a = m2993a(m2994b(c0491e), c0491e.m2999b());
        Bitmap a2 = m2990a(m2994b(c0491e), m2991a(a.f1438a, c0491e));
        if (a2 != null) {
            return m2988a(a2, c0491e, a.f1439b.f1436a, a.f1439b.f1437b);
        }
        C0524d.m3155d("Image can't be decoded [%s]", c0491e.m2998a());
        return a2;
    }

    protected InputStream m2994b(C0491e c0491e) {
        return c0491e.m3003f().mo936a(c0491e.m2999b(), c0491e.m3004g());
    }

    protected C0490c m2993a(InputStream inputStream, String str) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            C0489b a;
            BitmapFactory.decodeStream(inputStream, null, options);
            if (VERSION.SDK_INT >= 5) {
                a = m2992a(str, options.outMimeType);
            } else {
                a = new C0489b();
            }
            return new C0490c(new C0478f(options.outWidth, options.outHeight, a.f1436a), a);
        } finally {
            C0523c.m3148a(inputStream);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.p026b.p027a.p034b.p037b.C0489b m2992a(java.lang.String r7, java.lang.String r8) {
        /*
        r6 = this;
        r1 = 0;
        r0 = 1;
        r2 = "image/jpeg";
        r2 = r2.equalsIgnoreCase(r8);
        if (r2 == 0) goto L_0x0047;
    L_0x000a:
        r2 = com.p026b.p027a.p034b.p039d.C0501d.ofUri(r7);
        r3 = com.p026b.p027a.p034b.p039d.C0501d.FILE;
        if (r2 != r3) goto L_0x0047;
    L_0x0012:
        r2 = new android.media.ExifInterface;	 Catch:{ IOException -> 0x003d }
        r3 = com.p026b.p027a.p034b.p039d.C0501d.FILE;	 Catch:{ IOException -> 0x003d }
        r3 = r3.crop(r7);	 Catch:{ IOException -> 0x003d }
        r2.<init>(r3);	 Catch:{ IOException -> 0x003d }
        r3 = "Orientation";
        r4 = 1;
        r2 = r2.getAttributeInt(r3, r4);	 Catch:{ IOException -> 0x003d }
        switch(r2) {
            case 1: goto L_0x0027;
            case 2: goto L_0x0028;
            case 3: goto L_0x0035;
            case 4: goto L_0x0036;
            case 5: goto L_0x003a;
            case 6: goto L_0x0031;
            case 7: goto L_0x0032;
            case 8: goto L_0x0039;
            default: goto L_0x0027;
        };
    L_0x0027:
        r0 = r1;
    L_0x0028:
        r5 = r0;
        r0 = r1;
        r1 = r5;
    L_0x002b:
        r2 = new com.b.a.b.b.b;
        r2.<init>(r0, r1);
        return r2;
    L_0x0031:
        r0 = r1;
    L_0x0032:
        r1 = 90;
        goto L_0x0028;
    L_0x0035:
        r0 = r1;
    L_0x0036:
        r1 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        goto L_0x0028;
    L_0x0039:
        r0 = r1;
    L_0x003a:
        r1 = 270; // 0x10e float:3.78E-43 double:1.334E-321;
        goto L_0x0028;
    L_0x003d:
        r2 = move-exception;
        r2 = "Can't read EXIF tags from file [%s]";
        r0 = new java.lang.Object[r0];
        r0[r1] = r7;
        com.p026b.p027a.p041c.C0524d.m3154c(r2, r0);
    L_0x0047:
        r0 = r1;
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.b.b.a.a(java.lang.String, java.lang.String):com.b.a.b.b.b");
    }

    protected Options m2991a(C0478f c0478f, C0491e c0491e) {
        int i = 1;
        C0477e d = c0491e.m3001d();
        C0478f c = c0491e.m3000c();
        if (d != C0477e.NONE) {
            int a = C0521a.m3144a(c0478f, c, c0491e.m3002e(), d == C0477e.IN_SAMPLE_POWER_OF_2);
            if (this.f1435a) {
                C0524d.m3153b("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", c0478f, c0478f.m2969a(a), Integer.valueOf(a), c0491e.m2998a());
            }
            i = a;
        }
        Options h = c0491e.m3005h();
        h.inSampleSize = i;
        return h;
    }

    protected Bitmap m2990a(InputStream inputStream, Options options) {
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            return decodeStream;
        } finally {
            C0523c.m3148a(inputStream);
        }
    }

    protected Bitmap m2988a(Bitmap bitmap, C0491e c0491e, int i, boolean z) {
        Matrix matrix = new Matrix();
        C0477e d = c0491e.m3001d();
        if (d == C0477e.EXACTLY || d == C0477e.EXACTLY_STRETCHED) {
            float b = C0521a.m3147b(new C0478f(bitmap.getWidth(), bitmap.getHeight(), i), c0491e.m3000c(), c0491e.m3002e(), d == C0477e.EXACTLY_STRETCHED);
            if (Float.compare(b, TextTrackStyle.DEFAULT_FONT_SCALE) != 0) {
                matrix.setScale(b, b);
                if (this.f1435a) {
                    C0524d.m3153b("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", r2, r2.m2968a(b), Float.valueOf(b), c0491e.m2998a());
                }
            }
        }
        if (z) {
            matrix.postScale(GroundOverlayOptions.NO_DIMENSION, TextTrackStyle.DEFAULT_FONT_SCALE);
            if (this.f1435a) {
                C0524d.m3153b("Flip image horizontally [%s]", c0491e.m2998a());
            }
        }
        if (i != 0) {
            matrix.postRotate((float) i);
            if (this.f1435a) {
                C0524d.m3153b("Rotate image on %1$d° [%2$s]", Integer.valueOf(i), c0491e.m2998a());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
