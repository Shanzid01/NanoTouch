package com.google.analytics.tracking.android;

import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

/* compiled from: GAServiceProxy */
class af {
    private final Map<String, String> f1969a;
    private final long f1970b;
    private final String f1971c;
    private final List<Command> f1972d;

    public af(Map<String, String> map, long j, String str, List<Command> list) {
        this.f1969a = map;
        this.f1970b = j;
        this.f1971c = str;
        this.f1972d = list;
    }

    public Map<String, String> m3743a() {
        return this.f1969a;
    }

    public long m3744b() {
        return this.f1970b;
    }

    public String m3745c() {
        return this.f1971c;
    }

    public List<Command> m3746d() {
        return this.f1972d;
    }
}
