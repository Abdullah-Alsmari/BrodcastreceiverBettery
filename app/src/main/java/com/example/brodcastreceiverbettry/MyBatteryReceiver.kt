package com.example.brodcastreceiverbettry

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.telecom.TelecomManager
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView

class MyBatteryReceiver(val textView: AppCompatTextView) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
  val batteryLevel = intent?.getIntExtra("level",0)
       textView.text = if (batteryLevel?:0>0)batteryLevel.toString()
       else ""




        }
    }
