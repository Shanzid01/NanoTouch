package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.mopub.common.C1505m;
import com.mopub.common.C1506n;
import com.mopub.common.C1507o;
import com.mopub.common.C1511s;
import com.mopub.common.C1514v;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.p050b.C1478a;
import com.mopub.common.p050b.C1481d;
import com.mopub.common.p050b.C1482e;
import com.mopub.common.p050b.C1486i;
import com.mopub.common.p050b.C1490m;
import com.mopub.common.p050b.C1493p;
import com.mopub.mobileads.util.vast.C1563a;
import com.mopub.mobileads.util.vast.C1565c;
import com.slideme.sam.manager.model.data.dynamic.LayoutTagTable;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.methods.HttpGet;

public class VastVideoViewController extends BaseVideoViewController implements C1507o {
    private static final ThreadPoolExecutor f2367a = new ThreadPoolExecutor(10, 50, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final C1565c f2368b;
    private final C1563a f2369c;
    private final ca f2370d;
    private final VideoView f2371e;
    private final ImageView f2372f;
    private final OnTouchListener f2373g;
    private final Handler f2374h = new Handler();
    private final Runnable f2375i;
    private boolean f2376j = false;
    private int f2377k = FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS;
    private boolean f2378l;
    private boolean f2379m;
    private boolean f2380n;
    private boolean f2381o;
    private boolean f2382p;
    private int f2383q = -1;
    private boolean f2384r;
    private int f2385s = 0;

    VastVideoViewController(Context context, Bundle bundle, long j, BaseVideoViewControllerListener baseVideoViewControllerListener) {
        super(context, j, baseVideoViewControllerListener);
        Serializable serializable = bundle.getSerializable("vast_video_configuration");
        if (serializable == null || !(serializable instanceof C1565c)) {
            throw new IllegalStateException("VastVideoConfiguration is invalid");
        }
        this.f2368b = (C1565c) serializable;
        if (this.f2368b.m4707j() == null) {
            throw new IllegalStateException("VastVideoConfiguration does not have a video disk path");
        }
        this.f2369c = this.f2368b.m4708k();
        this.f2373g = new cc(this);
        m4418a(context);
        this.f2371e = m4429c(context);
        this.f2371e.requestFocus();
        this.f2370d = m4425b(context);
        m4292i().addView(this.f2370d);
        this.f2372f = m4432d(context);
        C1511s.m4152a(this.f2368b.m4687a());
        this.f2375i = m4444l();
    }

    VideoView mo4125b() {
        return this.f2371e;
    }

    void mo4124a() {
        super.mo4124a();
        m4290g().onSetRequestedOrientation(0);
        m4282a("com.mopub.action.interstitial.show");
        m4442k();
    }

    void mo4127d() {
        this.f2385s = 0;
        m4452p();
        this.f2371e.seekTo(this.f2383q);
        if (!this.f2384r) {
            this.f2371e.start();
        }
    }

    void mo4126c() {
        m4455q();
        this.f2383q = this.f2371e.getCurrentPosition();
        this.f2371e.pause();
    }

    void mo4128e() {
        m4455q();
        m4282a("com.mopub.action.interstitial.dismiss");
    }

    boolean mo4135f() {
        return this.f2378l;
    }

    void mo4134a(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            m4290g().onFinish();
        }
    }

    public void mo4076a(String str, C1505m c1505m) {
        if (c1505m != null && c1505m.m4132b() == 200) {
            Bitmap a = C1514v.m4154a(c1505m);
            if (a != null) {
                int b = C1481d.m4058b((float) a.getWidth(), m4291h());
                int b2 = C1481d.m4058b((float) a.getHeight(), m4291h());
                int measuredWidth = this.f2372f.getMeasuredWidth();
                int measuredHeight = this.f2372f.getMeasuredHeight();
                if (b < measuredWidth && b2 < measuredHeight) {
                    this.f2372f.getLayoutParams().width = b;
                    this.f2372f.getLayoutParams().height = b2;
                }
                this.f2372f.setImageBitmap(a);
                this.f2372f.setOnClickListener(new cd(this));
            }
        }
    }

