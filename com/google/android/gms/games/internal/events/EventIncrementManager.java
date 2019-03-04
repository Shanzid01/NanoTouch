package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> zzahT = new AtomicReference();

    public void flush() {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.zzahT.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    protected abstract EventIncrementCache zznM();

    public void zzp(String str, int i) {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.zzahT.get();
        if (eventIncrementCache == null) {
            eventIncrementCache = zznM();
            if (!this.zzahT.compareAndSet(null, eventIncrementCache)) {
                eventIncrementCache = (EventIncrementCache) this.zzahT.get();
            }
        }
        eventIncrementCache.zzz(str, i);
    }
}
