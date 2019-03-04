package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

class FragmentTransitionCompat21 {

    public interface ViewRetriever {
        View getView();
    }

    final class C00461 extends EpicenterCallback {
        final /* synthetic */ Rect val$epicenter;

        C00461(Rect rect) {
            this.val$epicenter = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.val$epicenter;
        }
    }

    final class C00472 implements OnPreDrawListener {
        final /* synthetic */ View val$container;
        final /* synthetic */ Transition val$enterTransition;
        final /* synthetic */ ArrayList val$enteringViews;
        final /* synthetic */ ViewRetriever val$inFragment;
        final /* synthetic */ Map val$nameOverrides;
        final /* synthetic */ Map val$renamedViews;

        C00472(View view, ViewRetriever viewRetriever, Map map, Map map2, Transition transition, ArrayList arrayList) {
            this.val$container = view;
            this.val$inFragment = viewRetriever;
            this.val$nameOverrides = map;
            this.val$renamedViews = map2;
            this.val$enterTransition = transition;
            this.val$enteringViews = arrayList;
        }

        public boolean onPreDraw() {
            this.val$container.getViewTreeObserver().removeOnPreDrawListener(this);
            View view = this.val$inFragment.getView();
            if (view != null) {
                if (!this.val$nameOverrides.isEmpty()) {
                    FragmentTransitionCompat21.findNamedViews(this.val$renamedViews, view);
                    this.val$renamedViews.keySet().retainAll(this.val$nameOverrides.values());
                    for (Entry entry : this.val$nameOverrides.entrySet()) {
                        View view2 = (View) this.val$renamedViews.get((String) entry.getValue());
                        if (view2 != null) {
                            view2.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.val$enterTransition != null) {
                    FragmentTransitionCompat21.captureTransitioningViews(this.val$enteringViews, view);
                    this.val$enteringViews.removeAll(this.val$renamedViews.values());
                    FragmentTransitionCompat21.addTargets(this.val$enterTransition, this.val$enteringViews);
                }
            }
            return true;
        }
    }

    final class C00483 extends EpicenterCallback {
        private Rect mEpicenter;
        final /* synthetic */ EpicenterView val$epicenterView;

        C00483(EpicenterView epicenterView) {
            this.val$epicenterView = epicenterView;
        }

        public Rect onGetEpicenter(Transition transition) {
            if (this.mEpicenter == null && this.val$epicenterView.epicenter != null) {
                this.mEpicenter = FragmentTransitionCompat21.getBoundsOnScreen(this.val$epicenterView.epicenter);
            }
            return this.mEpicenter;
        }
    }

    final class C00494 implements OnPreDrawListener {
        final /* synthetic */ Transition val$enterTransition;
        final /* synthetic */ ArrayList val$enteringViews;
        final /* synthetic */ Transition val$exitTransition;
        final /* synthetic */ ArrayList val$exitingViews;
        final /* synthetic */ ArrayList val$hiddenViews;
        final /* synthetic */ View val$nonExistentView;
        final /* synthetic */ Transition val$overallTransition;
        final /* synthetic */ Map val$renamedViews;
        final /* synthetic */ View val$sceneRoot;
        final /* synthetic */ ArrayList val$sharedElementTargets;
        final /* synthetic */ Transition val$sharedElementTransition;

        C00494(View view, Transition transition, View view2, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4) {
            this.val$sceneRoot = view;
            this.val$enterTransition = transition;
            this.val$nonExistentView = view2;
            this.val$enteringViews = arrayList;
            this.val$exitTransition = transition2;
            this.val$exitingViews = arrayList2;
            this.val$sharedElementTransition = transition3;
            this.val$sharedElementTargets = arrayList3;
            this.val$renamedViews = map;
            this.val$hiddenViews = arrayList4;
            this.val$overallTransition = transition4;
        }

        public boolean onPreDraw() {
            this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.val$enterTransition != null) {
                this.val$enterTransition.removeTarget(this.val$nonExistentView);
                FragmentTransitionCompat21.removeTargets(this.val$enterTransition, this.val$enteringViews);
            }
            if (this.val$exitTransition != null) {
                FragmentTransitionCompat21.removeTargets(this.val$exitTransition, this.val$exitingViews);
            }
            if (this.val$sharedElementTransition != null) {
                FragmentTransitionCompat21.removeTargets(this.val$sharedElementTransition, this.val$sharedElementTargets);
            }
            for (Entry entry : this.val$renamedViews.entrySet()) {
                ((View) entry.getValue()).setTransitionName((String) entry.getKey());
            }
            int size = this.val$hiddenViews.size();
            for (int i = 0; i < size; i++) {
                this.val$overallTransition.excludeTarget((View) this.val$hiddenViews.get(i), false);
            }
            this.val$overallTransition.excludeTarget(this.val$nonExistentView, false);
            return true;
        }
    }

    public class EpicenterView {
        public View epicenter;
    }

    FragmentTransitionCompat21() {
    }

    public static String getTransitionName(View view) {
        return view.getTransitionName();
    }

    public static Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return obj;
    }

    public static Object captureExitingViews(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map) {
        if (obj == null) {
            return obj;
        }
        captureTransitioningViews(arrayList, view);
        if (map != null) {
            arrayList.removeAll(map.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        addTargets((Transition) obj, arrayList);
        return obj;
    }

    public static void excludeTarget(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static void setEpicenter(Object obj, View view) {
        ((Transition) obj).setEpicenterCallback(new C00461(getBoundsOnScreen(view)));
    }

    public static void addTransitionTargets(Object obj, Object obj2, View view, ViewRetriever viewRetriever, View view2, EpicenterView epicenterView, Map<String, String> map, ArrayList<View> arrayList, Map<String, View> map2, ArrayList<View> arrayList2) {
        if (obj != null || obj2 != null) {
            Transition transition = (Transition) obj;
            if (transition != null) {
                transition.addTarget(view2);
            }
            if (obj2 != null) {
                addTargets((Transition) obj2, arrayList2);
            }
            if (viewRetriever != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new C00472(view, viewRetriever, map, map2, transition, arrayList));
            }
            setSharedElementEpicenter(transition, epicenterView);
        }
    }

    public static Object mergeTransitions(Object obj, Object obj2, Object obj3, boolean z) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition == null || transition2 == null) {
            z = true;
        }
        Object transitionSet;
        if (z) {
            transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 == null) {
                return transitionSet;
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        Transition transition4 = null;
        if (transition2 != null && transition != null) {
            transition4 = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
        } else if (transition2 != null) {
            transition4 = transition2;
        } else if (transition != null) {
            transition4 = transition;
        }
        if (transition3 == null) {
            return transition4;
        }
        transitionSet = new TransitionSet();
        if (transition4 != null) {
            transitionSet.addTransition(transition4);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    private static void setSharedElementEpicenter(Transition transition, EpicenterView epicenterView) {
        if (transition != null) {
            transition.setEpicenterCallback(new C00483(epicenterView));
        }
    }

    private static Rect getBoundsOnScreen(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }

    private static void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                captureTransitioningViews(arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public static void findNamedViews(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    findNamedViews(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void cleanupTransitions(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        Transition transition4 = (Transition) obj4;
        if (transition4 != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new C00494(view, transition, view2, arrayList, transition2, arrayList2, transition3, arrayList3, map, arrayList4, transition4));
        }
    }

    public static void removeTargets(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            transition.removeTarget((View) arrayList.get(i));
        }
    }

    public static void addTargets(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            transition.addTarget((View) arrayList.get(i));
        }
    }
}
