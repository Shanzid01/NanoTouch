package android.support.v4.widget;

/* compiled from: ContentLoadingProgressBar */
class C0152d implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar f488a;

    C0152d(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f488a = contentLoadingProgressBar;
    }

    public void run() {
        this.f488a.f291c = false;
        if (!this.f488a.f292d) {
            this.f488a.f289a = System.currentTimeMillis();
            this.f488a.setVisibility(0);
        }
    }
}
