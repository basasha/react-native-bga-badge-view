package cn.bingoogolapple.badgeview.react;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

import cn.bingoogolapple.badgeview.BGABadgeView;
import cn.bingoogolapple.badgeview.BGABadgeable;
import cn.bingoogolapple.badgeview.BGADragDismissDelegate;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:16/3/13 下午12:24
 * 描述:
 */
public class ReactBGABadgeViewManager extends SimpleViewManager<BGABadgeView> {
    private static final String REACT_CLASS = "AndroidBGABadgeView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected BGABadgeView createViewInstance(ThemedReactContext reactContext) {
        BGABadgeView badgeView = new BGABadgeView(reactContext);
        badgeView.getBadgeViewHelper().setDragable(true);
        return badgeView;
    }

    @ReactProp(name = "badgeBgColor")
    public void setBadgeBgColor(BGABadgeView view, String color) {
        if (!TextUtils.isEmpty(color)) {
            view.getBadgeViewHelper().setBadgeBgColorInt(Color.parseColor(color));
        }
    }

    @ReactProp(name = "badgeTextColor")
    public void setBadgeTextColor(BGABadgeView view, String color) {
        if (!TextUtils.isEmpty(color)) {
            view.getBadgeViewHelper().setBadgeTextColorInt(Color.parseColor(color));
        }
    }

    @ReactProp(name = "textBadge")
    public void setTextBadge(BGABadgeView view, String text) {
        if (TextUtils.isEmpty(text)) {
            view.hiddenBadge();
        } else {
            view.showTextBadge(text);
        }
    }

    @ReactProp(name = "circlePointBadge")
    public void setCirclePointBadge(BGABadgeView view, boolean isShowCircleBadge) {
        if (isShowCircleBadge) {
            view.showCirclePointBadge();
        } else {
            view.hiddenBadge();
        }
    }

    @ReactProp(name = "drawableBadge")
    public void setDrawableBadge(BGABadgeView view, String drawableBadge) {
        if (TextUtils.isEmpty(drawableBadge)) {
            view.hiddenBadge();
        } else {
            int resId = getMipmap(view.getContext(), drawableBadge);
            if (resId == 0) {
                view.hiddenBadge();
            } else {
                Bitmap badgeBitmap = BitmapFactory.decodeResource(view.getResources(), resId);
                view.showDrawableBadge(badgeBitmap);
            }
        }
    }

    @ReactProp(name = "dragable")
    public void setDragable(BGABadgeView view, boolean dragable) {
        view.getBadgeViewHelper().setDragable(dragable);
    }

    @ReactProp(name = "badgeTextSizeSp")
    public void setBadgeTextSize(BGABadgeView view, int badgetextSize) {
        view.getBadgeViewHelper().setBadgeTextSizeSp(badgetextSize);
    }

    @ReactProp(name = "badgePaddingDp")
    public void setBadgePadding(BGABadgeView view, int badgePadding) {
        view.getBadgeViewHelper().setBadgePaddingDp(badgePadding);
    }

    @Override
    protected void addEventEmitters(final ThemedReactContext reactContext, final BGABadgeView view) {
        view.setDragDismissDelegage(new BGADragDismissDelegate() {
            @Override
            public void onDismiss(BGABadgeable badgeable) {
                // 一定要用view.getId()，不能用badgeable.getId()，这个坑踩了半天
                reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher()
                        .dispatchEvent(new ReactBGABadgeEvent(view.getId(), SystemClock.uptimeMillis()));
            }
        });
    }

    @Override
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.<String, Object>builder()
                .put(ReactBGABadgeEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDismiss"))
                .build();
    }

    public static int getMipmap(Context context, String name){
        return context.getResources().getIdentifier(name, "mipmap", context.getPackageName());
    }
}
