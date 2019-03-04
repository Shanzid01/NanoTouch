package com.facebook.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.content.C0090q;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.android.C0572R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.LikeActionController;
import com.facebook.internal.LikeActionController.CreationCallback;
import com.facebook.internal.LikeBoxCountView;
import com.facebook.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition;
import com.facebook.internal.LikeButton;
import com.facebook.internal.Utility;

public class LikeView extends FrameLayout {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$facebook$widget$LikeView$AuxiliaryViewPosition = null;
    private static final int NO_FOREGROUND_COLOR = -1;
    private AuxiliaryViewPosition auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
    private BroadcastReceiver broadcastReceiver;
    private LinearLayout containerView;
    private LikeActionControllerCreationCallback creationCallback;
    private int edgePadding;
    private int foregroundColor = -1;
    private HorizontalAlignment horizontalAlignment = HorizontalAlignment.DEFAULT;
    private int internalPadding;
    private LikeActionController likeActionController;
    private LikeBoxCountView likeBoxCountView;
    private LikeButton likeButton;
    private Style likeViewStyle = Style.DEFAULT;
    private String objectId;
    private OnErrorListener onErrorListener;
    private TextView socialSentenceView;

    class C06131 implements OnClickListener {
        C06131() {
        }

        public void onClick(View view) {
            LikeView.this.toggleLike();
        }
    }

    public enum AuxiliaryViewPosition {
        BOTTOM("bottom", 0),
        INLINE("inline", 1),
        TOP("top", 2);
        
        static AuxiliaryViewPosition DEFAULT;
        private int intValue;
        private String stringValue;

        static {
            DEFAULT = BOTTOM;
        }

        static AuxiliaryViewPosition fromInt(int i) {
            for (AuxiliaryViewPosition auxiliaryViewPosition : values()) {
                if (auxiliaryViewPosition.getValue() == i) {
                    return auxiliaryViewPosition;
                }
            }
            return null;
        }

        private AuxiliaryViewPosition(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public String toString() {
            return this.stringValue;
        }

        private int getValue() {
            return this.intValue;
        }
    }

    public enum HorizontalAlignment {
        CENTER("center", 0),
        LEFT("left", 1),
        RIGHT("right", 2);
        
        static HorizontalAlignment DEFAULT;
        private int intValue;
        private String stringValue;

        static {
            DEFAULT = CENTER;
        }

        static HorizontalAlignment fromInt(int i) {
            for (HorizontalAlignment horizontalAlignment : values()) {
                if (horizontalAlignment.getValue() == i) {
                    return horizontalAlignment;
                }
            }
            return null;
        }

        private HorizontalAlignment(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public String toString() {
            return this.stringValue;
        }

        private int getValue() {
            return this.intValue;
        }
    }

    class LikeActionControllerCreationCallback implements CreationCallback {
        private boolean isCancelled;

        private LikeActionControllerCreationCallback() {
        }

        public void cancel() {
            this.isCancelled = true;
        }

        public void onComplete(LikeActionController likeActionController) {
            if (!this.isCancelled) {
                LikeView.this.associateWithLikeActionController(likeActionController);
                LikeView.this.updateLikeStateAndLayout();
                LikeView.this.creationCallback = null;
            }
        }
    }

