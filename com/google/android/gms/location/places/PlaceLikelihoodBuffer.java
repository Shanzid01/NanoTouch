package com.google.android.gms.location.places;

import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.location.LocationRequest;

public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {
    private final Context mContext;
    private final Status zzHb;
    private final String zzanK;
    private final int zzanL;

    public class zza {
        static int zzfD(int i) {
            switch (i) {
                case 100:
                case Quests.SELECT_COMPLETED_UNCLAIMED /*101*/:
                case 102:
                case Quests.SELECT_RECENTLY_FAILED /*103*/:
                case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                case LocationRequest.PRIORITY_NO_POWER /*105*/:
                    return i;
                default:
                    throw new IllegalArgumentException("invalid source: " + i);
            }
        }
    }

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int i, Context context) {
        super(dataHolder);
        this.mContext = context;
        this.zzHb = new Status(dataHolder.getStatusCode());
        this.zzanL = zza.zzfD(i);
        if (dataHolder == null || dataHolder.zziu() == null) {
            this.zzanK = null;
        } else {
            this.zzanK = dataHolder.zziu().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    public PlaceLikelihood get(int i) {
        return new zzqc(this.zzMd, i, this.mContext);
    }

    public CharSequence getAttributions() {
        return this.zzanK;
    }

    public Status getStatus() {
        return this.zzHb;
    }

    public String toString() {
        return zzw.zzk(this).zza("status", getStatus()).zza("attributions", this.zzanK).toString();
    }
}
