package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.facebook.FacebookException;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;
import com.facebook.widget.WebDialog;
import com.facebook.widget.WebDialog.OnCompleteListener;
import org.json.JSONObject;

public class FacebookWebFallbackDialog extends WebDialog {
    private static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;
    private static final String TAG = FacebookWebFallbackDialog.class.getName();
    private boolean waitingForDialogToClose;

    class C05801 implements OnCompleteListener {
        private final /* synthetic */ PendingCall val$appCall;
        private final /* synthetic */ Callback val$callback;
        private final /* synthetic */ Context val$context;

        C05801(Context context, PendingCall pendingCall, Callback callback) {
            this.val$context = context;
            this.val$appCall = pendingCall;
            this.val$callback = callback;
        }

        public void onComplete(Bundle bundle, FacebookException facebookException) {
            Intent intent = new Intent();
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtras(bundle);
            FacebookDialog.handleActivityResult(this.val$context, this.val$appCall, this.val$appCall.getRequestCode(), intent, this.val$callback);
        }
    }

    class C05812 implements Runnable {
        C05812() {
        }

        public void run() {
            if (!FacebookWebFallbackDialog.this.isListenerCalled()) {
                FacebookWebFallbackDialog.this.sendCancelToListener();
            }
        }
    }

    public static boolean presentWebFallback(Context context, String str, String str2, PendingCall pendingCall, Callback callback) {
        if (Utility.isNullOrEmpty(str)) {
            return false;
        }
        FacebookWebFallbackDialog facebookWebFallbackDialog = new FacebookWebFallbackDialog(context, str, String.format("fb%s://bridge/", new Object[]{str2}));
        facebookWebFallbackDialog.setOnCompleteListener(new C05801(context, pendingCall, callback));
        facebookWebFallbackDialog.show();
        return true;
    }

    private FacebookWebFallbackDialog(Context context, String str, String str2) {
        super(context, str);
        setExpectedRedirectUrl(str2);
    }

    protected Bundle parseResponseUri(String str) {
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(Uri.parse(str).getQuery());
        String string = parseUrlQueryString.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_BRIDGE_ARGS);
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_BRIDGE_ARGS);
        if (!Utility.isNullOrEmpty(string)) {
            try {
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_BRIDGE_ARGS, BundleJSONConverter.convertToBundle(new JSONObject(string)));
            } catch (Throwable e) {
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e);
            }
        }
        string = parseUrlQueryString.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        if (!Utility.isNullOrEmpty(string)) {
            if (Utility.isNullOrEmpty(string)) {
                string = "{}";
            }
            try {
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_METHOD_RESULTS, BundleJSONConverter.convertToBundle(new JSONObject(string)));
            } catch (Throwable e2) {
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e2);
            }
        }
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        parseUrlQueryString.putInt(NativeProtocol.EXTRA_PROTOCOL_VERSION, NativeProtocol.getLatestKnownVersion());
        return parseUrlQueryString;
    }

    public void dismiss() {
        WebView webView = getWebView();
        if (isListenerCalled() || webView == null || !webView.isShown()) {
            super.dismiss();
        } else if (!this.waitingForDialogToClose) {
            this.waitingForDialogToClose = true;
            webView.loadUrl("javascript:" + "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
            new Handler(Looper.getMainLooper()).postDelayed(new C05812(), 1500);
        }
    }
}
