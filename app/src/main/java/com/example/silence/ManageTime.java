package com.example.silence;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ManageTime extends AppCompatActivity {
    private SetTime setTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_times);
        setTitle("manage times"); //still dk what this does
        Button back = findViewById(R.id.backButton);
        back.setText("back");
        back.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
        Button addNew = findViewById(R.id.addNewTimer);
        addNew.setText("add a time");
        addNew.setOnClickListener(v -> {
            startActivity(new Intent(this, SetTime.class));
        });
        updateUI();
    }
    public void updateUI() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        LinearLayout parent = findViewById(R.id.onGoingTimers);
        View ongoingTimersChunk = getLayoutInflater().inflate(R.layout.chunk_ongoing_timers, parent, false);

        TextView setName = ongoingTimersChunk.findViewById(R.id.setTimerName);
        String timerName = extras.getString("timerName");
        setName.setText(timerName);

        TextView setRange = ongoingTimersChunk.findViewById(R.id.timeRange);
        String timerRange = extras.getString("timeRange");
        setRange.setText(timerRange);

        TextView setDays = ongoingTimersChunk.findViewById(R.id.days);
        String daysSelected = extras.getString("daysSelected");
        setDays.setText(daysSelected);

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
