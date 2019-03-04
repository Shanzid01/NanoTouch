package com.slideme.sam.manager.controller.fragment;

/* compiled from: ApplicationDetailsFragment */
class C1771u extends Thread {
    final /* synthetic */ C1735a f3156a;
    private final /* synthetic */ String f3157b;

    C1771u(C1735a c1735a, String str) {
        this.f3156a = c1735a;
        this.f3157b = str;
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        if (this.f3156a.getActivity() != null) {
            this.f3156a.getActivity().runOnUiThread(new C1772v(this, this.f3157b));
        }
    }
}
