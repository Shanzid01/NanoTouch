package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestBatch extends AbstractList<Request> {
    private static AtomicInteger idGenerator = new AtomicInteger();
    private String batchApplicationId;
    private Handler callbackHandler;
    private List<Callback> callbacks;
    private final String id;
    private List<Request> requests;
    private int timeoutInMilliseconds;

    public interface Callback {
        void onBatchCompleted(RequestBatch requestBatch);
    }

    public interface OnProgressCallback extends Callback {
        void onBatchProgress(RequestBatch requestBatch, long j, long j2);
    }

    public RequestBatch() {
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList();
    }

    public RequestBatch(Collection<Request> collection) {
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(collection);
    }

    public RequestBatch(Request... requestArr) {
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = Arrays.asList(requestArr);
    }

    public RequestBatch(RequestBatch requestBatch) {
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(requestBatch);
        this.callbackHandler = requestBatch.callbackHandler;
        this.timeoutInMilliseconds = requestBatch.timeoutInMilliseconds;
        this.callbacks = new ArrayList(requestBatch.callbacks);
    }

    public int getTimeout() {
        return this.timeoutInMilliseconds;
    }

    public void setTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
        }
        this.timeoutInMilliseconds = i;
    }

    public void addCallback(Callback callback) {
        if (!this.callbacks.contains(callback)) {
            this.callbacks.add(callback);
        }
    }

    public void removeCallback(Callback callback) {
        this.callbacks.remove(callback);
    }

    public final boolean add(Request request) {
        return this.requests.add(request);
    }

    public final void add(int i, Request request) {
        this.requests.add(i, request);
    }

    public final void clear() {
        this.requests.clear();
    }

    public final Request get(int i) {
        return (Request) this.requests.get(i);
    }

    public final Request remove(int i) {
        return (Request) this.requests.remove(i);
    }

    public final Request set(int i, Request request) {
        return (Request) this.requests.set(i, request);
    }

    public final int size() {
        return this.requests.size();
    }

    final String getId() {
        return this.id;
    }

    final Handler getCallbackHandler() {
        return this.callbackHandler;
    }

    final void setCallbackHandler(Handler handler) {
        this.callbackHandler = handler;
    }

    final List<Request> getRequests() {
        return this.requests;
    }

    final List<Callback> getCallbacks() {
        return this.callbacks;
    }

    final String getBatchApplicationId() {
        return this.batchApplicationId;
    }

    final void setBatchApplicationId(String str) {
        this.batchApplicationId = str;
    }

    public final List<Response> executeAndWait() {
        return executeAndWaitImpl();
    }

    public final RequestAsyncTask executeAsync() {
        return executeAsyncImpl();
    }

    List<Response> executeAndWaitImpl() {
        return Request.executeBatchAndWait(this);
    }

    RequestAsyncTask executeAsyncImpl() {
        return Request.executeBatchAsync(this);
    }
}
