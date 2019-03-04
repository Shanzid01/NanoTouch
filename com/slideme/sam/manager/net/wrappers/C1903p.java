package com.slideme.sam.manager.net.wrappers;

import android.os.Bundle;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.Review;
import com.slideme.sam.manager.net.C1599q;
import java.util.ArrayList;

/* compiled from: ReviewLoader */
public class C1903p {
    public boolean f3483a = false;
    private int f3484b = 0;
    private int f3485c = 0;
    private ArrayList<Review> f3486d = new ArrayList();
    private String f3487e;
    private C1599q f3488f;

    public C1903p(String str) {
        this.f3487e = str;
    }

    public void m5734a(C1599q c1599q) {
        this.f3488f = c1599q;
    }

    public void m5732a() {
        SAM.f2614g.m5618a(this.f3487e, this.f3484b * 36, 36, new C1904q(this));
        this.f3484b++;
    }

    public int m5735b() {
        return this.f3485c;
    }

    public ArrayList<Review> m5737c() {
        return this.f3486d;
    }

    public int m5738d() {
        return 36;
    }

    public void m5733a(Bundle bundle) {
        bundle.putInt("page", this.f3484b);
        bundle.putInt("lastcount", this.f3485c);
        bundle.putParcelableArrayList("reviews", this.f3486d);
        bundle.putString("uid", this.f3487e);
    }

    public void m5736b(Bundle bundle) {
        this.f3484b = bundle.getInt("page");
        this.f3485c = bundle.getInt("lastcount");
        this.f3486d = bundle.getParcelableArrayList("reviews");
        this.f3487e = bundle.getString("uid");
    }

    public boolean m5739e() {
        return this.f3483a;
    }
}
