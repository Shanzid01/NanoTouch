package com.facebook.widget;

import android.content.Context;
import android.os.Handler;
import android.support.v4.content.C0089o;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Request.Callback;
import com.facebook.RequestBatch;
import com.facebook.Response;
import com.facebook.Response.PagingDirection;
import com.facebook.internal.CacheableRequestBatch;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import java.util.Collection;

class GraphObjectPagingLoader<T extends GraphObject> extends C0089o<SimpleGraphObjectCursor<T>> {
    private boolean appendResults = false;
    private Request currentRequest;
    private SimpleGraphObjectCursor<T> cursor;
    private final Class<T> graphObjectClass;
    private boolean loading = false;
    private Request nextRequest;
    private OnErrorListener onErrorListener;
    private Request originalRequest;
    private boolean skipRoundtripIfCached;

    class C06101 implements Callback {
        C06101() {
        }

        public void onCompleted(Response response) {
            GraphObjectPagingLoader.this.requestCompleted(response);
        }
    }

    class C06112 implements Callback {
        C06112() {
        }

        public void onCompleted(Response response) {
            GraphObjectPagingLoader.this.requestCompleted(response);
        }
    }

    public interface OnErrorListener {
        void onError(FacebookException facebookException, GraphObjectPagingLoader<?> graphObjectPagingLoader);
    }

    interface PagedResults extends GraphObject {
        GraphObjectList<GraphObject> getData();
    }

    public GraphObjectPagingLoader(Context context, Class<T> cls) {
        super(context);
        this.graphObjectClass = cls;
    }

    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public SimpleGraphObjectCursor<T> getCursor() {
        return this.cursor;
    }

    public void clearResults() {
        this.nextRequest = null;
        this.originalRequest = null;
        this.currentRequest = null;
        deliverResult(null);
    }

    public boolean isLoading() {
        return this.loading;
    }

    public void startLoading(Request request, boolean z) {
        this.originalRequest = request;
        startLoading(request, z, 0);
    }

    public void refreshOriginalRequest(long j) {
        if (this.originalRequest == null) {
            throw new FacebookException("refreshOriginalRequest may not be called until after startLoading has been called.");
        }
        startLoading(this.originalRequest, false, j);
    }

    public void followNextLink() {
        if (this.nextRequest != null) {
            this.appendResults = true;
            this.currentRequest = this.nextRequest;
            this.currentRequest.setCallback(new C06101());
            this.loading = true;
            Request.executeBatchAsync(putRequestIntoBatch(this.currentRequest, this.skipRoundtripIfCached));
        }
    }

    public void deliverResult(SimpleGraphObjectCursor<T> simpleGraphObjectCursor) {
        SimpleGraphObjectCursor<T> simpleGraphObjectCursor2 = this.cursor;
        this.cursor = simpleGraphObjectCursor;
        if (isStarted()) {
            super.deliverResult(simpleGraphObjectCursor);
            if (simpleGraphObjectCursor2 != null && simpleGraphObjectCursor2 != simpleGraphObjectCursor && !simpleGraphObjectCursor2.isClosed()) {
                simpleGraphObjectCursor2.close();
            }
        }
    }

    protected void onStartLoading() {
        super.onStartLoading();
        if (this.cursor != null) {
            deliverResult(this.cursor);
        }
    }

    private void startLoading(Request request, boolean z, long j) {
        this.skipRoundtripIfCached = z;
        this.appendResults = false;
        this.nextRequest = null;
        this.currentRequest = request;
        this.currentRequest.setCallback(new C06112());
        this.loading = true;
        final RequestBatch putRequestIntoBatch = putRequestIntoBatch(request, z);
        Runnable c06123 = new Runnable() {
            public void run() {
                Request.executeBatchAsync(putRequestIntoBatch);
            }
        };
        if (j == 0) {
            c06123.run();
        } else {
            new Handler().postDelayed(c06123, j);
        }
    }

    private CacheableRequestBatch putRequestIntoBatch(Request request, boolean z) {
        boolean z2 = false;
        CacheableRequestBatch cacheableRequestBatch = new CacheableRequestBatch(request);
        if (!z) {
            z2 = true;
        }
        cacheableRequestBatch.setForceRoundTrip(z2);
        return cacheableRequestBatch;
    }

    private void requestCompleted(Response response) {
        if (response.getRequest() == this.currentRequest) {
            this.loading = false;
            this.currentRequest = null;
            FacebookRequestError error = response.getError();
            FacebookException exception = error == null ? null : error.getException();
            if (response.getGraphObject() == null && exception == null) {
                exception = new FacebookException("GraphObjectPagingLoader received neither a result nor an error.");
            }
            if (exception != null) {
                this.nextRequest = null;
                if (this.onErrorListener != null) {
                    this.onErrorListener.onError(exception, this);
                    return;
                }
                return;
            }
            addResults(response);
        }
    }

    private void addResults(Response response) {
        SimpleGraphObjectCursor simpleGraphObjectCursor;
        boolean z;
        if (this.cursor == null || !this.appendResults) {
            simpleGraphObjectCursor = new SimpleGraphObjectCursor();
        } else {
            simpleGraphObjectCursor = new SimpleGraphObjectCursor(this.cursor);
        }
        PagedResults pagedResults = (PagedResults) response.getGraphObjectAs(PagedResults.class);
        boolean isFromCache = response.getIsFromCache();
        Collection castToListOf = pagedResults.getData().castToListOf(this.graphObjectClass);
        if (castToListOf.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.nextRequest = response.getRequestForPagedResults(PagingDirection.NEXT);
            simpleGraphObjectCursor.addGraphObjects(castToListOf, isFromCache);
            if (this.nextRequest != null) {
                simpleGraphObjectCursor.setMoreObjectsAvailable(true);
            } else {
                simpleGraphObjectCursor.setMoreObjectsAvailable(false);
            }
        }
        if (!z) {
            simpleGraphObjectCursor.setMoreObjectsAvailable(false);
            simpleGraphObjectCursor.setFromCache(isFromCache);
            this.nextRequest = null;
        }
        if (!isFromCache) {
            this.skipRoundtripIfCached = false;
        }
        deliverResult(simpleGraphObjectCursor);
    }
}
