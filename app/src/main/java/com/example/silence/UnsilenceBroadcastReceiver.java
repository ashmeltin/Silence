package com.example.silence;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;

public class UnsilenceBroadcastReceiver extends BroadcastReceiver {
    AudioManager audioManager;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Alarm", "unsilence");
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        int volume = audioManager.getStreamMaxVolume(AudioManager.STREAM_RING);
        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        audioManager.setStreamVolume(AudioManager.STREAM_RING, volume, AudioManager.FLAG_SHOW_UI + AudioManager.FLAG_PLAY_SOUND);
    }
}
