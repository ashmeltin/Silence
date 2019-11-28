package com.example.silence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        setTitle("silence"); //idk what this does but it says "change the title in the top bar"
        Button setTime = findViewById(R.id.setTime); //initializes button setTime
        Button manageTime = findViewById(R.id.manageTime); //initializes button manageTime
        TextView appName = findViewById(R.id.appName); //initializes textView appName
        TextView quote = findViewById(R.id.quote); //initializes textView quote
        appName.setText("s i l e n c e");
        appName.setTextColor(Color.WHITE);
        appName.setVisibility(View.VISIBLE);
        quote.setText("the quieter you become, the more you will be able to hear");
        quote.setTextColor(Color.WHITE);
        quote.setVisibility(View.VISIBLE);
        setTime.setText("set a time");
        setTime.setOnClickListener(v -> {
            startActivity(new Intent(this, SetTime.class));
        });
        manageTime.setText("manage times");
        manageTime.setOnClickListener(v -> {
            startActivity(new Intent(this, ManageTime.class));
        });
    }
}
