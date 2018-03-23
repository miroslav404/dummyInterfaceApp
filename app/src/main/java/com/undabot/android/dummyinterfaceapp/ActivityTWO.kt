package com.undabot.android.dummyinterfaceapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class ActivityTWO : AppCompatActivity() {

    private lateinit var service: MyService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        service = MyService()
        service.addListener(
                serviceError = { result -> Toast.makeText(this, result, Toast.LENGTH_SHORT).show() },
                serviceConnected = { Toast.makeText(this, "connected", Toast.LENGTH_SHORT).show() },
                serviceDisconnected = { Toast.makeText(this, "disconencted", Toast.LENGTH_SHORT).show() },
                serviceReinitialized = { Toast.makeText(this, "reinitialized", Toast.LENGTH_SHORT).show() },
                serviceActionResult = { result -> Toast.makeText(this, result, Toast.LENGTH_SHORT).show() }
        )
    }

    override fun onResume() {
        super.onResume()
        service.connect()
    }
}
