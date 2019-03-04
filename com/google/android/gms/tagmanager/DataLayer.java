package com.google.android.gms.tagmanager;

import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] zzayd = "gtm.lifetime".toString().split("\\.");
    private static final Pattern zzaye = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<zzb, Integer> zzayf;
    private final Map<String, Object> zzayg;
    private final ReentrantLock zzayh;
    private final LinkedList<Map<String, Object>> zzayi;
    private final zzc zzayj;
    private final CountDownLatch zzayk;

    interface zzc {

        public interface zza {
            void zzq(List<zza> list);
        }

        void zza(zza com_google_android_gms_tagmanager_DataLayer_zzc_zza);

        void zza(List<zza> list, long j);

        void zzcW(String str);
    }

    class C14061 implements zzc {
        C14061() {
        }

        public void zza(zza com_google_android_gms_tagmanager_DataLayer_zzc_zza) {
            com_google_android_gms_tagmanager_DataLayer_zzc_zza.zzq(new ArrayList());
        }

        public void zza(List<zza> list, long j) {
        }

        public void zzcW(String str) {
        }
    }

    class C14072 implements zza {
        final /* synthetic */ DataLayer zzayl;

        C14072(DataLayer dataLayer) {
            this.zzayl = dataLayer;
        }

        public void zzq(List<zza> list) {
            for (zza com_google_android_gms_tagmanager_DataLayer_zza : list) {
                this.zzayl.zzK(this.zzayl.zzc(com_google_android_gms_tagmanager_DataLayer_zza.zzqd, com_google_android_gms_tagmanager_DataLayer_zza.zzzt));
            }
            this.zzayl.zzayk.countDown();
        }
    }

    final class zza {
        public final String zzqd;
        public final Object zzzt;

        zza(String str, Object obj) {
            this.zzqd = str;
            this.zzzt = obj;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_tagmanager_DataLayer_zza = (zza) obj;
            return this.zzqd.equals(com_google_android_gms_tagmanager_DataLayer_zza.zzqd) && this.zzzt.equals(com_google_android_gms_tagmanager_DataLayer_zza.zzzt);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.zzqd.hashCode()), Integer.valueOf(this.zzzt.hashCode())});
        }

        public String toString() {
            return "Key: " + this.zzqd + " value: " + this.zzzt.toString();
        }
    }

    interface zzb {
        void zzI(Map<String, Object> map);
    }

    DataLayer() {
        this(new C14061());
    }

    DataLayer(zzc com_google_android_gms_tagmanager_DataLayer_zzc) {
        this.zzayj = com_google_android_gms_tagmanager_DataLayer_zzc;
        this.zzayf = new ConcurrentHashMap();
        this.zzayg = new HashMap();
        this.zzayh = new ReentrantLock();
        this.zzayi = new LinkedList();
        this.zzayk = new CountDownLatch(1);
        zzsU();
    }

    public static List<Object> listOf(Object... objArr) {
        List<Object> arrayList = new ArrayList();
        for (Object add : objArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Map<String, Object> mapOf(Object... objArr) {
        if (objArr.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        Map<String, Object> hashMap = new HashMap();
        int i = 0;
        while (i < objArr.length) {
            if (objArr[i] instanceof String) {
                hashMap.put((String) objArr[i], objArr[i + 1]);
                i += 2;
            } else {
                throw new IllegalArgumentException("key is not a string: " + objArr[i]);
            }
        }
        return hashMap;
    }

    private void zzK(Map<String, Object> map) {
        this.zzayh.lock();
        try {
            this.zzayi.offer(map);
            if (this.zzayh.getHoldCount() == 1) {
                zzsV();
            }
            zzL(map);
        } finally {
            this.zzayh.unlock();
        }
    }

    private void zzL(Map<String, Object> map) {
        Long zzM = zzM(map);
        if (zzM != null) {
            List zzO = zzO(map);
            zzO.remove("gtm.lifetime");
            this.zzayj.zza(zzO, zzM.longValue());
        }
    }

    private Long zzM(Map<String, Object> map) {
        Object zzN = zzN(map);
        return zzN == null ? null : zzcV(zzN.toString());
    }

    private Object zzN(Map<String, Object> map) {
        String[] strArr = zzayd;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    private List<zza> zzO(Map<String, Object> map) {
        Object arrayList = new ArrayList();
        zza(map, "", arrayList);
        return arrayList;
    }

    private void zzP(Map<String, Object> map) {
        synchronized (this.zzayg) {
            for (String str : map.keySet()) {
                zza(zzc(str, map.get(str)), this.zzayg);
            }
        }
        zzQ(map);
    }

    private void zzQ(Map<String, Object> map) {
        for (zzb zzI : this.zzayf.keySet()) {
            zzI.zzI(map);
        }
    }

    private void zza(Map<String, Object> map, String str, Collection<zza> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                zza((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new zza(str2, entry.getValue()));
            }
        }
    }

    static Long zzcV(String str) {
        Matcher matcher = zzaye.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                zzbf.zzac("illegal number in _lifetime value: " + str);
                parseLong = 0;
            }
            if (parseLong <= 0) {
                zzbf.zzaa("non-positive _lifetime: " + str);
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case 'd':
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case 'm':
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    zzbf.zzac("unknown units in _lifetime: " + str);
                    return null;
            }
        }
        zzbf.zzaa("unknown _lifetime: " + str);
        return null;
    }

    private void zzsU() {
        this.zzayj.zza(new C14072(this));
    }

    private void zzsV() {
        int i = 0;
        while (true) {
            Map map = (Map) this.zzayi.poll();
            if (map != null) {
                zzP(map);
                int i2 = i + 1;
                if (i2 > 500) {
                    this.zzayi.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    public Object get(String str) {
        synchronized (this.zzayg) {
            Map map = this.zzayg;
            String[] split = str.split("\\.");
            int length = split.length;
            Object obj = map;
            int i = 0;
            while (i < length) {
                Object obj2 = split[i];
                if (obj instanceof Map) {
                    obj2 = ((Map) obj).get(obj2);
                    if (obj2 == null) {
                        return null;
                    }
                    i++;
                    obj = obj2;
                } else {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String str, Object obj) {
        push(zzc(str, obj));
    }

    public void push(Map<String, Object> map) {
        try {
            this.zzayk.await();
        } catch (InterruptedException e) {
            zzbf.zzac("DataLayer.push: unexpected InterruptedException");
        }
        zzK(map);
    }

    public void pushEvent(String str, Map<String, Object> map) {
        Map hashMap = new HashMap(map);
        hashMap.put("event", str);
        push(hashMap);
    }

    public String toString() {
        String stringBuilder;
        synchronized (this.zzayg) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : this.zzayg.entrySet()) {
                stringBuilder2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{entry.getKey(), entry.getValue()}));
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    void zza(zzb com_google_android_gms_tagmanager_DataLayer_zzb) {
        this.zzayf.put(com_google_android_gms_tagmanager_DataLayer_zzb, Integer.valueOf(0));
    }

    void zza(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                zzb((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                zza((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    void zzb(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                zzb((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                zza((Map) obj, (Map) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    Map<String, Object> zzc(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }

    void zzcU(String str) {
        push(str, null);
        this.zzayj.zzcW(str);
    }
}
