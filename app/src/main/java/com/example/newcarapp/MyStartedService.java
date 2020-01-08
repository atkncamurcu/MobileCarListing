package com.example.newcarapp;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.core.app.TaskStackBuilder;

public class MyStartedService extends IntentService {

    public static final String EXTRA_MESSAGE = "notification message";
    public static final int NOTIFICATION_ID = 1;

    public MyStartedService() {
        super("MyStartedService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        synchronized (this){
            try{
                while (true) {
                    wait(10000);
                    String text  =intent.getStringExtra(EXTRA_MESSAGE);
                    showNotification(text);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void showNotification(final String text) {


        Intent intent = new Intent(this, HomeActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.login_icon)
                .setContentTitle(getString(R.string.notificationtitle))
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(pendingIntent)
                .setContentText(text)
                .build();
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

}
