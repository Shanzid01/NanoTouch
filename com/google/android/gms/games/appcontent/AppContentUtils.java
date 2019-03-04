package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzls;
import java.util.ArrayList;

public final class AppContentUtils {

    interface AppContentRunner {
        void zzb(ArrayList<DataHolder> arrayList, int i);
    }

    final class C10011 implements AppContentRunner {
        final /* synthetic */ ArrayList zzadG;

        C10011(ArrayList arrayList) {
            this.zzadG = arrayList;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            this.zzadG.add(new AppContentActionRef(arrayList, i));
        }
    }

    final class C10022 implements AppContentRunner {
        final /* synthetic */ ArrayList zzadG;

        C10022(ArrayList arrayList) {
            this.zzadG = arrayList;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            this.zzadG.add(new AppContentAnnotationRef(arrayList, i));
        }
    }

    final class C10033 implements AppContentRunner {
        final /* synthetic */ ArrayList zzadG;

        C10033(ArrayList arrayList) {
            this.zzadG = arrayList;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            this.zzadG.add(new AppContentConditionRef(arrayList, i));
        }
    }

    final class C10044 implements AppContentRunner {
        final /* synthetic */ DataHolder zzadH;
        final /* synthetic */ Bundle zzadI;

        C10044(DataHolder dataHolder, Bundle bundle) {
            this.zzadH = dataHolder;
            this.zzadI = bundle;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            AppContentTuple appContentTupleRef = new AppContentTupleRef(this.zzadH, i);
            this.zzadI.putString(appContentTupleRef.getName(), appContentTupleRef.getValue());
        }
    }

    public static ArrayList<AppContentAction> zza(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentAction> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 1, str2, "action_id", i, new C10011(arrayList2), arrayList);
        return arrayList2;
    }

    private static void zza(DataHolder dataHolder, int i, String str, String str2, int i2, AppContentRunner appContentRunner, ArrayList<DataHolder> arrayList) {
        DataHolder dataHolder2 = (DataHolder) arrayList.get(i);
        Object zzc = dataHolder.zzc(str, i2, dataHolder.zzax(i2));
        if (!TextUtils.isEmpty(zzc)) {
            int count = dataHolder2.getCount();
            String[] split = zzc.split(",");
            for (int i3 = 0; i3 < count; i3++) {
                CharSequence zzc2 = dataHolder2.zzc(str2, i3, dataHolder2.zzax(i3));
                if (!TextUtils.isEmpty(zzc2) && zzls.zzb(split, zzc2)) {
                    appContentRunner.zzb(arrayList, i3);
                }
            }
        }
    }

    public static ArrayList<AppContentAnnotation> zzb(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentAnnotation> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 2, str2, "annotation_id", i, new C10022(arrayList2), arrayList);
        return arrayList2;
    }

    public static ArrayList<AppContentCondition> zzc(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentCondition> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 4, str2, "condition_id", i, new C10033(arrayList2), arrayList);
        return arrayList2;
    }

    public static Bundle zzd(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        Bundle bundle = new Bundle();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 3, str2, "tuple_id", i, new C10044((DataHolder) arrayList.get(3), bundle), arrayList);
        return bundle;
    }
}
