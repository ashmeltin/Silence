package com.example.silence;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.media.AudioManager;
import android.util.Log;

import static android.content.Context.ALARM_SERVICE;

public class SilenceBroadcastReceiver extends BroadcastReceiver {
    AudioManager audioManager;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Alarm", "silence");
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);

        Log.d("Alarm", "another alarm");
        int[] endTime = intent.getIntArrayExtra("endTime");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, endTime[0]);
        calendar.set(Calendar.MINUTE, endTime[1]);

        Intent alarmIntent = new Intent(context.getApplicationContext(), UnsilenceBroadcastReceiver.class);
        PendingIntent pending = PendingIntent.getBroadcast(context.getApplicationContext(), 2, alarmIntent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7, pending);
    }
}
