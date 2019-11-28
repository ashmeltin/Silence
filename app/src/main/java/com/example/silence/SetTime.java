package com.example.silence;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

public class SetTime extends AppCompatActivity {
    private TextView setName;
    private TimePicker startTimer;
    private TimePicker endTimer;
    private List<String> days;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_time);
        setTitle("set a time"); //still dk what this does
        days = new ArrayList<>();

        //back button code
        Button back = findViewById(R.id.backButton);
        back.setText("back");
        back.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        //set name code
        setName = findViewById(R.id.setTimerName);
        setName.setText("Timer Name");

        //start timer code
        startTimer = findViewById(R.id.startTime);
        startTimer.setIs24HourView(false);

        //end timer code
        endTimer = findViewById(R.id.endTime);
        endTimer.setIs24HourView(false);

        //set start time code
        TextView chooseStartTime = findViewById(R.id.chooseStart);
        chooseStartTime.setText("set a start time");
        chooseStartTime.setVisibility(View.VISIBLE);

        //set end time code
        TextView chooseEndTime = findViewById(R.id.chooseEnd);
        chooseEndTime.setText("set an end time");
        chooseEndTime.setVisibility(View.VISIBLE);

        //checkbox code
        CheckBox sunday = findViewById(R.id.sunday);
        sunday.setText("s");
        if (sunday.isChecked()) {
            //set timer on sunday
            days.add("s");
        }
        CheckBox monday = findViewById(R.id.monday);
        monday.setText("m");
        if (monday.isChecked()) {
            //set timer on monday
            days.add("m");
        }
        CheckBox tuesday = findViewById(R.id.tuesday);
        tuesday.setText("t");
        if (tuesday.isChecked()) {
            //set timer on tuesday
            days.add("t");
        }
        CheckBox wednesday = findViewById(R.id.wednesday);
        wednesday.setText("w");
        if (wednesday.isChecked()) {
            //set timer on wednesday
            days.add("w");
        }
        CheckBox thursday = findViewById(R.id.thursday);
        thursday.setText("t");
        if (thursday.isChecked()) {
            //set timer on thursday
            days.add("t");
        }
        CheckBox friday = findViewById(R.id.friday);
        friday.setText("f");
        if (friday.isChecked()) {
            //set timer on friday
            days.add("f");
        }
        CheckBox saturday = findViewById(R.id.saturday);
        saturday.setText("s");
        if (saturday.isChecked()) {
            //set timer on saturday
            days.add("s");
        }

        //done button code
        Button done = findViewById(R.id.doneButton);
        done.setText("done");
        done.setOnClickListener(v -> {
            setContentView(R.layout.manage_times);
            Button backButton = findViewById(R.id.backButton);
            backButton.setText("back");
            backButton.setOnClickListener(b -> {
                startActivity(new Intent(this, MainActivity.class));
            });
            updateUI();
        });
    }
    public String getTimerName() {
        return setName.getText().toString();
    }
    public String getDayString(List<String> days) {
        StringBuilder sb = new StringBuilder();
        for (String s : days) {
            sb.append(s);
            sb.append("\t");
        }
        Log.d("PRINT", sb.toString());
        return sb.toString();
    }
    public int[] getStartTime() {
        int[] time = new int[2];
        time[0] = startTimer.getHour();
        time[1] = startTimer.getMinute();
        return time;
    }
    public int[] getEndTime() {
        int[] time = new int[2];
        time[0] = endTimer.getHour();
        time[1] = endTimer.getMinute();
        return time;
    }
    public void updateUI() {
        LinearLayout parent = findViewById(R.id.onGoingTimers);
        View ongoingTimersChunk = getLayoutInflater().inflate(R.layout.chunk_ongoing_timers, parent, false);
        TextView setName = ongoingTimersChunk.findViewById(R.id.setTimerName);
        setName.setText(getTimerName());
        TextView setRange = ongoingTimersChunk.findViewById(R.id.timeRange);
        setRange.setText("placeholder");
        TextView setDays = ongoingTimersChunk.findViewById(R.id.days);
        setDays.setText(getDayString(days));
        Button edit = ongoingTimersChunk.findViewById(R.id.edit);
        edit.setText("edit");
        edit.setOnClickListener(v -> {
            parent.removeAllViews();
            startActivity(new Intent(this, SetTime.class));
        });
        Button delete = ongoingTimersChunk.findViewById(R.id.delete);
        delete.setText("delete");
        delete.setOnClickListener(v -> {
            parent.removeAllViews();
        });
        parent.addView(ongoingTimersChunk);
    }
}
