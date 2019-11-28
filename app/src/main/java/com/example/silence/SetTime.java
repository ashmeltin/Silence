package com.example.silence;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
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
        startTimer = findViewById(R.id.startTime);
        startTimer.setIs24HourView(true);
        endTimer = findViewById(R.id.endTime);
        endTimer.setIs24HourView(true);
        TextView chooseStartTime = findViewById(R.id.chooseStart);
        chooseStartTime.setText("choose a start time");
        chooseStartTime.setVisibility(View.VISIBLE);
        TextView chooseEndTime = findViewById(R.id.chooseEnd);
        chooseEndTime.setText("choose a start time");
        chooseEndTime.setVisibility(View.VISIBLE);
        Button back = findViewById(R.id.backButton);
        back.setText("back");
        back.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
        Button done = findViewById(R.id.doneButton);
        done.setText("done");
        done.setOnClickListener(v -> {
            //inflate the chunk first
            startActivity(new Intent(this, ManageTime.class));
        });
    }
}
