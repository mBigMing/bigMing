package com.flowerfat.utiltool.others;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("onReceive", "啥情况？");
        Log.i("onReceive", "the time is up,start the alarm...");
        Toast.makeText(context, "闹钟！", Toast.LENGTH_SHORT).show();
    }
}