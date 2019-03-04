package com.google.android.gms.appstate;

import com.google.android.gms.common.internal.zzw;

public final class zza implements AppState {
    private final int zzGL;
    private final String zzGM;
    private final byte[] zzGN;
    private final boolean zzGO;
    private final String zzGP;
    private final byte[] zzGQ;

    public zza(AppState appState) {
        this.zzGL = appState.getKey();
        this.zzGM = appState.getLocalVersion();
        this.zzGN = appState.getLocalData();
        this.zzGO = appState.hasConflict();
        this.zzGP = appState.getConflictVersion();
        this.zzGQ = appState.getConflictData();
    }

    static int zza(AppState appState) {
        return zzw.hashCode(Integer.valueOf(appState.getKey()), appState.getLocalVersion(), appState.getLocalData(), Boolean.valueOf(appState.hasConflict()), appState.getConflictVersion(), appState.getConflictData());
    }

    static boolean zza(AppState appState, Object obj) {
        if (!(obj instanceof AppState)) {
            return false;
        }
        if (appState == obj) {
            return true;
        }
        AppState appState2 = (AppState) obj;
        return zzw.equal(Integer.valueOf(appState2.getKey()), Integer.valueOf(appState.getKey())) && zzw.equal(appState2.getLocalVersion(), appState.getLocalVersion()) && zzw.equal(appState2.getLocalData(), appState.getLocalData()) && zzw.equal(Boolean.valueOf(appState2.hasConflict()), Boolean.valueOf(appState.hasConflict())) && zzw.equal(appState2.getConflictVersion(), appState.getConflictVersion()) && zzw.equal(appState2.getConflictData(), appState.getConflictData());
    }

    static String zzb(AppState appState) {
        return zzw.zzk(appState).zza("Key", Integer.valueOf(appState.getKey())).zza("LocalVersion", appState.getLocalVersion()).zza("LocalData", appState.getLocalData()).zza("HasConflict", Boolean.valueOf(appState.hasConflict())).zza("ConflictVersion", appState.getConflictVersion()).zza("ConflictData", appState.getConflictData()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzha();
    }

    public byte[] getConflictData() {
        return this.zzGQ;
    }

    public String getConflictVersion() {
        return this.zzGP;
    }

    public int getKey() {
        return this.zzGL;
    }

    public byte[] getLocalData() {
        return this.zzGN;
    }

    public String getLocalVersion() {
        return this.zzGM;
    }

    public boolean hasConflict() {
        return this.zzGO;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public AppState zzha() {
        return this;
    }
}
