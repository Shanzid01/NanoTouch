package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import java.util.ArrayList;

public abstract class MultiDataBufferRef extends zzd {
    protected final ArrayList<DataHolder> zzadC;

    protected MultiDataBufferRef(ArrayList<DataHolder> arrayList, int i, int i2) {
        super((DataHolder) arrayList.get(i), i2);
        this.zzadC = arrayList;
    }
}
