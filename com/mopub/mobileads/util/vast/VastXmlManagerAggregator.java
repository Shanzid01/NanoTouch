package com.mopub.mobileads.util.vast;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import com.mopub.common.C1511s;
import com.mopub.common.p050b.C1486i;
import com.mopub.common.p050b.C1491n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

public class VastXmlManagerAggregator extends AsyncTask<String, Void, List<C1566d>> {
    private final WeakReference<VastXmlManagerAggregatorListener> f2566a;
    private int f2567b;

    interface VastXmlManagerAggregatorListener {
        void onAggregationComplete(List<C1566d> list);
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m4682a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m4683a((List) obj);
    }

    protected List<C1566d> m4682a(String... strArr) {
        AndroidHttpClient a;
        List<C1566d> list;
        Throwable th;
        Throwable e;
        AndroidHttpClient androidHttpClient = null;
        try {
            a = C1511s.m4151a();
            if (strArr != null) {
                try {
                    if (strArr.length > 0) {
                        String str = strArr[0];
                        List<C1566d> arrayList = new ArrayList();
                        while (str != null) {
                            try {
                                if (str.length() <= 0) {
                                    break;
                                } else if (isCancelled()) {
                                    list = arrayList;
                                    break;
                                } else {
                                    C1566d c1566d = new C1566d();
                                    c1566d.m4711a(str);
                                    arrayList.add(c1566d);
                                    str = m4681a(a, c1566d.m4710a());
                                }
                            } catch (Throwable e2) {
                                androidHttpClient = a;
                                th = e2;
                                list = arrayList;
                            } catch (Throwable th2) {
                                e2 = th2;
                            }
                        }
                        list = arrayList;
                        if (a != null) {
                            a.close();
                        }
                        return list;
                    }
                } catch (Throwable e22) {
                    Throwable th3 = e22;
                    list = null;
                    androidHttpClient = a;
                    th = th3;
                    try {
                        C1486i.m4077a("Failed to parse VAST XML", th);
                        if (androidHttpClient != null) {
                            androidHttpClient.close();
                        }
                        return list;
                    } catch (Throwable th4) {
                        e22 = th4;
                        a = androidHttpClient;
                        if (a != null) {
                            a.close();
                        }
                        throw e22;
                    }
                } catch (Throwable th22) {
                    e22 = th22;
                }
            }
            list = null;
            if (a != null) {
                a.close();
            }
        } catch (Throwable e222) {
            th = e222;
            list = null;
            C1486i.m4077a("Failed to parse VAST XML", th);
            if (androidHttpClient != null) {
                androidHttpClient.close();
            }
            return list;
        } catch (Throwable th5) {
            e222 = th5;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e222;
        }
        return list;
    }

    protected void m4683a(List<C1566d> list) {
        VastXmlManagerAggregatorListener vastXmlManagerAggregatorListener = (VastXmlManagerAggregatorListener) this.f2566a.get();
        if (vastXmlManagerAggregatorListener != null) {
            vastXmlManagerAggregatorListener.onAggregationComplete(list);
        }
    }

    protected void onCancelled() {
        VastXmlManagerAggregatorListener vastXmlManagerAggregatorListener = (VastXmlManagerAggregatorListener) this.f2566a.get();
        if (vastXmlManagerAggregatorListener != null) {
            vastXmlManagerAggregatorListener.onAggregationComplete(null);
        }
    }

    String m4681a(AndroidHttpClient androidHttpClient, String str) {
        if (str == null || this.f2567b >= 20) {
            return null;
        }
        this.f2567b++;
        HttpEntity entity = androidHttpClient.execute(new HttpGet(str)).getEntity();
        if (entity != null) {
            return C1491n.m4087a(entity.getContent());
        }
        return null;
    }
}
