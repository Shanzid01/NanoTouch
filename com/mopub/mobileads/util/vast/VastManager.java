package com.mopub.mobileads.util.vast;

import android.os.AsyncTask;
import com.mopub.common.C1497e;
import com.mopub.common.p050b.C1478a;
import com.mopub.common.p050b.C1486i;
import com.mopub.mobileads.VastVideoDownloadTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VastManager implements VastXmlManagerAggregatorListener {
    private static final List<String> f2560a = Arrays.asList(new String[]{"video/mp4", "video/3gpp"});
    private static final List<String> f2561b = Arrays.asList(new String[]{"image/jpeg", "image/png", "image/bmp", "image/gif"});
    private VastManagerListener f2562c;
    private VastXmlManagerAggregator f2563d;
    private double f2564e;
    private int f2565f;

    public interface VastManagerListener {
        void onVastVideoConfigurationPrepared(C1565c c1565c);
    }

    public void onAggregationComplete(List<C1566d> list) {
        this.f2563d = null;
        if (list != null) {
            C1565c c = m4678c(list);
            if (!m4677a(c)) {
                AsyncTask vastVideoDownloadTask = new VastVideoDownloadTask(new C1564b(this, c));
                try {
                    C1478a.m4050a(vastVideoDownloadTask, c.m4706i());
                } catch (Throwable e) {
                    C1486i.m4077a("Failed to download vast video", e);
                    if (this.f2562c != null) {
                        this.f2562c.onVastVideoConfigurationPrepared(null);
                    }
                }
            } else if (this.f2562c != null) {
                this.f2562c.onVastVideoConfigurationPrepared(c);
            }
        } else if (this.f2562c != null) {
            this.f2562c.onVastVideoConfigurationPrepared(null);
        }
    }

    private boolean m4677a(C1565c c1565c) {
        String i = c1565c.m4706i();
        if (!C1497e.m4095b(i)) {
            return false;
        }
        c1565c.m4695c(C1497e.m4096c(i));
        return true;
    }

    private C1565c m4678c(List<C1566d> list) {
        C1565c c1565c = new C1565c();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (C1566d c1566d : list) {
            c1565c.m4690a(c1566d.m4712b());
            c1565c.m4693b(c1566d.m4713c());
            c1565c.m4696c(c1566d.m4714d());
            c1565c.m4698d(c1566d.m4715e());
            c1565c.m4700e(c1566d.m4716f());
            c1565c.m4702f(c1566d.m4717g());
            c1565c.m4704g(c1566d.m4719i());
            if (c1565c.m4705h() == null) {
                c1565c.m4689a(c1566d.m4718h());
            }
            arrayList.addAll(c1566d.m4720j());
            arrayList2.addAll(c1566d.m4721k());
        }
        c1565c.m4692b(m4679a(arrayList));
        c1565c.m4688a(m4680b(arrayList2));
        return c1565c;
    }

    String m4679a(List<C1568f> list) {
        List arrayList = new ArrayList(list);
        Iterator it = arrayList.iterator();
        String str = null;
        double d = Double.POSITIVE_INFINITY;
        while (it.hasNext()) {
            C1568f c1568f = (C1568f) it.next();
            String c = c1568f.m4730c();
            String d2 = c1568f.m4731d();
            if (!f2560a.contains(c) || d2 == null) {
                it.remove();
            } else {
                Integer a = c1568f.m4728a();
                Integer b = c1568f.m4729b();
                if (a != null && a.intValue() > 0 && b != null && b.intValue() > 0) {
                    double a2 = m4674a(a.intValue(), b.intValue());
                    if (a2 < d) {
                        str = d2;
                        d = a2;
                    }
                }
            }
        }
        if (str != null || arrayList.isEmpty()) {
            return str;
        }
        return ((C1568f) arrayList.get(0)).m4731d();
    }

    C1563a m4680b(List<C1567e> list) {
        C1567e c1567e;
        List arrayList = new ArrayList(list);
        Iterator it = arrayList.iterator();
        double d = Double.POSITIVE_INFINITY;
        C1567e c1567e2 = null;
        while (it.hasNext()) {
            C1567e c1567e3 = (C1567e) it.next();
            String c = c1567e3.m4724c();
            String d2 = c1567e3.m4725d();
            if (!f2561b.contains(c) || d2 == null) {
                it.remove();
            } else {
                Integer a = c1567e3.m4722a();
                Integer b = c1567e3.m4723b();
                if (a != null && a.intValue() > 0 && b != null && b.intValue() > 0) {
                    double a2 = m4674a(a.intValue(), b.intValue());
                    if (a2 < d) {
                        c1567e2 = c1567e3;
                        d = a2;
                    }
                }
            }
        }
        if (c1567e2 != null || arrayList.isEmpty()) {
            c1567e = c1567e2;
        } else {
            c1567e = (C1567e) arrayList.get(0);
        }
        if (c1567e != null) {
            return new C1563a(c1567e.m4722a(), c1567e.m4723b(), c1567e.m4725d(), c1567e.m4726e(), new ArrayList(c1567e.m4727f()));
        }
        return null;
    }

    private double m4674a(int i, int i2) {
        return (Math.abs(Math.log((((double) i) / ((double) i2)) / this.f2564e)) * 40.0d) + (Math.abs(Math.log(((double) (i * i2)) / ((double) this.f2565f))) * 60.0d);
    }
}
