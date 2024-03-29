package com.example.silence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
        days = new ArrayList<>();

        //back button code
        Button back = findViewById(R.id.backButton);
        back.setText("back");
        back.setOnClickListener(v -> {
            startActivity(new Intent(this, ManageTime.class));
        });

        //set name code
        setName = findViewById(R.id.setTimerName);
        setName.setHint("Enter Name");

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
        sunday.setText("su");

        CheckBox monday = findViewById(R.id.monday);
        monday.setText("m");

        CheckBox tuesday = findViewById(R.id.tuesday);
        tuesday.setText("tu");

        CheckBox wednesday = findViewById(R.id.wednesday);
        wednesday.setText("w");

        CheckBox thursday = findViewById(R.id.thursday);
        thursday.setText("th");

        CheckBox friday = findViewById(R.id.friday);
        friday.setText("f");

        CheckBox saturday = findViewById(R.id.saturday);
        saturday.setText("sa");

        //done button code
        Button done = findViewById(R.id.doneButton);
        done.setText("done");
        done.setOnClickListener(v -> {
           String timerName = getTimerName();
           int[] startTime = getStartTime();
           int[] endTime = getEndTime();
           String timeRange = startTime[0] + ":" + startTime[1] + " - " + endTime[0] + ":" + endTime[1];
           String daysSelected = getDayString(days);
           Intent intent = new Intent();
           intent.putExtra("timerName", timerName);
           intent.putExtra("timeRange", timeRange);
           intent.putExtra("daysSelected", daysSelected);
           intent.putExtra("startTime", getStartTime());
           intent.putExtra("endTime",getEndTime());
           intent.putExtra("days", getDaysSelected(days));
           setResult(Activity.RESULT_OK, intent);
           finish();
        });
    }
    public String[] getDaysSelected(List<String> days) {
        String[] daysSelected = new String[days.size()];
        for (int i = 0; i < days.size(); i++) {
            daysSelected[i] = days.get(i);
        }
        return daysSelected;
    }
    public String getTimerName() {
        return setName.getText().toString();
    }
    public String getDayString(List<String> days) {
        StringBuilder sb = new StringBuilder();
        for (String s : days) {
            sb.append(s);
            sb.append("\t\t");
        }
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
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        int id = view.getId();
        if (checked) {
            if (id == R.id.sunday) {
                days.add("su");
            }
            if (id == R.id.monday) {
                days.add("m");
            }
            if (id == R.id.tuesday) {
                days.add("tu");
            }
            if (id == R.id.wednesday) {
                days.add("w");
            }
            if (id == R.id.thursday) {
                days.add("th");
            }
            if (id == R.id.friday) {
                days.add("f");
            }
            if (id == R.id.saturday) {
                days.add("sa");
            }
        }
        return;
    }
}
