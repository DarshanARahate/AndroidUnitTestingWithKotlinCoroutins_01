package com.test.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.myapplication.thirdtest.Car
import com.test.myapplication.thirdtest.Engine

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        val engine = Engine()
        val car = Car(engine, 20.00)
        car.turnOn()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}