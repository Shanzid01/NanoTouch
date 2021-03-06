package com.facebook.widget;

import android.app.Activity;
import android.content.res.TypedArray;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.android.C0572R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.model.GraphPlace;
import com.facebook.widget.GraphObjectAdapter.DataNeededListener;
import com.facebook.widget.PickerFragment.OnErrorListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class PlacePickerFragment extends PickerFragment<GraphPlace> {
    private static final String CATEGORY = "category";
    public static final int DEFAULT_RADIUS_IN_METERS = 1000;
    public static final int DEFAULT_RESULTS_LIMIT = 100;
    private static final String ID = "id";
    private static final String LOCATION = "location";
    public static final String LOCATION_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.Location";
    private static final String NAME = "name";
    public static final String RADIUS_IN_METERS_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.RadiusInMeters";
    public static final String RESULTS_LIMIT_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.ResultsLimit";
    public static final String SEARCH_TEXT_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.SearchText";
    public static final String SHOW_SEARCH_BOX_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.ShowSearchBox";
    private static final String TAG = "PlacePickerFragment";
    private static final String WERE_HERE_COUNT = "were_here_count";
    private static final int searchTextTimerDelayInMilliseconds = 2000;
    private boolean hasSearchTextChangedSinceLastQuery;
    private Location location;
    private int radiusInMeters;
    private int resultsLimit;
    private EditText searchBox;
    private String searchText;
    private Timer searchTextTimer;
    private boolean showSearchBox;

    class C06272 extends TimerTask {
        C06272() {
        }

        public void run() {
            PlacePickerFragment.this.onSearchTextTimerTriggered();
        }
    }

    class C06283 implements Runnable {
        C06283() {
        }

        public void run() {
            OnErrorListener onErrorListener;
            try {
                PlacePickerFragment.this.loadData(true);
                if (null != null) {
                    onErrorListener = PlacePickerFragment.this.getOnErrorListener();
                    if (onErrorListener != null) {
                        onErrorListener.onError(PlacePickerFragment.this, null);
                        return;
                    }
                    Logger.log(LoggingBehavior.REQUESTS, PlacePickerFragment.TAG, "Error loading data : %s", null);
                }
            } catch (FacebookException e) {
                if (e != null) {
                    OnErrorListener onErrorListener2 = PlacePickerFragment.this.getOnErrorListener();
                    if (onErrorListener2 != null) {
                        onErrorListener2.onError(PlacePickerFragment.this, e);
                        return;
                    }
                    Logger.log(LoggingBehavior.REQUESTS, PlacePickerFragment.TAG, "Error loading data : %s", e);
                }
            } catch (Throwable e2) {
                FacebookException facebookException = new FacebookException(e2);
                if (facebookException != null) {
                    onErrorListener = PlacePickerFragment.this.getOnErrorListener();
                    if (onErrorListener != null) {
                        onErrorListener.onError(PlacePickerFragment.this, facebookException);
                        return;
                    }
                    Logger.log(LoggingBehavior.REQUESTS, PlacePickerFragment.TAG, "Error loading data : %s", facebookException);
                }
            } catch (Throwable th) {
                if (null != null) {
                    OnErrorListener onErrorListener3 = PlacePickerFragment.this.getOnErrorListener();
                    if (onErrorListener3 != null) {
                        onErrorListener3.onError(PlacePickerFragment.this, null);
                    } else {
                        Logger.log(LoggingBehavior.REQUESTS, PlacePickerFragment.TAG, "Error loading data : %s", null);
                    }
                }
            }
        }
    }

    class AsNeededLoadingStrategy extends LoadingStrategy {

        class C06291 implements DataNeededListener {
            C06291() {
            }

            public void onDataNeeded() {
                if (!AsNeededLoadingStrategy.this.loader.isLoading()) {
                    AsNeededLoadingStrategy.this.loader.followNextLink();
                }
            }
        }

        private AsNeededLoadingStrategy() {
            super();
        }

        public void attach(GraphObjectAdapter<GraphPlace> graphObjectAdapter) {
            super.attach(graphObjectAdapter);
            this.adapter.setDataNeededListener(new C06291());
        }

        protected void onLoadFinished(GraphObjectPagingLoader<GraphPlace> graphObjectPagingLoader, SimpleGraphObjectCursor<GraphPlace> simpleGraphObjectCursor) {
            super.onLoadFinished(graphObjectPagingLoader, simpleGraphObjectCursor);
            if (simpleGraphObjectCursor != null && !graphObjectPagingLoader.isLoading()) {
                PlacePickerFragment.this.hideActivityCircle();
                if (simpleGraphObjectCursor.isFromCache()) {
                    graphObjectPagingLoader.refreshOriginalRequest((long) (simpleGraphObjectCursor.areMoreObjectsAvailable() ? 2000 : 0));
                }
            }
        }
    }

    class SearchTextWatcher implements TextWatcher {
        private SearchTextWatcher() {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            PlacePickerFragment.this.onSearchBoxTextChanged(charSequence.toString(), false);
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    public PlacePickerFragment() {
        this(null);
    }

    public PlacePickerFragment(Bundle bundle) {
        super(GraphPlace.class, C0572R.layout.com_facebook_placepickerfragment, bundle);
        this.radiusInMeters = 1000;
        this.resultsLimit = 100;
        this.showSearchBox = true;
        setPlacePickerSettingsFromBundle(bundle);
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getRadiusInMeters() {
        return this.radiusInMeters;
    }

    public void setRadiusInMeters(int i) {
        this.radiusInMeters = i;
    }

    public int getResultsLimit() {
        return this.resultsLimit;
    }

    public void setResultsLimit(int i) {
        this.resultsLimit = i;
    }

    public String getSearchText() {
        return this.searchText;
    }

    public void setSearchText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.searchText = str;
        if (this.searchBox != null) {
            this.searchBox.setText(str);
        }
    }

    public void onSearchBoxTextChanged(String str, boolean z) {
        if (z || !Utility.stringsEqualOrEmpty(this.searchText, str)) {
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            this.searchText = str;
            this.hasSearchTextChangedSinceLastQuery = true;
            if (this.searchTextTimer == null) {
                this.searchTextTimer = createSearchTextTimer();
            }
        }
    }

    public GraphPlace getSelection() {
        Collection selectedGraphObjects = getSelectedGraphObjects();
        return (selectedGraphObjects == null || selectedGraphObjects.isEmpty()) ? null : (GraphPlace) selectedGraphObjects.iterator().next();
    }

    public void setSettingsFromBundle(Bundle bundle) {
        super.setSettingsFromBundle(bundle);
        setPlacePickerSettingsFromBundle(bundle);
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(attributeSet, C0572R.styleable.com_facebook_place_picker_fragment);
        setRadiusInMeters(obtainStyledAttributes.getInt(C0572R.styleable.com_facebook_place_picker_fragment_radius_in_meters, this.radiusInMeters));
        setResultsLimit(obtainStyledAttributes.getInt(C0572R.styleable.com_facebook_place_picker_fragment_results_limit, this.resultsLimit));
        if (obtainStyledAttributes.hasValue(C0572R.styleable.com_facebook_place_picker_fragment_results_limit)) {
            setSearchText(obtainStyledAttributes.getString(C0572R.styleable.com_facebook_place_picker_fragment_search_text));
        }
        this.showSearchBox = obtainStyledAttributes.getBoolean(C0572R.styleable.com_facebook_place_picker_fragment_show_search_box, this.showSearchBox);
        obtainStyledAttributes.recycle();
    }

    void setupViews(ViewGroup viewGroup) {
        if (this.showSearchBox) {
            ListView listView = (ListView) viewGroup.findViewById(C0572R.id.com_facebook_picker_list_view);
            listView.addHeaderView(getActivity().getLayoutInflater().inflate(C0572R.layout.com_facebook_picker_search_box, listView, false), null, false);
            this.searchBox = (EditText) viewGroup.findViewById(C0572R.id.com_facebook_picker_search_text);
            this.searchBox.addTextChangedListener(new SearchTextWatcher());
            if (!TextUtils.isEmpty(this.searchText)) {
                this.searchBox.setText(this.searchText);
            }
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.searchBox != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.searchBox, 1);
        }
    }

    public void onDetach() {
        super.onDetach();
        if (this.searchBox != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.searchBox.getWindowToken(), 0);
        }
    }

    void saveSettingsToBundle(Bundle bundle) {
        super.saveSettingsToBundle(bundle);
        bundle.putInt(RADIUS_IN_METERS_BUNDLE_KEY, this.radiusInMeters);
        bundle.putInt(RESULTS_LIMIT_BUNDLE_KEY, this.resultsLimit);
        bundle.putString(SEARCH_TEXT_BUNDLE_KEY, this.searchText);
        bundle.putParcelable(LOCATION_BUNDLE_KEY, this.location);
        bundle.putBoolean(SHOW_SEARCH_BOX_BUNDLE_KEY, this.showSearchBox);
    }

    void onLoadingData() {
        this.hasSearchTextChangedSinceLastQuery = false;
    }

    Request getRequestForLoadData(Session session) {
        return createRequest(this.location, this.radiusInMeters, this.resultsLimit, this.searchText, this.extraFields, session);
    }

    String getDefaultTitleText() {
        return getString(C0572R.string.com_facebook_nearby);
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
        bundle.putInt("num_places_picked", getSelection() != null ? 1 : 0);
        newLogger.logSdkEvent(AnalyticsEvents.EVENT_PLACE_PICKER_USAGE, null, bundle);
    }

    PickerFragmentAdapter<GraphPlace> createAdapter() {
        PickerFragmentAdapter<GraphPlace> c06261 = new PickerFragmentAdapter<GraphPlace>(this, getActivity()) {
            protected CharSequence getSubTitleOfGraphObject(GraphPlace graphPlace) {
                String category = graphPlace.getCategory();
                Integer num = (Integer) graphPlace.getProperty(PlacePickerFragment.WERE_HERE_COUNT);
                if (category != null && num != null) {
                    return PlacePickerFragment.this.getString(C0572R.string.com_facebook_placepicker_subtitle_format, category, num);
                } else if (category == null && num != null) {
                    return PlacePickerFragment.this.getString(C0572R.string.com_facebook_placepicker_subtitle_were_here_only_format, num);
                } else if (category == null || num != null) {
                    return null;
                } else {
                    return PlacePickerFragment.this.getString(C0572R.string.com_facebook_placepicker_subtitle_catetory_only_format, category);
                }
            }

            protected int getGraphObjectRowLayoutId(GraphPlace graphPlace) {
                return C0572R.layout.com_facebook_placepickerfragment_list_row;
            }

            protected int getDefaultPicture() {
                return C0572R.drawable.com_facebook_place_default_icon;
            }
        };
        c06261.setShowCheckbox(false);
        c06261.setShowPicture(getShowPictures());
        return c06261;
    }

    LoadingStrategy createLoadingStrategy() {
        return new AsNeededLoadingStrategy();
    }

    SelectionStrategy createSelectionStrategy() {
        return new SingleSelectionStrategy();
    }

    private Request createRequest(Location location, int i, int i2, String str, Set<String> set, Session session) {
        Request newPlacesSearchRequest = Request.newPlacesSearchRequest(session, location, i, i2, str, null);
        Iterable hashSet = new HashSet(set);
        hashSet.addAll(Arrays.asList(new String[]{ID, NAME, LOCATION, CATEGORY, WERE_HERE_COUNT}));
        String pictureFieldSpecifier = this.adapter.getPictureFieldSpecifier();
        if (pictureFieldSpecifier != null) {
            hashSet.add(pictureFieldSpecifier);
        }
        Bundle parameters = newPlacesSearchRequest.getParameters();
        parameters.putString("fields", TextUtils.join(",", hashSet));
        newPlacesSearchRequest.setParameters(parameters);
        return newPlacesSearchRequest;
    }

    private void setPlacePickerSettingsFromBundle(Bundle bundle) {
        if (bundle != null) {
            setRadiusInMeters(bundle.getInt(RADIUS_IN_METERS_BUNDLE_KEY, this.radiusInMeters));
            setResultsLimit(bundle.getInt(RESULTS_LIMIT_BUNDLE_KEY, this.resultsLimit));
            if (bundle.containsKey(SEARCH_TEXT_BUNDLE_KEY)) {
                setSearchText(bundle.getString(SEARCH_TEXT_BUNDLE_KEY));
            }
            if (bundle.containsKey(LOCATION_BUNDLE_KEY)) {
                setLocation((Location) bundle.getParcelable(LOCATION_BUNDLE_KEY));
            }
            this.showSearchBox = bundle.getBoolean(SHOW_SEARCH_BOX_BUNDLE_KEY, this.showSearchBox);
        }
    }

    private Timer createSearchTextTimer() {
        Timer timer = new Timer();
        timer.schedule(new C06272(), 0, 2000);
        return timer;
    }

    private void onSearchTextTimerTriggered() {
        if (this.hasSearchTextChangedSinceLastQuery) {
            new Handler(Looper.getMainLooper()).post(new C06283());
            return;
        }
        this.searchTextTimer.cancel();
        this.searchTextTimer = null;
    }
}
