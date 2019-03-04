package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class zzcu {

    final class C14291 implements Runnable {
        final /* synthetic */ Editor zzaAH;

        C14291(Editor editor) {
            this.zzaAH = editor;
        }

        public void run() {
            this.zzaAH.commit();
        }
    }

    static void zza(Context context, String str, String str2, String str3) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        zza(edit);
    }

    static void zza(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new C14291(editor)).start();
        }
    }
}
