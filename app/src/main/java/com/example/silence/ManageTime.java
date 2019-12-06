package com.example.silence;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ManageTime extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_times);
        Button back = findViewById(R.id.backButton);
        back.setText("back");
        back.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
        Button addNew = findViewById(R.id.addNewTimer);
        addNew.setText("add a time");
        addNew.setOnClickListener(v -> {
            startActivityForResult(new Intent(this, SetTime.class),1);
        });
    }
    public long lengthOfTime(int[] start, int[] end) {
        int hours = end[0] - start[0];
        int minutes = Math.abs(end[1] - start[1]);
        long hourMilliseconds = hours * 60 * 60 * 1000;
        long minutesMilliseconds = minutes * 60 * 1000;
        return hourMilliseconds + minutesMilliseconds;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                LinearLayout parent = findViewById(R.id.onGoingTimers);
                View ongoingTimersChunk = getLayoutInflater().inflate(R.layout.chunk_ongoing_timers, parent, false);

                String[] days = data.getStringArrayExtra("days");

                int[] startTime = data.getIntArrayExtra("startTime");

                int[] endTime = data.getIntArrayExtra("endTime");

                TextView setName = ongoingTimersChunk.findViewById(R.id.setTimerName);
                String timerName = data.getStringExtra("timerName");
                setName.setText(timerName);

                TextView setRange = ongoingTimersChunk.findViewById(R.id.timeRange);
                String timerRange = data.getStringExtra("timeRange");
                setRange.setText(timerRange);

                TextView setDays = ongoingTimersChunk.findViewById(R.id.days);
                String daysSelected = data.getStringExtra("daysSelected");
                setDays.setText(daysSelected);

                Button edit = ongoingTimersChunk.findViewById(R.id.edit);
                edit.setText("edit");
                edit.setOnClickListener(v -> {
                    ongoingTimersChunk.setVisibility(View.GONE);
                    startActivityForResult(new Intent(this, SetTime.class), 1);
                });

                Button delete = ongoingTimersChunk.findViewById(R.id.delete);
                delete.setText("delete");
                delete.setOnClickListener(v -> {
                    ongoingTimersChunk.setVisibility(View.GONE);
                });
                parent.addView(ongoingTimersChunk);

                //alarm code
                Log.d("Alarm", "initial");
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY, startTime[0]);
                calendar.set(Calendar.MINUTE, startTime[1]);

                Intent intent = new Intent(getApplicationContext(), SilenceBroadcastReceiver.class);
                intent.putExtra("endTime", endTime);
                PendingIntent pending = PendingIntent.getBroadcast(getApplicationContext(), 2, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7, pending);
                //this will be set on the exact same day because logic errors I don't wanna deal with rn
            }
        }
    }
}
