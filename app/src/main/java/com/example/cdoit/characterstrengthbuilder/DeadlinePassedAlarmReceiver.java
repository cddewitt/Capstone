package com.example.cdoit.characterstrengthbuilder;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.support.v7.app.NotificationCompat;

public class DeadlinePassedAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String wish = intent.getStringExtra("wish");
        Intent mainIntent = new Intent(context, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, mainIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        long[] pattern = {(long) 500, (long) 500,(long) 500,(long) 500};

        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("Character Strength Builder")
                .setContentText("The deadline for your wish: " + wish + " was yesterday.")
                .setTicker("The deadline for your wish: " + wish + " was yesterday.")
                .setContentInfo("The deadline for your wish: " + wish + " was yesterday.")
                .setColor(Color.WHITE)
                .setLights(Color.CYAN, 3000, 1000)
                .setVibrate(pattern)
                .setSound(RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(pIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();

        manager.notify(0, notification);
    }
}

