package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class zztv extends zzd implements Moment {
    private zztt zzavU;

    public zztv(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private zztt zzse() {
        synchronized (this) {
            if (this.zzavU == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.zzavU = zztt.CREATOR.zzeA(obtain);
                obtain.recycle();
            }
        }
        return this.zzavU;
    }

    public /* synthetic */ Object freeze() {
        return zzsd();
    }

    public String getId() {
        return zzse().getId();
    }

    public ItemScope getResult() {
        return zzse().getResult();
    }

    public String getStartDate() {
        return zzse().getStartDate();
    }

    public ItemScope getTarget() {
        return zzse().getTarget();
    }

    public String getType() {
        return zzse().getType();
    }

    public boolean hasId() {
        return zzse().hasId();
    }

    public boolean hasResult() {
        return zzse().hasResult();
    }

    public boolean hasStartDate() {
        return zzse().hasStartDate();
    }

    public boolean hasTarget() {
        return zzse().hasTarget();
    }

    public boolean hasType() {
        return zzse().hasType();
    }

    public zztt zzsd() {
        return zzse();
    }
}
