package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;
import com.google.android.gms.internal.zztw;
import com.google.android.gms.internal.zzuh;

public final class PersonBuffer extends AbstractDataBuffer<Person> {
    private final zze<zztw> zzawE;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.zziu() == null || !dataHolder.zziu().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.zzawE = null;
        } else {
            this.zzawE = new zze(dataHolder, zztw.CREATOR);
        }
    }

    public Person get(int i) {
        return this.zzawE != null ? (Person) this.zzawE.zzaw(i) : new zzuh(this.zzMd, i);
    }
}
