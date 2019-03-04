package com.facebook.internal;

import android.os.Bundle;
import com.facebook.widget.FacebookDialog.PendingCall;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class PendingCallStore {
    private static final String CALL_ID_ARRAY_KEY = "com.facebook.internal.PendingCallStore.callIdArrayKey";
    private static final String CALL_KEY_PREFIX = "com.facebook.internal.PendingCallStore.";
    private static PendingCallStore mInstance;
    private Map<String, PendingCall> pendingCallMap = new HashMap();

    public static PendingCallStore getInstance() {
        if (mInstance == null) {
            createInstance();
        }
        return mInstance;
    }

    private static synchronized void createInstance() {
        synchronized (PendingCallStore.class) {
            if (mInstance == null) {
                mInstance = new PendingCallStore();
            }
        }
    }

    public void trackPendingCall(PendingCall pendingCall) {
        if (pendingCall != null) {
            this.pendingCallMap.put(pendingCall.getCallId().toString(), pendingCall);
        }
    }

    public void stopTrackingPendingCall(UUID uuid) {
        if (uuid != null) {
            this.pendingCallMap.remove(uuid.toString());
        }
    }

    public PendingCall getPendingCallById(UUID uuid) {
        if (uuid == null) {
            return null;
        }
        return (PendingCall) this.pendingCallMap.get(uuid.toString());
    }

    public void saveInstanceState(Bundle bundle) {
        bundle.putStringArrayList(CALL_ID_ARRAY_KEY, new ArrayList(this.pendingCallMap.keySet()));
        for (PendingCall pendingCall : this.pendingCallMap.values()) {
            bundle.putParcelable(getSavedStateKeyForPendingCallId(pendingCall.getCallId().toString()), pendingCall);
        }
    }

    public void restoreFromSavedInstanceState(Bundle bundle) {
        ArrayList stringArrayList = bundle.getStringArrayList(CALL_ID_ARRAY_KEY);
        if (stringArrayList != null) {
            Iterator it = stringArrayList.iterator();
            while (it.hasNext()) {
                PendingCall pendingCall = (PendingCall) bundle.getParcelable(getSavedStateKeyForPendingCallId((String) it.next()));
                if (pendingCall != null) {
                    this.pendingCallMap.put(pendingCall.getCallId().toString(), pendingCall);
                }
            }
        }
    }

    private String getSavedStateKeyForPendingCallId(String str) {
        return new StringBuilder(CALL_KEY_PREFIX).append(str).toString();
    }
}