    private void m4442k() {
        if (this.f2369c != null) {
            try {
                HttpGet httpGet = new HttpGet(this.f2369c.m4684a());
                C1478a.m4050a(new C1506n(this), httpGet);
            } catch (Throwable e) {
                C1486i.m4077a("Failed to download companion ad", e);
            }
        }
    }

    private Runnable m4444l() {
        return new ce(this);
    }

    private void m4418a(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{Color.argb(0, 0, 0, 0), Color.argb(255, 0, 0, 0)});
        m4292i().setBackgroundDrawable(new LayerDrawable(new Drawable[]{C1482e.THATCHED_BACKGROUND.decodeImage(context), gradientDrawable}));
    }

    private ca m4425b(Context context) {
        ca caVar = new ca(context);
        caVar.m4635a(new cf(this));
        caVar.m4637b(this.f2373g);
        return caVar;
    }

    private VideoView m4429c(Context context) {
        VideoView videoView = new VideoView(context);
        videoView.setOnPreparedListener(new cg(this));
        videoView.setOnTouchListener(this.f2373g);
        videoView.setOnCompletionListener(new ch(this, videoView));
        videoView.setOnErrorListener(new ci(this));
        videoView.setVideoPath(this.f2368b.m4707j());
        return videoView;
    }

    boolean m4459a(MediaPlayer mediaPlayer, int i, int i2) {
        Closeable closeable;
        Throwable th;
        if (!C1493p.currentApiLevel().isBelow(C1493p.JELLY_BEAN) || i != 1 || i2 != Integer.MIN_VALUE || this.f2385s >= 1) {
            return false;
        }
        Closeable closeable2 = null;
        try {
            mediaPlayer.reset();
            Closeable fileInputStream = new FileInputStream(new File(this.f2368b.m4707j()));
            try {
                mediaPlayer.setDataSource(fileInputStream.getFD());
                mediaPlayer.prepareAsync();
                this.f2371e.start();
                C1490m.m4085a(fileInputStream);
                this.f2385s++;
                return true;
            } catch (Exception e) {
                closeable = fileInputStream;
                C1490m.m4085a(closeable);
                this.f2385s++;
                return false;
            } catch (Throwable th2) {
                th = th2;
                closeable2 = fileInputStream;
                C1490m.m4085a(closeable2);
                this.f2385s++;
                throw th;
            }
        } catch (Exception e2) {
            closeable = null;
            C1490m.m4085a(closeable);
            this.f2385s++;
            return false;
        } catch (Throwable th3) {
            th = th3;
            C1490m.m4085a(closeable2);
            this.f2385s++;
            throw th;
        }
    }

    private ImageView m4432d(Context context) {
        View relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(17);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, this.f2370d.getId());
        m4292i().addView(relativeLayout, layoutParams);
        View imageView = new ImageView(context);
        imageView.setVisibility(4);
        relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        return imageView;
    }

    private void m4421a(List<String> list, String str) {
        C1511s.m4152a(list);
        m4293j();
        Bundle bundle = new Bundle();
        bundle.putString(LayoutTagTable.URL, str);
        m4290g().onStartActivityForResult(MoPubBrowser.class, 1, bundle);
    }

    private boolean m4422a(int i) {
        return i >= 16000;
    }

    private void m4446m() {
        this.f2378l = true;
        this.f2370d.m4633a();
    }

    private boolean m4449n() {
        return !this.f2378l && this.f2371e.getCurrentPosition() > this.f2377k;
    }

    private boolean m4451o() {
        return this.f2378l;
    }

    private void m4452p() {
        if (!this.f2376j) {
            this.f2376j = true;
            this.f2374h.post(this.f2375i);
        }
    }

    private void m4455q() {
        if (this.f2376j) {
            this.f2376j = false;
            this.f2374h.removeCallbacks(this.f2375i);
        }
    }
}
