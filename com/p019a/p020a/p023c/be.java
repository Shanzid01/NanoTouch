package com.p019a.p020a.p023c;

import com.p019a.p020a.p023c.p024a.p025a.C0380a;
import com.p019a.p020a.p023c.p024a.p025a.C0381b;
import com.p019a.p020a.p023c.p024a.p025a.C0382c;
import com.p019a.p020a.p023c.p024a.p025a.C0383d;
import com.p019a.p020a.p023c.p024a.p025a.C0384e;
import com.p019a.p020a.p023c.p024a.p025a.C0385f;
import com.p019a.p020a.p023c.p024a.p025a.C0386g;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: NativeCrashWriter */
class be {
    private static final C0384e f1255a = new C0384e("", "", 0);
    private static final bo[] f1256b = new bo[0];
    private static final br[] f1257c = new br[0];
    private static final bl[] f1258d = new bl[0];
    private static final bg[] f1259e = new bg[0];
    private static final bh[] f1260f = new bh[0];

    private static bj m2609a(C0383d c0383d, az azVar, Map<String, String> map) {
        bf bfVar = new bf(new bk(new bq(c0383d.f1195b != null ? c0383d.f1195b : f1255a), be.m2612a(c0383d.f1196c), be.m2610a(c0383d.f1197d)), be.m2611a(be.m2615a(c0383d.f1198e, map)));
        bi a = be.m2608a(c0383d.f1199f);
        C0389b a2 = azVar.m2582a();
        if (a2 == null) {
            C0326f.m2298h().mo511a("CrashlyticsCore", "No log data to include with this event.");
        }
        azVar.m2587b();
        bm bmVar = a2 != null ? new bm(a2) : new bn();
        return new bj(c0383d.f1194a, "ndk-crash", bfVar, a, bmVar);
    }

    private static C0381b[] m2615a(C0381b[] c0381bArr, Map<String, String> map) {
        int i;
        Map treeMap = new TreeMap(map);
        if (c0381bArr != null) {
            for (C0381b c0381b : c0381bArr) {
                treeMap.put(c0381b.f1184a, c0381b.f1185b);
            }
        }
        Entry[] entryArr = (Entry[]) treeMap.entrySet().toArray(new Entry[treeMap.size()]);
        C0381b[] c0381bArr2 = new C0381b[entryArr.length];
        for (i = 0; i < c0381bArr2.length; i++) {
            c0381bArr2[i] = new C0381b((String) entryArr[i].getKey(), (String) entryArr[i].getValue());
        }
        return c0381bArr2;
    }

    private static bi m2608a(C0382c c0382c) {
        return new bi(((float) c0382c.f1191f) / 100.0f, c0382c.f1192g, c0382c.f1193h, c0382c.f1186a, c0382c.f1187b - c0382c.f1189d, c0382c.f1188c - c0382c.f1190e);
    }

    private static bp m2612a(C0385f[] c0385fArr) {
        bo[] boVarArr = c0385fArr != null ? new br[c0385fArr.length] : f1257c;
        for (int i = 0; i < boVarArr.length; i++) {
            C0385f c0385f = c0385fArr[i];
            boVarArr[i] = new br(c0385f, be.m2613a(c0385f.f1205c));
        }
        return new bp(boVarArr);
    }

    private static bp m2613a(C0386g[] c0386gArr) {
        bo[] boVarArr = c0386gArr != null ? new bl[c0386gArr.length] : f1258d;
        for (int i = 0; i < boVarArr.length; i++) {
            boVarArr[i] = new bl(c0386gArr[i]);
        }
        return new bp(boVarArr);
    }

    private static bp m2610a(C0380a[] c0380aArr) {
        bo[] boVarArr = c0380aArr != null ? new bg[c0380aArr.length] : f1259e;
        for (int i = 0; i < boVarArr.length; i++) {
            boVarArr[i] = new bg(c0380aArr[i]);
        }
        return new bp(boVarArr);
    }

    private static bp m2611a(C0381b[] c0381bArr) {
        bo[] boVarArr = c0381bArr != null ? new bh[c0381bArr.length] : f1260f;
        for (int i = 0; i < boVarArr.length; i++) {
            boVarArr[i] = new bh(c0381bArr[i]);
        }
        return new bp(boVarArr);
    }

    public static void m2614a(C0383d c0383d, az azVar, Map<String, String> map, C0393f c0393f) {
        be.m2609a(c0383d, azVar, map).mo557b(c0393f);
    }
}
