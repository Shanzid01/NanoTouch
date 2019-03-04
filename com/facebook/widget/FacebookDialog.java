package com.facebook.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphObjectException;
import com.facebook.NativeAppCallAttachmentStore;
import com.facebook.NativeAppCallContentProvider;
import com.facebook.Settings;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.DialogFeatureConfig;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import com.facebook.model.GraphObjectList;
import com.facebook.model.OpenGraphAction;
import com.facebook.model.OpenGraphObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class FacebookDialog {
    public static final String COMPLETION_GESTURE_CANCEL = "cancel";
    private static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    private static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    private static final String EXTRA_DIALOG_COMPLETION_ID_KEY = "com.facebook.platform.extra.POST_ID";
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
    public static final String RESULT_ARGS_DIALOG_COMPLETION_ID_KEY = "postId";
    private static NativeAppCallAttachmentStore attachmentStore;
    private Activity activity;
    private PendingCall appCall;
    private Fragment fragment;
    private OnPresentCallback onPresentCallback;

    public interface Callback {
        void onComplete(PendingCall pendingCall, Bundle bundle);

        void onError(PendingCall pendingCall, Exception exception, Bundle bundle);
    }

    public abstract class Builder<CONCRETE extends Builder<?>> {
        protected final Activity activity;
        protected final PendingCall appCall;
        protected final String applicationId;
        protected String applicationName;
        protected Fragment fragment;
        protected HashMap<String, Bitmap> imageAttachments = new HashMap();
        protected HashMap<String, File> mediaAttachmentFiles = new HashMap();

        class C06051 implements OnPresentCallback {
            C06051() {
            }

            public void onPresent(Context context) {
                if (Builder.this.imageAttachments != null && Builder.this.imageAttachments.size() > 0) {
                    FacebookDialog.getAttachmentStore().addAttachmentsForCall(context, Builder.this.appCall.getCallId(), Builder.this.imageAttachments);
                }
                if (Builder.this.mediaAttachmentFiles != null && Builder.this.mediaAttachmentFiles.size() > 0) {
                    FacebookDialog.getAttachmentStore().addAttachmentFilesForCall(context, Builder.this.appCall.getCallId(), Builder.this.mediaAttachmentFiles);
                }
            }
        }

        protected abstract EnumSet<? extends DialogFeature> getDialogFeatures();

        protected abstract Bundle getMethodArguments();

        public Builder(Activity activity) {
            Validate.notNull(activity, "activity");
            this.activity = activity;
            this.applicationId = Utility.getMetadataApplicationId(activity);
            this.appCall = new PendingCall((int) NativeProtocol.DIALOG_REQUEST_CODE);
        }

        public CONCRETE setRequestCode(int i) {
            this.appCall.setRequestCode(i);
            return this;
        }

        public CONCRETE setApplicationName(String str) {
            this.applicationName = str;
            return this;
        }

        public CONCRETE setFragment(Fragment fragment) {
            this.fragment = fragment;
            return this;
        }

        public FacebookDialog build() {
            Bundle methodArguments;
            validate();
            String access$0 = FacebookDialog.getActionForFeatures(getDialogFeatures());
            int access$2 = FacebookDialog.getProtocolVersionForNativeDialog(this.activity, access$0, FacebookDialog.getVersionSpecForFeatures(this.applicationId, access$0, getDialogFeatures()));
            if (NativeProtocol.isVersionCompatibleWithBucketedIntent(access$2)) {
                methodArguments = getMethodArguments();
            } else {
                methodArguments = setBundleExtras(new Bundle());
            }
            Intent createPlatformActivityIntent = NativeProtocol.createPlatformActivityIntent(this.activity, this.appCall.getCallId().toString(), access$0, access$2, this.applicationName, methodArguments);
            if (createPlatformActivityIntent == null) {
                FacebookDialog.logDialogActivity(this.activity, this.fragment, FacebookDialog.getEventName(access$0, methodArguments.containsKey(NativeProtocol.EXTRA_PHOTOS), false), AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED);
                throw new FacebookException("Unable to create Intent; this likely means the Facebook app is not installed.");
            }
            this.appCall.setRequestIntent(createPlatformActivityIntent);
            return new FacebookDialog(this.activity, this.fragment, this.appCall, getOnPresentCallback());
        }

        protected String getWebFallbackUrlInternal() {
            String name;
            String action;
            Iterator it = getDialogFeatures().iterator();
            if (it.hasNext()) {
                DialogFeature dialogFeature = (DialogFeature) it.next();
                name = dialogFeature.name();
                action = dialogFeature.getAction();
            } else {
                action = null;
                name = null;
            }
            DialogFeatureConfig dialogFeatureConfig = Utility.getDialogFeatureConfig(this.applicationId, action, name);
            if (dialogFeatureConfig == null) {
                return null;
            }
            Uri fallbackUrl = dialogFeatureConfig.getFallbackUrl();
            if (fallbackUrl == null) {
                return null;
            }
            Bundle methodArguments = getMethodArguments();
            methodArguments = ServerProtocol.getQueryParamsForPlatformActivityIntentWebFallback(this.activity, this.appCall.getCallId().toString(), NativeProtocol.getLatestKnownVersion(), this.applicationName, methodArguments);
            if (methodArguments == null) {
                return null;
            }
            if (fallbackUrl.isRelative()) {
                fallbackUrl = Utility.buildUri(ServerProtocol.getDialogAuthority(), fallbackUrl.toString(), methodArguments);
            }
            return fallbackUrl.toString();
        }

        public boolean canPresent() {
            return FacebookDialog.handleCanPresent(this.activity, getDialogFeatures());
        }

        void validate() {
        }

        OnPresentCallback getOnPresentCallback() {
            return new C06051();
        }

        protected List<String> addImageAttachments(Collection<Bitmap> collection) {
            List arrayList = new ArrayList();
            for (Bitmap bitmap : collection) {
                String uuid = UUID.randomUUID().toString();
                addImageAttachment(uuid, bitmap);
                arrayList.add(NativeAppCallContentProvider.getAttachmentUrl(this.applicationId, this.appCall.getCallId(), uuid));
            }
            return arrayList;
        }

        protected List<String> addImageAttachmentFiles(Collection<File> collection) {
            List arrayList = new ArrayList();
            for (File file : collection) {
                String uuid = UUID.randomUUID().toString();
                addImageAttachment(uuid, file);
                arrayList.add(NativeAppCallContentProvider.getAttachmentUrl(this.applicationId, this.appCall.getCallId(), uuid));
            }
            return arrayList;
        }

        protected String addVideoAttachmentFile(File file) {
            String uuid = UUID.randomUUID().toString();
            addVideoAttachment(uuid, file);
            return NativeAppCallContentProvider.getAttachmentUrl(this.applicationId, this.appCall.getCallId(), uuid);
        }

        List<String> getImageAttachmentNames() {
            return new ArrayList(this.imageAttachments.keySet());
        }

        protected Bundle setBundleExtras(Bundle bundle) {
            return bundle;
        }

        protected void putExtra(Bundle bundle, String str, String str2) {
            if (str2 != null) {
                bundle.putString(str, str2);
            }
        }

        protected CONCRETE addImageAttachment(String str, Bitmap bitmap) {
            this.imageAttachments.put(str, bitmap);
            return this;
        }

        protected CONCRETE addImageAttachment(String str, File file) {
            this.mediaAttachmentFiles.put(str, file);
            return this;
        }

        protected CONCRETE addVideoAttachment(String str, File file) {
            this.mediaAttachmentFiles.put(str, file);
            return this;
        }
    }

    public interface DialogFeature {
        String getAction();

        int getMinVersion();

        String name();
    }

    interface OnPresentCallback {
        void onPresent(Context context);
    }

    abstract class ShareDialogBuilderBase<CONCRETE extends ShareDialogBuilderBase<?>> extends Builder<CONCRETE> {
        private String caption;
        private boolean dataErrorsFatal;
        private String description;
        private ArrayList<String> friends;
        protected String link;
        private String name;
        private String picture;
        private String place;
        private String ref;

        public ShareDialogBuilderBase(Activity activity) {
            super(activity);
        }

        public CONCRETE setName(String str) {
            this.name = str;
            return this;
        }

        public CONCRETE setCaption(String str) {
            this.caption = str;
            return this;
        }

        public CONCRETE setDescription(String str) {
            this.description = str;
            return this;
        }

        public CONCRETE setLink(String str) {
            this.link = str;
            return this;
        }

        public CONCRETE setPicture(String str) {
            this.picture = str;
            return this;
        }

        public CONCRETE setPlace(String str) {
            this.place = str;
            return this;
        }

        public CONCRETE setFriends(List<String> list) {
            this.friends = list == null ? null : new ArrayList(list);
            return this;
        }

        public CONCRETE setRef(String str) {
            this.ref = str;
            return this;
        }

        public CONCRETE setDataErrorsFatal(boolean z) {
            this.dataErrorsFatal = z;
            return this;
        }

        protected Bundle setBundleExtras(Bundle bundle) {
            putExtra(bundle, NativeProtocol.EXTRA_APPLICATION_ID, this.applicationId);
            putExtra(bundle, NativeProtocol.EXTRA_APPLICATION_NAME, this.applicationName);
            putExtra(bundle, NativeProtocol.EXTRA_TITLE, this.name);
            putExtra(bundle, NativeProtocol.EXTRA_SUBTITLE, this.caption);
            putExtra(bundle, NativeProtocol.EXTRA_DESCRIPTION, this.description);
            putExtra(bundle, NativeProtocol.EXTRA_LINK, this.link);
            putExtra(bundle, NativeProtocol.EXTRA_IMAGE, this.picture);
            putExtra(bundle, NativeProtocol.EXTRA_PLACE_TAG, this.place);
            putExtra(bundle, NativeProtocol.EXTRA_REF, this.ref);
            bundle.putBoolean(NativeProtocol.EXTRA_DATA_FAILURES_FATAL, this.dataErrorsFatal);
            if (!Utility.isNullOrEmpty(this.friends)) {
                bundle.putStringArrayList(NativeProtocol.EXTRA_FRIEND_TAGS, this.friends);
            }
            return bundle;
        }

        protected Bundle getMethodArguments() {
            Bundle bundle = new Bundle();
            putExtra(bundle, NativeProtocol.METHOD_ARGS_TITLE, this.name);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_SUBTITLE, this.caption);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_DESCRIPTION, this.description);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_LINK, this.link);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_IMAGE, this.picture);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_PLACE_TAG, this.place);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_REF, this.ref);
            bundle.putBoolean(NativeProtocol.METHOD_ARGS_DATA_FAILURES_FATAL, this.dataErrorsFatal);
            if (!Utility.isNullOrEmpty(this.friends)) {
                bundle.putStringArrayList(NativeProtocol.METHOD_ARGS_FRIEND_TAGS, this.friends);
            }
            return bundle;
        }
    }

    public class MessageDialogBuilder extends ShareDialogBuilderBase<MessageDialogBuilder> {
        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setCaption(String str) {
            return super.setCaption(str);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setDataErrorsFatal(boolean z) {
            return super.setDataErrorsFatal(z);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setDescription(String str) {
            return super.setDescription(str);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setLink(String str) {
            return super.setLink(str);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setName(String str) {
            return super.setName(str);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setPicture(String str) {
            return super.setPicture(str);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setRef(String str) {
            return super.setRef(str);
        }

        public MessageDialogBuilder(Activity activity) {
            super(activity);
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(MessageDialogFeature.MESSAGE_DIALOG);
        }

        public MessageDialogBuilder setPlace(String str) {
            return this;
        }

        public MessageDialogBuilder setFriends(List<String> list) {
            return this;
        }
    }

    public enum MessageDialogFeature implements DialogFeature {
        MESSAGE_DIALOG(NativeProtocol.PROTOCOL_VERSION_20140204),
        PHOTOS(NativeProtocol.PROTOCOL_VERSION_20140324),
        VIDEO(NativeProtocol.PROTOCOL_VERSION_20141218);
        
        private int minVersion;

        private MessageDialogFeature(int i) {
            this.minVersion = i;
        }

        public String getAction() {
            return NativeProtocol.ACTION_MESSAGE_DIALOG;
        }

        public int getMinVersion() {
            return this.minVersion;
        }
    }

    abstract class OpenGraphDialogBuilderBase<CONCRETE extends OpenGraphDialogBuilderBase<?>> extends Builder<CONCRETE> {
        private OpenGraphAction action;
        private String actionType;
        private boolean dataErrorsFatal;
        private String previewPropertyName;

        @Deprecated
        public OpenGraphDialogBuilderBase(Activity activity, OpenGraphAction openGraphAction, String str, String str2) {
            super(activity);
            Validate.notNull(openGraphAction, "action");
            Validate.notNullOrEmpty(str, "actionType");
            Validate.notNullOrEmpty(str2, "previewPropertyName");
            if (openGraphAction.getProperty(str2) == null) {
                throw new IllegalArgumentException("A property named \"" + str2 + "\" was not found on the action.  The name of " + "the preview property must match the name of an action property.");
            }
            String type = openGraphAction.getType();
            if (Utility.isNullOrEmpty(type) || type.equals(str)) {
                this.action = openGraphAction;
                this.actionType = str;
                this.previewPropertyName = str2;
                return;
            }
            throw new IllegalArgumentException("'actionType' must match the type of 'action' if it is specified. Consider using OpenGraphDialogBuilderBase(Activity activity, OpenGraphAction action, String previewPropertyName) instead.");
        }

        public OpenGraphDialogBuilderBase(Activity activity, OpenGraphAction openGraphAction, String str) {
            super(activity);
            Validate.notNull(openGraphAction, "action");
            Validate.notNullOrEmpty(openGraphAction.getType(), "action.getType()");
            Validate.notNullOrEmpty(str, "previewPropertyName");
            if (openGraphAction.getProperty(str) == null) {
                throw new IllegalArgumentException("A property named \"" + str + "\" was not found on the action.  The name of " + "the preview property must match the name of an action property.");
            }
            this.action = openGraphAction;
            this.actionType = openGraphAction.getType();
            this.previewPropertyName = str;
        }

        public CONCRETE setDataErrorsFatal(boolean z) {
            this.dataErrorsFatal = z;
            return this;
        }

        public CONCRETE setImageAttachmentsForAction(List<Bitmap> list) {
            return setImageAttachmentsForAction(list, false);
        }

        public CONCRETE setImageAttachmentsForAction(List<Bitmap> list, boolean z) {
            Validate.containsNoNulls(list, "bitmaps");
            if (this.action == null) {
                throw new FacebookException("Can not set attachments prior to setting action.");
            }
            updateActionAttachmentUrls(addImageAttachments(list), z);
            return this;
        }

        public CONCRETE setImageAttachmentFilesForAction(List<File> list) {
            return setImageAttachmentFilesForAction(list, false);
        }

        public CONCRETE setImageAttachmentFilesForAction(List<File> list, boolean z) {
            Validate.containsNoNulls(list, "bitmapFiles");
            if (this.action == null) {
                throw new FacebookException("Can not set attachments prior to setting action.");
            }
            updateActionAttachmentUrls(addImageAttachmentFiles(list), z);
            return this;
        }

        private void updateActionAttachmentUrls(List<String> list, boolean z) {
            List arrayList;
            List image = this.action.getImage();
            if (image == null) {
                arrayList = new ArrayList(list.size());
            } else {
                arrayList = image;
            }
            for (String str : list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", str);
                    if (z) {
                        jSONObject.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, true);
                    }
                    arrayList.add(jSONObject);
                } catch (Throwable e) {
                    throw new FacebookException("Unable to attach images", e);
                }
            }
            this.action.setImage(arrayList);
        }

        public CONCRETE setImageAttachmentsForObject(String str, List<Bitmap> list) {
            return setImageAttachmentsForObject(str, list, false);
        }

        public CONCRETE setImageAttachmentsForObject(String str, List<Bitmap> list, boolean z) {
            Validate.notNull(str, "objectProperty");
            Validate.containsNoNulls(list, "bitmaps");
            if (this.action == null) {
                throw new FacebookException("Can not set attachments prior to setting action.");
            }
            updateObjectAttachmentUrls(str, addImageAttachments(list), z);
            return this;
        }

        public CONCRETE setImageAttachmentFilesForObject(String str, List<File> list) {
            return setImageAttachmentFilesForObject(str, list, false);
        }

        public CONCRETE setImageAttachmentFilesForObject(String str, List<File> list, boolean z) {
            Validate.notNull(str, "objectProperty");
            Validate.containsNoNulls(list, "bitmapFiles");
            if (this.action == null) {
                throw new FacebookException("Can not set attachments prior to setting action.");
            }
            updateObjectAttachmentUrls(str, addImageAttachmentFiles(list), z);
            return this;
        }

        void updateObjectAttachmentUrls(String str, List<String> list, boolean z) {
            try {
                OpenGraphObject openGraphObject = (OpenGraphObject) this.action.getPropertyAs(str, OpenGraphObject.class);
                if (openGraphObject == null) {
                    throw new IllegalArgumentException("Action does not contain a property '" + str + "'");
                } else if (openGraphObject.getCreateObject()) {
                    GraphObjectList createList;
                    GraphObjectList image = openGraphObject.getImage();
                    if (image == null) {
                        createList = Factory.createList(GraphObject.class);
                    } else {
                        createList = image;
                    }
                    for (String str2 : list) {
                        GraphObject create = Factory.create();
                        create.setProperty("url", str2);
                        if (z) {
                            create.setProperty(NativeProtocol.IMAGE_USER_GENERATED_KEY, Boolean.valueOf(true));
                        }
                        createList.add(create);
                    }
                    openGraphObject.setImage(createList);
                } else {
                    throw new IllegalArgumentException("The Open Graph object in '" + str + "' is not marked for creation");
                }
            } catch (FacebookGraphObjectException e) {
                throw new IllegalArgumentException("Property '" + str + "' is not a graph object");
            }
        }

        protected Bundle setBundleExtras(Bundle bundle) {
            putExtra(bundle, NativeProtocol.EXTRA_PREVIEW_PROPERTY_NAME, this.previewPropertyName);
            putExtra(bundle, NativeProtocol.EXTRA_ACTION_TYPE, this.actionType);
            bundle.putBoolean(NativeProtocol.EXTRA_DATA_FAILURES_FATAL, this.dataErrorsFatal);
            putExtra(bundle, NativeProtocol.EXTRA_ACTION, flattenChildrenOfGraphObject(this.action.getInnerJSONObject()).toString());
            return bundle;
        }

        protected Bundle getMethodArguments() {
            Bundle bundle = new Bundle();
            putExtra(bundle, NativeProtocol.METHOD_ARGS_PREVIEW_PROPERTY_NAME, this.previewPropertyName);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_ACTION_TYPE, this.actionType);
            bundle.putBoolean(NativeProtocol.METHOD_ARGS_DATA_FAILURES_FATAL, this.dataErrorsFatal);
            putExtra(bundle, NativeProtocol.METHOD_ARGS_ACTION, flattenChildrenOfGraphObject(this.action.getInnerJSONObject()).toString());
            return bundle;
        }

        private JSONObject flattenChildrenOfGraphObject(JSONObject jSONObject) {
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if (!str.equalsIgnoreCase("image")) {
                        jSONObject2.put(str, flattenObject(jSONObject2.get(str)));
                    }
                }
                return jSONObject2;
            } catch (Throwable e) {
                throw new FacebookException(e);
            }
        }

        private Object flattenObject(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.optBoolean(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                    return obj;
                }
                if (jSONObject.has("id")) {
                    return jSONObject.getString("id");
                }
                if (jSONObject.has("url")) {
                    return jSONObject.getString("url");
                }
                return obj;
            } else if (!(obj instanceof JSONArray)) {
                return obj;
            } else {
                JSONArray jSONArray = (JSONArray) obj;
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    jSONArray2.put(flattenObject(jSONArray.get(i)));
                }
                return jSONArray2;
            }
        }
    }

    public class OpenGraphActionDialogBuilder extends OpenGraphDialogBuilderBase<OpenGraphActionDialogBuilder> {
        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setDataErrorsFatal(boolean z) {
            return super.setDataErrorsFatal(z);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentFilesForAction(List list) {
            return super.setImageAttachmentFilesForAction(list);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentFilesForAction(List list, boolean z) {
            return super.setImageAttachmentFilesForAction(list, z);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentFilesForObject(String str, List list) {
            return super.setImageAttachmentFilesForObject(str, list);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentFilesForObject(String str, List list, boolean z) {
            return super.setImageAttachmentFilesForObject(str, list, z);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentsForAction(List list) {
            return super.setImageAttachmentsForAction(list);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentsForAction(List list, boolean z) {
            return super.setImageAttachmentsForAction(list, z);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentsForObject(String str, List list) {
            return super.setImageAttachmentsForObject(str, list);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentsForObject(String str, List list, boolean z) {
            return super.setImageAttachmentsForObject(str, list, z);
        }

        @Deprecated
        public OpenGraphActionDialogBuilder(Activity activity, OpenGraphAction openGraphAction, String str, String str2) {
            super(activity, openGraphAction, str, str2);
        }

        public OpenGraphActionDialogBuilder(Activity activity, OpenGraphAction openGraphAction, String str) {
            super(activity, openGraphAction, str);
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(OpenGraphActionDialogFeature.OG_ACTION_DIALOG);
        }
    }

    public enum OpenGraphActionDialogFeature implements DialogFeature {
        OG_ACTION_DIALOG(NativeProtocol.PROTOCOL_VERSION_20130618);
        
        private int minVersion;

        private OpenGraphActionDialogFeature(int i) {
            this.minVersion = i;
        }

        public String getAction() {
            return NativeProtocol.ACTION_OGACTIONPUBLISH_DIALOG;
        }

        public int getMinVersion() {
            return this.minVersion;
        }
    }

    public class OpenGraphMessageDialogBuilder extends OpenGraphDialogBuilderBase<OpenGraphMessageDialogBuilder> {
        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setDataErrorsFatal(boolean z) {
            return super.setDataErrorsFatal(z);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentFilesForAction(List list) {
            return super.setImageAttachmentFilesForAction(list);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentFilesForAction(List list, boolean z) {
            return super.setImageAttachmentFilesForAction(list, z);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentFilesForObject(String str, List list) {
            return super.setImageAttachmentFilesForObject(str, list);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentFilesForObject(String str, List list, boolean z) {
            return super.setImageAttachmentFilesForObject(str, list, z);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentsForAction(List list) {
            return super.setImageAttachmentsForAction(list);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentsForAction(List list, boolean z) {
            return super.setImageAttachmentsForAction(list, z);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentsForObject(String str, List list) {
            return super.setImageAttachmentsForObject(str, list);
        }

        public /* bridge */ /* synthetic */ OpenGraphDialogBuilderBase setImageAttachmentsForObject(String str, List list, boolean z) {
            return super.setImageAttachmentsForObject(str, list, z);
        }

        public OpenGraphMessageDialogBuilder(Activity activity, OpenGraphAction openGraphAction, String str) {
            super(activity, openGraphAction, str);
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(OpenGraphMessageDialogFeature.OG_MESSAGE_DIALOG);
        }
    }

    public enum OpenGraphMessageDialogFeature implements DialogFeature {
        OG_MESSAGE_DIALOG(NativeProtocol.PROTOCOL_VERSION_20140204);
        
        private int minVersion;

        private OpenGraphMessageDialogFeature(int i) {
            this.minVersion = i;
        }

        public String getAction() {
            return NativeProtocol.ACTION_OGMESSAGEPUBLISH_DIALOG;
        }

        public int getMinVersion() {
            return this.minVersion;
        }
    }

    public class PendingCall implements Parcelable {
        public static final Creator<PendingCall> CREATOR = new C06061();
        private UUID callId;
        private int requestCode;
        private Intent requestIntent;

        class C06061 implements Creator<PendingCall> {
            C06061() {
            }

            public PendingCall createFromParcel(Parcel parcel) {
                return new PendingCall(parcel);
            }

            public PendingCall[] newArray(int i) {
                return new PendingCall[i];
            }
        }

        public PendingCall(int i) {
            this.callId = UUID.randomUUID();
            this.requestCode = i;
        }

        private PendingCall(Parcel parcel) {
            this.callId = UUID.fromString(parcel.readString());
            this.requestIntent = (Intent) parcel.readParcelable(null);
            this.requestCode = parcel.readInt();
        }

        private void setRequestIntent(Intent intent) {
            this.requestIntent = intent;
        }

        public Intent getRequestIntent() {
            return this.requestIntent;
        }

        public UUID getCallId() {
            return this.callId;
        }

        private void setRequestCode(int i) {
            this.requestCode = i;
        }

        public int getRequestCode() {
            return this.requestCode;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.callId.toString());
            parcel.writeParcelable(this.requestIntent, 0);
            parcel.writeInt(this.requestCode);
        }
    }

    abstract class PhotoDialogBuilderBase<CONCRETE extends PhotoDialogBuilderBase<?>> extends Builder<CONCRETE> {
        static int MAXIMUM_PHOTO_COUNT = 6;
        private ArrayList<String> friends;
        private ArrayList<String> imageAttachmentUrls = new ArrayList();
        private String place;

        abstract int getMaximumNumberOfPhotos();

        public PhotoDialogBuilderBase(Activity activity) {
            super(activity);
        }

        public CONCRETE setPlace(String str) {
            this.place = str;
            return this;
        }

        public CONCRETE setFriends(List<String> list) {
            this.friends = list == null ? null : new ArrayList(list);
            return this;
        }

        public CONCRETE addPhotos(Collection<Bitmap> collection) {
            this.imageAttachmentUrls.addAll(addImageAttachments(collection));
            return this;
        }

        public CONCRETE addPhotoFiles(Collection<File> collection) {
            this.imageAttachmentUrls.addAll(addImageAttachmentFiles(collection));
            return this;
        }

        void validate() {
            super.validate();
            if (this.imageAttachmentUrls.isEmpty()) {
                throw new FacebookException("Must specify at least one photo.");
            } else if (this.imageAttachmentUrls.size() > getMaximumNumberOfPhotos()) {
                throw new FacebookException(String.format("Cannot add more than %d photos.", new Object[]{Integer.valueOf(getMaximumNumberOfPhotos())}));
            }
        }

        protected Bundle setBundleExtras(Bundle bundle) {
            putExtra(bundle, NativeProtocol.EXTRA_APPLICATION_ID, this.applicationId);
            putExtra(bundle, NativeProtocol.EXTRA_APPLICATION_NAME, this.applicationName);
            putExtra(bundle, NativeProtocol.EXTRA_PLACE_TAG, this.place);
            bundle.putStringArrayList(NativeProtocol.EXTRA_PHOTOS, this.imageAttachmentUrls);
            if (!Utility.isNullOrEmpty(this.friends)) {
                bundle.putStringArrayList(NativeProtocol.EXTRA_FRIEND_TAGS, this.friends);
            }
            return bundle;
        }

        protected Bundle getMethodArguments() {
            Bundle bundle = new Bundle();
            putExtra(bundle, NativeProtocol.METHOD_ARGS_PLACE_TAG, this.place);
            bundle.putStringArrayList(NativeProtocol.METHOD_ARGS_PHOTOS, this.imageAttachmentUrls);
            if (!Utility.isNullOrEmpty(this.friends)) {
                bundle.putStringArrayList(NativeProtocol.METHOD_ARGS_FRIEND_TAGS, this.friends);
            }
            return bundle;
        }
    }

    public class PhotoMessageDialogBuilder extends PhotoDialogBuilderBase<PhotoMessageDialogBuilder> {
        public /* bridge */ /* synthetic */ PhotoDialogBuilderBase addPhotoFiles(Collection collection) {
            return super.addPhotoFiles(collection);
        }

        public /* bridge */ /* synthetic */ PhotoDialogBuilderBase addPhotos(Collection collection) {
            return super.addPhotos(collection);
        }

        public PhotoMessageDialogBuilder(Activity activity) {
            super(activity);
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(MessageDialogFeature.MESSAGE_DIALOG, MessageDialogFeature.PHOTOS);
        }

        int getMaximumNumberOfPhotos() {
            return MAXIMUM_PHOTO_COUNT;
        }

        public PhotoMessageDialogBuilder setPlace(String str) {
            return this;
        }

        public PhotoMessageDialogBuilder setFriends(List<String> list) {
            return this;
        }
    }

    public class PhotoShareDialogBuilder extends PhotoDialogBuilderBase<PhotoShareDialogBuilder> {
        public /* bridge */ /* synthetic */ PhotoDialogBuilderBase addPhotoFiles(Collection collection) {
            return super.addPhotoFiles(collection);
        }

        public /* bridge */ /* synthetic */ PhotoDialogBuilderBase addPhotos(Collection collection) {
            return super.addPhotos(collection);
        }

        public /* bridge */ /* synthetic */ PhotoDialogBuilderBase setFriends(List list) {
            return super.setFriends(list);
        }

        public /* bridge */ /* synthetic */ PhotoDialogBuilderBase setPlace(String str) {
            return super.setPlace(str);
        }

        public PhotoShareDialogBuilder(Activity activity) {
            super(activity);
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(ShareDialogFeature.SHARE_DIALOG, ShareDialogFeature.PHOTOS);
        }

        int getMaximumNumberOfPhotos() {
            return MAXIMUM_PHOTO_COUNT;
        }
    }

    public class ShareDialogBuilder extends ShareDialogBuilderBase<ShareDialogBuilder> {
        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setCaption(String str) {
            return super.setCaption(str);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setDataErrorsFatal(boolean z) {
            return super.setDataErrorsFatal(z);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setDescription(String str) {
            return super.setDescription(str);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setFriends(List list) {
            return super.setFriends(list);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setLink(String str) {
            return super.setLink(str);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setName(String str) {
            return super.setName(str);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setPicture(String str) {
            return super.setPicture(str);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setPlace(String str) {
            return super.setPlace(str);
        }

        public /* bridge */ /* synthetic */ ShareDialogBuilderBase setRef(String str) {
            return super.setRef(str);
        }

        public ShareDialogBuilder(Activity activity) {
            super(activity);
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(ShareDialogFeature.SHARE_DIALOG);
        }
    }

    public enum ShareDialogFeature implements DialogFeature {
        SHARE_DIALOG(NativeProtocol.PROTOCOL_VERSION_20130618),
        PHOTOS(NativeProtocol.PROTOCOL_VERSION_20140204),
        VIDEO(NativeProtocol.PROTOCOL_VERSION_20141028);
        
        private int minVersion;

        private ShareDialogFeature(int i) {
            this.minVersion = i;
        }

        public String getAction() {
            return NativeProtocol.ACTION_FEED_DIALOG;
        }

        public int getMinVersion() {
            return this.minVersion;
        }
    }

    abstract class VideoDialogBuilderBase<CONCRETE extends VideoDialogBuilderBase<?>> extends Builder<CONCRETE> {
        private String place;
        private String videoAttachmentUrl;

        public VideoDialogBuilderBase(Activity activity) {
            super(activity);
        }

        public CONCRETE setPlace(String str) {
            this.place = str;
            return this;
        }

        public CONCRETE addVideoFile(File file) {
            this.videoAttachmentUrl = addVideoAttachmentFile(file);
            return this;
        }

        public CONCRETE setVideoUrl(String str) {
            this.videoAttachmentUrl = str;
            return this;
        }

        void validate() {
            super.validate();
            if (this.videoAttachmentUrl == null || this.videoAttachmentUrl.isEmpty()) {
                throw new FacebookException("Must specify at least one video.");
            }
        }

        protected Bundle getMethodArguments() {
            Bundle bundle = new Bundle();
            putExtra(bundle, NativeProtocol.METHOD_ARGS_PLACE_TAG, this.place);
            bundle.putString(NativeProtocol.METHOD_ARGS_VIDEO, this.videoAttachmentUrl);
            return bundle;
        }
    }

    public class VideoMessageDialogBuilder extends VideoDialogBuilderBase<VideoMessageDialogBuilder> {
        public /* bridge */ /* synthetic */ VideoDialogBuilderBase addVideoFile(File file) {
            return super.addVideoFile(file);
        }

        public /* bridge */ /* synthetic */ VideoDialogBuilderBase setVideoUrl(String str) {
            return super.setVideoUrl(str);
        }

        public VideoMessageDialogBuilder(Activity activity) {
            super(activity);
        }

        protected EnumSet<MessageDialogFeature> getDialogFeatures() {
            return EnumSet.of(MessageDialogFeature.MESSAGE_DIALOG, MessageDialogFeature.VIDEO);
        }

        public VideoMessageDialogBuilder setPlace(String str) {
            return this;
        }
    }

    public class VideoShareDialogBuilder extends VideoDialogBuilderBase<VideoShareDialogBuilder> {
        public /* bridge */ /* synthetic */ VideoDialogBuilderBase addVideoFile(File file) {
            return super.addVideoFile(file);
        }

        public /* bridge */ /* synthetic */ VideoDialogBuilderBase setPlace(String str) {
            return super.setPlace(str);
        }

        public /* bridge */ /* synthetic */ VideoDialogBuilderBase setVideoUrl(String str) {
            return super.setVideoUrl(str);
        }

        public VideoShareDialogBuilder(Activity activity) {
            super(activity);
        }

        protected EnumSet<? extends DialogFeature> getDialogFeatures() {
            return EnumSet.of(ShareDialogFeature.SHARE_DIALOG, ShareDialogFeature.VIDEO);
        }
    }

    public static boolean getNativeDialogDidComplete(Bundle bundle) {
        if (bundle.containsKey(RESULT_ARGS_DIALOG_COMPLETE_KEY)) {
            return bundle.getBoolean(RESULT_ARGS_DIALOG_COMPLETE_KEY);
        }
        return bundle.getBoolean(EXTRA_DIALOG_COMPLETE_KEY, false);
    }

    public static String getNativeDialogCompletionGesture(Bundle bundle) {
        if (bundle.containsKey(RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY)) {
            return bundle.getString(RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY);
        }
        return bundle.getString(EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
    }

    public static String getNativeDialogPostId(Bundle bundle) {
        if (bundle.containsKey(RESULT_ARGS_DIALOG_COMPLETION_ID_KEY)) {
            return bundle.getString(RESULT_ARGS_DIALOG_COMPLETION_ID_KEY);
        }
        return bundle.getString(EXTRA_DIALOG_COMPLETION_ID_KEY);
    }

    private FacebookDialog(Activity activity, Fragment fragment, PendingCall pendingCall, OnPresentCallback onPresentCallback) {
        this.activity = activity;
        this.fragment = fragment;
        this.appCall = pendingCall;
        this.onPresentCallback = onPresentCallback;
    }

    public PendingCall present() {
        logDialogActivity(this.activity, this.fragment, getEventName(this.appCall.getRequestIntent()), AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED);
        if (this.onPresentCallback != null) {
            try {
                this.onPresentCallback.onPresent(this.activity);
            } catch (Throwable e) {
                throw new FacebookException(e);
            }
        }
        if (this.fragment != null) {
            this.fragment.startActivityForResult(this.appCall.getRequestIntent(), this.appCall.getRequestCode());
        } else {
            this.activity.startActivityForResult(this.appCall.getRequestIntent(), this.appCall.getRequestCode());
        }
        return this.appCall;
    }

    public static boolean handleActivityResult(Context context, PendingCall pendingCall, int i, Intent intent, Callback callback) {
        if (i != pendingCall.getRequestCode()) {
            return false;
        }
        if (attachmentStore != null) {
            attachmentStore.cleanupAttachmentsForCall(context, pendingCall.getCallId());
        }
        if (callback != null) {
            if (NativeProtocol.isErrorResult(intent)) {
                Bundle errorDataFromResultIntent = NativeProtocol.getErrorDataFromResultIntent(intent);
                callback.onError(pendingCall, NativeProtocol.getExceptionFromErrorData(errorDataFromResultIntent), errorDataFromResultIntent);
            } else {
                callback.onComplete(pendingCall, NativeProtocol.getSuccessResultsFromIntent(intent));
            }
        }
        return true;
    }

    public static boolean canPresentShareDialog(Context context, ShareDialogFeature... shareDialogFeatureArr) {
        return handleCanPresent(context, EnumSet.of(ShareDialogFeature.SHARE_DIALOG, shareDialogFeatureArr));
    }

    public static boolean canPresentMessageDialog(Context context, MessageDialogFeature... messageDialogFeatureArr) {
        return handleCanPresent(context, EnumSet.of(MessageDialogFeature.MESSAGE_DIALOG, messageDialogFeatureArr));
    }

    public static boolean canPresentOpenGraphActionDialog(Context context, OpenGraphActionDialogFeature... openGraphActionDialogFeatureArr) {
        return handleCanPresent(context, EnumSet.of(OpenGraphActionDialogFeature.OG_ACTION_DIALOG, openGraphActionDialogFeatureArr));
    }

    public static boolean canPresentOpenGraphMessageDialog(Context context, OpenGraphMessageDialogFeature... openGraphMessageDialogFeatureArr) {
        return handleCanPresent(context, EnumSet.of(OpenGraphMessageDialogFeature.OG_MESSAGE_DIALOG, openGraphMessageDialogFeatureArr));
    }

    private static boolean handleCanPresent(Context context, Iterable<? extends DialogFeature> iterable) {
        String actionForFeatures = getActionForFeatures(iterable);
        String applicationId = Settings.getApplicationId();
        if (Utility.isNullOrEmpty(applicationId)) {
            applicationId = Utility.getMetadataApplicationId(context);
        }
        return getProtocolVersionForNativeDialog(context, actionForFeatures, getVersionSpecForFeatures(applicationId, actionForFeatures, iterable)) != -1;
    }

    private static int getProtocolVersionForNativeDialog(Context context, String str, int[] iArr) {
        return NativeProtocol.getLatestAvailableProtocolVersionForAction(context, str, iArr);
    }

    private static NativeAppCallAttachmentStore getAttachmentStore() {
        if (attachmentStore == null) {
            attachmentStore = new NativeAppCallAttachmentStore();
        }
        return attachmentStore;
    }

    private static int[] getVersionSpecForFeatures(String str, String str2, Iterable<? extends DialogFeature> iterable) {
        int[] iArr = null;
        for (DialogFeature versionSpecForFeature : iterable) {
            iArr = Utility.intersectRanges(iArr, getVersionSpecForFeature(str, str2, versionSpecForFeature));
        }
        return iArr;
    }

    private static int[] getVersionSpecForFeature(String str, String str2, DialogFeature dialogFeature) {
        DialogFeatureConfig dialogFeatureConfig = Utility.getDialogFeatureConfig(str, str2, dialogFeature.name());
        if (dialogFeatureConfig != null) {
            return dialogFeatureConfig.getVersionSpec();
        }
        return new int[]{dialogFeature.getMinVersion()};
    }

    private static String getActionForFeatures(Iterable<? extends DialogFeature> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return ((DialogFeature) it.next()).getAction();
        }
        return null;
    }

    private static void logDialogActivity(Activity activity, Fragment fragment, String str, String str2) {
        if (fragment != null) {
            activity = fragment.getActivity();
        }
        AppEventsLogger newLogger = AppEventsLogger.newLogger(activity);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME, str2);
        newLogger.logSdkEvent(str, null, bundle);
    }

    private static String getEventName(Intent intent) {
        boolean z;
        boolean z2 = true;
        String stringExtra = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION);
        boolean hasExtra = intent.hasExtra(NativeProtocol.EXTRA_PHOTOS);
        Bundle bundleExtra = intent.getBundleExtra(NativeProtocol.EXTRA_PROTOCOL_METHOD_ARGS);
        if (bundleExtra != null) {
            ArrayList stringArrayList = bundleExtra.getStringArrayList(NativeProtocol.METHOD_ARGS_PHOTOS);
            String string = bundleExtra.getString(NativeProtocol.METHOD_ARGS_VIDEO);
            if (!(stringArrayList == null || stringArrayList.isEmpty())) {
                hasExtra = true;
            }
            if (string == null || string.isEmpty()) {
                z2 = false;
                z = hasExtra;
            } else {
                z = hasExtra;
            }
        } else {
            z2 = false;
            z = hasExtra;
        }
        return getEventName(stringExtra, z, z2);
    }

    private static String getEventName(String str, boolean z, boolean z2) {
        if (str.equals(NativeProtocol.ACTION_FEED_DIALOG)) {
            if (z2) {
                return AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_VIDEO_SHARE;
            }
            if (z) {
                return AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_PHOTO_SHARE;
            }
            return AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_SHARE;
        } else if (str.equals(NativeProtocol.ACTION_MESSAGE_DIALOG)) {
            if (z) {
                return AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_PHOTO_MESSAGE;
            }
            return AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_MESSAGE;
        } else if (str.equals(NativeProtocol.ACTION_OGACTIONPUBLISH_DIALOG)) {
            return AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_OG_SHARE;
        } else {
            if (str.equals(NativeProtocol.ACTION_OGMESSAGEPUBLISH_DIALOG)) {
                return AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_OG_MESSAGE;
            }
            if (str.equals(NativeProtocol.ACTION_LIKE_DIALOG)) {
                return AnalyticsEvents.EVENT_NATIVE_DIALOG_TYPE_LIKE;
            }
            throw new FacebookException("An unspecified action was presented");
        }
    }
}
