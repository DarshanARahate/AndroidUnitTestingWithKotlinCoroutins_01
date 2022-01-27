package com.test.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.myapplication.fourthtest.PlaylistFragment
import com.test.myapplication.thirdtest.Car
import com.test.myapplication.thirdtest.Engine
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
//        val engine = Engine()
//        val car = Car(engine, 20.00)
//        car.turnOn()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, PlaylistFragment.newInstance())
                .commit()
        }
    }
}