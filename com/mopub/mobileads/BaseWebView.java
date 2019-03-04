package com.mopub.mobileads;

import android.content.Context;
import android.util.Log;
import android.webkit.WebView;
import com.mopub.common.p050b.C1493p;
import com.mopub.common.p050b.C1494q;
import com.mopub.mobileads.util.C1561g;
import java.lang.reflect.Method;

public class BaseWebView extends WebView {
    protected boolean f2280a;

    public BaseWebView(Context context) {
        super(context.getApplicationContext());
        m4274c(false);
        C1561g.m4673c(this);
    }

    protected void m4274c(boolean z) {
        if (!C1493p.currentApiLevel().isAtLeast(C1493p.JELLY_BEAN_MR2)) {
            if (C1493p.currentApiLevel().isBelow(C1493p.FROYO)) {
                try {
                    Class.forName("android.webkit.WebSettings").getDeclaredMethod("setPluginsEnabled", new Class[]{Boolean.TYPE}).invoke(getSettings(), new Object[]{Boolean.valueOf(z)});
                    return;
                } catch (Exception e) {
                    Log.d("MoPub", "Unable to " + (z ? "enable" : "disable") + "WebSettings plugins for BaseWebView.");
                    return;
                }
            }
            try {
                Method declaredMethod = getSettings().getClass().getDeclaredMethod("setPluginState", new Class[]{Class.forName("android.webkit.WebSettings$PluginState")});
                Enum valueOf = Enum.valueOf(Class.forName("android.webkit.WebSettings$PluginState"), z ? "ON" : "OFF");
                declaredMethod.invoke(getSettings(), new Object[]{valueOf});
            } catch (Exception e2) {
                Log.d("MoPub", "Unable to modify WebView plugin state.");
            }
        }
    }

    public void destroy() {
        this.f2280a = true;
        C1494q.m4092a(this);
        super.destroy();
    }

    @Deprecated
    void setIsDestroyed(boolean z) {
        this.f2280a = z;
    }
}
