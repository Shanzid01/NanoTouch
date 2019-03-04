package android.support.v7.widget;

import android.database.Observable;

/* compiled from: RecyclerView */
class al extends Observable<am> {
    al() {
    }

    public void m1539a() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((am) this.mObservers.get(size)).mo447a();
        }
    }
}
