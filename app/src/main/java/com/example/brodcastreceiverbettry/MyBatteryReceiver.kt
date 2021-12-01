package com.example.brodcastreceiverbettry

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.telecom.TelecomManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView

class MyBatteryReceiver(
    val levelValue: AppCompatTextView,
    val isChargingValue: TextView,
    val batteryHealthValue: TextView
) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val batteryLevel = intent?.getIntExtra("level", 0)
        levelValue.text = if (batteryLevel ?: 0 > 0) batteryLevel.toString()
        else ""

        val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        var BStatus = "No Data"
        if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
            BStatus = "Charging"
        }
        if (status == BatteryManager.BATTERY_STATUS_DISCHARGING) {
            BStatus = "Discharging"
        }
        if (status == BatteryManager.BATTERY_STATUS_FULL) {
            BStatus = "Full"
        }
        if (status == BatteryManager.BATTERY_STATUS_NOT_CHARGING) {
            BStatus = "Not Charging"
        }
        if (status == BatteryManager.BATTERY_STATUS_UNKNOWN) {
            BStatus = "Unknown"
        }

        isChargingValue.text = BStatus


        val BHealth = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, -1)
        var BatteryHealth = "No Data"
        if (BHealth == BatteryManager.BATTERY_HEALTH_COLD) {
            BatteryHealth = "Cold"
        }
        if (BHealth == BatteryManager.BATTERY_HEALTH_DEAD) {
            BatteryHealth = "Dead"
        }
        if (BHealth == BatteryManager.BATTERY_HEALTH_GOOD) {
            BatteryHealth = "Good"
        }
        if (BHealth == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE) {
            BatteryHealth = "Over-Voltage"
        }
        if (BHealth == BatteryManager.BATTERY_HEALTH_OVERHEAT) {
            BatteryHealth = "Overheat"
        }
        if (BHealth == BatteryManager.BATTERY_HEALTH_UNKNOWN) {
            BatteryHealth = "Unknown"
        }
        if (BHealth == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE) {
            BatteryHealth = "Unspecified Failure"
        }

        batteryHealthValue.text = BatteryHealth


    }
}
