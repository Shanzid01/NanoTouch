package com.google.android.gms.fitness;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.concurrent.TimeUnit;

public interface HistoryApi {

    public class ViewIntentBuilder {
        private final Context mContext;
        private long zzON;
        private final DataType zzYo;
        private DataSource zzYp;
        private long zzYq;
        private String zzYr;

        public ViewIntentBuilder(Context context, DataType dataType) {
            this.mContext = context;
            this.zzYo = dataType;
        }

        private Intent zzi(Intent intent) {
            if (this.zzYr == null) {
                return intent;
            }
            Intent intent2 = new Intent(intent).setPackage(this.zzYr);
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent2, 0);
            if (resolveActivity == null) {
                return intent;
            }
            intent2.setComponent(new ComponentName(this.zzYr, resolveActivity.activityInfo.name));
            return intent2;
        }

        public Intent build() {
            boolean z = true;
            zzx.zza(this.zzON > 0, (Object) "Start time must be set");
            if (this.zzYq <= this.zzON) {
                z = false;
            }
            zzx.zza(z, (Object) "End time must be set and after start time");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(DataType.getMimeType(this.zzYp.getDataType()));
            intent.putExtra(Fitness.EXTRA_START_TIME, this.zzON);
            intent.putExtra(Fitness.EXTRA_END_TIME, this.zzYq);
            zzc.zza(this.zzYp, intent, DataSource.EXTRA_DATA_SOURCE);
            return zzi(intent);
        }

        public ViewIntentBuilder setDataSource(DataSource dataSource) {
            zzx.zzb(dataSource.getDataType().equals(this.zzYo), "Data source %s is not for the data type %s", dataSource, this.zzYo);
            this.zzYp = dataSource;
            return this;
        }

        public ViewIntentBuilder setPreferredApplication(String str) {
            this.zzYr = str;
            return this;
        }

        public ViewIntentBuilder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            this.zzON = timeUnit.toMillis(j);
            this.zzYq = timeUnit.toMillis(j2);
            return this;
        }
    }

    PendingResult<Status> deleteData(GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest);

    PendingResult<Status> insertData(GoogleApiClient googleApiClient, DataSet dataSet);

    PendingResult<DataReadResult> readData(GoogleApiClient googleApiClient, DataReadRequest dataReadRequest);
}
