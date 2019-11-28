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
        updateUI();
    }
    public void updateUI() {
        LinearLayout parent = findViewById(R.id.onGoingTimers);
        View ongoingTimersChunk = getLayoutInflater().inflate(R.layout.chunk_ongoing_timers, parent, false);
        Button edit = ongoingTimersChunk.findViewById(R.id.edit);
        edit.setOnClickListener(v -> {
            parent.removeAllViews();
            startActivity(new Intent(this, SetTime.class));
        });
        Button delete = ongoingTimersChunk.findViewById(R.id.delete);
        delete.setOnClickListener(v -> {
            parent.removeAllViews();
        });
        parent.addView(ongoingTimersChunk);
    }
}
