package com.facebook.android;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class Util {
    private static final String UTF8 = "UTF-8";

    @Deprecated
    public static String encodePostBody(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : bundle.keySet()) {
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                stringBuilder.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + ((String) obj));
                stringBuilder.append("\r\n--" + str + "\r\n");
            }
        }
        return stringBuilder.toString();
    }

    @Deprecated
    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : bundle.keySet()) {
            if (bundle.get(str) instanceof String) {
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder.append("&");
                }
                stringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
            }
        }
        return stringBuilder.toString();
    }

    @Deprecated
    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    if (split2.length == 2) {
                        bundle.putString(URLDecoder.decode(split2[0], UTF8), URLDecoder.decode(split2[1], UTF8));
                    } else if (split2.length == 1) {
                        bundle.putString(URLDecoder.decode(split2[0], UTF8), "");
                    }
                } catch (UnsupportedEncodingException e) {
                }
            }
        }
        return bundle;
    }

    @Deprecated
    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str.replace("fbconnect", "http"));
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    @Deprecated
    public static String openUrl(String str, String str2, Bundle bundle) {
        String str3 = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
        String str4 = "\r\n";
        if (str2.equals("GET")) {
            str = new StringBuilder(String.valueOf(str)).append("?").append(encodeUrl(bundle)).toString();
        }
        Utility.logd("Facebook-Util", new StringBuilder(String.valueOf(str2)).append(" URL: ").append(str).toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestProperty("User-Agent", new StringBuilder(String.valueOf(System.getProperties().getProperty("http.agent"))).append(" FacebookAndroidSDK").toString());
        if (!str2.equals("GET")) {
            Bundle bundle2 = new Bundle();
            for (String str5 : bundle.keySet()) {
                Object obj = bundle.get(str5);
                if (obj instanceof byte[]) {
                    bundle2.putByteArray(str5, (byte[]) obj);
                }
            }
            if (!bundle.containsKey("method")) {
                bundle.putString("method", str2);
            }
            if (bundle.containsKey("access_token")) {
                bundle.putString("access_token", URLDecoder.decode(bundle.getString("access_token")));
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + str3);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.connect();
            OutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            try {
                bufferedOutputStream.write(("--" + str3 + str4).getBytes());
                bufferedOutputStream.write(encodePostBody(bundle, str3).getBytes());
                bufferedOutputStream.write(new StringBuilder(String.valueOf(str4)).append("--").append(str3).append(str4).toString().getBytes());
                if (!bundle2.isEmpty()) {
                    for (String str52 : bundle2.keySet()) {
                        bufferedOutputStream.write(("Content-Disposition: form-data; filename=\"" + str52 + "\"" + str4).getBytes());
                        bufferedOutputStream.write(("Content-Type: content/unknown" + str4 + str4).getBytes());
                        bufferedOutputStream.write(bundle2.getByteArray(str52));
                        bufferedOutputStream.write(new StringBuilder(String.valueOf(str4)).append("--").append(str3).append(str4).toString().getBytes());
                    }
                }
                bufferedOutputStream.flush();
            } finally {
                bufferedOutputStream.close();
            }
        }
        String str522 = "";
        try {
            return read(httpURLConnection.getInputStream());
        } catch (FileNotFoundException e) {
            return read(httpURLConnection.getErrorStream());
        }
    }

    @Deprecated
    private static String read(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1000);
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            stringBuilder.append(readLine);
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    @Deprecated
    public static JSONObject parseJson(String str) {
        if (str.equals("false")) {
            throw new FacebookError("request failed");
        }
        if (str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            str = "{value : true}";
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("error")) {
            jSONObject = jSONObject.getJSONObject("error");
            throw new FacebookError(jSONObject.getString("message"), jSONObject.getString("type"), 0);
        } else if (jSONObject.has(NativeProtocol.BRIDGE_ARG_ERROR_CODE) && jSONObject.has("error_msg")) {
            throw new FacebookError(jSONObject.getString("error_msg"), "", Integer.parseInt(jSONObject.getString(NativeProtocol.BRIDGE_ARG_ERROR_CODE)));
        } else if (jSONObject.has(NativeProtocol.BRIDGE_ARG_ERROR_CODE)) {
            throw new FacebookError("request failed", "", Integer.parseInt(jSONObject.getString(NativeProtocol.BRIDGE_ARG_ERROR_CODE)));
        } else if (jSONObject.has("error_msg")) {
            throw new FacebookError(jSONObject.getString("error_msg"));
        } else if (!jSONObject.has("error_reason")) {
            return jSONObject;
        } else {
            throw new FacebookError(jSONObject.getString("error_reason"));
        }
    }

    @Deprecated
    public static void showAlert(Context context, String str, String str2) {
        Builder builder = new Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.create().show();
    }
}
