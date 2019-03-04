package com.mopub.mobileads.p051a;

import com.mopub.mobileads.AdFetchTask;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.TaskTracker;

/* compiled from: AdFetchTaskFactory */
public class C1521a {
    protected static C1521a f2389a = new C1521a();

    public static AdFetchTask m4473a(TaskTracker taskTracker, AdViewController adViewController, String str, int i) {
        return f2389a.m4474b(taskTracker, adViewController, str, i);
    }

    protected AdFetchTask m4474b(TaskTracker taskTracker, AdViewController adViewController, String str, int i) {
        return new AdFetchTask(taskTracker, adViewController, str, i);
    }
}
