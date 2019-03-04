package com.facebook.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.android.C0572R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.model.GraphUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FriendPickerFragment extends PickerFragment<GraphUser> {
    public static final String FRIEND_PICKER_TYPE_KEY = "com.facebook.widget.FriendPickerFragment.FriendPickerType";
    private static final String ID = "id";
    public static final String MULTI_SELECT_BUNDLE_KEY = "com.facebook.widget.FriendPickerFragment.MultiSelect";
    private static final String NAME = "name";
    public static final String USER_ID_BUNDLE_KEY = "com.facebook.widget.FriendPickerFragment.UserId";
    private FriendPickerType friendPickerType;
    private boolean multiSelect;
    private List<String> preSelectedFriendIds;
    private String userId;

    public enum FriendPickerType {
        FRIENDS("/friends", true),
        TAGGABLE_FRIENDS("/taggable_friends", false),
        INVITABLE_FRIENDS("/invitable_friends", false);
        
        private final boolean requestIsCacheable;
        private final String requestPath;

        private FriendPickerType(String str, boolean z) {
            this.requestPath = str;
            this.requestIsCacheable = z;
        }

        String getRequestPath() {
            return this.requestPath;
        }

        boolean isCacheable() {
            return this.requestIsCacheable;
        }
    }

    class ImmediateLoadingStrategy extends LoadingStrategy {
        private ImmediateLoadingStrategy() {
            super();
        }

        protected void onLoadFinished(GraphObjectPagingLoader<GraphUser> graphObjectPagingLoader, SimpleGraphObjectCursor<GraphUser> simpleGraphObjectCursor) {
            super.onLoadFinished(graphObjectPagingLoader, simpleGraphObjectCursor);
            if (simpleGraphObjectCursor != null && !graphObjectPagingLoader.isLoading()) {
                if (simpleGraphObjectCursor.areMoreObjectsAvailable()) {
                    followNextLink();
                    return;
                }
                FriendPickerFragment.this.hideActivityCircle();
                if (simpleGraphObjectCursor.isFromCache()) {
                    graphObjectPagingLoader.refreshOriginalRequest((long) (simpleGraphObjectCursor.getCount() == 0 ? 2000 : 0));
                }
            }
        }

        protected boolean canSkipRoundTripIfCached() {
            return FriendPickerFragment.this.friendPickerType.isCacheable();
        }

        private void followNextLink() {
            FriendPickerFragment.this.displayActivityCircle();
            this.loader.followNextLink();
        }
    }

    public FriendPickerFragment() {
        this(null);
    }

    @SuppressLint({"ValidFragment"})
    public FriendPickerFragment(Bundle bundle) {
        super(GraphUser.class, C0572R.layout.com_facebook_friendpickerfragment, bundle);
        this.multiSelect = true;
        this.friendPickerType = FriendPickerType.FRIENDS;
        this.preSelectedFriendIds = new ArrayList();
        setFriendPickerSettingsFromBundle(bundle);
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public boolean getMultiSelect() {
        return this.multiSelect;
    }

    public void setMultiSelect(boolean z) {
        if (this.multiSelect != z) {
            this.multiSelect = z;
            setSelectionStrategy(createSelectionStrategy());
        }
    }

    public void setFriendPickerType(FriendPickerType friendPickerType) {
        this.friendPickerType = friendPickerType;
    }

    public void setSelectionByIds(List<String> list) {
        this.preSelectedFriendIds.addAll(list);
    }

    public void setSelectionByIds(String... strArr) {
        setSelectionByIds(Arrays.asList(strArr));
    }

    public void setSelection(GraphUser... graphUserArr) {
        setSelection(Arrays.asList(graphUserArr));
    }

    public void setSelection(List<GraphUser> list) {
        List arrayList = new ArrayList();
        for (GraphUser id : list) {
            arrayList.add(id.getId());
        }
        setSelectionByIds(arrayList);
    }

    public List<GraphUser> getSelection() {
        return getSelectedGraphObjects();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(attributeSet, C0572R.styleable.com_facebook_friend_picker_fragment);
        setMultiSelect(obtainStyledAttributes.getBoolean(C0572R.styleable.com_facebook_friend_picker_fragment_multi_select, this.multiSelect));
        obtainStyledAttributes.recycle();
    }

    public void setSettingsFromBundle(Bundle bundle) {
        super.setSettingsFromBundle(bundle);
        setFriendPickerSettingsFromBundle(bundle);
    }

    void saveSettingsToBundle(Bundle bundle) {
        super.saveSettingsToBundle(bundle);
        bundle.putString(USER_ID_BUNDLE_KEY, this.userId);
        bundle.putBoolean(MULTI_SELECT_BUNDLE_KEY, this.multiSelect);
    }

    PickerFragmentAdapter<GraphUser> createAdapter() {
        PickerFragmentAdapter<GraphUser> c06071 = new PickerFragmentAdapter<GraphUser>(this, getActivity()) {
            protected int getGraphObjectRowLayoutId(GraphUser graphUser) {
                return C0572R.layout.com_facebook_picker_list_row;
            }

            protected int getDefaultPicture() {
                return C0572R.drawable.com_facebook_profile_default_icon;
            }
        };
        c06071.setShowCheckbox(true);
        c06071.setShowPicture(getShowPictures());
        c06071.setSortFields(Arrays.asList(new String[]{NAME}));
        c06071.setGroupByField(NAME);
        return c06071;
    }

    LoadingStrategy createLoadingStrategy() {
        return new ImmediateLoadingStrategy();
    }

    SelectionStrategy createSelectionStrategy() {
        return this.multiSelect ? new MultiSelectionStrategy() : new SingleSelectionStrategy();
    }

    Request getRequestForLoadData(Session session) {
        if (this.adapter == null) {
            throw new FacebookException("Can't issue requests until Fragment has been created.");
        }
        return createRequest(this.userId != null ? this.userId : "me", this.extraFields, session);
    }

    String getDefaultTitleText() {
        return getString(C0572R.string.com_facebook_choose_friends);
    }

    void logAppEvents(boolean z) {
        String str;
        AppEventsLogger newLogger = AppEventsLogger.newLogger(getActivity(), getSession());
        Bundle bundle = new Bundle();
        if (z) {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
        } else {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        bundle.putString(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME, str);
        bundle.putInt("num_friends_picked", getSelection().size());
        newLogger.logSdkEvent(AnalyticsEvents.EVENT_FRIEND_PICKER_USAGE, null, bundle);
    }

    public void loadData(boolean z) {
        super.loadData(z);
        setSelectedGraphObjects(this.preSelectedFriendIds);
    }

    private Request createRequest(String str, Set<String> set, Session session) {
        Request newGraphPathRequest = Request.newGraphPathRequest(session, new StringBuilder(String.valueOf(str)).append(this.friendPickerType.getRequestPath()).toString(), null);
        Iterable hashSet = new HashSet(set);
        hashSet.addAll(Arrays.asList(new String[]{ID, NAME}));
        String pictureFieldSpecifier = this.adapter.getPictureFieldSpecifier();
        if (pictureFieldSpecifier != null) {
            hashSet.add(pictureFieldSpecifier);
        }
        Bundle parameters = newGraphPathRequest.getParameters();
        parameters.putString("fields", TextUtils.join(",", hashSet));
        newGraphPathRequest.setParameters(parameters);
        return newGraphPathRequest;
    }

    private void setFriendPickerSettingsFromBundle(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey(USER_ID_BUNDLE_KEY)) {
                setUserId(bundle.getString(USER_ID_BUNDLE_KEY));
            }
            setMultiSelect(bundle.getBoolean(MULTI_SELECT_BUNDLE_KEY, this.multiSelect));
            if (bundle.containsKey(FRIEND_PICKER_TYPE_KEY)) {
                try {
                    this.friendPickerType = FriendPickerType.valueOf(bundle.getString(FRIEND_PICKER_TYPE_KEY));
                } catch (Exception e) {
                }
            }
        }
    }
}
