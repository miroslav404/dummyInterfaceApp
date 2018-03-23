package com.undabot.android.dummyinterfaceapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

class ActivityONE : AppCompatActivity() {

    private lateinit var service: MyService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        service = MyService()
        service.addListener(
                serviceActionResult = { result -> Toast.makeText(this, result, Toast.LENGTH_SHORT).show() }
        )
    }

    override fun onResume() {
        super.onResume()
        service.connect()
    }

    fun goToSecondActivity(view: View) {
        startActivity(Intent(this, ActivityTWO::class.java))
    }
}
