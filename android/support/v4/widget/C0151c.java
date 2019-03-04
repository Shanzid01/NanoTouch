package android.support.v4.widget;

/* compiled from: ContentLoadingProgressBar */
class C0151c implements Runnable {
    final /* synthetic */ ContentLoadingProgressBar f487a;

    C0151c(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f487a = contentLoadingProgressBar;
    }

    public void run() {
        this.f487a.f290b = false;
        this.f487a.f289a = -1;
        this.f487a.setVisibility(8);
    }
}
