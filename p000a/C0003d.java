package p000a;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* compiled from: AppLink */
public class C0003d {
    private Uri f5a;
    private List<C0004e> f6b;
    private Uri f7c;

    public C0003d(Uri uri, List<C0004e> list, Uri uri2) {
        this.f5a = uri;
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f6b = list;
        this.f7c = uri2;
    }
}
