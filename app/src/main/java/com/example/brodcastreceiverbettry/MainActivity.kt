package com.example.brodcastreceiverbettry

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import android.os.BatteryManager

import android.os.Build.VERSION_CODES

import android.os.Build.VERSION
import android.widget.Toast


class MainActivity : AppCompatActivity() {
   lateinit var  myBatteryReciver: MyBatteryReceiver

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val levelValue = findViewById<AppCompatTextView>(R.id.levelValue)
        val isChargingValue = findViewById<AppCompatTextView>(R.id.isChargingValue)
        val batteryHealthValue = findViewById<AppCompatTextView>(R.id.batteryHealthValue)
        myBatteryReciver = MyBatteryReceiver(levelValue,isChargingValue,batteryHealthValue)
        registerReceiver(myBatteryReciver,IntentFilter(Intent.ACTION_BATTERY_CHANGED))


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBatteryReciver)
    }
}