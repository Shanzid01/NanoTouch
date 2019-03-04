package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.facebook.AppEventsConstants;
import com.google.android.gms.analytics.HitBuilders.HitBuilder;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.zzik;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class zzx extends Thread implements zzf {
    private volatile boolean mClosed;
    private final GoogleAnalytics zzBN;
    private final LinkedBlockingQueue<Runnable> zzCJ = new LinkedBlockingQueue();
    private volatile boolean zzCK;
    private volatile String zzCL;
    private volatile zzak zzCM;
    private final Lock zzCN;
    private final List<zzik> zzCO = new ArrayList();

    class zza implements Runnable {
        final /* synthetic */ zzx zzCP;

        private zza(zzx com_google_android_gms_analytics_zzx) {
            this.zzCP = com_google_android_gms_analytics_zzx;
        }

        public void run() {
            this.zzCP.zzCM.zzfa();
        }
    }

    class zzb implements Runnable {
        final /* synthetic */ zzx zzCP;

        private zzb(zzx com_google_android_gms_analytics_zzx) {
            this.zzCP = com_google_android_gms_analytics_zzx;
        }

        public void run() {
            this.zzCP.zzCM.dispatch();
        }
    }

    class zzc implements Runnable {
        final /* synthetic */ zzx zzCP;

        private zzc(zzx com_google_android_gms_analytics_zzx) {
            this.zzCP = com_google_android_gms_analytics_zzx;
        }

        public void run() {
            this.zzCP.zzCM.zzfh();
        }
    }

    class zzd implements Runnable {
        final /* synthetic */ zzx zzCP;
        private final Map<String, String> zzCQ;

        zzd(zzx com_google_android_gms_analytics_zzx, Map<String, String> map) {
            this.zzCP = com_google_android_gms_analytics_zzx;
            this.zzCQ = new HashMap(map);
            String str = (String) map.get("&ht");
            if (str != null) {
                try {
                    Long.valueOf(str);
                } catch (NumberFormatException e) {
                    str = null;
                }
            }
            if (str == null) {
                this.zzCQ.put("&ht", Long.toString(System.currentTimeMillis()));
            }
        }

        private void zzA(Map<String, String> map) {
            zzq zzgo = this.zzCP.zzBN.zzgo();
            zzan.zza((Map) map, "&an", zzgo);
            zzan.zza((Map) map, "&av", zzgo);
            zzan.zza((Map) map, "&aid", zzgo);
            zzan.zza((Map) map, "&aiid", zzgo);
            map.put("&v", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }

        private boolean zzB(Map<String, String> map) {
            if (map.get("&sf") == null) {
                return false;
            }
            double zza = zzan.zza((String) map.get("&sf"), 100.0d);
            if (zza >= 100.0d) {
                return false;
            }
            if (((double) (zzx.zzan((String) map.get("&cid")) % 10000)) < zza * 100.0d) {
                return false;
            }
            String str = map.get("&t") == null ? FitnessActivities.UNKNOWN : (String) map.get("&t");
            zzae.zzab(String.format("%s hit sampled out", new Object[]{str}));
            return true;
        }

        private String zzy(Map<String, String> map) {
            return map.containsKey("useSecure") ? zzan.zze((String) map.get("useSecure"), true) ? "https:" : "http:" : "https:";
        }

        private void zzz(Map<String, String> map) {
            this.zzCP.zzBN.getContext();
            zzq zzgq = this.zzCP.zzBN.zzgq();
            zzan.zza((Map) map, "&adid", zzgq);
            zzan.zza((Map) map, "&ate", zzgq);
        }

        public void run() {
            zzz(this.zzCQ);
            if (TextUtils.isEmpty((CharSequence) this.zzCQ.get("&cid"))) {
                this.zzCQ.put("&cid", this.zzCP.zzBN.zzgp().getValue("&cid"));
            }
            if (!this.zzCP.zzBN.getAppOptOut() && !zzB(this.zzCQ)) {
                if (!TextUtils.isEmpty(this.zzCP.zzCL)) {
                    zzy.zzfV().zzF(true);
                    HitBuilder campaignParamsFromUrl = new HitBuilder().setCampaignParamsFromUrl(this.zzCP.zzCL);
                    this.zzCP.zzCL = null;
                    Map build = campaignParamsFromUrl.build();
                    zzy.zzfV().zzF(false);
                    this.zzCQ.putAll(build);
                }
                zzA(this.zzCQ);
                this.zzCP.zzCM.zzb(zzac.zzC(this.zzCQ), Long.valueOf((String) this.zzCQ.get("&ht")).longValue(), zzy(this.zzCQ), this.zzCP.zzCO);
            }
        }
    }

    zzx(GoogleAnalytics googleAnalytics, zzak com_google_android_gms_analytics_zzak) {
        super("GAThread");
        com.google.android.gms.common.internal.zzx.zzl(googleAnalytics);
        this.zzBN = googleAnalytics;
        this.zzCM = com_google_android_gms_analytics_zzak;
        this.zzCO.add(new zzik(Command.APPEND_VERSION, "&_v".substring(1), "ma4.0.6"));
        this.zzCN = new ReentrantLock();
        start();
    }

    static String zzH(Context context) {
        FileInputStream openFileInput;
        Throwable th;
        try {
            openFileInput = context.openFileInput("gaInstallData");
            try {
                byte[] bArr = new byte[8192];
                int read = openFileInput.read(bArr, 0, 8192);
                if (openFileInput.available() > 0) {
                    zzae.zzZ("Too much campaign data, ignoring it.");
                    openFileInput.close();
                    openFileInput = null;
                    context.deleteFile("gaInstallData");
                    if (null == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e) {
                        zzae.zzZ("Failed to close campaign data in stream: " + e);
                        return null;
                    }
                }
                openFileInput.close();
                FileInputStream fileInputStream = null;
                context.deleteFile("gaInstallData");
                if (read <= 0) {
                    zzae.zzac("Campaign file is empty.");
                    if (null == null) {
                        return null;
                    }
                    try {
                        fileInputStream.close();
                        return null;
                    } catch (IOException e2) {
                        zzae.zzZ("Failed to close campaign data in stream: " + e2);
                        return null;
                    }
                }
                String str = new String(bArr, 0, read);
                zzae.zzaa("Campaign found: " + str);
                if (null != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        zzae.zzZ("Failed to close campaign data in stream: " + e3);
                    }
                }
                return str;
            } catch (FileNotFoundException e4) {
                try {
                    zzae.zzaa("No campaign data found.");
                    if (openFileInput != null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e22) {
                        zzae.zzZ("Failed to close campaign data in stream: " + e22);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e222) {
                            zzae.zzZ("Failed to close campaign data in stream: " + e222);
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                zzae.zzZ("Error reading campaign data.");
                context.deleteFile("gaInstallData");
                if (openFileInput != null) {
                    return null;
                }
                try {
                    openFileInput.close();
                    return null;
                } catch (IOException e2222) {
                    zzae.zzZ("Failed to close campaign data in stream: " + e2222);
                    return null;
                }
            }
        } catch (FileNotFoundException e6) {
            openFileInput = null;
            zzae.zzaa("No campaign data found.");
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (IOException e7) {
            openFileInput = null;
            zzae.zzZ("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            openFileInput = null;
            th = th4;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw th;
        }
    }

    static int zzan(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    private void zzc(Runnable runnable) {
        this.zzCJ.add(runnable);
    }

    private String zzf(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void dispatch() {
        zzc(new zzb());
    }

    public Thread getThread() {
        return this;
    }

    protected synchronized void init() {
        if (this.zzCM == null) {
            this.zzCM = new zzw(this.zzBN.getContext(), this);
            this.zzCM.zzfM();
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            zzae.zzac("sleep interrupted in GAThread initialize");
        }
        try {
            init();
            this.zzCL = zzH(this.zzBN.getContext());
            zzae.zzab("Initialized GA Thread");
        } catch (Throwable th) {
            zzae.zzZ("Error initializing the GAThread: " + zzf(th));
            zzae.zzZ("Google Analytics will not start up.");
            this.zzCK = true;
        }
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.zzCJ.take();
                this.zzCN.lock();
                if (!this.zzCK) {
                    runnable.run();
                }
                this.zzCN.unlock();
            } catch (InterruptedException e2) {
                zzae.zzaa(e2.toString());
            } catch (Throwable th2) {
                zzae.zzZ("Error on GAThread: " + zzf(th2));
                zzae.zzZ("Google Analytics is shutting down.");
                this.zzCK = true;
            }
        }
    }

    public void zzfa() {
        zzc(new zza());
    }

    public void zzfh() {
        zzc(new zzc());
    }

    public LinkedBlockingQueue<Runnable> zzfi() {
        return this.zzCJ;
    }

    public void zzfj() {
        init();
        Object<Runnable> arrayList = new ArrayList();
        this.zzCJ.drainTo(arrayList);
        this.zzCN.lock();
        try {
            this.zzCK = true;
            for (Runnable run : arrayList) {
                run.run();
            }
        } catch (Throwable th) {
            this.zzCN.unlock();
        }
        this.zzCN.unlock();
    }

    public void zzx(Map<String, String> map) {
        zzc(new zzd(this, map));
    }
}
