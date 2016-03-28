package com.example.cdoit.characterstrengthbuilder;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Jessica on 3/28/2016.
 */
public class DeadlinePassedAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String wish = intent.getStringExtra("wish");
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("Character Strength Builder")
                .setContentText("The deadline for your wish: " + wish + " was yesterday.")
                .setSmallIcon(R.drawable.com_facebook_button_like_icon_selected)
                .build();

        manager.notify(0, notification);
    }
}
