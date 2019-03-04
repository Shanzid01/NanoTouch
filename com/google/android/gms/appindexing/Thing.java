package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.PlusShare;

public class Thing {
    final Bundle zzGJ;

    public class Builder {
        final Bundle zzGK = new Bundle();

        public Thing build() {
            return new Thing(this.zzGK);
        }

        public Builder put(String str, Thing thing) {
            zzx.zzl(str);
            if (thing != null) {
                this.zzGK.putParcelable(str, thing.zzGJ);
            }
            return this;
        }

        public Builder put(String str, String str2) {
            zzx.zzl(str);
            if (str2 != null) {
                this.zzGK.putString(str, str2);
            }
            return this;
        }

        public Builder setDescription(String str) {
            put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, str);
            return this;
        }

        public Builder setId(String str) {
            if (str != null) {
                put("id", str);
            }
            return this;
        }

        public Builder setName(String str) {
            zzx.zzl(str);
            put("name", str);
            return this;
        }

        public Builder setType(String str) {
            put("type", str);
            return this;
        }

        public Builder setUrl(Uri uri) {
            zzx.zzl(uri);
            put("url", uri.toString());
            return this;
        }
    }

    Thing(Bundle bundle) {
        this.zzGJ = bundle;
    }

    public Bundle zzgZ() {
        return this.zzGJ;
    }
}
