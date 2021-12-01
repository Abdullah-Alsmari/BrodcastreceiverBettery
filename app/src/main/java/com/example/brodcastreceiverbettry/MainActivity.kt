package com.example.brodcastreceiverbettry

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {
   lateinit var  myBatteryReciver: MyBatteryReceiver
    lateinit var  MyReceiver2 : MyReceiver2

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textViewBL = findViewById<AppCompatTextView>(R.id.textViewBL)
        val textViewBL2 = findViewById<AppCompatTextView>(R.id.healthBat)
        myBatteryReciver = MyBatteryReceiver(textViewBL)
        MyReceiver2 = MyReceiver2(textViewBL2)
        registerReceiver(myBatteryReciver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        registerReceiver(myBatteryReciver, IntentFilter(Intent.ACTION_BATTERY_LOW))
        registerReceiver(myBatteryReciver, IntentFilter(Intent.ACTION_BATTERY_OKAY))


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBatteryReciver)
    }
}