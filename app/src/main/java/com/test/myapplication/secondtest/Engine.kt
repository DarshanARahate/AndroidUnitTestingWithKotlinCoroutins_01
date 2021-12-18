package com.test.myapplication.secondtest

class Engine(var tempreture: Int = 15,
             var isTurnedOn : Boolean = false) {

    fun turnOn() {
        isTurnedOn = true
        tempreture = 95
    }
}