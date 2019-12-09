package com.example.silence;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NotificationManager n = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        if(n.isNotificationPolicyAccessGranted()) {
        }else{
            // Ask the user to grant access
            Intent intent = new Intent(android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            startActivityForResult(intent, 0);
        }
        setContentView(R.layout.home_screen);
        Button manageTime = findViewById(R.id.manageTime); //initializes button manageTime
        TextView appName = findViewById(R.id.appName); //initializes textView appName
        TextView quote = findViewById(R.id.quote); //initializes textView quote
        appName.setText("s i l e n c e");
        appName.setTextColor(Color.WHITE);
        appName.setVisibility(View.VISIBLE);
        quote.setText("the quieter you become, the more you will be able to hear");
        quote.setTextColor(Color.WHITE);
        quote.setVisibility(View.VISIBLE);
        manageTime.setText("manage times");
        manageTime.setOnClickListener(v -> {
            startActivity(new Intent(this, ManageTime.class));
        });
    }
}
