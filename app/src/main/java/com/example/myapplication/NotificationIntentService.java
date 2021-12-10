package com.example.myapplication;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationManagerCompat;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class NotificationIntentService extends IntentService {

    // TODO: Rename actions, choose action names that describe tasks that this



    // TODO: Rename parameters

    private static final int NOTIFICATION_ID = 3;

    public NotificationIntentService() {
        super("NotificationIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        Notification.Builder noBuilder=new Notification.Builder(this);
                noBuilder.setContentTitle("Your Diet");
                noBuilder.setContentText("Track your Diet changes and improvements");
                noBuilder.setSmallIcon(R.drawable.ic_baseline_no_food_24);
                Intent noIntent1=new Intent(this, MainActivity.class);
                PendingIntent pendingIntent =PendingIntent.getActivity(this,2,noIntent1 ,PendingIntent.FLAG_CANCEL_CURRENT);
                noBuilder.setContentIntent(pendingIntent);
                Notification notification=noBuilder.build();
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID , notification);
        NotificationManager mNotificationManager;
        mNotificationManager =
                (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
         //this is required for SDK version 26 and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelId = "Your_channel_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_HIGH);
            mNotificationManager.createNotificationChannel(channel);
            noBuilder.setChannelId(channelId);


        }
        noBuilder.build();
        mNotificationManager.notify(NOTIFICATION_ID,notification);

    }




}