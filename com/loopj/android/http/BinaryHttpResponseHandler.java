package com.loopj.android.http;

import android.os.Message;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public class BinaryHttpResponseHandler extends AsyncHttpResponseHandler {
    private static String[] mAllowedContentTypes = new String[]{"image/jpeg", "image/png"};

    public BinaryHttpResponseHandler(String[] strArr) {
        this();
        mAllowedContentTypes = strArr;
    }

    public void onSuccess(byte[] bArr) {
    }

    public void onSuccess(int i, byte[] bArr) {
        onSuccess(bArr);
    }

    @Deprecated
    public void onFailure(Throwable th, byte[] bArr) {
        onFailure(th);
    }

    protected void sendSuccessMessage(int i, byte[] bArr) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), bArr}));
    }

    protected void sendFailureMessage(Throwable th, byte[] bArr) {
        sendMessage(obtainMessage(1, new Object[]{th, bArr}));
    }

    protected void handleSuccessMessage(int i, byte[] bArr) {
        onSuccess(i, bArr);
    }

    protected void handleFailureMessage(Throwable th, byte[] bArr) {
        onFailure(th, bArr);
    }

    protected void handleMessage(Message message) {
        Object[] objArr;
        switch (message.what) {
            case 0:
                objArr = (Object[]) message.obj;
                handleSuccessMessage(((Integer) objArr[0]).intValue(), (byte[]) objArr[1]);
                return;
            case 1:
                objArr = (Object[]) message.obj;
                handleFailureMessage((Throwable) objArr[0], objArr[1].toString());
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }

    void sendResponseMessage(HttpResponse httpResponse) {
        int i = 0;
        StatusLine statusLine = httpResponse.getStatusLine();
        Header[] headers = httpResponse.getHeaders("Content-Type");
        if (headers.length != 1) {
            sendFailureMessage(new HttpResponseException(statusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"), null);
            return;
        }
        Header header = headers[0];
        for (String matches : mAllowedContentTypes) {
            if (Pattern.matches(matches, header.getValue())) {
                i = 1;
            }
        }
        if (i == 0) {
            sendFailureMessage(new HttpResponseException(statusLine.getStatusCode(), "Content-Type not allowed!"), null);
            return;
        }
        byte[] toByteArray;
        try {
            HttpEntity bufferedHttpEntity;
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                bufferedHttpEntity = new BufferedHttpEntity(entity);
            } else {
                bufferedHttpEntity = null;
            }
            toByteArray = EntityUtils.toByteArray(bufferedHttpEntity);
        } catch (Throwable e) {
            sendFailureMessage(e, null);
            toByteArray = null;
        }
        if (statusLine.getStatusCode() >= 300) {
            sendFailureMessage(new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), toByteArray);
        } else {
            sendSuccessMessage(statusLine.getStatusCode(), toByteArray);
        }
    }
}
