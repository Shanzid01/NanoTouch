package com.slideme.sam.manager.controller.fragment.p056a;

import android.os.Bundle;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: QueryListFragment */
public class ae extends C1710s {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String[] split = arguments.getString("com.slideme.sam.manager.EXTRA_QUERY_DATA").split(",");
            try {
                this.a = C1732x.values()[Integer.parseInt(split[0])];
                this.b = C1730v.values()[Integer.parseInt(split[1])];
                this.i = C1731w.values()[Integer.parseInt(split[2])];
                this.j = C1728t.values()[Integer.parseInt(split[3])];
                this.k = C1729u.values()[Integer.parseInt(split[4])];
                this.l = C1733y.values()[Integer.parseInt(split[5])];
                if (split.length <= 6) {
                    return;
                }
                if (split[6].startsWith("&")) {
                    this.m = split[6];
                } else {
                    this.m = "&" + split[6];
                }
            } catch (Throwable e) {
                C1922m.m5791a(e);
            }
        }
    }
}
