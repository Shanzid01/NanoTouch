package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: CursorAdapter */
class C0154g extends ContentObserver {
    final /* synthetic */ C0149e f489a;

    public C0154g(C0149e c0149e) {
        this.f489a = c0149e;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean z) {
        this.f489a.onContentChanged();
    }
}
