package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.zztr;
import com.google.android.gms.internal.zztt;
import java.util.HashSet;
import java.util.Set;

public interface Moment extends Freezable<Moment> {

    public class Builder {
        private String zzFA;
        private final Set<Integer> zzauX = new HashSet();
        private String zzavK;
        private zztr zzavS;
        private zztr zzavT;
        private String zzxV;

        public Moment build() {
            return new zztt(this.zzauX, this.zzFA, this.zzavS, this.zzavK, this.zzavT, this.zzxV);
        }

        public Builder setId(String str) {
            this.zzFA = str;
            this.zzauX.add(Integer.valueOf(2));
            return this;
        }

        public Builder setResult(ItemScope itemScope) {
            this.zzavS = (zztr) itemScope;
            this.zzauX.add(Integer.valueOf(4));
            return this;
        }

        public Builder setStartDate(String str) {
            this.zzavK = str;
            this.zzauX.add(Integer.valueOf(5));
            return this;
        }

        public Builder setTarget(ItemScope itemScope) {
            this.zzavT = (zztr) itemScope;
            this.zzauX.add(Integer.valueOf(6));
            return this;
        }

        public Builder setType(String str) {
            this.zzxV = str;
            this.zzauX.add(Integer.valueOf(7));
            return this;
        }
    }

    String getId();

    ItemScope getResult();

    String getStartDate();

    ItemScope getTarget();

    String getType();

    boolean hasId();

    boolean hasResult();

    boolean hasStartDate();

    boolean hasTarget();

    boolean hasType();
}
