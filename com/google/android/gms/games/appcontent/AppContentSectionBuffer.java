package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzg;
import java.util.ArrayList;

public final class AppContentSectionBuffer extends zzg<AppContentSection> {
    private final ArrayList<DataHolder> zzadC;

    public void release() {
        super.release();
        int size = this.zzadC.size();
        for (int i = 1; i < size; i++) {
            DataHolder dataHolder = (DataHolder) this.zzadC.get(i);
            if (dataHolder != null) {
                dataHolder.close();
            }
        }
    }

    protected String zziB() {
        return "section_id";
    }

    protected String zziD() {
        return "card_id";
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzm(i, i2);
    }

    protected AppContentSection zzm(int i, int i2) {
        return new AppContentSectionRef(this.zzadC, i, i2);
    }
}