    class LikeControllerBroadcastReceiver extends BroadcastReceiver {
        private LikeControllerBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Object obj = 1;
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString(LikeActionController.ACTION_OBJECT_ID_KEY);
                if (!(Utility.isNullOrEmpty(string) || Utility.areObjectsEqual(LikeView.this.objectId, string))) {
                    obj = null;
                }
            }
            if (obj != null) {
                if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED.equals(action)) {
                    LikeView.this.updateLikeStateAndLayout();
                } else if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR.equals(action)) {
                    if (LikeView.this.onErrorListener != null) {
                        LikeView.this.onErrorListener.onError(extras);
                    }
                } else if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET.equals(action)) {
                    LikeView.this.setObjectIdForced(LikeView.this.objectId);
                    LikeView.this.updateLikeStateAndLayout();
                }
            }
        }
    }

    public interface OnErrorListener {
        void onError(Bundle bundle);
    }

    public enum Style {
        STANDARD("standard", 0),
        BUTTON("button", 1),
        BOX_COUNT("box_count", 2);
        
        static Style DEFAULT;
        private int intValue;
        private String stringValue;

        static {
            DEFAULT = STANDARD;
        }

        static Style fromInt(int i) {
            for (Style style : values()) {
                if (style.getValue() == i) {
                    return style;
                }
            }
            return null;
        }

        private Style(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public String toString() {
            return this.stringValue;
        }

        private int getValue() {
            return this.intValue;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$facebook$widget$LikeView$AuxiliaryViewPosition() {
        int[] iArr = $SWITCH_TABLE$com$facebook$widget$LikeView$AuxiliaryViewPosition;
        if (iArr == null) {
            iArr = new int[AuxiliaryViewPosition.values().length];
            try {
                iArr[AuxiliaryViewPosition.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AuxiliaryViewPosition.INLINE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AuxiliaryViewPosition.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$facebook$widget$LikeView$AuxiliaryViewPosition = iArr;
        }
        return iArr;
    }

    public static boolean handleOnActivityResult(Context context, int i, int i2, Intent intent) {
        return LikeActionController.handleOnActivityResult(context, i, i2, intent);
    }

    public LikeView(Context context) {
        super(context);
        initialize(context);
    }

    public LikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        parseAttributes(attributeSet);
        initialize(context);
    }

    public void setObjectId(String str) {
        String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(str, null);
        if (!Utility.areObjectsEqual(coerceValueIfNullOrEmpty, this.objectId)) {
            setObjectIdForced(coerceValueIfNullOrEmpty);
            updateLikeStateAndLayout();
        }
    }

    public void setLikeViewStyle(Style style) {
        if (style == null) {
            style = Style.DEFAULT;
        }
        if (this.likeViewStyle != style) {
            this.likeViewStyle = style;
            updateLayout();
        }
    }

    public void setAuxiliaryViewPosition(AuxiliaryViewPosition auxiliaryViewPosition) {
        if (auxiliaryViewPosition == null) {
            auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
        }
        if (this.auxiliaryViewPosition != auxiliaryViewPosition) {
            this.auxiliaryViewPosition = auxiliaryViewPosition;
            updateLayout();
        }
    }

    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        if (horizontalAlignment == null) {
            horizontalAlignment = HorizontalAlignment.DEFAULT;
        }
        if (this.horizontalAlignment != horizontalAlignment) {
            this.horizontalAlignment = horizontalAlignment;
            updateLayout();
        }
    }

    public void setForegroundColor(int i) {
        if (this.foregroundColor != i) {
            this.socialSentenceView.setTextColor(i);
        }
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    protected void onDetachedFromWindow() {
        setObjectId(null);
        super.onDetachedFromWindow();
    }

    private void parseAttributes(AttributeSet attributeSet) {
        if (attributeSet != null && getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0572R.styleable.com_facebook_like_view);
            if (obtainStyledAttributes != null) {
                this.objectId = Utility.coerceValueIfNullOrEmpty(obtainStyledAttributes.getString(C0572R.styleable.com_facebook_like_view_object_id), null);
                this.likeViewStyle = Style.fromInt(obtainStyledAttributes.getInt(C0572R.styleable.com_facebook_like_view_style, Style.DEFAULT.getValue()));
                if (this.likeViewStyle == null) {
                    throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
                }
                this.auxiliaryViewPosition = AuxiliaryViewPosition.fromInt(obtainStyledAttributes.getInt(C0572R.styleable.com_facebook_like_view_auxiliary_view_position, AuxiliaryViewPosition.DEFAULT.getValue()));
                if (this.auxiliaryViewPosition == null) {
                    throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
                }
                this.horizontalAlignment = HorizontalAlignment.fromInt(obtainStyledAttributes.getInt(C0572R.styleable.com_facebook_like_view_horizontal_alignment, HorizontalAlignment.DEFAULT.getValue()));
                if (this.horizontalAlignment == null) {
                    throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
                }
                this.foregroundColor = obtainStyledAttributes.getColor(C0572R.styleable.com_facebook_like_view_foreground_color, -1);
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void initialize(Context context) {
        this.edgePadding = getResources().getDimensionPixelSize(C0572R.dimen.com_facebook_likeview_edge_padding);
        this.internalPadding = getResources().getDimensionPixelSize(C0572R.dimen.com_facebook_likeview_internal_padding);
        if (this.foregroundColor == -1) {
            this.foregroundColor = getResources().getColor(C0572R.color.com_facebook_likeview_text_color);
        }
        setBackgroundColor(0);
        this.containerView = new LinearLayout(context);
        this.containerView.setLayoutParams(new LayoutParams(-2, -2));
        initializeLikeButton(context);
        initializeSocialSentenceView(context);
        initializeLikeCountView(context);
        this.containerView.addView(this.likeButton);
        this.containerView.addView(this.socialSentenceView);
        this.containerView.addView(this.likeBoxCountView);
        addView(this.containerView);
        setObjectIdForced(this.objectId);
        updateLikeStateAndLayout();
    }

    private void initializeLikeButton(Context context) {
        this.likeButton = new LikeButton(context, this.likeActionController != null ? this.likeActionController.isObjectLiked() : false);
        this.likeButton.setOnClickListener(new C06131());
        this.likeButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    private void initializeSocialSentenceView(Context context) {
        this.socialSentenceView = new TextView(context);
        this.socialSentenceView.setTextSize(0, getResources().getDimension(C0572R.dimen.com_facebook_likeview_text_size));
        this.socialSentenceView.setMaxLines(2);
        this.socialSentenceView.setTextColor(this.foregroundColor);
        this.socialSentenceView.setGravity(17);
        this.socialSentenceView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    }

    private void initializeLikeCountView(Context context) {
        this.likeBoxCountView = new LikeBoxCountView(context);
        this.likeBoxCountView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    private void toggleLike() {
        if (this.likeActionController != null) {
            this.likeActionController.toggleLike((Activity) getContext(), getAnalyticsParameters());
        }
    }

    private Bundle getAnalyticsParameters() {
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, this.likeViewStyle.toString());
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_AUXILIARY_POSITION, this.auxiliaryViewPosition.toString());
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, this.horizontalAlignment.toString());
        bundle.putString("object_id", Utility.coerceValueIfNullOrEmpty(this.objectId, ""));
        return bundle;
    }

    private void setObjectIdForced(String str) {
        tearDownObjectAssociations();
        this.objectId = str;
        if (!Utility.isNullOrEmpty(str)) {
            this.creationCallback = new LikeActionControllerCreationCallback();
            LikeActionController.getControllerForObjectId(getContext(), str, this.creationCallback);
        }
    }

    private void associateWithLikeActionController(LikeActionController likeActionController) {
        this.likeActionController = likeActionController;
        this.broadcastReceiver = new LikeControllerBroadcastReceiver();
        C0090q a = C0090q.m145a(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR);
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET);
        a.m149a(this.broadcastReceiver, intentFilter);
    }

    private void tearDownObjectAssociations() {
        if (this.broadcastReceiver != null) {
            C0090q.m145a(getContext()).m148a(this.broadcastReceiver);
            this.broadcastReceiver = null;
        }
        if (this.creationCallback != null) {
            this.creationCallback.cancel();
            this.creationCallback = null;
        }
        this.likeActionController = null;
    }

    private void updateLikeStateAndLayout() {
        if (this.likeActionController == null) {
            this.likeButton.setLikeState(false);
            this.socialSentenceView.setText(null);
            this.likeBoxCountView.setText(null);
        } else {
            this.likeButton.setLikeState(this.likeActionController.isObjectLiked());
            this.socialSentenceView.setText(this.likeActionController.getSocialSentence());
            this.likeBoxCountView.setText(this.likeActionController.getLikeCountString());
        }
        updateLayout();
    }

    private void updateLayout() {
        View view;
        int i = 1;
        LayoutParams layoutParams = (LayoutParams) this.containerView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.likeButton.getLayoutParams();
        int i2 = this.horizontalAlignment == HorizontalAlignment.LEFT ? 3 : this.horizontalAlignment == HorizontalAlignment.CENTER ? 1 : 5;
        layoutParams.gravity = i2 | 48;
        layoutParams2.gravity = i2;
        this.socialSentenceView.setVisibility(8);
        this.likeBoxCountView.setVisibility(8);
        if (this.likeViewStyle == Style.STANDARD && this.likeActionController != null && !Utility.isNullOrEmpty(this.likeActionController.getSocialSentence())) {
            view = this.socialSentenceView;
        } else if (this.likeViewStyle == Style.BOX_COUNT && this.likeActionController != null && !Utility.isNullOrEmpty(this.likeActionController.getLikeCountString())) {
            updateBoxCountCaretPosition();
            view = this.likeBoxCountView;
        } else {
            return;
        }
        view.setVisibility(0);
        ((LinearLayout.LayoutParams) view.getLayoutParams()).gravity = i2;
        LinearLayout linearLayout = this.containerView;
        if (this.auxiliaryViewPosition == AuxiliaryViewPosition.INLINE) {
            i = 0;
        }
        linearLayout.setOrientation(i);
        if (this.auxiliaryViewPosition == AuxiliaryViewPosition.TOP || (this.auxiliaryViewPosition == AuxiliaryViewPosition.INLINE && this.horizontalAlignment == HorizontalAlignment.RIGHT)) {
            this.containerView.removeView(this.likeButton);
            this.containerView.addView(this.likeButton);
        } else {
            this.containerView.removeView(view);
            this.containerView.addView(view);
        }
        switch ($SWITCH_TABLE$com$facebook$widget$LikeView$AuxiliaryViewPosition()[this.auxiliaryViewPosition.ordinal()]) {
            case 1:
                view.setPadding(this.edgePadding, this.internalPadding, this.edgePadding, this.edgePadding);
                return;
            case 2:
                if (this.horizontalAlignment == HorizontalAlignment.RIGHT) {
                    view.setPadding(this.edgePadding, this.edgePadding, this.internalPadding, this.edgePadding);
                    return;
                } else {
                    view.setPadding(this.internalPadding, this.edgePadding, this.edgePadding, this.edgePadding);
                    return;
                }
            case 3:
                view.setPadding(this.edgePadding, this.edgePadding, this.edgePadding, this.internalPadding);
                return;
            default:
                return;
        }
    }

    private void updateBoxCountCaretPosition() {
        switch ($SWITCH_TABLE$com$facebook$widget$LikeView$AuxiliaryViewPosition()[this.auxiliaryViewPosition.ordinal()]) {
            case 1:
                this.likeBoxCountView.setCaretPosition(LikeBoxCountViewCaretPosition.TOP);
                return;
            case 2:
                LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition;
                LikeBoxCountView likeBoxCountView = this.likeBoxCountView;
                if (this.horizontalAlignment == HorizontalAlignment.RIGHT) {
                    likeBoxCountViewCaretPosition = LikeBoxCountViewCaretPosition.RIGHT;
                } else {
                    likeBoxCountViewCaretPosition = LikeBoxCountViewCaretPosition.LEFT;
                }
                likeBoxCountView.setCaretPosition(likeBoxCountViewCaretPosition);
                return;
            case 3:
                this.likeBoxCountView.setCaretPosition(LikeBoxCountViewCaretPosition.BOTTOM);
                return;
            default:
                return;
        }
    }
}
