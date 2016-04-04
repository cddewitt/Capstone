package com.example.cdoit.characterstrengthbuilder;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Vibrator;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Jessica on 3/28/2016.
 */
public class FiveDaysAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String wish = intent.getStringExtra("wish");
        Intent mainIntent = new Intent(context, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context,0,mainIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        long[] pattern = {Long.valueOf(500),Long.valueOf(500),Long.valueOf(500),Long.valueOf(500)};

        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("Character Strength Builder")
                .setContentText("The deadline for your wish: " + wish + " is in five days.")
                .setTicker("The deadline for your wish: " + wish + " is in five days.")
                .setContentInfo("The deadline for your wish: " + wish + " is in five days.")
                .setColor(Color.WHITE) //functional just currently looking for a good color
                .setLights(Color.CYAN,3000,1000)
                .setVibrate(pattern)
                .setSound(RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(pIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();

        manager.notify(0, notification);
    }
}

