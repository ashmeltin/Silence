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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                LinearLayout parent = findViewById(R.id.onGoingTimers);
                View ongoingTimersChunk = getLayoutInflater().inflate(R.layout.chunk_ongoing_timers, parent, false);

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
            }
        }
    }
}
