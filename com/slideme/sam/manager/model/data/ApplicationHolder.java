package com.slideme.sam.manager.model.data;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.widget.ImageView;
import com.p026b.p027a.p034b.C0509f;
import com.p026b.p027a.p034b.C0510g;
import com.p026b.p027a.p034b.p035a.C0476d;
import com.p026b.p027a.p034b.p035a.C0477e;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.Application.ImageSize;
import com.slideme.sam.manager.model.p054b.C1827a;
import com.slideme.sam.manager.model.p054b.C1828b;
import com.slideme.sam.manager.net.C1782r;
import com.slideme.sam.manager.util.C1922m;
import com.slideme.sam.manager.view.C1950a;
import com.slideme.sam.manager.view.touchme.YoutubePreviewButton;
import java.util.Date;

public class ApplicationHolder implements Parcelable {
    public static final Creator<ApplicationHolder> CREATOR = new C18361();
    public Application app;
    public Changelog changelog;
    public String description;
    public String privacy;
    public String terms;

    public interface OnTextReadyListener {
        void textReady(String str);
    }

    class C18361 implements Creator<ApplicationHolder> {
        C18361() {
        }

        public ApplicationHolder createFromParcel(Parcel parcel) {
            return new ApplicationHolder(parcel);
        }

        public ApplicationHolder[] newArray(int i) {
            return new ApplicationHolder[i];
        }
    }

    public ApplicationHolder(Application application) {
        this.app = null;
        this.description = "";
        this.terms = "";
        this.privacy = "";
        this.changelog = null;
        this.app = application;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.terms);
        parcel.writeString(this.description);
        parcel.writeString(this.privacy);
        parcel.writeParcelable(this.changelog, 0);
        parcel.writeParcelable(this.app, 0);
    }

    private ApplicationHolder(Parcel parcel) {
        this.app = null;
        this.description = "";
        this.terms = "";
        this.privacy = "";
        this.changelog = null;
        this.terms = parcel.readString();
        this.description = parcel.readString();
        this.privacy = parcel.readString();
        this.changelog = (Changelog) parcel.readParcelable(Changelog.class.getClassLoader());
        this.app = (Application) parcel.readParcelable(Application.class.getClassLoader());
    }

    public C1828b getInstallState(Context context) {
        return C1827a.m5491a(context, this.app.packageName, this.app.versionCode);
    }

    public float getStarRating() {
        return (float) (this.app.rating * 0.05d);
    }

    public void downloadPrivacyPolicy(final OnTextReadyListener onTextReadyListener) {
        if (TextUtils.isEmpty(this.privacy)) {
            SAM.f2614g.m5623a(this.app.privacyUrl, new C1782r() {
                public void onFinish(String str) {
                    OnTextReadyListener onTextReadyListener = onTextReadyListener;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    onTextReadyListener.textReady(str);
                }
            });
        } else {
            onTextReadyListener.textReady(this.privacy);
        }
    }

    public void downloadTerms(final OnTextReadyListener onTextReadyListener) {
        if (TextUtils.isEmpty(this.terms)) {
            SAM.f2614g.m5623a(this.app.termsUrl, new C1782r() {
                public void onFinish(String str) {
                    OnTextReadyListener onTextReadyListener = onTextReadyListener;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    onTextReadyListener.textReady(str);
                }
            });
        } else {
            onTextReadyListener.textReady(this.terms);
        }
    }

    public void setImage(ImageView imageView, String str, int i, C0476d c0476d) {
        setImage(imageView, str, i, c0476d, true);
    }

    public void setImage(ImageView imageView, String str, int i, C0476d c0476d, boolean z) {
        C0509f a = new C0509f().m3079b().m3076a(Config.RGB_565).m3077a(C0477e.IN_SAMPLE_INT);
        if (z) {
            a.m3074a();
        }
        if (i > 0) {
            a.m3075a(i);
        }
        try {
            C0510g.m3081a().m3084a(str, imageView, a.m3080c(), c0476d);
        } catch (Throwable e) {
            C1922m.m5791a(e);
        }
    }

    public void setIcon(ImageView imageView, ImageSize imageSize, C0476d c0476d) {
        setImage(imageView, getScaledIconUrl(imageSize), R.drawable.ic_loading, c0476d);
    }

    public int describeContents() {
        return 0;
    }

    public void setYoutubeButton(YoutubePreviewButton youtubePreviewButton, C0476d c0476d) {
        setImage(youtubePreviewButton, this.app.videoThumb, R.drawable.dummy_youtube_preview, c0476d);
    }

    public String getVersionText() {
        return "v" + this.app.version;
    }

    public String downloadDescriptionSynch() {
        if (TextUtils.isEmpty(this.description)) {
            this.description = SAM.f2614g.m5630b(this.app.descriptionUrl);
        }
        return this.description;
    }

    public Changelog downloadChangelogSynch(Context context) {
        if (this.changelog == null) {
            this.changelog = new Changelog(SAM.f2614g.m5630b(this.app.changelogUrl.concat("?versionName=").concat(context.getString(R.string.sam_version_num))));
        }
        return this.changelog;
    }

    public void downloadPrimarySynch(Context context) {
        downloadDescriptionSynch();
        downloadChangelogSynch(context);
    }

    public CharSequence getLastUpdated(Context context) {
        return C1950a.m5859a(context, new Date(this.app.modifiedTime));
    }

    public boolean isOffer() {
        return this.app.priceOld != -1.0d;
    }

    public boolean isAdProxyOffer() {
        return this.app.payout > 0.0d;
    }

    public String getScaledIconUrl(ImageSize imageSize) {
        if (this.app.resources.icon.startsWith("http://")) {
            this.app.resources.icon = this.app.resources.icon.replace("http://", "https://");
        }
        if (this.app.resources.icon.contains("files/imagecache/icon")) {
            return this.app.resources.icon.replace("icon/", "icon-" + imageSize + "/");
        }
        return this.app.resources.icon;
    }

    public String getScaledScreenshotUrl(String str, ImageSize imageSize) {
        if (str.startsWith("http://")) {
            str = str.replace("http://", "https://");
        }
        return str.replace("files", "files/imagecache/screenshot-" + imageSize);
    }

    public String getScaledScreenshotUrl(int i, ImageSize imageSize) {
        String str = (String) this.app.resources.screenshots.get(i);
        if (str.startsWith("http://")) {
            str = str.replace("http://", "https://");
        }
        return str.replace("files", "files/imagecache/screenshot-" + imageSize);
    }

    public Intent getVideoIntent() {
        return new Intent("android.intent.action.VIEW", Uri.parse(getCanonicalVideoUrl()));
    }

    private String getCanonicalVideoUrl() {
        if (this.app.videoURL.contains("youtube.com/v")) {
            return "http://www.youtube.com/watch?v=" + this.app.videoURL.split("/")[4];
        }
        return this.app.videoURL;
    }
}
