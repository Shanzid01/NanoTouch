package android.support.v7.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

/* compiled from: RecyclerView */
public class aw {
    private SparseArray<ArrayList<bg>> f599a = new SparseArray();
    private SparseIntArray f600b = new SparseIntArray();
    private int f601c = 0;

    public void m1585a() {
        this.f599a.clear();
    }

    public bg m1584a(int i) {
        ArrayList arrayList = (ArrayList) this.f599a.get(i);
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size() - 1;
        bg bgVar = (bg) arrayList.get(size);
        arrayList.remove(size);
        return bgVar;
    }

    public void m1588a(bg bgVar) {
        int f = bgVar.m1680f();
        ArrayList b = m1583b(f);
        if (this.f600b.get(f) > b.size()) {
            bgVar.m1693s();
            b.add(bgVar);
        }
    }

    void m1586a(ak akVar) {
        this.f601c++;
    }

    void m1589b() {
        this.f601c--;
    }

    void m1587a(ak akVar, ak akVar2, boolean z) {
        if (akVar != null) {
            m1589b();
        }
        if (!z && this.f601c == 0) {
            m1585a();
        }
        if (akVar2 != null) {
            m1586a(akVar2);
        }
    }

    private ArrayList<bg> m1583b(int i) {
        ArrayList<bg> arrayList = (ArrayList) this.f599a.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f599a.put(i, arrayList);
            if (this.f600b.indexOfKey(i) < 0) {
                this.f600b.put(i, 5);
            }
        }
        return arrayList;
    }
}
