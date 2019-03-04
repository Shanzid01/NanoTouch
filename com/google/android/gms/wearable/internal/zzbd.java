package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.zza.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class zzbd extends zzk<zzai> {
    private final zzaj<zza> zzaGG = new zzb();
    private final zzaj<DataListener> zzaGH = new zzc();
    private final zzaj<MessageListener> zzaGI = new zzd();
    private final zzaj<NodeListener> zzaGJ = new zze();
    private final ExecutorService zzazT = Executors.newCachedThreadPool();

    public zzbd(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 14, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
    }

    private FutureTask<Boolean> zza(final ParcelFileDescriptor parcelFileDescriptor, final byte[] bArr) {
        return new FutureTask(new Callable<Boolean>(this) {
            final /* synthetic */ zzbd zzaGL;

            public /* synthetic */ Object call() {
                return zzvl();
            }

            public java.lang.Boolean zzvl() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00bf in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r1 = 3;
                r0 = "WearableClient";
                r0 = android.util.Log.isLoggable(r0, r1);
                if (r0 == 0) goto L_0x0023;
            L_0x0009:
                r0 = "WearableClient";
                r1 = new java.lang.StringBuilder;
                r1.<init>();
                r2 = "processAssets: writing data to FD : ";
                r1 = r1.append(r2);
                r2 = r3;
                r1 = r1.append(r2);
                r1 = r1.toString();
                android.util.Log.d(r0, r1);
            L_0x0023:
                r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream;
                r0 = r3;
                r1.<init>(r0);
                r0 = r4;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r1.write(r0);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r1.flush();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r0 = "WearableClient";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = 3;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r0 = android.util.Log.isLoggable(r0, r2);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                if (r0 == 0) goto L_0x0055;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            L_0x003b:
                r0 = "WearableClient";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2.<init>();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r3 = "processAssets: wrote data: ";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r3 = r3;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.toString();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                android.util.Log.d(r0, r2);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            L_0x0055:
                r0 = 1;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00f4 }
                r3 = 3;	 Catch:{ IOException -> 0x00f4 }
                r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00f4 }
                if (r2 == 0) goto L_0x007d;	 Catch:{ IOException -> 0x00f4 }
            L_0x0063:
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00f4 }
                r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f4 }
                r3.<init>();	 Catch:{ IOException -> 0x00f4 }
                r4 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00f4 }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f4 }
                r4 = r3;	 Catch:{ IOException -> 0x00f4 }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f4 }
                r3 = r3.toString();	 Catch:{ IOException -> 0x00f4 }
                android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x00f4 }
            L_0x007d:
                r1.close();	 Catch:{ IOException -> 0x00f4 }
            L_0x0080:
                return r0;
            L_0x0081:
                r0 = move-exception;
                r0 = "WearableClient";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2.<init>();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r3 = "processAssets: writing data failed: ";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r3 = r3;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.toString();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                android.util.Log.w(r0, r2);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r0 = "WearableClient";
                r2 = 3;
                r0 = android.util.Log.isLoggable(r0, r2);
                if (r0 == 0) goto L_0x00bf;
            L_0x00a5:
                r0 = "WearableClient";
                r2 = new java.lang.StringBuilder;
                r2.<init>();
                r3 = "processAssets: closing: ";
                r2 = r2.append(r3);
                r3 = r3;
                r2 = r2.append(r3);
                r2 = r2.toString();
                android.util.Log.d(r0, r2);
            L_0x00bf:
                r1.close();
            L_0x00c2:
                r0 = 0;
                r0 = java.lang.Boolean.valueOf(r0);
                goto L_0x0080;
            L_0x00c8:
                r0 = move-exception;
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00f0 }
                r3 = 3;	 Catch:{ IOException -> 0x00f0 }
                r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00f0 }
                if (r2 == 0) goto L_0x00ec;	 Catch:{ IOException -> 0x00f0 }
            L_0x00d2:
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00f0 }
                r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f0 }
                r3.<init>();	 Catch:{ IOException -> 0x00f0 }
                r4 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00f0 }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f0 }
                r4 = r3;	 Catch:{ IOException -> 0x00f0 }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f0 }
                r3 = r3.toString();	 Catch:{ IOException -> 0x00f0 }
                android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x00f0 }
            L_0x00ec:
                r1.close();	 Catch:{ IOException -> 0x00f0 }
            L_0x00ef:
                throw r0;
            L_0x00f0:
                r1 = move-exception;
                goto L_0x00ef;
            L_0x00f2:
                r0 = move-exception;
                goto L_0x00c2;
            L_0x00f4:
                r1 = move-exception;
                goto L_0x0080;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzbd.1.zzvl():java.lang.Boolean");
            }
        });
    }

    public void disconnect() {
        this.zzaGG.zzb(this);
        this.zzaGH.zzb(this);
        this.zzaGI.zzb(this);
        this.zzaGJ.zzb(this);
        super.disconnect();
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.zzaGG.zzcS(iBinder);
            this.zzaGH.zzcS(iBinder);
            this.zzaGI.zzcS(iBinder);
            this.zzaGJ.zzcS(iBinder);
        }
        super.zza(i, iBinder, bundle);
    }

    public void zza(zzb<DataItemResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, Uri uri) {
        ((zzai) zzjb()).zza(new zzd(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult), uri);
    }

    public void zza(zzb<GetFdForAssetResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult, Asset asset) {
        ((zzai) zzjb()).zza(new zzf(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult), asset);
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, DataListener dataListener) {
        this.zzaGH.zza(this, com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, dataListener);
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, DataListener dataListener, IntentFilter[] intentFilterArr) {
        this.zzaGH.zza(this, com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, dataListener, intentFilterArr);
    }

    public void zza(zzb<GetFdForAssetResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult, DataItemAsset dataItemAsset) {
        zza((zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult, Asset.createFromRef(dataItemAsset.getId()));
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, MessageListener messageListener) {
        this.zzaGI.zza(this, com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, messageListener);
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        this.zzaGI.zza(this, com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, messageListener, intentFilterArr);
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, NodeListener nodeListener) {
        this.zzaGJ.zza(this, com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, nodeListener, null);
    }

    public void zza(zzb<DataItemResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, PutDataRequest putDataRequest) {
        for (Entry value : putDataRequest.getAssets().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.getData() == null && asset.getDigest() == null && asset.getFd() == null && asset.getUri() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.getUri() + " contains invalid asset: " + asset);
            }
        }
        PutDataRequest zzn = PutDataRequest.zzn(putDataRequest.getUri());
        zzn.setData(putDataRequest.getData());
        List arrayList = new ArrayList();
        for (Entry value2 : putDataRequest.getAssets().entrySet()) {
            Asset asset2 = (Asset) value2.getValue();
            if (asset2.getData() == null) {
                zzn.putAsset((String) value2.getKey(), (Asset) value2.getValue());
            } else {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + asset2 + " read:" + createPipe[0] + " write:" + createPipe[1]);
                    }
                    zzn.putAsset((String) value2.getKey(), Asset.createFromFd(createPipe[0]));
                    Runnable zza = zza(createPipe[1], asset2.getData());
                    arrayList.add(zza);
                    this.zzazT.submit(zza);
                } catch (Throwable e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            }
        }
        try {
            ((zzai) zzjb()).zza(new zzi(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, arrayList), zzn);
        } catch (Throwable e2) {
            throw new IllegalStateException("Unable to putDataItem: " + putDataRequest, e2);
        }
    }

    public void zza(zzb<SendMessageResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult, String str, String str2, byte[] bArr) {
        ((zzai) zzjb()).zza(new zzj(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult), str, str2, bArr);
    }

    public void zzb(zzb<DataItemBuffer> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataItemBuffer, Uri uri) {
        ((zzai) zzjb()).zzb(new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataItemBuffer), uri);
    }

    public void zzb(zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, NodeListener nodeListener) {
        this.zzaGJ.zza(this, com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, nodeListener);
    }

    public void zzc(zzb<DeleteDataItemsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult, Uri uri) {
        ((zzai) zzjb()).zzc(new zzb(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult), uri);
    }

    protected String zzcF() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected String zzcG() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    protected zzai zzcT(IBinder iBinder) {
        return zzai.zza.zzcR(iBinder);
    }

    public void zzm(zzb<DataItemBuffer> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataItemBuffer) {
        ((zzai) zzjb()).zzb(new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataItemBuffer));
    }

    public void zzn(zzb<GetLocalNodeResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult) {
        ((zzai) zzjb()).zzc(new zzg(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult));
    }

    public void zzo(zzb<GetConnectedNodesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult) {
        ((zzai) zzjb()).zzd(new zzc(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult));
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzcT(iBinder);
    }
}
