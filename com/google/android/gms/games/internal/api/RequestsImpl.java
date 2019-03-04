package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {
        private UpdateRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzam(status);
        }

        public UpdateRequestsResult zzam(final Status status) {
            return new UpdateRequestsResult(this) {
                final /* synthetic */ UpdateRequestsImpl zzahg;

                public Set<String> getRequestIds() {
                    return null;
                }

                public int getRequestOutcome(String str) {
                    throw new IllegalArgumentException("Unknown request ID " + str);
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {
        private LoadRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return zzak(status);
        }

        public LoadRequestsResult zzak(final Status status) {
            return new LoadRequestsResult(this) {
                final /* synthetic */ LoadRequestsImpl zzahe;

                public GameRequestBuffer getRequests(int i) {
                    return new GameRequestBuffer(DataHolder.zzay(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzal(status);
        }

        public SendRequestResult zzal(final Status status) {
            return new SendRequestResult(this) {
                final /* synthetic */ SendRequestImpl zzahf;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    class C10954 extends SendRequestImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ String[] zzagZ;
        final /* synthetic */ int zzaha;
        final /* synthetic */ byte[] zzahb;
        final /* synthetic */ int zzahc;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzafB, this.zzagZ, this.zzaha, this.zzahb, this.zzahc);
        }
    }

    class C10965 extends SendRequestImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ String[] zzagZ;
        final /* synthetic */ int zzaha;
        final /* synthetic */ byte[] zzahb;
        final /* synthetic */ int zzahc;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzafB, this.zzagZ, this.zzaha, this.zzahb, this.zzahc);
        }
    }

    class C10976 extends UpdateRequestsImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ String zzagR;
        final /* synthetic */ String[] zzagV;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzafB, this.zzagR, this.zzagV);
        }
    }

    class C10987 extends LoadRequestsImpl {
        final /* synthetic */ String zzafB;
        final /* synthetic */ String zzagR;
        final /* synthetic */ int zzagX;
        final /* synthetic */ int zzagY;
        final /* synthetic */ int zzagc;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zza((zzb) this, this.zzafB, this.zzagR, this.zzagX, this.zzagY, this.zzagc);
        }
    }

    abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {
        public /* synthetic */ Result createFailedResult(Status status) {
            return zzaj(status);
        }

        public LoadRequestSummariesResult zzaj(final Status status) {
            return new LoadRequestSummariesResult(this) {
                final /* synthetic */ LoadRequestSummariesImpl zzahd;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class C10998 extends LoadRequestSummariesImpl {
        final /* synthetic */ String zzagR;
        final /* synthetic */ int zzagY;

        protected void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzf(this, this.zzagR, this.zzagY);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient googleApiClient, String str) {
        List arrayList = new ArrayList();
        arrayList.add(str);
        return acceptRequests(googleApiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient googleApiClient, List<String> list) {
        final String[] strArr = list == null ? null : (String[]) list.toArray(new String[list.size()]);
        return googleApiClient.zzb(new UpdateRequestsImpl(this, googleApiClient) {
            final /* synthetic */ RequestsImpl zzagW;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzb((zzb) this, strArr);
            }
        });
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient googleApiClient, String str) {
        List arrayList = new ArrayList();
        arrayList.add(str);
        return dismissRequests(googleApiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient googleApiClient, List<String> list) {
        final String[] strArr = list == null ? null : (String[]) list.toArray(new String[list.size()]);
        return googleApiClient.zzb(new UpdateRequestsImpl(this, googleApiClient) {
            final /* synthetic */ RequestsImpl zzagW;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zzc((zzb) this, strArr);
            }
        });
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) bundle.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent intent) {
        return intent == null ? new ArrayList() : getGameRequestsFromBundle(intent.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient).zznG();
    }

    public int getMaxLifetimeDays(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient).zznI();
    }

    public int getMaxPayloadSize(GoogleApiClient googleApiClient) {
        return Games.zzd(googleApiClient).zznH();
    }

    public Intent getSendIntent(GoogleApiClient googleApiClient, int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        return Games.zzd(googleApiClient).zza(i, bArr, i2, bitmap, str);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient googleApiClient, int i, int i2, int i3) {
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        return googleApiClient.zza(new LoadRequestsImpl(this, googleApiClient) {
            final /* synthetic */ RequestsImpl zzagW;

            protected void zza(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.zza((zzb) this, i4, i5, i6);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient googleApiClient, OnRequestReceivedListener onRequestReceivedListener) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzd(googleApiClient.zzf(onRequestReceivedListener));
        }
    }

    public void unregisterRequestListener(GoogleApiClient googleApiClient) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zznA();
        }
    }
}
