package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* compiled from: LocalBroadcastManager */
class C0093t {
    final IntentFilter f106a;
    final BroadcastReceiver f107b;
    boolean f108c;

    C0093t(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.f106a = intentFilter;
        this.f107b = broadcastReceiver;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("Receiver{");
        stringBuilder.append(this.f107b);
        stringBuilder.append(" filter=");
        stringBuilder.append(this.f106a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
