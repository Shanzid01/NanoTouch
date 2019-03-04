package android.support.v4.widget;

import android.database.DataSetObserver;

/* compiled from: CursorAdapter */
class C0155h extends DataSetObserver {
    final /* synthetic */ C0149e f490a;

    private C0155h(C0149e c0149e) {
        this.f490a = c0149e;
    }

    public void onChanged() {
        this.f490a.mDataValid = true;
        this.f490a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f490a.mDataValid = false;
        this.f490a.notifyDataSetInvalidated();
    }
}
