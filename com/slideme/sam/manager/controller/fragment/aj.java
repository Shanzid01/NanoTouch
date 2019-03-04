package com.slideme.sam.manager.controller.fragment;

/* compiled from: DynamicLayoutFragment */
class aj extends Thread {
    final /* synthetic */ ae f3044a;

    aj(ae aeVar) {
        this.f3044a = aeVar;
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        if (this.f3044a.getActivity() != null) {
            this.f3044a.getActivity().runOnUiThread(new ak(this));
        }
    }
}
