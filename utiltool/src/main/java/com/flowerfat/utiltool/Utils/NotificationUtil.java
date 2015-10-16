package com.flowerfat.utiltool.Utils;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.flowerfat.utiltool.R;

/**
 * Created by 明明大美女 on 2015/9/28.
 * <p/>
 * Notification
 * <p/>
 * http://hukai.me/android-dev-patterns/
 */
public class NotificationUtil {

    private Context mContext;
    private NotificationManagerCompat manager;

    public NotificationUtil(Context context) {
        mContext = context;
        // 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
        manager = NotificationManagerCompat.from(mContext);
    }

    public void show(Class toActivity, String ticker, String title, String content, int Icon) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);
        builder
            .setSmallIcon(R.drawable.ic_launcher) // 设置状态栏中的小图片，尺寸一般建议在24×24，这个图片同样也是在下拉状态栏中所显示，如果在那里需要更换更大的图片，可以使用setLargeIcon(Bitmap icon)
            .setContentTitle(title)
            .setContentText(content)
            .setTicker(ticker)// 设置在status bar上显示的提示文字
            .setNumber(1); // 在TextView的右方显示的数字.这个number同时也起到一个序列号的左右，如果多个触发多个通知（同一ID），可以指定显示哪一个。
        if(toActivity != null){
            PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0,
                    new Intent(mContext, toActivity), 0);
            builder.setContentIntent(pendingIntent); // 关联PendingIntent
        }
        Notification notification = builder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL ; // 点击后消失
        manager.notify(0, notification);
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
