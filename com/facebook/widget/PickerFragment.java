package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.C0089o;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.android.C0572R;
import com.facebook.internal.SessionTracker;
import com.facebook.model.GraphObject;
import com.facebook.widget.GraphObjectAdapter.SectionAndItem;
import com.facebook.widget.GraphObjectAdapter.SectionAndItem.Type;
import com.google.android.gms.cast.TextTrackStyle;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class PickerFragment<T extends GraphObject> extends Fragment {
    private static final String ACTIVITY_CIRCLE_SHOW_KEY = "com.facebook.android.PickerFragment.ActivityCircleShown";
    public static final String DONE_BUTTON_TEXT_BUNDLE_KEY = "com.facebook.widget.PickerFragment.DoneButtonText";
    public static final String EXTRA_FIELDS_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ExtraFields";
    private static final int PROFILE_PICTURE_PREFETCH_BUFFER = 5;
    private static final String SELECTION_BUNDLE_KEY = "com.facebook.android.PickerFragment.Selection";
    public static final String SHOW_PICTURES_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ShowPictures";
    public static final String SHOW_TITLE_BAR_BUNDLE_KEY = "com.facebook.widget.PickerFragment.ShowTitleBar";
    public static final String TITLE_TEXT_BUNDLE_KEY = "com.facebook.widget.PickerFragment.TitleText";
    private ProgressBar activityCircle;
    GraphObjectAdapter<T> adapter;
    private boolean appEventsLogged;
    private Button doneButton;
    private Drawable doneButtonBackground;
    private String doneButtonText;
    HashSet<String> extraFields = new HashSet();
    private GraphObjectFilter<T> filter;
    private final Class<T> graphObjectClass;
    private final int layout;
    private ListView listView;
    private LoadingStrategy loadingStrategy;
    private OnDataChangedListener onDataChangedListener;
    private OnDoneButtonClickedListener onDoneButtonClickedListener;
    private OnErrorListener onErrorListener;
    private OnScrollListener onScrollListener = new C06171();
    private OnSelectionChangedListener onSelectionChangedListener;
    private Set<String> selectionHint;
    private SelectionStrategy selectionStrategy;
    private SessionTracker sessionTracker;
    private boolean showPictures = true;
    private boolean showTitleBar = true;
    private Drawable titleBarBackground;
    private String titleText;
    private TextView titleTextView;

    abstract class PickerFragmentAdapter<U extends GraphObject> extends GraphObjectAdapter<T> {
        public PickerFragmentAdapter(Context context) {
            super(context);
        }

        boolean isGraphObjectSelected(String str) {
            return PickerFragment.this.selectionStrategy.isSelected(str);
        }

        void updateCheckboxState(CheckBox checkBox, boolean z) {
            checkBox.setChecked(z);
            int i = (z || PickerFragment.this.selectionStrategy.shouldShowCheckBoxIfUnselected()) ? 0 : 8;
            checkBox.setVisibility(i);
        }
    }

    abstract class LoadingStrategy {
        protected static final int CACHED_RESULT_REFRESH_DELAY = 2000;
        protected GraphObjectAdapter<T> adapter;
        protected GraphObjectPagingLoader<T> loader;

        class C06231 implements LoaderCallbacks<SimpleGraphObjectCursor<T>> {
            C06231() {
            }

            public C0089o<SimpleGraphObjectCursor<T>> onCreateLoader(int i, Bundle bundle) {
                return LoadingStrategy.this.onCreateLoader();
            }

            public void onLoadFinished(C0089o<SimpleGraphObjectCursor<T>> c0089o, SimpleGraphObjectCursor<T> simpleGraphObjectCursor) {
                if (c0089o != LoadingStrategy.this.loader) {
                    throw new FacebookException("Received callback for unknown loader.");
                }
                LoadingStrategy.this.onLoadFinished((GraphObjectPagingLoader) c0089o, simpleGraphObjectCursor);
            }

            public void onLoaderReset(C0089o<SimpleGraphObjectCursor<T>> c0089o) {
                if (c0089o != LoadingStrategy.this.loader) {
                    throw new FacebookException("Received callback for unknown loader.");
                }
                LoadingStrategy.this.onLoadReset((GraphObjectPagingLoader) c0089o);
            }
        }

        class C06242 implements com.facebook.widget.GraphObjectPagingLoader.OnErrorListener {
            C06242() {
            }

            public void onError(FacebookException facebookException, GraphObjectPagingLoader<?> graphObjectPagingLoader) {
                PickerFragment.this.hideActivityCircle();
                if (PickerFragment.this.onErrorListener != null) {
                    PickerFragment.this.onErrorListener.onError(PickerFragment.this, facebookException);
                }
            }
        }

        class C06253 implements com.facebook.widget.GraphObjectAdapter.OnErrorListener {
            C06253() {
            }

            public void onError(GraphObjectAdapter<?> graphObjectAdapter, FacebookException facebookException) {
                if (PickerFragment.this.onErrorListener != null) {
                    PickerFragment.this.onErrorListener.onError(PickerFragment.this, facebookException);
                }
            }
        }

        LoadingStrategy() {
        }

        public void attach(GraphObjectAdapter<T> graphObjectAdapter) {
            this.loader = (GraphObjectPagingLoader) PickerFragment.this.getLoaderManager().initLoader(0, null, new C06231());
            this.loader.setOnErrorListener(new C06242());
            this.adapter = graphObjectAdapter;
            this.adapter.changeCursor(this.loader.getCursor());
            this.adapter.setOnErrorListener(new C06253());
        }

        public void detach() {
            this.adapter.setDataNeededListener(null);
            this.adapter.setOnErrorListener(null);
            this.loader.setOnErrorListener(null);
            this.loader = null;
            this.adapter = null;
        }

        public void clearResults() {
            if (this.loader != null) {
                this.loader.clearResults();
            }
        }

        public void startLoading(Request request) {
            if (this.loader != null) {
                this.loader.startLoading(request, canSkipRoundTripIfCached());
                onStartLoading(this.loader, request);
            }
        }

        public boolean isDataPresentOrLoading() {
            return !this.adapter.isEmpty() || this.loader.isLoading();
        }

        protected GraphObjectPagingLoader<T> onCreateLoader() {
            return new GraphObjectPagingLoader(PickerFragment.this.getActivity(), PickerFragment.this.graphObjectClass);
        }

        protected void onStartLoading(GraphObjectPagingLoader<T> graphObjectPagingLoader, Request request) {
            PickerFragment.this.displayActivityCircle();
        }

        protected void onLoadReset(GraphObjectPagingLoader<T> graphObjectPagingLoader) {
            this.adapter.changeCursor(null);
        }

        protected void onLoadFinished(GraphObjectPagingLoader<T> graphObjectPagingLoader, SimpleGraphObjectCursor<T> simpleGraphObjectCursor) {
            PickerFragment.this.updateAdapter(simpleGraphObjectCursor);
        }

        protected boolean canSkipRoundTripIfCached() {
            return true;
        }
    }

    class C06171 implements OnScrollListener {
        C06171() {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            PickerFragment.this.reprioritizeDownloads();
        }
    }

    class C06182 implements Filter<T> {
        C06182() {
        }

        public boolean includeItem(T t) {
            return PickerFragment.this.filterIncludesItem(t);
        }
    }

    class C06193 implements OnItemClickListener {
        C06193() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PickerFragment.this.onListItemClick((ListView) adapterView, view, i);
        }
    }

    class C06204 implements OnLongClickListener {
        C06204() {
        }

        public boolean onLongClick(View view) {
            return false;
        }
    }

    class C06215 implements StatusCallback {
        C06215() {
        }

        public void call(Session session, SessionState sessionState, Exception exception) {
            if (!session.isOpened()) {
                PickerFragment.this.clearResults();
            }
        }
    }

    class C06226 implements OnClickListener {
        C06226() {
        }

        public void onClick(View view) {
            PickerFragment.this.logAppEvents(true);
            PickerFragment.this.appEventsLogged = true;
            if (PickerFragment.this.onDoneButtonClickedListener != null) {
                PickerFragment.this.onDoneButtonClickedListener.onDoneButtonClicked(PickerFragment.this);
            }
        }
    }

    public interface GraphObjectFilter<T> {
        boolean includeItem(T t);
    }

    abstract class SelectionStrategy {
        abstract void clear();

        abstract Collection<String> getSelectedIds();

        abstract boolean isEmpty();

        abstract boolean isSelected(String str);

        abstract void readSelectionFromBundle(Bundle bundle, String str);

        abstract void saveSelectionToBundle(Bundle bundle, String str);

        abstract boolean shouldShowCheckBoxIfUnselected();

        abstract void toggleSelection(String str);

        SelectionStrategy() {
        }
    }

    class MultiSelectionStrategy extends SelectionStrategy {
        private Set<String> selectedIds = new HashSet();

        MultiSelectionStrategy() {
            super();
        }

        public Collection<String> getSelectedIds() {
            return this.selectedIds;
        }

        boolean isSelected(String str) {
            return str != null && this.selectedIds.contains(str);
        }

        void toggleSelection(String str) {
            if (str == null) {
                return;
            }
            if (this.selectedIds.contains(str)) {
                this.selectedIds.remove(str);
            } else {
                this.selectedIds.add(str);
            }
        }

        void saveSelectionToBundle(Bundle bundle, String str) {
            if (!this.selectedIds.isEmpty()) {
                bundle.putString(str, TextUtils.join(",", this.selectedIds));
            }
        }

        void readSelectionFromBundle(Bundle bundle, String str) {
            if (bundle != null) {
                String string = bundle.getString(str);
                if (string != null) {
                    String[] split = TextUtils.split(string, ",");
                    this.selectedIds.clear();
                    Collections.addAll(this.selectedIds, split);
                }
            }
        }

        public void clear() {
            this.selectedIds.clear();
        }

        boolean isEmpty() {
            return this.selectedIds.isEmpty();
        }

        boolean shouldShowCheckBoxIfUnselected() {
            return true;
        }
    }

    public interface OnDataChangedListener {
        void onDataChanged(PickerFragment<?> pickerFragment);
    }

    public interface OnDoneButtonClickedListener {
        void onDoneButtonClicked(PickerFragment<?> pickerFragment);
    }

    public interface OnErrorListener {
        void onError(PickerFragment<?> pickerFragment, FacebookException facebookException);
    }

    public interface OnSelectionChangedListener {
        void onSelectionChanged(PickerFragment<?> pickerFragment);
    }

    class SingleSelectionStrategy extends SelectionStrategy {
        private String selectedId;

        SingleSelectionStrategy() {
            super();
        }

        public Collection<String> getSelectedIds() {
            return Arrays.asList(new String[]{this.selectedId});
        }

        boolean isSelected(String str) {
            return (this.selectedId == null || str == null || !this.selectedId.equals(str)) ? false : true;
        }

        void toggleSelection(String str) {
            if (this.selectedId == null || !this.selectedId.equals(str)) {
                this.selectedId = str;
            } else {
                this.selectedId = null;
            }
        }

        void saveSelectionToBundle(Bundle bundle, String str) {
            if (!TextUtils.isEmpty(this.selectedId)) {
                bundle.putString(str, this.selectedId);
            }
        }

        void readSelectionFromBundle(Bundle bundle, String str) {
            if (bundle != null) {
                this.selectedId = bundle.getString(str);
            }
        }

        public void clear() {
            this.selectedId = null;
        }

        boolean isEmpty() {
            return this.selectedId == null;
        }

        boolean shouldShowCheckBoxIfUnselected() {
            return false;
        }
    }

    abstract PickerFragmentAdapter<T> createAdapter();

    abstract LoadingStrategy createLoadingStrategy();

    abstract SelectionStrategy createSelectionStrategy();

    abstract Request getRequestForLoadData(Session session);

    PickerFragment(Class<T> cls, int i, Bundle bundle) {
        this.graphObjectClass = cls;
        this.layout = i;
        setPickerFragmentSettingsFromBundle(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.adapter = createAdapter();
        this.adapter.setFilter(new C06182());
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(attributeSet, C0572R.styleable.com_facebook_picker_fragment);
        setShowPictures(obtainStyledAttributes.getBoolean(C0572R.styleable.com_facebook_picker_fragment_show_pictures, this.showPictures));
        String string = obtainStyledAttributes.getString(C0572R.styleable.com_facebook_picker_fragment_extra_fields);
        if (string != null) {
            setExtraFields(Arrays.asList(string.split(",")));
        }
        this.showTitleBar = obtainStyledAttributes.getBoolean(C0572R.styleable.com_facebook_picker_fragment_show_title_bar, this.showTitleBar);
        this.titleText = obtainStyledAttributes.getString(C0572R.styleable.com_facebook_picker_fragment_title_text);
        this.doneButtonText = obtainStyledAttributes.getString(C0572R.styleable.com_facebook_picker_fragment_done_button_text);
        this.titleBarBackground = obtainStyledAttributes.getDrawable(C0572R.styleable.com_facebook_picker_fragment_title_bar_background);
        this.doneButtonBackground = obtainStyledAttributes.getDrawable(C0572R.styleable.com_facebook_picker_fragment_done_button_background);
        obtainStyledAttributes.recycle();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(this.layout, viewGroup, false);
        this.listView = (ListView) viewGroup2.findViewById(C0572R.id.com_facebook_picker_list_view);
        this.listView.setOnItemClickListener(new C06193());
        this.listView.setOnLongClickListener(new C06204());
        this.listView.setOnScrollListener(this.onScrollListener);
        this.activityCircle = (ProgressBar) viewGroup2.findViewById(C0572R.id.com_facebook_picker_activity_circle);
        setupViews(viewGroup2);
        this.listView.setAdapter(this.adapter);
        return viewGroup2;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.sessionTracker = new SessionTracker(getActivity(), new C06215());
        setSettingsFromBundle(bundle);
        this.loadingStrategy = createLoadingStrategy();
        this.loadingStrategy.attach(this.adapter);
        this.selectionStrategy = createSelectionStrategy();
        this.selectionStrategy.readSelectionFromBundle(bundle, SELECTION_BUNDLE_KEY);
        if (this.showTitleBar) {
            inflateTitleBar((ViewGroup) getView());
        }
        if (this.activityCircle != null && bundle != null) {
            if (bundle.getBoolean(ACTIVITY_CIRCLE_SHOW_KEY, false)) {
                displayActivityCircle();
            } else {
                hideActivityCircle();
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        this.listView.setOnScrollListener(null);
        this.listView.setAdapter(null);
        this.loadingStrategy.detach();
        this.sessionTracker.stopTracking();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        saveSettingsToBundle(bundle);
        this.selectionStrategy.saveSelectionToBundle(bundle, SELECTION_BUNDLE_KEY);
        if (this.activityCircle != null) {
            bundle.putBoolean(ACTIVITY_CIRCLE_SHOW_KEY, this.activityCircle.getVisibility() == 0);
        }
    }

    public void onStop() {
        if (!this.appEventsLogged) {
            logAppEvents(false);
        }
        super.onStop();
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        setSettingsFromBundle(bundle);
    }

    public OnDataChangedListener getOnDataChangedListener() {
        return this.onDataChangedListener;
    }

    public void setOnDataChangedListener(OnDataChangedListener onDataChangedListener) {
        this.onDataChangedListener = onDataChangedListener;
    }

    public OnSelectionChangedListener getOnSelectionChangedListener() {
        return this.onSelectionChangedListener;
    }

    public void setOnSelectionChangedListener(OnSelectionChangedListener onSelectionChangedListener) {
        this.onSelectionChangedListener = onSelectionChangedListener;
    }

    public OnDoneButtonClickedListener getOnDoneButtonClickedListener() {
        return this.onDoneButtonClickedListener;
    }

    public void setOnDoneButtonClickedListener(OnDoneButtonClickedListener onDoneButtonClickedListener) {
        this.onDoneButtonClickedListener = onDoneButtonClickedListener;
    }

    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public GraphObjectFilter<T> getFilter() {
        return this.filter;
    }

    public void setFilter(GraphObjectFilter<T> graphObjectFilter) {
        this.filter = graphObjectFilter;
    }

    public Session getSession() {
        return this.sessionTracker.getSession();
    }

    public void setSession(Session session) {
        this.sessionTracker.setSession(session);
    }

    public boolean getShowPictures() {
        return this.showPictures;
    }

    public void setShowPictures(boolean z) {
        this.showPictures = z;
    }

    public Set<String> getExtraFields() {
        return new HashSet(this.extraFields);
    }

    public void setExtraFields(Collection<String> collection) {
        this.extraFields = new HashSet();
        if (collection != null) {
            this.extraFields.addAll(collection);
        }
    }

    public void setShowTitleBar(boolean z) {
        this.showTitleBar = z;
    }

    public boolean getShowTitleBar() {
        return this.showTitleBar;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public String getTitleText() {
        if (this.titleText == null) {
            this.titleText = getDefaultTitleText();
        }
        return this.titleText;
    }

    public void setDoneButtonText(String str) {
        this.doneButtonText = str;
    }

    public String getDoneButtonText() {
        if (this.doneButtonText == null) {
            this.doneButtonText = getDefaultDoneButtonText();
        }
        return this.doneButtonText;
    }

    public void loadData(boolean z) {
        loadData(z, null);
    }

    public void loadData(boolean z, Set<String> set) {
        if (z || !this.loadingStrategy.isDataPresentOrLoading()) {
            this.selectionHint = set;
            loadDataSkippingRoundTripIfCached();
        }
    }

    public void setSettingsFromBundle(Bundle bundle) {
        setPickerFragmentSettingsFromBundle(bundle);
    }

    void setupViews(ViewGroup viewGroup) {
    }

    boolean filterIncludesItem(T t) {
        if (this.filter != null) {
            return this.filter.includeItem(t);
        }
        return true;
    }

    List<T> getSelectedGraphObjects() {
        return this.adapter.getGraphObjectsById(this.selectionStrategy.getSelectedIds());
    }

    void setSelectedGraphObjects(List<String> list) {
        for (String str : list) {
            if (!this.selectionStrategy.isSelected(str)) {
                this.selectionStrategy.toggleSelection(str);
            }
        }
    }

    void saveSettingsToBundle(Bundle bundle) {
        bundle.putBoolean(SHOW_PICTURES_BUNDLE_KEY, this.showPictures);
        if (!this.extraFields.isEmpty()) {
            bundle.putString(EXTRA_FIELDS_BUNDLE_KEY, TextUtils.join(",", this.extraFields));
        }
        bundle.putBoolean(SHOW_TITLE_BAR_BUNDLE_KEY, this.showTitleBar);
        bundle.putString(TITLE_TEXT_BUNDLE_KEY, this.titleText);
        bundle.putString(DONE_BUTTON_TEXT_BUNDLE_KEY, this.doneButtonText);
    }

    void onLoadingData() {
    }

    String getDefaultTitleText() {
        return null;
    }

    String getDefaultDoneButtonText() {
        return getString(C0572R.string.com_facebook_picker_done_button_text);
    }

    void displayActivityCircle() {
        if (this.activityCircle != null) {
            layoutActivityCircle();
            this.activityCircle.setVisibility(0);
        }
    }

    void layoutActivityCircle() {
        setAlpha(this.activityCircle, !this.adapter.isEmpty() ? 0.25f : TextTrackStyle.DEFAULT_FONT_SCALE);
    }

    void hideActivityCircle() {
        if (this.activityCircle != null) {
            this.activityCircle.clearAnimation();
            this.activityCircle.setVisibility(4);
        }
    }

    void setSelectionStrategy(SelectionStrategy selectionStrategy) {
        if (selectionStrategy != this.selectionStrategy) {
            this.selectionStrategy = selectionStrategy;
            if (this.adapter != null) {
                this.adapter.notifyDataSetChanged();
            }
        }
    }

    void logAppEvents(boolean z) {
    }

    private static void setAlpha(View view, float f) {
        Animation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    private void setPickerFragmentSettingsFromBundle(Bundle bundle) {
        if (bundle != null) {
            this.showPictures = bundle.getBoolean(SHOW_PICTURES_BUNDLE_KEY, this.showPictures);
            String string = bundle.getString(EXTRA_FIELDS_BUNDLE_KEY);
            if (string != null) {
                setExtraFields(Arrays.asList(string.split(",")));
            }
            this.showTitleBar = bundle.getBoolean(SHOW_TITLE_BAR_BUNDLE_KEY, this.showTitleBar);
            string = bundle.getString(TITLE_TEXT_BUNDLE_KEY);
            if (string != null) {
                this.titleText = string;
                if (this.titleTextView != null) {
                    this.titleTextView.setText(this.titleText);
                }
            }
            string = bundle.getString(DONE_BUTTON_TEXT_BUNDLE_KEY);
            if (string != null) {
                this.doneButtonText = string;
                if (this.doneButton != null) {
                    this.doneButton.setText(this.doneButtonText);
                }
            }
        }
    }

    private void inflateTitleBar(ViewGroup viewGroup) {
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(C0572R.id.com_facebook_picker_title_bar_stub);
        if (viewStub != null) {
            View inflate = viewStub.inflate();
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, C0572R.id.com_facebook_picker_title_bar);
            this.listView.setLayoutParams(layoutParams);
            if (this.titleBarBackground != null) {
                inflate.setBackgroundDrawable(this.titleBarBackground);
            }
            this.doneButton = (Button) viewGroup.findViewById(C0572R.id.com_facebook_picker_done_button);
            if (this.doneButton != null) {
                this.doneButton.setOnClickListener(new C06226());
                if (getDoneButtonText() != null) {
                    this.doneButton.setText(getDoneButtonText());
                }
                if (this.doneButtonBackground != null) {
                    this.doneButton.setBackgroundDrawable(this.doneButtonBackground);
                }
            }
            this.titleTextView = (TextView) viewGroup.findViewById(C0572R.id.com_facebook_picker_title);
            if (this.titleTextView != null && getTitleText() != null) {
                this.titleTextView.setText(getTitleText());
            }
        }
    }

    private void onListItemClick(ListView listView, View view, int i) {
        this.selectionStrategy.toggleSelection(this.adapter.getIdOfGraphObject((GraphObject) listView.getItemAtPosition(i)));
        this.adapter.notifyDataSetChanged();
        if (this.onSelectionChangedListener != null) {
            this.onSelectionChangedListener.onSelectionChanged(this);
        }
    }

    private void loadDataSkippingRoundTripIfCached() {
        clearResults();
        Request requestForLoadData = getRequestForLoadData(getSession());
        if (requestForLoadData != null) {
            onLoadingData();
            this.loadingStrategy.startLoading(requestForLoadData);
        }
    }

    private void clearResults() {
        Object obj = null;
        if (this.adapter != null) {
            Object obj2;
            if (this.selectionStrategy.isEmpty()) {
                obj2 = null;
            } else {
                int i = 1;
            }
            if (!this.adapter.isEmpty()) {
                int i2 = 1;
            }
            this.loadingStrategy.clearResults();
            this.selectionStrategy.clear();
            this.adapter.notifyDataSetChanged();
            if (!(obj == null || this.onDataChangedListener == null)) {
                this.onDataChangedListener.onDataChanged(this);
            }
            if (obj2 != null && this.onSelectionChangedListener != null) {
                this.onSelectionChangedListener.onSelectionChanged(this);
            }
        }
    }

    void updateAdapter(SimpleGraphObjectCursor<T> simpleGraphObjectCursor) {
        int i = 0;
        if (this.adapter != null) {
            int position;
            View childAt = this.listView.getChildAt(1);
            int firstVisiblePosition = this.listView.getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition++;
            }
            SectionAndItem sectionAndItem = this.adapter.getSectionAndItem(firstVisiblePosition);
            firstVisiblePosition = (childAt == null || sectionAndItem.getType() == Type.ACTIVITY_CIRCLE) ? 0 : childAt.getTop();
            boolean changeCursor = this.adapter.changeCursor(simpleGraphObjectCursor);
            if (!(childAt == null || sectionAndItem == null)) {
                position = this.adapter.getPosition(sectionAndItem.sectionKey, sectionAndItem.graphObject);
                if (position != -1) {
                    this.listView.setSelectionFromTop(position, firstVisiblePosition);
                }
            }
            if (changeCursor && this.onDataChangedListener != null) {
                this.onDataChangedListener.onDataChanged(this);
            }
            if (this.selectionHint != null && !this.selectionHint.isEmpty() && simpleGraphObjectCursor != null) {
                simpleGraphObjectCursor.moveToFirst();
                position = 0;
                while (i < simpleGraphObjectCursor.getCount()) {
                    simpleGraphObjectCursor.moveToPosition(i);
                    GraphObject graphObject = simpleGraphObjectCursor.getGraphObject();
                    if (graphObject.asMap().containsKey("id")) {
                        Object property = graphObject.getProperty("id");
                        if (property instanceof String) {
                            String str = (String) property;
                            if (this.selectionHint.contains(str)) {
                                this.selectionStrategy.toggleSelection(str);
                                this.selectionHint.remove(str);
                                position = 1;
                            }
                            if (this.selectionHint.isEmpty()) {
                                break;
                            }
                            firstVisiblePosition = position;
                        } else {
                            firstVisiblePosition = position;
                        }
                    } else {
                        firstVisiblePosition = position;
                    }
                    i++;
                    position = firstVisiblePosition;
                }
                if (this.onSelectionChangedListener != null && r2 != 0) {
                    this.onSelectionChangedListener.onSelectionChanged(this);
                }
            }
        }
    }

    private void reprioritizeDownloads() {
        int lastVisiblePosition = this.listView.getLastVisiblePosition();
        if (lastVisiblePosition >= 0) {
            this.adapter.prioritizeViewRange(this.listView.getFirstVisiblePosition(), lastVisiblePosition, 5);
        }
    }
}
