package com.example.silence;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class SilenceBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //silencing API code here
        int[] endTime = intent.getIntArrayExtra("endTime");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, endTime[0]);
        calendar.set(Calendar.MINUTE, endTime[1]);

        Intent alarmIntent = new Intent(context, UnsilenceBroadcastReceiver.class);
        PendingIntent pending = PendingIntent.getBroadcast(context, 2, alarmIntent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7, pending);
    }
}
