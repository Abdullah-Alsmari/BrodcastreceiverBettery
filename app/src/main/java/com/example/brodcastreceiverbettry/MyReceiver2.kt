package com.example.brodcastreceiverbettry

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import androidx.appcompat.widget.AppCompatTextView

class MyReceiver2 (val textView: AppCompatTextView): BroadcastReceiver () {

    override fun onReceive(context: Context, intent: Intent) {
        val extras = intent.extras
        extras?.let {

        }

    }
}