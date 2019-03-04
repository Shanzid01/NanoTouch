package com.mopub.mobileads;

import android.os.AsyncTask;
import android.util.Log;
import com.facebook.AppEventsConstants;
import com.mopub.common.p050b.C1489l;
import com.mopub.mobileads.p051a.C1530j;
import com.mopub.mobileads.util.C1558d;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;

public class AdFetchTask extends AsyncTask<String, Void, C1534c> {
    private static /* synthetic */ int[] f2244h;
    private TaskTracker f2245a;
    private AdViewController f2246b;
    private Exception f2247c;
    private HttpClient f2248d;
    private long f2249e;
    private String f2250f;
    private C1533b f2251g = C1533b.NOT_SET;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m4219a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m4220a((C1534c) obj);
    }

    static /* synthetic */ int[] m4212a() {
        int[] iArr = f2244h;
        if (iArr == null) {
            iArr = new int[C1533b.values().length];
            try {
                iArr[C1533b.AD_WARMING_UP.ordinal()] = 6;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C1533b.CLEAR_AD_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1533b.FETCH_CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C1533b.INVALID_SERVER_RESPONSE_BACKOFF.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[C1533b.INVALID_SERVER_RESPONSE_NOBACKOFF.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[C1533b.NOT_SET.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            f2244h = iArr;
        }
        return iArr;
    }

    public AdFetchTask(TaskTracker taskTracker, AdViewController adViewController, String str, int i) {
        this.f2245a = taskTracker;
        this.f2246b = adViewController;
        this.f2248d = C1530j.m4492a(i);
        this.f2249e = this.f2245a.m4412a();
        this.f2250f = str;
    }

    protected C1534c m4219a(String... strArr) {
        C1534c c1534c = null;
        try {
            c1534c = m4210a(strArr[0]);
        } catch (Exception e) {
            this.f2247c = e;
        } finally {
            m4217e();
        }
        return c1534c;
    }

    private C1534c m4210a(String str) {
        HttpUriRequest httpGet = new HttpGet(str);
        httpGet.addHeader(C1489l.USER_AGENT.getKey(), this.f2250f);
        if (!m4213b()) {
            return null;
        }
        HttpResponse execute = this.f2248d.execute(httpGet);
        if (!m4214b(execute)) {
            return null;
        }
        this.f2246b.m4242a(execute);
        if (m4211a(execute)) {
            return C1534c.m4625a(execute, this.f2246b);
        }
        return null;
    }

    private boolean m4211a(HttpResponse httpResponse) {
        if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(C1558d.m4662a(httpResponse, C1489l.WARMUP))) {
            Log.d("MoPub", "Ad Unit (" + this.f2246b.m4256e() + ") is still warming up. " + "Please try again in a few minutes.");
            this.f2251g = C1533b.AD_WARMING_UP;
            return false;
        }
        if (!"clear".equals(C1558d.m4662a(httpResponse, C1489l.AD_TYPE))) {
            return true;
        }
        Log.d("MoPub", "No inventory found for adunit (" + this.f2246b.m4256e() + ").");
        this.f2251g = C1533b.CLEAR_AD_TYPE;
        return false;
    }

    private boolean m4214b(HttpResponse httpResponse) {
        if (httpResponse == null || httpResponse.getEntity() == null) {
            Log.d("MoPub", "MoPub server returned null response.");
            this.f2251g = C1533b.INVALID_SERVER_RESPONSE_NOBACKOFF;
            return false;
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode >= 400) {
            Log.d("MoPub", "Server error: returned HTTP status code " + Integer.toString(statusCode) + ". Please try again.");
            this.f2251g = C1533b.INVALID_SERVER_RESPONSE_BACKOFF;
            return false;
        } else if (statusCode == 200) {
            return true;
        } else {
            Log.d("MoPub", "MoPub server returned invalid response: HTTP status code " + Integer.toString(statusCode) + ".");
            this.f2251g = C1533b.INVALID_SERVER_RESPONSE_NOBACKOFF;
            return false;
        }
    }

    private boolean m4213b() {
        if (isCancelled()) {
            this.f2251g = C1533b.FETCH_CANCELLED;
            return false;
        } else if (this.f2246b != null && !this.f2246b.m4265n()) {
            return true;
        } else {
            Log.d("MoPub", "Error loading ad: AdViewController has already been GCed or destroyed.");
            return false;
        }
    }

    protected void m4220a(C1534c c1534c) {
        if (!m4218f()) {
            Log.d("MoPub", "Ad response is stale.");
            m4216d();
        } else if (this.f2246b == null || this.f2246b.m4265n()) {
            if (c1534c != null) {
                c1534c.mo4143b();
            }
            this.f2245a.m4413a(this.f2249e);
            m4216d();
        } else {
            if (c1534c == null) {
                MoPubErrorCode moPubErrorCode;
                if (this.f2247c != null) {
                    Log.d("MoPub", "Exception caught while loading ad: " + this.f2247c);
                }
                switch (m4212a()[this.f2251g.ordinal()]) {
                    case 1:
                        moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
                        break;
                    case 2:
                        moPubErrorCode = MoPubErrorCode.CANCELLED;
                        break;
                    case 3:
                    case 4:
                        moPubErrorCode = MoPubErrorCode.SERVER_ERROR;
                        break;
                    case 5:
                    case 6:
                        moPubErrorCode = MoPubErrorCode.NO_FILL;
                        break;
                    default:
                        moPubErrorCode = MoPubErrorCode.UNSPECIFIED;
                        break;
                }
                this.f2246b.m4247b(moPubErrorCode);
                if (this.f2251g == C1533b.INVALID_SERVER_RESPONSE_BACKOFF) {
                    m4215c();
                    this.f2251g = C1533b.NOT_SET;
                }
            } else {
                c1534c.mo4142a();
                c1534c.mo4143b();
            }
            this.f2245a.m4413a(this.f2249e);
            m4216d();
        }
    }

    protected void onCancelled() {
        if (m4218f()) {
            Log.d("MoPub", "Ad loading was cancelled.");
            if (this.f2247c != null) {
                Log.d("MoPub", "Exception caught while loading ad: " + this.f2247c);
            }
            this.f2245a.m4413a(this.f2249e);
            m4216d();
            return;
        }
        Log.d("MoPub", "Ad response is stale.");
        m4216d();
    }

    private void m4215c() {
        int i = 600000;
        if (this.f2246b != null) {
            int q = (int) (((double) this.f2246b.m4268q()) * 1.5d);
            if (q <= 600000) {
                i = q;
            }
            this.f2246b.m4251c(i);
        }
    }

    private void m4216d() {
        this.f2245a = null;
        this.f2247c = null;
        this.f2251g = C1533b.NOT_SET;
    }

    private void m4217e() {
        if (this.f2248d != null) {
            ClientConnectionManager connectionManager = this.f2248d.getConnectionManager();
            if (connectionManager != null) {
                connectionManager.shutdown();
            }
            this.f2248d = null;
        }
    }

    private boolean m4218f() {
        return this.f2245a == null ? false : this.f2245a.m4415b(this.f2249e);
    }
}
