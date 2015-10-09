package com.flowerfat.utiltool.Utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * Created by 明明大美女 on 2015/9/28.
 * <p>
 * Notification
 */
public class NotificationUtil {

    private Context mContext;
    private NotificationManager manager;

    public NotificationUtil(Context context) {
        mContext = context;
        // 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }


    public void show(Class toActivity,String ticker, String title, String content, int Icon) {
        PendingIntent pendingIntent2 = PendingIntent.getActivity(mContext, 0,
                new Intent(mContext, toActivity), 0);
        // 通过Notification.Builder来创建通知，注意API Level API11之后才支持
        Notification notify = new Notification.Builder(mContext)
                .setSmallIcon(Icon) // 设置状态栏中的小图片，尺寸一般建议在24×24，这个图片同样也是在下拉状态栏中所显示，如果在那里需要更换更大的图片，可以使用setLargeIcon(Bitmap icon)
                .setTicker(ticker)// 设置在status bar上显示的提示文字
                .setContentTitle(title)// 设置在下拉status bar后Activity，本例子中的NotififyMessage的TextView中显示的标题
                .setContentText(content)// TextView中显示的详细内容
                .setContentIntent(pendingIntent2) // 关联PendingIntent
                .setNumber(1) // 在TextView的右方显示的数字，可放大图片看，在最右侧。这个number同时也起到一个序列号的左右，如果多个触发多个通知（同一ID），可以指定显示哪一个。
                .getNotification(); // 需要注意build()是在API level 16及之后增加的，在API11中可以使用getNotificatin()来代替
        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        manager.notify(1, notify);
    }

    /**
     * 清除id为notificationId的通知
     *
     * @param notificationId 要清楚的消息的id
     */
    public void clearById(int notificationId) {
        manager.cancel(notificationId);
    }

    /**
     * 清空所有消息
     */
    public void clearAll() {
        manager.cancelAll();
    }
}
