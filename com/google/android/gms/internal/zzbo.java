package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzgi
public final class zzbo {
    public static final String DEVICE_ID_EMULATOR = zzbe.zzbD().zzX("emulator");
    private final Date zzd;
    private final Set<String> zzf;
    private final Location zzh;
    private final String zzpn;
    private final int zzpo;
    private final boolean zzpp;
    private final Bundle zzpq;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzpr;
    private final String zzps;
    private final String zzpt;
    private final SearchAdRequest zzpu;
    private final int zzpv;
    private final Set<String> zzpw;
    private final Bundle zzpx;
    private final Set<String> zzpy;

    public final class zza {
        private Date zzd;
        private Location zzh;
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzpA = new HashMap();
        private final HashSet<String> zzpB = new HashSet();
        private final HashSet<String> zzpC = new HashSet();
        private String zzpn;
        private int zzpo = -1;
        private boolean zzpp = false;
        private final Bundle zzpq = new Bundle();
        private String zzps;
        private String zzpt;
        private int zzpv = -1;
        private final Bundle zzpx = new Bundle();
        private final HashSet<String> zzpz = new HashSet();

        public void zza(Location location) {
            this.zzh = location;
        }

        @Deprecated
        public void zza(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.zzpA.put(networkExtras.getClass(), networkExtras);
            }
        }

        public void zza(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zzpq.putBundle(cls.getName(), bundle);
        }

        public void zza(Date date) {
            this.zzd = date;
        }

        public void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.zzpq.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.zzpq.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.zzpq.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public void zzc(String str, String str2) {
            this.zzpx.putString(str, str2);
        }

        public void zzh(int i) {
            this.zzpo = i;
        }

        public void zzj(boolean z) {
            this.zzpp = z;
        }

        public void zzk(boolean z) {
            this.zzpv = z ? 1 : 0;
        }

        public void zzr(String str) {
            this.zzpz.add(str);
        }

        public void zzs(String str) {
            this.zzpB.add(str);
        }

        public void zzt(String str) {
            this.zzpB.remove(str);
        }

        public void zzu(String str) {
            this.zzpn = str;
        }

        public void zzv(String str) {
            this.zzps = str;
        }

        public void zzw(String str) {
            this.zzpt = str;
        }

        public void zzx(String str) {
            this.zzpC.add(str);
        }
    }

    public zzbo(zza com_google_android_gms_internal_zzbo_zza) {
        this(com_google_android_gms_internal_zzbo_zza, null);
    }

    public zzbo(zza com_google_android_gms_internal_zzbo_zza, SearchAdRequest searchAdRequest) {
        this.zzd = com_google_android_gms_internal_zzbo_zza.zzd;
        this.zzpn = com_google_android_gms_internal_zzbo_zza.zzpn;
        this.zzpo = com_google_android_gms_internal_zzbo_zza.zzpo;
        this.zzf = Collections.unmodifiableSet(com_google_android_gms_internal_zzbo_zza.zzpz);
        this.zzh = com_google_android_gms_internal_zzbo_zza.zzh;
        this.zzpp = com_google_android_gms_internal_zzbo_zza.zzpp;
        this.zzpq = com_google_android_gms_internal_zzbo_zza.zzpq;
        this.zzpr = Collections.unmodifiableMap(com_google_android_gms_internal_zzbo_zza.zzpA);
        this.zzps = com_google_android_gms_internal_zzbo_zza.zzps;
        this.zzpt = com_google_android_gms_internal_zzbo_zza.zzpt;
        this.zzpu = searchAdRequest;
        this.zzpv = com_google_android_gms_internal_zzbo_zza.zzpv;
        this.zzpw = Collections.unmodifiableSet(com_google_android_gms_internal_zzbo_zza.zzpB);
        this.zzpx = com_google_android_gms_internal_zzbo_zza.zzpx;
        this.zzpy = Collections.unmodifiableSet(com_google_android_gms_internal_zzbo_zza.zzpC);
    }

    public static void updateCorrelator() {
        zzbe.zzbF().zzbG();
    }

    public Date getBirthday() {
        return this.zzd;
    }

    public String getContentUrl() {
        return this.zzpn;
    }

    public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzpq.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return bundle != null ? bundle.getBundle(cls.getClass().getName()) : null;
    }

    public Bundle getCustomTargeting() {
        return this.zzpx;
    }

    public int getGender() {
        return this.zzpo;
    }

    public Set<String> getKeywords() {
        return this.zzf;
    }

    public Location getLocation() {
        return this.zzh;
    }

    public boolean getManualImpressionsEnabled() {
        return this.zzpp;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (NetworkExtras) this.zzpr.get(cls);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> cls) {
        return this.zzpq.getBundle(cls.getName());
    }

    public String getPublisherProvidedId() {
        return this.zzps;
    }

    public boolean isTestDevice(Context context) {
        return this.zzpw.contains(zzbe.zzbD().zzz(context));
    }

    public String zzbH() {
        return this.zzpt;
    }

    public SearchAdRequest zzbI() {
        return this.zzpu;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> zzbJ() {
        return this.zzpr;
    }

    public Bundle zzbK() {
        return this.zzpq;
    }

    public int zzbL() {
        return this.zzpv;
    }

    public Set<String> zzbM() {
        return this.zzpy;
    }
}
