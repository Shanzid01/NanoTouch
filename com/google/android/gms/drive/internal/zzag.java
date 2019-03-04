package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;
import com.google.android.gms.drive.execution.internal.GetContentTransferInfoRequest;

public interface zzag extends IInterface {

    public abstract class zza extends Binder implements zzag {

        class zza implements zzag {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    IntentSender intentSender = obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intentSender;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    IntentSender intentSender = obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intentSender;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (realtimeDocumentSyncRequest != null) {
                        obtain.writeInt(1);
                        realtimeDocumentSyncRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetContentTransferInfoRequest getContentTransferInfoRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getContentTransferInfoRequest != null) {
                        obtain.writeInt(1);
                        getContentTransferInfoRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AddEventListenerRequest addEventListenerRequest, zzai com_google_android_gms_drive_internal_zzai, String str, zzah com_google_android_gms_drive_internal_zzah) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addEventListenerRequest != null) {
                        obtain.writeInt(1);
                        addEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzai != null ? com_google_android_gms_drive_internal_zzai.asBinder() : null);
                    obtain.writeString(str);
                    if (com_google_android_gms_drive_internal_zzah != null) {
                        iBinder = com_google_android_gms_drive_internal_zzah.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AuthorizeAccessRequest authorizeAccessRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (authorizeAccessRequest != null) {
                        obtain.writeInt(1);
                        authorizeAccessRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (cancelPendingActionsRequest != null) {
                        obtain.writeInt(1);
                        cancelPendingActionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (checkResourceIdsExistRequest != null) {
                        obtain.writeInt(1);
                        checkResourceIdsExistRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsAndUpdateMetadataRequest != null) {
                        obtain.writeInt(1);
                        closeContentsAndUpdateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CloseContentsRequest closeContentsRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        obtain.writeInt(1);
                        closeContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateContentsRequest createContentsRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        obtain.writeInt(1);
                        createContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateFileRequest createFileRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        obtain.writeInt(1);
                        createFileRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateFolderRequest createFolderRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        obtain.writeInt(1);
                        createFolderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DeleteResourceRequest deleteResourceRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (deleteResourceRequest != null) {
                        obtain.writeInt(1);
                        deleteResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DisconnectRequest disconnectRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(FetchThumbnailRequest fetchThumbnailRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (fetchThumbnailRequest != null) {
                        obtain.writeInt(1);
                        fetchThumbnailRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetChangesRequest getChangesRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getChangesRequest != null) {
                        obtain.writeInt(1);
                        getChangesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getDriveIdFromUniqueIdentifierRequest != null) {
                        obtain.writeInt(1);
                        getDriveIdFromUniqueIdentifierRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetMetadataRequest getMetadataRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        obtain.writeInt(1);
                        getMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ListParentsRequest listParentsRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (listParentsRequest != null) {
                        obtain.writeInt(1);
                        listParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LoadRealtimeRequest loadRealtimeRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (loadRealtimeRequest != null) {
                        obtain.writeInt(1);
                        loadRealtimeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OpenContentsRequest openContentsRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        obtain.writeInt(1);
                        openContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(QueryRequest queryRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(QueryRequest queryRequest, zzai com_google_android_gms_drive_internal_zzai, zzai com_google_android_gms_drive_internal_zzai2, zzah com_google_android_gms_drive_internal_zzah) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzai != null ? com_google_android_gms_drive_internal_zzai.asBinder() : null);
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzai2 != null ? com_google_android_gms_drive_internal_zzai2.asBinder() : null);
                    if (com_google_android_gms_drive_internal_zzah != null) {
                        iBinder = com_google_android_gms_drive_internal_zzah.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RemoveEventListenerRequest removeEventListenerRequest, zzai com_google_android_gms_drive_internal_zzai, String str, zzah com_google_android_gms_drive_internal_zzah) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removeEventListenerRequest != null) {
                        obtain.writeInt(1);
                        removeEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzai != null ? com_google_android_gms_drive_internal_zzai.asBinder() : null);
                    obtain.writeString(str);
                    if (com_google_android_gms_drive_internal_zzah != null) {
                        iBinder = com_google_android_gms_drive_internal_zzah.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setDrivePreferencesRequest != null) {
                        obtain.writeInt(1);
                        setDrivePreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setFileUploadPreferencesRequest != null) {
                        obtain.writeInt(1);
                        setFileUploadPreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetResourceParentsRequest setResourceParentsRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setResourceParentsRequest != null) {
                        obtain.writeInt(1);
                        setResourceParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(TrashResourceRequest trashResourceRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (trashResourceRequest != null) {
                        obtain.writeInt(1);
                        trashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (unsubscribeResourceRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UntrashResourceRequest untrashResourceRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (untrashResourceRequest != null) {
                        obtain.writeInt(1);
                        untrashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UpdateMetadataRequest updateMetadataRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        obtain.writeInt(1);
                        updateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzai com_google_android_gms_drive_internal_zzai, zzah com_google_android_gms_drive_internal_zzah) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzai != null ? com_google_android_gms_drive_internal_zzai.asBinder() : null);
                    if (com_google_android_gms_drive_internal_zzah != null) {
                        iBinder = com_google_android_gms_drive_internal_zzah.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(QueryRequest queryRequest, zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(zzah com_google_android_gms_drive_internal_zzah) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzah != null ? com_google_android_gms_drive_internal_zzah.asBinder() : null);
                    this.zzle.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzag zzac(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzag)) ? new zza(iBinder) : (zzag) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            UnsubscribeResourceRequest unsubscribeResourceRequest = null;
            QueryRequest queryRequest;
            IntentSender zza;
            switch (i) {
                case 1:
                    GetMetadataRequest getMetadataRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        getMetadataRequest = (GetMetadataRequest) GetMetadataRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(getMetadataRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        queryRequest = (QueryRequest) QueryRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(queryRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    UpdateMetadataRequest updateMetadataRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        updateMetadataRequest = (UpdateMetadataRequest) UpdateMetadataRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(updateMetadataRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    CreateContentsRequest createContentsRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        createContentsRequest = (CreateContentsRequest) CreateContentsRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(createContentsRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    CreateFileRequest createFileRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        createFileRequest = (CreateFileRequest) CreateFileRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(createFileRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    CreateFolderRequest createFolderRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        createFolderRequest = (CreateFolderRequest) CreateFolderRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(createFolderRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    OpenContentsRequest openContentsRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        openContentsRequest = (OpenContentsRequest) OpenContentsRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(openContentsRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    CloseContentsRequest closeContentsRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        closeContentsRequest = (CloseContentsRequest) CloseContentsRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(closeContentsRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    OpenFileIntentSenderRequest openFileIntentSenderRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        openFileIntentSenderRequest = (OpenFileIntentSenderRequest) OpenFileIntentSenderRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza = zza(openFileIntentSenderRequest);
                    parcel2.writeNoException();
                    if (zza != null) {
                        parcel2.writeInt(1);
                        zza.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 11:
                    CreateFileIntentSenderRequest createFileIntentSenderRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        createFileIntentSenderRequest = (CreateFileIntentSenderRequest) CreateFileIntentSenderRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza = zza(createFileIntentSenderRequest);
                    parcel2.writeNoException();
                    if (zza != null) {
                        parcel2.writeInt(1);
                        zza.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    AuthorizeAccessRequest authorizeAccessRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        authorizeAccessRequest = (AuthorizeAccessRequest) AuthorizeAccessRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(authorizeAccessRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    ListParentsRequest listParentsRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        listParentsRequest = (ListParentsRequest) ListParentsRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(listParentsRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    AddEventListenerRequest addEventListenerRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        addEventListenerRequest = (AddEventListenerRequest) AddEventListenerRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(addEventListenerRequest, com.google.android.gms.drive.internal.zzai.zza.zzae(parcel.readStrongBinder()), parcel.readString(), com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    RemoveEventListenerRequest removeEventListenerRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        removeEventListenerRequest = (RemoveEventListenerRequest) RemoveEventListenerRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(removeEventListenerRequest, com.google.android.gms.drive.internal.zzai.zza.zzae(parcel.readStrongBinder()), parcel.readString(), com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    DisconnectRequest disconnectRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        disconnectRequest = (DisconnectRequest) DisconnectRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(disconnectRequest);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    TrashResourceRequest trashResourceRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        trashResourceRequest = (TrashResourceRequest) TrashResourceRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(trashResourceRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 18:
                    CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        closeContentsAndUpdateMetadataRequest = (CloseContentsAndUpdateMetadataRequest) CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(closeContentsAndUpdateMetadataRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        queryRequest = (QueryRequest) QueryRequest.CREATOR.createFromParcel(parcel);
                    }
                    zzb(queryRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzb(com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzc(com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzd(com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zze(com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    DeleteResourceRequest deleteResourceRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        deleteResourceRequest = (DeleteResourceRequest) DeleteResourceRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(deleteResourceRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 27:
                    LoadRealtimeRequest loadRealtimeRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        loadRealtimeRequest = (LoadRealtimeRequest) LoadRealtimeRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(loadRealtimeRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 28:
                    SetResourceParentsRequest setResourceParentsRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        setResourceParentsRequest = (SetResourceParentsRequest) SetResourceParentsRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(setResourceParentsRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 29:
                    GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        getDriveIdFromUniqueIdentifierRequest = (GetDriveIdFromUniqueIdentifierRequest) GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(getDriveIdFromUniqueIdentifierRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 30:
                    CheckResourceIdsExistRequest checkResourceIdsExistRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        checkResourceIdsExistRequest = (CheckResourceIdsExistRequest) CheckResourceIdsExistRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(checkResourceIdsExistRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzf(com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzg(com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 33:
                    SetDrivePreferencesRequest setDrivePreferencesRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        setDrivePreferencesRequest = (SetDrivePreferencesRequest) SetDrivePreferencesRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(setDrivePreferencesRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 34:
                    RealtimeDocumentSyncRequest realtimeDocumentSyncRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        realtimeDocumentSyncRequest = (RealtimeDocumentSyncRequest) RealtimeDocumentSyncRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(realtimeDocumentSyncRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzh(com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    SetFileUploadPreferencesRequest setFileUploadPreferencesRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        setFileUploadPreferencesRequest = (SetFileUploadPreferencesRequest) SetFileUploadPreferencesRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(setFileUploadPreferencesRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 37:
                    CancelPendingActionsRequest cancelPendingActionsRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        cancelPendingActionsRequest = (CancelPendingActionsRequest) CancelPendingActionsRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(cancelPendingActionsRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 38:
                    UntrashResourceRequest untrashResourceRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        untrashResourceRequest = (UntrashResourceRequest) UntrashResourceRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(untrashResourceRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        queryRequest = (QueryRequest) QueryRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(queryRequest, com.google.android.gms.drive.internal.zzai.zza.zzae(parcel.readStrongBinder()), com.google.android.gms.drive.internal.zzai.zza.zzae(parcel.readStrongBinder()), com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(com.google.android.gms.drive.internal.zzai.zza.zzae(parcel.readStrongBinder()), com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzi(com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 42:
                    FetchThumbnailRequest fetchThumbnailRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        fetchThumbnailRequest = (FetchThumbnailRequest) FetchThumbnailRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(fetchThumbnailRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzj(com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 44:
                    GetChangesRequest getChangesRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        getChangesRequest = (GetChangesRequest) GetChangesRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(getChangesRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 45:
                    GetContentTransferInfoRequest getContentTransferInfoRequest;
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        getContentTransferInfoRequest = (GetContentTransferInfoRequest) GetContentTransferInfoRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(getContentTransferInfoRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 46:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        unsubscribeResourceRequest = (UnsubscribeResourceRequest) UnsubscribeResourceRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(unsubscribeResourceRequest, com.google.android.gms.drive.internal.zzah.zza.zzad(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.internal.IDriveService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest);

    IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest);

    void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(GetContentTransferInfoRequest getContentTransferInfoRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(AddEventListenerRequest addEventListenerRequest, zzai com_google_android_gms_drive_internal_zzai, String str, zzah com_google_android_gms_drive_internal_zzah);

    void zza(AuthorizeAccessRequest authorizeAccessRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(CloseContentsRequest closeContentsRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(CreateContentsRequest createContentsRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(CreateFileRequest createFileRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(CreateFolderRequest createFolderRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(DeleteResourceRequest deleteResourceRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(DisconnectRequest disconnectRequest);

    void zza(FetchThumbnailRequest fetchThumbnailRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(GetChangesRequest getChangesRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(GetMetadataRequest getMetadataRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(ListParentsRequest listParentsRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(LoadRealtimeRequest loadRealtimeRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(OpenContentsRequest openContentsRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(QueryRequest queryRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(QueryRequest queryRequest, zzai com_google_android_gms_drive_internal_zzai, zzai com_google_android_gms_drive_internal_zzai2, zzah com_google_android_gms_drive_internal_zzah);

    void zza(RemoveEventListenerRequest removeEventListenerRequest, zzai com_google_android_gms_drive_internal_zzai, String str, zzah com_google_android_gms_drive_internal_zzah);

    void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(SetResourceParentsRequest setResourceParentsRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(TrashResourceRequest trashResourceRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(UntrashResourceRequest untrashResourceRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(UpdateMetadataRequest updateMetadataRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zza(zzah com_google_android_gms_drive_internal_zzah);

    void zza(zzai com_google_android_gms_drive_internal_zzai, zzah com_google_android_gms_drive_internal_zzah);

    void zzb(QueryRequest queryRequest, zzah com_google_android_gms_drive_internal_zzah);

    void zzb(zzah com_google_android_gms_drive_internal_zzah);

    void zzc(zzah com_google_android_gms_drive_internal_zzah);

    void zzd(zzah com_google_android_gms_drive_internal_zzah);

    void zze(zzah com_google_android_gms_drive_internal_zzah);

    void zzf(zzah com_google_android_gms_drive_internal_zzah);

    void zzg(zzah com_google_android_gms_drive_internal_zzah);

    void zzh(zzah com_google_android_gms_drive_internal_zzah);

    void zzi(zzah com_google_android_gms_drive_internal_zzah);

    void zzj(zzah com_google_android_gms_drive_internal_zzah);
}
