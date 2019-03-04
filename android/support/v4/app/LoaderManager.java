package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.C0089o;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        C0089o<D> onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(C0089o<D> c0089o, D d);

        void onLoaderReset(C0089o<D> c0089o);
    }

    public abstract void destroyLoader(int i);

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> C0089o<D> getLoader(int i);

    public abstract <D> C0089o<D> initLoader(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks);

    public abstract <D> C0089o<D> restartLoader(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks);

    public static void enableDebugLogging(boolean z) {
        LoaderManagerImpl.DEBUG = z;
    }

    public boolean hasRunningLoaders() {
        return false;
    }
}
