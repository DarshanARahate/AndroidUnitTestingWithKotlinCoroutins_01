package com.test.myapplication.thirdtest

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Engine(var temperature: Int = 15,
             var isTurnedOn : Boolean = false) {

    suspend fun turnOn() : Flow<Int> {
        isTurnedOn = true
        Log.d("COURSE", "Engine has turned on")

        return flow {

            kotlinx.coroutines.delay(1000)
            temperature = 25
            emit(temperature)
            kotlinx.coroutines.delay(1000)
            temperature = 50
            emit(temperature)
            kotlinx.coroutines.delay(1000)
            temperature = 95
            emit(temperature)
        }
    }


}