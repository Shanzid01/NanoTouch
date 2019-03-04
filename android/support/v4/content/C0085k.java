package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

/* compiled from: IntentCompat */
class C0085k implements C0084j {
    C0085k() {
    }

    public Intent mo168a(ComponentName componentName) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(componentName);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }
}
