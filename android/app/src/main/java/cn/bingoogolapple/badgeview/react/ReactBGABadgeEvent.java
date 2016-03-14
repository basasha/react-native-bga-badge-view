package cn.bingoogolapple.badgeview.react;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:16/3/13 下午9:54
 * 描述:
 */
public class ReactBGABadgeEvent extends Event<ReactBGABadgeEvent> {
    public static final String EVENT_NAME = "topDismiss";

    protected ReactBGABadgeEvent(int viewTag, long timestampMs) {
        super(viewTag, timestampMs);
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), null);
    }

}
