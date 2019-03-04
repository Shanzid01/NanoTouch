package com.facebook.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.Button;
import com.facebook.android.C0572R;

public class LikeButton extends Button {
    private boolean isLiked;

    public LikeButton(Context context, boolean z) {
        super(context);
        this.isLiked = z;
        initialize();
    }

    public void setLikeState(boolean z) {
        if (z != this.isLiked) {
            this.isLiked = z;
            updateForLikeStatus();
        }
    }

    private void initialize() {
        setGravity(16);
        setTextColor(getResources().getColor(C0572R.color.com_facebook_likebutton_text_color));
        setTextSize(0, getResources().getDimension(C0572R.dimen.com_facebook_likebutton_text_size));
        setTypeface(Typeface.DEFAULT_BOLD);
        setCompoundDrawablePadding(getResources().getDimensionPixelSize(C0572R.dimen.com_facebook_likebutton_compound_drawable_padding));
        setPadding(getResources().getDimensionPixelSize(C0572R.dimen.com_facebook_likebutton_padding_left), getResources().getDimensionPixelSize(C0572R.dimen.com_facebook_likebutton_padding_top), getResources().getDimensionPixelSize(C0572R.dimen.com_facebook_likebutton_padding_right), getResources().getDimensionPixelSize(C0572R.dimen.com_facebook_likebutton_padding_bottom));
        updateForLikeStatus();
    }

    private void updateForLikeStatus() {
        if (this.isLiked) {
            setBackgroundResource(C0572R.drawable.com_facebook_button_like_selected);
            setCompoundDrawablesWithIntrinsicBounds(C0572R.drawable.com_facebook_button_like_icon_selected, 0, 0, 0);
            setText(getResources().getString(C0572R.string.com_facebook_like_button_liked));
            return;
        }
        setBackgroundResource(C0572R.drawable.com_facebook_button_like);
        setCompoundDrawablesWithIntrinsicBounds(C0572R.drawable.com_facebook_button_like_icon, 0, 0, 0);
        setText(getResources().getString(C0572R.string.com_facebook_like_button_not_liked));
    }
}
