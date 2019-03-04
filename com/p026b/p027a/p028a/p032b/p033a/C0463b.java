package com.p026b.p027a.p028a.p032b.p033a;

import android.graphics.Bitmap;
import com.p026b.p027a.p028a.p032b.C0462b;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: LRULimitedMemoryCache */
public class C0463b extends C0462b<String, Bitmap> {
    private final Map<String, Bitmap> f1407a = Collections.synchronizedMap(new LinkedHashMap(10, 1.1f, true));

    protected /* synthetic */ Object mo923c() {
        return m2930d();
    }

    protected /* synthetic */ Reference mo924c(Object obj) {
        return m2924b((Bitmap) obj);
    }

    protected /* synthetic */ int mo925d(Object obj) {
        return m2919a((Bitmap) obj);
    }

    public C0463b(int i) {
        super(i);
    }

    public boolean m2923a(String str, Bitmap bitmap) {
        if (!super.mo921a(str, bitmap)) {
            return false;
        }
        this.f1407a.put(str, bitmap);
        return true;
    }

    public Bitmap m2920a(String str) {
        this.f1407a.get(str);
        return (Bitmap) super.mo919a(str);
    }

    public void m2926b(String str) {
        this.f1407a.remove(str);
        super.mo922b(str);
    }

    protected int m2919a(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    protected Bitmap m2930d() {
        Bitmap bitmap = null;
        synchronized (this.f1407a) {
            Iterator it = this.f1407a.entrySet().iterator();
            if (it.hasNext()) {
                bitmap = (Bitmap) ((Entry) it.next()).getValue();
                it.remove();
            }
        }
        return bitmap;
    }

    protected Reference<Bitmap> m2924b(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }
}
