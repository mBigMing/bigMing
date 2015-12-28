package com.flowerfat.utiltool.Utils;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.flowerfat.utiltool.R;

/**
 * Notification
 * http://hukai.me/android-dev-patterns/
 */
public class NotificationUtil {

    private Context mContext;
    private NotificationManagerCompat manager;

    public NotificationUtil(Context context) {
        mContext = context;
        manager = NotificationManagerCompat.from(mContext);
    }

    public void show(Class toActivity, String ticker, String title, String content, int Icon) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);
        builder
            .setSmallIcon(Icon) // small icon, 24×24，against with setLargeIcon(Bitmap icon)
            .setContentTitle(title)
            .setContentText(content)
            .setTicker(ticker)// set the text shown on the status bar
            .setNumber(1);
        if(toActivity != null){
            PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0,
                    new Intent(mContext, toActivity), 0);
            builder.setContentIntent(pendingIntent);
        }
        Notification notification = builder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL ; // disappear when click
        manager.notify(0, notification);
    }


    /**
     * clear the notification which id is notificationId
     *
     * @param notificationId
     */
    public void clearById(int notificationId) {
        manager.cancel(notificationId);
    }

    /**
     * clear all notification
     */
    public void clearAll() {
        manager.cancelAll();
    }


}
