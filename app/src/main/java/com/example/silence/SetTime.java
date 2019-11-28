package com.example.silence;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;

public class SetTime extends AppCompatActivity {
    private TimePicker startTimer;
    private TimePicker endTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_time);
        setTitle("set a time"); //still dk what this does

        //back button code
        Button back = findViewById(R.id.backButton);
        back.setText("back");
        back.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        //set name code
        TextView setName = findViewById(R.id.setTimerName);
        setName.setText("Timer Name");
        String timerName = setName.getText().toString();

        //start timer code
        startTimer = findViewById(R.id.startTime);
        startTimer.setIs24HourView(true);

        //end timer code
        endTimer = findViewById(R.id.endTime);
        endTimer.setIs24HourView(true);

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
        sunday.setText("sun");
        if (sunday.isChecked()) {
            //set timer on sunday
        }
        CheckBox monday = findViewById(R.id.monday);
        monday.setText("mon");
        if (monday.isChecked()) {
            //set timer on monday
        }
        CheckBox tuesday = findViewById(R.id.tuesday);
        tuesday.setText("tue");
        if (tuesday.isChecked()) {
            //set timer on tuesday
        }
        CheckBox wednesday = findViewById(R.id.wednesday);
        wednesday.setText("wed");
        if (wednesday.isChecked()) {
            //set timer on wednesday
        }
        CheckBox thursday = findViewById(R.id.thursday);
        thursday.setText("thu");
        if (thursday.isChecked()) {
            //set timer on thursday
        }
        CheckBox friday = findViewById(R.id.friday);
        friday.setText("fri");
        if (friday.isChecked()) {
            //set timer on friday
        }
        CheckBox saturday = findViewById(R.id.saturday);
        saturday.setText("sat");
        if (saturday.isChecked()) {
            //set timer on saturday
        }

        //done button code
        Button done = findViewById(R.id.doneButton);
        done.setText("done");
        done.setOnClickListener(v -> {
            startActivity(new Intent(this, ManageTime.class));
        });
    }
}
